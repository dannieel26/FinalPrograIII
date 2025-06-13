//esta clase carga los datos desde un archivo .txt y los transforma en una lista de objetos Vehiculo
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Vehiculo;

public class LectorVehiculos {
    
    public static List<Vehiculo> cargarVehiculos(String rutaArchivo){
        List<Vehiculo> lista = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            boolean primera = true;
            
            while ((linea = br.readLine()) != null){
                if (primera){
                    primera = false; //saltar encabezado (primera linea)
                    continue;
                }
                
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    String placa = partes[0];
                    String dpi = partes[1];
                    String nombre = partes[2];
                    String marca = partes[3];
                    String modelo = partes[4];
                    int anio = Integer.parseInt(partes[5]);
                    int multas = Integer.parseInt(partes[6]);
                    int traspasos = Integer.parseInt(partes[7]);

                    Vehiculo vehiculo = new Vehiculo(placa, dpi, nombre, marca, modelo, anio, multas, traspasos);
                    lista.add(vehiculo);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return lista;
    }
}