package com.example.ddd_market.ddd_market.sinConexion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.conexiones.ObtenerProductos;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;

import java.util.ArrayList;

/**
 * Created by hugo_ on 10/04/2017.
 */

public class ObtenerProductosSC {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;
    private Context context;

    public ObtenerProductosSC(final Context context) {
        this.context = context;
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        obtenerProductos();
    }

    private void obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        Cursor fila = baseDatos.rawQuery("select * from producto", null);
        fila.moveToFirst();
        for (int i = 0; i < fila.getCount(); i++) {
            Producto p = new Producto();
            p.setIdProducto(fila.getInt(0));
            p.setNombre(fila.getString(1));
            p.setMarca(fila.getString(2));
            p.setCategoria(fila.getString(3));
            p.setExistencia(fila.getInt(4));
            p.setPrecio(fila.getDouble(5));
            p.setFoto("");
            productos.add(p);
            fila.moveToNext();
        }
        Handler.productos = productos;
        baseDatos.close();
    }

}