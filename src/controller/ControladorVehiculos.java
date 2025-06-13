package controller;

import datastructures.ArbolBinarioBusqueda;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Vehiculo;
import utils.LectorVehiculos;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ControladorVehiculos {
    private ArbolBinarioBusqueda<Vehiculo> arbol;
    private long tiempoInsercion;
    private long tiempoRecorrido;

    public ControladorVehiculos() {
        arbol = new ArbolBinarioBusqueda<>();
        tiempoRecorrido = 0;
    }

    // Método para cargar vehículos desde un archivo
    public void cargarVehiculosDesdeArchivo(String ruta) {
        List<Vehiculo> vehiculos = LectorVehiculos.cargarVehiculos(ruta);
        for (Vehiculo v : vehiculos) {
            arbol.insertar(v);
        }
    }

    // Método para buscar vehículos por placa
    public List<Vehiculo> buscarVehiculosPorPlaca(String subcadena) {
        List<Vehiculo> coincidencias = arbol.buscarPorSubcadena(subcadena);
        tiempoInsercion = arbol.getTiempoOperacion(); // Obtener el tiempo desde el árbol
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
            writer.newLine();
            writer.write(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para modificar un vehículo
    public String modificarVehiculo(DefaultTableModel modelo, int fila, String departamento) {
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
        return modificarVehiculoEnArchivo(rutaArchivo, placa, vehiculoModificado);
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
        Vehiculo vehiculoAEliminar = new Vehiculo(placa, "", "", "", "", 0, 0, 0); // Se pasa una instancia con la placa

        // Llamar al método de eliminar del árbol
        arbol.eliminar(vehiculoAEliminar);

        // Obtener el tiempo de la operación de eliminación
        tiempoInsercion = arbol.getTiempoOperacion(); // Tiempo de la operación

        return "Vehículo eliminado correctamente.";
    }

    public String eliminarVehiculoEnArchivo(String rutaArchivo, String placa) {
        try {
            List<String> lineas = new ArrayList<>();
            boolean encontrado = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    if (linea.startsWith(placa + ",")) {
                        encontrado = true;
                    } else {
                        lineas.add(linea);
                    }
                }
            }

            if (!encontrado) {
                return "No se encontró el vehículo a eliminar.";
            }

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
        arbol = new ArbolBinarioBusqueda<>(); // Reinicia el árbol
    }
}
