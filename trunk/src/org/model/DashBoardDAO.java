package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.table.CotaDTO;

import util.connection.ConnectionManager;

public class DashBoardDAO {
	
	public String getDivisionWiseStat(String divisionId,String divisionName)
	{		
		Connection conn = ConnectionManager.getConnection();
		String sql = " Select dist_name,dist_id,divisionid,total From DISTRICT " +
				     " Left Outer Join ( " +
				     " Select per_dis,count(*) total from ADDRESS Where Per_div=? " +
				     " Group by per_dis)tmp1 On District.DIST_ID=tmp1.per_dis " +
				     " Where divisionid=? Order by Dist_Name ";

		System.out.println("Stat by District (sql) :" + sql);
		PreparedStatement stmt = null;
		ResultSet r = null;
		String response=" <p class='statLine1'> " +
						" Registration Statistics for <font style='color:blue'> <b>"+divisionName+"</b> </font> Division" +
						" </p>";
			   response+=" <table class='divisionStatTable' width='100%'> " +
						" 	<tr> " +
						"     <th>District</th><th>Total Registered Jobseeker</th> " +
						"	</tr>";
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, divisionId);
			stmt.setString(2, divisionId);
			r = stmt.executeQuery();
			while (r.next())
			{

				response+="<tr onclick=\"loadDistrictStatistics("+r.getString("dist_id")+",'"+r.getString("dist_name")+"')\">";
				response+="<td width='60%' align='left' style='padding-right:10px;'>"+r.getString("dist_name")+"</td>";
				if(r.getInt("total")==0)
					response+="<td class='redCell' width='40%'align='right' style='padding-right:10px;'>"+r.getInt("total")+"</td>";
				else
					response+="<td width='40%' align='right' style='padding-right:10px;'>"+r.getString("total")+"</td>";
	
				
				response+="</tr>";				
			}
			response+="</table>";
		}
		
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}

		return response;
	}
	
	public String getDistrictWiseStat(String districtId,String districtName)
	{		
		
		Connection conn = ConnectionManager.getConnection();
		String sql = " Select THANA_name,THANAID,DISTRICTID,total From THANA " +
				     " Left Outer Join ( " +
				     " Select PER_THANA,count(*) total from ADDRESS Where Per_dis=? " +
				     " Group by PER_THANA)tmp1 On THANA.THANAID=tmp1.PER_THANA " +
				     " Where DISTRICTID=?";

		System.out.println("Stat by Upazilla (sql) :" + sql);
		PreparedStatement stmt = null;
		ResultSet r = null;
		String response=" <p class='statLine1'> " +
						" Registration Statistics for <font style='color:blue'> "+districtName+" </font> District" +
						" </p>";

		      response+=" <table class='divisionStatTable' width='100%'> " +
						" 	<tr> " +
						"     <th>Upazilla</th><th>Total Registered Jobseeker</th> " +
						"	</tr>";
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, districtId);
			stmt.setString(2, districtId);
			r = stmt.executeQuery();
			while (r.next())
			{
				response+="<tr onclick=\"loadThanaStatistics("+r.getString("THANAID")+",'"+r.getString("THANA_name")+"')\">";
				response+="<td align='left' style='padding-right:10px;'>"+r.getString("thana_name")+"</td>";
				if(r.getInt("total")==0)
					response+="<td class='redCell' width='40%'align='right' style='padding-right:10px;'>"+r.getInt("total")+"</td>";
				else
					response+="<td width='40%' align='right' style='padding-right:10px;'>"+r.getString("total")+"</td>";
				response+="</tr>";				
			}
			response+="</table>";
		}
		
		catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}

		return response;
	}
	
	
	public String getThanaWiseStat(String thanaId,String thanaName)
	{		
		
		Connection conn = ConnectionManager.getConnection();
		String sql = " Select UNIONNAME,UNIONID,THANAID,total From UNIONS " +
				     " Left Outer Join ( " +
				     " Select PER_UNION,count(*) total from ADDRESS Where Per_THANA=? " +
				     " Group by PER_UNION)tmp1   On UNIONS.UNIONID =tmp1.PER_UNION " +
				     " Where THANAID=?";

		System.out.println("Stat by Union (sql) :" + sql);
		PreparedStatement stmt = null;
		ResultSet r = null;
		String response=" <p class='statLine1'> " +
						" Registration Statistics for <font style='color:blue'> "+thanaName+" </font> Upazilla" +
						" </p>";

		      response+=" <table class='divisionStatTable' width='100%'> " +
						" 	<tr> " +
						"     <th>Union/Pauroshova</th><th>Total Registered Jobseeker</th> " +
						"	</tr>";
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, thanaId);
			stmt.setString(2, thanaId);
			r = stmt.executeQuery();
			while (r.next())
			{
				response+="<tr>";
				response+="<td align='left' style='padding-right:10px;'>"+r.getString("UNIONNAME")+"</td>";
				if(r.getInt("total")==0)
					response+="<td class='redCell' width='40%'align='right' style='padding-right:10px;'>"+r.getInt("total")+"</td>";
				else
					response+="<td width='40%' align='right' style='padding-right:10px;'>"+r.getString("total")+"</td>";
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
