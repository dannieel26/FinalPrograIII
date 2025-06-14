package controller;

import datastructures.ListaDoble;
import model.Multa;
import utils.LectorMultas;
import java.io.File;

public class ControladorMultas {

    private static final String CARPETA_BASE = "SIRVE_Datos_Vehiculos_DataSet/";

    public ListaDoble<Multa> cargarMultasPorPlaca(String placa) {
        ListaDoble<Multa> multasEncontradas = new ListaDoble<>();

        File carpetaBase = new File(CARPETA_BASE);
        File[] departamentos = carpetaBase.listFiles(File::isDirectory);

        if (departamentos != null) {
            for (File departamento : departamentos) {
                String rutaArchivoMultas = departamento.getPath() + "/" + departamento.getName() + "_multas.txt";
                ListaDoble<Multa> multasDepto = LectorMultas.cargarMultas(rutaArchivoMultas);

                for (Multa multa : multasDepto.obtenerLista()) {
                    if (multa.getPlaca().equalsIgnoreCase(placa)) {
                        multasEncontradas.agregar(multa);
                    }
                }
            }
        }

        return multasEncontradas;
    }
}
