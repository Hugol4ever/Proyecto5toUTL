package com.example.ddd_market.ddd_market.conexiones;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;

/**
 * Created by hugo_ on 10/04/2017.
 */

public class ObtenerPromociones {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;
    private Context context;

    public ObtenerPromociones(Context context) {
        this.context = context;
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        registrarPromociones();
    }

    private void registrarPromociones() {
        ContentValues registro = new ContentValues();
        for (Promocion p : Handler.promociones) {
            try {
                registro.put("Id_Promocion", p.getId());
                registro.put("Preco_Promo", p.getPrecioPromo());
                registro.put("Nombre", p.getProducto().getNombre());
                registro.put("Marca", p.getProducto().getMarca());
                registro.put("Categoria", p.getProducto().getCategoria());
                registro.put("Precio", p.getProducto().getPrecio());
                baseDatos.insert("promociones", null, registro);
            } catch (Exception ex) {
                Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show();
                Log.w("Prueba", "" + ex.toString());
            }
        }
        baseDatos.close();
    }

}
