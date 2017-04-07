package com.example.ddd_market.ddd_market.conexiones;

import android.os.AsyncTask;
import com.example.ddd_market.ddd_market.controlador.Handler;
/**
 * Created by hugo_ on 06/04/2017.
 */

public class BackGround extends AsyncTask <Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... params) {
        obtenerProductos();

        registrarBD();
        return null;
    }

    private void obtenerProductos() {
        ObtenerProductos op = new ObtenerProductos();
        Handler.productos = op.getProductos();
    }

    private void registrarBD() {
        RegistrarEnBD registrarEnBD = new RegistrarEnBD();
    }
}
