package app;

import Animacion.Fade;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.JTableHeader;

/**
 *
 * @author bvsr9
 */
public class Promociones extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     */
    public Promociones() {
        setUndecorated(true);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        encabezado();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * 
     */
    public void encabezado() {
        JTableHeader th = tablaPromociones.getTableHeader();
        th.setFont(new Font("Segoe Print", 1, 14));
        th.setForeground(Color.DARK_GRAY);
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelSalir2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPromociones = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtCodProducto = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDias = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 51, 103));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(26, 51, 103));

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PROMOCIONES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(390, 390, 390))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/promo.png"))); // NOI18N

        jPanelSalir2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSalir2.setMaximumSize(new java.awt.Dimension(106, 100));
        jPanelSalir2.setMinimumSize(new java.awt.Dimension(106, 100));
        jPanelSalir2.setLayout(null);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanelSalir2.add(btnSalir);
        btnSalir.setBounds(-40, 20, 106, 73);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 0, 20))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 17)); // NOI18N
        jLabel3.setText("Buscar por:");

        jComboBox1.setBackground(new java.awt.Color(51, 153, 255));
        jComboBox1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de Promoción", "Nombre Producto", "Fecha Registro" }));

        jTextField1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 16)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnbuscar1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaPromociones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaPromociones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, 187, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        txtCodProducto.setBackground(new java.awt.Color(251, 245, 135));
        txtCodProducto.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtCodProducto.setBorder(null);
        txtCodProducto.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtCodProducto);
        txtCodProducto.setBounds(230, 130, 170, 20);

        txtFecha.setBackground(new java.awt.Color(251, 245, 135));
        txtFecha.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtFecha.setBorder(null);
        txtFecha.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtFecha);
        txtFecha.setBounds(230, 210, 170, 20);

        txtPrecio.setBackground(new java.awt.Color(251, 245, 135));
        txtPrecio.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtPrecio.setBorder(null);
        txtPrecio.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtPrecio);
        txtPrecio.setBounds(230, 290, 170, 20);

        txtDias.setBackground(new java.awt.Color(251, 245, 135));
        txtDias.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtDias.setBorder(null);
        txtDias.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtDias);
        txtDias.setBounds(230, 370, 170, 20);

        txtCodigo.setBackground(new java.awt.Color(251, 245, 135));
        txtCodigo.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 15)); // NOI18N
        txtCodigo.setBorder(null);
        txtCodigo.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanel5.add(txtCodigo);
        txtCodigo.setBounds(230, 50, 170, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datosPromo.png"))); // NOI18N
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 0, 610, 420);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(26, 51, 103));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7);
        jPanel7.setBounds(50, 0, 510, 10);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnLimpiar.jpg"))); // NOI18N
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        jPanel6.add(btnLimpiar);
        btnLimpiar.setBounds(40, -30, 110, 130);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnGuardar.jpg"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        jPanel6.add(btnGuardar);
        btnGuardar.setBounds(170, -30, 127, 130);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnModificar.jpg"))); // NOI18N
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        jPanel6.add(btnModificar);
        btnModificar.setBounds(310, -30, 127, 130);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnCancelar.jpg"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        jPanel6.add(btnCancelar);
        btnCancelar.setBounds(450, -30, 127, 130);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        Animacion.Animacion.mover_derecha(-40, 0, 3, 2, btnSalir);
    }//GEN-LAST:event_btnSalirMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        Animacion.Animacion.mover_izquierda(0, -40, 3, 2, btnSalir);
    }//GEN-LAST:event_btnSalirMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Fade.JFrameFadeOut(1f, 0f, 0.1f, 70, this, Fade.DISPOSE);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        Animacion.Animacion.bajar(-30, 10, 3, 2, btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        Animacion.Animacion.subir(10, -30, 3, 2, btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
         Animacion.Animacion.subir(10, -30, 3, 2, btnGuardar);
    }//GEN-LAST:event_btnGuardarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        Animacion.Animacion.bajar(-30, 10, 3, 2, btnGuardar);
    }//GEN-LAST:event_btnGuardarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
         Animacion.Animacion.subir(10, -30, 3, 2, btnModificar);
    }//GEN-LAST:event_btnModificarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        Animacion.Animacion.bajar(-30, 10, 3, 2, btnModificar);
    }//GEN-LAST:event_btnModificarMouseEntered

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
         Animacion.Animacion.subir(10, -30, 3, 2, btnCancelar);
    }//GEN-LAST:event_btnCancelarMouseExited

    /**
     * 
     * 
     * @param evt parámetro por defecto
     */
    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        Animacion.Animacion.bajar(-30, 10, 3, 2, btnCancelar);
    }//GEN-LAST:event_btnCancelarMouseEntered
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Método main">
    /**
     * 
     * 
     * @param args parámetro por defecto
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
            java.util.logging.Logger.getLogger(Promociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Promociones().setVisible(true);
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos auto-generados">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelSalir2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaPromociones;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos Get y Set">
    
    //</editor-fold>
    
}