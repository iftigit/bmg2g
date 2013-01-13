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
<title>G2G Project - Lottery Home</title>
 <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />	
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery-1.6.4.min.js"></script> 
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
<script type="text/javascript" src="/BMG2G_WEB/resources/js/util/numeric.js"></script>
 <script type="text/javascript" src="/BMG2G_WEB/resources/js/util/util.js"></script>
 
 <link type="text/css" rel="Stylesheet" href="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css" />
        <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
 

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
	 	<div style="font-size: 20px;margin-top: 10px;">G2G Lottery Home</div>
	</div>
</div>
</center>
</div>
<center>
<br/>
<div class="box" style="margin-top: 20px;width: 1000px;text-align: center;">
    <h3>Lottery</h3>
    
<form id="loginForm" name="loginForm" method="post" action="checkValidity.action">    
    <table width="100%" border="0" cellspacing="1" class="infoTable">
    
    <tr>
     <td style="text-align: center" width="50%">
     	<input type="button" name="Lottery" value="Process Lottery" style="width: 150px; height: 40px;font-weight: bold;" />
     </td>
     <td style="text-align: center" width="50%">
     	<input type="button" name="LotteryResult" value="Download Lottery Result" style="width: 250px; height: 40px;font-weight: bold;"/>
     </td>
    </tr>
    <tr>
    <td colspan="2"></td>
    </tr>
    <tr>
    
    <td colspan="2" style="padding: 0px;">
    	<table width="100%" border="0" cellpadding="0" cellspacing="0" >
    	<tr>
    	    <td width="10%" align="center" style="background-color: #A2C1A2">SL</td>
    		<td width="20%" align="center" style="background-color: #8EBBB8">Reg. Number</td>
    		<td width="20%" align="center" style="background-color: #A2C1A2">Jobseeker Name</td>
    		<td width="20%" align="center" style="background-color: #8EBBB8">Father Name</td>
    		<td width="20%" align="center" style="background-color: #A2C1A2">Mother Name</td>    		
    		<td width="10%" align="center" style="background-color: #8EBBB8">Union</td>
    	</tr>
    	</table>
    	
    	<div style="height: 500px;overflow: auto;">
    		<table width="100%" border="0" cellpadding="0" cellspacing="0" >    	   
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">10</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">9</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">8</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">7</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">6</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">5</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">4</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">3</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">4</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">3</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">4</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">3</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #FFFFFF">
		    		<td align="center">4</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
		    	<tr style="background-color: #E1E1E1">
		    		<td align="center">3</td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    		<td align="center"></td>
		    	</tr>
    		</table>
    	</div>
    	
    </td>
    </tr>
    

    </table>
</form>    
    
  
</div>
<p style="height: 30px"></p>
</center>

</body>

</html>