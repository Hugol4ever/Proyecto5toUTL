
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.Producto;
import modelo.DTO.DTOproducto;

/**
 *
 * @author hugol
 */
public class ProductosController {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private DTOproducto producto;
    private JTable tabla;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     * 
     * @param tabla 
     */
    public ProductosController(JTable tabla) throws SQLException {
        this.producto = new DTOproducto();
        this.tabla = tabla;
        cargarTabla();
        obtenerProductos();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * 
     * 
     * @param parametro
     * @param valor 
     */
    public void obtenerProductos(String parametro, String valor) throws SQLException {
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        ArrayList<Producto> lista = this.producto.ListaProducto(parametro, valor);
        for (Producto lista1 : lista) {
            Object[] array = {lista1.getIdProducto(), lista1.getNombre(), lista1.getMarca(),
                                lista1.getCategoria(), lista1.getPrecio()};
            modelo.addRow(array);
        }
        this.tabla.setModel(modelo);
    }
    
    /**
     * 
     */
    private void obtenerProductos() throws SQLException {
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        ArrayList<Producto> lista = this.producto.ListaProducto();
        for (Producto lista1 : lista) {
            Object[] array = {lista1.getIdProducto(), lista1.getNombre(), lista1.getMarca(),
                                lista1.getCategoria(), lista1.getPrecio()};
            modelo.addRow(array);
        }
        this.tabla.setModel(modelo);
    }
    
    /**
     * 
     * 
     * @param id
     * @return 
     */
    public String[] mostrarFoto(int id) throws SQLException {
        String[] datos = new String[7];
        ArrayList<Producto> lista = this.producto.ListaProducto();
        for (Producto lista1 : lista) {
            if (lista1.getIdProducto() == id) {
                datos[0] = String.valueOf(lista1.getIdProducto());
                datos[1] = lista1.getNombre();
                datos[2] = lista1.getMarca();
                datos[3] = lista1.getCategoria();
                datos[4] = String.valueOf(lista1.getExistencia());
                datos[5] = String.valueOf(lista1.getPrecio());
                datos[6] = lista1.getFoto();
            }
        }
        return datos;
    }
    
    /**
     * 
     */
    private void limpiarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        cargarTabla();
    }
    
    /**
     * 
     */
    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Categoria");
        modelo.addColumn("Precio");
        this.tabla.setModel(modelo);
    }
    
    /**
     * 
     * 
     * @param producto 
     * @return  
     */
    public boolean registrarProducto(Producto producto) {
        try {
            this.producto.insertarProducto(producto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 
     * 
     * @param producto
     * @return 
     */
    public boolean modificarProducto(Producto producto) {
        try {
            this.producto.modificarProducto(producto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //</editor-fold>

}