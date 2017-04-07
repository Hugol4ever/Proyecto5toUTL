package com.example.ddd_market.ddd_market.conexiones;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.ddd_market.ddd_market.baseDeDatos.DB;
import com.example.ddd_market.ddd_market.commons.Globals;

/**
 * Created by hugo_ on 06/04/2017.
 */

public class RegistrarEnBD extends Activity {

    private DB baseDeDatos;
    private SQLiteDatabase baseDatos;

    public RegistrarEnBD() {
        this.baseDeDatos = new DB(getApplicationContext(), "DDD", null, Globals.VERSION_DB);
        this.baseDatos = this.baseDeDatos.getWritableDatabase();
    }


}
