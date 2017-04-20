package com.example.ddd_market.ddd_market;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.adapters.AdapterDetalleCompra;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.DetalleVenta;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

import java.util.ArrayList;

public class DetalleCompra extends AppCompatActivity {

    private TextView noCompra;
    private TextView fecha;
    private TextView hora;
    private TextView total;

    ListView listaDV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);
        inicializar();
        cargar();
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
        return Handler.detalleVentas;
    }

    private void inicializar() {
        this.noCompra = (TextView)findViewById(R.id.tvNCompra);
        this.fecha = (TextView)findViewById(R.id.tvFecha);
        this.hora = (TextView)findViewById(R.id.tvHora);
    }

    private void cargar() {
        this.noCompra.setText((this.noCompra.getText().toString()) + Handler.detalleVentas.get(0).getVenta().getIdVenta());
        //this.fecha.setText((this.fecha.getText().toString()) + " " + Globals.FECHA.format(Handler.detalleVentas.get(0).getVenta().getFecha()));
        //this.hora.setText((this.hora.getText().toString()) + " " + Handler.detalleVentas.get(0).getVenta().getHora());
    }

}
