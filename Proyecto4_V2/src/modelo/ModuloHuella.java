
package modelo;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloHuella {
    
// AQUI VA LA CONEXION   ConexionBD bd=new ConexionBD();
private DPFPCapture Lector=DPFPGlobal.getCaptureFactory().createCapture();
private DPFPEnrollment Reclutador=DPFPGlobal.getEnrollmentFactory().createEnrollment();
private DPFPVerification Verificador=DPFPGlobal.getVerificationFactory().createVerification();
private DPFPTemplate template;
public static String TEMPLATE_PROPERTY="template";

public DPFPFeatureSet featuresincripcion;
public DPFPFeatureSet featuresverificacion;

public DPFPFeatureSet estraerCaracteristicas(DPFPSample sample,DPFPDataPurpose purpose){
    DPFPFeatureExtraction extractor=DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
    try{
        return extractor.createFeatureSet(sample, purpose);
    }catch(DPFPImageQualityException e){
        return null;
    }
}

//INIT COMPONENTS public CapturaHuella() {
//        //Código para estilo visual de la aplicacion
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "no se puede modificar el tema","Error",JOptionPane.ERROR_MESSAGE);
//        }
//        initComponents();
//    }
    
public void guardarHuella() throws SQLException{
        //tomamos los datos del template actual
        ByteArrayInputStream datosHuella=new ByteArrayInputStream(template.serialize());
        Integer tamañoHuella=template.serialize().length;
        String nombre=JOptionPane.showInputDialog("Nombre: ");
        //Connection x=bd.conectar();
        PreparedStatement guardaStmt=x.prepareStatement("insert into usuarios (nombre,huella) values(?,?)");
        guardaStmt.setString(1, nombre);
        guardaStmt.setBinaryStream(2, datosHuella,tamañoHuella);
        
        guardaStmt.execute();
        guardaStmt.close();
           }
public void verificarHuella(String n) throws SQLException{
        //Connection x=bd.conectar();
        PreparedStatement verificarStmt=x.prepareStatement("Select huella from usuarios where nombre=?");
        verificarStmt.setString(1, n);
        ResultSet r=verificarStmt.executeQuery();
        if(r.next()){
            byte templateBuffer []=r.getBytes("huella");
            DPFPTemplate referenceTemplate=DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
            setTemplate(referenceTemplate);
            DPFPVerificationResult result=Verificador.verify(featuresverificacion, getTemplate());
            if(result.isVerified())JOptionPane.showMessageDialog(null, "las huella si coinsiden");
            else JOptionPane.showMessageDialog(null, "las huella no coinsiden");
        }
        else{
            JOptionPane.showMessageDialog(null, "no existe un registro de huella");
        }
            
    }

    protected void iniciar(){
    Lector.addDataListener(new DPFPDataAdapter(){
    @Override
     public void dataAcquired(final DPFPDataEvent e){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               EnviarTexto("Camarita La huella se capturo con Éxito!!!");
               ProcesarCaptura(e.getSample());
            }
        });
    }
});
    Lector.addReaderStatusListener(new DPFPReaderStatusAdapter(){
        
        @Override
        public void readerConnected(final DPFPReaderStatusEvent e){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    EnviarTexto("Camarita El Sensor de Huella esta Activado!!!");
                }
            });
        }
        @Override
        public void readerDisconnected(final DPFPReaderStatusEvent e){
             SwingUtilities.invokeLater(new Runnable() {
                 @Override
                 public void run() {
                    EnviarTexto("Camarita El Sensor de Huella esta Desconectado!!!");
                 }
             });
        }
   });
    Lector.addSensorListener(new DPFPSensorAdapter(){
        @Override
        public void fingerTouched(final DPFPSensorEvent e){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    EnviarTexto("Camarita tu dedo ha sido colocado en el lector !!");
                }
            });
        }
        @Override
        public void fingerGone(final DPFPSensorEvent e){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                  EnviarTexto("Camarita tu dedo se ha quitado del lector !!");
                }
            });
        }
    });
    Lector.addErrorListener(new DPFPErrorAdapter(){
        public void errorReader(final DPFPErrorEvent e){
             SwingUtilities.invokeLater(new Runnable() {
                 @Override
                 public void run() {
                       EnviarTexto("Error: "+e.getError());
                 }
             });
        }
    });
}
    public void dibujarHuella(Image image){
//    jLabel1.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel1.getWidth(),this.jLabel1.getHeight() ,image.SCALE_DEFAULT)));
//    repaint();
}
public void start(){
    Lector.startCapture();
}
public void stop(){
    Lector.stopCapture();
    EnviarTexto("Camarita no se está utilizando el Lector!!");
}
public void EnviarTexto(String s){
//    this.jTextArea1.append( s+"\n");
}
public DPFPTemplate getTemplate(){
    return template;
}
public void setTemplate(DPFPTemplate template){
    DPFPTemplate old=this.template;
    this.template=template;
//    firePropertyChange(TEMPLATE_PROPERTY, old, template);
}
public void EstadoHuella(){
    EnviarTexto("Muestra de huellas necesarias para captura de  huella "+ Reclutador.getFeaturesNeeded());
}
public Image CrearImagenHuella(DPFPSample sample){
    return DPFPGlobal.getSampleConversionFactory().createImage(sample);
}
public void ProcesarCaptura(DPFPSample sample){
    //procesa la muetra de la huella y crea un conjunto de caracteristicas con el proposito de enrrolar
    featuresincripcion=estraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
    //procesa la muestra de la huella y crea un conjunto de caracteristicas con el proposito de verificación
    featuresverificacion=estraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
    //comprobar la calidad de la muestra de la huella y lo añanade a su reclutador si es bueno.
    if(featuresincripcion!=null){
        try{
            System.out.println("Las caracteristicas de huella han sido creadas");
            Reclutador.addFeatures(featuresincripcion);
            Image i=CrearImagenHuella(sample);
            dibujarHuella(i);
            //btnIdentificar.setEnabled(true);
            //btnVerificar.setEnabled(true);
        }catch(DPFPImageQualityException e){
            System.out.println("Error: "+e.getMessage());
        }
        finally{
            EstadoHuella();
            switch(Reclutador.getTemplateStatus()){
                case TEMPLATE_STATUS_READY:
                    stop();
                    setTemplate(Reclutador.getTemplate());
                    EnviarTexto("La plantilla a sido creada, ya puede verificar o identificarla");
                    //btnIdentificar.setEnabled(false);
                    //btnVerificar.setEnabled(false);
                    //btnGuardar.setEnabled(true);
                    //btnGuardar.grabFocus();
                    break;
                case TEMPLATE_STATUS_FAILED:
                    Reclutador.clear();
                    stop();
                    EstadoHuella();
                    setTemplate(null);
//                    JOptionPane.showMessageDialog(CapturaHuella.this, "La plantilla no se pudo crear Lastima!!!!");
                    start();
                    break;
            }
        }
    }
}
    

//ESTO VA EN EL INIT COMPONENTS
//                 iniciar();
//         start();
//         EstadoHuella();
////         btnGuardar.setEnabled(false);
////         btnIdentificar.setEnabled(false);
////         btnVerificar.setEnabled(false);
//         btnSalir.grabFocus();

//ACTION PERFORMEN DEL BOTON SALIR
//        this.dispose();

//BOTON VERIFICAR HUELLA
//        try {
//            String nombre=JOptionPane.showInputDialog("Nombre a verificar:");
//            verificarHuella(nombre);
//            Reclutador.clear();
//        } catch (SQLException ex) {
//            Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
//        }

//BOTON GUARDAR HUELLA
//        try {
//            guardarHuella();
//            Reclutador.clear();this.jLabel1.setIcon(null);
//            start();
//        } catch (SQLException ex) {
//            Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
//        }
}
