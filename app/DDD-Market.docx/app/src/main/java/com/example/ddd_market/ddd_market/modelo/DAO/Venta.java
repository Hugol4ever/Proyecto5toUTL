package com.example.ddd_market.ddd_market.modelo.DAO;

import java.util.Date;

/**
 * Created by bvsr9 on 04/04/2017.
 */

public class Venta {
    private int idVenta;
    private Date fecha;
    private Date hora;
    private Cliente cliente;
    private double monto;

    public Venta() {
    }

    public Venta(Date fecha, Date hora, Cliente cliente, double monto) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
