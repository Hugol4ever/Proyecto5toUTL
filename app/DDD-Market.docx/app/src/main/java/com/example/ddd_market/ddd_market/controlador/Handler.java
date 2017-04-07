package com.example.ddd_market.ddd_market.controlador;

import com.example.ddd_market.ddd_market.modelo.DAO.Cliente;
import com.example.ddd_market.ddd_market.modelo.DAO.DetalleVenta;
import com.example.ddd_market.ddd_market.modelo.DAO.Producto;
import com.example.ddd_market.ddd_market.modelo.DAO.Promocion;
import com.example.ddd_market.ddd_market.modelo.DAO.Venta;

import java.util.ArrayList;

/**
 * Created by hugo_ on 06/04/2017.
 */

public class Handler {

    public static ArrayList<Producto> productos;
    public static ArrayList<Venta> ventas;
    public static Cliente cliente;
    public static ArrayList<Promocion> promociones;
    public static ArrayList<DetalleVenta> detalleVentas;

}
