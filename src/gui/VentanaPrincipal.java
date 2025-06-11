package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Vehiculo;
import controller.ControladorVehiculos;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private String rutaArchivoSeleccionado;
    private ControladorVehiculos controlador = new ControladorVehiculos();
    private String ultimoRecorridoSeleccionado = null;
    private static final String[] DEPARTAMENTOS = {
        "Suchitepequez", "Antigua_Guatemala", "Chimaltenango", "Chiquimula",
        "Escuintla", "Guatemala", "Huehuetenango", "Peten", "Quetzaltenango", "San_Marcos"
    };



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
        jTextFieldBuscarVehiculo = new javax.swing.JTextField();
        jButtonBuscarVehiculo = new javax.swing.JButton();
        jButtonLimpiarTabla = new javax.swing.JButton();
        jPanelTiempos = new javax.swing.JPanel();
        jLabelTiempoInsercion = new javax.swing.JLabel();
        jLabelTiempoRecorrido = new javax.swing.JLabel();
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
        menuSuperior.setPreferredSize(new java.awt.Dimension(800, 60));
        menuSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los departamentos" }));
        jComboBoxDepartamentos.setMaximumSize(new java.awt.Dimension(0, 0));
        jComboBoxDepartamentos.setMinimumSize(null);
        jComboBoxDepartamentos.setName(""); // NOI18N
        jComboBoxDepartamentos.setPreferredSize(new java.awt.Dimension(180, 35));
        jComboBoxDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentosActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxDepartamentos);

        jComboBoxTipoArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de arbol" }));
        jComboBoxTipoArbol.setMaximumSize(null);
        jComboBoxTipoArbol.setMinimumSize(null);
        jComboBoxTipoArbol.setPreferredSize(new java.awt.Dimension(120, 35));
        jComboBoxTipoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoArbolActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxTipoArbol);

        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recorrido" }));
        jComboBoxRecorrido.setPreferredSize(new java.awt.Dimension(120, 35));
        jComboBoxRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRecorridoActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxRecorrido);

        jTextFieldBuscarVehiculo.setPreferredSize(new java.awt.Dimension(70, 26));
        menuSuperior.add(jTextFieldBuscarVehiculo);

        jButtonBuscarVehiculo.setText("Buscar");
        jButtonBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarVehiculoActionPerformed(evt);
            }
        });
        menuSuperior.add(jButtonBuscarVehiculo);

        jButtonLimpiarTabla.setText("Limpiar tabla");
        jButtonLimpiarTabla.setPreferredSize(new java.awt.Dimension(103, 35));
        jButtonLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaActionPerformed(evt);
            }
        });
        menuSuperior.add(jButtonLimpiarTabla);

        jPanelTiempos.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanelTiempos.setLayout(new javax.swing.BoxLayout(jPanelTiempos, javax.swing.BoxLayout.PAGE_AXIS));
        jPanelTiempos.add(jLabelTiempoInsercion);
        jPanelTiempos.add(jLabelTiempoRecorrido);

        menuSuperior.add(jPanelTiempos);

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
        // Agrega el menú superior y el panel de tarjetas al panel principal
        panelPrincipal.add(menuSuperior, BorderLayout.NORTH);
        panelPrincipal.add(cardPanel, BorderLayout.CENTER);
        
        // Muestra la tarjeta correspondiente a vehículos (nombre del panel: "cardVehiculosABB")
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "cardVehiculosABB");
        
        panelPrincipal.revalidate();// Actualiza el diseño del panel
        panelPrincipal.repaint(); // Redibuja el contenido
    }//GEN-LAST:event_jButtonVehiculosActionPerformed

    // Botón "Multas" (sin funcionalidad aún)
    private void jButtonMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultasActionPerformed
        panelPrincipal.removeAll(); //por el momento en construccion
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_jButtonMultasActionPerformed

    // Botón "Traspasos" (sin funcionalidad aún)
    private void jButtonTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraspasosActionPerformed
        panelPrincipal.removeAll();//por el momento en construccion
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_jButtonTraspasosActionPerformed

    // Cuando se selecciona un departamento en el ComboBox
    private void jComboBoxDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentosActionPerformed
        controlador.limpiarDatos(); // Limpia el árbol actual para cargar nuevos datos
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        // Carga los datos del archivo correspondiente al departamento seleccionado
        cargarDepartamentosSeleccionados(jComboBoxDepartamentos.getSelectedIndex());
        
        // Muestra los datos recorriendo el árbol (si ya se seleccionó un recorrido)
        realizarRecorridoYMostrarTabla();
    }//GEN-LAST:event_jComboBoxDepartamentosActionPerformed

    // Botón para limpiar solo la tabla (no borra los datos del árbol)
    private void jButtonLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaActionPerformed
        limpiarTablaYDatos();
    }//GEN-LAST:event_jButtonLimpiarTablaActionPerformed

    private void jComboBoxTipoArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoArbolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoArbolActionPerformed
   
    // Cuando se selecciona un tipo de recorrido (Inorden, Preorden, Postorden)
    private void jComboBoxRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRecorridoActionPerformed
        // Verifica que se haya seleccionado un tipo de árbol y un recorrido válidos
        if (jComboBoxTipoArbol.getSelectedIndex() <= 0 || jComboBoxRecorrido.getSelectedIndex() <= 0) {
            return; // asegura que haya una selección válida
        }

        //Guarda el recorrido seleccionado para usarlo más adelante
        ultimoRecorridoSeleccionado = (String) jComboBoxRecorrido.getSelectedItem();

        // Solo se admite árbol binario por ahora
        if (!"Binario".equals(jComboBoxTipoArbol.getSelectedItem())) {
            return;
        }

        // Llama al método que realiza el recorrido, mide el tiempo y llena la tabla
        realizarRecorridoYMostrarTabla();
    }//GEN-LAST:event_jComboBoxRecorridoActionPerformed

    private void jButtonBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVehiculoActionPerformed
        String textoBusqueda = jTextFieldBuscarVehiculo.getText().trim();

        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese al menos una parte de la placa para buscar.");
            return;
        }

        long inicioBusqueda = System.nanoTime(); // ⏱️ Inicia cronómetro
        List<Vehiculo> resultados = controlador.buscarVehiculosPorPlaca(textoBusqueda);
        long finBusqueda = System.nanoTime(); // ⏱️ Termina cronómetro

        double tiempoMilisBusqueda = (finBusqueda - inicioBusqueda) / 1_000_000.0;

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron vehículos con esa placa.");
        } else {
            llenarTabla(resultados); // Reutilizamos el método que ya muestra datos en la tabla
        }

        // Muestra el tiempo en el primer campo y deja el segundo en blanco
        jLabelTiempoInsercion.setText(String.format("Tiempo de búsqueda: %.3f ms", tiempoMilisBusqueda));
        jLabelTiempoRecorrido.setText(""); // Limpiar el segundo campo
    }//GEN-LAST:event_jButtonBuscarVehiculoActionPerformed

    // Realiza el recorrido seleccionado y actualiza la tabla con los resultados
    private void realizarRecorridoYMostrarTabla() {
        // Asegura que se haya seleccionado un recorrido y que el tipo de árbol sea válido
        if (ultimoRecorridoSeleccionado != null && jComboBoxTipoArbol.getSelectedIndex() == 1) {
            long inicioRecorrido = System.nanoTime();

            // Obtiene los vehículos en el orden seleccionado
            List<Vehiculo> lista = switch (ultimoRecorridoSeleccionado) {
                case "Inorden" -> controlador.obtenerVehiculosInorden();
                case "Preorden" -> controlador.obtenerVehiculosPreorden();
                case "Postorden" -> controlador.obtenerVehiculosPostorden();
                default -> null;
            };

            long finRecorrido = System.nanoTime();
            long duracionRecorrido = finRecorrido - inicioRecorrido;
            double tiempoMilisRecorrido = duracionRecorrido / 1_000_000.0;

            if (lista != null) {
                llenarTabla(lista); // Muestra los vehículos en la tabla

                long tiempoNanoInsercion = controlador.getTiempoInsercion();
                double tiempoMilisInsercion = tiempoNanoInsercion / 1_000_000.0;

                jLabelTiempoInsercion.setText("Tiempo de inserción: " + tiempoMilisInsercion + " ms");
                jLabelTiempoRecorrido.setText("Tiempo de recorrido: " + tiempoMilisRecorrido + " ms");
            }
        }
    }
    
    // Llena la tabla con la lista de vehículos proporcionada
    private void llenarTabla(List<Vehiculo> lista) {
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel(); //obtiene el modelo de la tabla
        modelo.setRowCount(0); // Limpiar tabla

        // agrega fila por fila los datos de cada vehículo
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
        
        // Mensaje de depuración en consola
        System.out.println("Total de vehiculos mostrados en la tabla: " + lista.size());
    }

    //Este método se llama en el constructor de la ventana, por lo que todo está listo cuando se abre la interfaz
    private void inicializarCombos() {
        // Agrega "Todos los departamentos" al inicio
        String[] opcionesDepartamentos = new String[DEPARTAMENTOS.length + 1];
        opcionesDepartamentos[0] = "Todos los departamentos";
        System.arraycopy(DEPARTAMENTOS, 0, opcionesDepartamentos, 1, DEPARTAMENTOS.length);
        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesDepartamentos));

        // ComboBox para tipo de árbol
        jComboBoxTipoArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Tipo de arbol", "Binario", "AVL"
        }));

        // ComboBox para recorrido
        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Recorrido", "Inorden", "Preorden", "Postorden"
        }));

        // Selección por defecto
        jComboBoxDepartamentos.setSelectedIndex(0);
    }
    
    // Carga los datos desde archivo según el departamento seleccionado
    private void cargarDepartamentosSeleccionados(int index) {
        if (index == 0) {
            // Si se selecciona "Todos los departamentos", los carga todos
            for (String departamento : DEPARTAMENTOS) {
                String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
                controlador.cargarVehiculosDesdeArchivo(ruta);
            }
        } else {
            // Carga solo el archivo del departamento seleccionado
            String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            controlador.cargarVehiculosDesdeArchivo(ruta);
        }
    }

    //devuelve la ruta del archivo seleccionado en el combo box departamento
    public String getRutaArchivoSeleccionado() {
        return rutaArchivoSeleccionado;
    }
    
    // Limpia la tabla sin borrar el árbol de datos
    private void limpiarTablaYDatos() {
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0);
        //controlador.limpiarDatos();
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
    private javax.swing.JButton jButtonBuscarVehiculo;
    private javax.swing.JButton jButtonLimpiarTabla;
    private javax.swing.JButton jButtonMultas;
    private javax.swing.JButton jButtonTraspasos;
    private javax.swing.JButton jButtonVehiculos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxRecorrido;
    private javax.swing.JComboBox<String> jComboBoxTipoArbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTiempoInsercion;
    private javax.swing.JLabel jLabelTiempoRecorrido;
    private javax.swing.JPanel jPanelTiempos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JTextField jTextFieldBuscarVehiculo;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel menuSuperior;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}