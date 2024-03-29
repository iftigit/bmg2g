package org.singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.table.TtcDTO;

import oracle.jdbc.driver.OracleCallableStatement;

import util.connection.ConnectionManager;


public class RegistrationSingleton {
    

    
    
     
    //Marking default constructor private
    //to avoid direct instantiation.
    private RegistrationSingleton() {
    }
 
    //Get instance for class SimpleSingleton
    /*
    public static synchronized String generateRegistrationId()
	 {
    	   String registrationId = null;
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "select SQN_REGID.nextval regId from dual";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				r = stmt.executeQuery();
				if (r.next())
				{
					registrationId=r.getString("regId");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return registrationId;
	 }
	 */
    public static synchronized String generateRegistrationId(String distId,String sex)
	 {
   	   	   String registrationId = null;
	 	   Connection conn = ConnectionManager.getConnection();
	 	   OracleCallableStatement stmt=null;
		   try
			  {
				 System.out.println("Procedure Generate_RegId Begins");
				 stmt = (OracleCallableStatement) conn.prepareCall(
						 	  "{ call Generate_RegId(?,?,?) }");
				 

			 		stmt.setString(1,  distId);
					stmt.setString(2,  sex);
					stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
					stmt.executeUpdate();
					registrationId = (stmt.getString(3)).trim();
					System.out.println("registrationId : " + registrationId);
			  }
			    catch (Exception e){e.printStackTrace();return registrationId;}
		 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
					{e.printStackTrace();}stmt = null;conn = null;}
		 			 		
	 	return registrationId;
	 }
    
    
    public static synchronized String decreaseRegistrationCount(String regId,String distId,String thanaId)
	 {
		 String response="";
		 Connection conn = ConnectionManager.getConnection();
		 OracleCallableStatement stmt=null;

		 try
		  {
			 System.out.println("Procedure Manage_RegCount Begins");
			 stmt = (OracleCallableStatement) conn.prepareCall(
					 	  "{ call Manage_RegCount(?,?,?,?) }");
			 

		 		stmt.setString(1,  regId);
				stmt.setString(2,  distId);
				stmt.setString(3,  thanaId);
				stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
				stmt.executeUpdate();
				response = (stmt.getString(4)).trim();
				System.out.println("Response : " + response);
		  }
		    catch (Exception e){e.printStackTrace();return response;}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
 	
	 		return response;	           
	 }
    
    public static synchronized int decreaseInterviewCount(int ttcId,String interviewDate)
	 {
    	Connection conn = ConnectionManager.getConnection();
		   String sql = " Update TTC_INTERVIEW Set AVAILABLE=AVAILABLE-1 Where TTC_ID=? and INTERVIEW_DATE=to_date(?,'dd-MM-YYYY')";
		   PreparedStatement stmt = null;
		   int response=0;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ttcId);
				stmt.setString(2, interviewDate);
				response = stmt.executeUpdate();
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return response;
	 }
    
    public static synchronized int avaiabilityCount(String thanaId)
	 {
  	   	   int  total = 0;
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = "Select available from COTA_Thana where thana_id=?";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, thanaId);
				r = stmt.executeQuery();
				if (r.next())
				{
					total=r.getInt("available");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return total;
	 }
    
    public static synchronized TtcDTO getInterviewInformation(String districtId)
	 {
    	   TtcDTO ttcDTO=new TtcDTO();
	 	   Connection conn = ConnectionManager.getConnection();
		   String sql = " Select to_char(min(interview_date),'dd-MM-YYYY') int_date,max(MST_TTC.TTC_NAME) ttc_name,max(MST_TTC.TTC_ID) ttc_id from  " +
		   		        " TTC_INTERVIEW,MST_TTC where TTC_INTERVIEW.ttc_id=(Select TTC_ID from DISTRICT Where Dist_Id=?) " +
		   		        " And TTC_INTERVIEW.TTC_ID=MST_TTC.TTC_ID And available>0 ";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				if (r.next())
				{
					ttcDTO.setInterviewDate(r.getString("int_date"));
					ttcDTO.setTtcId(r.getInt("ttc_id"));
					ttcDTO.setTtcName(r.getString("ttc_name"));
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return ttcDTO;
	 }
    
    
}


