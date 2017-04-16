/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.util.Date;

/**
 *
 * @author DDD
 */
public class Promocion {
    
    private int idPromocion;
    private double precioPromocion;
    private Date fechaRegistro;
    private int diasDuracion;
    private Producto producto;

    public Promocion() {
    }

    public Promocion(double precioPromocion, Date fechaRegistro, int diasDuracion, Producto producto) {
        this.precioPromocion = precioPromocion;
        this.fechaRegistro = fechaRegistro;
        this.diasDuracion = diasDuracion;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public double getPrecioPromocion() {
        return precioPromocion;
    }

    public void setPrecioPromocion(double precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(int diasDuracion) {
        this.diasDuracion = diasDuracion;
    }
    
}
