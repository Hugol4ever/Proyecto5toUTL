package modelo.DAO;

/**
 *
 * @author DDD
 */

public class Usuario {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private Huella huella;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

    /**
     * Constructor sobrecargado
     * 
     * @param nomUsuario
     * @param contraseña
     * @param idHuella
     */
    public Usuario(String nomUsuario, String contraseña, Huella idHuella) {
        this.nombreUsuario = nomUsuario;
        this.contrasenia = contraseña;
        this.huella = idHuella;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos get y set">
    /**
     * Método get de id de usuario
     * 
     * @return id de usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Método get de nombre de usuario
     * 
     * @return nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método get de contraseña
     * 
     * @return contraseña
     */
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método get de huella
     * 
     * @return huella
     */
    public Huella getHuella() {
        return huella;
    }

    public void setHuella(Huella huella) {
        this.huella = huella;
    }
    //</editor-fold>

}