package modelo.DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import modelo.ConnectionMysql;
import modelo.DAO.Venta;

/**
 *
 * @author DDD
 */

public class DTOVenta {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ConnectionMysql conexion;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor por defecto
     */
    public DTOVenta() {
        this(new ConnectionMysql());
    }

    /**
     * Constructor sobrecargado
     * 
     * @param conexion 
     */
    public DTOVenta(ConnectionMysql conexion) {
        this.conexion = conexion;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * Método para registrar una venta
     * 
     * @param venta
     * @return id de venta
     * @throws Exception 
     */
    public int insert(Venta venta) throws Exception {
        int id;
        Connection conn;
        CallableStatement cstmt;

        String query = "CALL regVenta( ?, ?)";

        try {
            conn = conexion.abrir();
            cstmt = conn.prepareCall(query);

            cstmt.setInt(1, venta.getCliente().getIdCliente());
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.executeUpdate();

            venta.setIdVenta(cstmt.getInt(2));
            id = venta.getIdVenta();

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
