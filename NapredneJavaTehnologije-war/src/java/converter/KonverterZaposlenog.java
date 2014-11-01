/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import domen.Zaposleni;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sessions.ZaposleniManager;

/**
 *
 * @author Damjan
 */
@FacesConverter(forClass = Zaposleni.class , value = "konverterZaposlenih")
public class KonverterZaposlenog implements Converter{

    @EJB
    private ZaposleniManager sbZaposleni;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value != null || !value.isEmpty()){    
            try{
                Integer zaposleniID = Integer.parseInt(value);
                Zaposleni zaposlen = sbZaposleni.vratiZaposlenogPoId(zaposleniID);
                return zaposlen;
            }catch(Exception e){
                Logger.getLogger(KonverterZaposlenog.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Zaposleni)value).getIdZaposlenog());
    }
    
}
