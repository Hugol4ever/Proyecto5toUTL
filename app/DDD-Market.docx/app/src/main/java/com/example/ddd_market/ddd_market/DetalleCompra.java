package com.example.ddd_market.ddd_market;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.ddd_market.ddd_market.adapters.AdapterDetalleCompra;
import com.example.ddd_market.ddd_market.modelo.DAO.DetalleVenta;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

import java.util.ArrayList;

public class DetalleCompra extends AppCompatActivity {

    ListView listaDV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaDV = (ListView)findViewById(R.id.listaDetalleCompras);
        listaDV.setAdapter(new AdapterDetalleCompra(this, obtenerDetalle()));
    }

    public ArrayList obtenerDetalle(){
        ArrayList<DetalleVenta> detalle = new ArrayList<>();
        Venta venta = new Venta();
        venta.setIdVenta(1);
        venta.setMonto(15623);
        Producto producto = new Producto();
        producto.setNombre("Coca Cola");
        detalle.add(new DetalleVenta(2, 123, producto,venta));
        return detalle;
    }

}
