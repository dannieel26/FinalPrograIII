package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Vehiculo;
import controller.ControladorVehiculos;
import java.awt.CardLayout;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private String rutaArchivoSeleccionado;
    private ControladorVehiculos controlador = new ControladorVehiculos();
    private String ultimoRecorridoSeleccionado = null;


    public VentanaPrincipal() {
        initComponents();
        inicializarCombos();
        setLocationRelativeTo(null);
        setTitle("SIRVE | Sistema Inteligente de Registro de Vehículos y Evaluación");
                panelPrincipal.removeAll(); //por el momento en construccion
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLateral = new javax.swing.JPanel();
        jButtonVehiculos = new javax.swing.JButton();
        jButtonMultas = new javax.swing.JButton();
        jButtonTraspasos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        menuSuperior = new javax.swing.JPanel();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        jComboBoxTipoArbol = new javax.swing.JComboBox<>();
        jComboBoxRecorrido = new javax.swing.JComboBox<>();
        jButtonLimpiarTabla = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        cardVehiculosABB = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVehiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 556));

        menuLateral.setBackground(new java.awt.Color(51, 51, 51));
        menuLateral.setPreferredSize(new java.awt.Dimension(200, 100));

        jButtonVehiculos.setBackground(new java.awt.Color(204, 204, 204));
        jButtonVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVehiculos.setText("VEHÍCULOS");
        jButtonVehiculos.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVehiculosActionPerformed(evt);
            }
        });
        menuLateral.add(jButtonVehiculos);

        jButtonMultas.setBackground(new java.awt.Color(204, 204, 204));
        jButtonMultas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonMultas.setText("MULTAS");
        jButtonMultas.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultasActionPerformed(evt);
            }
        });
        menuLateral.add(jButtonMultas);

        jButtonTraspasos.setBackground(new java.awt.Color(204, 204, 204));
        jButtonTraspasos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonTraspasos.setText("TRASPASOS");
        jButtonTraspasos.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraspasosActionPerformed(evt);
            }
        });
        menuLateral.add(jButtonTraspasos);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoUMG.png"))); // NOI18N
        menuLateral.add(jLabel1);

        getContentPane().add(menuLateral, java.awt.BorderLayout.WEST);

        panelPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        menuSuperior.setMaximumSize(null);
        menuSuperior.setPreferredSize(new java.awt.Dimension(800, 70));
        menuSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los departamentos" }));
        jComboBoxDepartamentos.setName(""); // NOI18N
        jComboBoxDepartamentos.setPreferredSize(new java.awt.Dimension(189, 35));
        jComboBoxDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentosActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxDepartamentos);

        jComboBoxTipoArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de arbol" }));
        jComboBoxTipoArbol.setPreferredSize(new java.awt.Dimension(176, 35));
        jComboBoxTipoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoArbolActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxTipoArbol);

        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el recorrido" }));
        jComboBoxRecorrido.setPreferredSize(new java.awt.Dimension(157, 35));
        jComboBoxRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRecorridoActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxRecorrido);

        jButtonLimpiarTabla.setText("Limpiar tabla");
        jButtonLimpiarTabla.setPreferredSize(new java.awt.Dimension(103, 35));
        jButtonLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaActionPerformed(evt);
            }
        });
        menuSuperior.add(jButtonLimpiarTabla);

        panelPrincipal.add(menuSuperior, java.awt.BorderLayout.NORTH);

        cardPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        cardPanel.setLayout(new java.awt.CardLayout());

        cardVehiculosABB.setBackground(new java.awt.Color(51, 51, 51));
        cardVehiculosABB.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);

        jTableVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "DPI", "NOMBRE", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVehiculos);

        cardVehiculosABB.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        cardPanel.add(cardVehiculosABB, "cardVehiculosABB");

        panelPrincipal.add(cardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //cuando se presiona el boton de vehiculos
    private void jButtonVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVehiculosActionPerformed
        panelPrincipal.add(menuSuperior, BorderLayout.NORTH);
        panelPrincipal.add(cardPanel, BorderLayout.CENTER);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "cardVehiculosABB");
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_jButtonVehiculosActionPerformed

    private void jButtonMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultasActionPerformed
        panelPrincipal.removeAll(); //por el momento en construccion
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_jButtonMultasActionPerformed

    private void jButtonTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraspasosActionPerformed
        panelPrincipal.removeAll();//por el momento en construccion
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_jButtonTraspasosActionPerformed

    private void jComboBoxDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentosActionPerformed
        int index = jComboBoxDepartamentos.getSelectedIndex(); // obtener el índice

        controlador.limpiarDatos(); // limpiar cualquier dato previo
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0); // limpiar tabla

        if (index == 0) {
            // Si se selecciona "Todos los departamentos" (es el indice 0)
            String[] departamentos = {
                "Suchitepequez", "Antigua_Guatemala", "Chimaltenango", "Chiquimula",
                "Escuintla", "Guatemala", "Huehuetenango", "Peten", "Quetzaltenango", "San_Marcos"
            };

            for (String departamento : departamentos) {
                String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
                controlador.cargarVehiculosDesdeArchivo(ruta);
            } 
        } else {
            // Cargar un solo departamento
            String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            controlador.cargarVehiculosDesdeArchivo(ruta);
        }

        //Si ya hay recorrido seleccionado, mostrar los datos de inmediato
        if (ultimoRecorridoSeleccionado != null && jComboBoxTipoArbol.getSelectedIndex() == 1) {
            List<Vehiculo> lista = switch (ultimoRecorridoSeleccionado) {
                case "Inorden" -> controlador.obtenerVehiculosInorden();
                case "Preorden" -> controlador.obtenerVehiculosPreorden();
                case "Postorden" -> controlador.obtenerVehiculosPostorden();
                default -> null;
            };
            if (lista != null) {
                llenarTabla(lista);
            }
        }
    }//GEN-LAST:event_jComboBoxDepartamentosActionPerformed

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
        
        ultimoRecorridoSeleccionado = recorrido; //Guardamos el recorrid

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
                v.getAnio(),
                v.getCantidadMultas(),
                v.getCantidadTraspasos()
            });
        }
        System.out.println("Total de vehículos mostrados en la tabla: " + lista.size());
    }

    //Este método se llama en el constructor de la ventana, por lo que todo está listo cuando se abre la interfaz
    private void inicializarCombos() {
        String[] departamentos = {
            "Todos los departamentos", // opción por defecto
            "Suchitepequez","Antigua_Guatemala","Chimaltenango","Chiquimula",
            "Escuintla","Guatemala","Huehuetenango","Peten","Quetzaltenango","San_Marcos"
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
        jComboBoxDepartamentos.setSelectedIndex(0);
    }
    
    //devuelve la ruta del archivo seleccionado en el combo box departamento
    public String getRutaArchivoSeleccionado() {
        return rutaArchivoSeleccionado;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cardVehiculosABB;
    private javax.swing.JButton jButtonLimpiarTabla;
    private javax.swing.JButton jButtonMultas;
    private javax.swing.JButton jButtonTraspasos;
    private javax.swing.JButton jButtonVehiculos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxRecorrido;
    private javax.swing.JComboBox<String> jComboBoxTipoArbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel menuSuperior;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
