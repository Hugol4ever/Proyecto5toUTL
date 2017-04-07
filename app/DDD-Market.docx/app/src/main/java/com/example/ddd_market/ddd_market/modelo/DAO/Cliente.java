package com.example.ddd_market.ddd_market.modelo.DAO;

/**
 * Created by bvsr9 on 26/03/2017.
 */

public class Cliente {

    private int idCliente;
    private String nombre;
    private String correo;
    private String telefono;
    private String genero;
    private String ntarjeta;
    private double limiteSaldo;
    private double saldoDisponible;

    public Cliente() {
    }

    public Cliente(String nombre, String correo, String telefono, String genero, String ntarjeta, double limiteSaldo, double saldoDisponible) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
        this.ntarjeta = ntarjeta;
        this.limiteSaldo = limiteSaldo;
        this.saldoDisponible = saldoDisponible;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNtarjeta() {
        return ntarjeta;
    }

    public void setNtarjeta(String ntarjeta) {
        this.ntarjeta = ntarjeta;
    }

    public double getLimiteSaldo() {
        return limiteSaldo;
    }

    public void setLimiteSaldo(double limiteSaldo) {
        this.limiteSaldo = limiteSaldo;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
