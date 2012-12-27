package org.controller.registration;

import org.apache.struts2.ServletActionContext;
import org.util.PassPhrase;


public class RegistrationAction {
	
	private String rc;
	
	public String regHomeAction()
	{
		this.rc= PassPhrase.getNext();
		ServletActionContext.getRequest().getSession().setAttribute("form_error", null);
		return "REG_HOME";
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}
	
	
	

}
