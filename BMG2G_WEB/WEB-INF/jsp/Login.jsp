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
<title>G2G Project - Login Page</title>
 <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />	
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery-1.6.4.min.js"></script> 
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/numeric.js"></script>
 <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
 
 <link type="text/css" rel="Stylesheet" href="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css" />
        <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
 
 <script type="text/javascript">
   $(function() { 

                $("form").validity(function() {
                    $("#USERID")                      // The first input:    
        			.require("Userid required.");                         // Required:
        			
        			$("#PASSWORD")                      // The first input:    
        			.require("Password required.");                         // Required:
        			
                });
            });
 </script>
  
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
	 	<div style="font-size: 20px;margin-top: 10px;">G2G Project Registration System Login Page</div>
	</div>
</div>
</center>
</div>
<center>
<br/>
				
<div class="box" style="margin-top: 120px;width: 500px;">
    <h3>Login</h3>
    
<form id="loginForm" name="loginForm" method="post" action="checkValidity.action">    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    
    <tr>
     <td align="left" width="20%">Mobile No</td>
     <td align="left" width="80%"><input type="text" tabindex="6" name="userId" id="USERID" maxlength="15" class="textBox" value="<s:property value='userId' />" />
      
     </td>
    </tr>

    
    <tr>
     <td>Password</td>
     <td><input type="password" tabindex="6" name="password" id="PASSWORD" maxlength="15" class="textBox" value="<s:property value='password' />" /></td>
    </tr>

    <tr>
     <td height="30px;"></td>
     <td style="padding-bottom: 10px;" align="left">
     	<table width="100%" cellpadding="0" cellspacing="0">
	     	<tr>
	     	<td align="left" style="padding-left: 0px;">
	     		<input type="submit" value="Login" name="Login" />
	     	</td>
	     	<td align="right" style="padding-right: 0px;"><a href="np1">Request Password</a></td>
	     	</tr>
     	</table>
     </td>
    </tr>
    
    </table>
</form>      
</div>
<p style="height: 10px"></p>
<s:if test="hasActionMessages()">
				   <div class="errors">				    
			            	<s:actionmessage />
			         <!-- notification info -->
				   </div>
<br/>
</s:if>
</center>
<script type="text/javascript">
$('input').attr('autocomplete','off');   
</script>
</body>

</html>