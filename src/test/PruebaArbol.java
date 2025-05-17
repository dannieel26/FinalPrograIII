package test;

import datastructures.ArbolBinarioBusqueda;
import model.Vehiculo;
import utils.LectorVehiculos;

public class PruebaArbol {

    public static void main(String[] args) {

        // Crear el árbol
        ArbolBinarioBusqueda<Vehiculo> arbol = new ArbolBinarioBusqueda<>();

        // Crear vehículos
        Vehiculo v1 = new Vehiculo("ABC-123", "1234567890101", "Juan Perez", "Toyota", "Corolla", 2015, 3, 1);
        Vehiculo v2 = new Vehiculo("XYZ-987", "9876543210010", "Ana Gomez", "Honda", "Civic", 2020, 0, 0);
        Vehiculo v3 = new Vehiculo("DEF-456", "1111222233334", "Luis Lopez", "Ford", "Focus", 2010, 5, 2);
        Vehiculo v4 = new Vehiculo("GHI-789", "5555666677778", "Maria Ruiz", "Mazda", "3", 2018, 2, 1);
        Vehiculo v5 = new Vehiculo("BCD-321", "4444555566667", "Carlos Ortega", "Kia", "Rio", 2012, 1, 0);

        // Insertar vehículos en el árbol
        arbol.insertar(v1);
        arbol.insertar(v2);
        arbol.insertar(v3);
        arbol.insertar(v4);
        arbol.insertar(v5);

        // Buscar un vehículo
        Vehiculo buscado = new Vehiculo("DEF-456", "", "", "", "", 0, 0, 0); // solo importa la placa
        boolean encontrado = arbol.buscar(buscado);
        System.out.println("DEF-456 encontrado?: " + (encontrado ? "Si" : "No"));

        // Mostrar todos los vehículos (inorden)
        System.out.println("\nVehiculos ordenados por placa:");
        arbol.inOrden();
    }
}
