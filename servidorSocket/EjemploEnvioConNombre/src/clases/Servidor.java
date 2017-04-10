package clases;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * ********************************************************************
 */
/* Asignación del programa:      servidor [recibe archivo]*/
/* Nombre:                       @author Hugo Martínez                 */
/* Fecha:                        9/04/2017*/
/* Descripción:                  */
/**
 * ********************************************************************
 */
public class Servidor extends Thread {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    OutputStream salida;
    InputStream entrada;
    DataOutputStream envio_salida;
    DataInputStream recibe_entrada;
    ServerSocket servidor;
    Socket conexion;
    String nombre;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    public void inicio_socket() throws IOException {
        while (true) {
            flujos();
            mostrar();
            recibeFoto();
        }
    }

    public void flujos() throws IOException {
        salida = conexion.getOutputStream();
        envio_salida = new DataOutputStream(salida);
        entrada = conexion.getInputStream();
        recibe_entrada = new DataInputStream(entrada);
    }

    public void recibeFoto() throws IOException {
        ObjectInputStream oit = new ObjectInputStream(entrada);
        String ruta = "/home/hugol/Escritorio/" + nombre;
        FileOutputStream file = new FileOutputStream(ruta);
        byte[] buf = new byte[1024];
        while (true) {
            int len = oit.read(buf);
            if (len == -1) {
                oit.close();
                file.close();
                moverImagen();
                servidor.close();
                System.out.println("Desconectado");
                iniciar();
                break;
            }
            file.write(buf, 0, len);
        }
    }

    public void mostrar() throws IOException {
        nombre = recibe_entrada.readUTF();
        System.out.println(nombre);
    }

    public void enviar(String x) throws IOException {
        envio_salida.writeUTF(x);
        envio_salida.flush();
    }

    @Override
    public void run() {
        try {
            inicio_socket();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciar() throws IOException {
        servidor = new ServerSocket(5432);
        conexion = servidor.accept();
        System.out.println("conectado con camarita");
    }

    public void moverImagen() {
        try {
            Runtime.getRuntime().exec("mv /home/hugol/Escritorio/"
                    + nombre + " /usr/local/apache-tomcat-8.0.15/webapps/FotosWebService5to");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Método principal">
    public static void main(String[] args) throws IOException {
        Servidor x = new Servidor();
        x.start();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Servidor() throws IOException {
        iniciar();
    }
    //</editor-fold>

}
