/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import controller.ControladorVehiculos;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Vehiculo;

/**
 *
 * @author Pablo
 */
public class VentanaVehiculos extends javax.swing.JPanel {
    
    //VentanaPrincipal vp = new VentanaPrincipal();

    public VentanaVehiculos() {
        initComponents();
        inicializarCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVehiculos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVehiculos = new javax.swing.JTable();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        jButtonLimpiarTabla = new javax.swing.JButton();
        jComboBoxTipoArbol = new javax.swing.JComboBox<>();
        jComboBoxRecorrido = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(900, 450));

        panelVehiculos.setBackground(new java.awt.Color(51, 51, 51));

        jTableVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "DPI", "NOMBRE", "MARCA", "MODELO", "AÑO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVehiculos);
        if (jTableVehiculos.getColumnModel().getColumnCount() > 0) {
            jTableVehiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableVehiculos.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableVehiculos.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un departamento" }));
        jComboBoxDepartamentos.setName(""); // NOI18N
        jComboBoxDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentosActionPerformed(evt);
            }
        });

        jButtonLimpiarTabla.setText("Limpiar tabla");
        jButtonLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaActionPerformed(evt);
            }
        });

        jComboBoxTipoArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de arbol" }));
        jComboBoxTipoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoArbolActionPerformed(evt);
            }
        });

        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el recorrido" }));
        jComboBoxRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRecorridoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVehiculosLayout = new javax.swing.GroupLayout(panelVehiculos);
        panelVehiculos.setLayout(panelVehiculosLayout);
        panelVehiculosLayout.setHorizontalGroup(
            panelVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelVehiculosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxTipoArbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxRecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jButtonLimpiarTabla)
                .addGap(96, 96, 96))
        );
        panelVehiculosLayout.setVerticalGroup(
            panelVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVehiculosLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiarTabla)
                    .addComponent(jComboBoxTipoArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //cuando se presiona el combo box con departamentos
    private void jComboBoxDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentosActionPerformed
        int index = jComboBoxDepartamentos.getSelectedIndex(); //obtener el indice
        
        if (index <= 0) { //si el indice es cero o menor no hace nada
            return;
        }
        
        ///btener el nombre del departamento seleccionado
        String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
        //construye la ruta al archivo de datos del departamento seleccionado
        String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
        
        controlador.limpiarDatos(); // Limpiar el árbol anterior
        controlador.cargarVehiculosDesdeArchivo(ruta);
        
        //limpia la tabla de la interfaz para que quede lista para mostrar nuevos datos
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_jComboBoxDepartamentosActionPerformed

    //método que limpia la tabla, los datos del arbol y reinicia los combo box
    private void jButtonLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0);
        controlador.limpiarDatos();
        jComboBoxDepartamentos.setSelectedIndex(0);
        jComboBoxTipoArbol.setSelectedIndex(0);
        jComboBoxRecorrido.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonLimpiarTablaActionPerformed

    private void jComboBoxTipoArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoArbolActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxTipoArbolActionPerformed

    private void jComboBoxRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRecorridoActionPerformed
        if (jComboBoxTipoArbol.getSelectedIndex() <= 0 || jComboBoxRecorrido.getSelectedIndex() <= 0) {
            return; // Asegura que haya una selección válida
        }
        
        // Obtiene las opciones seleccionadas de tipo de arbol y recorrido
        String tipoArbol = (String) jComboBoxTipoArbol.getSelectedItem();
        String recorrido = (String) jComboBoxRecorrido.getSelectedItem();

        if (!"Binario".equals(tipoArbol)) { //Verifica si el tipo de árbol seleccionado es "Binario"
            return; // Aún no soportamos otros tipos
        }

        //Según el recorrido seleccionado, obtiene la lista de vehiculos correspondiente desde el árbol
        List<Vehiculo> lista = switch (recorrido) {
            case "Inorden" -> controlador.obtenerVehiculosInorden();
            case "Preorden" -> controlador.obtenerVehiculosPreorden();
            case "Postorden" -> controlador.obtenerVehiculosPostorden();
            default -> null; //si el recorrido no coincide
        };

        if (lista != null) { //si la la lista no está vacia se llena la tabla
            llenarTabla(lista);
        }
    }//GEN-LAST:event_jComboBoxRecorridoActionPerformed

    private void llenarTabla(List<Vehiculo> lista) {
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel(); //obtiene el modelo de la tabla
        modelo.setRowCount(0); // Limpiar tabla

        //recorre la lista de vehículos y agrega cada uno como una nueva fila en la tabla
        for (Vehiculo v : lista) {
            modelo.addRow(new Object[]{
                v.getPlaca(),
                v.getDpi(),
                v.getNombre(),
                v.getMarca(),
                v.getModelo(),
                v.getAnio()
            });
        }
    }

    //Este método se llama en el constructor de la ventana, por lo que todo está listo cuando se abre la interfaz
    private void inicializarCombos() {
        String[] departamentos = {
            "Seleccione un departamento", // opción por defecto
            "Suchitepequez","Antigua_Guatemala","Chimaltenango","Chiquimula","Escuintla","Guatemala","Huehuetenango","Peten","Quetzaltenango","San_Marcos"
        };
        //Establece los valores del ComboBox de departamentos
        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(departamentos));
        
        // Establece las opciones del ComboBox de tipo de árbol
        jComboBoxTipoArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Seleccione el tipo de arbol", "Binario", "AVL"
        }));
        
        //// Establece las opciones del ComboBox de recorrido
        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Seleccione el recorrido", "Inorden", "Preorden", "Postorden"
        }));
    }
    
    //devuelve la ruta del archivo seleccionado en el combo box departamento
    public String getRutaArchivoSeleccionado() {
        return rutaArchivoSeleccionado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLimpiarTabla;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxRecorrido;
    private javax.swing.JComboBox<String> jComboBoxTipoArbol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JPanel panelVehiculos;
    // End of variables declaration//GEN-END:variables
    private String rutaArchivoSeleccionado;
    private ControladorVehiculos controlador = new ControladorVehiculos();
}
