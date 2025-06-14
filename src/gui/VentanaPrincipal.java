package gui;

import controller.ControladorEstadisticas;
import controller.ControladorVehiculos;
import controller.ControladorMultas;
import controller.ControladorRendimiento;
import controller.ControladorTraspasos;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import datastructures.ListaCircular;
import datastructures.ListaDoble;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import model.Vehiculo;
import model.Multa;
import model.Traspaso;
import utils.EncriptadorArbol;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private String rutaArchivoSeleccionado;
    private String ultimoRecorridoSeleccionado = null;
    private static final String[] DEPARTAMENTOS = {
        "Suchitepequez", "Antigua_Guatemala", "Chimaltenango", "Chiquimula",
        "Escuintla", "Guatemala", "Huehuetenango", "Peten", "Quetzaltenango", "San_Marcos"
    };
    private ControladorVehiculos controlador = new ControladorVehiculos();
    private ControladorMultas controladorMultas = new ControladorMultas();
    private ControladorTraspasos controladorTraspasos = new ControladorTraspasos();
    private boolean isInicializando = false;
    private ControladorEstadisticas controladorEstadisticas = new ControladorEstadisticas();
    private ControladorRendimiento controladorRendimiento;


    public VentanaPrincipal() {
        initComponents();
        inicializarCombos();
        setLocationRelativeTo(null);
        setTitle("SIRVE | Sistema Inteligente de Registro de Vehículos y Evaluación");
        panelPrincipal.removeAll();
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        controladorRendimiento = new ControladorRendimiento(controlador, jTextAreaRendimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLateral = new javax.swing.JPanel();
        jButtonVehiculos = new javax.swing.JButton();
        jButtonMultas = new javax.swing.JButton();
        jButtonTraspasos = new javax.swing.JButton();
        jButtonEstadisticas = new javax.swing.JButton();
        jButtonRendimientoAlgoritmico = new javax.swing.JButton();
        jButtonEncriptar = new javax.swing.JButton();
        jButtonDesencriptar = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        cardPanelVisualizarEstructura = new javax.swing.JPanel();
        cardVisualizarEstructuraVacio = new javax.swing.JPanel();
        cardVisualizarEstructura = new javax.swing.JPanel();
        jButtonVisualizarEstructura = new javax.swing.JButton();
        jLabelVisualizacionArbol = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        cardPanelSuperior = new javax.swing.JPanel();
        cardSuperiorVehiculos = new javax.swing.JPanel();
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
        cardSuperiorMultas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBuscarMulta = new javax.swing.JTextField();
        jButtonBuscarMulta = new javax.swing.JButton();
        jButtonLimpiarTablaMultas = new javax.swing.JButton();
        jLabelMensajesMultas = new javax.swing.JLabel();
        jLabelTiempoMultas = new javax.swing.JLabel();
        cardSuperiorTraspasos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBuscarTraspaso = new javax.swing.JTextField();
        jButtonBuscarTraspaso = new javax.swing.JButton();
        jButtonLimpiarTablaTraspasos = new javax.swing.JButton();
        jLabelMensajesTraspasos = new javax.swing.JLabel();
        jLabelTiempoTraspasos = new javax.swing.JLabel();
        cardSuperiorEstadisticas = new javax.swing.JPanel();
        jLabelEstadisticas = new javax.swing.JLabel();
        cardSuperiorRendimiento = new javax.swing.JPanel();
        jLabelRendimiento = new javax.swing.JLabel();
        cardPanelCentral = new javax.swing.JPanel();
        cardCentralVehiculos = new javax.swing.JPanel();
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
        cardCentralMultas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableMultas = new javax.swing.JTable();
        cardCentralTraspasos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTraspasos = new javax.swing.JTable();
        cardCentralEstadisticas = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableEstadisticasMultas = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableEstadisticasTraspasos = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableEstadisticasMeses = new javax.swing.JTable();
        cardCentralRendimientoAlgoritmico = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaRendimiento = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 556));

        panelLateral.setBackground(new java.awt.Color(51, 51, 51));
        panelLateral.setPreferredSize(new java.awt.Dimension(200, 100));

        jButtonVehiculos.setBackground(new java.awt.Color(204, 204, 204));
        jButtonVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVehiculos.setText("VEHÍCULOS");
        jButtonVehiculos.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVehiculosActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonVehiculos);

        jButtonMultas.setBackground(new java.awt.Color(204, 204, 204));
        jButtonMultas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonMultas.setText("MULTAS");
        jButtonMultas.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultasActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonMultas);

        jButtonTraspasos.setBackground(new java.awt.Color(204, 204, 204));
        jButtonTraspasos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonTraspasos.setText("TRASPASOS");
        jButtonTraspasos.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraspasosActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonTraspasos);

        jButtonEstadisticas.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEstadisticas.setText("ESTADISTÍSTICAS");
        jButtonEstadisticas.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadisticasActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonEstadisticas);

        jButtonRendimientoAlgoritmico.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRendimientoAlgoritmico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRendimientoAlgoritmico.setText("<html>RENDIMIENTO<br>ALGORITMICO</html>");
        jButtonRendimientoAlgoritmico.setPreferredSize(new java.awt.Dimension(150, 45));
        jButtonRendimientoAlgoritmico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRendimientoAlgoritmicoActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonRendimientoAlgoritmico);

        jButtonEncriptar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEncriptar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEncriptar.setText("ENCRIPTAR");
        jButtonEncriptar.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonEncriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncriptarActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonEncriptar);

        jButtonDesencriptar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonDesencriptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDesencriptar.setText("DESENCRIPTAR");
        jButtonDesencriptar.setPreferredSize(new java.awt.Dimension(150, 36));
        jButtonDesencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesencriptarActionPerformed(evt);
            }
        });
        panelLateral.add(jButtonDesencriptar);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoUMG.png"))); // NOI18N
        jLabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoMouseClicked(evt);
            }
        });
        panelLateral.add(jLabelLogo);

        cardPanelVisualizarEstructura.setBackground(new java.awt.Color(51, 51, 51));
        cardPanelVisualizarEstructura.setPreferredSize(new java.awt.Dimension(150, 70));
        cardPanelVisualizarEstructura.setLayout(new java.awt.CardLayout());

        cardVisualizarEstructuraVacio.setBackground(new java.awt.Color(51, 51, 51));
        cardPanelVisualizarEstructura.add(cardVisualizarEstructuraVacio, "cardVisualizarEstructuraVacio");

        cardVisualizarEstructura.setBackground(new java.awt.Color(51, 51, 51));
        cardVisualizarEstructura.setMinimumSize(new java.awt.Dimension(270, 60));

        jButtonVisualizarEstructura.setBackground(new java.awt.Color(204, 204, 204));
        jButtonVisualizarEstructura.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButtonVisualizarEstructura.setText("<html>VISUALIZAR<br>ESTRUCTURA</html>");
        jButtonVisualizarEstructura.setPreferredSize(new java.awt.Dimension(150, 60));
        jButtonVisualizarEstructura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarEstructuraActionPerformed(evt);
            }
        });
        cardVisualizarEstructura.add(jButtonVisualizarEstructura);

        cardPanelVisualizarEstructura.add(cardVisualizarEstructura, "cardVisualizarEstructura");

        panelLateral.add(cardPanelVisualizarEstructura);

        jLabelVisualizacionArbol.setPreferredSize(new java.awt.Dimension(150, 150));
        panelLateral.add(jLabelVisualizacionArbol);

        getContentPane().add(panelLateral, java.awt.BorderLayout.WEST);

        panelPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        cardPanelSuperior.setLayout(new java.awt.CardLayout());

        cardSuperiorVehiculos.setMaximumSize(null);
        cardSuperiorVehiculos.setPreferredSize(new java.awt.Dimension(800, 65));
        cardSuperiorVehiculos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 15));

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
        cardSuperiorVehiculos.add(jComboBoxDepartamentos);

        jComboBoxTipoArbol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de arbol" }));
        jComboBoxTipoArbol.setMaximumSize(null);
        jComboBoxTipoArbol.setMinimumSize(null);
        jComboBoxTipoArbol.setPreferredSize(new java.awt.Dimension(110, 35));
        jComboBoxTipoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoArbolActionPerformed(evt);
            }
        });
        cardSuperiorVehiculos.add(jComboBoxTipoArbol);

        jComboBoxRecorrido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recorrido" }));
        jComboBoxRecorrido.setPreferredSize(new java.awt.Dimension(110, 35));
        jComboBoxRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRecorridoActionPerformed(evt);
            }
        });
        cardSuperiorVehiculos.add(jComboBoxRecorrido);

        jComboBoxOpcionesVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opciones", "Buscar", "Insertar", "Modificar", "Eliminar" }));
        jComboBoxOpcionesVehiculos.setPreferredSize(new java.awt.Dimension(90, 35));
        jComboBoxOpcionesVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpcionesVehiculosActionPerformed(evt);
            }
        });
        cardSuperiorVehiculos.add(jComboBoxOpcionesVehiculos);

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

        cardSuperiorVehiculos.add(jPanelCardOpcionesVehiculos);

        jButtonLimpiarTablaVehiculos.setText("Limpiar tabla");
        jButtonLimpiarTablaVehiculos.setPreferredSize(new java.awt.Dimension(103, 35));
        jButtonLimpiarTablaVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaVehiculosActionPerformed(evt);
            }
        });
        cardSuperiorVehiculos.add(jButtonLimpiarTablaVehiculos);

        jPanelTiemposVehiculos.setPreferredSize(new java.awt.Dimension(200, 35));
        jPanelTiemposVehiculos.setLayout(new javax.swing.BoxLayout(jPanelTiemposVehiculos, javax.swing.BoxLayout.PAGE_AXIS));
        jPanelTiemposVehiculos.add(jLabelTiempoInsercion);
        jPanelTiemposVehiculos.add(jLabelTiempoRecorrido);

        cardSuperiorVehiculos.add(jPanelTiemposVehiculos);

        cardPanelSuperior.add(cardSuperiorVehiculos, "cardSuperiorVehiculos");

        cardSuperiorMultas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 15));

        jLabel4.setText(" Ingrese la placa:");
        cardSuperiorMultas.add(jLabel4);

        jTextFieldBuscarMulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldBuscarMulta.setPreferredSize(new java.awt.Dimension(100, 30));
        cardSuperiorMultas.add(jTextFieldBuscarMulta);

        jButtonBuscarMulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBuscarMulta.setText("Buscar multas");
        jButtonBuscarMulta.setPreferredSize(new java.awt.Dimension(120, 35));
        jButtonBuscarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarMultaActionPerformed(evt);
            }
        });
        cardSuperiorMultas.add(jButtonBuscarMulta);

        jButtonLimpiarTablaMultas.setText("Limpiar Tabla");
        jButtonLimpiarTablaMultas.setPreferredSize(new java.awt.Dimension(110, 35));
        jButtonLimpiarTablaMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaMultasActionPerformed(evt);
            }
        });
        cardSuperiorMultas.add(jButtonLimpiarTablaMultas);
        cardSuperiorMultas.add(jLabelMensajesMultas);
        cardSuperiorMultas.add(jLabelTiempoMultas);

        cardPanelSuperior.add(cardSuperiorMultas, "cardSuperiorMultas");

        cardSuperiorTraspasos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 15));

        jLabel5.setText(" Ingrese la placa:");
        cardSuperiorTraspasos.add(jLabel5);

        jTextFieldBuscarTraspaso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldBuscarTraspaso.setPreferredSize(new java.awt.Dimension(100, 30));
        cardSuperiorTraspasos.add(jTextFieldBuscarTraspaso);

        jButtonBuscarTraspaso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBuscarTraspaso.setText("Buscar traspasos");
        jButtonBuscarTraspaso.setPreferredSize(new java.awt.Dimension(130, 35));
        jButtonBuscarTraspaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarTraspasoActionPerformed(evt);
            }
        });
        cardSuperiorTraspasos.add(jButtonBuscarTraspaso);

        jButtonLimpiarTablaTraspasos.setText("Limpiar Tabla");
        jButtonLimpiarTablaTraspasos.setPreferredSize(new java.awt.Dimension(110, 35));
        jButtonLimpiarTablaTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaTraspasosActionPerformed(evt);
            }
        });
        cardSuperiorTraspasos.add(jButtonLimpiarTablaTraspasos);
        cardSuperiorTraspasos.add(jLabelMensajesTraspasos);
        cardSuperiorTraspasos.add(jLabelTiempoTraspasos);

        cardPanelSuperior.add(cardSuperiorTraspasos, "cardSuperiorTraspasos");

        jLabelEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelEstadisticas.setText("<html><div style='text-align: center;'>ESTADÍSTICAS</div>Vehículo con más multas | Vehículo con más traspasos | Mes con más eventos</html>");
        cardSuperiorEstadisticas.add(jLabelEstadisticas);

        cardPanelSuperior.add(cardSuperiorEstadisticas, "cardSuperiorEstadisticas");

        cardSuperiorRendimiento.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabelRendimiento.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelRendimiento.setText("RENDIMIENTO ALGORITMICO");
        cardSuperiorRendimiento.add(jLabelRendimiento);

        cardPanelSuperior.add(cardSuperiorRendimiento, "cardSuperiorRendimiento");

        panelPrincipal.add(cardPanelSuperior, java.awt.BorderLayout.NORTH);

        cardPanelCentral.setPreferredSize(new java.awt.Dimension(800, 100));
        cardPanelCentral.setLayout(new java.awt.CardLayout());

        cardCentralVehiculos.setLayout(new java.awt.BorderLayout());

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

        cardCentralVehiculos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        cardPanelCentral.add(cardCentralVehiculos, "cardCentralVehiculos");

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

        cardPanelCentral.add(cardInsertarVehiculo, "cardInsertarVehiculo");

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

        cardPanelCentral.add(cardModificarVehiculo, "cardModificarVehiculo");

        cardCentralMultas.setLayout(new java.awt.BorderLayout());

        jTableMultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "FECHA", "DESCRIPCION", "MONTO"
            }
        ));
        jScrollPane4.setViewportView(jTableMultas);

        cardCentralMultas.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        cardPanelCentral.add(cardCentralMultas, "cardCentralMultas");

        cardCentralTraspasos.setLayout(new java.awt.BorderLayout());

        jTableTraspasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "DPI ANTERIOR", "NOMBRE ANTERIOR", "FECHA", "DPI NUEVO", "NOMBRE NUEVO"
            }
        ));
        jScrollPane5.setViewportView(jTableTraspasos);

        cardCentralTraspasos.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        cardPanelCentral.add(cardCentralTraspasos, "cardCentralTraspasos");

        cardCentralEstadisticas.setLayout(new javax.swing.BoxLayout(cardCentralEstadisticas, javax.swing.BoxLayout.LINE_AXIS));

        jTableEstadisticasMultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "CANTIDAD"
            }
        ));
        jScrollPane6.setViewportView(jTableEstadisticasMultas);

        cardCentralEstadisticas.add(jScrollPane6);

        jTableEstadisticasTraspasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "CANTIDAD"
            }
        ));
        jScrollPane7.setViewportView(jTableEstadisticasTraspasos);

        cardCentralEstadisticas.add(jScrollPane7);

        jTableEstadisticasMeses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AÑO-MES", "CANTIDAD"
            }
        ));
        jScrollPane8.setViewportView(jTableEstadisticasMeses);

        cardCentralEstadisticas.add(jScrollPane8);

        cardPanelCentral.add(cardCentralEstadisticas, "cardCentralEstadisticas");

        cardCentralRendimientoAlgoritmico.setLayout(new java.awt.BorderLayout());

        jTextAreaRendimiento.setColumns(20);
        jTextAreaRendimiento.setRows(5);
        jScrollPane9.setViewportView(jTextAreaRendimiento);

        cardCentralRendimientoAlgoritmico.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        cardPanelCentral.add(cardCentralRendimientoAlgoritmico, "cardCentralRendimientoAlgoritmico");

        panelPrincipal.add(cardPanelCentral, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Métodos de los botones para cambiar entre tarjetas de CardLayout
    private void cambiarTarjeta(String cardSuperior, String cardCentral) {
        panelPrincipal.add(cardPanelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(cardPanelCentral, BorderLayout.CENTER);

        CardLayout cl1 = (CardLayout) cardPanelSuperior.getLayout();
        cl1.show(cardPanelSuperior, cardSuperior);

        CardLayout cl2 = (CardLayout) cardPanelCentral.getLayout();
        cl2.show(cardPanelCentral, cardCentral);

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    //cuando se presiona el boton de vehiculos
    private void jButtonVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVehiculosActionPerformed
        //llamo al método para mostrar la tarjeta y le mando el nombre de las card para vehiculos
        cambiarTarjeta("cardSuperiorVehiculos", "cardCentralVehiculos");
    }//GEN-LAST:event_jButtonVehiculosActionPerformed

    // Botón "Multas"
    private void jButtonMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultasActionPerformed
        cambiarTarjeta("cardSuperiorMultas", "cardCentralMultas");
    }//GEN-LAST:event_jButtonMultasActionPerformed

    // Botón "Traspasos"
    private void jButtonTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraspasosActionPerformed
        cambiarTarjeta("cardSuperiorTraspasos", "cardCentralTraspasos");
    }//GEN-LAST:event_jButtonTraspasosActionPerformed

    // Cuando se selecciona un departamento en el ComboBox
    private void jComboBoxDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentosActionPerformed
        if (isInicializando) return;

        isInicializando = true;
        jComboBoxTipoArbol.setSelectedIndex(0); // reinicia tipoArbol
        jComboBoxRecorrido.setSelectedIndex(0); // reinicia recorrido
        limpiarTabla();
        controlador.limpiarArbol();
        isInicializando = false;

        System.out.println("Esperando que seleccione un tipo de arbol");
    }//GEN-LAST:event_jComboBoxDepartamentosActionPerformed

    // Botón para limpiar solo la tabla (no borra los datos del árbol)
    private void jButtonLimpiarTablaVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaVehiculosActionPerformed
        limpiarTabla();
    }//GEN-LAST:event_jButtonLimpiarTablaVehiculosActionPerformed

    private void jComboBoxTipoArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoArbolActionPerformed
        if (isInicializando) return;

        String tipoArbol = (String) jComboBoxTipoArbol.getSelectedItem();

        isInicializando = true;
        jComboBoxRecorrido.setSelectedIndex(0); // reinicia recorrido
        limpiarTabla();
        controlador.limpiarArbol();
        isInicializando = false;

        if (!"Binario".equals(tipoArbol) && !"AVL".equals(tipoArbol)) {
            actualizarVisualizacionEstructura();
            return;
        }

        controlador.configurarTipoArbol(tipoArbol);
        cargarDepartamentosSeleccionados(jComboBoxDepartamentos.getSelectedIndex(), false);
        actualizarVisualizacionEstructura();
    }//GEN-LAST:event_jComboBoxTipoArbolActionPerformed
   
    // Cuando se selecciona un tipo de recorrido (Inorden, Preorden, Postorden)
    private void jComboBoxRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRecorridoActionPerformed
        if (isInicializando) return;

        if (jComboBoxTipoArbol.getSelectedIndex() <= 0 ||
            jComboBoxRecorrido.getSelectedIndex() <= 0) {
            limpiarTabla();
            return;
        }

        ultimoRecorridoSeleccionado = (String) jComboBoxRecorrido.getSelectedItem();
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
        CardLayout clPrincipal = (CardLayout) cardPanelCentral.getLayout();

        switch (index) {
            case 1: // Buscar
                clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionBuscarVehiculo");
                clPrincipal.show(cardPanelCentral, "cardVehiculosABB"); // volver al panel principal
                break;
            case 2: // Insertar
                clPrincipal.show(cardPanelCentral, "cardInsertarVehiculo");
                clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionesVacio");
                break;
            case 3: // Modificar
                int filaSeleccionada = jTableVehiculos.getSelectedRow();
                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo en la tabla primero.");
                    // Vuelve al panel principal
                    clOpciones.show(jPanelCardOpcionesVehiculos, "cardOpcionesVacio");
                    clPrincipal.show(cardPanelCentral, "cardVehiculosABB");
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
                clPrincipal.show(cardPanelCentral, "cardModificarVehiculo");
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
                clPrincipal.show(cardPanelCentral, "cardVehiculosABB"); // volver al panel principal
                break;
        }
    }//GEN-LAST:event_jComboBoxOpcionesVehiculosActionPerformed

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
            jLabelTiempoInsercion.setText(String.format("Tiempo de inserción: %.4f ms", controlador.getTiempoInsercion() / 1_000_000.0));
            jLabelTiempoRecorrido.setText("");
        }
    }//GEN-LAST:event_jButtonInsertarVehiculoActionPerformed

    //método para cuando se presiona el boton de regresar
    private void jButtonRegresarInsertarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarInsertarVehiculoActionPerformed
        CardLayout cl1 = (CardLayout) cardPanelSuperior.getLayout();
        cl1.show(cardPanelSuperior, "cardSuperiorVehiculos");
        
        CardLayout cl2 = (CardLayout) cardPanelCentral.getLayout();
        cl2.show(cardPanelCentral, "cardCentralVehiculos");
        
        //reiniciar el label de mensajes
        jLabelInsertarMensajes.setText("");
        jLabelTiempoInsercion.setText("");
        jLabelTiempoRecorrido.setText("");
        
        isInicializando = true; // empieza a ignorar eventos
        //reiniciar el combo box de las opciones y departamentos
        jComboBoxOpcionesVehiculos.setSelectedIndex(0);
        jComboBoxDepartamentoInsertar.setSelectedIndex(0);
        jComboBoxDepartamentos.setSelectedIndex(0);
        jComboBoxTipoArbol.setSelectedIndex(0);
        jComboBoxRecorrido.setSelectedIndex(0);
        isInicializando = false; // ya puede procesar eventos otra vez
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
            jLabelTiempoInsercion.setText(String.format("Tiempo de modificación: %.4f ms", controlador.getTiempoInsercion() / 1_000_000.0));
            jLabelTiempoRecorrido.setText("");  // Limpiar el tiempo de recorrido
        }
    }//GEN-LAST:event_jButtonModificarVehiculoActionPerformed

    private void jButtonRegresarModificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarModificarVehiculoActionPerformed
        CardLayout cl1 = (CardLayout) cardPanelSuperior.getLayout();
        cl1.show(cardPanelSuperior, "cardSuperiorVehiculos");
        
        CardLayout cl2 = (CardLayout) cardPanelCentral.getLayout();
        cl2.show(cardPanelCentral, "cardCentralVehiculos");
        
        //reiniciar el label de mensajes
        jLabelModificarMensajes.setText("");
        jLabelTiempoInsercion.setText("");
        jLabelTiempoRecorrido.setText("");

        //reiniciar el combo box de las opciones y departamentos
        jComboBoxOpcionesVehiculos.setSelectedIndex(0);
        jComboBoxDepartamentoModificar.setSelectedIndex(0);
        jComboBoxDepartamentos.setSelectedIndex(0);
        jComboBoxTipoArbol.setSelectedIndex(0);
        jComboBoxRecorrido.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonRegresarModificarVehiculoActionPerformed

    private void jButtonBuscarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarMultaActionPerformed
        String placa = jTextFieldBuscarMulta.getText().trim();

        if (placa.isEmpty()) {
            jLabelMensajesMultas.setText("Debe ingresar la placa del vehículo.");
            limpiarTablaMultas();
            jLabelTiempoMultas.setText(""); // limpia tiempo anterior
            return;
        }

        long inicioBusqueda = System.nanoTime();

        ListaDoble<Multa> listaMultas = controladorMultas.cargarMultasPorPlaca(placa);

        long finBusqueda = System.nanoTime();
        double tiempoBusqueda = (finBusqueda - inicioBusqueda) / 1_000_000.0;

        // SIEMPRE limpia la tabla antes de actualizarla
        limpiarTablaMultas();

        if (listaMultas.getTamaño() == 0) {
            jLabelMensajesMultas.setText("No se encontraron multas para la placa: " + placa);
        } else {
            llenarTablaMultas(listaMultas);
            jLabelMensajesMultas.setText("Multas cargadas correctamente.");
        }

        jLabelTiempoMultas.setText(String.format("Tiempo de búsqueda: %.3f ms", tiempoBusqueda));
    }//GEN-LAST:event_jButtonBuscarMultaActionPerformed

    private void jButtonLimpiarTablaMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaMultasActionPerformed
        limpiarTablaMultas();
    }//GEN-LAST:event_jButtonLimpiarTablaMultasActionPerformed

    private void jButtonBuscarTraspasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarTraspasoActionPerformed
    String placa = jTextFieldBuscarTraspaso.getText().trim();

    if (placa.isEmpty()) {
        jLabelMensajesTraspasos.setText("Debe ingresar la placa del vehículo.");
        limpiarTablaTraspasos();
        return;
    }

    long inicioBusqueda = System.nanoTime();

    ListaCircular<Traspaso> traspasos = controladorTraspasos.cargarTraspasosPorPlaca(placa);

    long finBusqueda = System.nanoTime();
    double tiempoBusqueda = (finBusqueda - inicioBusqueda) / 1_000_000.0;

    limpiarTablaTraspasos();

    if (traspasos.getTamaño() == 0) {
        jLabelMensajesTraspasos.setText("No se encontraron traspasos para la placa: " + placa);
    } else {
        llenarTablaTraspasos(traspasos);
        jLabelMensajesTraspasos.setText("Traspasos cargados correctamente.");
    }

    jLabelTiempoTraspasos.setText(String.format("Tiempo de búsqueda: %.3f ms", tiempoBusqueda));
    }//GEN-LAST:event_jButtonBuscarTraspasoActionPerformed

    private void jButtonLimpiarTablaTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaTraspasosActionPerformed
        limpiarTablaTraspasos();
    }//GEN-LAST:event_jButtonLimpiarTablaTraspasosActionPerformed

    private void jLabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoMouseClicked
        panelPrincipal.removeAll();
        panelPrincipal.revalidate();
        panelPrincipal.repaint();// TODO add your handling code here:
    }//GEN-LAST:event_jLabelLogoMouseClicked

    private void jButtonVisualizarEstructuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarEstructuraActionPerformed
        String tipoArbol = (String) jComboBoxTipoArbol.getSelectedItem(); // "Binario" o "AVL"
        controlador.generarVisualizacionArbol(tipoArbol);
    }//GEN-LAST:event_jButtonVisualizarEstructuraActionPerformed

    private void jButtonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadisticasActionPerformed
        controladorEstadisticas.generarEstadisticas(controlador, 
                                                   jTableEstadisticasMultas, 
                                                   jTableEstadisticasTraspasos, 
                                                   jTableEstadisticasMeses);
        
        cambiarTarjeta("cardSuperiorEstadisticas", "cardCentralEstadisticas");
    }//GEN-LAST:event_jButtonEstadisticasActionPerformed

    private void jButtonRendimientoAlgoritmicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRendimientoAlgoritmicoActionPerformed
        // Llamamos al controlador de rendimiento para realizar la comparación
    String resultado = controladorRendimiento.realizarComparacionRendimiento();

    // Mostramos el resultado en el JTextArea
    jTextAreaRendimiento.setText(resultado);  // Primero mostramos el resumen de rendimiento

    // Cambiamos a la tarjeta correspondiente para mostrar los resultados
    cambiarTarjeta("cardSuperiorRendimiento", "cardCentralRendimientoAlgoritmico");
    }//GEN-LAST:event_jButtonRendimientoAlgoritmicoActionPerformed

    private void jButtonEncriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncriptarActionPerformed
        // Verificar que haya un árbol seleccionado
    if (controlador.getArbol() == null) {
        JOptionPane.showMessageDialog(this, "No hay árbol seleccionado.");
        return;
    }

    // Obtener el tipo de árbol (Binario o AVL)
    String tipoArbol = controlador.getTipoArbolConfigurado();
    if (tipoArbol == null || tipoArbol.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de árbol.");
        return;
    }

    // Llamar al método de EncriptadorArbol para encriptar y guardar el árbol usando César
    EncriptadorArbol.encriptarArbol(controlador.getArbol(), tipoArbol);

    // Mensaje de confirmación
    JOptionPane.showMessageDialog(this, "Árbol encriptado y guardado correctamente.");
    }//GEN-LAST:event_jButtonEncriptarActionPerformed

    private void jButtonDesencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesencriptarActionPerformed
    // Verificar que haya un árbol seleccionado
    if (controlador.getArbol() == null) {
        JOptionPane.showMessageDialog(this, "No hay árbol seleccionado.");
        return;
    }

    // Obtener el tipo de árbol (Binario o AVL)
    String tipoArbol = controlador.getTipoArbolConfigurado();
    if (tipoArbol == null || tipoArbol.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de árbol.");
        return;
    }

    // Verificar si el archivo está encriptado
    if (!EncriptadorArbol.esArchivoEncriptado(tipoArbol)) {
        JOptionPane.showMessageDialog(this, "El archivo no está encriptado.");
        return;
    }

    // Llamar al método de EncriptadorArbol para desencriptar
    EncriptadorArbol.desencriptarArbol(controlador.getArbol(), tipoArbol);

    // Mensaje de confirmación
    JOptionPane.showMessageDialog(this, "Árbol desencriptado y restaurado correctamente.");
    }//GEN-LAST:event_jButtonDesencriptarActionPerformed

    //Realiza el recorrido seleccionado y actualiza la tabla con los resultados
    private void realizarRecorridoYMostrarTabla() {
        // Verificamos que se haya seleccionado un recorrido y un tipo de árbol válidos
        if (ultimoRecorridoSeleccionado != null && jComboBoxTipoArbol.getSelectedIndex() > 0) {
            // Realiza el recorrido dependiendo del tipo de árbol
            List<Vehiculo> lista = null;
            if ("Binario".equals(jComboBoxTipoArbol.getSelectedItem()) || "AVL".equals(jComboBoxTipoArbol.getSelectedItem())) {
                // Según el tipo de recorrido, se llama al método correspondiente
                switch (ultimoRecorridoSeleccionado) {
                    case "Inorden":
                        lista = controlador.obtenerVehiculosInorden();
                        break;
                    case "Preorden":
                        lista = controlador.obtenerVehiculosPreorden();
                        break;
                    case "Postorden":
                        lista = controlador.obtenerVehiculosPostorden();
                        break;
                    default:
                        break;
                }
            }

            // Solo mostrar tiempo de recorrido si se está haciendo realmente un recorrido
            if (lista != null) {
                double tiempoMilisRecorrido = controlador.getTiempoRecorrido() / 1_000_000.0;
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
    
    private void llenarTablaMultas(ListaDoble<Multa> listaMultas) {
        DefaultTableModel modelo = (DefaultTableModel) jTableMultas.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        // Obtener una lista normal de multas
        List<Multa> multas = listaMultas.obtenerLista();

        // Agregar las multas a la tabla
        for (Multa multa : multas) {
            modelo.addRow(new Object[]{
                multa.getPlaca(), multa.getFecha(), multa.getDescripcion(), multa.getMonto()
            });
        }
    }
    
    private void llenarTablaTraspasos(ListaCircular<Traspaso> traspasos) {
        DefaultTableModel modelo = (DefaultTableModel) jTableTraspasos.getModel();
        modelo.setRowCount(0);

        for (Traspaso t : traspasos.obtenerLista()) {
            modelo.addRow(new Object[]{
                t.getPlaca(), t.getDpiAnterior(), t.getNombreAnterior(),
                t.getFecha(), t.getDpiNuevo(), t.getNombreNuevo()
            });
        }
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
    
    private void cargarDepartamentosSeleccionados(int index, boolean esModificacion) {
        String tipoArbol = (String) jComboBoxTipoArbol.getSelectedItem();
        if (!"Binario".equals(tipoArbol) && !"AVL".equals(tipoArbol)) {
            System.out.println("Seleccione primero un tipo de arbol (Binario o AVL)");
            return;
        }

        // Verifica si el tipo actual es diferente al configurado
        if (!tipoArbol.equals(controlador.getTipoArbolConfigurado())) {
            controlador.configurarTipoArbol(tipoArbol);
        } 

        controlador.limpiarArbol();

        if (index == 0) {
            long inicio = System.nanoTime();
            for (String departamento : DEPARTAMENTOS) {
                String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
                controlador.cargarVehiculosDesdeArchivo(ruta);
            }
            long fin = System.nanoTime();
            if (!esModificacion) {
                jLabelTiempoInsercion.setText(String.format("Tiempo de carga: %.3f ms", (fin - inicio) / 1_000_000.0));
            }
        } else {
            String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            long inicio = System.nanoTime();
            controlador.cargarVehiculosDesdeArchivo(ruta);
            long fin = System.nanoTime();
            if (!esModificacion) {
                jLabelTiempoInsercion.setText(String.format("Tiempo de carga: %.3f ms", (fin - inicio) / 1_000_000.0));
            }
        }

        int altura = controlador.getAlturaArbolActual();
        System.out.println("Altura: " + altura);
    }
        
    private void eliminarVehiculo(String placa) {
        // Obtener el índice seleccionado en el JComboBox
        int departamentoIndex = jComboBoxDepartamentos.getSelectedIndex();

        long inicio = System.nanoTime();  // Comienza a medir el tiempo

        // Verificar si se ha seleccionado un departamento específico o "Todos los departamentos"
        if (departamentoIndex == 0) {
            // Caso cuando se elige "Todos los departamentos"
            // Buscar el vehículo en todos los departamentos
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
            // Caso cuando se selecciona un departamento específico
            String departamento = (String) jComboBoxDepartamentos.getSelectedItem();
            if (departamento == null || departamento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un departamento primero.");
                return;
            }

            // Construir la ruta del archivo para el departamento seleccionado
            String ruta = "SIRVE_Datos_Vehiculos_DataSet/" + departamento + "/" + departamento + "_vehiculos.txt";
            // Llamar al método para eliminar el vehículo en el archivo
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
    
    private void actualizarVisualizacionEstructura() {
        CardLayout cl = (CardLayout) cardPanelVisualizarEstructura.getLayout();
        String tipoSeleccionado = (String) jComboBoxTipoArbol.getSelectedItem();

        if ("Binario".equals(tipoSeleccionado) || "AVL".equals(tipoSeleccionado)) {
            cl.show(cardPanelVisualizarEstructura, "cardVisualizarEstructura");
        } else {
            cl.show(cardPanelVisualizarEstructura, "cardVisualizarEstructuraVacio");
        }
    }

    //devuelve la ruta del archivo seleccionado en el combo box departamento
    public String getRutaArchivoSeleccionado() {
        return rutaArchivoSeleccionado;
    }
    
    // Limpia la tabla sin borrar el árbol de datos
    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTableVehiculos.getModel();
        modelo.setRowCount(0);
    }
    
    // Método auxiliar para limpiar la tabla de multas
    private void limpiarTablaMultas() {
        DefaultTableModel modelo = (DefaultTableModel) jTableMultas.getModel();
        modelo.setRowCount(0);
        jLabelMensajesMultas.setText("");
        jLabelTiempoMultas.setText("");
    }
    
    private void limpiarTablaTraspasos() {
        DefaultTableModel modelo = (DefaultTableModel) jTableTraspasos.getModel();
        modelo.setRowCount(0);
        jLabelMensajesTraspasos.setText("");
        jLabelTiempoTraspasos.setText("");
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
    private javax.swing.JPanel cardCentralEstadisticas;
    private javax.swing.JPanel cardCentralMultas;
    private javax.swing.JPanel cardCentralRendimientoAlgoritmico;
    private javax.swing.JPanel cardCentralTraspasos;
    private javax.swing.JPanel cardCentralVehiculos;
    private javax.swing.JPanel cardInsertarVehiculo;
    private javax.swing.JPanel cardModificarVehiculo;
    private javax.swing.JPanel cardOpcionBuscarVehiculo;
    private javax.swing.JPanel cardPanelCentral;
    private javax.swing.JPanel cardPanelSuperior;
    private javax.swing.JPanel cardPanelVisualizarEstructura;
    private javax.swing.JPanel cardSuperiorEstadisticas;
    private javax.swing.JPanel cardSuperiorMultas;
    private javax.swing.JPanel cardSuperiorRendimiento;
    private javax.swing.JPanel cardSuperiorTraspasos;
    private javax.swing.JPanel cardSuperiorVehiculos;
    private javax.swing.JPanel cardVisualizarEstructura;
    private javax.swing.JPanel cardVisualizarEstructuraVacio;
    private javax.swing.JButton jButtonBuscarMulta;
    private javax.swing.JButton jButtonBuscarTraspaso;
    private javax.swing.JButton jButtonBuscarVehiculo;
    private javax.swing.JButton jButtonDesencriptar;
    private javax.swing.JButton jButtonEncriptar;
    private javax.swing.JButton jButtonEstadisticas;
    private javax.swing.JButton jButtonInsertarVehiculo;
    private javax.swing.JButton jButtonLimpiarTablaMultas;
    private javax.swing.JButton jButtonLimpiarTablaTraspasos;
    private javax.swing.JButton jButtonLimpiarTablaVehiculos;
    private javax.swing.JButton jButtonModificarVehiculo;
    private javax.swing.JButton jButtonMultas;
    private javax.swing.JButton jButtonRegresarInsertarVehiculo;
    private javax.swing.JButton jButtonRegresarModificarVehiculo;
    private javax.swing.JButton jButtonRendimientoAlgoritmico;
    private javax.swing.JButton jButtonTraspasos;
    private javax.swing.JButton jButtonVehiculos;
    private javax.swing.JButton jButtonVisualizarEstructura;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoInsertar;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoModificar;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JComboBox<String> jComboBoxOpcionesVehiculos;
    private javax.swing.JComboBox<String> jComboBoxRecorrido;
    private javax.swing.JComboBox<String> jComboBoxTipoArbol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelEstadisticas;
    private javax.swing.JLabel jLabelInsertarMensajes;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMensajesMultas;
    private javax.swing.JLabel jLabelMensajesTraspasos;
    private javax.swing.JLabel jLabelModificarMensajes;
    private javax.swing.JLabel jLabelRendimiento;
    private javax.swing.JLabel jLabelTiempoInsercion;
    private javax.swing.JLabel jLabelTiempoMultas;
    private javax.swing.JLabel jLabelTiempoRecorrido;
    private javax.swing.JLabel jLabelTiempoTraspasos;
    private javax.swing.JLabel jLabelVisualizacionArbol;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableEstadisticasMeses;
    private javax.swing.JTable jTableEstadisticasMultas;
    private javax.swing.JTable jTableEstadisticasTraspasos;
    private javax.swing.JTable jTableInsertarVehiculo;
    private javax.swing.JTable jTableModificarVehiculo;
    private javax.swing.JTable jTableMultas;
    private javax.swing.JTable jTableTraspasos;
    private javax.swing.JTable jTableVehiculos;
    private javax.swing.JTextArea jTextAreaRendimiento;
    private javax.swing.JTextField jTextFieldBuscarMulta;
    private javax.swing.JTextField jTextFieldBuscarTraspaso;
    private javax.swing.JTextField jTextFieldBuscarVehiculo;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}