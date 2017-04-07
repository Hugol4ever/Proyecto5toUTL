package com.example.ddd_market.ddd_market.modelo.DAO;

/**
 *
 * @author DDD
 */

public class Producto {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idProducto;
    private String nombre;
    private String marca;
    private String categoria;
    private int existencia;
    private double precio;
    private String foto;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Producto() {
    }

    /**
     * Constructor sobrecargado
     *
     * @param nombre
     * @param marca
     * @param categoria
     * @param existencia
     * @param precio
     * @param foto
     */
    public Producto(String nombre, String marca, String categoria, int existencia, double precio, String foto) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.existencia = existencia;
        this.precio = precio;
        this.foto = foto;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos get y set">
    /**
     * Método get de id de producto
     *
     * @return id de producto
     */
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Método get de nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get de marca
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método get de categoria
     *
     * @return categoria
     */
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método get de existencia
     *
     * @return existencia
     */
    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    /**
     * Método get de precio
     *
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método get de foto
     *
     * @return foto
     */
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    //</editor-fold>

}
