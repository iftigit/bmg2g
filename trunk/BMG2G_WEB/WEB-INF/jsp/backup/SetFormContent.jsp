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

<%String reset_Sex=((PersonalInfoDTO) (request.getSession().getAttribute("sessionObj_PersonalInfo"))).getSex(); %>
<%String reset_MaritalStatus=((PersonalInfoDTO) (request.getSession().getAttribute("sessionObj_PersonalInfo"))).getMaritalStatus(); %>
<%String reset_Religion=((PersonalInfoDTO) (request.getSession().getAttribute("sessionObj_PersonalInfo"))).getReligion(); %>
<%String reset_nomineeRelation=((NomineeDTO) (request.getSession().getAttribute("sessionObj_NomineeInfo"))).getNomineeRelation(); %>


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
      
      

/*!!!!!!!  Resetting Address Information of JobSeeker  !!!!!!!!!*/
 <% String sub_PDiv=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getpDivision();%>
 
 if("<%=sub_PDiv%>"!="select")
  {
      for(var i=0;i<document.forms['empRegForm'].PERMANENT_DIV.length;i++)
	  { 
        if(document.forms['empRegForm'].PERMANENT_DIV.options[i].value=="<%=sub_PDiv%>")
		   {
		    document.forms['empRegForm'].PERMANENT_DIV.selectedIndex=i;
			fetchJSONData_Dist("<%=sub_PDiv%>","PERMANENT_DIST");
   		    funcSetPDistrict();  
  	   }
      }
  
  }
							 
function funcSetPDistrict(){
 <% String sub_PDist=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getpDistrict();%>
     for(var i=0;i<document.forms['empRegForm'].PERMANENT_DIST.length;i++)
	  { 
        if(document.forms['empRegForm'].PERMANENT_DIST.options[i].value=="<%=sub_PDist%>")
		   {
		    document.forms['empRegForm'].PERMANENT_DIST.selectedIndex=i;
		    fetchJSONData_Thana("<%=sub_PDist%>","PERMANENT_THANA");
		    funcSetPThana();
		   }
      }
 
}

function funcSetPThana(){
 <% String sub_PThana=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getpThana();%>
    for(var i=0;i<document.forms['empRegForm'].PERMANENT_THANA.length;i++)
	  { 
        if(document.forms['empRegForm'].PERMANENT_THANA.options[i].value=="<%=sub_PThana%>")
		   {
		    document.forms['empRegForm'].PERMANENT_THANA.selectedIndex=i;
		    setMailingAddress();
		   }
      }
 
}

function setMailingAddress()      
      {
<%
    String sameAsPermanenet=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getSameAsPermanenet();
        
%>  

    if("<%=sameAsPermanenet%>"=="on")
     {
      document.getElementById("mp").checked=true;
      copyPermanentAddress(true);
     }
     else
     {    
<% String sub_MDiv=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getmDivision();%>
 
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
} //End of Else

} //End of Function 
							 
function funcSetMDistrict(){

 <% String sub_MDist=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getmDistrict();%>
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
 <% String sub_MThana=((AddressDTO) (request.getSession().getAttribute("sessionObj_AddressInfo"))).getmThana();%>
    for(var i=0;i<document.forms['empRegForm'].MAILING_THANA.length;i++)
	  { 
        if(document.forms['empRegForm'].MAILING_THANA.options[i].value=="<%=sub_MThana%>")
		   {
		    document.forms['empRegForm'].MAILING_THANA.selectedIndex=i;
		   }
      }
 
	}

setEducationTyped();
//setTimeout("setEducationTyped()",200);
function setEducationTyped()
{
<%ArrayList<EducationDTO> education_list=(ArrayList<EducationDTO>) request.getSession().getAttribute("sessionObj_EducationInfo"); 
if(education_list.size()>=1)
 {
 for(int j=0;j<education_list.size();j++)
 {
  %>
 addMoreEducation();
<%}
 }
%>
<%for(int i=0;i<education_list.size();i++)
 {
%>
 $1('degree'+'<%=i%>').value="<%=((EducationDTO) education_list.get(i)).getDegreeName()%>";
 $1('year'+'<%=i%>').value="<%=((EducationDTO) education_list.get(i)).getPassingYear()%>";
 $1('school'+'<%=i%>').value="<%=((EducationDTO) education_list.get(i)).getSchool()%>";
 $1('board'+'<%=i%>').value="<%=((EducationDTO) education_list.get(i)).getUniversity()%>";
 $1('subject'+'<%=i%>').value="<%=((EducationDTO) education_list.get(i)).getSubject()%>";
 $1('grade'+'<%=i%>').value="<%=((EducationDTO) education_list.get(i)).getGrade()%>";
 
    <%
 }
%>
}


setLanguageTyped();
//setTimeout("setLanguageTyped()",200);
function setLanguageTyped()
{
<%ArrayList<LanguageDTO> language_list=(ArrayList<LanguageDTO>) request.getSession().getAttribute("sessionObj_LanguageInfo"); 
if(language_list.size()>=1)
 {
 for(int j=0;j<language_list.size();j++)
 {
  %>
 addMoreLanguage();
<%}
 }
%>
<%for(int i=0;i<language_list.size();i++)
 {
%>
 $1('language'+'<%=i%>').value="<%=((LanguageDTO) language_list.get(i)).getLanguage()%>";
 $1('oral'+'<%=i%>').value="<%=((LanguageDTO) language_list.get(i)).getOralSkill()%>";
 $1('writing'+'<%=i%>').value="<%=((LanguageDTO) language_list.get(i)).getWritingSkill()%>";
<%}%>
}


setExperienceTyped();
function setExperienceTyped()
{
<%ArrayList<ExperienceDTO> experience_list=(ArrayList<ExperienceDTO>) request.getSession().getAttribute("sessionObj_ExperienceInfo"); 
if(experience_list.size()>=1)
 {
 for(int j=0;j<experience_list.size();j++)
 {
  %>
 addMoreExperience();
<%}
 }
%>
<%for(int i=0;i<experience_list.size();i++)
 {
%>
 $1('COMPANY_NAME'+'<%=i%>').value="<%=((ExperienceDTO) experience_list.get(i)).getCompanyName()%>";
 $1('POSITION_HELD'+'<%=i%>').value="<%=((ExperienceDTO) experience_list.get(i)).getPosition()%>";
 $1('SERVE_FROM'+'<%=i%>').value="<%=((ExperienceDTO) experience_list.get(i)).getServeFrom()%>";
 $1('SERVE_TILL'+'<%=i%>').value="<%=((ExperienceDTO) experience_list.get(i)).getServeTill()%>";
 $1('EXPERI_ADDRESS'+'<%=i%>').value="<%=((ExperienceDTO) experience_list.get(i)).getAddress()%>";
 <%
 }
%>
}


setTimeout("setTrainingTyped()",200);
function setTrainingTyped()
{
<%ArrayList<TrainingDTO> training_list=(ArrayList<TrainingDTO>) request.getSession().getAttribute("sessionObj_TrainingInfo"); 
if(training_list.size()>=1)
 {
 for(int j=0;j<training_list.size();j++)
 {
  %>
 addMoreTraining();
<%}
 }
%>
<%for(int i=0;i<training_list.size();i++)
 {
%>
 $1('trainingName'+'<%=i%>').value="<%=((TrainingDTO) training_list.get(i)).getTrainingName()%>";
 $1('trainingFrom'+'<%=i%>').value="<%=((TrainingDTO) training_list.get(i)).getFromWhere()%>";
 $1('trainingDuration'+'<%=i%>').value="<%=((TrainingDTO) training_list.get(i)).getDuration()%>";
 $1('trainingDesc'+'<%=i%>').value="<%=((TrainingDTO) training_list.get(i)).getDescription()%>";
<%}%>
}
</script>


<script type="text/javascript">
setTimeout("loadingComplete()",2000);
</script>
