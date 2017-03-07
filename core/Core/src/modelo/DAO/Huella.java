package modelo.DAO;

import com.digitalpersona.onetouch.DPFPTemplate;

/**
 *
 * @author DDD
 */

public class Huella {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int idHuella;
    private DPFPTemplate huella;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Huella() {
    }

    /**
     * Constructor sobrecargado
     * 
     * @param template 
     */
    public Huella(DPFPTemplate template) {
        this.huella = template;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos get y set">
    /**
     * Método get de template
     * 
     * @return template
     */
    public DPFPTemplate getTemplate() {
        return huella;
    }

    /**
     * Método set de template
     * 
     * @param template
     */
    public void setTemplate(DPFPTemplate template) {
        this.huella = template;
    }
    
    /**
     * Método get de id de huella
     * 
     * @return id de huella
     */
    public int getIdHuella() {
        return idHuella;
    }

    /**
     * Método set de id de huella
     * 
     * @param idHuella
     */
    public void setIdHuella(int idHuella) {
        this.idHuella = idHuella;
    }
    //</editor-fold>

}