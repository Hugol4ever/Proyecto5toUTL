package modelo.DAO;

/**
 *
 * @author DDD
 */

public class Cliente {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idCliente;
    private String nombre;
    private String correo;
    private String telefono;
    private String genero;
    private String noTarjeta;
    private double limiteSaldo;
    private double saldoDisponible;
    private Usuario usuario;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Cliente() {
    }

    /**
     * Constructor sobrecargado
     * 
     * @param nombre
     * @param correo
     * @param telefono
     * @param genero
     * @param nTarjeta
     * @param limiteSaldo
     * @param saldoDisponible
     * @param idUsuario
     */
    public Cliente(String nombre, String correo, String telefono, String genero, String nTarjeta, double limiteSaldo, double saldoDisponible, Usuario idUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
        this.noTarjeta = nTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.limiteSaldo = limiteSaldo;
        this.usuario = idUsuario;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos get y set">
    /**
     * Método get del usuario
     * 
     * @return Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método set del usuario
     * 
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método get id de usuario
     * 
     * @return Id del usuario
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Método set del id de usuario
     * 
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método get del nombre
     * 
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set del nombre
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get del correo
     * 
     * @return Correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método set del correo
     * 
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método get del teléfono
     * 
     * @return Teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método set del teléfono
     * 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método get genero
     * 
     * @return Genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Método set del genero
     * 
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Método get número de tarjeta
     * 
     * @return Número de tarjeta
     */
    public String getNoTarjeta() {
        return noTarjeta;
    }

    /**
     * Método set del número de tarjeta
     * 
     * @param noTarjeta
     */
    public void setNoTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    /**
     * 
     * 
     * @return 
     */
    public double getLimiteSaldo() {
        return limiteSaldo;
    }

    /**
     * 
     * 
     * @param limiteSaldo 
     */
    public void setLimiteSaldo(double limiteSaldo) {
        this.limiteSaldo = limiteSaldo;
    }

    /**
     * 
     * 
     * @return 
     */
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * 
     * 
     * @param saldoDisponible 
     */
    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
}