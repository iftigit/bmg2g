package org.controller.registration;
import org.apache.struts2.ServletActionContext;


public class EditRegistrationFormAction {
	
public String execute() {
				
		ServletActionContext.getRequest().getSession().setAttribute("form_error", "edit_form");
		return "success";
	}

}
