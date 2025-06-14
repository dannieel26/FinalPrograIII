package utils;

import datastructures.Arbol;
import model.Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class EncriptadorArbol {

    // Método para verificar si el archivo ya está encriptado
    public static boolean esArchivoEncriptado(String tipoArbol) {
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + tipoArbol + "_arbol_encriptado.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Verificar si hay caracteres que no son alfabéticos
                if (!linea.matches("[a-zA-Z0-9,\\s]+")) {
                    return true;  // Archivo contiene caracteres no alfabéticos, es probable que esté encriptado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer el archivo.");
        }

        return false;  // Si todo el texto está en formato legible, el archivo no está encriptado
    }

    // Método para encriptar el árbol seleccionado
    public static void encriptarArbol(Arbol<Vehiculo> arbol, String tipoArbol) {
        if (arbol == null) {
            return;  // No hacer nada si no hay árbol seleccionado
        }

        // Serializar el árbol
        String arbolSerializado = serializarArbol(arbol);

        // Encriptar el árbol con César (desplazamiento 3, por ejemplo)
        String arbolEncriptado = Encriptacion.encriptarCesar(arbolSerializado, 3);

        // Guardar el árbol encriptado en un archivo utilizando UTF-8
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + tipoArbol + "_arbol_encriptado.txt";
        guardarEnArchivo(arbolEncriptado, rutaArchivo);
    }

    // Serializa el árbol a un formato de texto (por ejemplo, inorden)
    private static String serializarArbol(Arbol<Vehiculo> arbol) {
        StringBuilder sb = new StringBuilder();
        // Usamos el recorrido inorden para serializar el árbol
        for (Vehiculo v : arbol.inorden()) {
            sb.append(v.getPlaca()).append(",")
              .append(v.getDpi()).append(",")
              .append(v.getNombre()).append(",")
              .append(v.getMarca()).append(",")
              .append(v.getModelo()).append(",")
              .append(v.getAnio()).append(",")
              .append(v.getCantidadMultas()).append(",")
              .append(v.getCantidadTraspasos()).append("\n");
        }

        return sb.toString();
    }

    // Método para guardar el texto encriptado en un archivo utilizando UTF-8
    private static void guardarEnArchivo(String textoEncriptado, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaArchivo), "UTF-8"))) {
            writer.write(textoEncriptado); // Escribe el texto encriptado en el archivo
            System.out.println("Árbol encriptado guardado en " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el archivo encriptado.");
        }
    }


    public static void desencriptarArbol(Arbol<Vehiculo> arbol, String tipoArbol) {
    if (arbol == null) {
        return;  // No hacer nada si no hay árbol seleccionado
    }

    // Verificar si el archivo está encriptado
    if (!esArchivoEncriptado(tipoArbol)) {
        System.out.println("El archivo no está encriptado.");
        return;
    }

    // Leer el archivo encriptado
    String archivoEncriptado = leerArchivoEncriptado(tipoArbol);

    // Desencriptar el archivo
    String arbolDesencriptado = Encriptacion.desencriptarCesar(archivoEncriptado, 3);

    // Depuración: Verificar si el texto desencriptado es correcto
    System.out.println("Texto desencriptado: \n" + arbolDesencriptado);

    // Restaurar el árbol
    restaurarArbol(arbolDesencriptado, arbol);
}



    // Método para leer el archivo encriptado
    private static String leerArchivoEncriptado(String tipoArbol) {
        StringBuilder sb = new StringBuilder();
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + tipoArbol + "_arbol_encriptado.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer el archivo encriptado.");
        }

        return sb.toString();
    }

    // Método para restaurar el árbol desde el texto desencriptado
    private static void restaurarArbol(String textoDesencriptado, Arbol<Vehiculo> arbol) {
    // Imprimir para depuración y ver si el texto se está procesando correctamente
    System.out.println("Restaurando el árbol...");

    String[] lineas = textoDesencriptado.split("\n");

    for (String linea : lineas) {
        // Asegúrate de que el split se haga correctamente
        String[] partes = linea.split(",");
        if (partes.length == 8) {
            // Procesar cada parte del vehículo
            String placa = partes[0].trim();
            String dpi = partes[1].trim();
            String nombre = partes[2].trim(); // Verificar que los nombres no tengan problemas con caracteres especiales
            String marca = partes[3].trim();
            String modelo = partes[4].trim();
            int anio = Integer.parseInt(partes[5].trim());
            int multas = Integer.parseInt(partes[6].trim());
            int traspasos = Integer.parseInt(partes[7].trim());

            // Crear el objeto Vehiculo
            Vehiculo vehiculo = new Vehiculo(placa, dpi, nombre, marca, modelo, anio, multas, traspasos);

            // Insertar el vehículo en el árbol
            arbol.insertar(vehiculo);
        }
    }

    System.out.println("Restauración del árbol completada.");
}

}
