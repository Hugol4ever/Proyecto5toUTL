package com.example.ddd_market.ddd_market.modelo.DAO;

import java.util.Date;

/**
 * Created by bvsr9 on 30/03/2017.
 */

public class Promocion {

    private int id;
    private double precioPromo;
    private Date fecha;
    private int diasDuracion;
    private Producto producto;

    public Promocion() {
    }

    public Promocion(double precioPromo, Date fecha, int diasDuracion, Producto producto) {
        this.precioPromo = precioPromo;
        this.fecha = fecha;
        this.diasDuracion = diasDuracion;
        this.producto = producto;
    }

    public double getPrecioPromo() {
        return precioPromo;
    }

    public void setPrecioPromo(double precioPromo) {
        this.precioPromo = precioPromo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(int diasDuracion) {
        this.diasDuracion = diasDuracion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
