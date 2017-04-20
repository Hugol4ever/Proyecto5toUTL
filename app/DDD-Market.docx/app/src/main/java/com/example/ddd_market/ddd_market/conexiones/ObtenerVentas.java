package com.example.ddd_market.ddd_market.conexiones;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

/**
 * Created by hugo_ on 16/04/2017.
 */

public class ObtenerVentas {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;
    private Context context;

    public ObtenerVentas(Context context) {
        this.context = context;
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        registrarVentas();
    }

    private void registrarVentas() {
        ContentValues registro = new ContentValues();
        for (Venta v : Handler.ventas) {
            try {
                registro.put("Id_Venta", v.getIdVenta());
                registro.put("Fecha", Globals.FECHA.format(v.getFecha()));
                registro.put("Hora", Globals.HORA.format(v.getHora()));
                registro.put("total", v.getMonto());
                registro.put("Id_Cliente", Handler.cliente.getIdCliente());
                baseDatos.insert("ventas", null, registro);
            } catch (Exception ex) {
                Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show();
                Log.w("Prueba", "" + ex.toString());
            }
        }
        baseDatos.close();
    }

}
