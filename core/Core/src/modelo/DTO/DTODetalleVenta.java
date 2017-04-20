package modelo.DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ConnectionMysql;
import modelo.DAO.DetalleVenta;
import modelo.DAO.Producto;
import modelo.DAO.Venta;

/**
 *
 * @author DDD
 */

public class DTODetalleVenta {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ConnectionMysql conexion;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor por defecto
     */
    public DTODetalleVenta() {
        this(new ConnectionMysql());
    }

    /**
     * Constructor sobrecargado
     * 
     * @param conexion 
     */
    public DTODetalleVenta(ConnectionMysql conexion) {
        this.conexion = conexion;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * Método para insertar detalle de venta
     * 
     * @param detalle
     * @return id de detalle de venta
     * @throws Exception 
     */
    public int insert(DetalleVenta detalle) throws Exception {
        int id;
        Connection conn;
        CallableStatement cstmt;

        String query = "CALL regDetVenta( ?, ?, ?, ?, ?)";

        try {
            conn = conexion.abrir();
            cstmt = conn.prepareCall(query);

            cstmt.setInt(1, detalle.getCantidad());
            cstmt.setDouble(2, detalle.getPrecio());
            cstmt.setInt(3, detalle.getProducto().getIdProducto());
            cstmt.setInt(4, detalle.getVenta().getIdVenta());
            cstmt.registerOutParameter(5, java.sql.Types.INTEGER);
            cstmt.executeUpdate();

            detalle.setIdDetalleVenta(cstmt.getInt(5));
            id = detalle.getIdDetalleVenta();

            cstmt.close();
            conexion.cerrar();
        } catch (Exception e) {
            conexion.cerrar();
            throw e;
        }
        return id;
    }
    
     public ArrayList<DetalleVenta> getAll(int id) {
         System.out.println("Entro a metodo--------------------");
        ArrayList<DetalleVenta> lista = new ArrayList<>();
        Connection conn;
        Statement stmt;
        ResultSet rs;
        
        String query = "select * from viewDetaVenta where Id_Venta = "+id;
        try {
            conn = conexion.abrir();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                DetalleVenta ven = new DetalleVenta();
                Venta v = new Venta();
                Producto p = new Producto();
                p.setNombre(rs.getString("Nombre"));
                ven.setProducto(p);
                v.setIdVenta(rs.getInt("Id_Venta"));
                ven.setVenta(v);
                ven.setIdDetalleVenta(rs.getInt("Id_DetalleVenta"));
                ven.setCantidad(rs.getInt("Cantidad"));
                ven.setPrecio(rs.getDouble("preciodv"));
                lista.add(ven);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }
    //</editor-fold>

}
