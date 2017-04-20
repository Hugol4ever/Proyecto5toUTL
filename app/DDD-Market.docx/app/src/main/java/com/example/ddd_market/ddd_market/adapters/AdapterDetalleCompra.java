package com.example.ddd_market.ddd_market.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ddd_market.ddd_market.R;
import com.example.ddd_market.ddd_market.modelo.DAO.DetalleVenta;

import java.util.List;

/**
 * Created by bvsr9 on 26/03/2017.
 */

public class AdapterDetalleCompra extends ArrayAdapter<DetalleVenta> {


    public AdapterDetalleCompra(Context context, List<DetalleVenta> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_det_compras, null);
        }

        TextView subTotal =(TextView) convertView.findViewById(R.id.tvSubTotal);
        TextView nombre =(TextView) convertView.findViewById(R.id.tvNomProducto);
        TextView cantidad =(TextView) convertView.findViewById(R.id.tvCantidad);
        TextView monto = (TextView)convertView.findViewById(R.id.tvCosto);
        TextView n = (TextView)convertView.findViewById(R.id.tvN);

        DetalleVenta item = getItem(position);
        n.setText(""+(position+1));
        String name = item.getProducto().getNombre();
        if(name.length()>12){
            String subText=name.substring(0,10);
            name = subText+"...";
        }
        nombre.setText(name);
        cantidad.setText("" + item.getCantidad());
        monto.setText("$"+item.getPrecio());
        subTotal.setText("$"+(item.getCantidad()*item.getPrecio()));

        return convertView;
    }
}
