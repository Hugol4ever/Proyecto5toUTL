/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import commons.Globals;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.Producto;
import modelo.DAO.Promocion;
import modelo.DTO.DTOPromocion;
import modelo.DTO.DTOproducto;

/**
 *
 * @author DDD
 */
public class PromocionController {
    
    private DTOPromocion dtoPromocion;
    private JTable tabla;
    private JComboBox combo;
    public int [] ids;

    public PromocionController(JTable tabla, JComboBox combo) throws SQLException {
        this.tabla = tabla;
        this.combo = combo;
        dtoPromocion = new DTOPromocion();
        cargarTabla();
        PromocionController.this.obtenerPromociones();
        cargarCombo();
        listaProductos();
    }
    
    
    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id promoción");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio normal");
        modelo.addColumn("Precio de promoción");
        modelo.addColumn("Dias de duración");
        modelo.addColumn("Fecha registro");
        this.tabla.setModel(modelo);
    }
    
    private void cargarCombo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Elige un producto");
        this.combo.setModel(modelo);
    }
    
    private void limpiarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        cargarTabla();
    }
    
    private void limpiarCombo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        this.combo.setModel(modelo);
        ids = null;
        cargarCombo();
    }
    
    public void obtenerPromociones(){
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        ArrayList<Promocion> lista = this.dtoPromocion.getAll();
        for (Promocion lista1 : lista) {
            Object[] array = {lista1.getIdPromocion(), lista1.getProducto().getNombre(), lista1.getProducto().getPrecio(),lista1.getPrecioPromocion(), lista1.getDiasDuracion(), Globals.formatoFecha.format(lista1.getFechaRegistro())};
        modelo.addRow(array);
        }
        this.tabla.setModel(modelo);
    }
    
    public void obtenerPromociones(String parametro, String valor){
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        ArrayList<Promocion> lista = this.dtoPromocion.getAll(parametro, valor);
        for (Promocion lista1 : lista) {
            Object[] array = {lista1.getIdPromocion(), lista1.getProducto().getNombre(), lista1.getProducto().getPrecio(),lista1.getPrecioPromocion(), lista1.getDiasDuracion(), Globals.formatoFecha.format(lista1.getFechaRegistro())};
        modelo.addRow(array);
        }
        this.tabla.setModel(modelo);
    }

    public void listaProductos() throws SQLException{
        DTOproducto dtoProducto = new DTOproducto();
        limpiarCombo();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.combo.getModel();
        ArrayList <Producto>lista = dtoProducto.ListaProducto();
        ids = new int[lista.size()+1];
        ids[0]=0;
        for (int i = 1; i <= lista.size(); i++) {
            modelo.addElement(lista.get(i-1).getNombre());
            ids[i]=lista.get(i-1).getIdProducto();
        }
        this.combo.setModel(modelo);
    }
  
    public int registrarPromo(Promocion promo) throws Exception{
        int n;
        try {
           n = this.dtoPromocion.insert(promo);
        } catch (Exception e) {
            throw e;
        }
        return n;
    }
    
    public void modificarPromocion(Promocion promocion) throws Exception{
        this.dtoPromocion.modificar(promocion);
    }
    
    public void eliminarPromocion(int id) throws Exception{
        this.dtoPromocion.delete(id);
    }
}

