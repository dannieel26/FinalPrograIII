//esta clase organiza el codigo y es un puente de la lógica y la interfaz

package controller;

import datastructures.ArbolBinarioBusqueda;
import java.util.List;
import model.Vehiculo;
import utils.LectorVehiculos;

public class ControladorVehiculos {
    private ArbolBinarioBusqueda arbol;
    
    public ControladorVehiculos() {
        arbol = new ArbolBinarioBusqueda();
    }
    
    public void cargarVehiculosDesdeArchivo(String ruta) {
        //Usa la clase LectorVehiculos para leer los vehiculos desde el archivo
        List<Vehiculo> vehiculos = LectorVehiculos.cargarVehiculos(ruta);
        for (Vehiculo v : vehiculos) {
            arbol.insertar(v); //Inserta cada vehiculo en el árbol binario
        }
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
    }
}
