package com.example.ddd_market.ddd_market.sinConexion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;

import java.util.ArrayList;

/**
 * Created by hugo_ on 10/04/2017.
 */

public class ObtenerPromocionesSC {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;
    private Context context;

    public ObtenerPromocionesSC(final Context context) {
        this.context = context;
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        obtenerPromociones();
    }

    private void obtenerPromociones() {
        ArrayList<Promocion> promociones = new ArrayList<>();
        Cursor fila = baseDatos.rawQuery("select * from promociones", null);
        fila.moveToFirst();
        for (int i = 0; i < fila.getCount(); i++) {
            Promocion p = new Promocion();
            p.setId(fila.getInt(0));
            p.setPrecioPromo(fila.getDouble(1));
            p.setProducto(new Producto());
            p.getProducto().setNombre(fila.getString(2));
            p.getProducto().setMarca(fila.getString(3));
            p.getProducto().setCategoria(fila.getString(4));
            p.getProducto().setPrecio(fila.getDouble(5));
            p.getProducto().setFoto("");
            promociones.add(p);
            fila.moveToNext();
        }
        Handler.promociones = promociones;
        baseDatos.close();
    }

}