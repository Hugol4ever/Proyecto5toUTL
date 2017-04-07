package com.example.ddd_market.ddd_market.conexiones;

import android.app.Activity;

import com.example.ddd_market.ddd_market.commons.Globals;
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

public class ObtenerProductos extends Activity {

    private ArrayList<Producto> productos;

    public ObtenerProductos() {
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String resultado = leer();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        productos = obtDatosJSON(resultado);
                    }
                });
            }
        };
        tr.start();
    }

    private String leer() {
        HttpClient client = new DefaultHttpClient();
        HttpContext contexto = new BasicHttpContext();
        HttpGet httpGet = new HttpGet("http://" + Globals.SERVIDOR + ":80/web_service/vistas/getDTOProducto.php");
        String resultado = null;
        try{
            HttpResponse response = client.execute(httpGet, contexto);
            HttpEntity entity = response.getEntity();
            resultado = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private ArrayList<Producto> obtDatosJSON(String response) {
        ArrayList<Producto> listado = new ArrayList<>();
        try{
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.optJSONArray("productos");
            for (int i = 0; i < jsonArray.length(); i++) {
                listado.add(imp(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listado;
    }

    private Producto imp(JSONObject objetoJSON) {
        Producto p = new Producto();
        try {
            p.setIdProducto(objetoJSON.getInt("Id_Producto"));
            p.setNombre(objetoJSON.getString("Nombre"));
            p.setMarca(objetoJSON.getString("Marca"));
            p.setCategoria(objetoJSON.getString("Categoria"));
            p.setExistencia(objetoJSON.getInt("Existencia"));
            p.setPrecio(objetoJSON.getDouble("Precio"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
}
