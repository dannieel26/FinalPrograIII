package controller;

import datastructures.ListaCircular;
import model.Traspaso;
import utils.LectorTraspasos;
import java.io.File;

public class ControladorTraspasos {

    private static final String CARPETA_BASE = "SIRVE_Datos_Vehiculos_DataSet/";

    public ListaCircular<Traspaso> cargarTraspasosPorPlaca(String placa) {
        ListaCircular<Traspaso> traspasosEncontrados = new ListaCircular<>();
        File carpetaBase = new File(CARPETA_BASE);
        File[] departamentos = carpetaBase.listFiles(File::isDirectory);

        if (departamentos != null) {
            for (File depto : departamentos) {
                String rutaArchivo = depto.getPath() + "/" + depto.getName() + "_traspasos.txt";
                ListaCircular<Traspaso> traspasosDepto = LectorTraspasos.cargarTraspasos(rutaArchivo);

                for (Traspaso t : traspasosDepto.obtenerLista()) {
                    if (t.getPlaca().equalsIgnoreCase(placa)) {
                        traspasosEncontrados.agregar(t);
                    }
                }
            }
        }
        return traspasosEncontrados;
    }
}
