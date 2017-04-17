package com.example.ddd_market.ddd_market.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ddd_market.ddd_market.DownloadImageTask;
import com.example.ddd_market.ddd_market.R;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;

import java.io.InputStream;
import java.util.List;

/**
 * Created by bvsr9 on 26/03/2017.
 */

public class AdapterProducto extends ArrayAdapter<Producto> {


    public AdapterProducto(Context context, List<Producto> objects) {
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

        Producto item = getItem(position);
        new DownloadImageTask(imagen)
                .execute(item.getFoto());
        nombre.setText(item.getNombre());
        marca.setText(item.getMarca());
        categoria.setText(item.getCategoria());
        precio.setText("$"+item.getPrecio());

        return convertView;
    }
}
