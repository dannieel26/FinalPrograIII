//esta clase organiza el codigo y es un puente de la lógica y la interfaz

package controller;

import datastructures.ArbolBinarioBusqueda;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Vehiculo;
import utils.LectorVehiculos;

public class ControladorVehiculos {
    private ArbolBinarioBusqueda arbol;
    private long tiempoInsercion;
    
    public ControladorVehiculos() {
        arbol = new ArbolBinarioBusqueda();
    }
    
    public void cargarVehiculosDesdeArchivo(String ruta) {
        //Usa la clase LectorVehiculos para leer los vehiculos desde el archivo
        List<Vehiculo> vehiculos = LectorVehiculos.cargarVehiculos(ruta);
        
        long inicio = System.nanoTime(); // Inicio (mediciond e tiempo)
        for (Vehiculo v : vehiculos) {
            arbol.insertar(v); //Inserta cada vehiculo en el árbol binario
        }
        long fin = System.nanoTime(); //Fin
        tiempoInsercion += (fin - inicio); // acumulativo si se cargan varios archivos
    }
    
    //método para insertar un vehículo y escribirlo en el archivo de la ruta recibida
    public void insertarVehiculoEnArchivo(String rutaArchivo, Vehiculo vehiculo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            // Formato: Placa,DPI,Nombre,Marca,Modelo,Año,Multas,Traspasos
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

            writer.newLine(); // Asegura que se escriba en una nueva línea
            writer.write(linea);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String procesarInsercionVehiculo(DefaultTableModel modelo, int fila, String departamento) {
        // Validar si hay datos en la tabla
        if (modelo.getRowCount() == 0 || modelo.getValueAt(fila, 0) == null) {
            return "Debe ingresar los datos en la tabla antes de insertar.";
        }

        // Validar que todos los campos estén llenos
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            Object valor = modelo.getValueAt(fila, i);
            if (valor == null || valor.toString().trim().isEmpty()) {
                return "Debe completar todos los campos antes de insertar.";
            }
        }

        try {
            //Extraer datos de cada columna de la fila indicada, con trim para eliminar espacios
            String placa = modelo.getValueAt(fila, 0).toString().trim();
            String dpi = modelo.getValueAt(fila, 1).toString().trim();
            String nombre = modelo.getValueAt(fila, 2).toString().trim();
            String marca = modelo.getValueAt(fila, 3).toString().trim();
            String modeloVehiculo = modelo.getValueAt(fila, 4).toString().trim();
            
            //Convertir los valores numéricos de las columnas a enteros (puede lanzar NumberFormatException)
            int anio = Integer.parseInt(modelo.getValueAt(fila, 5).toString().trim());
            int multas = Integer.parseInt(modelo.getValueAt(fila, 6).toString().trim());
            int traspasos = Integer.parseInt(modelo.getValueAt(fila, 7).toString().trim());

            //validar que se haya seleccionado un departamento válido para insertar
            if (departamento == null || departamento.trim().isEmpty()) {
                return "Seleccione un departamento válido para insertar.";
            }

            //Construir la ruta del archivo donde se guardará el vehículo
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            
            //crear un nuevo objeto Vehiculo con los datos extraídos
            Vehiculo nuevoVehiculo = new Vehiculo(placa, dpi, nombre, marca, modeloVehiculo, anio, multas, traspasos);
            
            //Llamar al método que inserta el vehículo en el archivo correspondiente
            insertarVehiculoEnArchivo(ruta, nuevoVehiculo);

            return "Vehículo insertado correctamente en el archivo.";

        } catch (NumberFormatException e) {
            //Capturar y manejar error si los campos numéricos no contienen valores válidos
            return "Error: 'Año', 'Multas' y 'Traspasos' deben ser números.";
        } catch (Exception e) {
            //Captura cualquier otro error inesperado
            return "Error al insertar: verifique los datos ingresados.";
        }
    }

    //metodo que permite buscar desde la interfaz sin acceder directamente al árbol
    public List<Vehiculo> buscarVehiculosPorPlaca(String subcadena) {
        return arbol.buscarPorSubcadena(subcadena);
    }
    
    public List<Vehiculo> obtenerVehiculosInorden() {
        return arbol.inorden(); //llama directamente al árbol para obtener la lista de vehículos en el orden solicitado
    }

    public List<Vehiculo> obtenerVehiculosPreorden() {
        return arbol.preorden();
    }

    public List<Vehiculo> obtenerVehiculosPostorden() {
        return arbol.postorden();
    }

    //reinicia el árbol, eliminando todos los datos actuales
    public void limpiarDatos() {
        arbol = new ArbolBinarioBusqueda();
        tiempoInsercion = 0;
    }
    
    public long getTiempoInsercion(){
        return tiempoInsercion;
    }
}
