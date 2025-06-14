package datastructures;

import model.Vehiculo;
import java.awt.Desktop;
import java.io.*;

public class ArbolVisualizer {

    public static String generarArchivoDot(Arbol<Vehiculo> arbol, String tipoArbol, String rutaDot) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        sb.append("node [shape=ellipse, style=filled, fillcolor=lightblue, fontsize=18, width=1.2, fixedsize=false];\n");
        sb.append("ranksep=1.5;\n");
        sb.append("nodesep=0.1;\n");
        sb.append("splines=true;\n");
        sb.append("ordering=out;\n");

        if ("Binario".equals(tipoArbol) || "AVL".equals(tipoArbol)) {
            generarDotRecursivo(arbol, sb);
        }

        sb.append("}\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDot))) {
            writer.write(sb.toString());
        }

        return rutaDot;
    }

    private static String formatearPlaca(String placa) {
        if (placa.contains("-")) {
            return placa.replace("-", "-\\n");
        } else if (placa.length() >= 4) {
            return placa.substring(0, 3) + "-\\n" + placa.substring(3);
        }
        return placa;
    }

    private static void generarDotRecursivo(Arbol<Vehiculo> arbol, StringBuilder sb) {
        if (arbol instanceof ArbolBinarioBusqueda<Vehiculo> abb) {
            generarDotNodosABB(abb, sb, abb.getRaiz());
        } else if (arbol instanceof ArbolAVL<Vehiculo> avl) {
            generarDotNodosAVL(avl, sb, avl.getRaiz());
        }
    }

    private static void generarDotNodosABB(ArbolBinarioBusqueda<Vehiculo> arbol, StringBuilder sb, Object nodo) {
        if (nodo == null) return;
        var nodoActual = (ArbolBinarioBusqueda<Vehiculo>.Nodo) nodo;
        String actual = "\"" + formatearPlaca(nodoActual.dato.getPlaca()) + "\"";

        if (nodoActual.izquierdo != null) {
            String izq = "\"" + formatearPlaca(((ArbolBinarioBusqueda<Vehiculo>.Nodo) nodoActual.izquierdo).dato.getPlaca()) + "\"";
            sb.append(actual).append(" -> ").append(izq).append(";\n");
            generarDotNodosABB(arbol, sb, nodoActual.izquierdo);
        }

        if (nodoActual.derecho != null) {
            String der = "\"" + formatearPlaca(((ArbolBinarioBusqueda<Vehiculo>.Nodo) nodoActual.derecho).dato.getPlaca()) + "\"";
            sb.append(actual).append(" -> ").append(der).append(";\n");
            generarDotNodosABB(arbol, sb, nodoActual.derecho);
        }
    }

    private static void generarDotNodosAVL(ArbolAVL<Vehiculo> arbol, StringBuilder sb, Object nodo) {
        if (nodo == null) return;
        var nodoActual = (ArbolAVL<Vehiculo>.Nodo) nodo;
        String actual = "\"" + formatearPlaca(nodoActual.dato.getPlaca()) + "\"";

        if (nodoActual.izquierdo != null) {
            String izq = "\"" + formatearPlaca(((ArbolAVL<Vehiculo>.Nodo) nodoActual.izquierdo).dato.getPlaca()) + "\"";
            sb.append(actual).append(" -> ").append(izq).append(";\n");
            generarDotNodosAVL(arbol, sb, nodoActual.izquierdo);
        }

        if (nodoActual.derecho != null) {
            String der = "\"" + formatearPlaca(((ArbolAVL<Vehiculo>.Nodo) nodoActual.derecho).dato.getPlaca()) + "\"";
            sb.append(actual).append(" -> ").append(der).append(";\n");
            generarDotNodosAVL(arbol, sb, nodoActual.derecho);
        }
    }

    public static void generarSvgYAbrir(String rutaDot, String rutaSvg) throws IOException, InterruptedException {
        String comando = "dot -Tsvg " + rutaDot + " -o " + rutaSvg;
        Process p = Runtime.getRuntime().exec(comando);
        p.waitFor();

        File archivoSvg = new File(rutaSvg);
        if (archivoSvg.exists() && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(archivoSvg.toURI());
        } else {
            System.out.println("No se pudo abrir el archivo SVG.");
        }
    }
}
