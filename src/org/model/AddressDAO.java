package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.table.AddressDTO;

import util.connection.ConnectionManager;

public class AddressDAO {


	public static ArrayList<AddressDTO> getAllDivision()
	{
		ArrayList<AddressDTO> divisionList=new ArrayList<AddressDTO>();
		
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "SELECT DIVISIONID,DIVISION_NAME FROM DIVISION ORDER BY DIVISIONID";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   AddressDTO addressDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				r = stmt.executeQuery();
				while (r.next())
				{
					addressDto=new AddressDTO();
					addressDto.setDivision_id(r.getInt("DIVISIONID"));
					addressDto.setDivision_name(r.getString("DIVISION_NAME"));
					divisionList.add(addressDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return divisionList;

	}
	
	public String getDivisionNameFromId(int divId)
	{
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "SELECT DIVISION_NAME FROM DIVISION WHERE DIVISIONID=?";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   String divName="";
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, divId);
				r = stmt.executeQuery();
				if (r.next())
				{
					divName=r.getString("DIVISION_NAME");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return divName;

	}
	
	public String getDistrictNameFromId(int distId)
	{
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "Select DIST_NAME from DISTRICT Where dist_id=?";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   String districtName="";
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, distId);
				r = stmt.executeQuery();
				if (r.next())
				{
					districtName=r.getString("DIST_NAME");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return districtName;

	}
	

	public String getThanaNameFromId(String thanaId)
	{
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "Select THANA_NAME from THANA where Thanaid=?";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   String districtName="";
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, thanaId);
				r = stmt.executeQuery();
				if (r.next())
				{
					districtName=r.getString("THANA_NAME");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return districtName;

	}
	
	public static ArrayList<AddressDTO> getAllDistrict()
	{
		ArrayList<AddressDTO> districtList=new ArrayList<AddressDTO>();
		
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "SELECT DIST_CODE,DIST_NAME,DIST_ID,DIVISIONID FROM DISTRICT ORDER BY DIST_NAME";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   AddressDTO addressDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				r = stmt.executeQuery();
				while (r.next())
				{
					addressDto=new AddressDTO();
					addressDto.setDistrict_code(r.getString("DIST_CODE"));
					addressDto.setDistrict_name(r.getString("DIST_NAME"));
					addressDto.setDistrict_id(r.getInt("DIST_ID"));
					addressDto.setDivision_id(r.getInt("DIVISIONID"));
					
					districtList.add(addressDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
		return districtList;
	}
	public static ArrayList<AddressDTO> getAllThana()
	{
		ArrayList<AddressDTO> thanaList=new ArrayList<AddressDTO>();
		   Connection conn = ConnectionManager.getConnection();
		   String sql = "SELECT THANAID, DISTRICTID, THANA_NAME FROM THANA ORDER BY THANA_NAME";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   AddressDTO addressDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				r = stmt.executeQuery();
				while (r.next())
				{
					addressDto=new AddressDTO();
					addressDto.setThana_id(r.getString("THANAID"));
					addressDto.setDistrict_id(Integer.parseInt(r.getString("DISTRICTID")));
					addressDto.setThana_name(r.getString("THANA_NAME"));
					
					thanaList.add(addressDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}

	 		return thanaList;
	}
	
	public ArrayList<String> getDistrict(int divId)
	{
		ArrayList<String> distList=new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection();
		String sql = "select dist_name,dist_id from district where divisionid="+divId;

		Statement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next())
			{
				distList.add(r.getString("DIST_NAME"));
				distList.add(r.getString("DIST_ID"));
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}

		return distList;
	}
	
	
	public ArrayList<String> getThana(int distId)
	{
		ArrayList<String> thanaList=new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection();
		
		String sql = "select thana_name,thanaid from thana where districtid="+distId;

		Statement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next())
			{
				thanaList.add(r.getString("THANA_NAME"));
				thanaList.add(r.getString("THANAID"));
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}

		return thanaList;
	}

}