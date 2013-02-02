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
 document.images.captchaImage.src = 'BMG2G_WEB/CaptchaServlet.cap?' + rightnow.getTime();

  }
  function submitForm(actionName)
  {
   document.myForm.action=actionName;
   document.myForm.submit();
  }
 </script>
  
</head>
<!-- 
http://validity.thatscaptaintoyou.com/Demos/index.htm
 -->

<body style="margin: 0px;">
<form id="myForm" name=myForm method="post" action="">
<!-- 
<s:token name="token"></s:token>
 -->
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

<div style="color: red"><s:label name="Err_RegSubmit" ></s:label></div>
<br/>
<div class="boxPreview">
    <h3>Personal Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    <tr>
     <td width="15%" style="color:#7D2252;">Name</td>
     <td width="85%" colspan="3" style="padding-bottom: 15px;">
     
     <div style="float:left;width: 250px;color: #4D4D4D;">First Name<br/>
     	<font color='black'/><s:property value="personalDTO.empFname" /></font>
     	<input type="hidden" name="personalDTO.empFname" value="<s:property value="personalDTO.empFname" />" />
     </div>
     <div style="float:left;width: 250px;color: #4D4D4D">Middle Name<br/>
     	<font color='black'/><s:property value="personalDTO.empMname" /></font>
     	<input type="hidden" name="personalDTO.empMname" value="<s:property value="personalDTO.empMname" />" />
     </div>
     <div style="float:left;width: 250px;color: #4D4D4D">Last Name<br/>	
     	<font color='black'/><s:property value="personalDTO.empLname" /></font>
     	<input type="hidden" name="personalDTO.empLname" value="<s:property value="personalDTO.empLname" />" />
     </div>
     
     </td>
    </tr>
    <tr>
     <td width="15%" style="color:#7D2252;">Father's Name</td>
     <td width="35%">
     	<s:property value="personalDTO.fatherName" />
     	<input type="hidden" name="personalDTO.fatherName" value="<s:property value="personalDTO.fatherName" />" />
     </td>
     <td width="15%" style="color:#7D2252;">Mother's Name</td>
     <td width="35%">
     	<s:property value="personalDTO.motherName" />
     	<input type="hidden" name="personalDTO.motherName" value="<s:property value="personalDTO.motherName" />" />
     </td>
    </tr>
    <tr>
     <td style="color:#7D2252;">Spouse Name</td>
     <td><s:property value="personalDTO.spousName" />
     	<input type="hidden" name="personalDTO.spousName" value="<s:property value="personalDTO.spousName" />" />
     </td>
     <td style="color:#7D2252;">National ID</td>
     <td><s:property value="personalDTO.nationalId" />
     	<input type="hidden" name="personalDTO.nationalId" value="<s:property value="personalDTO.nationalId" />" />
     </td>
    </tr>

     <tr>
     <td style="color:#7D2252;">Birth Date</td>
     <td>
     <s:property value="personalDTO.birthDate" />
     <input type="hidden" name="personalDTO.birthDate" value="<s:property value="personalDTO.birthDate" />" />
     </td>
     <td style="color:#7D2252;">Age</td>
     <td>
     	<s:property value="personalDTO.age" />
     	<input type="hidden" name="personalDTO.age" value="<s:property value="personalDTO.age" />" />
     </td>
    </tr>

     <tr>
     <td style="color:#7D2252;">Marital Status</td>
     <td>
     
     <s:property value="personalDTO.maritalStatus" />
     <input type="hidden"  name="personalDTO.maritalStatus" value="<s:property value="personalDTO.maritalStatus" />" />
     </td>
     <td  style="color:#7D2252;">Gender</td>
     <td>
      <s:property value="personalDTO.sex" />
      <input type="hidden" name="personalDTO.sex" value="<s:property value="personalDTO.sex" />" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Weight (kg)</td>
     <td><s:property value="personalDTO.weight" />
     <input type="hidden" name="personalDTO.weight" value="<s:property value="personalDTO.weight" />" />
     </td>
     <td style="color:#7D2252;">Height</td>
     <td>
     <s:property value="personalDTO.heightFeet" />&nbsp;&nbsp;Feet&nbsp;&nbsp;&nbsp;
     <s:property value="personalDTO.heightInches" />&nbsp;&nbsp;Inches
     
     <input type="hidden" name="personalDTO.heightFeet"   value="<s:property value="personalDTO.heightFeet" />" />
     <input type="hidden" name="personalDTO.heightInches" value="<s:property value="personalDTO.heightInches" />" />
     </td>
    </tr>
  
    <tr>
     <td style="color:#7D2252;">Passport No</td>
     <td><s:property value="personalDTO.passportNo" />
     <input type="hidden" name="personalDTO.passportNo" value="<s:property value="personalDTO.passportNo" />" />
     </td>
     <td style="color:#7D2252;">Passport Issue Date</td>
     <td>
     	<s:property value="personalDTO.passportIssueDate" />
     	<input type="hidden" name="personalDTO.passportIssueDate" value="<s:property value="personalDTO.passportIssueDate" />" />
     </td>
    </tr>
    <tr>
     
   
     <td style="color:#7D2252;">Passport Exp. Date</td>
     
     <td>
     <s:property value="personalDTO.passportExpireDate" />
     <input type="hidden" name="personalDTO.passportExpireDate" value="<s:property value="personalDTO.passportExpireDate" />" />
     </td>
     <td style="color:#7D2252;">Religion</td>
     <td>
     <s:property value="personalDTO.religion" />
     <input type="hidden" name="personalDTO.religion" value="<s:property value="personalDTO.religion" />" />
     </td>
    </tr>
   
     <tr>
     <td colspan="4" align="left" style="background-color: #CCCCCC">
       Desired Job
     </td>
     </tr>
     <tr>
     
   
     <td style="color:#7D2252;">Option 1</td>     
     <td>
	     Plantation
	     <input type="hidden" name="personalDTO.desiredJob1" value="Plantation" />
     </td>
     <td style="color:#7D2252;"></td>
     <td>
     
     </td>
    </tr>
	
    <tr>
     <td style="color:#7D2252;">Option 2</td>     
     <td>
     <s:property value="personalDTO.desiredJobCat1" />
     <input type="hidden" name="personalDTO.desiredJobCat1" value="<s:property value="personalDTO.desiredJobCat1" />" />
     </td>
     <td style="color:#7D2252;"></td>
     <td>
     <s:property value="personalDTO.desiredJobSubcategory1" />
     <input type="hidden" name="personalDTO.desiredJobSubcategory1" value="<s:property value="personalDTO.desiredJobSubcategory1" />" />
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
     	<s:property value="addressDTO.pDivisionName" />     	
     	<input type="hidden" name="addressDTO.pDivision" value="<s:property value="addressDTO.pDivision" />" />
     	<input type="hidden" name="addressDTO.pDivisionName" value="<s:property value="addressDTO.pDivisionName" />" />
     	
     </td>
     <td width="15%" style="color:#7D2252;">Division</td>
     <td width="35%">
     	<s:property value="addressDTO.mDivisionName" />
     	<input type="hidden" name="addressDTO.mDivision" value="<s:property value="addressDTO.mDivision" />" />
     	<input type="hidden" name="addressDTO.mDivisionName" value="<s:property value="addressDTO.mDivisionName" />" />
     </td>
    </tr>
    <tr>
     <td style="color:#7D2252;">District</td>
     <td valign="top">
     <s:property value="addressDTO.pDistrictName" />
     <input type="hidden" name="addressDTO.pDistrict" value="<s:property value="addressDTO.pDistrict" />" />
     <input type="hidden" name="addressDTO.pDistrictName" value="<s:property value="addressDTO.pDistrictName" />" />
     </td>
     <td valign="top" style="color:#7D2252;">District</td>
     <td valign="top">
     <s:property value="addressDTO.mDistrictName" />
     <input type="hidden" name="addressDTO.mDistrict" value="<s:property value="addressDTO.mDistrict" />" />
     <input type="hidden" name="addressDTO.mDistrictName" value="<s:property value="addressDTO.mDistrictName" />" />

     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Upazilla/Pouroshova</td>
     <td valign="top">
        <s:property value="addressDTO.pThanaName" />
        <input type="hidden" name="addressDTO.pThana" value="<s:property value="addressDTO.pThana" />" />
        <input type="hidden" name="addressDTO.pThanaName" value="<s:property value="addressDTO.pThanaName" />" />
     </td>
     <td valign="top" style="color:#7D2252;">Upazilla/Pouroshova</td>
     <td valign="top">
     	<s:property value="addressDTO.mThanaName" />
     	<input type="hidden" name="addressDTO.mThana" value="<s:property value="addressDTO.mThana" />" />
     	<input type="hidden" name="addressDTO.mThanaName" value="<s:property value="addressDTO.mThanaName" />" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Union/Ward</td>
     <td valign="top">
        <s:property value="addressDTO.pUnionName" />
        <input type="hidden" name="addressDTO.pUnion" value="<s:property value="addressDTO.pUnion" />" />
        <input type="hidden" name="addressDTO.pUnionName" value="<s:property value="addressDTO.pUnionName" />" />
     </td>
     <td valign="top" style="color:#7D2252;">Union/Ward</td>
     <td valign="top">
     	<s:property value="addressDTO.mUnionName" />
     	<input type="hidden" name="addressDTO.mUnion" value="<s:property value="addressDTO.mUnion" />" />
     	<input type="hidden" name="addressDTO.mUnionName" value="<s:property value="addressDTO.mUnionName" />" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Post Office</td>
     <td valign="top">
     	<s:property value="addressDTO.pPost" />
     	<input type="hidden" name="addressDTO.pPost" value="<s:property value="addressDTO.pPost" />" />

     </td>
     <td valign="top" style="color:#7D2252;">Post Office</td>
     <td valign="top">
     	<s:property value="addressDTO.mPost" />
     	<input type="hidden" name="addressDTO.mPost" value="<s:property value="addressDTO.mPost" />" />
     </td>
    </tr>
    
     <tr>
     <td style="color:#7D2252;">Post Code</td>
     <td valign="top">
     	<s:property value="addressDTO.pPostCode" />
     	<input type="hidden" name="addressDTO.pPostCode" value="<s:property value="addressDTO.pPostCode" />" />
     </td>
     <td valign="top" style="color:#7D2252;">Post Code</td>
     <td valign="top">
     	<s:property value="addressDTO.mPostCode" />     
     	<input type="hidden" name="addressDTO.mPostCode" value="<s:property value="addressDTO.mPostCode" />" />		
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Village/Street</td>
     <td valign="top">
     	<s:property value="addressDTO.pAddressLine1" />
     	<input type="hidden" name="addressDTO.pAddressLine1" value="<s:property value="addressDTO.pAddressLine1" />" />
     </td>
     
     <td valign="top" style="color:#7D2252;">Village/Street</td>
     <td valign="top">
     	<s:property value="addressDTO.mAddressLine1" />     
     	<input type="hidden" name="addressDTO.mAddressLine1" value="<s:property value="addressDTO.mAddressLine1" />" />		
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">House No.</td>
     <td valign="top">
     	<s:property value="addressDTO.pAddressLine2" />
     	<input type="hidden" name="addressDTO.pAddressLine2" value="<s:property value="addressDTO.pAddressLine2" />" />
     </td>
     <td valign="top" style="color:#7D2252;">House No.</td>
     <td valign="top">
     	<s:property value="addressDTO.mAddressLine2" />     
     	<input type="hidden" name="addressDTO.mAddressLine2" value="<s:property value="addressDTO.mAddressLine2" />" />		
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Email</td>
     <td valign="top">
     	<s:property value="addressDTO.pEmail" />  
     	<input type="hidden" name="addressDTO.pEmail" value="<s:property value="addressDTO.pEmail" />" />     
     </td>
     <td valign="top" style="color:#7D2252;">Email</td>
     <td valign="top">
     	<s:property value="addressDTO.mEmail" />
     	<input type="hidden" name="addressDTO.mEmail" value="<s:property value="addressDTO.mEmail" />" />
     </td>
    </tr>
    
    <tr>
     <td style="color:#7D2252;">Mobile/Phone</td>
     <td valign="top">
     	<s:property value="addressDTO.pMobile" />
     	<input type="hidden" name="addressDTO.pMobile" value="<s:property value="addressDTO.pMobile" />" />
     </td>
     <td valign="top" style="color:#7D2252;">
     <!-- Mobile/Phone -->
     </td>
     <td valign="top">
     <!-- <s:property value="addressDTO.mMobile" />
     	<input type="hidden" name="addressDTO.mMobile" value="<s:property value="addressDTO.mMobile" />" />
     	 -->	
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
     	<s:property value="nomineeDTO.nomineeName" />
     	<input type="hidden" name="nomineeDTO.nomineeName" value="<s:property value="nomineeDTO.nomineeName" />" />
     	
     	
     </td>
     <td width="15%"  style="color:#7D2252;">Relation</td>
     <td width="35%">
     
     <s:property value="nomineeDTO.nomineeRelation" />
     <input type="hidden" name="nomineeDTO.nomineeRelation" value="<s:property value="nomineeDTO.nomineeRelation" />" />
     </td>
    </tr>
    <tr>
     <td valign="top" style="color:#7D2252;">Address</td>
     <td valign="top">
    	 <%=(String) request.getAttribute("sub_NomineeAddress")%>
    	 

    	 <input type="hidden" value="nomineeDTO.nomineeAddress" value="<s:property value="nomineeDTO.nomineeAddress" />" />
     </td>
     <td valign="top" style="color:#7D2252;">Mobile/Phone</td>
     <td valign="top">
        <s:property value="nomineeDTO.nomineePhone" />
     	<input type="hidden" value="nomineeDTO.nomineePhone" value="<s:property value="nomineeDTO.nomineePhone" />" />
   	  </td>
    </tr>
    <tr>
     <td valign="top" style="color:#7D2252;">Contact Person Name</td>
     <td valign="top">
        <s:property value="nomineeDTO.contactName" />
     	<input type="hidden" value="nomineeDTO.contactName" value="<s:property value="nomineeDTO.contactName" />" />
     </td>
     <td valign="top" style="color:#7D2252;">Contact Person Mobile</td>
     <td valign="top">
        <s:property value="nomineeDTO.nomineePhone" />
     	<input type="hidden" value="nomineeDTO.contactMobile" value="<s:property value="nomineeDTO.contactMobile" />" />
   	  </td>
    </tr>
    </table>
    
    
    </p>
</div>
<p style="height: 30px"></p>
<div class="boxPreview">
    <h3>Security Code</h3>
    <p>

  <div>
  <img src="BMG2G_WEB/CaptchaServlet.cap?rc=<s:property value="rc"/>&ft=2" alt="no image" id="captchaImage" name="captchaImage" /> 
  <input type="hidden" name="rc" value="<s:property value="rc"/>" /> 
  <br/>
  <input type="button" value="Get New Code"  onclick="refreshCaptcha('rc=<s:property value="rc"/>&ft=1')" />
  
  </div>  
  <br/>
  <div>
  <input type="text" class="captchCode" id="captchaText" name="personalDTO.captchaText"/>
  </div>
    <div style="color: red"><s:label name="Err_captchaError" ></s:label></div>
    </p>
</div>

<p style="height: 10px"></p>
<div style="margin-top: 10px;">
<input type="button" class="submitButton" name="Edit Application" value="Go Back" onclick="submitForm('editRegFormAction.action')"/>
<input type="button" class="submitButton" name="Submit Application" value="Submit Application" style="margin-left: 100px;" onclick="submitForm('submitRegistration.action')"/>
</div>
<p style="height: 30px"></p>
</center>

</form>
<script type="text/javascript">
//refreshCaptcha('rc=<s:property value="rc"/>&ft=1');

</script>


</body>

</html>