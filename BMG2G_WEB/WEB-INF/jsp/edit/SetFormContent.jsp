<%@page import="org.table.PersonalInfoDTO"%>
<%@page import="org.table.AddressDTO"%>
<%@page import="org.table.NomineeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.table.EducationDTO"%>
<%@page import="org.table.LanguageDTO"%>
<%@page import="org.table.ExperienceDTO"%>
<%@page import="org.table.TrainingDTO"%>
<DIV onMouseUp="return false"  onMouseMove="return false" onMouseDown="return false"
id="bid" onDblClick="return false" style="DISPLAY: none; Z-INDEX: 51; LEFT: 0px; POSITION: absolute; overflow:none;
TOP: 0px; BACKGROUND-COLOR: white;filter:alpha(opacity=70); opacity:0.7; height:100%; width:100%;" onclick="return false" >
<center>

<p style="margin-top: 260px;">
</p>
<div id="ifti" class="jquery-corner" style="background-color: #C1D979;height: 100px; width: 400px">
 <center>
<br/>
<img src="/BMG2G_WEB/resources/images/ajax-loader.gif" border="0" />
<br/><br/>
 <font style="color: red; font-size: 15px; font-weight: bold;">Loading....</font>
</center>

</div>


</center>
</DIV>
<script type="text/javascript">
var pageHeight,pageWidth;
var xScroll, yScroll;

function getPageSize(){
if (window.innerHeight && window.scrollMaxY) {
xScroll = document.body.scrollWidth;
yScroll = window.innerHeight + window.scrollMaxY;
} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
xScroll = document.body.scrollWidth;
yScroll = document.body.scrollHeight;
} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
xScroll = document.body.offsetWidth;
yScroll = document.body.offsetHeight;
}

var windowWidth, windowHeight;
if (self.innerHeight) { // all except Explorer
windowWidth = self.innerWidth;
windowHeight = self.innerHeight;
} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
windowWidth = document.documentElement.clientWidth;
windowHeight =document.documentElement.clientHeight;
} else if (document.body) { // other Explorers
windowWidth = document.body.clientWidth;
windowHeight = document.body.clientHeight;
}

// for small pages with total height less then height of the viewport
if(yScroll < windowHeight){
pageHeight = windowHeight;
} else {
pageHeight = yScroll;
}

// for small pages with total width less then width of the viewport
if(xScroll < windowWidth){
pageWidth = windowWidth;
} else {
pageWidth = xScroll;
}

arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight)
return arrayPageSize;
}


getPageSize();

function loadingComplete()
{
 document.getElementById("bid").style.display = "none";
}

var tmp=document.getElementById("bid").style;
var heightPG=pageHeight;
var widthPG=document.body.scrollWidth;
tmp.height=heightPG+"px";tmp.width=widthPG+"px";
document.getElementById("bid").style.display = "block";

</script>

<%String reset_Sex=((PersonalInfoDTO) (request.getAttribute("personalDTO"))).getSex(); %>
<%String reset_MaritalStatus=((PersonalInfoDTO) (request.getAttribute("personalDTO"))).getMaritalStatus(); %>
<%String reset_Religion=((PersonalInfoDTO) (request.getAttribute("personalDTO"))).getReligion(); %>
<%String reset_nomineeRelation=((PersonalInfoDTO) (request.getAttribute("personalDTO"))).getNomineeRelation();
 %>

<%String reset_category=((PersonalInfoDTO) (request.getAttribute("personalDTO"))).getDesiredJobCat1();%>
<%
	String reset_subCategory=((PersonalInfoDTO) (request.getAttribute("personalDTO"))).getDesiredJobSubcategory1();
%>
<%
System.out.println(reset_Sex);
System.out.println(reset_MaritalStatus);
 %>
<%  if(reset_Sex.equalsIgnoreCase("Male")) { %>
<script type="text/javascript">
 document.getElementById("SEXMale").checked=true;
 document.getElementById("SEXFemale").checked=false;
</script>    
<%}else { %>
<script type="text/javascript">
 document.getElementById("SEXMale").checked=false;
 document.getElementById("SEXFemale").checked=true;
</script>
<% } %>

<%  if(reset_MaritalStatus.equalsIgnoreCase("Married")) { %>
<script type="text/javascript">
 document.getElementById("Married").checked=true;
 document.getElementById("Unmarried").checked=false;
</script>    
<%}else { %>
<script type="text/javascript">
 document.getElementById("Married").checked=false;
 document.getElementById("Unmarried").checked=true;
</script>
<% } %>


<script type="text/javascript">
   for(var i=0;i<document.forms['empRegForm'].RELIGION.length;i++)
	  { 
        if(document.forms['empRegForm'].RELIGION.options[i].value=="<%=reset_Religion%>")
		   document.forms['empRegForm'].RELIGION.selectedIndex=i;
      }
    for(var i=0;i<document.forms['empRegForm'].NOMINEE_RELATION.length;i++)
	  { 
        if(document.forms['empRegForm'].NOMINEE_RELATION.options[i].value=="<%=reset_nomineeRelation%>")
		   document.forms['empRegForm'].NOMINEE_RELATION.selectedIndex=i;
      }
     for(var i=0;i<document.forms['empRegForm'].DESIREDJOBCAT1.length;i++)
	  { 
        if(document.forms['empRegForm'].DESIREDJOBCAT1.options[i].value=="<%=reset_category%>")
        {
		   document.forms['empRegForm'].DESIREDJOBCAT1.selectedIndex=i;
		   checkSubCategory("<%=reset_category%>");
		}
      }
      for(var i=0;i<document.forms['empRegForm'].DESIREDJOBSUBCAT1.length;i++)
	  { 
        if(document.forms['empRegForm'].DESIREDJOBSUBCAT1.options[i].value=="<%=reset_subCategory%>")
        {
		   document.forms['empRegForm'].DESIREDJOBSUBCAT1.selectedIndex=i;
		}
      }
       
/*!!!!!!!  Resetting Address Information of JobSeeker  !!!!!!!!!*/


<% String sub_MDiv=((AddressDTO) (request.getAttribute("addressDTO"))).getmDivision();

System.out.print(sub_MDiv);
%>
 
 if("<%=sub_MDiv%>"!="select")
  {
      for(var i=0;i<document.forms['empRegForm'].MAILING_DIV.length;i++)
	  { 
        if(document.forms['empRegForm'].MAILING_DIV.options[i].value=="<%=sub_MDiv%>")
		   {
		    document.forms['empRegForm'].MAILING_DIV.selectedIndex=i;
			fetchJSONData_Dist("<%=sub_MDiv%>","MAILING_DIST");
   		    funcSetMDistrict();  
  	   }
      }
  
  }

							 
function funcSetMDistrict(){

 <% String sub_MDist=((AddressDTO) (request.getAttribute("addressDTO"))).getmDistrict();%>
     for(var i=0;i<document.forms['empRegForm'].MAILING_DIST.length;i++)
	  { 
        if(document.forms['empRegForm'].MAILING_DIST.options[i].value=="<%=sub_MDist%>")
		   {
		    document.forms['empRegForm'].MAILING_DIST.selectedIndex=i;
		    fetchJSONData_Thana("<%=sub_MDist%>","MAILING_THANA");
		    funcSetMThana();
		   }
      }
 
}

function funcSetMThana(){
 <% String sub_MThana=((AddressDTO) (request.getAttribute("addressDTO"))).getmThana();%>
    for(var i=0;i<document.forms['empRegForm'].MAILING_THANA.length;i++)
	  { 
        if(document.forms['empRegForm'].MAILING_THANA.options[i].value=="<%=sub_MThana%>")
		   {
		    document.forms['empRegForm'].MAILING_THANA.selectedIndex=i;
		    fetchJSONData_Union("<%=sub_MThana%>","MAILING_UNION");
		    funcSetMUnion();
		   }
      }
 
	}

function funcSetMUnion(){
 <% String sub_MUnion=((AddressDTO) (request.getAttribute("addressDTO"))).getMUnion();%>
    for(var i=0;i<document.forms['empRegForm'].MAILING_UNION.length;i++)
	  { 
        if(document.forms['empRegForm'].MAILING_UNION.options[i].value=="<%=sub_MUnion%>")
		   {
		    document.forms['empRegForm'].MAILING_UNION.selectedIndex=i;
		   }
      }
 
	}

</script>


<script type="text/javascript">
setTimeout("loadingComplete()",2000);
</script>
