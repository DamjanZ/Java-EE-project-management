/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author DamjanZ
 */
@FacesValidator("datumRodjenjaValidator")
public class DatumRodjenjaValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        Date date = (Date)value;
        Date danasnjiDatum = new Date();
        if(date.after(danasnjiDatum) || date.equals(danasnjiDatum)){
            FacesMessage message = new FacesMessage("Zaposleni ne može biti rođen na danasnji datum ili posle danasnjeg!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }else{
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

            int unetaGodina = Integer.parseInt(sdf.format(date));
            int danasnjaGodina = Integer.parseInt(sdf.format(danasnjiDatum));

            if(danasnjaGodina - unetaGodina <18){
                FacesMessage message = new FacesMessage("Ne može zaposleni biti maloletno lice!");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }
    
}
