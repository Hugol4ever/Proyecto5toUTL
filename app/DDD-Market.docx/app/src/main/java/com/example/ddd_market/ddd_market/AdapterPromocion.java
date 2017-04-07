package com.example.ddd_market.ddd_market;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;

import java.util.List;

/**
 * Created by bvsr9 on 30/03/2017.
 */

public class AdapterPromocion extends ArrayAdapter<Promocion> {


    public AdapterPromocion(Context context, List<Promocion> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_producto, null);
        }

        ImageView imagen =(ImageView)convertView.findViewById(R.id.img);
        TextView nombre = (TextView)convertView.findViewById(R.id.nombre);
        TextView marca = (TextView)convertView.findViewById(R.id.marca);
        TextView categoria = (TextView)convertView.findViewById(R.id.categoria);
        TextView precio = (TextView)convertView.findViewById(R.id.precio);
        TextView promocio = (TextView)convertView.findViewById(R.id.precioPromo);

        Promocion item = getItem(position);
        new DownloadImageTask(imagen)
                .execute(item.getProducto().getFoto());
        nombre.setText(item.getProducto().getNombre());
        marca.setText(item.getProducto().getMarca());
        //marca.setTypeface(null, Typeface.STRIKETHRU);
        categoria.setText(item.getProducto().getCategoria());
        precio.setText("$"+item.getProducto().getPrecio());
        promocio.setText("$"+item.getPrecioPromo());
        precio.setPaintFlags(precio.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        return convertView;
    }
}
