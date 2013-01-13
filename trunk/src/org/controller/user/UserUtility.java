package org.controller.user;

import org.apache.struts2.ServletActionContext;
import org.table.UserDTO;

public class UserUtility {
	
	UserDTO user;
	public String homePage()
	{
		user=(UserDTO)ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		if(user.getUserType().equalsIgnoreCase("UISC_REG_OPERATOR"))						 
			 return "regOperator";
		else if(user.getUserType().equalsIgnoreCase("REG_VIEW_ADMIN"))						 
			 return "regViewAdmin";
		else if(user.getUserType().equalsIgnoreCase("REG_LOT_VIEW_ADMIN"))						 
			 return "regLotViewAdmin";
		 else
			 return null;
		
	}

}