package org.controller.registration;

import org.apache.struts2.ServletActionContext;
import org.table.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class LotteryHomeAction extends ActionSupport{

	private static final long serialVersionUID = 6485791838606873787L;
	
	
	public String lotteryHome()
	{
		String localIp=ServletActionContext.getRequest().getHeader("X-Forwarded-For")==null?"":ServletActionContext.getRequest().getHeader("X-Forwarded-For");
		String via=ServletActionContext.getRequest().getHeader("Via")==null?"":ServletActionContext.getRequest().getHeader("Via");
		String realIp=ServletActionContext.getRequest().getRemoteAddr()==null?"":ServletActionContext.getRequest().getRemoteAddr();
		String submittedAuthKey=localIp+via+realIp;
		
		UserDTO loggedInUser=(UserDTO) ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		if(!loggedInUser.getAuthenticationKey().equalsIgnoreCase(submittedAuthKey))
		{
			return "logout";
		}
		else if(!loggedInUser.getUserType().equalsIgnoreCase("REG_VIEW_ADMIN") && !loggedInUser.getUserType().equalsIgnoreCase("REG_LOT_VIEW_ADMIN"))
		{
			return "logout";
		}
		else if(loggedInUser.getAccessRight()==0)
		{
			return "timeOver";	
		}
		
		return "success";
	}
	

}
