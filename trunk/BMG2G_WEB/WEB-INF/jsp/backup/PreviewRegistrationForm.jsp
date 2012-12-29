<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title>G2G Job Seeker Registration Form</title>
 <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />	
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/prototype-1.6.0.2.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery-1.6.4.min.js"></script>
<!-- <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery.js"></script> --> 
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
 <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/browserDetect.js"></script>
 <script type="text/javascript" src="/BMG2G_WEB/resources/js/registration.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/address.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/regValidation.js"></script>
 
 
 <link type="text/css" rel="Stylesheet" href="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css" />
        <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
        
        <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jscalendar-1.0/calendar.js"></script>
    <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jscalendar-1.0/calendar-setup.js"></script>
    <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jscalendar-1.0/lang/calendar-en.js"></script>
    <style type="text/css"> @import url("/BMG2G_WEB/resources/js/lib/jscalendar-1.0/skins/aqua/theme.css"); </style>
    
        

 <script type="text/javascript">
  function refreshCaptcha()
  {
  var rightnow = new Date();
if (document.images)
 document.images.captchaImage.src = 'http://localhost:9090/BMG2G_WEB/CaptchaServlet.cap?' + rightnow.getTime();

  }
 </script>
  
</head>
<!-- 
http://validity.thatscaptaintoyou.com/Demos/index.htm
 -->
<body style="margin: 0px;">
<form id="myForm" method="post" action="">
<div style="width: 100%;height: 100px;border-bottom: 1px solid #006219;">
<center>
<div style="width: 1000px;height: 100px;border-right: 1px solid #006219;border-left: 1px solid #006219;">
	<div style="float: left; margin-top: 20px;width: 100px;">
	 <img src="/BMG2G_WEB/resources/images/bagladesh_logo.gif" width="60" height="60" />
	</div>
	<div style="float: left;margin-left: 30px;color: black;margin-top: 15px;text-align: left;">
	 	<div style="font-size: 27px;font-weight: bold;">Bureau of Manpower, Employment & Training (BMET)</div>
	 	<div style="font-size: 20px;margin-top: 10px;">Job Seeker's Registration Form (For Malaysia)</div>
	</div>
</div>
</center>
</div>
<center>
<br/>
<div class="boxPreview">
    <h3>Personal Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    <tr>
     <td width="15%" style="color:#7D2252;">Name</td>
     <td width="85%" colspan="3" style="padding-bottom: 15px;">
     
     <div style="float:left;width: 250px;color: #4D4D4D;">First Name<br/>
     	<s:property value="#session.sessionObj_PersonalInfo.empFname" />
     </div>
     <div style="float:left;width: 250px;color: #4D4D4D">Middle Name<br/>
     	<s:property value="#session.sessionObj_PersonalInfo.empMname" />
     </div>
     <div style="float:left;width: 250px;color: #4D4D4D">Last Name<br/>	
     	<s:property value="#session.sessionObj_PersonalInfo.empLname" />
     </div>
     
     </td>
    </tr>
    <tr>
     <td width="15%" style="color:#7D2252;">Father's Name</td>
     <td width="35%">
     	<s:property value="#session.sessionObj_PersonalInfo.fatherName" />
     </td>
     <td width="15%" style="color:#7D2252;">Mother's Name</td>
     <td width="35%">
     	<s:property value="#session.sessionObj_PersonalInfo.motherName" />
     </td>
    </tr>
    <tr>
     <td style="color:#7D2252;">Spouse Name</td>
     <td><s:property value="#session.sessionObj_PersonalInfo.spousName" /></td>
     <td style="color:#7D2252;">National ID</td>
     <td><s:property value="#session.sessionObj_PersonalInfo.nationalId" /></td>
    </tr>

     <tr>
     <td style="color:#7D2252;">Birth Date</td>
     <td>
     <s:property value="#session.sessionObj_PersonalInfo.birthDate" />
     </td>
     <td style="color:#7D2252;">Age</td>
     <td>
     	<s:property value="#session.sessionObj_PersonalInfo.age" />
     </td>
    </tr>

     <tr>
     <td style="color:#7D2252;">Marital Status</td>
     <td>
     
     <s:property value="#session.sessionObj_PersonalInfo.maritalStatus" />
     </td>
     <td  style="color:#7D2252;">Gender</td>
     <td>
      <s:property value="#session.sessionObj_PersonalInfo.sex" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Weight (kg)</td>
     <td><s:property value="#session.sessionObj_PersonalInfo.weight" /></td>
     <td style="color:#7D2252;">Height (meter)</td>
     <td><s:property value="#session.sessionObj_PersonalInfo.height" /></td>
    </tr>
  
    <tr>
     <td style="color:#7D2252;">Passport No</td>
     <td><s:property value="#session.sessionObj_PersonalInfo.passportNo" /></td>
     <td style="color:#7D2252;">Passport Issue Date</td>
     <td>
     	<s:property value="#session.sessionObj_PersonalInfo.passportIssueDate" />
     </td>
    </tr>
    <tr>
     
   
     <td style="color:#7D2252;">Passport Exp. Date</td>
     
     <td>
     <s:property value="#session.sessionObj_PersonalInfo.passportExpireDate" />
     </td>
     <td style="color:#7D2252;">Religion</td>
     <td>
     <s:property value="#session.sessionObj_PersonalInfo.religion" />
     </td>
    </tr>
   
    
    
    </table>
    
    
    </p>
</div>
<p style="height: 30px"></p>
<div class="boxPreview">
    <h3>Address</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable" style="margin-top: -10px;">
    <tr bgcolor="#E3DAD7">
     <td align="center" width="50%" colspan="2" style="text-align: center;font-weight: bold;">Permanent Address</td>
     <td align="center" width="50%" colspan="2" style="text-align: center;font-weight: bold;">Mailing Address
     </td>
    </tr>
    <tr>
     <td width="15%" style="color:#7D2252;">Division</td>
     <td width="35%">     	
     	<s:property value="#session.sessionObj_AddressInfo.pDivisionName" />
     </td>
     <td width="15%" style="color:#7D2252;">Division</td>
     <td width="35%">
     	<s:property value="#session.sessionObj_AddressInfo.mDivisionName" />
     </td>
    </tr>
    <tr>
     <td style="color:#7D2252;">District</td>
     <td valign="top" id="PERMANENT_DIST_TD">
     <s:property value="#session.sessionObj_AddressInfo.pDistrictName" />
     </td>
     <td valign="top" style="color:#7D2252;">District</td>
     <td valign="top" id="MAILING_DIST_TD">
     <s:property value="#session.sessionObj_AddressInfo.mDistrictName" />

     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Thana/Upazilla</td>
     <td valign="top" id="PERMANENT_THANA_TD">
        <s:property value="#session.sessionObj_AddressInfo.pThanaName" />
     </td>
     <td valign="top" style="color:#7D2252;">Thana/Upazilla</td>
     <td valign="top" id="MAILING_THANA_TD">
     	<s:property value="#session.sessionObj_AddressInfo.mThanaName" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Post Office</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.pPost" />
     </td>
     <td valign="top" style="color:#7D2252;">Post Office</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.mPost" />
     </td>
    </tr>
    
     <tr>
     <td style="color:#7D2252;">Post Code</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.pPostCode" />
     </td>
     <td valign="top" style="color:#7D2252;">Post Code</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.mPostCode" />     		
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Address Line 1</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.pAddressLine1" />
     </td>
     <td valign="top" style="color:#7D2252;">Address Line 1</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.mAddressLine1" />     		
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Address Line 2</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.pAddressLine2" />
     </td>
     <td valign="top" style="color:#7D2252;">Address Line 2</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.mAddressLine2" />     		
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Email(if any)</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.pEmail" />       
     </td>
     <td valign="top" style="color:#7D2252;">Email(if any)</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.mEmail" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Mobile/Phone</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.pMobile" />
     </td>
     <td valign="top" style="color:#7D2252;">Mobile/Phone</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_AddressInfo.mMobile" />
     </td>
    </tr>
    
    </table>
    
    
    </p>
</div>

<p style="height: 30px"></p>
<div class="boxPreview">
    <h3>Nominee Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoPreviewTable">
   
    <tr>
     <td width="15%" style="color:#7D2252;">Nominee Name</td>
     <td width="35%">
     	<s:property value="#session.sessionObj_NomineeInfo.nomineeName" />
     </td>
     <td width="15%"  style="color:#7D2252;">Relation</td>
     <td width="35%">
     
     <s:property value="#session.sessionObj_NomineeInfo.nomineeRelation" />
     </td>
    </tr>
    <tr>
     <td valign="top" style="color:#7D2252;">Address</td>
     <td valign="top">
    	 <%=(String) request.getSession().getAttribute("sub_NomineeAddress")%>
     </td>
     <td valign="top" style="color:#7D2252;">Mobile/Phone</td>
     <td valign="top">
     	<s:property value="#session.sessionObj_NomineeInfo.nomineePhone" />
   	  </td>
    </tr>
    </table>
    
    
    </p>
</div>


<p style="height: 30px"></p>
<div class="boxPreview">
    <h3>Educational Information(if any)</h3>
    <p>
    
    						<table align="center" border="0" cellpadding="3" cellspacing="0"
								width="100%" style="margin-top: -10px;">
								<tbody>
									<tr bgcolor="#E3DAD7">
										<td align="center" style="font-weight: bold;">
											Degree Name
										</td>
										<td align="center" style="font-weight: bold;">
											Passing Year
										</td>
										<td align="center" style="font-weight: bold;">
											Institute/School
										</td>
										<td align="center" style="font-weight: bold;">
											Board
										</td>
										<td align="center" style="font-weight: bold;">
											Subject
										</td>
										<td align="center" style="font-weight: bold;">
											Grade/Division
										</td>
									</tr>
									
									<%int e1=0;
									String eduColor="";
									 %> 		
									<s:iterator value="#session.sessionObj_EducationInfo" id="EducationDTO" > 	 
									<%if(e1%2==0)
									eduColor="#F0F0F0";
									else
									eduColor="#E5E5E5";
									e1++;
									%>
									<tr bgcolor="<%=eduColor%>">
										<td align="center" width="20%" height="24px"><s:property value="degreeName"/></td>
										<td align="center" width="10%"><s:property value="passingYear"/></td>
										<td align="center" width="30%"><s:property value="school"/></td>
										<td align="center" width="10%"><s:property value="university"/></td>
										<td align="center" width="10%"><s:property value="subject"/></td>
										<td align="center" width="10%"><s:property value="grade"/></td>
									</tr>
									</s:iterator>
								
								</tbody>
							</table>
							
							<input type="hidden" id="educationHidden" name="educationHidden" value="" />
    
    
    </p>
</div>
<p style="height: 30px"></p>
<div class="boxPreview">
    <h3>Language Skill</h3>
    <p>
    
   <table align="center" border="0" cellpadding="3" cellspacing="0"
								width="100%" class="infoPreviewTable">
								<tbody>
									
									<tr bgcolor="#E3DAD7">
										<td align="center" style="font-weight: bold;" width="40%">
											Language
										</td>
										<td align="center" style="font-weight: bold;" width="30%">
											Oral Skill
										</td>
										<td align="center" style="font-weight: bold;" width="30%">
											Writing Skill
										</td>
									</tr>
									
									
									<%int l1=0;
									String lanColor="";
									 %> 		
									 <s:iterator value="#session.sessionObj_LanguageInfo" id="LanguageDTO" > 	 
									<%if(l1%2==0)
									 lanColor="#F0F0F0";
									 else
									 lanColor="#E5E5E5";
									 l1++;
									%>
									 <tr bgcolor="<%=lanColor%>">
									   <td align="center" width="20%" height="24px"><s:property value="language"/></td>
									   <td align="center" width="10%"><s:property value="oralSkill"/></td>
									   <td align="center" width="30%"><s:property value="writingSkill"/></td>
									 </tr>
									</s:iterator>

								</tbody>
							</table>
    
    </p>
</div>

<p style="height: 30px"></p>
<div class="boxPreview">
    <h3>Experience Information(if any)</h3>
    <p>
    <table align="center" border="0" cellpadding="3" cellspacing="0"
								width="100%">
								<tbody>
									
									<tr bgcolor="#FAFCF3">
										<td colspan="4" width="100%" id="EXP" >

										</td>
									</tr>
									
									<%int exp1=0;
									String expColor1="#E5E5E5";
									String expColor2="#F0F0F0";
									 %> 		
									<s:iterator value="#session.sessionObj_ExperienceInfo" id="ExperienceDTO" > 	 
									<%if(exp1%2==0)
									expColor1="#E5E5E5";
									else
									expColor2="#F0F0F0";
									exp1++;
									%>
									<tr>
									<td colspan="4" width="100%">
									         <div width="100%" ><table width='100%' border='0' cellpadding="2px" cellspacing="2px" > 
									          <tr bgcolor="<%=expColor1%>"> 
									<td colspan='4' height='35px' width='100%'>
									&nbsp;&nbsp;<b>Work Experience</b>
									</td>
									</tr>
									<tr bgcolor="<%=expColor2%>">
									<td width='15%' height="22px" >
									<font color="#7D2252" style="font-weight: bold;">
									 &nbsp;&nbsp;Company Name
									 </font>
									 </td>
									 <td width='35%'>
									 <s:property value="companyName"/>
									</td>
									<td width='15%'>
									<font color="#7D2252" style="font-weight: bold;">
									&nbsp;&nbsp;Post Held
									</font>
									</td>
									<td width='35%'>
									<s:property value="position"/>
									</td>
									</tr>
									<tr bgcolor="<%=expColor2%>">
									<td height="22px">
									<font color="#7D2252" style="font-weight: bold;">
									&nbsp;&nbsp;Serve From
									</font>
									</td>
									<td>
									<s:property value="serveFrom"/>
									</td>
									<td>
									<font color="#7D2252" style="font-weight: bold;">
									&nbsp;&nbsp;Serve Till
									</font>
									</td>
									<td>
									<s:property value="serveTill"/>
									</td>
									</tr>
									<tr bgcolor="<%=expColor2%>">
									<td height="22px">
									<font color="#7D2252" style="font-weight: bold;">
									&nbsp;&nbsp;Address
									</font>
									</td>
									<td>
									<s:property value="address"  />
									 </td>
									<td>
									<font color="#7D2252" style="font-weight: bold;">
									 
									 </font>
									 </td>
									 <td>
									
									</td>
									</tr>
									
									</table>
									          
									</div>
									</td>
									</tr>
									</s:iterator>

								</tbody>
							</table>
							<input type="hidden" id="experienceHidden" name="experienceHidden"  />
    
    </p>
</div>
<p style="height: 30px"></p>

<div class="boxPreview">
    <h3>Training Information(if any)</h3>
    <p>
    <table align="center" border="0" cellpadding="3" cellspacing="0"
								width="100%" class="infoPreviewTable">
								<tbody>
									
									<tr bgcolor="#E3DAD7">
										<td align="center" width="20%"  style="font-weight: bold;">
											Training Name
										</td>
										<td align="center"  width="15%"  style="font-weight: bold;">
											Institute/Training<br/>
											Center Name
										</td>
										<td align="center"  width="15%"  style="font-weight: bold;">
											Duration
										</td>
									    <td align="center"  width="40%"  style="font-weight: bold;">
											Description
										</td>
										
									</tr>
									
									<%int tr1=0;
									String trainColor="";
									 %> 		
									<s:iterator value="#session.sessionObj_TrainingInfo" id="TrainingDTO" > 	 
									<%if(tr1%2==0)
									trainColor="#F0F0F0";
									else
									trainColor="#E5E5E5";
									tr1++;
									%>
									<tr bgcolor="<%=trainColor%>">
									<td align="center" width="20%" height="24px"><s:property value="trainingName"/></td>
									<td align="center" width="10%"><s:property value="fromWhere"/></td>
									<td align="center" width="30%"><s:property value="duration"/></td>
									<td align="center" width="30%"><s:property value="description"/></td>
									</tr>
									</s:iterator>

								</tbody>
							</table>
    
    </p>
</div>

<p style="height: 10px"></p>
<div style="margin-top: 10px;">
<input type="button" class="submitButton" name="Edit Application" value="Go Back" onclick='window.location="editRegFormAction.action"'/>
<input type="button" class="submitButton" name="Submit Application" value="Submit Application" style="margin-left: 100px;" onclick='window.location="submitRegistration.action"'/>
</div>
<p style="height: 30px"></p>
</center>

</form>
</body>

</html>