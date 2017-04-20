package modelo.DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     * @throws java.sql.SQLException
     */
    public ArrayList<Producto> ListaProducto(String parametro, String valor) throws SQLException {
        ArrayList<Producto> prod = new ArrayList<>();
        String query = "SELECT * FROM viewProducto where " + parametro + " = '" + valor + "'";
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
         finally {
            rs.close();
        }
        return prod;
    }

    /**
     * Método para obtener la lista de productos sin filtros
     * 
     * @return ArrayList de producto
     * @throws java.sql.SQLException
     */
    public ArrayList<Producto> ListaProducto() throws SQLException {
        ArrayList<Producto> prod = new ArrayList<>();
        String query = "SELECT * FROM viewProducto";
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
                p.setExistencia(rs.getInt("Existencia"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setFoto(rs.getString("Foto"));
                prod.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        } finally {
            rs.close();
        }
        return prod;
    }

    /**
     * Método para buscar producto por id
     * 
     * @param id
     * @return arreglo con los datos del producto
     * @throws java.sql.SQLException
     */
    public String[] ListaProductoPorId(int id) throws SQLException {
        String[] prod = new String[3];
        String query = "SELECT Id_Producto, Nombre, Precio FROM viewProducto where Id_Producto = " + id;
        try {
            cn = mysql.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            rs.first();
            prod[0] = String.valueOf(rs.getInt("Id_Producto"));
            prod[1] = rs.getString("Nombre");
            prod[2] = String.valueOf(rs.getDouble("Precio"));
            if (isProductoPromocion(id)) {
                prod[2] = String.valueOf(PrecioPromocionPorId(prod[1]));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        } finally {
            rs.close();
        }
        return prod;
    }
    
    private double PrecioPromocionPorId(String nombre) throws SQLException {
        String query = "SELECT Precio_Promo FROM viewPromos WHERE Nombre = '" + nombre + "'";
        double precio = 0;
        try {
            cn = mysql.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            rs.first();
            precio = rs.getDouble("Precio_Promo");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        } finally {
            rs.close();
        }
        return precio;
    }
    
    private boolean isProductoPromocion(int id) throws SQLException {
        String query = "SELECT Promocion FROM Producto where Id_Producto = " + id;
        boolean promocion = false;
        try {
            cn = mysql.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            rs.first();
            promocion = rs.getBoolean("Promocion");
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        } finally {
            rs.close();
        }
        return promocion;
    }
    
    /**
     * 
     * 
     * @param p 
     * @throws java.lang.Exception 
     */
    public void insertarProducto(Producto p) throws Exception {
        Connection conn;
        CallableStatement cstmt;
        String query = "call regProducto( ?, ?, ?, ?, ?,?,?)";
        conn = mysql.abrir();
        cstmt = conn.prepareCall(query);
        cstmt.setInt(1, p.getIdProducto());
        cstmt.setString(2, p.getNombre());
        cstmt.setString(3, p.getMarca());
        cstmt.setString(4, p.getCategoria());
        cstmt.setInt(5, p.getExistencia());
        cstmt.setDouble(6, p.getPrecio());
        cstmt.setString(7, p.getFoto());
        cstmt.executeUpdate();
        mysql.cerrar();
    }
    
    /**
     * 
     * 
     * @param p
     * @throws Exception 
     */
    public void modificarProducto(Producto p) throws Exception {
        Connection conn;
        CallableStatement cstmt;
        String query = "call modProducto( ?, ?, ?, ?, ?,?,?)";
        conn = mysql.abrir();
        cstmt = conn.prepareCall(query);
        cstmt.setInt(1, p.getIdProducto());
        cstmt.setString(2, p.getNombre());
        cstmt.setString(3, p.getMarca());
        cstmt.setString(4, p.getCategoria());
        cstmt.setInt(5, p.getExistencia());
        cstmt.setDouble(6, p.getPrecio());
        cstmt.setString(7, p.getFoto());
        cstmt.executeUpdate();
        mysql.cerrar();
    }
    //</editor-fold>
    
}
