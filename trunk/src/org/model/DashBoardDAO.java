package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.table.CotaDTO;

import util.connection.ConnectionManager;

public class DashBoardDAO {
	
	public String getDivisionWiseStat(String divisionId,int refreshRate)
	{		
		
		Connection conn = ConnectionManager.getConnection();
		String sql = " select district.dist_id,district.dist_name,cota,total,available from Cota_District,District " +
				     " Where cota_district.dist_id=District.dist_id and District.DIVISIONID=? " +
				     " order by district.dist_name";

		System.out.println("Stat by Division (sql) :" + sql);
		PreparedStatement stmt = null;
		ResultSet r = null;
		String response=" <p class='statLine1'> " +
						" Registration Statistics for Dhaka Division | Refresh After: "+getRefreshSelectBoxDivision(refreshRate)+" Seconds." +
						" </p>";
			   response+=" <table class='divisionStatTable' width='100%'> " +
						" 	<tr> " +
						"     <th>District</th><th>Quota</th><th>Total</th><th>Available</th><th>Registration %</th><th>Status</th> " +
						"	</tr>";
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, divisionId);
			r = stmt.executeQuery();
			while (r.next())
			{

				response+="<tr onclick=\"loadDistrictStatistics("+r.getString("dist_id")+",'"+r.getString("dist_name")+"')\">";
				response+="<td>"+r.getString("dist_name")+"</td>";
				response+="<td>"+r.getString("cota")+"</td>";
				response+="<td>"+r.getString("total")+"</td>";
				if(r.getInt("available")==0)
					response+="<td class='redCell'>"+r.getString("available")+"</td>";
				else
					response+="<td>"+r.getString("available")+"</td>";
				
				response+="<td>-</td>";
				if(r.getInt("available")==0)
					response+="<td class='redCell'>Filled</td>";
				else
					response+="<td>Avaiable</td>";
				
				response+="</tr>";				
			}
			response+="</table>";
		}
		
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}

		return response;
	}
	
	public String getDistrictWiseStat(String districtId,String districtName,int refreshRate)
	{		
		
		Connection conn = ConnectionManager.getConnection();
		String sql = " Select * from Cota_Thana,Thana where Thana.THANAID=Cota_Thana.THANA_ID " +
	     " and Thana.DISTRICTID=? and total != 0";

		System.out.println("Stat by Division (sql) :" + sql);
		PreparedStatement stmt = null;
		ResultSet r = null;
		String response=" <p class='statLine1'> " +
						" Registration Statistics for "+districtName+" District | Refresh After "+getRefreshSelectBoxDistrict(refreshRate)+"Seconds" +
						" </p>";

		      response+=" <table class='divisionStatTable' width='100%'> " +
						" 	<tr> " +
						"     <th>Thana</th><th>Quota</th><th>Total</th><th>Available</th><th>Registration %</th><th>Status</th>" +
						"	</tr>";
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, districtId);
			r = stmt.executeQuery();
			while (r.next())
			{
				response+="<tr>";
				response+="<td>"+r.getString("thana_name")+"</td>";
				response+="<td>"+r.getString("cota")+"</td>";
				response+="<td>"+r.getString("total")+"</td>";
				response+="<td>"+r.getString("available")+"</td>";
				response+="<td>-</td>";
				response+="<td>Available</td>";
				response+="</tr>";				
			}
			response+="</table>";
		}
		
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}

		return response;
	}
	
	public String getRefreshSelectBoxDivision(int refreshRate)
	{
		String selectBox=" <select onchange='refreshDivisionStat(this.value)' style='width:100px;border:1px solid grey;'> " +
						 " <option value='10000' "+(refreshRate==10000?"selected='selected'":"")+">10</option> " +
						 " <option value='30000' "+(refreshRate==30000?"selected='selected'":"")+">30</option> " +
						 " <option value='60000' "+(refreshRate==60000?"selected='selected'":"")+">60</option> " +
						 " <option value='0' "+(refreshRate==0?"selected='selected'":"")+">Never</option> " +
						 " </select>";
		
		return selectBox;
	}
	public String getRefreshSelectBoxDistrict(int refreshRate)
	{
		String selectBox=" <select onchange='refreshDistrictStat(this.value)' style='width:100px;border:1px solid grey;'> " +
						 " <option value='10000' "+(refreshRate==10000?"selected='selected'":"")+">10</option> " +
						 " <option value='30000' "+(refreshRate==30000?"selected='selected'":"")+">30</option> " +
						 " <option value='60000' "+(refreshRate==60000?"selected='selected'":"")+">60</option> " +
						 " <option value='0' "+(refreshRate==0?"selected='selected'":"")+">Never</option> " +
						 " </select>";
		
		return selectBox;
	}
	
}
