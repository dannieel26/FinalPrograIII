package controller;

import model.Vehiculo;
import java.util.List;
import utils.LectorVehiculos;

public class ControladorRendimiento {

    private ControladorVehiculos controlador;
    private javax.swing.JTextArea jTextAreaRendimiento;

    public ControladorRendimiento(ControladorVehiculos controlador, javax.swing.JTextArea jTextAreaRendimiento) {
        this.controlador = controlador;
        this.jTextAreaRendimiento = jTextAreaRendimiento;
    }

    // Método para realizar la comparación de rendimiento entre los árboles
    public String realizarComparacionRendimiento() {
        StringBuilder resultado = new StringBuilder();

        // Supongamos que la ruta de los archivos de vehículos es "SIRVE_Datos_Vehiculos_DataSet/"
        String rutaArchivo = "SIRVE_Datos_Vehiculos_DataSet/Guatemala/Guatemala_vehiculos.txt";

        // Medir tiempo de inserción para árbol binario
        long inicioBinario = System.nanoTime();
        controlador.configurarTipoArbol("Binario");
        cargarYInsertarVehiculos(rutaArchivo);  // Cargar e insertar los vehículos en el árbol binario
        long finBinario = System.nanoTime();
        double tiempoBinarioInsercion = (finBinario - inicioBinario) / 1_000_000.0;  // en milisegundos

        // Medir tiempo de búsqueda para árbol binario
        long inicioBusquedaBinario = System.nanoTime();
        controlador.buscarVehiculosPorPlaca("PLACA_TEST");  // Suponiendo que se busca por placa
        long finBusquedaBinario = System.nanoTime();
        double tiempoBusquedaBinario = (finBusquedaBinario - inicioBusquedaBinario) / 1_000_000.0;  // en milisegundos

        // Medir tiempo de inserción para árbol AVL
        long inicioAVL = System.nanoTime();
        controlador.configurarTipoArbol("AVL");
        cargarYInsertarVehiculos(rutaArchivo);  // Cargar e insertar los vehículos en el árbol AVL
        long finAVL = System.nanoTime();
        double tiempoAVLInsercion = (finAVL - inicioAVL) / 1_000_000.0;  // en milisegundos

        // Medir tiempo de búsqueda para árbol AVL
        long inicioBusquedaAVL = System.nanoTime();
        controlador.buscarVehiculosPorPlaca("PLACA_TEST");  // Búsqueda por placa
        long finBusquedaAVL = System.nanoTime();
        double tiempoBusquedaAVL = (finBusquedaAVL - inicioBusquedaAVL) / 1_000_000.0;  // en milisegundos

        // Construir el resultado de la comparación
        resultado.append("Comparación de rendimiento entre Árbol Binario y Árbol AVL:\n\n");
        resultado.append("Árbol Binario:\n");
        resultado.append("Tiempo de inserción: ").append(tiempoBinarioInsercion).append(" ms\n");
        resultado.append("Tiempo de búsqueda: ").append(tiempoBusquedaBinario).append(" ms\n\n");

        resultado.append("Árbol AVL:\n");
        resultado.append("Tiempo de inserción: ").append(tiempoAVLInsercion).append(" ms\n");
        resultado.append("Tiempo de búsqueda: ").append(tiempoBusquedaAVL).append(" ms\n");

        return resultado.toString();
    }

    // Método para cargar los vehículos desde el archivo y insertarlos en el árbol
    private void cargarYInsertarVehiculos(String rutaArchivo) {
        List<Vehiculo> vehiculos = LectorVehiculos.cargarVehiculos(rutaArchivo);  // Carga los vehículos desde el archivo
        for (Vehiculo v : vehiculos) {
            controlador.getArbol().insertar(v);  // Inserta los vehículos en el árbol

            // Actualizar el JTextArea mostrando el vehículo insertado
            String mensaje = "Insertando vehículo: " + v.getPlaca() + " - " + v.getMarca() + " " + v.getModelo();
            jTextAreaRendimiento.append(mensaje + "\n");  // Añadir el mensaje al JTextArea
            jTextAreaRendimiento.setCaretPosition(jTextAreaRendimiento.getDocument().getLength());  // Desplazar el cursor al final
        }
    }
}
