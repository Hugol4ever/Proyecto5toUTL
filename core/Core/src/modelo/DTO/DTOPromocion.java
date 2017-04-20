/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.ConnectionMysql;
import modelo.DAO.Producto;
import modelo.DAO.Promocion;
import modelo.DAO.Venta;

/**
 *
 * @author DDD
 */
public class DTOPromocion {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private DateFormat fechaSQL = new SimpleDateFormat("yyyy-MM-dd");
    private ConnectionMysql conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public DTOPromocion() {
        this(new ConnectionMysql());
    }

    public DTOPromocion(ConnectionMysql conexion) {
        this.conexion = conexion;
    }
    //</editor-fold>

    public int insert(Promocion promocion) throws Exception {
        int id;
        Connection conn;
        CallableStatement cstmt;

        String query = "CALL regPromocion( ?, ?, ?, ?)";

        try {
            conn = conexion.abrir();
            cstmt = conn.prepareCall(query);

            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.setDouble(2, promocion.getPrecioPromocion());
            cstmt.setInt(3, promocion.getDiasDuracion());
            cstmt.setInt(4, promocion.getProducto().getIdProducto());
            cstmt.executeUpdate();

            promocion.setIdPromocion(cstmt.getInt(1));
            id = promocion.getIdPromocion();

            cstmt.close();
            conexion.cerrar();
        } catch (Exception e) {
            conexion.cerrar();
            throw e;
        }
        return id;
    }

    public void modificar(Promocion promocion) throws Exception {
        Connection conn;
        CallableStatement cstmt;

        String query = "CALL modPromocion( ?, ?, ?)";

        try {
            conn = conexion.abrir();
            cstmt = conn.prepareCall(query);

            cstmt.setInt(1, promocion.getIdPromocion());
            cstmt.setDouble(2, promocion.getPrecioPromocion());
            cstmt.setInt(3, promocion.getDiasDuracion());
            cstmt.executeUpdate();

            cstmt.close();
            conexion.cerrar();
        } catch (Exception e) {
            conexion.cerrar();
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        String query = "delete from Promocion where Id_Promocion = " + id;

        try {
            conn = conexion.abrir();
            stmt = conn.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            conexion.cerrar();
        } catch (Exception e) {
            conexion.cerrar();
            throw e;
        }
    }

    public ArrayList<Promocion> getAll() {
        ArrayList<Promocion> lista = new ArrayList<>();

        Connection conn;
        Statement stmt;
        ResultSet rs;

        String query = "select * from viewPromosRed";
        try {
            conn = conexion.abrir();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Promocion pro = new Promocion();
                pro.setIdPromocion(rs.getInt("Id_Promocion"));
                pro.setProducto(new Producto());
                pro.getProducto().setIdProducto(rs.getInt("Id_Producto2"));
                pro.getProducto().setNombre(rs.getString("Nombre"));
                pro.getProducto().setPrecio(rs.getDouble("Precio"));
                pro.setPrecioPromocion(rs.getDouble("Precio_Promo"));
                pro.setDiasDuracion(rs.getInt("Dias_Duracion"));
                pro.setFechaRegistro(fechaSQL.parse(rs.getString("Fecha")));
                lista.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    public ArrayList<Promocion> getAll(String parametro, String valor) {
        ArrayList<Promocion> lista = new ArrayList<>();

        Connection conn;
        Statement stmt;
        ResultSet rs;

        String query = "select * from viewPromosRed where " + parametro + " = '" + valor + "'";
        try {
            conn = conexion.abrir();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Promocion pro = new Promocion();
                pro.setIdPromocion(rs.getInt("Id_Promocion"));
                pro.setProducto(new Producto());
                pro.getProducto().setIdProducto(rs.getInt("Id_Producto2"));
                pro.getProducto().setNombre(rs.getString("Nombre"));
                pro.getProducto().setPrecio(rs.getDouble("Precio"));
                pro.setPrecioPromocion(rs.getDouble("Precio_Promo"));
                pro.setDiasDuracion(rs.getInt("Dias_Duracion"));
                pro.setFechaRegistro(fechaSQL.parse(rs.getString("Fecha")));
                lista.add(pro);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

}
