package at.irian.jsfatwork.gui.page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator(value="CalculatorValidator")
public class CalculatorValidator implements Validator{
 
	private Pattern pattern;
	private Matcher matcher;
 
	public CalculatorValidator(){
		  pattern = Pattern.compile("[1-9]");
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("Calculation failed!.", 
						"Only numbers greater than 0 allowed!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
 
		}
 
	}
}
