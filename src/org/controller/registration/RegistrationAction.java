package org.controller.registration;

import org.apache.struts2.ServletActionContext;
import org.table.UserDTO;
import org.util.PassPhrase;


public class RegistrationAction {
	

	
	public String regHomeAction()
	{
		//this.rc= PassPhrase.getNext();
		UserDTO loggedInUser=(UserDTO) ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		if(!loggedInUser.getUserType().equalsIgnoreCase("UISC_REG_OPERATOR"))
		{
			return "logout";
		}
		else if(loggedInUser.getAccessRight()==0)
		{
			return "timeOver";	
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("form_error", null);
		return "REG_HOME";
	}

	

}
