package datastructures;

public class ArbolBinarioBusqueda <T extends Comparable<T>> {
    
    private class Nodo{
        T dato;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(T dato) {
            this.dato = dato;
        }
    }
    
    private Nodo raiz;
    
    // Método para insertar
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo actual, T dato) {
        if (actual == null) {
            return new Nodo(dato); // Se crea un nuevo nodo si llegamos a una hoja vacía
        }

        int comparacion = dato.compareTo(actual.dato);

        if (comparacion < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato);
        } else if (comparacion > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, dato);
        } else {
            // Si es igual ignoramos.
        }

        return actual;
    }
    
    // Método para buscar
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(Nodo actual, T dato) {
        if (actual == null) {
            return false;
        }

        int comparacion = dato.compareTo(actual.dato);

        if (comparacion == 0) {
            return true;
        } else if (comparacion < 0) {
            return buscarRecursivo(actual.izquierdo, dato);
        } else {
            return buscarRecursivo(actual.derecho, dato);
        }
    }

    // Método para recorrido In-Orden (opcional para visualizar datos)
    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            inOrdenRecursivo(actual.izquierdo);
            System.out.println(actual.dato.toString());
            inOrdenRecursivo(actual.derecho);
        }
    }
}
