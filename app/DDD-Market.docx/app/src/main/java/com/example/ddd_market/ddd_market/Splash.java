package com.example.ddd_market.ddd_market;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.conexiones.BackGround;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Cliente;

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
        //cargarHandlerProductos();
    }

    private void cargarHandlerProductos() {
        DB db = new DB(getApplicationContext(), Globals.NOMBRE_DB, null, Globals.VERSION_DB);
        SQLiteDatabase baseDatos = db.getWritableDatabase();

        Cursor fila = baseDatos.rawQuery("select * from usuarios", null);
        fila.moveToFirst();

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

    class miHilo extends Thread{

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
    }
}
