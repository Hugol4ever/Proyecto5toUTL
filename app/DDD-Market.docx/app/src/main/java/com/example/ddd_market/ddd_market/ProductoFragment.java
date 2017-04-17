package com.example.ddd_market.ddd_market;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.adapters.AdapterProducto;
import com.example.ddd_market.ddd_market.controlador.Handler;

import java.util.ArrayList;

public class ProductoFragment extends Fragment {
    ListView listaP;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProductoFragment() {

    }

    public static ProductoFragment newInstance(String param1, String param2) {
        ProductoFragment fragment = new ProductoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto, container, false);
        listaP =(ListView)view.findViewById(R.id.listaProductos);
        if (Handler.productos != null) {
            listaP.setAdapter(new AdapterProducto(ProductoFragment.super.getContext(), obtenerProductos()));
            listaP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    irDetalle(position);
                }
            });
        } else {
            Toast.makeText(getContext(), "No hay productos disponibles.", Toast.LENGTH_LONG).show();
        }
        return view;
    }

    private void irDetalle(int id) {
        Handler.producto = Handler.productos.get(id);
        Handler.isProductoPromocion = false;
        startActivity(new Intent(getContext(), DetalleProducto.class));
    }

    public ArrayList obtenerProductos(){
        return Handler.productos;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}