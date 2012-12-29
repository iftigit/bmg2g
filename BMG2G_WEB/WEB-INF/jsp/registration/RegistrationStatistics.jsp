<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title>Registration Statistics</title>

  <link rel="stylesheet" href="/BMG2G_WEB/resources/css/style.css" />
  <script type="text/javascript" src="/BMG2G_WEB/resources/js/lib/jquery-1.6.4.min.js"></script>
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
	 	<div style="font-size: 20px;margin-top: 10px;">Registration Statistics for Malaysia G2G Project</div>
	</div>
</div>
</center>
</div>


<table align="left" width="98%" cellpadding="2" cellspacing="2" style="margin-left: 20px;">
 <tr>
   <td align="left" width="43%" id="divisionTd" style="min-height: 700px;vertical-align: top;">
   
	   
   
   </td>
  <td width="5%"></td>
   <td align="left" width="43%" id="districtTd" style="min-height: 700px;vertical-align: top;">
   
   
   </td>
 </tr>
</table>


<script type="text/javascript">

var ajax_load="/BMG2G_WEB/resources/images/loading.gif";
var divisionTimerId = 0;
var districtTimerId = 0;
var divRefreshRate=30000;
var distRefreshRate=30000;
var selectedDistId="";
var selectedDistName="";

	function updateDivisionStatResult() 
	{
		 var loadUrl="divisionStat.action";	
	     
	     if(divRefreshRate>0)
	     {
	     $("#divisionTd")  
					.html(ajax_load)  
					.load(loadUrl, {refreshRate: divRefreshRate},function(responseText){  
					   
					   $("#divisionTd").html(responseText);
			
			 
					});
		}
		
	}
	divisionTimerId=setInterval(updateDivisionStatResult, divRefreshRate);
	updateDivisionStatResult();

 
 function loadDistrictStatistics(distId,distName) 
	{
	     if(distId==null || distId=="")
	     {
		   distId=selectedDistId;
		   distName=selectedDistName;
		 }
		 else
		 {
		   selectedDistId=distId;
		   selectedDistName=distName;
		 }
		 
		 var loadUrl="districtStat.action";	
		 
	     $("#districtTd")  
					.html(ajax_load)  
					.load(loadUrl, {districtId: distId,districtName:distName,refreshRate:distRefreshRate},function(responseText){  
					   
					   $("#districtTd").html(responseText);
			
			 
					});
		
	}
 
 
 function refreshDivisionStat(divRefRate)
 {
  divRefreshRate=divRefRate;
   if(divRefRate==0)
   {
     clearInterval(divisionTimerId);
   }
    
   else
   {
    clearInterval(divisionTimerId);
    divisionTimerId=setInterval(updateDivisionStatResult, divRefRate);
   }
 }
 
 function refreshDistrictStat(distRefRate)
 {
  distRefreshRate=distRefRate;
   if(distRefRate==0)
   {
     clearInterval(districtTimerId);
   }
    
   else
   {
    clearInterval(districtTimerId);
    districtTimerId=setInterval(loadDistrictStatistics, distRefRate);
   }
 }
 
 
</script>
<div id="footer">
&copy;BMET-2012. All right reserved.
</div>
</body>
</html>