package org.controller.registration;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.model.DashBoardDAO;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrationStatisticsAction  extends ActionSupport{

	private static final long serialVersionUID = -4335406653533806139L;
	String districtId;
	String districtName;
	int refreshRate;
	
	public String execute()
	{
		return "success";
	}
	
	public String divisionStatistics()
	{
		HttpServletResponse response = ServletActionContext.getResponse();

		DashBoardDAO dbdao=new DashBoardDAO();
		String table=dbdao.getDivisionWiseStat("1",this.refreshRate);
		

		try{
        	response.setContentType("text/xml");
        	response.setHeader("Cache-Control", "no-cache");
        	response.getWriter().write(table);
        	response.flushBuffer();
          }
        catch(Exception e) {e.printStackTrace();}
        
        
		return null;
		

	}
	public String districtStatistics()
	{
		HttpServletResponse response = ServletActionContext.getResponse();

		DashBoardDAO dbdao=new DashBoardDAO();
		String table=dbdao.getDistrictWiseStat(this.districtId,this.districtName,this.refreshRate);

		try{
        	response.setContentType("text/xml");
        	response.setHeader("Cache-Control", "no-cache");
        	response.getWriter().write(table);
        	response.flushBuffer();
          }
        catch(Exception e) {e.printStackTrace();}
        
        
		return null;
		

	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(int refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	
}
