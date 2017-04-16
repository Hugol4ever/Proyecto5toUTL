package app;

import Animacion.Fade;
import com.digitalpersona.onetouch.DPFPTemplate;
import controlador.ClientesController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.table.JTableHeader;
import modelo.DAO.Cliente;
import modelo.DAO.Usuario;
import modelo.DTO.DTOCliente;

/**
 *
 * @author bvsr9
 */
public class Clientes extends javax.swing.JFrame {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private DPFPTemplate template;
    private ClientesController clienteC;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     */
    public Clientes() {
        setUndecorated(true);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        encabezado();
        this.clienteC = new ClientesController(jTable1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * Método para decorar el encabezado de la tabla
     */
    public void encabezado() {
        JTableHeader th = jTable1.getTableHeader();
        th.setFont(new Font("Segoe Print", 1, 14));
        th.setForeground(Color.DARK_GRAY);
    }
    
    /**
     * 
     */
    private void limpiar() {
        this.txtNombre.setText(null);
        this.txtCorreo.setText(null);
        this.txtTel.setText(null);
        this.txtContraseña.setText(null);
        this.txtNTarjeta.setText(null);
        this.labHuella.setIcon(null);
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelSalir = new javax.swing.JPanel();
        btnSalir1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtNTarjeta = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        txtLimiteSaldo = new javax.swing.JTextField();
        txtSaldoDisponible = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        labHuella = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnHuella = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 51, 103));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(26, 51, 103));
        jPanel3.setFocusCycleRoot(true);

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CLIENTES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente2small.png"))); // NOI18N

        jPanelSalir.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSalir.setMaximumSize(new java.awt.Dimension(106, 100));
        jPanelSalir.setMinimumSize(new java.awt.Dimension(106, 100));
        jPanelSalir.setLayout(null);

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnSalir1.setBorderPainted(false);
        btnSalir1.setContentAreaFilled(false);
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalir1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalir1MouseExited(evt);
            }
        });
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanelSalir.add(btnSalir1);
        btnSalir1.setBounds(-40, 20, 106, 73);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        txtNTarjeta.setBackground(new java.awt.Color(251, 245, 135));
        txtNTarjeta.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtNTarjeta.setBorder(null);
        txtNTarjeta.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtNTarjeta);
        txtNTarjeta.setBounds(220, 400, 180, 30);

        txtTel.setBackground(new java.awt.Color(251, 245, 135));
        txtTel.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtTel.setBorder(null);
        txtTel.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtTel);
        txtTel.setBounds(180, 200, 220, 30);

        txtCorreo.setBackground(new java.awt.Color(251, 245, 135));
        txtCorreo.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtCorreo.setBorder(null);
        txtCorreo.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtCorreo);
        txtCorreo.setBounds(180, 240, 220, 30);

        txtNombre.setBackground(new java.awt.Color(251, 245, 135));
        txtNombre.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtNombre);
        txtNombre.setBounds(180, 120, 220, 30);

        txtContraseña.setBackground(new java.awt.Color(251, 245, 135));
        txtContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtContraseña.setBorder(null);
        txtContraseña.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtContraseña);
        txtContraseña.setBounds(180, 280, 220, 30);

        txtLimiteSaldo.setBackground(new java.awt.Color(251, 245, 135));
        txtLimiteSaldo.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtLimiteSaldo.setBorder(null);
        txtLimiteSaldo.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtLimiteSaldo);
        txtLimiteSaldo.setBounds(180, 320, 220, 30);

        txtSaldoDisponible.setBackground(new java.awt.Color(251, 245, 135));
        txtSaldoDisponible.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtSaldoDisponible.setBorder(null);
        txtSaldoDisponible.setSelectionColor(new java.awt.Color(251, 245, 134));
        jPanel5.add(txtSaldoDisponible);
        txtSaldoDisponible.setBounds(220, 360, 180, 30);

        jPanel7.setBackground(new java.awt.Color(251, 245, 135));

        jRadioButton3.setBackground(new java.awt.Color(251, 245, 135));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        jRadioButton3.setText("Masculino");
        jRadioButton3.setBorder(null);
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioButton4.setBackground(new java.awt.Color(251, 245, 135));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        jRadioButton4.setText("Femenino");
        jRadioButton4.setBorder(null);
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jRadioButton4)
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButton4))
        );

        jPanel5.add(jPanel7);
        jPanel7.setBounds(180, 160, 230, 23);

        labHuella.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        jPanel5.add(labHuella);
        labHuella.setBounds(160, 460, 120, 90);

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 0, 26)); // NOI18N
        jLabel10.setText("Datos de cliente");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(130, 40, 180, 34);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro1.png"))); // NOI18N
        jPanel5.add(jLabel9);
        jLabel9.setBounds(10, 0, 420, 600);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 0, 20))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(251, 245, 135));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnbuscar1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 17)); // NOI18N
        jLabel2.setText("Buscar por:");

        jComboBox1.setBackground(new java.awt.Color(51, 153, 255));
        jComboBox1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Usuario", "Todos" }));
        jComboBox1.setBorder(null);

        jTextField1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(26, 51, 103));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9);
        jPanel9.setBounds(0, 0, 10, 370);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.PNG"))); // NOI18N
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel8.add(btnLimpiar);
        btnLimpiar.setBounds(-70, 0, 150, 83);

        btnHuella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/huella.PNG"))); // NOI18N
        btnHuella.setBorderPainted(false);
        btnHuella.setContentAreaFilled(false);
        btnHuella.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuella.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuellaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuellaMouseExited(evt);
            }
        });
        btnHuella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuellaActionPerformed(evt);
            }
        });
        jPanel8.add(btnHuella);
        btnHuella.setBounds(-70, 90, 150, 83);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.PNG"))); // NOI18N
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel8.add(btnAgregar);
        btnAgregar.setBounds(-70, 190, 150, 83);

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnReporte.png"))); // NOI18N
        btnReporte.setBorderPainted(false);
        btnReporte.setContentAreaFilled(false);
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.add(btnReporte);
        btnReporte.setBounds(30, 420, 160, 83);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnModificar.png"))); // NOI18N
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        jPanel8.add(btnModificar);
        btnModificar.setBounds(-70, 290, 150, 81);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Métodos auto-generados">
    /**
     * Método para salir de la ventana
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        Fade.JFrameFadeOut(1f, 0f, 0.1f, 70, this, Fade.DISPOSE);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    /**
     * Método para hacer animación cuando el mouse pase por el botón salir
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalir1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir1MouseEntered
        Animacion.Animacion.mover_derecha(-40, 0, 3, 2, btnSalir1);
    }//GEN-LAST:event_btnSalir1MouseEntered

    /**
     * Método para hacer animación cuando el mouse salfo del botón salir
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalir1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir1MouseExited
        Animacion.Animacion.mover_izquierda(0, -40, 3, 2, btnSalir1);
    }//GEN-LAST:event_btnSalir1MouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        Animacion.Animacion.mover_derecha(-70, 10, 3, 2, btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        Animacion.Animacion.mover_izquierda(10, -70, 3, 2, btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnHuellaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuellaMouseEntered
        Animacion.Animacion.mover_derecha(-70, 10, 3, 2, btnHuella);
    }//GEN-LAST:event_btnHuellaMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnHuellaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuellaMouseExited
        Animacion.Animacion.mover_izquierda(10, -70, 3, 2, btnHuella);
    }//GEN-LAST:event_btnHuellaMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        Animacion.Animacion.mover_derecha(-70, 10, 3, 2, btnAgregar);
    }//GEN-LAST:event_btnAgregarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        Animacion.Animacion.mover_izquierda(10, -70, 3, 2, btnAgregar);
    }//GEN-LAST:event_btnAgregarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        Animacion.Animacion.mover_derecha(-70, 10, 3, 2, btnModificar);
    }//GEN-LAST:event_btnModificarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        Animacion.Animacion.mover_izquierda(10, -70, 3, 2, btnModificar);
    }//GEN-LAST:event_btnModificarMouseExited

    /**
     * 
     * 
     * @param evt 
     */
    private void btnHuellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuellaActionPerformed
        Huella huella = new Huella();
        huella.setClientes(this);
        huella.getBtnVerificar().setVisible(false);
        huella.setVisible(true);
    }//GEN-LAST:event_btnHuellaActionPerformed

    /**
     * 
     * 
     * @param evt 
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre(this.txtNombre.getText());
            cliente.setCorreo(this.txtCorreo.getText());
            cliente.setTelefono(this.txtTel.getText());
            if (this.jRadioButton3.isSelected()) {
                cliente.setGenero("Masculino");
            } else {
                cliente.setGenero("Femenino");
            }
            cliente.setNoTarjeta(this.txtNTarjeta.getText());
            cliente.setUsuario(new Usuario());
            cliente.getUsuario().setHuella(new modelo.DAO.Huella());
            cliente.getUsuario().getHuella().setTemplate(this.template);
            DTOCliente dto = new DTOCliente();
            if (dto.registrarCliente(cliente)) {
                //JOptionPane.showMessageDialog(null, "Se registró se ha agregado con éxito");
                MensajeConfirmacion mc = new MensajeConfirmacion();
                mc.setMensaje("Se registró se ha agregado con éxito");
                mc.setVisible(true);
                limpiar();
            } else {
                MensajeError m = new MensajeError();
                m.setMensaje("Ocurrió un error");
                m.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        } catch (Exception ex) {
            MensajeError m = new MensajeError();
                m.setMensaje(ex.getMessage());
                m.setVisible(true);
            //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clienteC = new ClientesController(jTable1);
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * 
     * 
     * @param evt 
     */
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * 
     * 
     * @param evt 
     */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Método main">
    /**
     * 
     * 
     * @param args 
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Clientes().setVisible(true);
        });
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Atributos auto-generados">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnHuella;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelSalir;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labHuella;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtLimiteSaldo;
    private javax.swing.JTextField txtNTarjeta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldoDisponible;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos Get y Set">
    /**
     * 
     * 
     * @param template 
     */
    public void setTemplate(DPFPTemplate template) {
        this.template = template;
    }
    
    /**
     * 
     */
    public void setCorrecto() {
        Image foto = Toolkit.getDefaultToolkit().getImage(".//src/img/correcto.png");
        this.labHuella.setIcon(new ImageIcon(foto.getScaledInstance(190, 150, 0)));
    }
    //</editor-fold>
    
}