package org.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;


import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;

import com.opensymphony.xwork2.ActionSupport;



public class Json extends ActionSupport
{

	

	private static final long serialVersionUID = 8960849566966201064L;
	private int divId;
	private int distId;
	private int thanaId;
	private String wardId;
	private String areaId;
	private Map<String, ArrayList<String>> districtList;
	private Map<String, ArrayList<String>> divisionList;
	private Map<String, ArrayList<String>> thanaList;
	private Map<String, ArrayList<String>> unionList;
	private Map<String, ArrayList<String>> areaList;
	private String districtId;
	

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public Map<String, ArrayList<String>> getDistrictList()
	{
		return districtList;
	}

	public void setDistrictList(Map<String, ArrayList<String>> districtList)
	{
		this.districtList = districtList;
	}

	public int getDivId()
	{
		return divId;
	}

	public void setDivId(int divId)
	{
		this.divId = divId;
	}




	public void fetchDistrict()
	{
		districtList = new HashMap<String, ArrayList<String>>();
		ArrayList<String> dlist=(ArrayList<String>) getServletContext().getAttribute("DISTRICT_BY_DIVISION_"+divId);
		if(dlist==null)
		{
			AddressDAO addDAO = new AddressDAO();
			dlist = addDAO.getDistrict(divId);			
			districtList.put("districtList", dlist);
			getServletContext().setAttribute("DISTRICT_BY_DIVISION_"+divId,dlist);
		}
		else
			districtList.put("districtList", dlist);
		
			
	}

	public void fetchThana()
	{
		thanaList = new HashMap<String, ArrayList<String>>();
		ArrayList<String> tlist=(ArrayList<String>) getServletContext().getAttribute("THANA_BY_DISTRICT_"+distId);
		if(tlist==null)
		{
			AddressDAO addDAO = new AddressDAO();
			tlist = addDAO.getThana(distId);			
			thanaList.put("thanaList", tlist);
			getServletContext().setAttribute("THANA_BY_DISTRICT_"+distId,tlist);
		}
		else
			thanaList.put("thanaList", tlist);
	
	}

	public void fetchUnion()
	{
		unionList = new HashMap<String, ArrayList<String>>();
		ArrayList<String> ulist=(ArrayList<String>) getServletContext().getAttribute("UNION_BY_THANA_"+thanaId);
		
		if(ulist==null)
		{
			AddressDAO addDAO = new AddressDAO();
			ulist = addDAO.getUnion(thanaId);			
			unionList.put("unionList", ulist);
			getServletContext().setAttribute("UNION_BY_THANA_"+thanaId,ulist);
		}
		else
			unionList.put("unionList", ulist);
	
	}

	public void fetchArea()
	{
		ArrayList<String> aList = new ArrayList<String>();
		AddressDAO addDAO = new AddressDAO();
		//aList = addDAO.getArea(wardId,thanaId,districtId);
		areaList = new HashMap<String, ArrayList<String>>();
		areaList.put("areaList", aList);
	}

	public String getArea()
	{
		fetchArea();
		return SUCCESS;
	}


	public String getDistrict()
	{
		fetchDistrict();
		return SUCCESS;
	}

	public String getThana()
	{
		fetchThana();
		return SUCCESS;
	}

	public String getUnion()
	{
		fetchUnion();
		return SUCCESS;
	}

	
	public int getDistId()
	{
		return distId;
	}

	public void setDistId(int distId)
	{
		this.distId = distId;
	}

	public int getThanaId()
	{
		return thanaId;
	}

	public void setThanaId(int thanaId)
	{
		this.thanaId = thanaId;
	}

	public String getWardId()
	{
		return wardId;
	}

	public void setWardId(String wardId)
	{
		this.wardId = wardId;
	}

	public String getAreaId()
	{
		return areaId;
	}

	public void setAreaId(String areaId)
	{
		this.areaId = areaId;
	}

	public Map<String, ArrayList<String>> getDivisionList()
	{
		return divisionList;
	}

	public void setDivisionList(Map<String, ArrayList<String>> divisionList)
	{
		this.divisionList = divisionList;
	}

	public Map<String, ArrayList<String>> getThanaList()
	{
		return thanaList;
	}

	public void setThanaList(Map<String, ArrayList<String>> thanaList)
	{
		this.thanaList = thanaList;
	}

	public Map<String, ArrayList<String>> getUnionList()
	{
		return unionList;
	}

	public void setUnionList(Map<String, ArrayList<String>> unionList)
	{
		this.unionList = unionList;
	}

	public Map<String, ArrayList<String>> getAreaList()
	{
		return areaList;
	}

	public void setAreaList(Map<String, ArrayList<String>> areaList)
	{
		this.areaList = areaList;
	}

	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}
}