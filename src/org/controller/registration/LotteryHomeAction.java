package org.controller.registration;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.model.LotteryDAO;
import org.table.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class LotteryHomeAction extends ActionSupport{

	private static final long serialVersionUID = 6485791838606873787L;
	
	private String districtName;
	private int totalRegJobseeker;
	private int totalCotaNumber;
	private int totalSelected;
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
		totalSelected=lotter.getTotalSelected(loggedInUser.getDistrictId());
		
		return "success";
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getTotalRegJobseeker() {
		return totalRegJobseeker;
	}

	public void setTotalRegJobseeker(int totalRegJobseeker) {
		this.totalRegJobseeker = totalRegJobseeker;
	}

	public int getTotalCotaNumber() {
		return totalCotaNumber;
	}

	public void setTotalCotaNumber(int totalCotaNumber) {
		this.totalCotaNumber = totalCotaNumber;
	}

	public int getTotalSelected() {
		return totalSelected;
	}

	public void setTotalSelected(int totalSelected) {
		this.totalSelected = totalSelected;
	}
	
	
	

}
