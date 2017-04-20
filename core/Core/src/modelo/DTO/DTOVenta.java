package modelo.DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.ConnectionMysql;
import modelo.DAO.Cliente;
import modelo.DAO.Producto;
import modelo.DAO.Promocion;
import modelo.DAO.Venta;

/**
 *
 * @author DDD
 */

public class DTOVenta {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ConnectionMysql conexion;
    private DateFormat fechaSQL = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat horaSQL = new SimpleDateFormat("HH:mm:ss");
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
    
    public ArrayList<Venta> getAll() {
        ArrayList<Venta> lista = new ArrayList<>();

        Connection conn;
        Statement stmt;
        ResultSet rs;

        String query = "select * from viewVenta";
        try {
            conn = conexion.abrir();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Venta ven = new Venta();
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("Id_Cliente1"));
                ven.setCliente(c);
                ven.setIdVenta(rs.getInt("Id_Venta"));
                ven.setFecha(fechaSQL.parse(rs.getString("Fecha")));
                ven.setHora(horaSQL.parse(rs.getString("Hora")));
                ven.setTotal(rs.getDouble("total"));
                lista.add(ven);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }
    //</editor-fold>

}
