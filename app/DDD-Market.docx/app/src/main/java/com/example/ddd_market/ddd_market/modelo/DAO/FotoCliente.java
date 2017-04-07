package com.example.ddd_market.ddd_market.modelo.DAO;

/**
 * Created by bvsr9 on 26/03/2017.
 */

public class FotoCliente {

    private int idFoto;
    private byte[] foto;

    public FotoCliente() {

    }

    public FotoCliente(byte[] foto) {
        this.foto = foto;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
