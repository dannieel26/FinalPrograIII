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
        jButtonRegresarInsertar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabelInsertarMensajes = new javax.swing.JLabel();

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

        jButtonRegresarInsertar.setText("Regresar");
        jButtonRegresarInsertar.setPreferredSize(new java.awt.Dimension(100, 40));
        jButtonRegresarInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarInsertarActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonRegresarInsertar);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.add(jLabelInsertarMensajes);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        cardInsertarVehiculo.add(jPanel4, java.awt.BorderLayout.SOUTH);

        cardPanel.add(cardInsertarVehiculo, "cardInsertarVehiculo");

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
    private void jButtonLimpiarTablaVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaVehiculosActionPerformed
        limpiarTablaYDatos();
    }//GEN-LAST:event_jButtonLimpiarTablaVehiculosActionPerformed

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

    //método cuando se presiona el botón de buscar vehículo
    private void jButtonBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarVehiculoActionPerformed
        String textoBusqueda = jTextFieldBuscarVehiculo.getText().trim();

        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese al menos una parte de la placa para buscar.");
            return;
        }

        long inicioBusqueda = System.nanoTime(); //Inicia cronómetro
        List<Vehiculo> resultados = controlador.buscarVehiculosPorPlaca(textoBusqueda);
        long finBusqueda = System.nanoTime(); //Termina cronómetro

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
        int fila = 0; //es la unica fila donde se insertan los datos
        
        // Obtiene el modelo de la tabla donde se ingresan los datos del nuevo vehículo
        DefaultTableModel modelo = (DefaultTableModel) jTableInsertarVehiculo.getModel();
        String departamento = (jComboBoxDepartamentoInsertar.getSelectedIndex() > 0)
                // Obtiene el departamento seleccionado en el combo box de inserción
            ? jComboBoxDepartamentoInsertar.getSelectedItem().toString()
                // Si no se ha seleccionado ningún departamento asigna cadena vacía
            : "";

        //Llama al método que procesa la inserción del vehículo con los datos en la fila 0 y el departamento seleccionado
        //Este método valida, inserta en archivo y devuelve un mensaje de éxito o error
        String mensaje = controlador.procesarInsercionVehiculo(modelo, fila, departamento);
        
        // Muestra el mensaje resultante en una etiqueta para informar al usuario
        jLabelInsertarMensajes.setText(mensaje);

        if (mensaje.equals("Vehículo insertado correctamente en el archivo.")) {
             // Si la inserción fue exitosa, limpia los campos de la fila para permitir nueva inserción
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                //Establece cadena vacía en cada columna de la fila 0 para borrar los datos ingresados previamente
                modelo.setValueAt("", fila, i);
            }
            //reiniciar el jComboBox de departamentos si se insertó con exito
            jComboBoxDepartamentoInsertar.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButtonInsertarVehiculoActionPerformed

    //método para cuando se presiona el boton de regresar
    private void jButtonRegresarInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarInsertarActionPerformed
        // Obtener selección actual de tipo de árbol y recorrido
        int tipoArbolIndex = jComboBoxTipoArbol.getSelectedIndex();
        int recorridoIndex = jComboBoxRecorrido.getSelectedIndex();

        // Validar que ambos estén seleccionados (índices > 0)
        if (tipoArbolIndex > 0 && recorridoIndex > 0) {
            // Recargar datos desde el archivo según departamento
            cargarDepartamentosSeleccionados(jComboBoxDepartamentos.getSelectedIndex());

            // Guardar el recorrido seleccionado nuevamente
            ultimoRecorridoSeleccionado = (String) jComboBoxRecorrido.getSelectedItem();

            // Mostrar recorrido y llenar tabla
            realizarRecorridoYMostrarTabla();
        }

        // Mostrar el panel de vehículos
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "cardVehiculosABB");
        
        //reiniciar el label de mensajes
        jLabelInsertarMensajes.setText("");

        //reiniciar el combo box de las opciones y departamentos
        jComboBoxOpcionesVehiculos.setSelectedIndex(0);
        jComboBoxDepartamentoInsertar.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonRegresarInsertarActionPerformed

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

                jLabelTiempoInsercion.setText(String.format("Tiempo de inserción: %.3f ms", tiempoMilisInsercion));
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
        
        String[] opcionesDepartamentosInsertar = new String[DEPARTAMENTOS.length + 1];
        opcionesDepartamentosInsertar[0] = "Seleccione un departamento";
        System.arraycopy(DEPARTAMENTOS, 0, opcionesDepartamentosInsertar, 1, DEPARTAMENTOS.length);
        jComboBoxDepartamentoInsertar.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesDepartamentosInsertar));
    }
    
    // Carga los datos desde archivo según el departamento seleccionado
    private void cargarDepartamentosSeleccionados(int index) {
        controlador.limpiarDatos();
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
    private javax.swing.JPanel cardInsertarVehiculo;
    private javax.swing.JPanel cardOpcionBuscarVehiculo;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cardVehiculosABB;
    private javax.swing.JButton jButtonBuscarVehiculo;
    private javax.swing.JButton jButtonInsertarVehiculo;
    private javax.swing.JButton jButtonLimpiarTablaVehiculos;
    private javax.swing.JButton jButtonMultas;
    private javax.swing.JButton jButtonRegresarInsertar;
    private javax.swing.JButton jButtonTraspasos;
    private javax.swing.JButton jButtonVehiculos;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoInsertar;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxOpcionesVehiculos;
    private javax.swing.JComboBox<String> jComboBoxRecorrido;
    private javax.swing.JComboBox<String> jComboBoxTipoArbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelInsertarMensajes;
    private javax.swing.JLabel jLabelTiempoInsercion;
    private javax.swing.JLabel jLabelTiempoRecorrido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelCardOpcionesVehiculos;
    private javax.swing.JPanel jPanelTiemposVehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableInsertarVehiculo;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JTextField jTextFieldBuscarVehiculo;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel menuSuperior;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}