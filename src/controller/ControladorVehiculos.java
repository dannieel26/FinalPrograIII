package controller;

import datastructures.Arbol;
import datastructures.ArbolBinarioBusqueda;
import datastructures.ArbolAVL;
import datastructures.ListaDoble;
import java.awt.image.BufferedImage;
import model.Vehiculo;
import utils.LectorVehiculos;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Multa;
import datastructures.ArbolVisualizer;
import utils.LectorMultas;

public class ControladorVehiculos {
    private Arbol<Vehiculo> arbol; // Usamos el tipo genérico Arbol para manejar ambos tipos de árboles
    private long tiempoInsercion;
    private long tiempoRecorrido;
    private String tipoArbolConfigurado;  // Nueva variable para controlar el tipo de árbol configurado

    public ControladorVehiculos() {
        arbol = null; // No inicializamos el árbol aún
        tipoArbolConfigurado = null;  // Inicializamos con el tipo de árbol como null
        tiempoRecorrido = 0;
    }
    
    public String getTipoArbolConfigurado() {
        return tipoArbolConfigurado;
    }

    // Cambia el tipo de árbol solo si no está configurado previamente
    public void configurarTipoArbol(String tipoArbol) {
        if (!tipoArbol.equals(tipoArbolConfigurado)) {
            if ("AVL".equals(tipoArbol)) {
                arbol = new ArbolAVL<>(); // Configurar como árbol AVL
                tipoArbolConfigurado = "AVL";
            } else if ("Binario".equals(tipoArbol)) {
                arbol = new ArbolBinarioBusqueda<>(); // Configurar como árbol binario
                tipoArbolConfigurado = "Binario";
            }
        }
    }

    // Método para cargar vehículos desde un archivo
    public void cargarVehiculosDesdeArchivo(String ruta) {
        List<Vehiculo> vehiculos = LectorVehiculos.cargarVehiculos(ruta);
        for (Vehiculo v : vehiculos) {
            arbol.insertar(v); // Inserta los vehículos en el árbol
        }
    }

    // Método para buscar vehículos por placa
    public List<Vehiculo> buscarVehiculosPorPlaca(String subcadena) {
        List<Vehiculo> coincidencias = arbol.buscarPorSubcadena(subcadena); // Busca por subcadena en el árbol
        tiempoInsercion = arbol.getTiempoOperacion(); // Mide el tiempo de la operación
        return coincidencias;
    }

    // Método para insertar un vehículo en el archivo y en el árbol
    public String procesarInsercionVehiculo(DefaultTableModel modelo, int fila, String departamento) {
        if (modelo.getRowCount() == 0 || modelo.getValueAt(fila, 0) == null) {
            return "Debe ingresar los datos en la tabla antes de insertar.";
        }

        // Extraer datos de la tabla
        String placa = modelo.getValueAt(fila, 0).toString().trim();
        String dpi = modelo.getValueAt(fila, 1).toString().trim();
        String nombre = modelo.getValueAt(fila, 2).toString().trim();
        String marca = modelo.getValueAt(fila, 3).toString().trim();
        String modeloVehiculo = modelo.getValueAt(fila, 4).toString().trim();
        int anio = Integer.parseInt(modelo.getValueAt(fila, 5).toString().trim());
        int multas = Integer.parseInt(modelo.getValueAt(fila, 6).toString().trim());
        int traspasos = Integer.parseInt(modelo.getValueAt(fila, 7).toString().trim());

        // Crear el objeto Vehiculo
        Vehiculo nuevoVehiculo = new Vehiculo(placa, dpi, nombre, marca, modeloVehiculo, anio, multas, traspasos);

        // Llamar al método de inserción en el árbol
        arbol.insertar(nuevoVehiculo);

        // Medir el tiempo de inserción
        tiempoInsercion = arbol.getTiempoOperacion();

        // Llamar al método que inserta el vehículo en el archivo
        insertarVehiculoEnArchivo(departamento, nuevoVehiculo);

        return "Vehículo insertado correctamente en el archivo.";
    }

    // Método que inserta un vehículo en el archivo de texto
    private void insertarVehiculoEnArchivo(String departamento, Vehiculo vehiculo) {
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            // Solo agrega un salto de línea si el archivo no está vacío
            File archivo = new File(rutaArchivo);
            if (archivo.length() > 0) {
                writer.write(System.lineSeparator());  // Se asegura de que los vehículos estén separados por una nueva línea
            }

            // Crear la línea con los datos del vehículo
            String linea = String.format("%s,%s,%s,%s,%s,%d,%d,%d",
                vehiculo.getPlaca(),
                vehiculo.getDpi(),
                vehiculo.getNombre(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnio(),
                vehiculo.getCantidadMultas(),
            vehiculo.getCantidadTraspasos()
        );

        // Escribir la línea en el archivo
        writer.write(linea);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public String modificarVehiculo(DefaultTableModel modelo, int fila, String departamento) {
        // Marca el inicio de la operación
        long inicioModificacion = System.nanoTime();

        String placa = modelo.getValueAt(fila, 0).toString().trim();
        String dpi = modelo.getValueAt(fila, 1).toString().trim();
        String nombre = modelo.getValueAt(fila, 2).toString().trim();
        String marca = modelo.getValueAt(fila, 3).toString().trim();
        String modeloVehiculo = modelo.getValueAt(fila, 4).toString().trim();
        int anio = Integer.parseInt(modelo.getValueAt(fila, 5).toString().trim());
        int multas = Integer.parseInt(modelo.getValueAt(fila, 6).toString().trim());
        int traspasos = Integer.parseInt(modelo.getValueAt(fila, 7).toString().trim());

        // Crear el objeto Vehiculo modificado
        Vehiculo vehiculoModificado = new Vehiculo(placa, dpi, nombre, marca, modeloVehiculo, anio, multas, traspasos);

        // Verificar si el vehículo existe en el archivo
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
        if (!vehiculoExisteEnArchivo(rutaArchivo, placa)) {
            return "No se encontró el vehículo en ese departamento.";
        }

        // Eliminar el vehículo viejo del árbol y agregar el nuevo
        arbol.eliminar(new Vehiculo(placa, "", "", "", "", 0, 0, 0)); // Eliminar solo por placa
        arbol.insertar(vehiculoModificado); // Insertar el vehículo modificado

        // Modificar el archivo
        String mensajeArchivo = modificarVehiculoEnArchivo(rutaArchivo, placa, vehiculoModificado);

        // Marca el fin de la operación
        long finModificacion = System.nanoTime();

        // Calcula el tiempo de modificación
        tiempoInsercion = finModificacion - inicioModificacion;

        // Retorna el mensaje de modificación
        return mensajeArchivo;
    }

    private boolean vehiculoExisteEnArchivo(String rutaArchivo, String placa) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(placa + ",")) {
                    return true; // El vehículo existe
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No se encontró el vehículo
    }

    // Método para modificar el vehículo en el archivo
    private String modificarVehiculoEnArchivo(String rutaArchivo, String placa, Vehiculo vehiculoModificado) {
        List<String> lineas = new ArrayList<>();
        String lineaModificada = String.format("%s,%s,%s,%s,%s,%d,%d,%d",
                vehiculoModificado.getPlaca(),
                vehiculoModificado.getDpi(),
                vehiculoModificado.getNombre(),
                vehiculoModificado.getMarca(),
                vehiculoModificado.getModelo(),
                vehiculoModificado.getAnio(),
                vehiculoModificado.getCantidadMultas(),
                vehiculoModificado.getCantidadTraspasos()
        );

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(placa + ",")) {
                    lineas.add(lineaModificada); // Reemplazamos la línea
                } else {
                    lineas.add(linea); // Mantener las otras líneas
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al modificar el archivo.";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String l : lineas) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al escribir en el archivo.";
        }

        return "Vehículo modificado correctamente.";
    }

    // Método para eliminar un vehículo del árbol
    public String eliminarVehiculo(String placa) {
        // Crear un objeto Vehiculo con la placa que queremos eliminar
        Vehiculo vehiculoAEliminar = new Vehiculo(placa, "", "", "", "", 0, 0, 0);

        // Llamar al método de eliminar del árbol
        arbol.eliminar(vehiculoAEliminar);

        // Obtener el tiempo de la operación de eliminación
        tiempoInsercion = arbol.getTiempoOperacion(); // Tiempo de la operación

        return "Vehículo eliminado correctamente.";
    }
    
    // Método para eliminar un vehículo del archivo
    public String eliminarVehiculoEnArchivo(String rutaArchivo, String placa) {
        try {
            List<String> lineas = new ArrayList<>();
            boolean encontrado = false;

            // Lee las líneas del archivo y elimina la línea con la placa
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    if (linea.startsWith(placa + ",")) {
                        encontrado = true; // Encuentra el vehículo
                    } else {
                        lineas.add(linea); // Mantiene las líneas que no son la del vehículo a eliminar
                    }
                }
            }

            if (!encontrado) {
                return "No se encontró el vehículo a eliminar."; // Si no se encuentra el vehículo
            }

            // Reescribe el archivo sin la línea del vehículo eliminado
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, false))) {
                for (String l : lineas) {
                    writer.write(l);
                    writer.newLine();
                }
            }

            return "Vehículo eliminado correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al eliminar el vehículo del archivo.";
        }
    }

    // Método para obtener los vehículos en orden
    public List<Vehiculo> obtenerVehiculosInorden() {
        List<Vehiculo> lista = arbol.inorden();
        tiempoRecorrido = arbol.getTiempoOperacion(); // Tiempo de recorrido
        return lista;
    }

    // Método para obtener los vehículos en preorden
    public List<Vehiculo> obtenerVehiculosPreorden() {
        List<Vehiculo> lista = arbol.preorden();
        tiempoRecorrido = arbol.getTiempoOperacion(); // Tiempo de recorrido
        return lista;
    }

    // Método para obtener los vehículos en postorden
    public List<Vehiculo> obtenerVehiculosPostorden() {
        List<Vehiculo> lista = arbol.postorden();
        tiempoRecorrido = arbol.getTiempoOperacion(); // Tiempo de recorrido
        return lista;
    }

    // Obtener el tiempo de inserción (tiempo de la última operación)
    public long getTiempoInsercion() {
        return tiempoInsercion;
    }

    // Obtener el tiempo de recorrido (tiempo de la última operación)
    public long getTiempoRecorrido() {
        return tiempoRecorrido;
    }
    
    public void limpiarArbol() {
        if (arbol != null) {
            arbol.vaciar();
        }
    }
    
    // Método para buscar multas de un vehículo por placa
    public ListaDoble<Multa> buscarMultasPorPlaca(String placa) {
        ListaDoble<Multa> listaMultas = new ListaDoble<>();
        
        // Cargar las multas desde el archivo correspondiente (suponemos que tienes un archivo por cada vehículo)
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + placa + "_multas.txt"; // Ruta del archivo de multas
        listaMultas = LectorMultas.cargarMultas(rutaArchivo);  // Usamos el lector para cargar las multas
        
        return listaMultas;
    }
    
    public BufferedImage generarVisualizacionArbol(String tipoArbol) {
        try {
            String rutaDot = "arbol.dot";
            String rutaImagen = "arbol.png";
            ArbolVisualizer.generarArchivoDot(arbol, tipoArbol, rutaDot);
            ArbolVisualizer.generarImagenGraphviz(rutaDot, rutaImagen);
            return ArbolVisualizer.cargarImagen(rutaImagen);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getAlturaArbolActual() {
    // Si tu árbol tiene el método getAltura()
    // (tanto AVL como ABB deberían tenerlo)
    if (arbol instanceof ArbolBinarioBusqueda) {
        return ((ArbolBinarioBusqueda<Vehiculo>) arbol).getAltura();
    } else if (arbol instanceof ArbolAVL) {
        return ((ArbolAVL<Vehiculo>) arbol).getAltura();
    }
    return 0;
}

}
