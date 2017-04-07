
package controlador;

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
    public ClientesController(JTable tabla) {
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
    private void obtenerClientes() {
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        ArrayList<Cliente> cli = this.clientes.listaCliente();
        for (Cliente lista1 : cli) {
            Object[] array = {lista1.getIdCliente(), lista1.getNombre(), lista1.getCorreo(),
                                lista1.getTelefono(), lista1.getGenero(), lista1.getNoTarjeta()};
            modelo.addRow(array);
        }
        this.tabla.setModel(modelo);
    }
    
    /**
     * 
     */
    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Genero");
        modelo.addColumn("Número de cuenta");
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