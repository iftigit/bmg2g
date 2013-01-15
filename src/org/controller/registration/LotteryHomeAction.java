package org.controller.registration;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.model.LotteryDAO;
import org.table.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class LotteryHomeAction extends ActionSupport{

	private static final long serialVersionUID = 6485791838606873787L;
	
	private String districtName;
	private String totalRegJobseeker;
	private String totalCotaNumber;
	AddressDAO addressDAO=new AddressDAO();
	LotteryDAO lotter=new LotteryDAO();
	
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
		else if(!loggedInUser.getUserType().equalsIgnoreCase("LOTTERY_DC_ADMIN"))
		{
			return "logout";
		}
		else if(loggedInUser.getAccessRight()==0)
		{
			return "timeOver";	
		}
		
		districtName=addressDAO.getDistrictNameFromId(Integer.parseInt(loggedInUser.getDistrictId()));
		totalRegJobseeker=lotter.getTotalRegisteredJobseeker(loggedInUser.getDistrictId());
		totalCotaNumber=lotter.getTotalCotaNumber(loggedInUser.getDistrictId());
		
		return "success";
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getTotalRegJobseeker() {
		return totalRegJobseeker;
	}

	public void setTotalRegJobseeker(String totalRegJobseeker) {
		this.totalRegJobseeker = totalRegJobseeker;
	}

	public String getTotalCotaNumber() {
		return totalCotaNumber;
	}

	public void setTotalCotaNumber(String totalCotaNumber) {
		this.totalCotaNumber = totalCotaNumber;
	}
	
	
	

}
