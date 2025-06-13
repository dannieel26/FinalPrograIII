 //interfaz para definir las operaciones de un árbol

package datastructures;

import java.util.List;

public interface Arbol<T extends Comparable<T>> {
    void insertar(T dato); //inserta un dato en el arbol
    List<T> buscarPorSubcadena(String subcadena); //busca nodos que contengan la subcadena
    void eliminar(T dato); //elimina un nodo del árbol
    List<T> inorden(); //recorrido en orden del arbol
    List<T> preorden(); //recorrido preorden del árbol
    List<T> postorden(); //recorrido postorden del árbol
    long getTiempoOperacion(); //devuelve el tiempo de operación realizado
}
