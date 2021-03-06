package com.example.ddd_market.ddd_market;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;

public class DetalleDeProducto extends AppCompatActivity {

    private ImageView imagen;
    private TextView nombre;
    private TextView marca;
    private TextView categoria;
    private TextView existencia;
    private TextView precio;
    private TextView precioPromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_producto);

        //Desabilitar toolbar
        getSupportActionBar().hide();

        inicializarComponentes();
        new DownloadImageTask(this.imagen).execute(Handler.producto.getFoto());
        this.nombre.setText(Handler.producto.getNombre());
        this.marca.setText(Handler.producto.getMarca());
        this.categoria.setText(Handler.producto.getCategoria());
        this.precio.setText("" + Handler.producto.getPrecio());
        if(Handler.isProductoPromocion) {
            this.existencia.setVisibility(View.INVISIBLE);
            this.precioPromo.setVisibility(View.VISIBLE);
            precio.setPaintFlags(precio.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            for (Promocion p : Handler.promociones) {
                if (p.getProducto().getIdProducto() == Handler.producto.getIdProducto()) {
                    this.precioPromo.setText("" + p.getPrecioPromo());
                    break;
                }
            }
        } else {
            this.existencia.setVisibility(View.VISIBLE);
            this.existencia.setText("" + Handler.producto.getExistencia());
            this.precioPromo.setVisibility(View.INVISIBLE);
        }

    }

    private void inicializarComponentes() {
        this.imagen = (ImageView)findViewById(R.id.imageView);
        this.nombre = (TextView)findViewById(R.id.tvNombreP);
        this.marca = (TextView)findViewById(R.id.tvMarcaP);
        this.categoria = (TextView)findViewById(R.id.tvCategoriaP);
        this.existencia = (TextView)findViewById(R.id.tvExistenciaP);
        this.precio = (TextView)findViewById(R.id.tvPrecio);
        this.precioPromo = (TextView)findViewById(R.id.textView2);
    }
}
