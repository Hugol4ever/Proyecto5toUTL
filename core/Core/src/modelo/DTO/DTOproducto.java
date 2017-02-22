package modelo.DTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ConnectionMysql;
import modelo.DAO.Producto;

/**
 *
 * @author DDD
 */
public class DTOproducto {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ResultSet rs;
    private Statement st;
    private Connection cn;
    private ConnectionMysql mysql;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor por defecto
     */
    public DTOproducto() {
        this.mysql = new ConnectionMysql();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * Método para obtener la lista de productos con filtros
     * 
     * @param parametro
     * @param valor
     * @return ArrayList de productos
     */
    public ArrayList<Producto> ListaProducto(String parametro, String valor) {
        ArrayList<Producto> prod = new ArrayList<>();
        String query = "SELECT * FROM vistProductos where " + parametro + " = '" + valor + "'";
        try {
            cn = mysql.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("Id_Producto"));
                p.setNombre(rs.getString("Nombre"));
                p.setMarca(rs.getString("Marca"));
                p.setCategoria(rs.getString("Categoria"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setFoto(rs.getString("Foto"));
                prod.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return prod;
    }

    /**
     * Método para obtener la lista de productos sin filtros
     * 
     * @return ArrayList de producto
     */
    public ArrayList<Producto> ListaProducto() {
        ArrayList<Producto> prod = new ArrayList<>();
        String query = "SELECT * FROM vistProductos";
        try {
            cn = mysql.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("Id_Producto"));
                p.setNombre(rs.getString("Nombre"));
                p.setMarca(rs.getString("Marca"));
                p.setCategoria(rs.getString("Categoria"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setFoto(rs.getString("Foto"));
                prod.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return prod;
    }

    /**
     * Método para buscar producto por id
     * 
     * @param id
     * @return arreglo con los datos del producto
     */
    public String[] ListaProductoPorId(int id) {
        String[] prod = new String[3];
        String query = "SELECT Id_Producto, Nombre, Precio FROM vistProductos where Id_Producto = " + id;
        try {
            cn = mysql.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            while (rs.next()) {
                prod[0] = String.valueOf(rs.getInt("Id_Producto"));
                prod[1] = rs.getString("Nombre");
                prod[2] = String.valueOf(rs.getDouble("Precio"));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return prod;
    }
    //</editor-fold>
    
}
