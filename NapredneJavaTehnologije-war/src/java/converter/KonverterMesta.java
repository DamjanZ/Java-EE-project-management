/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import domen.Mesto;
import interfaces.SBMestoLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Damjan
 */
@FacesConverter("konverterMesta")
public class KonverterMesta implements Converter{

    @EJB
    private SBMestoLocal mestoManager;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        if (string != null || !string.isEmpty()) {
            try{
                int ptt = Integer.parseInt(string);
                return mestoManager.vratiMestoNaOsnovuPtt(ptt);
            }catch(Exception e){
                Logger.getLogger(KonverterMesta.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return String.valueOf(((Mesto)o).getPtt());
    }
    
}
