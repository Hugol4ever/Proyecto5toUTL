package com.example.ddd_market.ddd_market.sinConexion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by hugo_ on 16/04/2017.
 */

public class ObtenerComprasSC {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;
    private Context context;

    public ObtenerComprasSC(final Context context) {
        this.context = context;
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        try {
            obtenerVentas();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void obtenerVentas() throws ParseException {
        ArrayList<Venta> ventas = new ArrayList<>();
        Cursor fila = baseDatos.rawQuery("select * from ventas", null);
        fila.moveToFirst();
        for (int i = 0; i < fila.getCount(); i++) {
            Venta v = new Venta();
            v.setIdVenta(fila.getInt(0));
            v.setMonto(fila.getDouble(1));
            v.setFecha(Globals.FECHA.parse(fila.getString(2)));
            v.setHora(Globals.HORA.parse(fila.getString(3)));
            ventas.add(v);
            fila.moveToNext();
        }
        Handler.ventas = ventas;
        baseDatos.close();
    }

}
