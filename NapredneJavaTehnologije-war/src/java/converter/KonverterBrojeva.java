/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Damjan
 */
@FacesConverter(forClass = Double.class , value = "konverterBrojeva")
public class KonverterBrojeva implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string==null || string.isEmpty()){
            return null;
        }else{
            return Double.parseDouble(string);
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return String.valueOf(o);
    }
    
}
