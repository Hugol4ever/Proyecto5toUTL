package modelo.DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import modelo.ConnectionMysql;
import modelo.DAO.DetalleVenta;

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
    //</editor-fold>

}
