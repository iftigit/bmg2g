<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title>G2G Job Seeker Registration Form</title>
 <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />	
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery-1.6.4.min.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/numeric.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/browserDetect.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/address.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/regValidation.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery.corner.js"></script>
  <link type="text/css" rel="Stylesheet" href="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css" />
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
        
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jscalendar-1.0/calendar.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jscalendar-1.0/calendar-setup.js"></script>
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jscalendar-1.0/lang/calendar-en.js"></script>
  <style type="text/css"> @import url("/BMG2G_WEB/resources/js/lib/jscalendar-1.0/skins/aqua/theme.css"); </style>
    
        

 <script type="text/javascript">
 
  
  function  valme()
  {
  			//	    $.validity.start();
				//	$("#11c")
        			//.assert(0,"The inputs can either have all even numbers or all odd numbers. Not mixed.");						
					//$.validity.end();
  }
  
   $(function() { 

                $("form").validity(function() {
                    $("#FIRST_NAME")                      // The first input:    
        			.require("First Name is required.");                         // Required:
        			
        			$("#LAST_NAME")                      // The first input:    
        			.require("Last Name is required.");                         // Required:
        			
        			$("#FATHER_NAME")                      // The first input:    
        			.require("Father's Name is required.");                         // Required:

        			$("#MOTHER_NAME")                      // The first input:    
        			.require("Mother's Name is required.");                         // Required:
        			
        			$("#BIRTH_DATE")                      // The first input:    
        			.require("Birth Date is required.");                         // Required:
        			
        			$("#WEIGHT")                      // The first input:    
        			.require("Weight is required.");                         // Required:
        			
        			$("#HEIGHT_FEET")                      // The first input:    
        			.require("Height Cannot be 0 feet.");                         // Required:
        			
        			
        			$("#PERMANENT_POST").require("Post Office is required.");
        			$("#MAILING_POST").require("Post Office is required.");
        			$("#PERMANENT_POST_CODE").require("Post Code is required.");
        			$("#MAILING_POST_CODE").require("Post Code is required.");
        			$("#PERMANENT_MOBILE").require("Mobile Number required.");
        			$("#MAILING_MOBILE").require("Mobile Number required.");
        			
        			
					$("#PERMANENT_DIV").equalCheck("select","Select Permanent Division.");
					$("#PERMANENT_DIV").equalCheck("","Select Permanent Division.");
					$("#MAILING_DIV").equalCheck("select","Select Mailing Division.");
					$("#MAILING_DIV").equalCheck("","Select Mailing Division.");

					$("#PERMANENT_DIST").equalCheck("select","Select Permanent District.");
					$("#PERMANENT_DIST").equalCheck("","Select Permanent District.");
					$("#MAILING_DIST").equalCheck("select","Select Mailing District.");
					$("#MAILING_DIST").equalCheck("","Select Mailing District.");


					$("#PERMANENT_THANA").equalCheck("select","Select Permanent Thana.");
					$("#PERMANENT_THANA").equalCheck("","Select Permanent Thana.");
					$("#MAILING_THANA").equalCheck("select","Select Mailing Thana.");
					$("#MAILING_THANA").equalCheck("","Select Mailing Thana.");
        			
        			$("#NOMINEE_NAME")                      // The first input:    
        			.require("Nominee Name is required.");                         // Required:
        			
        			$("#NOMINEE_RELATION")                      // The first input:    
        			.equalCheck("none","Nominee Relation is required.");
        			
        			$("#NOMINEE_ADDRESS")                      // The first input:    
        			.require("Nominee address is required.");                         // Required:
        			
        			$("#NOMINEE_PHONE")                      // The first input:    
        			.require("Nominee Phone Number required.");                         // Required:
        			
        			
					$("#educationMsg").assert(function(val){return checkEducationalInformation();},"One or More Education Information is blank.");
					$("#languageMsg").assert(function(val){return checkLanguageInformation();},"One or More Language Information is blank.");
					$("#experienceMsg").assert(function(val){return checkExperienceInformation();},"One or More Experience Information is blank.");					
					$("#trainingMsg").assert(function(val){return checkTrainingInformation();},"One or More Training Information is blank.");
					$("#captchaText").require("Please provide security code.");    
					


        			/*
        			$("#11c")
        			.assert(0,"The inputs can either have all even numbers or all odd numbers. Not mixed.");
        			*/
        			
                });
                
            Calendar.setup({
              inputField    : "BIRTH_DATE",
              button        : "BIRTH_DATE_BTN",
              align         : "Tr",
              ifFormat    : '%d-%m-%Y'    // the date format
            });
               
            Calendar.setup({
              inputField    : "PASSPORT_ISSUE_DATE",
              button        : "PASSPORT_ISSUE_DATE_BTN",
              align         : "Tr",
              ifFormat    : '%d-%m-%Y'    // the date format
            });
            
               
            Calendar.setup({
              inputField    : "PASSPORT_EXP_DATE",
              button        : "PASSPORT_EXP_DATE_BTN",
              align         : "Tr",
              ifFormat    : '%d-%m-%Y'    // the date format
            });
            
            
            });

 </script>
  
</head>
<!-- 
http://validity.thatscaptaintoyou.com/Demos/index.htm
 -->
<body style="margin: 0px;">
<form id="empRegForm" name="empRegForm" method="post" action="submitRegistration.action">
<div style="width: 100%;height: 100px;border-bottom: 1px solid #006219;">
<center>
<div style="width: 1000px;height: 100px;border-right: 1px solid #006219;border-left: 1px solid #006219;">
	<div style="float: left; margin-top: 20px;width: 100px;">
	 <img src="/BMG2G_WEB/resources/images/bagladesh_logo.gif" width="60" height="60" />
	</div>
	<div style="float: left;margin-left: 30px;color: black;margin-top: 15px;text-align: left;">
	 	<div style="font-size: 27px;font-weight: bold;">Bureau of Manpower, Employment & Training(BMET)</div>
	 	<div style="font-size: 20px;margin-top: 10px;">Job Seeker's Registration Form (For Malaysia)</div>
	</div>
</div>
</center>
</div>
<center>
<br/>
<div class="box">
    <h3>Personal Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    <tr>
     <td width="15%">Name<font color="red">*</font></td>
     <td width="85%" colspan="3" style="padding-bottom: 15px;">
     
     <div style="float:left;width: 250px;color: #4D4D4D;">First Name<br/>
     	<input type="text" tabindex="1" name="personalDTO.empFname" id="FIRST_NAME" maxlength="20"  value="<s:property value="#session.sessionObj_PersonalInfo.empFname" />" class="nameTextBox" />
     </div>
     <div style="float:left;width: 250px;color: #4D4D4D">Middle Name<br/>
     	<input type="text" tabindex="2" name="personalDTO.empMname" id="MIDDLE_NAME"  maxlength="20" value="<s:property value="#session.sessionObj_PersonalInfo.empMname" />"  class="nameTextBox" />
     </div>
     <div style="float:left;width: 250px;color: #4D4D4D">Last Name<br/>	
     	<input 	type="text" tabindex="3" name="personalDTO.empLname" id="LAST_NAME" maxlength="20" value="<s:property value="#session.sessionObj_PersonalInfo.empLname" />"  class="nameTextBox" />
     </div>
     
     </td>
    </tr>
    <tr>
     <td width="15%">Father's Name<font color="red">*</font></td>
     <td width="35%">
     	<input type="text" tabindex="4" name="personalDTO.fatherName" id="FATHER_NAME" maxlength="40"  value="<s:property value="#session.sessionObj_PersonalInfo.fatherName" />"  class="textBox"/>
     </td>
     <td width="15%">Mother's Name<font color="red">*</font></td>
     <td width="35%">
     	<input type="text" tabindex="5" name="personalDTO.motherName" id="MOTHER_NAME" maxlength="40" value="<s:property value="#session.sessionObj_PersonalInfo.motherName" />" class="textBox"/>
     </td>
    </tr>
    <tr>
     <td>Spouse Name</td>
     <td><input type="text" tabindex="6" name="personalDTO.spousName" id="SPOUSE_NAME" maxlength="40" value="<s:property value="#session.sessionObj_PersonalInfo.spousName" />" class="textBox"/></td>
     <td>National ID (If any)</td>
     <td><input type="text" tabindex="7" name="personalDTO.nationalId" id="NATIONALID" maxlength="13" value="<s:property value="#session.sessionObj_PersonalInfo.nationalId" />" onkeypress="return numericOnly(event)" class="textBox"/></td>
    </tr>

 	<tr>
     <td>Birth Date<font color="red">*</font></td>
     <td>
     <input type="text"  class="textBox" id="BIRTH_DATE"  value="11-11-2012"  name="personalDTO.birthDate" readonly="readonly" onchange="calculateAge('AGE','BIRTH_DATE')"/>
     <img src="/BMG2G_WEB/resources/images/calendar.png" id="BIRTH_DATE_BTN" border="0" />
          
    
     </td>
     <td>Age</td>
     <td>
     	<input type="text" class="textBox" id="AGE" name="personalDTO.age" value="22" readonly="readonly" />
     </td>
    </tr>

     <tr>
     <td>Marital Status</td>
     <td>
     <input type="radio" name="personalDTO.maritalStatus" value="Male" /> Married
     	<input type="radio" name="personalDTO.maritalStatus" value="Female" checked="checked"  /> Unmarried
     </td>
     <td>Gender</td>
     <td>
     	<input type="radio" id="SEX" name="personalDTO.sex" value="Male" checked="checked" /> Male
     	<input type="radio" id="SEX" name="personalDTO.sex" value="Female"  /> Female
     </td>
    </tr>
    
    <tr>
     <td>Weight (kg)<font color="red">*</font></td>
     <td><input type="text" tabindex="19" name="personalDTO.weight" id="WEIGHT" maxlength="4"  onkeypress="return numericWithDot(event)" value="70"/></td>
     <td>Height<font color="red">*</font></td>
     <td>
     <input type="text" tabindex="20" name="personalDTO.heightFeet" id="HEIGHT_FEET" maxlength="4" onkeypress="return numericOnly(event)" value="5" class="textBox" style="width: 50px;text-align: center;"/>
      Feet&nbsp;&nbsp;&nbsp;
     <input type="text" tabindex="20" name="personalDTO.heightInches" id="HEIGHT_INCHES" maxlength="4" onkeypress="return numericOnly(event)" value="4" class="textBox" style="width: 50px;text-align: center;"/>
      Inches
     </td>
    </tr>
  
    <tr>
     <td>MRP Passport No (If any)</td>
     <td><input type="text" tabindex="23" name="personalDTO.passportNo" id="PASSPORT_DATE" size="20" maxlength="50" value="<s:property value="#session.sessionObj_PersonalInfo.passportNo" />" class="textBox"/></td>
     <td>Passport Issue Date</td>
     <td>
     <input type="text"  class="textBox" id="PASSPORT_ISSUE_DATE" name="personalDTO.passportIssueDate" value="<s:property value="#session.sessionObj_PersonalInfo.passportIssueDate" />"/>
     <img src="/BMG2G_WEB/resources/images/calendar.png" id="PASSPORT_ISSUE_DATE_BTN" border="0" />

     </td>
    </tr>
    <tr>
     
   
     <td>Passport Exp. Date</td>
     <td>
     <input type="text"  class="textBox" id="PASSPORT_EXP_DATE" name="personalDTO.passportExpireDate" value="<s:property value="#session.sessionObj_PersonalInfo.passportExpireDate" />"/>
     <img src="/BMG2G_WEB/resources/images/calendar.png" id="PASSPORT_EXP_DATE_BTN" border="0" />
     </td>
     <td>Religion</td>
     <td>
     	<select tabindex="18" name="personalDTO.religion" id="RELIGION" class="addressSelectBox">
												<option value="Islam" selected="selected">Islam</option>
												<option value="Hinduism">Hinduism</option>
												<option value="Christianity">Christianity</option>
												<option value="Buddhism">Buddhism</option>
												<option value="Other">Other</option>
	</select>
     </td>
    </tr>
   
    
    
    </table>
    
    
    </p>
</div>
<p style="height: 30px"></p>
<div class="box">
    <h3>Address</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    <tr bgcolor="#F2F7E3">
     <td align="center" width="50%" colspan="2" style="text-align: center;font-weight: bold;">Permanent Address</td>
     <td align="center" width="50%" colspan="2" style="text-align: center;font-weight: bold;">Mailing Address
     [<input type="checkbox" tabindex="42" name="addressDTO.sameAsPermanenet" id="mp" onclick="copyPermanentAddress(this.checked)"  /> As Permanent Address]</td>
    </tr>
    <tr>
     <td width="15%">Division<font color="red">*</font></td>
     <td width="35%">
     	
     <select tabindex="30" name="addressDTO.pDivision" id="PERMANENT_DIV" class="addressSelectBox" onchange="fetchJSONData_Dist(this.value,'PERMANENT_DIST')">
     	  <option value="select" selected="selected">--Select Division--</option>	
     	<s:iterator value="%{#application.ALL_DIVISION}" id="divisionList">
     	  <option value="<s:property value="division_id" />"><s:property value="division_name" /></option>
     	</s:iterator>
     </select>
     </td>
     <td width="15%">Division<font color="red">*</font></td>
     <td width="35%">
     <select tabindex="44"  name="addressDTO.mDivision" id="MAILING_DIV" class="addressSelectBox" onchange="fetchJSONData_Dist(this.value,'MAILING_DIST')">
        <option value="select" selected="selected">--Select Division--</option>
     	<s:iterator value="%{#application.ALL_DIVISION}" id="divisionList">
     	  <option value="<s:property value="division_id" />"><s:property value="division_name" /></option>
     	</s:iterator>
     </select>
     </td>
    </tr>
    <tr>
     <td>District<font color="red">*</font></td>
     <td valign="top" id="PERMANENT_DIST_TD">
     <select tabindex="31" name="addressDTO.pDistrict" id="PERMANENT_DIST" class="addressSelectBox" onchange="fetchJSONData_Thana(this.value,'PERMANENT_THANA')">
     </select>
     </td>
     <td valign="top">District<font color="red">*</font></td>
     <td valign="top" id="MAILING_DIST_TD">
     <select tabindex="45" name="addressDTO.mDistrict" id="MAILING_DIST" class="addressSelectBox" onchange="fetchJSONData_Thana(this.value,'MAILING_THANA')">
     </select>

     </td>
    </tr>
    
    <tr>
     <td>Thana/Upazilla<font color="red">*</font></td>
     <td valign="top" id="PERMANENT_THANA_TD">
        <select tabindex="32" name="addressDTO.pThana" id="PERMANENT_THANA" class="addressSelectBox">
       </select>
     </td>
     <td valign="top">Thana/Upazilla<font color="red">*</font></td>
     <td valign="top" id="MAILING_THANA_TD">
     	<select tabindex="46" name="addressDTO.mThana" id="MAILING_THANA" class="addressSelectBox">
        </select>
     </td>
    </tr>
    
    <tr>
     <td>Post Office<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.pPost" maxlength="30" id="PERMANENT_POST"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.pPost"/>" />
     </td>
     <td valign="top">Post Office<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="52" name="addressDTO.mPost" maxlength="30" id="MAILING_POST" class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.mPost"/>"  />
     </td>
    </tr>
    
     <tr>
     <td>Post Code<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.pPostCode" maxlength="30" id="PERMANENT_POST_CODE"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.pPostCode"/>" />
     </td>
     <td valign="top">Post Code<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.mPostCode" maxlength="30" id="MAILING_POST_CODE"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.mPostCode"/>" />     		
     </td>
    </tr>
    
     <tr>
     <td>Address<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.pAddressLine1" maxlength="30" id="PERMANENT_ADDRESS_LINE1"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.pAddressLine1"/>" />
     </td>
     <td valign="top">Address<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.mAddressLine1" maxlength="30" id="MAILING_ADDRESS_LINE1"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.mAddressLine1"/>" />     		
     </td>
    </tr>
    
     <tr>
     <td></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.pAddressLine2" maxlength="30" id="PERMANENT_ADDRESS_LINE2"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.pAddressLine2"/>" />
     </td>
     <td valign="top"></td>
     <td valign="top">
     	<input type="text" tabindex="38" name="addressDTO.mAddressLine2" maxlength="30" id="MAILING_ADDRESS_LINE2"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.mAddressLine2"/>" />     		
     </td>
    </tr>

    <tr>
     <td>Email (If any)</td>
     <td valign="top">
     	<input type="text" tabindex="39" name="addressDTO.pEmail" maxlength="50" id="PERMANENT_EMAIL"  class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.pEmail"/>" />       
     </td>
     <td valign="top">Email (If any)</td>
     <td valign="top">
     	<input type="text" tabindex="53" name="addressDTO.mEmail" maxlength="50" id="MAILING_EMAIL" class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.mEmail"/>"  />
     </td>
    </tr>
    
    <tr>
     <td>Mobile/Phone<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="41" name="addressDTO.pMobile" maxlength="25" id="PERMANENT_MOBILE" class="textBox" value="<s:property value="#session.sessionObj_AddressInfo.pMobile"/>" onkeypress="return numericOnly(event)" />
     </td>
     <td valign="top">Mobile/Phone<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="55" maxlength="25" name="addressDTO.mMobile" id="MAILING_MOBILE" class="textBox"  value="<s:property value="#session.sessionObj_AddressInfo.mMobile"/>" onkeypress="return numericOnly(event)"  />
     </td>
    </tr>
    </table>
    
    
    </p>
</div>

<p style="height: 30px"></p>
<div class="box">
    <h3>Nominee Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
   
    <tr>
     <td width="15%">Nominee Name<font color="red">*</font></td>
     <td width="35%">
     <input type="text" tabindex="56" name="nomineeDTO.nomineeName" id="NOMINEE_NAME" maxlength="100" class="textBox" value="<s:property value="#session.sessionObj_NomineeInfo.nomineeName" />" />
     </td>
     <td width="15%">Relation<font color="red">*</font></td>
     <td width="35%">
     <!-- 
     <input type="text" class="textBox"/>
      -->
     <select tabindex="57" name="nomineeDTO.nomineeRelation" id="NOMINEE_RELATION"  class="addressSelectBox">
     <option value="none">--Select Relation--</option>
      <option value="Wife">Wife</option>
      <option value="Mother">Mother</option>
      <option value="Father">Father</option>
      <option value="Uncle">Uncle</option>
      <option value="Son/Daughter">Son/Daughter</option>
      <option value="Cousin">Cousin</option>
      <option value="Neighbour">Neighbour</option>
      <option value="Friend">Friend</option>
     </select>
     
     </td>
    </tr>
    <tr>
     <td valign="top">Address<font color="red">*</font></td>
     <td valign="top">
     <textarea tabindex="59" name="nomineeDTO.nomineeAddress" id="NOMINEE_ADDRESS" rows="5" cols="29" style="border: 1px solid grey;"
												onkeypress="textCounter(this,150);"><s:property value="#session.sessionObj_NomineeInfo.nomineeAddress" /></textarea>
												
     </td>
     <td valign="top">Mobile/Phone<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="58" name="nomineeDTO.nomineePhone" id="NOMINEE_PHONE" maxlength="25" class="textBox" value="<s:property value="#session.sessionObj_NomineeInfo.nomineePhone" />" onkeypress="return numericOnly(event)" />
   	  </td>
    </tr>
    
    <tr>
     <td valign="top">Contact Person Name<font color="red">*</font><br/>(in case of emergency)</td>
     <td valign="top">
		<input type="text" tabindex="58" name="nomineeDTO.contactName" id="CONTACT_NAME" maxlength="25" class="textBox"  onkeypress="return numericOnly(event)" />												
     </td>
     <td valign="top">Contact Person Mobile<font color="red">*</font></td>
     <td valign="top">
     	<input type="text" tabindex="58" name="nomineeDTO.contactMobile" id="CONTACT_MOBILE" maxlength="25" class="textBox"  onkeypress="return numericOnly(event)" />
   	  </td>
    </tr>    
    
    
    </table>
    
    
    </p>
</div>


<p style="height: 30px"></p>
<div class="box">
    <h3>Security Code</h3>
    <p>

  <div>
  <img src="http://localhost:8080/BMG2G_WEB/CaptchaServlet.cap" alt="no image" id="captchaImage" name="captchaImage" /> 
  <br/>
  <input type="button" value="Refresh"  onclick="refreshCaptcha()" />
  </div>  
  <br/>
  <div>
  <input type="text" class="captchCode" id="captchaText" name="personalDTO.captchaText"/>
  <br/>
  <font style="color:red"><s:label name="Err_captchaError"></s:label></font>
  </div>
    
    </p>
</div>

<div style="margin-top: 20px;">
<input type="submit" class="submitButton" name="Submit Application" value="Submit Application" />

</div>
<p style="height: 30px"></p>

 
</center>
<%String form_error=(String) request.getSession().getAttribute("form_error");
 if(form_error==null)form_error="first_time";
 if(form_error.equalsIgnoreCase("form_error")){
  %>
   <%@ include file="SetFormContent.jsp" %>
 <%} %>
 
<script type="text/javascript">
$('input').attr('autocomplete','off');   
</script>

</form>
</body>

