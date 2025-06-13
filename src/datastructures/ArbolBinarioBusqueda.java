//esta es una clase genérica que implementa un ABB
package datastructures;

import java.util.ArrayList;
import java.util.List;
import model.Vehiculo;

public class ArbolBinarioBusqueda <T extends Comparable<T>> {
    
    //Nodo del arbol como clase privada
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
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato); //si es menor
        } else if (comparacion > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, dato); //si es mayor
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, dato); //si es igual (se permite duplicado)
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
    
    //método para buscar por coincidencias
    public List<T> buscarPorSubcadena(String subcadena) {
        List<T> coincidencias = new ArrayList<>();
        buscarPorSubcadenaRecursivo(raiz, subcadena.toLowerCase(), coincidencias);
        return coincidencias;
    }

    private void buscarPorSubcadenaRecursivo(Nodo nodo, String subcadena, List<T> lista) {
        if (nodo != null) {
            buscarPorSubcadenaRecursivo(nodo.izquierdo, subcadena, lista);

            // Asumimos que T es Vehiculo, podrías validar o castear si fuera necesario
            if (nodo.dato instanceof Vehiculo v) {
                if (v.getPlaca().toLowerCase().contains(subcadena)) {
                    lista.add(nodo.dato);
                }
            }

            buscarPorSubcadenaRecursivo(nodo.derecho, subcadena, lista);
        }
    }
    
    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private Nodo eliminarRecursivo(Nodo actual, T dato) {
        if (actual == null) {
            return null; // Si no se encuentra el nodo, simplemente devolvemos null
        }

        // Verifica que el dato sea un Vehiculo y compara las placas
        if (dato instanceof Vehiculo && actual.dato instanceof Vehiculo) {
            String placaDato = ((Vehiculo) dato).getPlaca();
            String placaActual = ((Vehiculo) actual.dato).getPlaca();

            int comparacion = placaDato.compareTo(placaActual);

            // Si el dato a eliminar tiene una placa menor, buscamos en el subárbol izquierdo
            if (comparacion < 0) {
                actual.izquierdo = eliminarRecursivo(actual.izquierdo, dato);
            }
            // Si el dato a eliminar tiene una placa mayor, buscamos en el subárbol derecho
            else if (comparacion > 0) {
                actual.derecho = eliminarRecursivo(actual.derecho, dato);
            }
            // Si las placas son iguales, encontramos el nodo a eliminar
            else {
                // Caso 1: Nodo sin hijos (hoja)
                if (actual.izquierdo == null && actual.derecho == null) {
                    return null;
                }
                // Caso 2: Nodo con un solo hijo
                if (actual.izquierdo == null) {
                    return actual.derecho;
                }
                if (actual.derecho == null) {
                    return actual.izquierdo;
                }

                // Caso 3: Nodo con dos hijos
                // Buscar el nodo más pequeño en el subárbol derecho
                actual.dato = obtenerMinimo(actual.derecho);
                // Eliminar el nodo más pequeño en el subárbol derecho
                actual.derecho = eliminarRecursivo(actual.derecho, actual.dato);
            }
        }

        return actual;
    }

    // Método auxiliar para obtener el valor mínimo (más a la izquierda) de un subárbol
    private T obtenerMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.dato;
    }
    
    public List<T> inorden() {
        List<T> resultado = new ArrayList<>();
        inordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void inordenRecursivo(Nodo nodo, List<T> resultado) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo, resultado);
            resultado.add(nodo.dato);
            inordenRecursivo(nodo.derecho, resultado);
        }
    }
    
    public List<T> preorden() {
        List<T> resultado = new ArrayList<>();
        preordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void preordenRecursivo(Nodo nodo, List<T> resultado) {
        if (nodo != null) {
            resultado.add(nodo.dato);
            preordenRecursivo(nodo.izquierdo, resultado);
            preordenRecursivo(nodo.derecho, resultado);
        }
    }
    
    public List<T> postorden() {
        List<T> resultado = new ArrayList<>();
        postordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void postordenRecursivo(Nodo nodo, List<T> resultado) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo, resultado);
            postordenRecursivo(nodo.derecho, resultado);
            resultado.add(nodo.dato);
        }
    }
}