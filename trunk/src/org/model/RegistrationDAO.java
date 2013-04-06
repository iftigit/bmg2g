package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleCallableStatement;

import org.controller.registration.JobseekerDTO;
import org.table.AddressDTO;
import org.table.LogDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;
import org.table.PoliceDTO;
import org.table.SelectPersonDTO;


import com.lowagie.text.Image;

import util.connection.ConnectionManager;
import util.connection.TransactionManager;


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
	 
	 
	 public String updateEmpRegistrationInfo(PersonalInfoDTO personalDTO,AddressDTO addressDTO,String userId) 
			{	     
				String response="error";
				TransactionManager transactionManager=new TransactionManager();
				Connection conn = transactionManager.getConnection();
				PreparedStatement stmt = null;
				int totalUpdate=0;
				
				String personalInfoSql="Update JOBSEEKER Set FIRSTNAME=?, " +
					"MIDDLENAME=?, " +
					"LASTNAME=?, " +
					"FATHERNAME=?, " +
					"MOTHERNAME=?, " +
					"SPOUSNAME=?, " +
					"NATIONALID=?, " +
					"BIRTHDATE=to_date(?,'DD-MM-YYYY'), " +
					"AGE=?, " +
					"RELIGION=?, " +
					"MARITALSTATUS=?, " +
					"SEX=?, " +
					"WEIGHT=?, " +
					"PASSPORTNO=?, " +
					"PASSPORT_ISSUE_DATE=to_date(?,'DD-MM-YYYY'), " +
					"PASSPORT_EXP_DATE=to_date(?,'DD-MM-YYYY'), " +
					"NOMINEE_NAME=?, " +
					"NOMINEE_RELATION=?, " +
					"NOMINEE_ADDRESS=?, " +
					"NOMINEE_PHONE=?, " +
					"CONTACT_NAME=?, " +
					"CONTACT_PHONE=?, " +
					"JOB1=?, " +
					"JOBCAT2=?, " +
					"JOBSUBCAT2=?, " +
					"HEIGHT_FEET=?, " +
					"HEIGHT_INCHES=? " +
					"Where JOBSEEKER_NUMBER=? ";
				
			  String addressInfoSql="Update ADDRESS Set MAIL_DIV=?, " +
				  "MAIL_DIS=?, " +
				  "MAIL_THANA=?, " +
				  "MAIL_UNION=?, " +
				  "MAIL_POST_OFFICE=?, " +
				  "MAIL_POST_CODE=?, " +
				  "MAIL_ADDRESS_LINE1=?, " +
				  "MAIL_ADDRESS_LINE2=?, " +
				  "MAIL_EMAIL=?, " +
				  "MAIL_MOBILE=?,  " +
				  
				  "PER_POST_OFFICE=?, " +
				  "PER_POST_CODE=?, " +
				  "PER_ADDRESS_LINE1=?, " +
				  "PER_ADDRESS_LINE2=?, " +
				  "PER_EMAIL=?, " +
				  "PER_MOBILE=?  " +
				  
				  "Where JOBSEEKER_NUMBER=? ";
			  
			  String sqlEdit = " Insert Into EDIT_LOG(JOBSEEKER_NUMBER,USERID,UPDATE_DATE) VALUES(?,?,SYSDATE)";
			  
				try
				{
					stmt = conn.prepareStatement(personalInfoSql);

					stmt.setString(1,personalDTO.getEmpFname());
					stmt.setString(2,personalDTO.getEmpMname());
					stmt.setString(3,personalDTO.getEmpLname());					
					stmt.setString(4,personalDTO.getFatherName());
					stmt.setString(5,personalDTO.getMotherName());
					stmt.setString(6,personalDTO.getSpousName());
					stmt.setString(7,personalDTO.getNationalId());
					stmt.setString(8,personalDTO.getBirthDate());
					stmt.setString(9,personalDTO.getAge());
					stmt.setString(10,personalDTO.getReligion());
					stmt.setString(11,personalDTO.getMaritalStatus());
					stmt.setString(12,personalDTO.getSex());
					stmt.setString(13,personalDTO.getWeight());
					stmt.setString(14,personalDTO.getPassportNo());
					stmt.setString(15,personalDTO.getPassportIssueDate());
					stmt.setString(16,personalDTO.getPassportExpireDate());
					stmt.setString(17,personalDTO.getNomineeName());
					stmt.setString(18,personalDTO.getNomineeRelation());
					stmt.setString(19,personalDTO.getNomineeAddress());
					stmt.setString(20,personalDTO.getNomineePhone());
					stmt.setString(21,personalDTO.getContactName());
					stmt.setString(22,personalDTO.getContactMobile());
					stmt.setString(23,personalDTO.getDesiredJob1());
					stmt.setString(24,personalDTO.getDesiredJobCat1());
					stmt.setString(25,personalDTO.getDesiredJobSubcategory1());
					stmt.setString(26,personalDTO.getHeightFeet());
					stmt.setString(27,personalDTO.getHeightInches());
					stmt.setString(28,personalDTO.getJobseekerNumber());
						
					totalUpdate+=stmt.executeUpdate();
					
					stmt = conn.prepareStatement(addressInfoSql);
					
					stmt.setString(1,addressDTO.getmDivision());
					stmt.setString(2,addressDTO.getmDistrict());
					stmt.setString(3,addressDTO.getmThana());
					stmt.setString(4,addressDTO.getMUnion());
					stmt.setString(5,addressDTO.getmPost());
					stmt.setString(6,addressDTO.getmPostCode());
					stmt.setString(7,addressDTO.getmAddressLine1());
					stmt.setString(8,addressDTO.getmAddressLine2());
					stmt.setString(9,addressDTO.getmEmail());
					stmt.setString(10,addressDTO.getpMobile());
					
					stmt.setString(11,addressDTO.getpPost());
					stmt.setString(12,addressDTO.getpPostCode());
					stmt.setString(13,addressDTO.getpAddressLine1());
					stmt.setString(14,addressDTO.getpAddressLine2());
					stmt.setString(15,addressDTO.getpEmail());
					stmt.setString(16,addressDTO.getpMobile());
					
					stmt.setString(17,personalDTO.getJobseekerNumber());
					
					totalUpdate+=stmt.executeUpdate();
					
					
					stmt = conn.prepareStatement(sqlEdit);
					stmt.setString(1, personalDTO.getJobseekerNumber());
					stmt.setString(2, userId);
					totalUpdate+=stmt.executeUpdate();
					
					
					transactionManager.commit();
					
					
					
					if(totalUpdate==3)
						response="success";
					else
						response="noupdate";
				} 

				catch (Exception e){e.printStackTrace();
				try {
					transactionManager.rollback();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
 		finally{try{stmt.close();transactionManager.close();} catch (Exception e)
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
	 
	 public PersonalInfoDTO getAllPersonalInformation(String registrationId)
	 {
		 	Connection conn = ConnectionManager.getConnection();
		   String sql = " select jobseeker.jobseeker_number, jobseeker.firstname, jobseeker.middlename, jobseeker.lastname, " +
		   		        " jobseeker.fathername, jobseeker.mothername,SPOUSNAME,NATIONALID, " +
		   		        " TO_CHAR(BIRTHDATE,'DD-MM-YYYY') BDATE,AGE,RELIGION,MARITALSTATUS,SEX,WEIGHT,PASSPORTNO, " +
		   		        " TO_CHAR(PASSPORT_ISSUE_DATE,'DD-MM-YYYY') PASS_ISSUE_DATE,TO_CHAR(PASSPORT_EXP_DATE,'DD-MM-YYYY') PASS_EXP_DATE, " +
		   		        " NOMINEE_NAME,NOMINEE_RELATION,NOMINEE_ADDRESS,NOMINEE_PHONE,CONTACT_NAME,CONTACT_PHONE,HEIGHT_FEET,HEIGHT_INCHES,  " +
		   		        " JOB1,JOBCAT2,JOBSUBCAT2 from JOBSEEKER,SECONDLOTTERY_T1 " +
		   				" where jobseeker.jobseeker_number=? and jobseeker.jobseeker_number= SECONDLOTTERY_T1.jobseeker_number";
		   
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
					personalDto.setJobseekerNumber(r.getString("JOBSEEKER_NUMBER"));
					personalDto.setEmpFname(r.getString("FIRSTNAME"));
					personalDto.setEmpMname(r.getString("MIDDLENAME"));
					personalDto.setEmpLname(r.getString("LASTNAME"));
					personalDto.setFatherName(r.getString("FATHERNAME"));
					personalDto.setMotherName(r.getString("MOTHERNAME"));
					personalDto.setSpousName(r.getString("SPOUSNAME"));
					personalDto.setNationalId(r.getString("NATIONALID"));
					personalDto.setBirthDate(r.getString("BDATE"));
					personalDto.setAge(r.getString("AGE"));
					personalDto.setReligion(r.getString("RELIGION"));
					personalDto.setMaritalStatus(r.getString("MARITALSTATUS"));
					personalDto.setSex(r.getString("SEX"));
					personalDto.setWeight(r.getString("WEIGHT"));
					personalDto.setPassportNo(r.getString("PASSPORTNO"));
					personalDto.setPassportIssueDate(r.getString("PASS_ISSUE_DATE"));
					personalDto.setPassportExpireDate(r.getString("PASS_EXP_DATE"));
					personalDto.setNomineeName(r.getString("NOMINEE_NAME"));
					personalDto.setNomineeRelation(r.getString("NOMINEE_RELATION"));
					personalDto.setNomineeAddress(r.getString("NOMINEE_ADDRESS"));
					personalDto.setNomineePhone(r.getString("NOMINEE_PHONE"));
					personalDto.setContactName(r.getString("CONTACT_NAME"));					
					personalDto.setContactMobile(r.getString("CONTACT_PHONE"));
					personalDto.setHeightFeet(r.getString("HEIGHT_FEET"));
					personalDto.setHeightInches(r.getString("HEIGHT_INCHES"));
					
					personalDto.setDesiredJob1(r.getString("JOB1"));
					personalDto.setDesiredJobCat1(r.getString("JOBCAT2"));
					personalDto.setDesiredJobSubcategory1(r.getString("JOBSUBCAT2"));
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return personalDto;
	 }
	 
	 
	 
	 
	 public SelectPersonDTO getSelectPersonal(String registrationId)
	 {
		   Connection conn = ConnectionManager.getConnection();
		   String sql="SELECT sl.jobseeker_number, " +
		   		"       (sl.firstname || ' ' || sl.middlename || ' ' || sl.lastname " +
		   		"       ) fullname, sl.fathername, sl.mothername, ad.per_mobile, " +
		   		"       TO_CHAR (sl.idate, 'dd-mm-YYYY') idate, mt.ttc_name, mt.address_line1, " +
		   		"       mt.address_line2, mt.address_line3 " +
		   		"  FROM secondlottery_t1 sl, address ad, mst_ttc mt " +
		   		" WHERE sl.jobseeker_number = ad.jobseeker_number " +
		   		"   AND sl.ttc_id = mt.ttc_id " +
		   		"   AND sl.jobseeker_number = ? ";
	   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   SelectPersonDTO personalDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				if (r.next())
				{
					personalDto=new SelectPersonDTO();
					personalDto.setEmpFullName(r.getString("FULLNAME"));
					personalDto.setFatherName(r.getString("FATHERNAME"));
					personalDto.setMotherName(r.getString("MOTHERNAME"));
					personalDto.setRegId(r.getString("jobseeker_number"));
					personalDto.setMobileNo(r.getString("PER_MOBILE"));
					personalDto.setIDate(r.getString("IDATE"));
					personalDto.setTtcNmae(r.getString("TTC_NAME"));
					personalDto.setAddressLine1(r.getString("address_Line1"));
					personalDto.setAddressLine2(r.getString("address_Line2"));
					personalDto.setAddressLine3(r.getString("address_Line3"));
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return personalDto;
	 }
	 
	 
	 public byte [] getImage(String registrationId)
	 {
		 Connection conn = ConnectionManager.getConnection();
		 byte [] image= null;
		 String sql ="select IMAGE from  bio_image where JOBSEEKER_NUMBER = ? ";
		 PreparedStatement stmt = null;
		   ResultSet r = null;
		   
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				if (r.next())
				{
					image=r.getBytes("IMAGE");
				}
				
			}catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
		 
		 return image;
	 }
	 
	 
	 public PoliceDTO getPoliceData(String registrationId)
	 {
		   Connection conn = ConnectionManager.getConnection();
		   String sql="SELECT  " +
		   "	JOBSEEKER_NUMBER, NAME, GENDER,  " +
		   "   FATHERNAME, PASSPORTNO, RACE,  " +
		   "   RELIGION, BIRTHDATE, initcap(ADDRESS) ADDRESS,  " +
		   "   ADDRESS1, ADDRESS2, ADDRESS3,  " +
		   "   BIRTHPLACE, TTCNAME, TTCDATE " +
		   "	FROM DB_BMG2G.POLICE_DATA  " +
		   "	where JOBSEEKER_NUMBER = ? ";
	   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   PoliceDTO pDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				if (r.next())
				{
					pDto=new PoliceDTO();
					pDto.setRegno(r.getString("JOBSEEKER_NUMBER"));
					pDto.setName(r.getString("NAME"));
					pDto.setGender(r.getString("GENDER"));
					pDto.setFathername(r.getString("FATHERNAME"));
					pDto.setPasportno(r.getString("PASSPORTNO"));
					pDto.setRace(r.getString("RACE"));
					pDto.setReligion(r.getString("RELIGION"));
					pDto.setBirthdate(r.getString("BIRTHDATE"));
					pDto.setAddress(r.getString("ADDRESS"));
					pDto.setAddress1(r.getString("ADDRESS1"));
					pDto.setAddress2(r.getString("ADDRESS2"));
					pDto.setAddress3(r.getString("BIRTHPLACE"));
					pDto.setBirthplace(r.getString("BIRTHPLACE"));
					pDto.setTtcname(r.getString("TTCNAME"));
					pDto.setTtcdate(r.getString("TTCDATE"));					
					
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return pDto;
	 }
	 
	 
	 
	 public ArrayList<PoliceDTO> getPoliceDataAll(String registrationId)
	 {
		   Connection conn = ConnectionManager.getConnection();
		   ArrayList<PoliceDTO> plist = new ArrayList<PoliceDTO>();
		   
		   String sql="SELECT  " +
		   "	JOBSEEKER_NUMBER, NAME, GENDER,  " +
		   "   FATHERNAME, PASSPORTNO, RACE,  " +
		   "   RELIGION, BIRTHDATE, initcap(ADDRESS) ADDRESS,  " +
		   "   ADDRESS1, ADDRESS2, ADDRESS3,  " +
		   "   BIRTHPLACE, TTCNAME, TTCDATE " +
		   "	FROM DB_BMG2G.POLICE_DATA  " +
		   "	where dist_id = ? ";
	   
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   PoliceDTO pDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, registrationId);
				r = stmt.executeQuery();
				while (r.next())				
				{
					pDto=new PoliceDTO();
					pDto.setRegno(r.getString("JOBSEEKER_NUMBER"));
					pDto.setName(r.getString("NAME"));
					pDto.setGender(r.getString("GENDER"));
					pDto.setFathername(r.getString("FATHERNAME"));
					pDto.setPasportno(r.getString("PASSPORTNO"));
					pDto.setRace(r.getString("RACE"));
					pDto.setReligion(r.getString("RELIGION"));
					pDto.setBirthdate(r.getString("BIRTHDATE"));
					pDto.setAddress(r.getString("ADDRESS"));
					pDto.setAddress1(r.getString("ADDRESS1"));
					pDto.setAddress2(r.getString("ADDRESS2"));
					pDto.setAddress3(r.getString("BIRTHPLACE"));
					pDto.setBirthplace(r.getString("BIRTHPLACE"));
					pDto.setTtcname(r.getString("TTCNAME"));
					pDto.setTtcdate(r.getString("TTCDATE"));
					
					plist.add(pDto);
					
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 		return plist;
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
