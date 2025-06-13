//implementación de un árbol binario de búsqueda

package datastructures;

import java.util.ArrayList;
import java.util.List;
import model.Vehiculo;

public class ArbolBinarioBusqueda<T extends Comparable<T>> implements Arbol<T> {
    private class Nodo { //clase interna Nodo que representa un elemento del arbol
        T dato;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(T dato) { //constructor del nodo
            this.dato = dato;
        }
    }

    private Nodo raiz; //raíz del árbol
    private long tiempoOperacion; //tiempo de la última operacion

    @Override
    public void insertar(T dato) { //inserta un dato en el árbol
        long inicio = System.nanoTime(); //marca el inicio de la operación
        raiz = insertarRecursivo(raiz, dato); //llama al método recursivo para insertar
        long fin = System.nanoTime(); //marca el final de la operacion
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
    }

    private Nodo insertarRecursivo(Nodo nodo, T dato) { // Método recursivo para insertar
        if (nodo == null) { // Si el nodo es null, crea uno nuevo
            return new Nodo(dato);
        }

        int comparacion = dato.compareTo(nodo.dato); // Compara el dato con el nodo actual

        if (comparacion < 0) { // Si el dato es menor, va al subárbol izquierdo
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else if (comparacion > 0) { // Si el dato es mayor, va al subárbol derecho
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        } else { // Si el dato es igual, también lo insertamos en el subárbol derecho (o izquierdo, según preferencia)
            nodo.derecho = insertarRecursivo(nodo.derecho, dato); // Esto permite duplicados en el subárbol derecho
        }

        return nodo; // Devuelve el nodo (sin cambios si ya está en el árbol)
    }

    @Override
    public List<T> buscarPorSubcadena(String subcadena) { //busca elementos por subcadena
        long inicio = System.nanoTime(); //marca el inicio de la operación
        List<T> coincidencias = new ArrayList<>(); //lista de coincidencias
        buscarPorSubcadenaRecursivo(raiz, subcadena.toLowerCase(), coincidencias); //llama al método recursivo
        long fin = System.nanoTime(); //marca el final de la operación
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
        return coincidencias; //devuelve las coincidencias encontradas
    }

    private void buscarPorSubcadenaRecursivo(Nodo nodo, String subcadena, List<T> lista) { //método recursivo para buscar subcadena
        if (nodo != null) { //si el nodo no es null
            buscarPorSubcadenaRecursivo(nodo.izquierdo, subcadena, lista); //busca en el subárbol izquierdo

            // Verificar si el dato es de tipo Vehiculo
            if (nodo.dato instanceof Vehiculo v) { //si el dato es un Vehiculo
                if (v.getPlaca().toLowerCase().contains(subcadena)) { //si la placa contiene la subcadena
                    lista.add(nodo.dato); //añade el dato a la lista de coincidencias
                }
            }

            buscarPorSubcadenaRecursivo(nodo.derecho, subcadena, lista); //busca en el subárbol derecho
        }
    }

    @Override
    public void eliminar(T dato) { // Elimina un dato del árbol
        long inicio = System.nanoTime(); // Marca el inicio de la operación
        raiz = eliminarRecursivo(raiz, dato); // Llama al método recursivo para eliminar
        long fin = System.nanoTime(); // Marca el final de la operación
        tiempoOperacion = fin - inicio; // Calcula el tiempo de operación
    }

    private Nodo eliminarRecursivo(Nodo nodo, T dato) { // Método recursivo para eliminar un dato
        if (nodo == null) { // Si el nodo es null, no hay nada que eliminar
            return null;
        }

        // Compara las placas del vehículo (dato y nodo.dato)
        int comparacion = ((Vehiculo) dato).getPlaca().compareTo(((Vehiculo) nodo.dato).getPlaca());

        if (comparacion < 0) { // Si el dato es menor, busca en el subárbol izquierdo
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        } else if (comparacion > 0) { // Si el dato es mayor, busca en el subárbol derecho
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        } else { // Si el dato coincide con el nodo
            if (nodo.izquierdo == null && nodo.derecho == null) { // Si no tiene hijos
                return null; // Elimina el nodo
            }
            if (nodo.izquierdo == null) { // Si solo tiene hijo derecho
                return nodo.derecho;
            }
            if (nodo.derecho == null) { // Si solo tiene hijo izquierdo
                return nodo.izquierdo;
            }

            nodo.dato = obtenerMinimo(nodo.derecho); // Si tiene dos hijos, sustituye por el mínimo del subárbol derecho
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.dato); // Elimina el mínimo encontrado
        }
        return nodo; // Devuelve el nodo modificado
    }

    private T obtenerMinimo(Nodo nodo) { //obtiene el valor mínimo de un subárbol
        while (nodo.izquierdo != null) { //mientras tenga hijo izquierdo
            nodo = nodo.izquierdo; //baja al subárbol izquierdo
        }
        return nodo.dato; //devuelve el dato mínimo
    }

    @Override
    public List<T> inorden() { //realiza el recorrido inorden
        long inicio = System.nanoTime(); //marca el inicio de la operación
        List<T> resultado = new ArrayList<>(); //lista para almacenar el resultado
        inordenRecursivo(raiz, resultado); //llama al método recursivo
        long fin = System.nanoTime(); //marca el final de la operación
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
        return resultado; //devuelve el resultado del recorrido
    }

    private void inordenRecursivo(Nodo nodo, List<T> resultado) { //método recursivo para recorrido inorden
        if (nodo != null) { //si el nodo no es null
            inordenRecursivo(nodo.izquierdo, resultado); //recorre el subárbol izquierdo
            resultado.add(nodo.dato); //añade el dato al resultado
            inordenRecursivo(nodo.derecho, resultado); //recorre el subárbol derecho
        }
    }

    @Override
    public List<T> preorden() { //realiza el recorrido preorden
        long inicio = System.nanoTime(); //marca el inicio de la operación
        List<T> resultado = new ArrayList<>(); //lista para almacenar el resultado
        preordenRecursivo(raiz, resultado); //llama al método recursivo
        long fin = System.nanoTime(); //marca el final de la operación
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
        return resultado; //devuelve el resultado del recorrido
    }

    private void preordenRecursivo(Nodo nodo, List<T> resultado) { //método recursivo para recorrido preorden
        if (nodo != null) { //si el nodo no es null
            resultado.add(nodo.dato); //añade el dato al resultado
            preordenRecursivo(nodo.izquierdo, resultado); //recorre el subárbol izquierdo
            preordenRecursivo(nodo.derecho, resultado); //recorre el subárbol derecho
        }
    }

    @Override
    public List<T> postorden() { //realiza el recorrido postorden
        long inicio = System.nanoTime(); //marca el inicio de la operación
        List<T> resultado = new ArrayList<>(); //lista para almacenar el resultado
        postordenRecursivo(raiz, resultado); //llama al método recursivo
        long fin = System.nanoTime(); //marca el final de la operación
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
        return resultado; //devuelve el resultado del recorrido
    }

    private void postordenRecursivo(Nodo nodo, List<T> resultado) { //método recursivo para recorrido postorden
        if (nodo != null) { //si el nodo no es null
            postordenRecursivo(nodo.izquierdo, resultado); //recorre el subárbol izquierdo
            postordenRecursivo(nodo.derecho, resultado); //recorre el subárbol derecho
            resultado.add(nodo.dato); //añade el dato al resultado
        }
    }

    @Override
    public long getTiempoOperacion() { //devuelve el tiempo de la última operación
        return tiempoOperacion;
    }
}
