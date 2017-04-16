package app;

import Animacion.Fade;
import commons.Globals;
import controlador.FotoClienteSocket;
import controlador.ProductosController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.JTableHeader;
import modelo.DAO.Producto;

/**
 *
 * @author bvsr9
 */
public class Productos extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ProductosController productosC;
    private String rutaFoto;
    private String nombreFoto;
    private FotoClienteSocket fotoS;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     */
    public Productos() {
        setUndecorated(true);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        encabezado();
        this.productosC = new ProductosController(this.tblProductos);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * 
     */
    public void encabezado() {
        JTableHeader th = tblProductos.getTableHeader();
        th.setFont(new Font("Segoe Print", 1, 14));
        th.setForeground(Color.DARK_GRAY);
    }
    
    /**
     * 
     */
    public void limpiar() {
        this.txtCodigo.setText(null);
        this.txtMarca.setText(null);
        this.txtMarca.setText(null);
        this.txtCategoria.setText(null);
        this.txtPrecio.setText(null);
        this.txtExistencia.setText(null);
        this.jLabel12.setIcon(null);
    }
    
    public void cargarTabla() {
        
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelSalir = new javax.swing.JPanel();
        btnSalir1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 51, 103));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(26, 51, 103));

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCTOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(431, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito2small.png"))); // NOI18N

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 0, 20))); // NOI18N

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProductos.setGridColor(new java.awt.Color(251, 245, 135));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnbuscar1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 17)); // NOI18N
        jLabel2.setText("Buscar por:");

        jComboBox1.setBackground(new java.awt.Color(51, 153, 255));
        jComboBox1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Marca", "Categoría", "Código de Producto", "Todos *" }));

        jTextField1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, 187, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(jScrollPane1))
                .addGap(7, 7, 7))
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
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

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
        btnLimpiar.setBounds(-70, 10, 150, 83);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.PNG"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel8.add(btnGuardar);
        btnGuardar.setBounds(0, 10, 150, 83);

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
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel8.add(btnModificar);
        btnModificar.setBounds(70, 10, 150, 81);

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnReporte.png"))); // NOI18N
        btnReporte.setBorderPainted(false);
        btnReporte.setContentAreaFilled(false);
        jPanel8.add(btnReporte);
        btnReporte.setBounds(470, 10, 150, 80);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/promo1.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2);
        jButton2.setBounds(300, 10, 160, 83);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/marco.png"))); // NOI18N
        jPanel5.add(jLabel11);
        jLabel11.setBounds(380, 150, 210, 170);
        jPanel5.add(jLabel12);
        jLabel12.setBounds(390, 160, 190, 150);

        btnFoto.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPhoto.png"))); // NOI18N
        btnFoto.setText("<html><p align=center>Añadir<br>Foto</p></html>");
        btnFoto.setBorderPainted(false);
        btnFoto.setContentAreaFilled(false);
        btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        jPanel5.add(btnFoto);
        btnFoto.setBounds(400, 330, 170, 61);

        txtCodigo.setBackground(new java.awt.Color(251, 245, 135));
        txtCodigo.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtCodigo.setBorder(null);
        txtCodigo.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel5.add(txtCodigo);
        txtCodigo.setBounds(130, 110, 160, 20);

        txtMarca.setBackground(new java.awt.Color(251, 245, 135));
        txtMarca.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtMarca.setBorder(null);
        txtMarca.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtMarca);
        txtMarca.setBounds(140, 190, 170, 20);

        txtNombre.setBackground(new java.awt.Color(251, 245, 135));
        txtNombre.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtNombre);
        txtNombre.setBounds(130, 150, 240, 20);

        txtCategoria.setBackground(new java.awt.Color(251, 245, 135));
        txtCategoria.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtCategoria.setBorder(null);
        txtCategoria.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtCategoria);
        txtCategoria.setBounds(140, 230, 180, 20);

        txtPrecio.setBackground(new java.awt.Color(251, 245, 135));
        txtPrecio.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtPrecio.setBorder(null);
        txtPrecio.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtPrecio);
        txtPrecio.setBounds(140, 270, 170, 20);

        txtExistencia.setBackground(new java.awt.Color(251, 245, 135));
        txtExistencia.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtExistencia.setBorder(null);
        txtExistencia.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtExistencia);
        txtExistencia.setBounds(140, 320, 170, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datosProducto1.png"))); // NOI18N
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 30, 610, 410);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        Fade.JFrameFadeOut(1f, 0f, 0.1f, 70, this, Fade.DISPOSE);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalir1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir1MouseEntered
        Animacion.Animacion.mover_derecha(-40, 0, 3, 2, btnSalir1);
    }//GEN-LAST:event_btnSalir1MouseEntered

    /**
     * 
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
        Animacion.Animacion.mover_derecha(-70, 0, 3, 2, btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        Animacion.Animacion.mover_izquierda(0, -70, 3, 2, btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String parametro = this.jComboBox1.getSelectedItem().toString();
        String valor = this.jTextField1.getText();
        switch (parametro) {
            case "Todos *":
                this.productosC = new ProductosController(this.tblProductos);
                break;
            case "Categoría":
                this.productosC.obtenerProductos("Categoria", valor);
                break;
            case "Código de Producto":
                this.productosC.obtenerProductos("Id_Producto", valor);
                break;
            default:
                this.productosC.obtenerProductos(parametro, valor);
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        String valor = this.tblProductos.getValueAt(this.tblProductos.getSelectedRow(), 0).toString();
        if (!valor.isEmpty()) {
            try {
                int id = Integer.parseInt(valor);
                String[] datos = this.productosC.mostrarFoto(id);
                this.txtCodigo.setText(datos[0]);
                this.txtMarca.setText(datos[1]);
                this.txtMarca.setText(datos[2]);
                this.txtCategoria.setText(datos[3]);
                this.txtExistencia.setText(datos[4]);
                this.txtPrecio.setText(datos[5]);
                URL url = new URL(Globals.SERVIDOR_IMAGENES + datos[6]);
                Image foto = ImageIO.read(url);
                this.jLabel12.setIcon(new ImageIcon(foto.getScaledInstance(190, 150, 0)));
                this.nombreFoto = datos[6];
            } catch (MalformedURLException ex) {
                //Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                MensajeError m = new MensajeError();
                m.setMensaje(ex.getMessage());
                m.setVisible(true);
            } catch (IOException ex) {
                //Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                MensajeError m = new MensajeError();
                m.setMensaje(ex.getMessage());
                m.setVisible(true);
            }
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        Animacion.Animacion.mover_derecha(0, 80, 3, 2, btnGuardar);
    }//GEN-LAST:event_btnGuardarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        Animacion.Animacion.mover_izquierda(80, 0, 3, 2, btnGuardar);
    }//GEN-LAST:event_btnGuardarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        Animacion.Animacion.mover_derecha(70, 150, 3, 2, btnModificar);
    }//GEN-LAST:event_btnModificarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
         Animacion.Animacion.mover_izquierda(150, 70, 3, 2, btnModificar);
    }//GEN-LAST:event_btnModificarMouseExited

    /**
     * 
     * 
     * @param evt 
     */
    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this);
            this.rutaFoto = chooser.getSelectedFile().getAbsolutePath();
            this.nombreFoto = chooser.getSelectedFile().getName().replace(' ', '_');
            Image foto = Toolkit.getDefaultToolkit().getImage(this.rutaFoto);
            this.jLabel12.setIcon(new ImageIcon(foto.getScaledInstance(190, 150, 0)));
            this.fotoS = new FotoClienteSocket(this.rutaFoto);
            this.fotoS.start();
        } catch (IOException ex) {
            //Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError m = new MensajeError();
            m.setMensaje(ex.getMessage());
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    /**
     * 
     * 
     * @param evt 
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            this.fotoS.enviar(this.nombreFoto);
            this.fotoS.enviarFoto();
            Producto p = new Producto();
            p.setIdProducto(Integer.parseInt(this.txtCodigo.getText()));
            p.setNombre(this.txtMarca.getText());
            p.setMarca(this.txtMarca.getText());
            p.setCategoria(this.txtCategoria.getText());
            p.setPrecio(Double.parseDouble(this.txtPrecio.getText()));
            p.setExistencia(Integer.parseInt(this.txtExistencia.getText()));
            p.setFoto(this.nombreFoto);
            if (this.productosC.registrarProducto(p)) {
                MensajeConfirmacion mc = new MensajeConfirmacion();
                mc.setMensaje("Producto registrado con éxito");
                mc.setVisible(true);
                limpiar();
            } else {
                MensajeError m = new MensajeError();
                m.setMensaje("Ocurrió un error al registrar producto."
                        + "\nIntentelo de nuevo.");
                m.setVisible(true);
            }
            this.productosC = new ProductosController(this.tblProductos);
        } catch (IOException ex) {
            //Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError m = new MensajeError();
            m.setMensaje(ex.getMessage());
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (this.fotoS != null && this.fotoS.isAlive()) {
                this.fotoS.enviar(this.nombreFoto);
                this.fotoS.enviarFoto();
            }
            Producto p = new Producto();
            p.setIdProducto(Integer.parseInt(this.txtCodigo.getText()));
            p.setNombre(this.txtMarca.getText());
            p.setMarca(this.txtMarca.getText());
            p.setCategoria(this.txtCategoria.getText());
            p.setPrecio(Double.parseDouble(this.txtPrecio.getText()));
            p.setExistencia(Integer.parseInt(this.txtExistencia.getText()));
            p.setFoto(this.nombreFoto);
            if (this.productosC.modificarProducto(p)) {
                MensajeConfirmacion mc = new MensajeConfirmacion();
                mc.setMensaje("Producto modificado con éxito");
                mc.setVisible(true);
                limpiar();
            } else {
                MensajeError m = new MensajeError();
                m.setMensaje("Ocurrió un error al modificar el producto."
                        + "\nIntentelo de nuevo.");
                m.setVisible(true);
            }
            this.productosC = new ProductosController(this.tblProductos);
        } catch (IOException ex) {
            //Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError m = new MensajeError();
            m.setMensaje(ex.getMessage());
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Promociones().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Productos().setVisible(true);
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos auto-generados">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos Get y Set">
    
    //</editor-fold>
    
}