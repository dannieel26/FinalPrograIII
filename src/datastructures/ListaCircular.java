package datastructures;

import java.util.ArrayList;
import java.util.List;

public class ListaCircular<T> {
    private Nodo<T> ultimo;
    private int tamaño;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    public ListaCircular() {
        ultimo = null;
        tamaño = 0;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (ultimo == null) {
            nuevo.siguiente = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamaño++;
    }

    public List<T> obtenerLista() {
        List<T> lista = new ArrayList<>();
        if (ultimo == null) return lista;

        Nodo<T> actual = ultimo.siguiente;
        do {
            lista.add(actual.dato);
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);

        return lista;
    }

    public int getTamaño() {
        return tamaño;
    }
}
