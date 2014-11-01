/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import domen.Projekat;
import domen.Sastanak;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sessions.ProjectManager;

/**
 *
 * @author Damjan
 */
@FacesConverter(forClass = Sastanak.class , value = "konverterSastanka")
public class KonverterSastanka implements Converter{

    @EJB
    private ProjectManager sbProjekat;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("Konverter sastanka 1");
        if (string != null || !string.isEmpty()) {
            
            try{
                Integer projekatID = Integer.parseInt(string);
                Projekat projekat = sbProjekat.vratiProjekatPoId(projekatID);
                return projekat;
            }catch(NumberFormatException e){
                Logger.getLogger(KonverterSastanka.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
            System.out.println("Konverter sastanka 2");
            return String.valueOf(((Projekat)o).getIdProjekta());     
    }
}
