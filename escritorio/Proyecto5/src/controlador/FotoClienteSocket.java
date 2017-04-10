package controlador;

import app.Productos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/***********************************************************************/
/* Asignación del programa:      */
/* Nombre:                       @author Hugo Martínez                 */
/* Fecha:                        9/04/2017*/
/* Descripción:                  */
/***********************************************************************/

public class FotoClienteSocket extends Thread {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    Socket cliente;
    InputStream entrada;
    DataInputStream flujo;
    OutputStream salida;
    DataOutputStream envio_salida;
    DataInputStream recibe_entrada;
    String rutaFoto;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos generales">
    public void inicio_socket() throws IOException {
        flujos();
    }
    
    public void flujos() throws IOException {
        salida = cliente.getOutputStream();
        envio_salida = new DataOutputStream(salida);
        entrada =  cliente.getInputStream();
        recibe_entrada = new DataInputStream(entrada);
    }
    
    public void enviarFoto() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(salida);
        FileInputStream file = new FileInputStream(this.rutaFoto);
        byte[] buf = new byte[1024];
        while (true) {
            int len = file.read(buf);
            if (len == -1) {
                out.close();
                file.close();
                cliente.close();
                break;
            }
            out.write(buf, 0, len);
        }
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
            Logger.getLogger(FotoClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
       public FotoClienteSocket(String rutaFoto) throws IOException {
           cliente = new Socket("192.168.1.11", 5432);
           this.rutaFoto = rutaFoto;
       }
    //</editor-fold>

}