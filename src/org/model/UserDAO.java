package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.table.UserDTO;

import util.connection.ConnectionManager;

public class UserDAO {
	
	
	public UserDTO validateLogin(String userId,String password)
	{
		UserDTO user=null;
		
		 Connection conn = ConnectionManager.getConnection();
		   String sql = " Select * from MST_USER Where userid=? and password=?";
		   
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
					user.setLocalIp(r.getString("LOCAL_IP"));
					user.setVia(r.getString("VIA"));
					user.setRealIp(r.getString("REAL_IP"));
					user.setUnionId(r.getString("UNION_ID"));
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
	

}
