package controlador;

import app.Ventas;
import commons.Globals;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.Cliente;
import modelo.DAO.DetalleVenta;
import modelo.DAO.Producto;
import modelo.DTO.DTODetalleVenta;
import modelo.DTO.DTOVenta;
import modelo.DTO.DTOproducto;
import mprlib.MprCommands;
import mprlib.MprManager;

/**
 *
 * @author hugol
 */
public class VentaController {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private Lectura lectura;
    private MprManager mpr;
    private DTOproducto producto;
    private JTable tabla;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     * 
     * @param venta
     * @param tabla
     * @throws Exception 
     */
    public VentaController(Ventas venta, JTable tabla) throws Exception {
        this.producto = new DTOproducto();
        String puerto = Globals.COM;
        mpr = new MprManager(puerto, 9600);
        mpr.setByteSeparator("-");
        if (!mpr.connect()) {
            throw new Exception("No hay Comunicacion camarita");
        }
        lectura = new Lectura(mpr, venta.getTblProductos(), producto, venta.getjLabel5());
        lectura.start();
        this.tabla = tabla;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * 
     * 
     * @return 
     */
    public MprManager getMpr() {
        return mpr;
    }

    /**
     * 
     * 
     * @param cliente
     * @param tablita 
     */
    public void registrarVenta(Cliente cliente, JTable tablita) {
        try {
            DTODetalleVenta dtoDetalle;
            DetalleVenta detalle;
            Producto producto;

            DTOVenta dtoV = new DTOVenta();
            modelo.DAO.Venta venta = new modelo.DAO.Venta();
            venta.setCliente(cliente);
            venta.setIdVenta(dtoV.insert(venta));

            //Insertar detalle
            for (int i = 0; i < tablita.getRowCount(); i++) {
                dtoDetalle = new DTODetalleVenta();
                detalle = new DetalleVenta();
                producto = new Producto();
                producto.setIdProducto(Integer.parseInt(String.valueOf(tablita.getValueAt(i, 0))));
                detalle.setVenta(venta);
                detalle.setProducto(producto);
                detalle.setCantidad(Integer.parseInt(String.valueOf(tablita.getValueAt(i, 2))));
                detalle.setPrecio(Double.parseDouble(String.valueOf(tablita.getValueAt(i, 3))));

                dtoDetalle.insert(detalle);
            }

            JOptionPane.showMessageDialog(null, "Registro agregado", "Moviento realizado con exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Fallo conexión con BD", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void getProductoPorId(int id, JTable table, JLabel totales) throws SQLException {
        String[] array = new DTOproducto().ListaProductoPorId(id);
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        if (modelo.getRowCount() == 0) {
            String[] arreglo = new String[5];
            arreglo[0] = array[0];
            arreglo[1] = array[1];
            arreglo[2] = "1";
            arreglo[3] = array[2];
            arreglo[4] = String.valueOf((Double.parseDouble(arreglo[2])) * (Double.parseDouble(arreglo[3])));
            modelo.addRow(arreglo);
        } else {
            boolean bandera = true;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idTabla = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                if (idTabla == id) {
                    int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString()) + 1;
                    double precio = (double) cantidad * Double.parseDouble(modelo.getValueAt(i, 3).toString());
                    modelo.setValueAt(cantidad, i, 2);
                    modelo.setValueAt(precio, i, 4);
                    bandera = false;
                    break;
                }
            }
            if (bandera) {
                String[] arreglo = new String[5];
                arreglo[0] = array[0];
                arreglo[1] = array[1];
                arreglo[2] = "1";
                arreglo[3] = array[2];
                arreglo[4] = String.valueOf((Double.parseDouble(arreglo[2])) * (Double.parseDouble(arreglo[3])));
                modelo.addRow(arreglo);
            }
        }
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += Double.parseDouble(modelo.getValueAt(i, 4).toString());
        }
        totales.setText("" + total);
    }
    //</editor-fold>
    
}

class Lectura extends Thread {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    MprManager fox;
    String datoByte;
    String datoAscii;
    JTable tabla;
    DTOproducto producto;
    JLabel totales;
    ArrayList<String> lista;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * 
     * 
     * @param mpr
     * @param tabla
     * @param producto
     * @param total 
     */
    public Lectura(MprManager mpr, JTable tabla, DTOproducto producto, JLabel total) {
        this.lista = new ArrayList<>();
        fox = mpr;
        datoByte = datoAscii = null;
        this.tabla = tabla;
        this.producto = producto;
        this.totales = total;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Método "run"">
    /**
     * 
     */
    @Override
    public void run() {
        configurarTabla();
        try {
            while (true) {
                leer();
            }
        } catch (Exception e) {
            System.out.println("Error al leer tag");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    /**
     * 
     */
    private void leer() {
        try {
            datoByte = fox.readOneTagID(MprCommands.TagProtocol.EPC_C1G2, 1);
            datoAscii = convertirBytes(datoByte);
            datoAscii = datoAscii.trim();
            System.out.println("Dato en Bytes: " + datoByte);
            System.out.println("Dato leido: " + datoAscii);
            getProductoPorId(Integer.parseInt(datoAscii), tabla);
        } catch (Exception e) {
            System.out.println("Error -> " + e);
        }
    }
    
    /**
     * 
     * 
     * @param id
     * @param table
     * @throws SQLException 
     */
    private void getProductoPorId(int id, JTable table) throws SQLException {
        String[] array = new DTOproducto().ListaProductoPorId(Integer.parseInt(String.valueOf(id).substring(0, 3)));
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        if (modelo.getRowCount() == 0) {
            String[] arreglo = new String[5];
            arreglo[0] = array[0];
            arreglo[1] = array[1];
            arreglo[2] = "1";
            arreglo[3] = array[2];
            arreglo[4] = String.valueOf((Double.parseDouble(arreglo[2])) * (Double.parseDouble(arreglo[3])));
            this.lista.add(String.valueOf(id));
            modelo.addRow(arreglo);
        } else {
            boolean bandera = true;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idTabla = Integer.parseInt(this.lista.get(i).substring(0, 3));
                if ((idTabla == Integer.parseInt(String.valueOf(id).substring(0, 3))) && verificar(id)) {
                    int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString()) + 1;
                    double precio = (double) cantidad * Double.parseDouble(modelo.getValueAt(i, 3).toString());
                    modelo.setValueAt(cantidad, i, 2);
                    modelo.setValueAt(precio, i, 4);
                    bandera = false;
                    this.lista.add(String.valueOf(id));
                    break;
                }
            }
            if (bandera && verificar(id)) {
                String[] arreglo = new String[5];
                arreglo[0] = array[0];
                arreglo[1] = array[1];
                arreglo[2] = "1";
                arreglo[3] = array[2];
                arreglo[4] = String.valueOf((Double.parseDouble(arreglo[2])) * (Double.parseDouble(arreglo[3])));
                this.lista.add(String.valueOf(id));
                modelo.addRow(arreglo);
            }
        }
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += Double.parseDouble(modelo.getValueAt(i, 4).toString());
        }
        this.totales.setText("" + total);
    }
    
    /**
     * 
     * 
     * @param id
     * @return 
     */
    private boolean verificar(int id) {
        String idV = String.valueOf(id);
        return lista.stream().noneMatch((lista1) -> (lista1.equals(idV)));
    }

    /**
     * 
     */
    public void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Total");
        this.tabla.setModel(modelo);
    }

    /**
     * 
     * 
     * @param datoEnBytes
     * @return 
     */
    public String convertirBytes(String datoEnBytes) {
        String salida = "";
        String[] datos = datoEnBytes.split("-");
        try {
            for (String s : datos) {
                salida += (char) Integer.parseInt(s.trim(), 16);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return salida;
    }
    //</editor-fold>
    
}