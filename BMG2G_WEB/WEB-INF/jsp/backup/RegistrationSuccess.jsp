
<%@page import="org.apache.struts2.ServletActionContext"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title>G2G Job Seeker Registration Form</title>
 <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />	

 <link type="text/css" rel="Stylesheet" href="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css" />
  
</head>

<body style="margin: 0px;">
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
<div id="Example_F" style="height: 580px;width: 1000px;margin-top: 10px;">
<div style="font-size: 25px;font-weight: bold;padding-top: 100px;color: blue;">Registration Id: <color style="color:green;">

<%=(String)ServletActionContext.getRequest().getSession().getAttribute("sessionObj_regId")%></color></div>
<div style="font-size: 22px;font-weight: bold;margin-top: 50px;">
	Registration has successfully been received. Please click below button to download your Admit Card.
</div>
<div style="margin-top: 100px;text-align: center;">
<a href="downloadAdmitCard.action?registrationId=<%=(String)ServletActionContext.getRequest().getSession().getAttribute("sessionObj_regId")%>" style="text-decoration: none;">
<input type="button" class="submitButton" name="Downalod Card" value="Click Here to Download Admit Card" style="width: 300px;"  />
</a>
</div>
<div style=" margin-top: 100px;">
<b>Note :</b> <font style="color:red">Please Print your Admit Card and save it carefully. You need to show this Admit Card during the time of your interview.</font> 
</div>
</div>
</center>



<div id="footer">
&copy;BMET-2012. All right reserved.
</div>
</body>

</html>