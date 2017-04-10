package com.example.ddd_market.ddd_market;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;

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

public class Main extends ActionBarActivity implements Principal.OnFragmentInteractionListener,
        PerfilFragment.OnFragmentInteractionListener, ProductoFragment.OnFragmentInteractionListener,
        PromocionFragment.OnFragmentInteractionListener, ComprasFragment.OnFragmentInteractionListener{

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isOnlineNet();
        setContentView(R.layout.activity_main);

        itemTitle = activityTitle = getTitle();
        tagTitles = getResources().getStringArray(R.array.Tags);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        // Setear una sombra sobre el contenido principal cuando el drawer se despliegue
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        //Crear elementos de la lista
        ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();
        items.add(new DrawerItem(tagTitles[0], R.drawable.m_principal));
        items.add(new DrawerItem(tagTitles[1], R.drawable.m_perfil));
        items.add(new DrawerItem(tagTitles[2], R.drawable.m_productos));
        items.add(new DrawerItem(tagTitles[3], R.drawable.m_promo));
        items.add(new DrawerItem(tagTitles[4], R.drawable.m_compras));
        items.add(new DrawerItem(tagTitles[5], R.drawable.m_salir));


        // Relacionar el adaptador y la escucha de la lista del drawer
        drawerList.setAdapter(new DrawerListAdapter(this, items));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Habilitar el icono de la app por si hay algún estilo que lo deshabilitó
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);


        // Crear ActionBarDrawerToggle para la apertura y cierre
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(itemTitle);
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(activityTitle);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
        if (Handler.conexion) {
            Thread tr = new Thread() {
                @Override
                public void run() {
                    final String resultadoP = leerP();
                    final String resultadoPP = leerPP();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Handler.productos = obtDatosJSONP(resultadoP);
                            Handler.promociones = obtDatosJSONPP(resultadoPP);
                        }
                    });
                }
            };
            tr.start();
        } else {

        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = new Principal();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        drawerList.setItemChecked(0, true);
        setTitle(tagTitles[0]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            // Toma los eventos de selección del toggle aquí
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        //cambiar de fragmento
        Boolean transicion =false;
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new Principal();
                transicion = true;
                break;
            case 1:
                fragment = new PerfilFragment();
                transicion = true;
                break;
            case 2:
                fragment = new ProductoFragment();
                transicion=true;
                break;
            case 3:
                fragment = new PromocionFragment();
                transicion = true;
                break;
            case 4:
                fragment = new ComprasFragment();
                transicion = true;
                break;
            case 5:
                AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
                mensaje.setMessage("¿Desea cerrar sesión?")
                        .setTitle("DDD")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int id) {
                                        cerrarSesion();
                                    }
                                })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = mensaje.create();
                alertDialog.show();
                break;
        }


        if(transicion){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
            drawerList.setItemChecked(position, true);
            setTitle(tagTitles[position]);
        }
        drawerLayout.closeDrawer(drawerList);

    }

    private void cerrarSesion() {
        DB baseDeDatos = new DB(getApplicationContext(), Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        SQLiteDatabase baseDatos = baseDeDatos.getWritableDatabase();
        baseDatos.delete("usuarios", "Id_Cliente = " + Handler.cliente.getIdCliente(), null);
        baseDatos.close();
        startActivity(new Intent(this, Splash.class));
    }

    /* Método auxiliar para setear el titulo de la action bar */
    @Override
    public void setTitle(CharSequence title) {
        itemTitle = title;
        getSupportActionBar().setTitle(itemTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sincronizar el estado del drawer
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cambiar las configuraciones del drawer si hubo modificaciones
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void isOnlineNet() {
        try {
            Thread tr = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        HttpClient client = new DefaultHttpClient();
                        HttpContext contexto = new BasicHttpContext();
                        HttpGet httpGet = new HttpGet("http://" + Globals.SERVIDOR + ":80/vistas/getDTOProducto.php");
                        try {
                            HttpResponse response = client.execute(httpGet, contexto);
                            Handler.conexion = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            Handler.conexion = false;
                        }
                        try {
                            sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            tr.start();
        } catch (Exception e) {
            e.printStackTrace();
            Handler.conexion = false;
        }
    }

    public String leerP() {
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

    public ArrayList<Producto> obtDatosJSONP(String response) {
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

    public Producto impP(JSONObject objetoJSON) {
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

    public String leerPP() {
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

    public ArrayList<Promocion> obtDatosJSONPP(String response) {
        ArrayList<Promocion> listado = new ArrayList<>();
        try{
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.optJSONArray("productos");
            for (int i = 0; i < jsonArray.length(); i++) {
                listado.add(impPP(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al leer JSON.", Toast.LENGTH_SHORT).show();
        }
        return listado;
    }

    public Promocion impPP(JSONObject objetoJSON) {
        Promocion promocion = new Promocion();
        try {
            /**promocion.setId(objetoJSON.getInt("Id_Promocion"));
            promocion.setNombre(objetoJSON.getString("Nombre"));
            promocion.setMarca(objetoJSON.getString("Marca"));
            promocion.setCategoria(objetoJSON.getString("Categoria"));
            promocion.setExistencia(objetoJSON.getInt("Existencia"));
            promocion.setPrecio(objetoJSON.getDouble("Precio"));
            promocion.setFoto(objetoJSON.getString("Foto"));*/
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al leer el objeto.", Toast.LENGTH_SHORT).show();
        }
        return promocion;
    }

}