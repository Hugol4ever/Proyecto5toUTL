package com.example.ddd_market.ddd_market;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.modelo.DAO.Cliente;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private String usuario;
    private String password;
    private EditText usuarioV;
    private EditText passwordV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.usuarioV = (EditText) findViewById(R.id.txtUsuario);
        this.passwordV = (EditText) findViewById(R.id.txtPasword);

    }

    public void irPrincipal(View v){
        //Toast.makeText(Login.this, leer(usuarioV.getText().toString(), passwordV.getText().toString()), Toast.LENGTH_LONG).show();
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String resultado = leer(usuarioV.getText().toString(), passwordV.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<Cliente> c = obtDatosJSON(resultado);
                        if (c.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Usuario/Contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                        } else {
                            irPrincipal();
                        }
                    }
                });
            }
        };
        tr.start();
    }

    private void irPrincipal() {
        startActivity(new Intent(this, Main.class));
    }

    public String leer(String usuario, String pass) {
        HttpClient client = new DefaultHttpClient();
        HttpContext contexto = new BasicHttpContext();
        String ruta = "http://" + Globals.SERVIDOR + ":80/web_service/vistas/getDTOCliente.php" +
                "?user=" + usuario + "&password=" + pass;
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

    public ArrayList<Cliente> obtDatosJSON(String response) {
        ArrayList<Cliente> listado = new ArrayList<>();
        try{
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.optJSONArray("clientes");
            for (int i = 0; i < jsonArray.length(); i++) {
                listado.add(imp(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(), "Usuario/Contraseña incorrectos.", Toast.LENGTH_SHORT).show();
        }
        return listado;
    }

    public Cliente imp(JSONObject objetoJSON) {
        Cliente cliente = new Cliente();
        try {
            cliente.setIdCliente(objetoJSON.getInt("Id_Cliente"));
            cliente.setNombre(objetoJSON.getString("Nombre"));
            cliente.setGenero(objetoJSON.getString("Genero"));
            cliente.setTelefono(objetoJSON.getString("Telefono"));
            cliente.setCorreo(objetoJSON.getString("Correo"));
            cliente.setContrasenia(objetoJSON.getString("Contrasenia"));
            cliente.setNtarjeta(objetoJSON.getString("N_Tarjeta"));
            cliente.setLimiteSaldo(objetoJSON.getDouble("Limite_Saldo"));
            cliente.setSaldoDisponible(objetoJSON.getDouble("Saldo_Dis"));
        } catch (JSONException e) {
            //Toast.makeText(getApplicationContext(), "Usuario/Contraseña incorrectos.", Toast.LENGTH_SHORT).show();
        }
        return cliente;
    }

}
