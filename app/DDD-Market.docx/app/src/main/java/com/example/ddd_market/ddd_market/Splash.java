package com.example.ddd_market.ddd_market;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.conexiones.BackGround;
import com.example.ddd_market.ddd_market.conexiones.ObtenerProductos;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Cliente;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;
import com.example.ddd_market.ddd_market.sinConexion.ObtenerProductosSC;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Splash extends AppCompatActivity {

    ImageView lgSplash;
    Animation aumentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        lgSplash = (ImageView)findViewById(R.id.logoSplash);

        miHilo xx = new miHilo();
        xx.start();
        aumentar = AnimationUtils.loadAnimation(this, R.anim.ampliar);
        aumentar.reset();
        lgSplash.setAnimation(aumentar);
    }

    private void cargarHandlerCliente() {
        DB db = new DB(getApplicationContext(), Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        SQLiteDatabase baseDatos = db.getWritableDatabase();

        Cursor fila = baseDatos.rawQuery("select * from usuarios", null);
        fila.moveToFirst();
        Cliente c = new Cliente();
        c.setIdCliente(fila.getInt(0));
        c.setNombre(fila.getString(1));
        c.setGenero(fila.getString(2));
        c.setTelefono(fila.getString(3));
        c.setCorreo(fila.getString(4));
        c.setContrasenia(fila.getString(5));
        c.setNtarjeta(fila.getString(6));
        c.setLimiteSaldo(fila.getDouble(7));
        c.setSaldoDisponible(fila.getDouble(8));
        Handler.cliente = c;
        baseDatos.close();
    }

    public void irLogin(){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void irPrincipal() {
        cargarHandlerCliente();
        Intent i = new Intent(this, Main.class);
        startActivity(i);
    }

    class miHilo extends Thread {

        private void isOnlineNet() {
            HttpClient client = new DefaultHttpClient();
            HttpContext contexto = new BasicHttpContext();
            String ruta = "http://" + Globals.SERVIDOR + ":80/web_service/vistas/getDTOProducto.php";
            HttpGet httpGet = new HttpGet(ruta);
            try {
                HttpResponse response = client.execute(httpGet, contexto);
                Handler.conexion = true;
            } catch (IOException e) {
                e.printStackTrace();
                Handler.conexion = false;
            }
        }

        @Override
        public void run(){
            for(int i =0;i<=7;i++){
                i++;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (comprobarUsuario()) {
                isOnlineNet();
                if (Handler.conexion) {
                    llenarHandlerProductosRed();
                } else {
                    ObtenerProductosSC op = new ObtenerProductosSC(getApplicationContext());
                }
                irPrincipal();
            } else {
                irLogin();
            }
        }

        private boolean comprobarUsuario() {
            DB db = new DB(getApplicationContext(), Globals.NOMBRE_DB, null, Globals.VERSION_DB);
            SQLiteDatabase baseDatos = db.getWritableDatabase();
            Cursor fila = baseDatos.rawQuery("select * from usuarios", null);
            fila.moveToFirst();
            if (fila.isFirst()) {
                return true;
            } else {
                return false;
            }
        }

        private void llenarHandlerProductosRed() {
            Thread tr = new Thread() {
                @Override
                public void run() {
                    final String resultadoP = leerP();
                    final String resultadoPP = leerPP();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Handler.productos = obtDatosJSONP(resultadoP);
                            ObtenerProductos op = new ObtenerProductos(getApplicationContext());
                            Handler.promociones = obtDatosJSONPP(resultadoPP);
                        }
                    });
                }
            };
            tr.start();
        }

        private String leerP() {
            HttpClient client = new DefaultHttpClient();
            HttpContext contexto = new BasicHttpContext();
            String ruta = "http://" + Globals.SERVIDOR + ":80/web_service/vistas/getDTOProducto.php";
            HttpGet httpGet = new HttpGet(ruta);
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

        private ArrayList<Producto> obtDatosJSONP(String response) {
            ArrayList<Producto> listado = new ArrayList<>();
            try{
                JSONObject object = new JSONObject(response);
                JSONArray jsonArray = object.optJSONArray("productos");
                for (int i = 0; i < jsonArray.length(); i++) {
                    listado.add(impP(jsonArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error al leer JSON.", Toast.LENGTH_SHORT).show();
            }
            return listado;
        }

        private Producto impP(JSONObject objetoJSON) {
            Producto producto = new Producto();
            try {
                producto.setIdProducto(objetoJSON.getInt("Id_Producto"));
                producto.setNombre(objetoJSON.getString("Nombre"));
                producto.setMarca(objetoJSON.getString("Marca"));
                producto.setCategoria(objetoJSON.getString("Categoria"));
                producto.setExistencia(objetoJSON.getInt("Existencia"));
                producto.setPrecio(objetoJSON.getDouble("Precio"));
                producto.setFoto(Globals.SERVIDOR_IMAGENES + objetoJSON.getString("Foto"));
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), "Error al leer el objeto.", Toast.LENGTH_SHORT).show();
            }
            return producto;
        }

        private String leerPP() {
            HttpClient client = new DefaultHttpClient();
            HttpContext contexto = new BasicHttpContext();
            String ruta = "http://" + Globals.SERVIDOR + ":80/web_service/vistas/getDTOPromociones.php";
            HttpGet httpGet = new HttpGet(ruta);
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

        private ArrayList<Promocion> obtDatosJSONPP(String response) {
            ArrayList<Promocion> listado = new ArrayList<>();
            try{
                JSONObject object = new JSONObject(response);
                JSONArray jsonArray = object.optJSONArray("promociones");
                for (int i = 0; i < jsonArray.length(); i++) {
                    listado.add(impPP(jsonArray.getJSONObject(i)));
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error al leer JSON.", Toast.LENGTH_SHORT).show();
            }
            return listado;
        }

        private Promocion impPP(JSONObject objetoJSON) {
            Promocion promocion = new Promocion();
            try {
                promocion.setId(objetoJSON.getInt("Id_Promocion"));
                promocion.setPrecioPromo(objetoJSON.getDouble("Precio_Promo"));
                //promocion.setFecha(objetoJSON.getString("Fecha"));
                promocion.setDiasDuracion(objetoJSON.getInt("Dias_Duracion"));
                promocion.setProducto(new Producto());
                promocion.getProducto().setNombre(objetoJSON.getString("Nombre"));
                promocion.getProducto().setPrecio(objetoJSON.getDouble("Precio"));
                promocion.getProducto().setMarca(objetoJSON.getString("Marca"));
                promocion.getProducto().setCategoria(objetoJSON.getString("Categoria"));
                promocion.getProducto().setFoto(Globals.SERVIDOR_IMAGENES + objetoJSON.getString("Foto"));
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), "Error al leer el objeto.", Toast.LENGTH_SHORT).show();
            }
            return promocion;
        }
    }
}
