/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

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
@FacesValidator("telefonValidator")
public class TelefonValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value!=null){
                if(!((String)value).matches("^[0-9]+$")){
                    FacesMessage message = new FacesMessage("Telefon ne sme da ima alfanumericke vrednosti!");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }
        }
    }
    
}
