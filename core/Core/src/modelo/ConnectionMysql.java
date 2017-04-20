package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DDD
 */

public class ConnectionMysql {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private String nombreDriver;
    private String url;
    private String servidor;
    private int puerto;
    private String baseDeDatos;
    private String userName;
    private String password;
    private Connection connection;
    private Statement st;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public ConnectionMysql() {
        //this("com.mysql.jdbc.Driver", "192.168.1.11", 3306, "Proyecto5", "Proyecto5to", "hugol12");
        this("com.mysql.jdbc.Driver", "localhost", 3306, "Proyecto5", "root", "Admin");
    }

    /**
     * Constructor que tiene todas los argumentos de la clase ConnectionMysql
     *
     * @param nombreDriver
     * @param servidor
     * @param puerto
     * @param baseDeDatos
     * @param userName
     * @param password
     */
    public ConnectionMysql(String nombreDriver, String servidor, int puerto, String baseDeDatos, String userName, String password) {
        this.nombreDriver = nombreDriver;
        this.servidor = servidor;
        this.puerto = puerto;
        this.baseDeDatos = baseDeDatos;
        this.userName = userName;
        this.password = password;

        try {
            Class.forName(nombreDriver);
            url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDeDatos;
        } catch (Exception e) {
            System.out.println("Error - " + e);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * Método para abrir conexión
     *
     * @return Conexión
     * @throws java.lang.Exception
     */
    public Connection abrir() throws Exception {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }

    /**
     * Método para cerrar conéxion
     */
    public void cerrar() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos Get y Set">
    /**
     * Método get de Conexion
     *
     * @return Conexión
     */
    public Connection getConnection() {
        return connection;
    }
    //</editor-fold>
}
