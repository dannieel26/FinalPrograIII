package controller;

import datastructures.ListaCircular;
import datastructures.ListaDoble;
import model.Multa;
import model.Traspaso;
import utils.LectorMultas;
import utils.LectorTraspasos;

import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorEstadisticas {

    private static final String[] DEPARTAMENTOS = {
        "Suchitepequez", "Antigua_Guatemala", "Chimaltenango", "Chiquimula",
        "Escuintla", "Guatemala", "Huehuetenango", "Peten", "Quetzaltenango", "San_Marcos"
    };

    // Método para obtener el vehículo con más multas
    public List<String[]> obtenerEstadisticasVehiculosConMasMultas() {
        List<String[]> estadisticas = new ArrayList<>();
        Map<String, Integer> mapaMultas = new HashMap<>();

        // Iterar sobre los vehículos y contar las multas
        for (String departamento : DEPARTAMENTOS) {
            String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_multas.txt";
            ListaDoble<Multa> multas = LectorMultas.cargarMultas(rutaArchivo);

            for (Multa multa : multas.obtenerLista()) {
                mapaMultas.put(multa.getPlaca(), mapaMultas.getOrDefault(multa.getPlaca(), 0) + 1);
            }
        }

        // Ordenar por la cantidad de multas en orden descendente
        mapaMultas.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> estadisticas.add(new String[] { entry.getKey(), String.valueOf(entry.getValue()) }));

        return estadisticas;
    }

    // Método para obtener el vehículo con más traspasos
    public List<String[]> obtenerEstadisticasVehiculosConMasTraspasos() {
        List<String[]> estadisticas = new ArrayList<>();
        Map<String, Integer> mapaTraspasos = new HashMap<>();

        // Iterar sobre los vehículos y contar los traspasos
        for (String departamento : DEPARTAMENTOS) {
            String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_traspasos.txt";
            ListaCircular<Traspaso> traspasos = LectorTraspasos.cargarTraspasos(rutaArchivo);

            for (Traspaso traspaso : traspasos.obtenerLista()) {
                mapaTraspasos.put(traspaso.getPlaca(), mapaTraspasos.getOrDefault(traspaso.getPlaca(), 0) + 1);
            }
        }

        // Ordenar por la cantidad de traspasos en orden descendente
        mapaTraspasos.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> estadisticas.add(new String[] { entry.getKey(), String.valueOf(entry.getValue()) }));

        return estadisticas;
    }

    // Método para obtener los meses con más eventos (multas + traspasos)
    public List<String[]> obtenerEstadisticasMesesConMasEventos() {
        List<String[]> estadisticas = new ArrayList<>();
        Map<String, Integer> mapaEventosPorMes = new HashMap<>();

        // Contar eventos por mes (multas y traspasos)
        for (String departamento : DEPARTAMENTOS) {
            String rutaArchivoMultas = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_multas.txt";
            ListaDoble<Multa> multas = LectorMultas.cargarMultas(rutaArchivoMultas);

            for (Multa multa : multas.obtenerLista()) {
                String mes = multa.getFecha().substring(0, 7); // Extrae el mes (yyyy-mm)
                mapaEventosPorMes.put(mes, mapaEventosPorMes.getOrDefault(mes, 0) + 1);
            }

            String rutaArchivoTraspasos = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_traspasos.txt";
            ListaCircular<Traspaso> traspasos = LectorTraspasos.cargarTraspasos(rutaArchivoTraspasos);

            for (Traspaso traspaso : traspasos.obtenerLista()) {
                String mes = traspaso.getFecha().substring(0, 7); // Extrae el mes (yyyy-mm)
                mapaEventosPorMes.put(mes, mapaEventosPorMes.getOrDefault(mes, 0) + 1);
            }
        }

        // Ordenar por cantidad de eventos por mes en orden descendente
        mapaEventosPorMes.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .forEach(entry -> estadisticas.add(new String[] { entry.getKey(), String.valueOf(entry.getValue()) }));

        return estadisticas;
    }

    // Método para generar todas las estadísticas
    public void generarEstadisticas(ControladorVehiculos controlador, 
                                     JTable jTableEstadisticasMultas,
                                     JTable jTableEstadisticasTraspasos,
                                     JTable jTableEstadisticasMeses) {
        // Obtener las estadísticas
        List<String[]> estadisticasMultas = obtenerEstadisticasVehiculosConMasMultas();
        List<String[]> estadisticasTraspasos = obtenerEstadisticasVehiculosConMasTraspasos();
        List<String[]> estadisticasMeses = obtenerEstadisticasMesesConMasEventos();

        // Limpiar las tablas
        limpiarTablaEstadisticas(jTableEstadisticasMultas);
        limpiarTablaEstadisticas(jTableEstadisticasTraspasos);
        limpiarTablaEstadisticas(jTableEstadisticasMeses);

        // Insertar en la tabla de estadísticas de multas
        DefaultTableModel modeloMultas = (DefaultTableModel) jTableEstadisticasMultas.getModel();
        for (String[] estadistica : estadisticasMultas) {
            modeloMultas.addRow(estadistica);
        }

        // Insertar en la tabla de estadísticas de traspasos
        DefaultTableModel modeloTraspasos = (DefaultTableModel) jTableEstadisticasTraspasos.getModel();
        for (String[] estadistica : estadisticasTraspasos) {
            modeloTraspasos.addRow(estadistica);
        }

        // Insertar en la tabla de estadísticas de meses
        DefaultTableModel modeloMeses = (DefaultTableModel) jTableEstadisticasMeses.getModel();
        for (String[] estadistica : estadisticasMeses) {
            modeloMeses.addRow(estadistica);
        }
    }

    // Método para limpiar las tablas de estadísticas
    private void limpiarTablaEstadisticas(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
    }
}
