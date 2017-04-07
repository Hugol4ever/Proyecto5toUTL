
package controlador;

import app.Huella;
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
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author hugol
 */
public class HuellaController {
    
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    public DPFPFeatureSet featuresincripcion;
    public DPFPFeatureSet featuresverificacion;
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    private DPFPTemplate template;
    private Huella huella;
    public static String TEMPLATE_PROPERTY="template";
    
    public void iniciar() {
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnviarTexto("Camarita La huella se capturo con Éxito!!!");
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });
        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {

            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnviarTexto("Camarita El Sensor de Huella esta Activado!!!");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnviarTexto("Camarita El Sensor de Huella esta Desconectado!!!");
                    }
                });
            }
        });
        Lector.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnviarTexto("Camarita tu dedo ha sido colocado en el lector !!");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnviarTexto("Camarita tu dedo se ha quitado del lector !!");
                    }
                });
            }
        });
        Lector.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnviarTexto("Error: " + e.getError());
                    }
                });
            }
        });
    }
    
    public void EnviarTexto(String s){
        System.out.print( s+"\n");
    }
    
    public DPFPFeatureSet estraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }
    
    public void ProcesarCaptura(DPFPSample sample) {
        //procesa la muetra de la huella y crea un conjunto de caracteristicas con el proposito de enrrolar
        featuresincripcion = estraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        //procesa la muestra de la huella y crea un conjunto de caracteristicas con el proposito de verificación
        featuresverificacion = estraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        //comprobar la calidad de la muestra de la huella y lo añanade a su reclutador si es bueno.
        if (featuresincripcion != null) {
            try {
                System.out.println("Las caracteristicas de huella han sido creadas");
                Reclutador.addFeatures(featuresincripcion);
                Image i = CrearImagenHuella(sample);
                dibujarHuella(i);
            //btnIdentificar.setEnabled(true);
                //btnVerificar.setEnabled(true);
            } catch (DPFPImageQualityException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                EstadoHuella();
                switch (Reclutador.getTemplateStatus()) {
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
    
    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void start() {
        Lector.startCapture();
    }

    public void stop() {
        Lector.stopCapture();
        EnviarTexto("Camarita no se está utilizando el Lector!!");
    }
    
    public void dibujarHuella(Image image) {
        this.huella.getHuella().setIcon(new ImageIcon(image.getScaledInstance(this.huella.getHuella().getWidth(),this.huella.getHuella().getHeight() ,image.SCALE_DEFAULT)));
        this.huella.repaint();
    }
    
    public void EstadoHuella() {
        EnviarTexto("Muestra de huellas necesarias para captura de  huella " + Reclutador.getFeaturesNeeded());
    }
    
    public HuellaController(Huella huella) {
        this.huella = huella;
    }

    public DPFPCapture getLector() {
        return Lector;
    }

    public DPFPEnrollment getReclutador() {
        return Reclutador;
    }

    public DPFPTemplate getTemplate() {
        return template;
    }
    
    public void setTemplate(DPFPTemplate template){
        DPFPTemplate old=this.template;
        this.template=template;
        //firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

}