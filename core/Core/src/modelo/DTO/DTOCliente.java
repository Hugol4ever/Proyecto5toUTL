package modelo.DTO;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.DAO.Cliente;
import modelo.ConnectionMysql;
import modelo.DAO.Usuario;

/**
 *
 * @author DDD
 */

public class DTOCliente {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ConnectionMysql conexion;
    private ResultSet rs;
    private Statement st;
    private Connection cn;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public DTOCliente() {
        this(new ConnectionMysql());
    }

    /**
     * Constructor sobrecargado
     * 
     * @param conexion 
     */
    public DTOCliente(ConnectionMysql conexion) {
        this.conexion = conexion;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * Método para registrar cliente
     * 
     * @param cliente
     * @return verdadero si se registró con éxito
     * @throws Exception 
     */
    public boolean registrarCliente(Cliente cliente) throws Exception {
        boolean si = true;
        Connection conn;
        CallableStatement cstmt;

        String query = "call regCliente( ?, ?, ?, ?,"
                + "?,?,?,?,"
                + "?,?,?,?,?,?,?)";
        try {
            ByteArrayInputStream datosHuella = new ByteArrayInputStream(cliente.getUsuario().getHuella().getTemplate().serialize());
            Integer tamanioHuella = cliente.getUsuario().getHuella().getTemplate().serialize().length;
            conn = conexion.abrir();
            cstmt = conn.prepareCall(query);
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.setBinaryStream(2, datosHuella, tamanioHuella);
            cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
            cstmt.setString(4, "null");
            cstmt.registerOutParameter(5, java.sql.Types.INTEGER);
            cstmt.setString(6, cliente.getNombre());
            cstmt.setString(7, cliente.getCorreo());
            cstmt.setString(8, cliente.getTelefono());
            cstmt.setString(9, cliente.getGenero());
            cstmt.setString(10, cliente.getNoTarjeta());
            cstmt.setDouble(11, cliente.getLimiteSaldo());
            cstmt.setDouble(12, cliente.getSaldoDisponible());
            cstmt.registerOutParameter(13, java.sql.Types.INTEGER);
            cstmt.setString(14, cliente.getUsuario().getNombreUsuario());
            cstmt.setString(15, cliente.getUsuario().getContrasenia());
            cstmt.executeUpdate();
        } catch (Exception e) {
            si = false;
            throw e;
        } finally {
            conexion.cerrar();
        }
        return si;
    }

    /**
     * Método para cargar lista de clientes
     * 
     * @return ArrayList de lista de clientes
     * @throws java.sql.SQLException
     */
    public ArrayList<Cliente> listaCliente() throws SQLException {
        ArrayList<Cliente> cli = new ArrayList<>();
        String query = "SELECT * FROM viewCliente";
        try {
            cn = conexion.abrir();
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("Id_Cliente"));
                c.setNombre(rs.getString("Nombre"));
                c.setCorreo(rs.getString("Correo"));
                c.setTelefono(rs.getString("Telefono"));
                c.setGenero(rs.getString("Genero"));
                c.setNoTarjeta(rs.getString("N_Tarjeta"));
                c.setUsuario(new Usuario());
                c.getUsuario().setContrasenia(rs.getString("Contrasenia"));
                c.setLimiteSaldo(rs.getDouble("Limite_Saldo"));
                c.setSaldoDisponible(rs.getDouble("Saldo_Dis"));
                cli.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        } finally {
            cn.close();
        }
        return cli;
    }
    
    /**
     * 
     * 
     * @param cliente
     * @return
     * @throws Exception 
     */
    public boolean modificarCliente(Cliente cliente) throws Exception {
        boolean si = true;
        Connection conn;
        CallableStatement cstmt;

        String query = "call modCliente(?,?,?,?,"
                + "?,?,?,?,?,?)";
        try {
            ByteArrayInputStream datosHuella = new ByteArrayInputStream(cliente.getUsuario().getHuella().getTemplate().serialize());
            Integer tamanioHuella = cliente.getUsuario().getHuella().getTemplate().serialize().length;
            conn = conexion.abrir();
            cstmt = conn.prepareCall(query);
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.setBinaryStream(2, datosHuella, tamanioHuella);
            cstmt.setInt(3, cliente.getIdCliente());
            cstmt.setString(4, cliente.getNombre());
            cstmt.setString(5, cliente.getTelefono());
            cstmt.setString(6, cliente.getGenero());
            cstmt.setString(7, cliente.getNoTarjeta());
            cstmt.setDouble(8, cliente.getLimiteSaldo());
            cstmt.setDouble(9, cliente.getSaldoDisponible());
            cstmt.setString(10, cliente.getUsuario().getContrasenia());
            cstmt.executeUpdate();
        } catch (Exception ex) {
            si = false;
            throw ex;
        } finally {
            conexion.cerrar();
        }
        return si;
    }
    //</editor-fold>

}