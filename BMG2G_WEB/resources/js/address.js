var destiField="";
var pos;

function fetchJSONData_Dist(divId,dest){
        var url = 'JSONfindDistrict.action';
        destiField=dest;
     	var myAjax = new Ajax.Request(
                    url, 
                    {
                            method: 'post',
                            parameters: {'divId' : divId},
                            onComplete: fetchDistSuccess,
                            cache: true
                    });
         
   }
   function fetchDistSuccess(originalRequest){
       
     	var result = originalRequest.responseText.evalJSON();
     	var options="";
     	var tdId=""
     	if(destiField=="PERMANENT_DIST")
     	  {
     	   options="<select tabindex='31' name=\"addressDTO.pDistrict\" id=\"PERMANENT_DIST\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Thana(this.value,'PERMANENT_THANA')\">";
     	   tdId="PERMANENT_DIST_TD";
     	   document.getElementById(tdId).innerHTML="";
     	  }
     	else
     	 {
     	  options="<select tabindex='45' name=\"addressDTO.mDistrict\" id=\"MAILING_DIST\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Thana(this.value,'MAILING_THANA')\">";
     	  tdId="MAILING_DIST_TD";
     	  document.getElementById(tdId).innerHTML="";
     	 }
 		
 		options+="<option value='select'>--Select District--</option>";
 		for (var i=0;i<result.districtList.length;i=i+2)
 		{
        	options+="<option value='"+result.districtList[i+1]+"'>"+result.districtList[i]+"</option>"; 
        }
        options+="</select>";

        document.getElementById(tdId).innerHTML=options;

 	}
   
function fetchJSONData_Thana(distId,dest)
{
	destiField=dest;
	var url = 'JSONfindThana.action';
	var myAjax = new Ajax.Request(
                   url, 
                   {
                           method: 'post',
                           parameters: {'distId' : distId},
                           onComplete: fetchThanaSuccess,
                           cache: true
                   });
        
}
function fetchThanaSuccess(originalRequest)
{
	var result = originalRequest.responseText.evalJSON();
	var options="";
	var tdId=""
	if(destiField=="PERMANENT_THANA")
    {
    	options="<select tabindex='32' name=\"addressDTO.pThana\" id=\"PERMANENT_THANA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Union(this.value,'PERMANENT_UNION')\" >";
    	tdId="PERMANENT_THANA_TD";
    	document.getElementById(tdId).innerHTML="";
    }
    else
    {
    	options="<select tabindex='46' name=\"addressDTO.mThana\" id=\"MAILING_THANA\" class=\"addressSelectBox\" onchange=\"fetchJSONData_Union(this.value,'MAILING_UNION')\" >";
    	tdId="MAILING_THANA_TD";
    	document.getElementById(tdId).innerHTML="";
    }
	options+="<option value='select'>--Select Thana--</option>";
	for (var i=0;i<result.thanaList.length;i=i+2)
	{
    	options+="<option value='"+result.thanaList[i+1]+"'>"+result.thanaList[i]+"</option>"; 
	}
	options+="</select>";
	document.getElementById(tdId).innerHTML=options;
}

function fetchJSONData_Union(thanaId,dest)
{
	destiField=dest;
	var url = 'JSONfindUnion.action';
	var myAjax = new Ajax.Request(
                   url, 
                   {
                           method: 'post',
                           parameters: {'thanaId' : thanaId},
                           onComplete: fetchUnionSuccess,
                           cache: true
                   });
        
}
function fetchUnionSuccess(originalRequest)
{
	var result = originalRequest.responseText.evalJSON();
	var options="";
	var tdId=""
	if(destiField=="PERMANENT_UNION")
    {
    	options="<select tabindex='32' name=\"addressDTO.pUnion\" id=\"PERMANENT_UNION\" class=\"addressSelectBox\" >";
    	tdId="PERMANENT_UNION_TD";
    	document.getElementById(tdId).innerHTML="";
    }
    else
    {
    	options="<select tabindex='46' name=\"addressDTO.mUnion\" id=\"MAILING_UNION\" class=\"addressSelectBox\" >";
    	tdId="MAILING_UNION_TD";
    	document.getElementById(tdId).innerHTML="";
    }
	options+="<option value='select'>--Select Union--</option>";
	for (var i=0;i<result.unionList.length;i=i+2)
	{
    	options+="<option value='"+result.unionList[i+1]+"'>"+result.unionList[i]+"</option>"; 
	}
	options+="</select>";
	document.getElementById(tdId).innerHTML=options;
}  
  function copyPermanentAddress(checkValue)
  {
  
   if(checkValue==true)
   {
    
    
    $1('MAILING_DIV').value=$1('PERMANENT_DIV').value;
    document.getElementById('MAILING_DIV').readOnly =true;
    
    var t=getDropDown('PERMANENT_DIST');
    var selectedInd=t.selectedIndex;
    var tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    
    $1('MAILING_DIST_TD').innerHTML="<select tabindex='45' name=\"addressDTO.mDistrict\" id=\"MAILING_DIST\" class=\"addressSelectBox\" ><option value='"+$1('PERMANENT_DIST').value+"'>"+tex+"</option></select>";
    document.getElementById('MAILING_DIST').readOnly =true;
    
    t=getDropDown('PERMANENT_THANA');
    selectedInd=t.selectedIndex;
    tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    $1('MAILING_THANA_TD').innerHTML="<select tabindex='46' name=\"addressDTO.mThana\" id=\"MAILING_THANA\" class=\"addressSelectBox\" ><option  value='"+$1('PERMANENT_THANA').value+"'>"+tex+"</option>";
    document.getElementById('MAILING_THANA').readOnly =true;
    
    
    t=getDropDown('PERMANENT_UNION');
    selectedInd=t.selectedIndex;
    tex="";
    if(selectedInd>=0)
      tex=t.options[selectedInd].text;
    $1('MAILING_UNION_TD').innerHTML="<select tabindex='46' name=\"addressDTO.mUnion\" id=\"MAILING_UNION\" class=\"addressSelectBox\" ><option  value='"+$1('PERMANENT_UNION').value+"'>"+tex+"</option>";
    document.getElementById('MAILING_UNION').readOnly =true;
   
    
    $1('MAILING_POST').value=$1('PERMANENT_POST').value;
    $1('MAILING_POST_CODE').value=$1('PERMANENT_POST_CODE').value;
    $1('MAILING_ADDRESS_LINE1').value=$1('PERMANENT_ADDRESS_LINE1').value;
    $1('MAILING_ADDRESS_LINE2').value=$1('PERMANENT_ADDRESS_LINE2').value;
    
    
   }
   
   else
   {
    var t=getDropDown('MAILING_DIV');
    t.selectedIndex=0
    
    //$1('MAILING_DIV').value="--Select Division--";
    $1('MAILING_DIST').innerHTML="";
    $1('MAILING_THANA').innerHTML="";
    $1('MAILING_UNION').innerHTML="";
    
    $1('MAILING_POST').value="";
    $1('MAILING_POST_CODE').value="";
    $1('MAILING_ADDRESS_LINE1').value="";
    $1('MAILING_ADDRESS_LINE2').value="";
   }
   
  }
  
  
  function areaSelect(fieldValue,fieldId)
  {
   if(fieldValue=="Others")
    document.getElementById(fieldId).style.display="block";
   else
    document.getElementById(fieldId).style.display="none";
    
  }
  


	function getDropDown(listid)
	{
	var dps =  document.getElementsByTagName("select");
	var dpsno;
	
	for(i=0;i<dps.length;i++)
	 {
	   if(dps[i].id==listid)
	   {
	    dpsno = dps[i];
	    break;
	   }
	 }
	return dpsno; 
	} 