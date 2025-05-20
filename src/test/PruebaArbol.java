package test;

import datastructures.ArbolBinarioBusqueda;
import java.util.List;
import model.Vehiculo;
import utils.LectorVehiculos;

public class PruebaArbol {

    public static void main(String[] args) {

        ArbolBinarioBusqueda<Vehiculo> arbol = new ArbolBinarioBusqueda<>();
        
        // Ruta absoluta o relativa al archivo
        String rutaArchivo = "SIRVE_Datos_Vehiculos DataSet/Suchitepequez/Suchitepequez_vehiculos.txt";
        
        // Leer vehículos
        List<Vehiculo> lista = LectorVehiculos.leerVehiculosDesdeArchivo(rutaArchivo);
        
        for (Vehiculo v : lista) {
            arbol.insertar(v);
        }

        //llamar al metodo para mostrar la lista de vehiculos del arbol en in Orden
        arbol.mostrarInOrdenEnVentana();
    }
}
