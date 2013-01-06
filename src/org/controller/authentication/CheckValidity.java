package org.controller.authentication;

import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.model.UserDAO;
import org.table.AddressDTO;
import org.table.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class CheckValidity extends ActionSupport{

	private static final long serialVersionUID = -3308886200897622656L;
	UserDTO user=new UserDTO();
	UserDAO userDao=new UserDAO();
	private String userId;
	private String password;
	
	public String execute()
	{
			String submittedAuthKey="";
			String savedAuthKey="";
			String localIp=ServletActionContext.getRequest().getHeader("X-Forwarded-For")==null?"":ServletActionContext.getRequest().getHeader("X-Forwarded-For");
			String via=ServletActionContext.getRequest().getHeader("Via")==null?"":ServletActionContext.getRequest().getHeader("Via");
			String realIp=ServletActionContext.getRequest().getRemoteAddr()==null?"":ServletActionContext.getRequest().getRemoteAddr();
			submittedAuthKey=localIp+via+realIp;
			AddressDAO addressDao=new AddressDAO();
			
			this.user=userDao.validateLogin(userId, password);
			if(user==null)
			{
				addActionMessage("Invalid Userid or Password.");
				return INPUT;
			}
			else
			{
				
				savedAuthKey=userDao.getAuthenticationKey(userId, password);
				boolean flag=false;
				if(savedAuthKey.equalsIgnoreCase(""))
				{
					
					flag=userDao.updateLoginKey(userId, password, localIp, via, realIp);
				}
				else if(submittedAuthKey.equalsIgnoreCase(savedAuthKey))
				{
				
					flag=true;
				}
				
				if(flag==true)
				{
					ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", user);
					 if(user.getUserType().equalsIgnoreCase("UISC_REG_OPERATOR"))	
					 {
						 getServletContext().setAttribute("OPERATOR_DIVISION", addressDao.getDivision(Integer.parseInt(user.getDivisionId())));
						 getServletContext().setAttribute("OPERATOR_DISTRICT", addressDao.getOperatorDistrict(Integer.parseInt(user.getDistrictId())));
						 getServletContext().setAttribute("OPERATOR_UPAZILLA", addressDao.getUpazilla(user.getUpazillaId(),user.getDistrictId()));
						 

						 
						 ArrayList<AddressDTO> abc=(ArrayList<AddressDTO>) getServletContext().getAttribute("OPERATOR_DISTRICT");
						 System.out.println("=========>>"+abc.size());
						 
						 
						 return "regOperator";
					 }
						 else
						 return INPUT;
				}
				else
				{
					addActionMessage("Ip address changed....Please regenerate password and then try again.");
					return INPUT;
				}
			}
			
			
	}

	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
