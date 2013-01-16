package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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


}
