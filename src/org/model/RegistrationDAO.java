package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.controller.registration.JobseekerDTO;
import org.table.AddressDTO;
import org.table.EducationDTO;
import org.table.ExperienceDTO;
import org.table.LanguageDTO;
import org.table.LogDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;
import org.table.TrainingDTO;
import util.connection.ConnectionManager;


public class RegistrationDAO {
	
	 public String insertEmpRegistrationInfo(String registrationId,PersonalInfoDTO personalDTO,AddressDTO addressDTO,NomineeDTO nomineeDTO,
			 										LogDTO logDTO,String userId
			 										) 
	    {	     
			 String response="";
			 Connection conn = ConnectionManager.getConnection();
			 OracleCallableStatement stmt=null;
			 
			    try
				  {
				
					System.out.println("Procedure Insert_RegInfo Begins");
					 stmt = (OracleCallableStatement) conn.prepareCall(
							 	  "{ call Insert_RegInfo(?,?,?,?,?,?,?,?,?,?," +
					                                    "?,?,?,?,?,?,?,?,?,?, " +
					                                    "?,?,?,?,?,?,?,?,?,?, " +
					                                    "?,?,?,?,?,?,?,?,?,?, " +
					                                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
					 

				 		stmt.setString(1,  registrationId);
						stmt.setString(2,  personalDTO.getEmpFname());
						stmt.setString(3,  personalDTO.getEmpMname());
						stmt.setString(4,  personalDTO.getEmpLname());
						stmt.setString(5,  personalDTO.getFatherName());
						stmt.setString(6,  personalDTO.getMotherName());
						stmt.setString(7,  personalDTO.getSpousName());
						stmt.setString(8,  personalDTO.getNationalId());
						stmt.setString(9,  personalDTO.getBirthDate());
						stmt.setString(10, personalDTO.getAge());
						stmt.setString(11, personalDTO.getMaritalStatus());
						stmt.setString(12, personalDTO.getSex());
						stmt.setString(13, personalDTO.getWeight());
						stmt.setString(14, personalDTO.getHeight());
						stmt.setString(15, personalDTO.getPassportNo());
						stmt.setString(16, personalDTO.getPassportIssueDate());
						stmt.setString(17, personalDTO.getPassportExpireDate());
						stmt.setString(18, personalDTO.getReligion());
						
						stmt.setString(19, addressDTO.getpDivision());
						stmt.setString(20, addressDTO.getpDistrict());
						stmt.setString(21, addressDTO.getpThana());
						stmt.setString(22, addressDTO.getpPost());
						stmt.setString(23, addressDTO.getpPostCode());
						stmt.setString(24, addressDTO.getpAddressLine1());
						stmt.setString(25, addressDTO.getpAddressLine2());						
						stmt.setString(26, addressDTO.getpEmail());
						stmt.setString(27, addressDTO.getpMobile());
						
						stmt.setString(28, addressDTO.getmDivision());
						stmt.setString(29, addressDTO.getmDistrict());
						stmt.setString(30, addressDTO.getmThana());
						stmt.setString(31, addressDTO.getmPost());
						stmt.setString(32, addressDTO.getmPostCode());
						stmt.setString(33, addressDTO.getmAddressLine1());
						stmt.setString(34, addressDTO.getmAddressLine2());						
						stmt.setString(35, addressDTO.getmEmail());
						//stmt.setString(36, addressDTO.getmMobile());
						stmt.setString(36, addressDTO.getpMobile());

						
						stmt.setString(37, nomineeDTO.getNomineeName());
						stmt.setString(38, nomineeDTO.getNomineeRelation());
						stmt.setString(39, nomineeDTO.getNomineePhone());
						stmt.setString(40, nomineeDTO.getNomineeAddress());
						stmt.setString(41, nomineeDTO.getContactName());
						stmt.setString(42, nomineeDTO.getContactMobile());
						
						stmt.setString(43, personalDTO.getCotaUnionId());
						stmt.setString(44, personalDTO.getDesiredJob1()==null?"":personalDTO.getDesiredJob1());
						stmt.setString(45, personalDTO.getDesiredJobCat1()==null?"":personalDTO.getDesiredJobCat1());
						stmt.setString(46, personalDTO.getDesiredJobSubcategory1()==null?"":personalDTO.getDesiredJobSubcategory1());
						
						stmt.setString(47, logDTO.getxForward()); 
						stmt.setString(48, logDTO.getVia());
						stmt.setString(49, logDTO.getRemoteAddress());
						stmt.setString(50, addressDTO.getPUnion());
						stmt.setString(51, addressDTO.getMUnion());
						stmt.setString(52, userId);
						
						stmt.setString(53, personalDTO.getHeightFeet());
						stmt.setString(54, personalDTO.getHeightInches());
						
						stmt.registerOutParameter(55, java.sql.Types.VARCHAR);
						stmt.executeUpdate();
						response = (stmt.getString(55)).trim();
						System.out.println("Response : " + response);
						}
					    catch (Exception e){e.printStackTrace();return response;}
				 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
							{e.printStackTrace();}stmt = null;conn = null;}
			 	
				 		return response;	           
	    }
	 
	 public PersonalInfoDTO getPersonalInformation(String registrationId)
	 {
		 	Connection conn = ConnectionManager.getConnection();
		   String sql = " select jobseeker.jobseeker_number,(firstname||' '||middlename|| ' '||lastname) fullname,fathername,mothername, " +
		   				" to_char(sysdate,'dd-mm-YYYY HH:MI:SS') printedOn,REAL_IP, " +
		   				" to_char(APPLICATION_DATETIME,'dd-mm-YYYY HH24:MI:SS') applicationDateTime,UNIONNAME,PER_MOBILE from JOBSEEKER,UNIONS,ADDRESS " +
		   				" where jobseeker.jobseeker_number=? AND UNIONS.UNIONID=COTA_UNION AND JOBSEEKER.JOBSEEKER_NUMBER=ADDRESS.JOBSEEKER_NUMBER";
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   PersonalInfoDTO personalDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				if (r.next())
				{
					personalDto=new PersonalInfoDTO();
					personalDto.setEmpFullName(r.getString("FULLNAME"));
					personalDto.setFatherName(r.getString("FATHERNAME"));
					personalDto.setMotherName(r.getString("MOTHERNAME"));
					personalDto.setRegId(r.getString("jobseeker_number"));
					personalDto.setPrintedOn(r.getString("printedOn"));
					personalDto.setApplicationDateTime(r.getString("applicationDateTime"));
					personalDto.setIpAddress(r.getString("REAL_IP"));
					personalDto.setQuotaUnionName(r.getString("UNIONNAME"));
					personalDto.setContactMobileNumber(r.getString("PER_MOBILE"));
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return personalDto;
	 }
	 
	 public int updateInterviewInforamtion(String registrationId,int ttcId,String interviewDate)
	 {
		 	Connection conn = ConnectionManager.getConnection();
		   String sql = " Update JOBSEEKER Set TTC_ID=?,INTVIEW_DATE=to_date(?,'dd-MM-YYYY') Where JOBSEEKER_NUMBER=?";
		   PreparedStatement stmt = null;
		   int response=0;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ttcId);
				stmt.setString(2, interviewDate);
				stmt.setString(3, registrationId);
				response = stmt.executeUpdate();
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return response;
	 }
	 
	 public ArrayList<JobseekerDTO> getAllRegisteredJobseeker(String operatorId)
	 {
		 Connection conn = ConnectionManager.getConnection();
		 ArrayList<JobseekerDTO> jobSeekerList=new ArrayList<JobseekerDTO>();
		   String sql = " Select JOBSEEKER.JOBSEEKER_NUMBER,FIRSTNAME,MIDDLENAME,LASTNAME,FATHERNAME,MOTHERNAME,DIVISION.DIVISION_NAME, " +
		   		" DISTRICT.DIST_NAME,THANA.THANA_NAME,UNIONS.UNIONNAME from jobseeker,ADDRESS,DIVISION,DISTRICT,THANA,UNIONS Where " +
		   		"  OP_USERID=? " +
		   		" And JOBSEEKER.JOBSEEKER_NUMBER=ADDRESS.JOBSEEKER_NUMBER " +
		   		" And ADDRESS.PER_DIV=DIVISION.DIVISIONID " +
		   		"  And ADDRESS.PER_DIS=DISTRICT.DIST_ID " +
		   		"  And ADDRESS.PER_THANA=THANA.THANAID " +
		   		"  And ADDRESS.PER_UNION=UNIONS.UNIONID";
		   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   JobseekerDTO jobseeker  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, operatorId);
				r = stmt.executeQuery();
				while (r.next())
				{
					jobseeker=new JobseekerDTO();
					jobseeker.setRegId(r.getString("JOBSEEKER_NUMBER"));
					jobseeker.setName(r.getString("FIRSTNAME")+" "+r.getString("MIDDLENAME")+" "+r.getString("LASTNAME"));
					jobseeker.setFatherName(r.getString("FATHERNAME"));
					jobseeker.setMotherName(r.getString("MOTHERNAME"));
					jobseeker.setpDivisionName(r.getString("DIVISION_NAME"));
					jobseeker.setpDistrictName(r.getString("DIST_NAME"));
					jobseeker.setpThanaName(r.getString("THANA_NAME"));
					jobseeker.setpUnionName(r.getString("UNIONNAME"));
					jobSeekerList.add(jobseeker);
					
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return jobSeekerList;
	 }
	 
	
	 

}
