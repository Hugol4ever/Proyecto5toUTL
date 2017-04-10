package com.example.ddd_market.ddd_market;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.Cliente;
import com.example.ddd_market.ddd_market.modelo.DAO.Usuario;

public class PerfilFragment extends Fragment {

    private Cliente c = Handler.cliente;
    private TextView nombreCliente;
    private TextView telefono;
    private TextView genero;
    private TextView numeroTarjeta;
    private TextView limiteSaldo;
    private TextView saldoDisponible;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        nombreCliente = (TextView) view.findViewById(R.id.txtUsuario);
        telefono = (TextView) view.findViewById(R.id.txtTelefono);
        genero = (TextView) view.findViewById(R.id.txtGenero);
        numeroTarjeta = (TextView) view.findViewById(R.id.txtNumTarjeta);
        limiteSaldo = (TextView) view.findViewById(R.id.txtLimiSaldo);
        saldoDisponible = (TextView) view.findViewById(R.id.txtSaldoDis);
        inicializar();

        return view;
    }

    private void inicializar() {
        nombreCliente.setText(Handler.cliente.getNombre());
        telefono.setText(Handler.cliente.getTelefono());
        genero.setText(Handler.cliente.getGenero());
        numeroTarjeta.setText(Handler.cliente.getNtarjeta());
        limiteSaldo.setText("" + Handler.cliente.getLimiteSaldo());
        saldoDisponible.setText("" + Handler.cliente.getSaldoDisponible());
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
