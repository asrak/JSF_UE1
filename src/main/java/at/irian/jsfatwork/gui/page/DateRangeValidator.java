package at.irian.jsfatwork.gui.page;

import java.util.Date;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="dateRangeValidator")
public class DateRangeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	Date d = (Date) value;
    	System.out.println(d.getDate()+"   "+d.getMonth()+"   "+d.getYear());
        if (d.getMonth() > 11 || d.getMonth() < 0 || d.getDate() > 31 || d.getDate() < 1 || d.getYear() < 100) {
        	FacesMessage msg = 
    				new FacesMessage("Failed!", 
    						"Wrong date!");
    			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    			throw new ValidatorException(msg);
        }
    }

}