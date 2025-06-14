package datastructures;


import java.util.ArrayList;
import java.util.List;

public class ListaDoble<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        public Nodo(T dato) {
            this.dato = dato;
        }
    }

    public ListaDoble() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public void eliminarPrimero() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            tamaño--;
        }
    }

    public T obtenerPrimeroDato() {
        return cabeza != null ? cabeza.dato : null;
    }

    public Nodo<T> obtenerPrimerNodo() {
        return cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }

    public List<T> obtenerLista() {
        List<T> resultado = new ArrayList<>();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            resultado.add(actual.dato);
            actual = actual.siguiente;
        }
        return resultado;
    }
}
