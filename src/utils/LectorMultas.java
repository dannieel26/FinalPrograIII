package utils;

import model.Multa;
import datastructures.ListaDoble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorMultas {
    public static ListaDoble<Multa> cargarMultas(String rutaArchivo) {
        ListaDoble<Multa> listaMultas = new ListaDoble<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            return listaMultas;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;  // Aquí manejas el encabezado

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;  // Saltar encabezado
                    continue;
                }

                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String placa = partes[0];
                    String fecha = partes[1];
                    String descripcion = partes[2];

                    try {
                        double monto = Double.parseDouble(partes[3]);
                        Multa multa = new Multa(placa, fecha, descripcion, monto);
                        listaMultas.agregar(multa);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir el monto: " + partes[3]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaMultas;
    }
}
