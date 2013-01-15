package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.connection.ConnectionManager;

public class LotteryDAO {


	public String getTotalRegisteredJobseeker(String districtId)
	{
		
		String total="0";
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
					total=r.getString("total");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return total;
		
	}
	
	public String getTotalCotaNumber(String districtId)
	{
		
		String total="0";
		Connection conn = ConnectionManager.getConnection();
		   String sql = "select sum(cota_total) total from unions Where thanaid in (Select thanaid from thana where districtid=?)";
		   PreparedStatement stmt = null;
		   ResultSet r = null;

		   try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, districtId);
				r = stmt.executeQuery();
				if (r.next())
				{
					total=r.getString("total");
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return total;
		
	}
}
