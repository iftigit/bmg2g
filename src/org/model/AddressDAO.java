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
	
	public String getUnionNameFromId(String unionId)
	{
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "Select UNIONNAME from UNIONS where UNIONID=?";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   String unionName="";
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, unionId);
				r = stmt.executeQuery();
				if (r.next())
				{
					unionName=r.getString("UNIONNAME");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return unionName;

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
	
	public static ArrayList<AddressDTO> getAllUnion()
	{
		ArrayList<AddressDTO> thanaList=new ArrayList<AddressDTO>();
		   Connection conn = ConnectionManager.getConnection();
		   String sql = "Select UNIONID,THANAID,UNIONNAME From UNIONS Order By UnionName";
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
					addressDto.setUnion_id(r.getString("UNIONID"));
					addressDto.setThana_id(r.getString("THANAID"));
					addressDto.setUnion_name(r.getString("UNIONNAME"));
					
					thanaList.add(addressDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}

	 		return thanaList;
	}
	
	
	public ArrayList<AddressDTO> getDivision(int divId)
	{

		ArrayList<AddressDTO> divisionList=new ArrayList<AddressDTO>();
		
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "select divisionid,division_name from division where divisionid="+divId;
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
	
	public ArrayList<AddressDTO> getOperatorDistrict(int districtId)
	{
		ArrayList<AddressDTO> districtList=new ArrayList<AddressDTO>();
		
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "SELECT * FROM DISTRICT Where DIST_ID='"+districtId+"' ORDER BY DIST_NAME";
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
					
					districtList.add(addressDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
		return districtList;

		
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
	
	public ArrayList<AddressDTO> getUpazilla(String updazillaId,String districtId)
	{
		   ArrayList<AddressDTO> thanaList=new ArrayList<AddressDTO>();
		   Connection conn = ConnectionManager.getConnection();
		   /*
		   String sql = " Select * from Thana Where DistrictId='"+districtId+"' " +
		     " and thanaid='"+updazillaId+"' or thanaid in (Select thanaid from thana where districtid='"+districtId+"' and is_pauro=1)";
		   */
		   String sql = " Select * from Thana Where DistrictId='"+districtId+"' " +
		     " and thanaid='"+updazillaId+"' ";
		   
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
					addressDto.setThana_name(r.getString("THANA_NAME"));
					
					thanaList.add(addressDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}

	 		return thanaList;

	}

	
	public ArrayList<String> getUnion(int thanaId)
	{
		ArrayList<String> thanaList=new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection();
		
		String sql = "select unionname,unionid from UNIONS where thanaid='"+thanaId+"' order by 1";

		Statement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next())
			{
				thanaList.add(r.getString("UNIONNAME"));
				thanaList.add(r.getString("UNIONID"));
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}

		return thanaList;
	}
	
	public AddressDTO getAddressInformation(String registrationId)
	 {
		   Connection conn = ConnectionManager.getConnection();
		   String sql = "Select * from SECONDLOTTERY_T1 sl,Address addr,Division,District,Thana,Unions " +
		   "Where sl.JOBSEEKER_NUMBER=addr.JOBSEEKER_NUMBER " +
		   "And   addr.PER_DIV=Division.DIVISIONID " +
		   "And   addr.PER_DIS=District.DIST_ID " +
		   "And   addr.PER_THANA=Thana.THANAID " +
		   "And   addr.PER_UNION=Unions.UNIONID " +
		   "And   sl.jobseeker_number=? ";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   AddressDTO addressDTO  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				if (r.next())
				{
					addressDTO=new AddressDTO();
					addressDTO.setpDivisionName(r.getString("DIVISION_NAME"));
					addressDTO.setpDistrictName(r.getString("DIST_NAME"));
					addressDTO.setpThanaName(r.getString("THANA_NAME"));
					addressDTO.setPUnionName(r.getString("UNIONNAME"));
					addressDTO.setpPost(r.getString("PER_POST_OFFICE"));
					addressDTO.setpPostCode(r.getString("PER_POST_CODE"));					
					addressDTO.setpAddressLine1(r.getString("PER_ADDRESS_LINE1"));
					addressDTO.setpAddressLine2(r.getString("PER_ADDRESS_LINE2"));
					addressDTO.setpEmail(r.getString("PER_EMAIL"));
					addressDTO.setpMobile(r.getString("PER_MOBILE"));
					
					addressDTO.setmDivisionName(r.getString("MAIL_DIV"));
					addressDTO.setmDistrictName(r.getString("MAIL_DIS"));
					addressDTO.setmThanaName(r.getString("MAIL_THANA"));
					addressDTO.setMUnionName(r.getString("MAIL_UNION"));
					addressDTO.setmPost(r.getString("MAIL_POST_OFFICE"));
					addressDTO.setmPostCode(r.getString("MAIL_POST_CODE"));					
					addressDTO.setmAddressLine1(r.getString("MAIL_ADDRESS_LINE1"));
					addressDTO.setmAddressLine2(r.getString("MAIL_ADDRESS_LINE2"));
					addressDTO.setmEmail(r.getString("MAIL_EMAIL"));
					addressDTO.setmMobile(r.getString("MAIL_MOBILE"));
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return addressDTO;
	 }
	
	public AddressDTO getAllAddressInformation(String registrationId)
	 {
		   Connection conn = ConnectionManager.getConnection();
		   
		   String sql = "Select Address.*,DIVISION.DIVISION_NAME pDivisionName,DISTRICT.DIST_NAME pDistrictName, " +
		   "UNIONS.UNIONNAME pUnionName, THANA.THANA_NAME pThanaName from Address,SECONDLOTTERY_T1,DIVISION,DISTRICT,UNIONS,THANA " +
		   "Where Address.JOBSEEKER_NUMBER=SECONDLOTTERY_T1.JOBSEEKER_NUMBER  " +
		   "And SECONDLOTTERY_T1.JOBSEEKER_NUMBER=? " +
		   "And Address.PER_DIV=DIVISION.DIVISIONID " +
		   "And Address.PER_DIS=DISTRICT.DIST_ID " +
		   "And Address.PER_THANA=THANA.THANAID " +
		   "And Address.PER_UNION=UNIONS.UNIONID ";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   AddressDTO addressDTO  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				if (r.next())
				{
					addressDTO=new AddressDTO();
					addressDTO.setpDivision(r.getString("PER_DIV"));
					addressDTO.setpDistrict(r.getString("PER_DIS"));
					addressDTO.setpThana(r.getString("PER_THANA"));
					addressDTO.setPUnion(r.getString("PER_UNION"));
					
					addressDTO.setpDivisionName(r.getString("pDivisionName"));
					addressDTO.setpDistrictName(r.getString("pDistrictName"));
					addressDTO.setpThanaName(r.getString("pUnionName"));
					addressDTO.setPUnionName(r.getString("pThanaName"));
					
					
					addressDTO.setpPost(r.getString("PER_POST_OFFICE"));
					addressDTO.setpPostCode(r.getString("PER_POST_CODE"));										
					addressDTO.setpAddressLine1(r.getString("PER_ADDRESS_LINE1"));
					addressDTO.setpAddressLine2(r.getString("PER_ADDRESS_LINE2"));
					addressDTO.setpEmail(r.getString("PER_EMAIL"));
					addressDTO.setpMobile(r.getString("PER_MOBILE"));
					
					
					addressDTO.setmDivision(r.getString("MAIL_DIV"));
					addressDTO.setmDistrict(r.getString("MAIL_DIS"));
					addressDTO.setmThana(r.getString("MAIL_THANA"));
					addressDTO.setMUnion(r.getString("MAIL_UNION"));
					addressDTO.setmPost(r.getString("MAIL_POST_OFFICE"));
					addressDTO.setmPostCode(r.getString("MAIL_POST_CODE"));					
					addressDTO.setmAddressLine1(r.getString("MAIL_ADDRESS_LINE1"));
					addressDTO.setmAddressLine2(r.getString("MAIL_ADDRESS_LINE2"));
					addressDTO.setmEmail(r.getString("MAIL_EMAIL"));
					addressDTO.setmMobile(r.getString("MAIL_MOBILE"));
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return addressDTO;
	 }
}