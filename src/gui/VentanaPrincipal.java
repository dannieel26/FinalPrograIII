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
        jComboBoxOpcionesVehiculos = new javax.swing.JComboBox<>();
        jPanelCardOpcionesVehiculos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cardOpcionBuscarVehiculo = new javax.swing.JPanel();
        jTextFieldBuscarVehiculo = new javax.swing.JTextField();
        jButtonBuscarVehiculo = new javax.swing.JButton();
        jButtonLimpiarTablaVehiculos = new javax.swing.JButton();
        jPanelTiemposVehiculos = new javax.swing.JPanel();
        jLabelTiempoInsercion = new javax.swing.JLabel();
        jLabelTiempoRecorrido = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        cardVehiculosABB = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVehiculos = new javax.swing.JTable();
        cardInsertarVehiculo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInsertarVehiculo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxDepartamentoInsertar = new javax.swing.JComboBox<>();
        jButtonInsertarVehiculo = new javax.swing.JButton();
        jButtonRegresarInsertarVehiculo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabelInsertarMensajes = new javax.swing.JLabel();
        cardModificarVehiculo = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableModificarVehiculo = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jComboBoxDepartamentoModificar = new javax.swing.JComboBox<>();
        jButtonModificarVehiculo = new javax.swing.JButton();
        jButtonRegresarModificarVehiculo = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabelModificarMensajes = new javax.swing.JLabel();

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
        menuSuperior.setPreferredSize(new java.awt.Dimension(800, 65));
        menuSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 15));

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
        jComboBoxTipoArbol.setPreferredSize(new java.awt.Dimension(110, 35));
        jComboBoxTipoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoArbolActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxTipoArbol);

        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recorrido" }));
        jComboBoxRecorrido.setPreferredSize(new java.awt.Dimension(110, 35));
        jComboBoxRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRecorridoActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxRecorrido);

        jComboBoxOpcionesVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opciones", "Buscar", "Insertar", "Modificar", "Eliminar" }));
        jComboBoxOpcionesVehiculos.setPreferredSize(new java.awt.Dimension(90, 35));
        jComboBoxOpcionesVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcionesVehiculosActionPerformed(evt);
            }
        });
        menuSuperior.add(jComboBoxOpcionesVehiculos);

        jPanelCardOpcionesVehiculos.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanelCardOpcionesVehiculos.setLayout(new java.awt.CardLayout());
        jPanelCardOpcionesVehiculos.add(jPanel1, "cardOpcionesVacio");

        cardOpcionBuscarVehiculo.setPreferredSize(new java.awt.Dimension(155, 37));

        jTextFieldBuscarVehiculo.setPreferredSize(new java.awt.Dimension(75, 26));
        cardOpcionBuscarVehiculo.add(jTextFieldBuscarVehiculo);

        jButtonBuscarVehiculo.setText("Buscar");
        jButtonBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarVehiculoActionPerformed(evt);
            }
        });
        cardOpcionBuscarVehiculo.add(jButtonBuscarVehiculo);

        jPanelCardOpcionesVehiculos.add(cardOpcionBuscarVehiculo, "cardOpcionBuscarVehiculo");

        menuSuperior.add(jPanelCardOpcionesVehiculos);

        jButtonLimpiarTablaVehiculos.setText("Limpiar tabla");
        jButtonLimpiarTablaVehiculos.setPreferredSize(new java.awt.Dimension(103, 35));
        jButtonLimpiarTablaVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaVehiculosActionPerformed(evt);
            }
        });
        menuSuperior.add(jButtonLimpiarTablaVehiculos);

        jPanelTiemposVehiculos.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanelTiemposVehiculos.setLayout(new javax.swing.BoxLayout(jPanelTiemposVehiculos, javax.swing.BoxLayout.PAGE_AXIS));
        jPanelTiemposVehiculos.add(jLabelTiempoInsercion);
        jPanelTiemposVehiculos.add(jLabelTiempoRecorrido);

        menuSuperior.add(jPanelTiemposVehiculos);

        panelPrincipal.add(menuSuperior, java.awt.BorderLayout.NORTH);

        cardPanel.setPreferredSize(new java.awt.Dimension(800, 100));
        cardPanel.setLayout(new java.awt.CardLayout());

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

        cardInsertarVehiculo.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(10, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("INSERTAR VEHÍCULO | INGRESE LOS DATOS");
        jPanel2.add(jLabel2);

        cardInsertarVehiculo.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jTableInsertarVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PLACA", "DPI", "NOMBRE", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"
            }
        ));
        jScrollPane2.setViewportView(jTableInsertarVehiculo);

        jPanel3.add(jScrollPane2);

        cardInsertarVehiculo.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 350));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jComboBoxDepartamentoInsertar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un departamento" }));
        jComboBoxDepartamentoInsertar.setPreferredSize(new java.awt.Dimension(150, 40));
        jComboBoxDepartamentoInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoInsertarActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBoxDepartamentoInsertar);

        jButtonInsertarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonInsertarVehiculo.setText("Insertar");
        jButtonInsertarVehiculo.setPreferredSize(new java.awt.Dimension(100, 40));
        jButtonInsertarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarVehiculoActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonInsertarVehiculo);

        jButtonRegresarInsertarVehiculo.setText("Regresar");
        jButtonRegresarInsertarVehiculo.setPreferredSize(new java.awt.Dimension(100, 40));
        jButtonRegresarInsertarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarInsertarVehiculoActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonRegresarInsertarVehiculo);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.add(jLabelInsertarMensajes);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        cardInsertarVehiculo.add(jPanel4, java.awt.BorderLayout.SOUTH);

        cardPanel.add(cardInsertarVehiculo, "cardInsertarVehiculo");

        cardModificarVehiculo.setLayout(new java.awt.BorderLayout());

        jPanel11.setPreferredSize(new java.awt.Dimension(10, 50));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MODIFICAR VEHÍCULO | MODIFIQUE LOS DATOS");
        jPanel11.add(jLabel3);

        cardModificarVehiculo.add(jPanel11, java.awt.BorderLayout.NORTH);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jTableModificarVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PLACA", "DPI", "NOMBRE", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"
            }
        ));
        jScrollPane3.setViewportView(jTableModificarVehiculo);

        jPanel10.add(jScrollPane3);

        cardModificarVehiculo.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.setPreferredSize(new java.awt.Dimension(10, 350));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jComboBoxDepartamentoModificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un departamento" }));
        jComboBoxDepartamentoModificar.setPreferredSize(new java.awt.Dimension(150, 40));
        jComboBoxDepartamentoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoModificarActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBoxDepartamentoModificar);

        jButtonModificarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonModificarVehiculo.setText("Modificar");
        jButtonModificarVehiculo.setPreferredSize(new java.awt.Dimension(100, 40));
        jButtonModificarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarVehiculoActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonModificarVehiculo);

        jButtonRegresarModificarVehiculo.setText("Regresar");
        jButtonRegresarModificarVehiculo.setPreferredSize(new java.awt.Dimension(100, 40));
        jButtonRegresarModificarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarModificarVehiculoActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonRegresarModificarVehiculo);

        jPanel7.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel9.add(jLabelModificarMensajes);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        cardModificarVehiculo.add(jPanel7, java.awt.BorderLayout.SOUTH);

        cardPanel.add(cardModificarVehiculo, "cardModificarVehiculo");

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
        controlador.limpiarArbol();// Limpia el árbol actual para cargar nuevos datos
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        // Carga los datos del archivo correspondiente al departamento seleccionado
        cargarDepartamentosSeleccionados(jComboBoxDepartamentos.getSelectedIndex(),false);
        
        // Muestra los datos recorriendo el árbol (si ya se seleccionó un recorrido)
        realizarRecorridoYMostrarTabla();
    }//GEN-LAST:event_jComboBoxDepartamentosActionPerformed

    // Botón para limpiar solo la tabla (no borra los datos del árbol)
    private void jButtonLimpiarTablaVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaVehiculosActionPerformed
        limpiarTabla();
    }//GEN-LAST:event_jButtonLimpiarTablaVehiculosActionPerformed

    private void jComboBoxTipoArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoArbolActionPerformed
        controlador.limpiarArbol();// Limpia el árbol actual para cargar nuevos datos
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        // Carga los datos del archivo correspondiente al departamento seleccionado
        cargarDepartamentosSeleccionados(jComboBoxDepartamentos.getSelectedIndex(),false);
    }//GEN-LAST:event_jComboBoxTipoArbolActionPerformed
   
    // Cuando se selecciona un tipo de recorrido (Inorden, Preorden, Postorden)
    private void jComboBoxRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRecorridoActionPerformed
        if (jComboBoxRecorrido.getSelectedIndex() == 0){
                    limpiarTabla();
                }        

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

    //método cuando se presiona el botón de buscar vehículo
    private void jButtonBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVehiculoActionPerformed
        String textoBusqueda = jTextFieldBuscarVehiculo.getText().trim();

        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese al menos una parte de la placa para buscar.");
            return;
        }

        // Llamar al controlador para realizar la búsqueda
        List<Vehiculo> resultados = controlador.buscarVehiculosPorPlaca(textoBusqueda);

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron vehículos con esa placa.");
        } else {
            llenarTabla(resultados); // Reutilizamos el método que ya muestra datos en la tabla
        }

        // Muestra el tiempo de búsqueda, que ahora es gestionado por el controlador
        jLabelTiempoInsercion.setText(String.format("Tiempo de búsqueda: %.3f ms", controlador.getTiempoInsercion() / 1_000_000.0));
        jLabelTiempoRecorrido.setText(""); // Limpiar el segundo campo
    }//GEN-LAST:event_jButtonBuscarVehiculoActionPerformed

    //método de las opciones para hacer operaciones sobre los vehiculos
    private void jComboBoxOpcionesVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpcionesVehiculosActionPerformed
        int index = jComboBoxOpcionesVehiculos.getSelectedIndex();

        CardLayout clOpciones = (CardLayout) jPanelCardOpcionesVehiculos.getLayout();
        CardLayout clPrincipal = (CardLayout) cardPanel.getLayout();

        switch (index) {
            case 1: // Buscar
                clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionBuscarVehiculo");
                clPrincipal.show(cardPanel, "cardVehiculosABB"); // volver al panel principal
                break;
            case 2: // Insertar
                clPrincipal.show(cardPanel, "cardInsertarVehiculo");
                clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionesVacio");
                break;
            case 3: // Modificar
                int filaSeleccionada = jTableVehiculos.getSelectedRow();
                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo en la tabla primero.");
                    // Vuelve al panel principal
                    clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionesVacio");
                    clPrincipal.show(cardPanel, "cardVehiculosABB");
                    return;
                }

                // Pasa los datos seleccionados a la tabla de modificar
                DefaultTableModel modeloModificar = (DefaultTableModel) jTableModificarVehiculo.getModel();
                modeloModificar.setRowCount(1); // Solo una fila
                for (int i = 0; i < jTableVehiculos.getColumnCount(); i++) {
                    Object valor = jTableVehiculos.getValueAt(filaSeleccionada, i);
                    modeloModificar.setValueAt(valor, 0, i);
                }
                // Cambia de panel
                clPrincipal.show(cardPanel, "cardModificarVehiculo");
                clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionesVacio");
                int indexDepartamentoSeleccionado = jComboBoxDepartamentos.getSelectedIndex();
                jComboBoxDepartamentoModificar.setSelectedIndex(indexDepartamentoSeleccionado);
                break;
            case 4: //eliminar
                filaSeleccionada = jTableVehiculos.getSelectedRow();
                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo en la tabla primero.");
                    return;
                }

                // Obtenemos la placa del vehículo seleccionado
                String placaSeleccionada = jTableVehiculos.getValueAt(filaSeleccionada, 0).toString().trim();
                eliminarVehiculo(placaSeleccionada);
                break;
            default: // Nada o volver
                clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionesVacio");
                clPrincipal.show(cardPanel, "cardVehiculosABB"); // volver al panel principal
                break;
        }
    }//GEN-LAST:event_jComboBoxOpcionesVehiculosActionPerformed

    private void jComboBoxDepartamentoInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoInsertarActionPerformed
        
    }//GEN-LAST:event_jComboBoxDepartamentoInsertarActionPerformed

    // Método que se ejecuta al presionar el botón de "Insertar Vehiculo"
    private void jButtonInsertarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarVehiculoActionPerformed
        int fila = 0; // Es la única fila donde se insertan los datos

        DefaultTableModel modelo = (DefaultTableModel) jTableInsertarVehiculo.getModel();
        String departamento = (jComboBoxDepartamentoInsertar.getSelectedIndex() > 0)
                ? jComboBoxDepartamentoInsertar.getSelectedItem().toString()
                : "";

        // Validación para comprobar si se seleccionó un departamento
        if (departamento.isEmpty() || departamento.equals("Seleccione un departamento")) {
            // Mostrar un mensaje en el jLabelInsertarMensajes
            jLabelInsertarMensajes.setText("Debe seleccionar un departamento para insertar.");
            return; // Salir del método y evitar que se inserte el vehículo
        }

        // Llamar al controlador para insertar el vehículo
        String mensaje = controlador.procesarInsercionVehiculo(modelo, fila, departamento);

        // Mostrar el mensaje resultante
        jLabelInsertarMensajes.setText(mensaje);

        if (mensaje.equals("Vehículo insertado correctamente en el archivo.")) {
            // Si la inserción fue exitosa, limpia los campos de la fila
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                modelo.setValueAt("", fila, i);
            }

            jComboBoxDepartamentoInsertar.setSelectedIndex(0);

            // Mostrar el tiempo de inserción desde el controlador
            jLabelTiempoInsercion.setText(String.format("Tiempo de inserción: %.3f ms", controlador.getTiempoInsercion() / 1_000_000.0));
            jLabelTiempoRecorrido.setText("");
        }
    }//GEN-LAST:event_jButtonInsertarVehiculoActionPerformed

    //método para cuando se presiona el boton de regresar
    private void jButtonRegresarInsertarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarInsertarVehiculoActionPerformed
        // Mostrar el panel de vehículos
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "cardVehiculosABB");
        
        //reiniciar el label de mensajes
        jLabelInsertarMensajes.setText("");
        jLabelTiempoInsercion.setText("");
        jLabelTiempoRecorrido.setText("");

        //reiniciar el combo box de las opciones y departamentos
        jComboBoxOpcionesVehiculos.setSelectedIndex(0);
        jComboBoxDepartamentoInsertar.setSelectedIndex(0);
        jComboBoxDepartamentos.setSelectedIndex(0);
        jComboBoxTipoArbol.setSelectedIndex(0);
        jComboBoxRecorrido.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonRegresarInsertarVehiculoActionPerformed

    private void jButtonModificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarVehiculoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableModificarVehiculo.getModel();
        String departamento = jComboBoxDepartamentoModificar.getSelectedIndex() > 0 
                ? jComboBoxDepartamentoModificar.getSelectedItem().toString() 
                : "";  // Obtener el departamento seleccionado

        // Verificar si se ha seleccionado un departamento
        if (departamento.isEmpty() || departamento.equals("Seleccione un departamento")) {
            jLabelModificarMensajes.setText("Debe seleccionar un departamento para modificar.");
            return; // Salir del método si no se seleccionó un departamento
        }

        // Llamar al controlador para modificar el vehículo
        String mensaje = controlador.modificarVehiculo(modelo, 0, departamento); // Pasamos el departamento

        jLabelModificarMensajes.setText(mensaje);

        if (mensaje.startsWith("Vehículo modificado")) {
            // Limpiar la fila de modificar
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                modelo.setValueAt("", 0, i);
            }

            // Mostrar el tiempo de modificación desde el controlador
            jLabelTiempoInsercion.setText(String.format("Tiempo de modificación: %.3f ms", controlador.getTiempoInsercion() / 1_000_000.0));
            jLabelTiempoRecorrido.setText("");  // Limpiar el tiempo de recorrido
        }
    }//GEN-LAST:event_jButtonModificarVehiculoActionPerformed

    private void jButtonRegresarModificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarModificarVehiculoActionPerformed
        /// Mostrar el panel de vehículos
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "cardVehiculosABB");
        
        //reiniciar el label de mensajes
        jLabelModificarMensajes.setText("");
        jLabelTiempoInsercion.setText("");
        jLabelTiempoRecorrido.setText("");

        //reiniciar el combo box de las opciones y departamentos
        jComboBoxOpcionesVehiculos.setSelectedIndex(0);
        jComboBoxDepartamentoInsertar.setSelectedIndex(0);
        jComboBoxDepartamentos.setSelectedIndex(0);
        jComboBoxTipoArbol.setSelectedIndex(0);
        jComboBoxRecorrido.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonRegresarModificarVehiculoActionPerformed

    private void jComboBoxDepartamentoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDepartamentoModificarActionPerformed

    // Realiza el recorrido seleccionado y actualiza la tabla con los resultados
    private void realizarRecorridoYMostrarTabla() {
        if (ultimoRecorridoSeleccionado != null && jComboBoxTipoArbol.getSelectedIndex() == 1) {
            // Si no es modificación, entonces procesamos el recorrido
            List<Vehiculo> lista = switch (ultimoRecorridoSeleccionado) {
                case "Inorden" -> controlador.obtenerVehiculosInorden();
                case "Preorden" -> controlador.obtenerVehiculosPreorden();
                case "Postorden" -> controlador.obtenerVehiculosPostorden();
                default -> null;
            };

            // Solo mostrar tiempo de recorrido si se está haciendo realmente un recorrido
            double tiempoMilisRecorrido = controlador.getTiempoRecorrido() / 1_000_000.0;

            if (lista != null) {
                llenarTabla(lista);
                jLabelTiempoRecorrido.setText(String.format("Tiempo de recorrido: %.3f ms", tiempoMilisRecorrido));
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
        // Llenar el comboBox de departamentos para la vista principal
        inicializarComboBoxDepartamentos(jComboBoxDepartamentos, "Todos los departamentos");

        // Llenar el comboBox de departamentos para insertar
        inicializarComboBoxDepartamentos(jComboBoxDepartamentoInsertar, "Seleccione un departamento");

        // Llenar el comboBox de departamentos para modificar
        inicializarComboBoxDepartamentos(jComboBoxDepartamentoModificar, "Seleccione un departamento");

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
        jLabelTiempoInsercion.setText("");
    }
    
    private void inicializarComboBoxDepartamentos(javax.swing.JComboBox<String> comboBox, String valorInicial) {
        // Agrega el valor inicial (Ejemplo: "Seleccione un departamento" o "Todos los departamentos")
        String[] opcionesDepartamentos = new String[DEPARTAMENTOS.length + 1];
        opcionesDepartamentos[0] = valorInicial;  // Valor inicial personalizado

        // Copia los departamentos en el arreglo
        System.arraycopy(DEPARTAMENTOS, 0, opcionesDepartamentos, 1, DEPARTAMENTOS.length);

        // Asigna el modelo al comboBox
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesDepartamentos));
    }

    
    // Carga los datos desde archivo según el departamento seleccionado
        private void cargarDepartamentosSeleccionados(int index, boolean esModificacion) {
        controlador.limpiarArbol();

        if (index == 0) {
            // Si se selecciona "Todos los departamentos", los carga todos
            long inicio = System.nanoTime();
            for (String departamento : DEPARTAMENTOS) {
                String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
                if ("Binario".equals(jComboBoxTipoArbol.getSelectedItem())) {
                    controlador.cargarVehiculosDesdeArchivo(ruta); // Aquí se insertan los datos
                }
            }
            long fin = System.nanoTime();
            long tiempoNano = fin - inicio;
            double tiempoMillis = tiempoNano / 1_000_000.0;
            if (!esModificacion) {
                jLabelTiempoInsercion.setText(String.format("Tiempo de carga: %.3f ms", tiempoMillis));
            }
        } else {
            // Carga solo el archivo del departamento seleccionado
            String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            if ("Binario".equals(jComboBoxTipoArbol.getSelectedItem())) {
                long inicio = System.nanoTime();
                controlador.cargarVehiculosDesdeArchivo(ruta); // Aquí se insertan los datos
                long fin = System.nanoTime();

                long tiempoNano = fin - inicio;
                double tiempoMillis = tiempoNano / 1_000_000.0;
                if (!esModificacion) {
                    jLabelTiempoInsercion.setText(String.format("Tiempo de carga: %.3f ms", tiempoMillis));
                }
            }
        }
    }
        
    private void eliminarVehiculo(String placa) {
        //obtener el índice seleccionado en el JComboBox
        int departamentoIndex = jComboBoxDepartamentos.getSelectedIndex();

        long inicio = System.nanoTime();  // Comienza a medir el tiempo

        //verificar si se ha seleccionado un departamento específico o "Todos los departamentos"
        if (departamentoIndex == 0) {
            // caso cuando se elige "Todos los departamentos"
            //Buscar el vehículo en todos los departamentos
            boolean encontrado = false;
            for (String departamento : DEPARTAMENTOS) {
                String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
                String mensaje = controlador.eliminarVehiculoEnArchivo(ruta, placa);

                if (mensaje.equals("Vehículo eliminado correctamente.")) {
                    encontrado = true;
                    JOptionPane.showMessageDialog(this, "Vehículo eliminado correctamente de " + departamento);
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Vehículo no encontrado en ningún departamento.");
            }
        } else {
            //Caso cuando se selecciona un departamento específico
            String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
            if (departamento == null || departamento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un departamento primero.");
                return;
            }

            // Construir la ruta del archivo para el departamento seleccionado
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            // Llamar al método para eliminar el vehículo
            String mensaje = controlador.eliminarVehiculoEnArchivo(ruta, placa);
            JOptionPane.showMessageDialog(this, mensaje);
        }

        long fin = System.nanoTime();  // Fin de la medición
        long tiempoEliminacion = fin - inicio;  // Calcular el tiempo en nanosegundos

        // Convertir a milisegundos para un formato más legible
        double tiempoEnMs = tiempoEliminacion / 1_000_000.0;

        // Mostrar el tiempo de eliminación en el jLabelTiempoRecorrido
        jLabelTiempoRecorrido.setText(String.format("Tiempo de eliminación: %.3f ms", tiempoEnMs));
        jLabelTiempoInsercion.setText("");  // Limpiar el tiempo de inserción

        // Limpiar la tabla y recargar los datos después de la eliminación
        limpiarTabla();
        cargarDepartamentosSeleccionados(jComboBoxDepartamentos.getSelectedIndex(), false);
    }

    //devuelve la ruta del archivo seleccionado en el combo box departamento
    public String getRutaArchivoSeleccionado() {
        return rutaArchivoSeleccionado;
    }
    
    // Limpia la tabla sin borrar el árbol de datos
    private void limpiarTabla() {
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
    private javax.swing.JPanel cardInsertarVehiculo;
    private javax.swing.JPanel cardModificarVehiculo;
    private javax.swing.JPanel cardOpcionBuscarVehiculo;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cardVehiculosABB;
    private javax.swing.JButton jButtonBuscarVehiculo;
    private javax.swing.JButton jButtonInsertarVehiculo;
    private javax.swing.JButton jButtonLimpiarTablaVehiculos;
    private javax.swing.JButton jButtonModificarVehiculo;
    private javax.swing.JButton jButtonMultas;
    private javax.swing.JButton jButtonRegresarInsertarVehiculo;
    private javax.swing.JButton jButtonRegresarModificarVehiculo;
    private javax.swing.JButton jButtonTraspasos;
    private javax.swing.JButton jButtonVehiculos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoInsertar;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoModificar;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxOpcionesVehiculos;
    private javax.swing.JComboBox<String> jComboBoxRecorrido;
    private javax.swing.JComboBox<String> jComboBoxTipoArbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInsertarMensajes;
    private javax.swing.JLabel jLabelModificarMensajes;
    private javax.swing.JLabel jLabelTiempoInsercion;
    private javax.swing.JLabel jLabelTiempoRecorrido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCardOpcionesVehiculos;
    private javax.swing.JPanel jPanelTiemposVehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableInsertarVehiculo;
    private javax.swing.JTable jTableModificarVehiculo;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JTextField jTextFieldBuscarVehiculo;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel menuSuperior;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}