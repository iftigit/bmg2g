package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.table.LotteryDTO;

import oracle.jdbc.driver.OracleCallableStatement;

import util.connection.ConnectionManager;

public class LotteryDAO {


	public int getTotalRegisteredJobseeker(String districtId)
	{
		
		int total=0;
		Connection conn = ConnectionManager.getConnection();
		   String sql = "Select count(*) total from ADDRESS Where per_Dis=?";
		   PreparedStatement stmt = null;
		   ResultSet r = null;

		   try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				if (r.next())
				{
					total=r.getInt("total");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return total;
		
	}
	
	public int getTotalCotaNumber(String districtId)
	{
		
		int total=0;
		Connection conn = ConnectionManager.getConnection();
		   String sql = "select sum(cota_t) total from unions Where thanaid in (Select thanaid from thana where districtid=?)";
		   PreparedStatement stmt = null;
		   ResultSet r = null;

		   try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				if (r.next())
				{
					total=r.getInt("total");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return total;
		
	}
	public int getTotalSelected(String districtId)
	{
		
		int total=0;
		Connection conn = ConnectionManager.getConnection();
		String sql = "select count(*) total from FIRSTLOTTERY Where dist=?";
		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, districtId);
			r = stmt.executeQuery();
			if (r.next())
			{
				total=r.getInt("total");
			}
		} 
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return total;
		
	}
	
	public String processLottery(String userId)
	{
		 String response="error";
		 Connection conn = ConnectionManager.getConnection();
		 OracleCallableStatement stmt=null;
		 
		    try
			  {
			
				System.out.println("Procedure firstlottery_p Begins");
				 stmt = (OracleCallableStatement) conn.prepareCall(
						 	  "{ call firstlottery_p(?,?) }");
				 

			 		stmt.setString(1,  userId);					
					stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
					stmt.executeUpdate();
					response = (stmt.getString(2)).trim();
					System.out.println("Response : " + response);
					}
				    catch (Exception e){e.printStackTrace();return response;}
			 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
						{e.printStackTrace();}stmt = null;conn = null;}
		 	
			 		return response;
	}
	
	public String getLotteryResult(String districtId)
	{
		   	
		   
	 	   Connection conn = ConnectionManager.getConnection();
	 	  String sql = "SELECT   firstlottery.jobseeker_number, (firstname || ' ' || middlename || ' ' || lastname) jobseekername, " +
		        " fathername, mothername,unions.UNIONNAME " +
		        " FROM firstlottery,address,unions WHERE dist = ? " +
		        " And firstlottery.UNIONS=address.PER_UNION " +
		        " And firstlottery.JOBSEEKER_NUMBER=address.JOBSEEKER_NUMBER " +
		        " And firstlottery.UNIONS=unions.UNIONID ORDER BY unions, gserial";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   String selectedList="";
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				while (r.next())
				{
					selectedList+=r.getString("JOBSEEKER_NUMBER")+"IICTG2GIFTI"+r.getString("JOBSEEKERNAME")+"IICTG2GIFTI"+r.getString("FATHERNAME")+"IICTG2GIFTI"+r.getString("MOTHERNAME")+"IICTG2GIFTI"+r.getString("UNIONNAME")+"NEWJOBSEEKERG2G";
				}
				
				if(selectedList.length()>0)
					selectedList=selectedList.substring(0, selectedList.length()-15);
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return selectedList;

	}
	
	
	public ArrayList<LotteryDTO> getLotteryArrayList(String districtId)
	{
		   	
			ArrayList<LotteryDTO> lotteryList=new ArrayList<LotteryDTO>();
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "SELECT   firstlottery.jobseeker_number, (firstname || ' ' || middlename || ' ' || lastname) jobseekername, " +
		   		        " fathername, mothername,unions.UNIONNAME " +
		   		        " FROM firstlottery,address,unions WHERE dist = ? " +
		   		        " And firstlottery.UNIONS=address.PER_UNION " +
		   		        " And firstlottery.JOBSEEKER_NUMBER=address.JOBSEEKER_NUMBER " +
		   		        " And firstlottery.UNIONS=unions.UNIONID ORDER BY unions, gserial";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   LotteryDTO lottery=new LotteryDTO();
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				while (r.next())
				{
					lottery=new LotteryDTO();
					lottery.setJobseekerName(r.getString("JOBSEEKERNAME"));
					lottery.setFatherName(r.getString("FATHERNAME"));
					lottery.setMotherName(r.getString("MOTHERNAME"));
					lottery.setJobseekerNumber(r.getString("JOBSEEKER_NUMBER"));
					lottery.setUnionName(r.getString("UNIONNAME"));
					lotteryList.add(lottery);
				}
			
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return lotteryList;

	}
	public ArrayList<LotteryDTO> getLotteryArrayListForReport(String districtId)
	{
		   	
			ArrayList<LotteryDTO> lotteryList=new ArrayList<LotteryDTO>();
	 	   Connection conn = ConnectionManager.getConnection();
	 	   /*
		   String sql = "SELECT   firstlottery.jobseeker_number, (firstname || ' ' || middlename || ' ' || lastname) jobseekername, " +
		   		        " fathername, mothername,unions.UNIONNAME,unions.unionid" +
		   		        " FROM firstlottery,address,unions WHERE dist = ? " +
		   		        " And firstlottery.UNIONS=address.PER_UNION " +
		   		        " And firstlottery.JOBSEEKER_NUMBER=address.JOBSEEKER_NUMBER " +
		   		        " And firstlottery.UNIONS=unions.UNIONID ORDER BY unions, gserial";
		   */
	 	   
	 	   String sql=" SELECT   firstlottery.jobseeker_number, (firstname || ' ' || middlename || ' ' || lastname) jobseekername,  " +
	 	   		      " fathername, mothername,unions.UNIONNAME,unions.unionid,thana.THANA_NAME,unions.cota_t " +
	 	   		      " FROM firstlottery,address,unions,thana WHERE dist = ? " +
	 	   		      " And firstlottery.UNIONS=address.PER_UNION " +
	 	   		      " And firstlottery.JOBSEEKER_NUMBER=address.JOBSEEKER_NUMBER " +
	 	   		      " And firstlottery.UNIONS=unions.UNIONID and thana.THANAID=firstlottery.THANA ORDER BY unions, gserial";
	 	   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   LotteryDTO lottery=new LotteryDTO();
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				while (r.next())
				{
					lottery=new LotteryDTO();
					lottery.setJobseekerName(r.getString("JOBSEEKERNAME"));
					lottery.setFatherName(r.getString("FATHERNAME"));
					lottery.setMotherName(r.getString("MOTHERNAME"));
					lottery.setJobseekerNumber(r.getString("JOBSEEKER_NUMBER"));
					lottery.setUnionName(r.getString("UNIONNAME"));
					lottery.setUnionId(r.getString("unionid"));
					lottery.setUpazillaName(r.getString("THANA_NAME"));
					lottery.setTotalQuota(r.getString("cota_t"));
					
					lotteryList.add(lottery);
				}
			
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return lotteryList;

	}
	public String getLotteryStatus(String userId,String districtId)
	{
		
		String status="";
		Connection conn = ConnectionManager.getConnection();
		   String sql = "select decode(FIRSTLOTTERY,null,'NOTCOMPLETED',FIRSTLOTTERY) STATUS from mst_user where DISTRICT_ID=? and userid=? ";
		   PreparedStatement stmt = null;
		   ResultSet r = null;

		   try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				stmt.setString(2, userId);
				r = stmt.executeQuery();
				if (r.next())
				{
					status=r.getString("STATUS");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return status;
		
	}


}
