package com.example.ddd_market.ddd_market.conexiones;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Cliente;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hugo_ on 06/04/2017.
 */

public class ObtenerProductos {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;
    private Context context;

    public ObtenerProductos(Context context) {
        this.context = context;
        this.baseDeDatos = new DB(context, Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
        registrarProductos();
    }

    private void registrarProductos() {
        ContentValues registro = new ContentValues();
        for (Producto p : Handler.productos) {
            try {
                registro.put("Id_Producto", p.getIdProducto());
                registro.put("Nombre", p.getNombre());
                registro.put("Marca", p.getMarca());
                registro.put("Categoria", p.getCategoria());
                registro.put("Existencia", p.getExistencia());
                registro.put("Precio", p.getPrecio());
                baseDatos.insert("producto", null, registro);
            } catch (Exception ex) {
                Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        baseDatos.close();
    }

}