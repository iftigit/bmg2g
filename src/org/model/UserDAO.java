package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.table.TechnicalTeamDTO;
import org.table.UserDTO;

import util.connection.ConnectionManager;

public class UserDAO {
	
	
	public UserDTO validateLogin(String userId,String password)
	{
		UserDTO user=null;
		
		 Connection conn = ConnectionManager.getConnection();
		   String sql = " Select MST_USER.*,to_char(start_date,'DD-MM-YYYY') S_DATE,to_char(end_date,'DD-MM-YYYY') E_DATE,to_char(sysdate,'DD-MM-YYYY') TO_DAY " +
		   		        " from MST_USER Where userid=? and password=?";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
			try
			{
				stmt = conn.prepareStatement(sql);
				
			    stmt.setString(1, userId);
			    stmt.setString(2, password);

			    
				r = stmt.executeQuery();
				if (r.next())
				{
					user=new UserDTO();
					user.setUserId(r.getString("USERID"));
					user.setPassword(r.getString("PASSWORD"));
					user.setUserType(r.getString("USER_TYPE"));
					user.setLocalIp(r.getString("LOCAL_IP")==null?"":r.getString("LOCAL_IP"));
					user.setVia(r.getString("VIA")==null?"":r.getString("VIA"));
					user.setRealIp(r.getString("REAL_IP"));
					user.setDivisionId(r.getString("DIVISION_ID"));
					user.setDistrictId(r.getString("DISTRICT_ID"));
					user.setUpazillaId(r.getString("UPAZILLA_ID"));
					user.setUnionId(r.getString("UNION_ID"));
					
					String startDate=r.getString("S_DATE");
					String endDate=r.getString("E_DATE");
					String toDate=r.getString("TO_DAY");
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		        	Date sDate = sdf.parse(startDate);
		        	Date eDate = sdf.parse(endDate);
		        	Date tDate = sdf.parse(toDate);
		        	
		        	if(tDate.compareTo(sDate)<0){
		        		user.setAccessRight(0);
		        	}else if(tDate.compareTo(eDate)>0){
		        		user.setAccessRight(0);
		        	}
		        	else
		        		user.setAccessRight(1);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
		
		
		return user;
	}
	
	public String getAuthenticationKey(String userId,String password)
	{
		String authenticationKye="";
		
		 Connection conn = ConnectionManager.getConnection();
		   String sql = " Select Local_Ip||Via||Real_Ip authentication_key from MST_USER Where userid=? and password=?";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
			try
			{
				stmt = conn.prepareStatement(sql);
				
			    stmt.setString(1, userId);
			    stmt.setString(2, password);

			    
				r = stmt.executeQuery();
				if (r.next())
				{
					authenticationKye=r.getString("authentication_key");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
		
		
		return authenticationKye==null?"":authenticationKye;
	}
	
	public boolean updateLoginKey(String userId,String password,String localIp,String via,String realIp)
	{
		
		 Connection conn = ConnectionManager.getConnection();
		   String sql = " Update MST_USER Set LOCAL_IP=?,VIA=?,REAL_IP=? Where USERID=? and PASSWORD=?";
		   int operation=0;
		   PreparedStatement stmt = null;
			try
			{
				stmt = conn.prepareStatement(sql);
				
			    stmt.setString(1, localIp);
			    stmt.setString(2, via);
			    stmt.setString(3, realIp);
			    stmt.setString(4, userId);
			    stmt.setString(5, password);
			    operation=stmt.executeUpdate();
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
		
		if(operation==1)
			return true;
		else
			return false;
	}
	
	public ArrayList<TechnicalTeamDTO> getTechnicalTeam(String districtId)
	{
		ArrayList<TechnicalTeamDTO> teamList=new ArrayList<TechnicalTeamDTO>();
		TechnicalTeamDTO team=null;
		
		 Connection conn = ConnectionManager.getConnection();
		   String sql = " Select * from TECH_CONTACT_INFO Where dist_id=? Order by CONTACT_PERSON";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
			try
			{
				stmt = conn.prepareStatement(sql);
				
			    stmt.setString(1, districtId);
			    
				r = stmt.executeQuery();
				while (r.next())
				{
					team=new TechnicalTeamDTO();
					team.setContactName(r.getString("CONTACT_PERSON"));
					team.setMobileNo(r.getString("CONTACT_MOBILE"));
					
					teamList.add(team);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
		
		
		return teamList;
	}
	

}
