package at.irian.jsfatwork.gui.page;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.*;

@ManagedBean(name="rechner")
@SessionScoped
@RequestScoped
public class Rechner {
	@NotNull(message = "Please enter a number.")
	@Min(value = 1)
	private String a = "0";
	@NotNull(message = "Please enter a number.")
	@Min(value = 1)
	private String b = "0";
	private String result = "0";
	private String op = "Addition";
	private Date birthDate = new Date();

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void rechnen() {
		int resultI = 0;
		int aI = Integer.parseInt(a);
		int bI = Integer.parseInt(b);
		if(op.compareTo("Addition") == 0) {
			resultI = aI+bI;
		} else if(op.compareTo("Subtraktion") == 0) {
			resultI = aI-bI;
		} else if(op.compareTo("Multiplikation") == 0) {
			resultI = aI*bI;
		} else if(op.compareTo("Division") == 0) {
			resultI = aI/bI;
		}
		result = ""+resultI;
	}
}
