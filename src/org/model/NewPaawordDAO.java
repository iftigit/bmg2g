package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleCallableStatement;
import util.connection.ConnectionManager;
import java.util.ArrayList;

import org.table.UserDTO;

public class NewPaawordDAO {
	
	public String setSecurityCode(String mobile,String scode)
	{
		String response="";
		Connection conn = ConnectionManager.getConnection();
		OracleCallableStatement stmt=null;
	    try
		{
			 stmt = (OracleCallableStatement) conn.prepareCall(
					 	  "{ call setSecurityCode(?,?,?) }");
			 stmt.setString(1,  mobile);
			 stmt.setString(2,  scode);
			 stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			 stmt.executeUpdate();
			 response = (stmt.getString(3)).trim();
		}
	    catch (Exception e){e.printStackTrace();return response;}
	    finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
	    {e.printStackTrace();}stmt = null;conn = null;}
	    return response;		
	}
	public String setPasswordCode(String mobile,String scode,String pass)
	{
		String response="";
		Connection conn = ConnectionManager.getConnection();
		OracleCallableStatement stmt=null;
	    try
		{
			 stmt = (OracleCallableStatement) conn.prepareCall(
					 	  "{ call setPasswordCode(?,?,?, ?) }");
			 stmt.setString(1,  mobile);
			 stmt.setString(2,  scode);
			 stmt.setString(3,  pass);
			 stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			 stmt.executeUpdate();
			 response = (stmt.getString(4)).trim();
		}
	    catch (Exception e){e.printStackTrace();return response;}
	    finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
	    {e.printStackTrace();}stmt = null;conn = null;}
	    return response;		
	}
	public ArrayList<UserDTO> getAllUser()
	{
		ArrayList<UserDTO> tmp=new ArrayList<UserDTO>();
		UserDTO user=null;
		Connection conn = ConnectionManager.getConnection();
		//String sql = "select password,userid from mst_user where password is null";
		
		String sql = "select password,userid from mst_user where userid in ('01759893928','01677780116','01197228980')";
		
		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			while (r.next())
			{
				user=new UserDTO();
				user.setPassword(r.getString(1));
				user.setUserId(r.getString(2));
				tmp.add(user);
			}
		} 
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return tmp;
	}
	public ArrayList<UserDTO> getFirstLottery()
	{
		ArrayList<UserDTO> tmp=new ArrayList<UserDTO>();
		UserDTO user=null;
		Connection conn = ConnectionManager.getConnection();
//		String sql = "SELECT   fl.jobseeker_number, per_mobile" +
//				"  FROM   FIRSTLOTTERY fl, address a" +
//				" WHERE   THANA='107' and fl.jobseeker_number = A.JOBSEEKER_NUMBER";
		
//		String sql = " select ttc_ename||' TTC', per_mobile from SEND_SMS6457";
//		String sql = "select '01819262175','01819262175' from dual";
		
		//String sql ="select jobseeker_number,per_mobile from VISA_200_110413 where jobseeker_number in(select jobseeker_number from aa)";
		
		//String sql ="select jobseeker_number,PER_MOBILE from DB_G2G.address_all where jobseeker_number in(select jobseeker_number from DB_G2G_NEW.ALLDATA_5840 where slno>1600 and slno<1851 )";
		
//		String sql ="select jobseeker_number,PER_MOBILE from DB_G2G_NEW.sms408 where jobseeker_number  in( "+
//		" select jobseeker_number from  DB_G2G_NEW.btest where jobseeker_number not in( select jobseeker_number from DB_G2G_NEW.atest ))";
		
//		String sql ="select st.JOBSEEKER_NUMBER,ad.PER_MOBILE  from SECONDLOTTERY_T2 st,address ad where st.JOBSEEKER_NUMBER=ad.JOBSEEKER_NUMBER and length(ad.PER_MOBILE)=11 order by st.JOBSEEKER_NUMBER";
	
//		String sql ="select trim(j.FIRSTNAME||' '||j.MIDDLENAME||' '||j.LASTNAME) ,j.NOMINEE_PHONE " +
//				" from jobseeker_t2 j, mobile mm " +
//				" where j.JOBSEEKER_NUMBER=mm.JOBSEEKER_NUMBER ";
		
		
//		String sql="select ad.jobseeker_number , ad.PER_MOBILE from address ad, DB_G2G_NEW.sms205 s where ad.JOBSEEKER_NUMBER= s.JOBSEEKER_NUMBER";
		
//		String sql =" select trim(j.FIRSTNAME||' '||j.MIDDLENAME||' '||j.LASTNAME) ||' Pitar nam: '||j.FATHERNAME ,j.OP_USERID" +
//				"			 from jobseeker_t2 j, mobile mm" +
//				"			 where j.JOBSEEKER_NUMBER=mm.JOBSEEKER_NUMBER";
		
		String sql ="select ad.JOBSEEKER_NUMBER,ad.PER_MOBILE from ADDRESS_T2 ad, AllSec2nd se where se.JOBSEEKER_NUMBER=ad.JOBSEEKER_NUMBER and slno between 751 and 900";
		
		
//		String sql ="select JOBSEEKER_NUMBER,PER_MOBILE from DB_G2G_NEW.VISA_174_170813";
		
		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			while (r.next())
			{
				user=new UserDTO();
				user.setPassword(r.getString(1));
				user.setUserId(r.getString(2));
				tmp.add(user);
			}
		} 
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return tmp;
	}
	public String getLottery1(String regid)
	{
		Connection conn = ConnectionManager.getConnection();
		//String sql = " Select count(*) from firstlottery where JOBSEEKER_NUMBER=?";
		String sql = " Select count(*) from SECONDLOTTERY_T2 where JOBSEEKER_NUMBER=?";
		PreparedStatement stmt = null;
		ResultSet r = null;
		String tmp = "no";
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, regid);
			r = stmt.executeQuery();
			r.next();
			if (r.getInt(1)>0)
			{
				tmp="yes";
			}
		} 
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return tmp;
	}
	private static PreparedStatement stmtNewPassword = null;
	private static String sqlNewPassword = "update MST_USER set password=? where userid=?";
	private static Connection connection = null;
	public static void setNewPassword(String user,String pass)
	{
		String response="";
		try
		{
			if(connection==null || connection.isClosed())
                connection = ConnectionManager.getConnection();
			if(stmtNewPassword==null)
				stmtNewPassword = connection.prepareStatement(sqlNewPassword);
			 stmtNewPassword.setString(1,  pass);
			 stmtNewPassword.setString(2,  user);
			 stmtNewPassword.execute();
			 stmtNewPassword.clearParameters();
		}
	    catch (Exception e){e.printStackTrace();}
	}	
}
