package modelo.DAO;

/**
 *
 * @author DDD
 */

public class DetalleVenta {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idDetalleVenta;
    private int cantidad;
    private double precio;
    private Producto producto;
    private Venta venta;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public DetalleVenta() {
    }

    /**
     * Constructor sobrecargado
     * 
     * @param cantidad
     * @param precio
     * @param idProducto
     * @param idVenta
     */
    public DetalleVenta(int cantidad, double precio, Producto idProducto, Venta idVenta) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = idProducto;
        this.venta = idVenta;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos get y set">
    /**
     * Método get del id de detalle de venta
     * 
     * @return id de detalle de venta
     */
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    /**
     * Método set de id detalle de venta
     * 
     * @param idDetalleVenta
     */
    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    /**
     * Método get de cantidad
     * 
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Método set de cantidad
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método get de precio
     * 
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método set de precio
     * 
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método get de producto
     * 
     * @return producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Método set de producto
     * 
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Método get de venta
     * 
     * @return venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Método set de venta
     * 
     * @param venta
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    //</editor-fold>

}