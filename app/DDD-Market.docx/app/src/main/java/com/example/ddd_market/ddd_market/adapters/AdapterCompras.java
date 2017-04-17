package com.example.ddd_market.ddd_market.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ddd_market.ddd_market.R;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by bvsr9 on 04/04/2017.
 */

public class AdapterCompras extends ArrayAdapter<Venta> {

    public AdapterCompras(Context context, List<Venta> objects){super(context, 0, objects);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_compras, null);
        }

        TextView fecha = (TextView)convertView.findViewById(R.id.tvFecha);
        TextView monto = (TextView)convertView.findViewById(R.id.tvMonto);

        Venta item = getItem(position);
        DateFormat fechaFormato = new SimpleDateFormat("dd-MM-yyyy");
        fecha.setText(fechaFormato.format(item.getFecha()));
        monto.setText("$"+item.getMonto());
        return convertView;
    }
}
