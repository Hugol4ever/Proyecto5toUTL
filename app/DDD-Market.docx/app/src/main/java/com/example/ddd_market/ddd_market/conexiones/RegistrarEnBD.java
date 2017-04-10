package com.example.ddd_market.ddd_market.conexiones;

import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;

/**
 * Created by hugo_ on 06/04/2017.
 */

public class RegistrarEnBD {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;


    public RegistrarEnBD(Context context) {
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        registrarUsuario();
    }

    private void registrarUsuario() {
        ContentValues registro = new ContentValues();
        registro.put("Id_Cliente", Handler.cliente.getIdCliente());
        registro.put("Nombre", Handler.cliente.getNombre());
        registro.put("Genero", Handler.cliente.getGenero());
        registro.put("Telefono", Handler.cliente.getTelefono());
        registro.put("Correo", Handler.cliente.getCorreo());
        registro.put("Contrasenia", Handler.cliente.getContrasenia());
        registro.put("N_Tarjeta", Handler.cliente.getNtarjeta());
        registro.put("Limite_Saldo", Handler.cliente.getLimiteSaldo());
        registro.put("Saldo_Dis", Handler.cliente.getSaldoDisponible());
        baseDatos.insert("usuarios", null, registro);
    }

}