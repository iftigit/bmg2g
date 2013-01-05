<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="org.controller.registration.*" %>
<%@ page import="java.util.ArrayList" %>
<head>


<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title>G2G Job Seeker Registration Form</title>
 <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />	
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/xmlextras.js"></script>
 <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
 
        
    <style type="text/css"> @import url("/BMG2G_WEB/resources/js/lib/jscalendar-1.0/skins/aqua/theme.css"); </style>
    
  
</head>
<body style="margin-top: 30px;">
<script type="text/javascript">

function getSecurityCode()
{
	document.getElementById("securitycode").disabled = 'disabled';
	if(document.getElementById("PERMANENT_MOBILE").value.length<11)
	{
		alert("Please fillup mobile correctly");
		return;
	}
	if(document.getElementById("captchaText").value=="")
	{
		alert("Please fillup captcha code correctly");
		return;	
	}	
	if (window.XMLHttpRequest)
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			if(xmlhttp.responseText=="Please type captcha text correctly")
			{
				alert("Please type captcha text correctly");
				document.getElementById("securitycode").disabled = false;	
			}
		}
	}
	//alert("ho");
	var url="/BMG2G_WEB/securityCode?mobile="+document.getElementById("PERMANENT_MOBILE").value+
		"&ctext="+document.getElementById("captchaText").value;
	xmlhttp.open("GET",url,false);
	xmlhttp.send();
	document.getElementById("PERMANENT_MOBILE").value="01";
	document.getElementById("captchaText").value="";
	refreshCaptcha1('');
	document.getElementById("mobile1").value=document.getElementById("PERMANENT_MOBILE").value;
	
}
function refreshCaptcha1(queryParam)
{
	var rightnow = new Date();
	document.images.captchaImage.src = 'BMG2G_WEB/CaptchaServlet.cap?'+queryParam+"&dateTime="+ rightnow.getTime();
	document.images.captchaImage1.src = 'BMG2G_WEB/CaptchaServlet.cap?'+queryParam+"&dateTime="+ rightnow.getTime();

}

   
</script>
<table width="100%" >
<tr><td valign="top" width="50%" align="center">
<div class="box3" align="center" style="height: 370px">
    <h3>User Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    <tr>
     <td width="20%">Mobile No</td>
     <td width="80%" colspan="3" >
	 <input type="text" tabindex="1" name="addressDTO.pMobile" id="PERMANENT_MOBILE" maxlength="11"  value="01" class="nameTextBox"  onkeypress="return numericOnly(event)"/>
     </td>
    </tr>
    <tr>
     <td width="25%"></td>
     <td width="75%" colspan="3" > 
     	<img src="BMG2G_WEB/CaptchaServlet.cap" alt="no image" id="captchaImage" name="captchaImage" />
     	<a href="#" onclick="refreshCaptcha1('')"><img src="/BMG2G_WEB/resources/images/refresh_icon.gif" /></a>
     </td>   
    </tr>
    <tr>
    	<td width="25%"></td>
    	<td width="75%" colspan=3>
    		<input type="text" class="captchCode" id="captchaText" name="personalDTO.captchaText"/>
    		<div style="color: red"><s:label name="Err_captchaError" ></s:label></div>
    	</td>
    </tr>
    
    </table>
	<input type="button" class="submitButton" id="securitycode" value="Get Confirmation Code" onclick="getSecurityCode()" />
    
    </p>
</div>
	<br/>
	<font style="color: red">You should receive a confirmation code to your given mobile number.</font> 

</td>
<td valign="top" width="50%" align="center">
<div class="box3" align="center" style="height: 370px">
    <h3>Confirmation Code Information</h3>
    <p>
    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    <tr>
     <td width="25%">Mobile No</td>
     <td width="75%" colspan="3" >
	 <input type="text" tabindex="1" name="mobile1" id="mobile1" maxlength="11"  value="01" class="nameTextBox"  onkeypress="return numericOnly(event)"/>
     </td>
    </tr>

    <tr>
     <td width="25%">Confirmation Code</td>
     <td width="75%" colspan="3" >
	 <input type="text" tabindex="1" name="ccode" id="ccode" value="" class="nameTextBox"/>
     </td>
    </tr>
    <tr>
     <td width="25%"></td>
     <td width="75%" colspan="3" > 
     	<img src="BMG2G_WEB/CaptchaServlet.cap" alt="no image" id="captchaImage1" name="captchaImage1" />
     	<a href="#" onclick="refreshCaptcha1('')"><img src="/BMG2G_WEB/resources/images/refresh_icon.gif" /></a>
     </td>   
    </tr>
    <tr>
    	<td width="25%"></td>
    	<td width="75%" colspan=3>
    		<input type="text" class="captchCode" id="captchaText" name="personalDTO.captchaText"/>
    		<div style="color: red"><s:label name="Err_captchaError" ></s:label></div>
    	</td>
    </tr>
    
    </table>
	<input type="button" class="submitButton" name="passwordcode" value="Get Password" onclick="getSecurityCode()" />
    
    </p>
</div>
	<br/>
	<font style="color: red">Please provide the received confirmation code and request for a new password.</font> 

</td></tr></table>


</body>
</html>