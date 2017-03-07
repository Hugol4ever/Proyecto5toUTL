package modelo.DAO;

import java.util.Date;

/**
 *
 * @author DDD
 */

public class Venta {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idVenta;
    private Date fecha;
    private Date hora;
    private Cliente cliente;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Venta() {
    }

    /**
     * Constructor sobrecargado
     * 
     * @param fecha
     * @param hora
     * @param idCliente
     */
    public Venta(Date fecha, Date hora, Cliente idCliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = idCliente;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos get y set">
    /**
     * Método get de id de venta
     * 
     * @return id de venta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Método set de id venta
     * 
     * @param idVenta
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Método get de fecha
     * 
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método set de fecha
     * 
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método get de hora
     * 
     * @return hora
     */
    public Date getHora() {
        return hora;
    }

    /**
     * Método set de hora
     * 
     * @param hora
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * Método get de cliente
     * 
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método set de cliente
     * 
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //</editor-fold>

}