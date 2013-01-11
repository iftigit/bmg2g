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
		String sql = " Select * from MST_USER where password is null";
		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			while (r.next())
			{
				user=new UserDTO();
				user.setUserId(r.getString("USERID"));
				tmp.add(user);
			}
		} 
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return tmp;
	}
	private static PreparedStatement stmtNewPassword = null;
	private static String sqlNewPassword = "update mst_user set password=? where userid=?";
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
