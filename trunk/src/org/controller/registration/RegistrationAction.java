package org.controller.registration;

import org.apache.struts2.ServletActionContext;


public class RegistrationAction {
	
	public String regHomeAction()
	{
		ServletActionContext.getRequest().getSession().setAttribute("form_error", null);
		return "REG_HOME";
	}

}
