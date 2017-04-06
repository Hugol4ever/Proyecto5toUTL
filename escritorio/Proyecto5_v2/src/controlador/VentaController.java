package controlador;

import app.Ventas;
import commons.Globals;
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
    public VentaController(Ventas venta, JTable tabla) throws Exception {
        this.producto = new DTOproducto();
        String puerto = Globals.COM;
        mpr = new MprManager(puerto, 9600);
        mpr.setByteSeparator("-");
        if (!mpr.connect()) {
            throw new Exception("No hay Comunicacion camarita");
        }
        lectura = new Lectura(mpr, venta.getTblProductos(), producto, venta.getjLabel2());
        lectura.start();
        this.tabla = tabla;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    public MprManager getMpr() {
        return mpr;
    }

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
    //</editor-fold>
}

class Lectura extends Thread {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    MprManager fox;
    String datoByte;
    String datoAscii;
    ArrayList<String> lista = new ArrayList<>();
    JTable tabla;
    DTOproducto producto;
    JLabel totales;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Lectura(MprManager mpr, JTable tabla, DTOproducto producto, JLabel total) {
        fox = mpr;
        datoByte = datoAscii = null;
        this.tabla = tabla;
        this.producto = producto;
        this.totales = total;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Método "run"">
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
    private void leer() {
        try {
            datoByte = fox.readOneTagID(MprCommands.TagProtocol.EPC_C1G2, 1);
            datoAscii = convertirBytes(datoByte);
            datoAscii = datoAscii.trim();
            System.out.println("Dato en Bytes: " + datoByte);
            System.out.println("Dato leido: " + datoAscii);
            agregar();
        } catch (Exception e) {
        }
    }

    public String xxx() {
        return datoAscii;
    }

    private boolean validar(String dato) {
        boolean si = true;
        for (String lista1 : lista) {
            if (lista1.equals(dato)) {
                si = false;
                break;
            }
        }
        return si;
    }

    private void agregar() {
        boolean bandera = true;
        if (!lista.isEmpty()) {
            for (String lista1 : lista) {
                if ((lista1.indexOf(datoAscii.substring(0, 3)) == 0) && (validar(datoAscii))) {
                    String descripcion = buscar(Integer.parseInt(datoAscii.substring(0, 3)));
                    modificarTabla(descripcion);
                    bandera = false;
                    lista.add(datoAscii);
                    break;
                } else if (lista1.equals(datoAscii)) {
                    bandera = false;
                    break;
                }
            }
            if (bandera) {
                lista.add(datoAscii);
                agregarTabla(Integer.parseInt(datoAscii.substring(0, 3)));
            }
        } else {
            lista.add(datoAscii);
            agregarTabla(Integer.parseInt(datoAscii.substring(0, 3)));
        }
    }

    public void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Total");
        this.tabla.setModel(modelo);
    }

    private void agregarTabla(int id) {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        if (id != 0) {
            modelo.addRow(registro(id));
            this.tabla.setModel(modelo);
        }
//        this.totales.setText(String.valueOf(total(modelo)));
    }

//    private int total(DefaultTableModel modelo) {
//        int total = 0;
//        for (int i = 0; i < modelo.getRowCount(); i++) {
//            total += Integer.parseInt(modelo.getValueAt(i, 4).toString());
//        }
//        System.out.println("Siiii");
//        return total;
//    }

    private String[] registro(int id) {
        String[] reg = new String[5];
        String[] nombres = this.producto.ListaProductoPorId(id);
        reg[0] = nombres[0];
        reg[1] = nombres[1];
        reg[2] = "1";
        reg[3] = nombres[2];
        reg[4] = String.valueOf(Integer.parseInt(reg[2]) * Double.parseDouble(nombres[2]));
        return reg;
    }

    private void modificarTabla(String id) {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (id.equals(modelo.getValueAt(i, 0).toString())) {
                int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
                double precio = Double.parseDouble(modelo.getValueAt(i, 3).toString());
                modelo.setValueAt(cantidad + 1, i, 2);
                modelo.setValueAt(precio * (cantidad + 1), i, 4);
//                this.totales.setText(String.valueOf(total(modelo)));
                break;
            }
        }
//        this.totales.setText(String.valueOf(total(modelo)));
    }

    private String buscar(int id) {
        String[] dato = this.producto.ListaProductoPorId(id);
        return dato[0];
    }

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
