//esta clase organiza el codigo y es un puente de la lógica y la interfaz

package controller;

import datastructures.ArbolBinarioBusqueda;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
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
            // También puedes propagar la excepción si quieres manejarla en la UI
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
