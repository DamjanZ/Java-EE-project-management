/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author DamjanZ
 */
@FacesValidator("datumValidator")
public class DatumOdDoValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        UIInput sd = (UIInput)component.getAttributes().get("datumOd");
        
        if(value != null && sd.isValid()){
            
            System.out.println("Datum validiramo, nisu prazni.");
            
            Date datumOd = (Date)sd.getValue();
            Date datumDo = (Date)value;

            System.out.println("Datum do:"+datumDo.toString());
            System.out.println("Datum od:"+datumOd.toString());
            
            Date danasnjiDatum = new Date();
            //Ako datum pocetka projekta pre danasnjeg dana
            if(datumOd.before(danasnjiDatum) ){
                System.out.println("Datum je pre danasnjeg dana.");
                FacesMessage message = new FacesMessage("Datum pocetka projekta ne može biti pre današnjeg dana!");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
            
            if(datumOd.after(datumDo) || datumOd.equals(datumDo)){
                System.out.println("Datum zavrsetka je pre datuma pocetka.");
                FacesMessage message = new FacesMessage("Datum završetka mora da bude posle datuma početka projekta!");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
            
            
        }
    }
    
}
