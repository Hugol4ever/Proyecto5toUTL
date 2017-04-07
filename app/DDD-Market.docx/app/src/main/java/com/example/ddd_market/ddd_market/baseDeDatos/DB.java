package com.example.ddd_market.ddd_market.baseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by hugo_ on 06/04/2017.
 */

public class DB extends SQLiteOpenHelper {


    public DB(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "Id_Cliente integer primary key," +
                "Id_Usuario integer," +
                "Nombre text," +
                "Genero text," +
                "Telefono text," +
                "Correo text," +
                "Contrasenia text," +
                "N_Tarjeta text," +
                "Limite_Saldo double," +
                "Saldo_Dis double" +
                ")");

        db.execSQL("CREATE TABLE producto (" +
                "Id_Producto integer primary key," +
                "Nombre text," +
                "Marca text," +
                "Categoria text," +
                "Existencia int," +
                "Precio double" +
                ")");

        db.execSQL("CREATE TABLE promociones (" +
                "Id_Promocio integer primary key," +
                "Preco_Promo double," +
                "Fecha text," +
                "Dias_Duracion int," +
                "Nombre text," +
                "Precio double" +
                ")");

        db.execSQL("");

        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuarios");
        db.execSQL("CREATE TABLE usuarios (" +
                "Id_Cliente integer primary key," +
                "Id_Usuario integer," +
                "Nombre text," +
                "Genero text," +
                "Telefono text," +
                "Correo text," +
                "Contrasenia text," +
                "N_Tarjeta text," +
                "Limite_Saldo double," +
                "Saldo_Dis double" +
                ")");

        db.execSQL("drop table if exists producto");
        db.execSQL("CREATE TABLE producto (" +
                "Id_Producto integer primary key," +
                "Nombre text," +
                "Marca text," +
                "Categoria text," +
                "Existencia int," +
                "Precio double" +
                ")");

        db.execSQL("drop table if exists promociones");
        db.execSQL("CREATE TABLE promociones (" +
                "Id_Promocio integer primary key," +
                "Preco_Promo double," +
                "Fecha text," +
                "Dias_Duracion int," +
                "Nombre text," +
                "Precio double" +
                ")");

        db.execSQL("drop table if exists ventas");
        db.execSQL("");

        db.execSQL("drop table if exists detalle_venta");
        db.execSQL("");
    }
}
