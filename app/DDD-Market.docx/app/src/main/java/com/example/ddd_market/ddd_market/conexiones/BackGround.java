package com.example.ddd_market.ddd_market.conexiones;

import android.content.Context;
import android.os.AsyncTask;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;

/**
 * Created by hugo_ on 06/04/2017.
 */

public class BackGround extends AsyncTask <Void, Void, Void> {

    private Context context;

    public BackGround(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        registrarBD();
        return null;
    }

    private void registrarBD() {
        RegistrarEnBD registrarEnBD = new RegistrarEnBD(context);
    }

}