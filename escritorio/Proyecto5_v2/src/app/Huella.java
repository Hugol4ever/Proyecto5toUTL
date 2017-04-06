package app;

import com.digitalpersona.onetouch.DPFPTemplate;
import controlador.HuellaController;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.DAO.Cliente;
import modelo.DTO.DTOHuella;

/**
 *
 * @author DDD
 */

public class Huella extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private Cliente cliente;
    private HuellaController huellaC;
    private Clientes clientes;
    private Ventas venta;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor por defecto
     */
    public Huella() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.huellaC = new HuellaController(this);
        this.huellaC.iniciar();
        this.huellaC.start();
        this.huellaC.EstadoHuella();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    
     //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        huella = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 51, 103), 5));
        jPanel1.setMinimumSize(new java.awt.Dimension(251, 339));
        jPanel1.setPreferredSize(new java.awt.Dimension(251, 339));
        jPanel1.setLayout(null);

        huella.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(huella);
        huella.setBounds(25, 16, 202, 223);

        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificar.png"))); // NOI18N
        btnVerificar.setBorderPainted(false);
        btnVerificar.setContentAreaFilled(false);
        btnVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificar);
        btnVerificar.setBounds(84, 240, 80, 77);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add+.png"))); // NOI18N
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(80, 240, 92, 77);

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
    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        DTOHuella dto = new DTOHuella(this.huellaC.featuresverificacion, huellaC.getTemplate());
        this.venta.setCliente(dto.huella());
        this.huellaC.getReclutador().clear();
        this.venta.insertar(cliente);
        this.huellaC.stop();
        dispose();
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.huellaC.getReclutador().clear();this.huella.setIcon(null);
        this.huellaC.start();
        this.clientes.setTemplate(this.huellaC.getTemplate());
        this.clientes.setCorrecto();
        this.huellaC.stop();
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Método main">
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Huella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Huella().setVisible(true);
        });
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos auto-generados">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel huella;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos Get y Set">
    public JLabel getHuella() {
        return huella;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }
    
    public DPFPTemplate getTemplate() {
        return this.huellaC.getTemplate();
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnVerificar() {
        return btnVerificar;
    }
    //</editor-fold>
    
}