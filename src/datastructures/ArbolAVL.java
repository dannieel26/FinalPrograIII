//implementación de un árbol AVL

package datastructures;

import java.util.ArrayList;
import java.util.List;
import model.Vehiculo;

public class ArbolAVL<T extends Comparable<T>> implements Arbol<T> {
    private class Nodo { //clase interna Nodo que representa un nodo del arbol
        T dato;
        Nodo izquierdo, derecho;
        int altura; //altura del nodo en el árbol

        Nodo(T dato) { //constructor del nodo
            this.dato = dato;
            this.altura = 1;  // Inicializamos la altura como 1
        }
    }

    private Nodo raiz; //raíz del árbol
    private long tiempoOperacion; //tiempo de la última operación

    @Override
    public void insertar(T dato) { //inserta un dato en el árbol
        long inicio = System.nanoTime(); //marca el inicio de la operación
        raiz = insertarRecursivo(raiz, dato); //llama al método recursivo para insertar
        long fin = System.nanoTime(); //marca el final de la operacion
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
    }

    private Nodo insertarRecursivo(Nodo nodo, T dato) { //método recursivo para insertar un dato
        if (nodo == null) { //si el nodo es null, crea uno nuevo
            return new Nodo(dato);
        }

        int comparacion = dato.compareTo(nodo.dato); //compara el dato con el nodo actual
        if (comparacion < 0) { //si el dato es menor, va al subárbol izquierdo
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else if (comparacion > 0) { //si el dato es mayor, va al subárbol derecho
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho)); //actualiza la altura del nodo

        return balancear(nodo); //balancea el árbol después de la inserción
    }

    private Nodo balancear(Nodo nodo) { //balancea el árbol para mantener las propiedades del AVL
        int balance = obtenerBalance(nodo); //calcula el balance del nodo

        // Rotación simple a la derecha
        if (balance > 1 && nodo.dato.compareTo(nodo.izquierdo.dato) < 0) {
            return rotarDerecha(nodo);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && nodo.dato.compareTo(nodo.derecho.dato) > 0) {
            return rotarIzquierda(nodo);
        }

        // Rotación doble: izquierda luego derecha
        if (balance > 1 && nodo.dato.compareTo(nodo.izquierdo.dato) > 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Rotación doble: derecha luego izquierda
        if (balance < -1 && nodo.dato.compareTo(nodo.derecho.dato) < 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo; //si el árbol está balanceado, retorna el nodo sin cambios
    }

    private Nodo rotarIzquierda(Nodo nodo) { //realiza una rotación hacia la izquierda
        Nodo nuevoRaiz = nodo.derecho;
        Nodo aux = nuevoRaiz.izquierdo;

        nuevoRaiz.izquierdo = nodo;
        nodo.derecho = aux;

        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1; //actualiza la altura del nodo original
        nuevoRaiz.altura = Math.max(altura(nuevoRaiz.izquierdo), altura(nuevoRaiz.derecho)) + 1; //actualiza la altura de la nueva raíz

        return nuevoRaiz; //devuelve la nueva raíz
    }

    private Nodo rotarDerecha(Nodo nodo) { //realiza una rotación hacia la derecha
        Nodo nuevoRaiz = nodo.izquierdo;
        Nodo aux = nuevoRaiz.derecho;

        nuevoRaiz.derecho = nodo;
        nodo.izquierdo = aux;

        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1; //actualiza la altura del nodo original
        nuevoRaiz.altura = Math.max(altura(nuevoRaiz.izquierdo), altura(nuevoRaiz.derecho)) + 1; //actualiza la altura de la nueva raíz

        return nuevoRaiz; //devuelve la nueva raíz
    }

    private int altura(Nodo nodo) { //devuelve la altura de un nodo
        return nodo == null ? 0 : nodo.altura;
    }

    private int obtenerBalance(Nodo nodo) { //calcula el balance de un nodo
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    @Override
    public List<T> buscarPorSubcadena(String subcadena) { //busca elementos que contengan una subcadena
        long inicio = System.nanoTime(); //marca el inicio de la operación
        List<T> coincidencias = new ArrayList<>(); //lista para almacenar las coincidencias
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
    public void eliminar(T dato) { //elimina un dato del árbol
        long inicio = System.nanoTime(); //marca el inicio de la operación
        raiz = eliminarRecursivo(raiz, dato); //llama al método recursivo para eliminar
        long fin = System.nanoTime(); //marca el final de la operación
        tiempoOperacion = fin - inicio; //calcula el tiempo de operación
    }

    private Nodo eliminarRecursivo(Nodo nodo, T dato) { //método recursivo para eliminar un dato
        if (nodo == null) { //si el nodo es null, no hay nada que eliminar
            return null;
        }

        int comparacion = dato.compareTo(nodo.dato); //compara el dato con el nodo actual

        if (comparacion < 0) { //si el dato es menor, busca en el subárbol izquierdo
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        } else if (comparacion > 0) { //si el dato es mayor, busca en el subárbol derecho
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        } else { //si el dato coincide con el nodo
            if (nodo.izquierdo == null && nodo.derecho == null) { //si no tiene hijos
                return null; //elimina el nodo
            }
            if (nodo.izquierdo == null) { //si solo tiene hijo derecho
                return nodo.derecho;
            }
            if (nodo.derecho == null) { //si solo tiene hijo izquierdo
                return nodo.izquierdo;
            }

            nodo.dato = obtenerMinimo(nodo.derecho); //si tiene dos hijos, sustituye por el mínimo del subárbol derecho
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.dato); //elimina el mínimo encontrado
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho)); //actualiza la altura del nodo
        return balancear(nodo); //balancea el árbol después de la eliminación
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
        tiempoOperacion = fin - inicio; //calcula el tiempo de operacion
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
