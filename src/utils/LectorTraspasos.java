package utils;

import datastructures.ListaCircular;
import model.Traspaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorTraspasos {

    public static ListaCircular<Traspaso> cargarTraspasos(String rutaArchivo) {
        ListaCircular<Traspaso> listaTraspasos = new ListaCircular<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) return listaTraspasos;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Saltar encabezado
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    Traspaso traspaso = new Traspaso(
                        partes[0], partes[1], partes[2],
                        partes[3], partes[4], partes[5]
                    );
                    listaTraspasos.agregar(traspaso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaTraspasos;
    }
}
