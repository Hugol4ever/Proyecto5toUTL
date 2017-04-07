package com.example.ddd_market.ddd_market.modelo.DAO;

/**
 * Created by bvsr9 on 26/03/2017.
 */

public class Usuario {

    private int idUsuario;
    private String nomUsuario;
    private String contraseña;
    //Huella
    private FotoCliente foto;
    private Cliente cliente;

    public Usuario() {
    }

    public Usuario(String nomUsuario, String contraseña, FotoCliente foto, Cliente cliente) {
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
        this.foto = foto;
        this.cliente = cliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public FotoCliente getFoto() {
        return foto;
    }

    public void setFoto(FotoCliente foto) {
        this.foto = foto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
