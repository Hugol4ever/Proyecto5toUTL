package com.example.ddd_market.ddd_market.modelo.DAO;

/**
 * Created by bvsr9 on 07/04/2017.
 */

public class DetalleVenta {

    private  int idDetalleVenta;
    private int cantidad;
    private double precio;
    private Producto producto;
    private Venta venta;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, double precio, Producto producto, Venta venta) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.venta = venta;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}