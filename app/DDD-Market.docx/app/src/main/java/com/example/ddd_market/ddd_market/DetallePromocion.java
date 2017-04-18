package com.example.ddd_market.ddd_market;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetallePromocion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_promocion);

        //Eliminar Toolbar
        getSupportActionBar().hide();
    }
}
