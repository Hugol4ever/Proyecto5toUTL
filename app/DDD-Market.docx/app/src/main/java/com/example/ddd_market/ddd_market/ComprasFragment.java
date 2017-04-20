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

import com.example.ddd_market.ddd_market.adapters.AdapterCompras;
import com.example.ddd_market.ddd_market.commons.Globals;
import com.example.ddd_market.ddd_market.conexiones.ObtenerVentas;
import com.example.ddd_market.ddd_market.controlador.Handler;
import com.example.ddd_market.ddd_market.modelo.DAO.DetalleVenta;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComprasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComprasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComprasFragment extends Fragment {
    ListView listaC;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ComprasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComprasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComprasFragment newInstance(String param1, String param2) {
        ComprasFragment fragment = new ComprasFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compras, container, false);
        listaC =(ListView)view.findViewById(R.id.listaCompras);
        if (Handler.ventas != null) {
            ArrayList<Venta> arreglo = Handler.ventas;
            listaC.setAdapter(new AdapterCompras(ComprasFragment.super.getContext(), arreglo));
            listaC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (Handler.conexion) {
                        irDetalle(position);
                    } else {
                        Toast.makeText(getContext(), "No puede ver el detalle de sus ventas" +
                                "\nsi no tiene conexión a Internet.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            Toast.makeText(getContext(), "No hay ventas disponibles.", Toast.LENGTH_LONG).show();
        }
        return view;
    }

    private void irDetalle(int id) {
        final int idVenta = Handler.ventas.get(id).getIdVenta();
        final double monto = Handler.ventas.get(id).getMonto();
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String resultado = leer(idVenta);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Handler.detalleVentas = obtDatosJSONC(resultado);
                        Handler.detalleVentas.get(0).getVenta().setMonto(monto);
                        startActivity(new Intent(getContext(), DetalleCompra.class));
                    }
                });
            }
        };
        tr.start();
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private String leer(int id) {
        HttpClient client = new DefaultHttpClient();
        HttpContext contexto = new BasicHttpContext();
        String ruta = "http://" + Globals.SERVIDOR + ":80/web_service/vistas/getDTODetalleCompra.php?id=" + id;
        HttpGet httpGet = new HttpGet(ruta);
        String resultado = null;
        try{
            HttpResponse response = client.execute(httpGet, contexto);
            HttpEntity entity = response.getEntity();
            resultado = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            Toast.makeText(getContext(), "Error con la ruta. -> " + e.toString(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    private ArrayList<DetalleVenta> obtDatosJSONC(String response) {
        ArrayList<DetalleVenta> listado = new ArrayList<>();
        try{
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.optJSONArray("detalleCompra");
            for (int i = 0; i < jsonArray.length(); i++) {
                listado.add(imp(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Error al leer JSON.", Toast.LENGTH_SHORT).show();
        }
        return listado;
    }

    private DetalleVenta imp(JSONObject objetoJSON) {
        DetalleVenta detalleVenta = new DetalleVenta();
        try {
            detalleVenta.setVenta(new Venta());
            detalleVenta.getVenta().setIdVenta(objetoJSON.getInt("Id_Venta"));
            detalleVenta.setProducto(new Producto());
            detalleVenta.getProducto().setNombre(objetoJSON.getString("Nombre"));
            detalleVenta.setCantidad(objetoJSON.getInt("Cantidad"));
            detalleVenta.setPrecio(objetoJSON.getDouble("preciodv"));
            detalleVenta.getProducto().setPrecio(objetoJSON.getDouble("Precio"));
            detalleVenta.getVenta().setFecha(Globals.FECHA.parse(objetoJSON.getString("Fecha")));
            detalleVenta.getVenta().setHora(Globals.HORA.parse(objetoJSON.getString("Hora")));
        } catch (JSONException e) {
            Toast.makeText(getContext(), "Error al leer el objeto.", Toast.LENGTH_SHORT).show();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return detalleVenta;
    }

}