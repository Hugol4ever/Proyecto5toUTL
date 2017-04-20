
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.Cliente;
import modelo.DTO.DTOCliente;

/**
 *
 * @author DDD
 */

public class ClientesController {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private DTOCliente clientes;
    private JTable tabla;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     * 
     * @param tabla 
     */
    public ClientesController(JTable tabla) throws SQLException {
        this.clientes = new DTOCliente();
        this.tabla = tabla;
        cargarTabla();
        obtenerClientes();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * 
     */
    private void obtenerClientes() throws SQLException {
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        ArrayList<Cliente> cli = this.clientes.listaCliente();
        for (Cliente lista1 : cli) {
            Object[] array = {lista1.getIdCliente(), lista1.getNombre(), lista1.getGenero(),
                                lista1.getTelefono(), lista1.getCorreo(), lista1.getUsuario().getContrasenia(),
                                lista1.getNoTarjeta(),  lista1.getLimiteSaldo(), lista1.getSaldoDisponible()};
            modelo.addRow(array);
        }
        this.tabla.setModel(modelo);
    }
    
    public Object[][] obtenerDatos() throws SQLException {
        ArrayList<Cliente> cli = this.clientes.listaCliente();
        Object[][] chido = new Object[cli.size()][9];
        for (int i = 0; i < cli.size(); i++) {
            Object [] chidito={cli.get(i).getIdCliente(), cli.get(i).getNombre(), cli.get(i).getGenero(),
                                cli.get(i).getTelefono(), cli.get(i).getCorreo(), cli.get(i).getUsuario().getContrasenia(),
                                cli.get(i).getNoTarjeta(),  cli.get(i).getLimiteSaldo(), cli.get(i).getSaldoDisponible()};
            chido[i]=chidito;
        }
        return chido;
    }
    
    public Object[] obtenerTitulos(){
        Object [] xx = {"Id cliente","Nombre","Genero","Teléfono","Correo","Contraseña","Número de cuenta","Limite de saldo"};
        return xx;
    }
    
    /**
     * 
     */
    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Genero");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Número de cuenta");
        modelo.addColumn("Limite de saldo");
        modelo.addColumn("Saldo disponible");
        this.tabla.setModel(modelo);
    }
    
    /**
     * 
     */
    private void limpiarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        cargarTabla();
    }
    //</editor-fold>

}