package datastructures;

import model.Vehiculo;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ArbolVisualizer {

    // Genera el archivo .dot
    public static String generarArchivoDot(Arbol<Vehiculo> arbol, String tipoArbol, String rutaDot) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        sb.append("node [shape=ellipse, style=filled, fillcolor=lightblue];\n");

        // Genera el código DOT según el tipo de árbol
        if ("Binario".equals(tipoArbol) || "AVL".equals(tipoArbol)) {
            generarDotRecursivo(arbol, sb);
        }

        sb.append("}\n");

        // Escribe el archivo .dot
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDot))) {
            writer.write(sb.toString());
        }
        return rutaDot;
    }

    // Este método es clave: crea el código DOT desde el árbol
    private static void generarDotRecursivo(Arbol<Vehiculo> arbol, StringBuilder sb) {
        // Aquí necesitas acceso a la raíz del árbol y sus hijos (puedes exponer un método getRaiz() en tu clase de árbol)
        // Para mantener el diseño actual, puedes agregar un método recursivo que recorra la estructura
        if (arbol instanceof datastructures.ArbolBinarioBusqueda<Vehiculo> abb) {
            generarDotNodosABB(abb, sb, abb.getRaiz()); // Tienes que crear getRaiz() con visibilidad de paquete
        } else if (arbol instanceof datastructures.ArbolAVL<Vehiculo> avl) {
            generarDotNodosAVL(avl, sb, avl.getRaiz()); // Igual aquí
        }
    }

    // Recorrido para ABB
    private static void generarDotNodosABB(datastructures.ArbolBinarioBusqueda<Vehiculo> arbol, StringBuilder sb, Object nodo) {
        if (nodo == null) return;
        Vehiculo v = ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).dato;
        String actual = "\"" + v.getPlaca() + "\"";
        if (((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).izquierdo != null) {
            Vehiculo vi = ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).izquierdo).dato;
            sb.append(actual).append(" -> \"").append(vi.getPlaca()).append("\";\n");
            generarDotNodosABB(arbol, sb, ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).izquierdo);
        }
        if (((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).derecho != null) {
            Vehiculo vd = ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).derecho).dato;
            sb.append(actual).append(" -> \"").append(vd.getPlaca()).append("\";\n");
            generarDotNodosABB(arbol, sb, ((datastructures.ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo).derecho);
        }
    }

    // Recorrido para AVL (idéntico al ABB, pero por claridad)
    private static void generarDotNodosAVL(datastructures.ArbolAVL<Vehiculo> arbol, StringBuilder sb, Object nodo) {
        if (nodo == null) return;
        Vehiculo v = ((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).dato;
        String actual = "\"" + v.getPlaca() + "\"";
        if (((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).izquierdo != null) {
            Vehiculo vi = ((datastructures.ArbolAVL<Vehiculo>.Nodo) ((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).izquierdo).dato;
            sb.append(actual).append(" -> \"").append(vi.getPlaca()).append("\";\n");
            generarDotNodosAVL(arbol, sb, ((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).izquierdo);
        }
        if (((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).derecho != null) {
            Vehiculo vd = ((datastructures.ArbolAVL<Vehiculo>.Nodo) ((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).derecho).dato;
            sb.append(actual).append(" -> \"").append(vd.getPlaca()).append("\";\n");
            generarDotNodosAVL(arbol, sb, ((datastructures.ArbolAVL<Vehiculo>.Nodo) nodo).derecho);
        }
    }

    // Llama al comando de Graphviz para crear la imagen
    public static void generarImagenGraphviz(String rutaDot, String rutaImagen) throws IOException, InterruptedException {
        String comando = "dot -Tpng " + rutaDot + " -o " + rutaImagen;
        Process p = Runtime.getRuntime().exec(comando);
        p.waitFor();
    }

    // Devuelve la imagen lista para poner en un JLabel
    public static BufferedImage cargarImagen(String rutaImagen) throws IOException {
        return ImageIO.read(new File(rutaImagen));
    }
}
