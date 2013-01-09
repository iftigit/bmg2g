package org.model;

import java.sql.Connection;

import oracle.jdbc.driver.OracleCallableStatement;
import util.connection.ConnectionManager;

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

}
