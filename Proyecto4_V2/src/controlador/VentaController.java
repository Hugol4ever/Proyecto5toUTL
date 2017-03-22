package controlador;

import app.Ventas;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
        String puerto = "COM5";
        mpr = new MprManager(puerto, 9600);
        mpr.setByteSeparator("-");
        if (!mpr.connect()) {
            throw new Exception("No hay Comunicacion camarita");
        }
        lectura = new Lectura(mpr, venta.getTblProductos(), producto);
        lectura.start();
        this.tabla = tabla;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Lectura(MprManager mpr, JTable tabla, DTOproducto producto) {
        fox = mpr;
        datoByte = datoAscii = null;
        this.tabla = tabla;
        this.producto = producto;
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

    private void agregar() {
        boolean bandera = true;
        if (!lista.isEmpty()) {
            for (String lista1 : lista) {
                if (lista1.indexOf(datoAscii.substring(0, 3)) == 0) {
                    String descripcion = buscar(Integer.parseInt(datoAscii));
                    modificarTabla(descripcion);
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
    }

    private String[] registro(int id) {
        String[] reg = new String[4];
        String[] nombres = this.producto.ListaProducto2(id);
        reg[0] = nombres[0];
        reg[1] = "1";
        reg[2] = nombres[1];
        reg[3] = String.valueOf(Integer.parseInt(reg[1]) * Double.parseDouble(nombres[1]));
        return reg;
    }
    
    private void modificarTabla(String descripcion) {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (descripcion.equals(tabla.getValueAt(i, 0).toString())) {
                int cantidad = (int) modelo.getValueAt(i, 1);
                double precio = (double) modelo.getValueAt(i, 2);
                modelo.setValueAt(cantidad + 1, i, 1);
                modelo.setValueAt(precio * cantidad, i, 2);
                break;
            }
        }
    }
    
    private String buscar(int id) {
        return "";
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