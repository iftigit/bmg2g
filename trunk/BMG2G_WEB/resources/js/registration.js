var version=BrowserDetect.init();
var totalExpNum=0;
var cnt=new Array(1);
cnt[0]=0;

var cntt=new Array(1);
cntt[0]=0;

var cnt1=new Array(1);
cnt1[0]=0;


var eduTab=100;
var lanTab=201;
var expTab=300;
var trainTab=401;

function addMoreEducation()
{
  row=0;
 
 
 	var elementDegree = document.createElement("input");
	elementDegree.id = "degree"+cnt[row];
	elementDegree.style.border="1px solid grey";
	elementDegree.style.width = '150px';
	elementDegree.style.textAlign = 'left';
	elementDegree.setAttribute('maxlength',60);
	elementDegree.name = cnt[row];
	
	elementDegree.tabIndex=eduTab+cnt[row]+1;
	
	//alert(eduTab+cnt[row]+1); 
	
	
	var elementYear = document.createElement("select");
	elementYear.id = "year"+cnt[row];
	elementYear.name = cnt[row];
	elementYear.options[0] = new Option("Select","select");
	for(var i=1950;i<2010;i++)
	{
	 elementYear.options[i-1949] = new Option(i,i);
	}
	elementYear.style.width = '100px';
	elementYear.style.textAlign = 'center';
	elementYear.style.border="1px solid grey";
	
	elementYear.tabIndex=eduTab+cnt[row]+2;
	
	
 	


	var elementSchool = document.createElement("input");
	elementSchool.id = "school"+cnt[row];
	elementSchool.style.border="1px solid grey";
	elementSchool.style.width = '250px';
	elementSchool.setAttribute('maxlength',80);
	elementSchool.name = cnt[row];
	elementSchool.tabIndex=eduTab+cnt[row]+3;
	
	var elementBoard = document.createElement("select");
	elementBoard.id = "board"+cnt[row];
	elementBoard.name = cnt[row];
	
	elementBoard.options[0] = new Option("Select","select");
	elementBoard.options[1] = new Option("N/A","N/A");
	elementBoard.options[2] = new Option("Dhaka Board","Dhaka Board");
	elementBoard.options[3] = new Option("Rajshahi Board","Rajshahi Board");
	elementBoard.options[4] = new Option("Comilla Board","Comilla Board");
	elementBoard.options[5] = new Option("Jessore Board","Jessore Board");
	elementBoard.options[6] = new Option("Chittagong Board","Chittagong Board");
	elementBoard.options[7] = new Option("Barisal Board","Barisal Board");
	elementBoard.options[8] = new Option("Sylhet Board","Sylhet Board");
	elementBoard.options[9] = new Option("Dinajpur Board","Dinajpur Board");
	elementBoard.options[10] = new Option("Madrasha Board","Madrasha Board");
	elementBoard.options[11] = new Option("Technical - SSC(Vocational)","Technical - SSC(Vocational)");
	elementBoard.options[12] = new Option("Others","Others");
	elementBoard.tabIndex=eduTab+cnt[row]+4;
	
	elementBoard.style.width = '120px';
	elementBoard.style.border="1px solid grey";
	elementBoard.style.textAlign = 'left';
	
	var elementSubject = document.createElement("input");
	elementSubject.id = "subject"+cnt[row];
	elementSubject.style.width = '120px';
	elementSubject.style.border="1px solid grey";
	elementSubject.style.textAlign = 'center';
	elementSubject.setAttribute('maxlength',60);
	elementSubject.name = cnt[row];
	elementSubject.tabIndex=eduTab+cnt[row]+5;


	var elementGrade = document.createElement("input");
	elementGrade.id = "grade"+cnt[row];
	elementGrade.style.width = '100px';
	elementGrade.style.border="1px solid grey";
	elementGrade.style.textAlign = 'center';	
	elementGrade.setAttribute('maxlength',60);
	elementGrade.name = cnt[row];
	elementGrade.style.textAlign = 'center';
	elementGrade.tabIndex=eduTab+cnt[row]+6;
	
	var elementDelete = document.createElement("a");
	elementDelete.id = "delete"+cnt[row];
	elementDelete.href = "javascript:void(0)";
	elementDelete.innerHTML = "<font size=2>Delete</font>";
	elementDelete.value = cnt[row];
	elementDelete.tabIndex=eduTab+cnt[row]+7;
	
	if(window.addEventListener)
	{              //DOM compliant
	
	 elementDelete.addEventListener("click",function()
	                                        {
	                                          document.getElementById("degree"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column4"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column5"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column7"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column8"+elementDelete.value).style.display = 'none';
	                                          
	                                          return false;
	                                        },true);
	 }
	  else
	     {           //IE6 standards compliant mode
	     elementDelete.attachEvent("onclick",function()
	                                         {
	                                          document.getElementById("degree"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column4"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column5"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column7"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column8"+elementDelete.value).style.display = 'none';

	                                          return false;
	                                         },true);
	     }
	
		
	

	table1 = document.getElementById("degreeTable");
	table1.style.border = '0px';
	newRow = table1.insertRow(table1.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementDegree);
	newRow.id = "column1"+cnt[row];

	 
	table2 = document.getElementById("yearTable");
	table2.style.border = '0px';
	newRow = table2.insertRow(table2.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementYear);
	newRow.id = "column2"+cnt[row];
	  
	table3 = document.getElementById("schoolTable");
	table3.style.border = '0px';
	newRow = table3.insertRow(table3.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementSchool);
	newRow.id = "column3"+cnt[row];
	
	table4 = document.getElementById("boardTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementBoard);
	newRow.id = "column4"+cnt[row];
	
	table5 = document.getElementById("subjectTable");
	table5.style.border = '0px';
	newRow = table5.insertRow(table5.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementSubject);
	newRow.id = "column5"+cnt[row];
/*	
	table6 = document.getElementById("countryTable");
	table6.style.border = '0px';
	newRow = table6.insertRow(table6.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementCountry);
	newRow.id = "column6"+cnt[row];
	
*/	
	table7 = document.getElementById("gradeTable");
	table7.style.border = '0px';
	newRow = table7.insertRow(table7.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementGrade);
	newRow.id = "column7"+cnt[row];				



	
	table4 = document.getElementById("deleteEducationTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	 
	newCell.appendChild(elementDelete);
	newRow.id = "column8"+cnt[row];
	 
	 
	 cnt[row]++;
	 // document.getElementById("languageNumber").value=cnt[row];
	  //alert(cnt[row]);
	 return cnt[row];
}

function defaultEducationLoad()
{
  row=0;
 
 	var elementDegree = document.createElement("input");
	elementDegree.id = "degree"+cnt[row];
	elementDegree.setAttribute('maxlength',60);	
	elementDegree.name = cnt[row];
	elementDegree.tabIndex=eduTab+cnt[row]+1;
	
	elementDegree.style.border="1px solid grey";
	elementDegree.style.width = '150px';
	elementDegree.style.textAlign = 'left';
	
	var elementYear = document.createElement("select");
	elementYear.id = "year"+cnt[row];
	elementYear.name = cnt[row];
	elementYear.options[0] = new Option("Select","select");
	for(var i=1950;i<2010;i++)
	{
	 elementYear.options[i-1949] = new Option(i,i);
	}
	elementYear.style.width = '100px';
	elementYear.style.textAlign = 'center';
	elementYear.style.border="1px solid grey";
	elementYear.tabIndex=eduTab+cnt[row]+2;


	var elementSchool = document.createElement("input");
	elementSchool.id = "school"+cnt[row];
	elementSchool.style.border="1px solid grey";
	elementSchool.style.width = '250px';
	elementSchool.setAttribute('maxlength',80);
	elementSchool.name = cnt[row];
	elementSchool.tabIndex=eduTab+cnt[row]+3;
	
	
	var elementBoard = document.createElement("select");
	elementBoard.id = "board"+cnt[row];
	elementBoard.name = cnt[row];
	
	elementBoard.options[0] = new Option("Select","select");
	elementBoard.options[1] = new Option("N/A","N/A");
	elementBoard.options[2] = new Option("Dhaka Board","Rajshahi Board");
	elementBoard.options[3] = new Option("Rajshahi Board","Rajshahi Board");
	elementBoard.options[4] = new Option("Comilla Board","Comilla Board");
	elementBoard.options[5] = new Option("Jessore Board","Jessore Board");
	elementBoard.options[6] = new Option("Chittagong Board","Chittagong Board");
	elementBoard.options[7] = new Option("Barisal Board","Barisal Board");
	elementBoard.options[8] = new Option("Sylhet Board","Sylhet Board");
	elementBoard.options[9] = new Option("Dinajpur Board","Dinajpur Board");
	elementBoard.options[10] = new Option("Madrasha Board","Madrasha Board");
	elementBoard.options[11] = new Option("Technical - SSC(Vocational)","Technical - SSC(Vocational)");
	elementBoard.options[12] = new Option("Others","Others");
	
	elementBoard.style.width = '120px';
	elementBoard.style.border="1px solid grey";
	elementBoard.style.textAlign = 'left';
 	elementBoard.tabIndex=eduTab+cnt[row]+4;
	
    var elementSubject = document.createElement("input");
	elementSubject.id = "subject"+cnt[row];
	elementSubject.setAttribute('maxlength',60);
	elementSubject.name = cnt[row];
	elementSubject.style.width = '120px';
	elementSubject.style.border="1px solid grey";
	elementSubject.style.textAlign = 'center';
	elementSubject.tabIndex=eduTab+cnt[row]+5;
	
	var elementGrade = document.createElement("input");
	elementGrade.id = "grade"+cnt[row];
	elementGrade.style.width = '100px';
	elementGrade.style.border="1px solid grey";
	elementGrade.style.textAlign = 'center';
	elementGrade.setAttribute('maxlength',60);
	elementGrade.name = cnt[row];
	elementGrade.tabIndex=eduTab+cnt[row]+6;
	
	var elementDelete = document.createElement("a");
	elementDelete.id = "delete"+cnt[row];
	elementDelete.href = "javascript:void(0)";
	elementDelete.innerHTML = "<font size=2>Delete</font>";
	elementDelete.value = cnt[row];
	elementDelete.tabIndex=eduTab+cnt[row]+7;
	
	if(window.addEventListener)
	{              //DOM compliant
	
	 elementDelete.addEventListener("click",function()
	                                        {
	                                          document.getElementById("degree"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column4"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column5"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column7"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column8"+elementDelete.value).style.display = 'none';
	                                          
	                                          return false;
	                                        },true);
	 }
	  else
	     {           //IE6 standards compliant mode
	     elementDelete.attachEvent("onclick",function()
	                                         {
	                                          document.getElementById("degree"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column4"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column5"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column7"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("column8"+elementDelete.value).style.display = 'none';

	                                          return false;
	                                         },true);
	     }
	
		
	

	table1 = document.getElementById("degreeTable");
	table1.style.border = '0px';
	newRow = table1.insertRow(table1.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementDegree);
	newRow.id = "column1"+cnt[row];

	 
	table2 = document.getElementById("yearTable");
	table2.style.border = '0px';
	newRow = table2.insertRow(table2.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementYear);
	newRow.id = "column2"+cnt[row];
	  
	table3 = document.getElementById("schoolTable");
	table3.style.border = '0px';
	newRow = table3.insertRow(table3.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementSchool);
	newRow.id = "column3"+cnt[row];
	
	table4 = document.getElementById("boardTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementBoard);
	newRow.id = "column4"+cnt[row];
	
	table5 = document.getElementById("subjectTable");
	table5.style.border = '0px';
	newRow = table5.insertRow(table5.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementSubject);
	newRow.id = "column5"+cnt[row];
/*	
	table6 = document.getElementById("countryTable");
	table6.style.border = '0px';
	newRow = table6.insertRow(table6.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementCountry);
	newRow.id = "column6"+cnt[row];
	
*/	
	table7 = document.getElementById("gradeTable");
	table7.style.border = '0px';
	newRow = table7.insertRow(table7.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementGrade);
	newRow.id = "column7"+cnt[row];				



	
	table4 = document.getElementById("deleteEducationTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	
	 
	newCell.appendChild(elementDelete);
	newRow.id = "column8"+cnt[row];
	 
	 
	 cnt[row]++;
	// document.getElementById("languageNumber").value=cnt[row];
	 return cnt[row];
 
} 
function addMoreLanguage()
{

    row=0;
 
	var elementLanguage = document.createElement("select");
	elementLanguage.id = "language"+cntt[row];
	elementLanguage.name = cntt[row];
	elementLanguage.options[0] = new Option("Select","select");
	elementLanguage.options[1] = new Option("Abenaki","Abenaki");
	elementLanguage.options[2] = new Option("Arabic","Arabic");
	elementLanguage.options[3] = new Option("Aramaic","Aramaic");
	elementLanguage.options[4] = new Option("Ayapathu","Ayapathu");
	elementLanguage.options[5] = new Option("Balinese","Balinese");
	elementLanguage.options[6] = new Option("Bangla","Bangla");
	elementLanguage.options[7] = new Option("Bobangi","Bobangi");
	elementLanguage.options[8] = new Option("Bulgarian","Bulgarian");
	elementLanguage.options[9] = new Option("Burmese","Burmese");
	elementLanguage.options[10] = new Option("Catalan","Catalan");
	elementLanguage.options[11] = new Option("Chinese","Chinese");
	elementLanguage.options[12] = new Option("Chinook","Chinook");
	elementLanguage.options[13] = new Option("Cree","Cree");
	elementLanguage.options[14] = new Option("Creole","Creole");
	elementLanguage.options[15] = new Option("Czech","Czech");
	elementLanguage.options[16] = new Option("Danish","Danish");
	elementLanguage.options[17] = new Option("Dutch","Dutch");
	elementLanguage.options[18] = new Option("Eggon","Eggon");
	elementLanguage.options[19] = new Option("English","English");
	elementLanguage.options[20] = new Option("Farsi","Farsi");
	elementLanguage.options[21] = new Option("French","French");
	elementLanguage.options[22] = new Option("Gaelic","Gaelic");
	elementLanguage.options[23] = new Option("German","German");
	elementLanguage.options[24] = new Option("Gothic","Gothic");
	elementLanguage.options[25] = new Option("Greek","Greek");
	elementLanguage.options[26] = new Option("Haida","Haida");
	elementLanguage.options[27] = new Option("Hindi","Hindi");
	elementLanguage.options[28] = new Option("Hungarian","Hungarian");
	elementLanguage.options[29] = new Option("Indonesian","Indonesian");
	elementLanguage.options[30] = new Option("Italian","Italian");
	
	elementLanguage.options[31] = new Option("Jangshung","Jangshung");
	elementLanguage.options[32] = new Option("Japanese","Japanese");
	elementLanguage.options[33] = new Option("Konkani","Konkani");
	elementLanguage.options[34] = new Option("Korean","Korean");
	elementLanguage.options[35] = new Option("Koyo","Koyo");
	elementLanguage.options[36] = new Option("Latin","Latin");
	elementLanguage.options[37] = new Option("Malagasy","Malagasy");
	elementLanguage.options[38] = new Option("Malay","Malay");
	elementLanguage.options[39] = new Option("Malayalam","Malayalam");
	
	
	elementLanguage.options[40] = new Option("Mayan","Mayan");
	elementLanguage.options[41] = new Option("Nahuatl","Nahuatl");
	elementLanguage.options[42] = new Option("Nande","Nande");
	elementLanguage.options[43] = new Option("Pidgin","Pidgin");
	elementLanguage.options[44] = new Option("Pirah","Pirah");
	elementLanguage.options[45] = new Option("Polish","Polish");
	elementLanguage.options[46] = new Option("Prussian","Prussian");
	elementLanguage.options[47] = new Option("Quechua","Quechua");
	elementLanguage.options[48] = new Option("Romanian","Romanian");
	elementLanguage.options[49] = new Option("Russian","Russian");
	elementLanguage.options[50] = new Option("Saanich","Saanich");
	elementLanguage.options[51] = new Option("Sign","Sign");
	elementLanguage.options[52] = new Option("Spanish","Spanish");
	
	
	elementLanguage.options[53] = new Option("Swedish","Swedish");
	elementLanguage.options[54] = new Option("Tagalog","Tagalog");
	elementLanguage.options[55] = new Option("Tamil","Tamil");
	elementLanguage.options[56] = new Option("Thai","Thai");
	elementLanguage.options[57] = new Option("Urdu","Urdu");
	elementLanguage.options[58] = new Option("Venda","Venda");
	elementLanguage.options[59] = new Option("Vietnamese","Vietnamese");
	elementLanguage.options[60] = new Option("Wagiman","Wagiman");
    elementLanguage.options[61] = new Option("Others","Others");


	elementLanguage.style.width = '200px';
	elementLanguage.style.textAlign = 'left';
	elementLanguage.style.border="1px solid grey";
	
	elementLanguage.tabIndex=lanTab+cntt[row]+1;
	
	var elementOral = document.createElement("select");
	elementOral.id = "oral"+cntt[row];
	elementOral.name = cnt[row];
	elementOral.options[0] = new Option("Select","select");
	elementOral.options[1] = new Option("Excellent","Excellent");
	elementOral.options[2] = new Option("Good","Good");
	elementOral.options[3] = new Option("Workable","Workable");
	elementOral.style.width = '180px';
	elementOral.style.textAlign = 'left';
	elementOral.style.border="1px solid grey";
	elementOral.tabIndex=lanTab+cntt[row]+2;


	var elementWriting = document.createElement("select");
	elementWriting.id = "writing"+cntt[row];
	elementWriting.name = cntt[row];
	elementWriting.options[0] = new Option("Select","select");
	elementWriting.options[1] = new Option("Excellent","Excellent");
	elementWriting.options[2] = new Option("Good","Good");
	elementWriting.options[3] = new Option("Workable","Workable");
	elementWriting.style.width = '180px';
	elementWriting.style.textAlign = 'left';
	elementWriting.style.border="1px solid grey";
	elementWriting.tabIndex=lanTab+cntt[row]+3;
	

var elementDelete = document.createElement("a");
elementDelete.id = "delete_lan"+cntt[row];
elementDelete.href = "javascript:void(0)";
elementDelete.innerHTML = "<font size=2>Delete</font>";
elementDelete.value = cntt[row];
elementDelete.tabIndex=lanTab+cntt[row]+4;

if(window.addEventListener)
{              //DOM compliant

 elementDelete.addEventListener("click",function()
                                        {
                                          document.getElementById("language"+elementDelete.value).style.display = 'none';
                                          document.getElementById("delete_lan"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column1"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column2"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column3"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column4"+elementDelete.value).style.display = 'none';
                                          return false;
                                        },true);
 }
  else
     {           //IE6 standards compliant mode
     elementDelete.attachEvent("onclick",function()
                                         {
                                          document.getElementById("language"+elementDelete.value).style.display = 'none';
                                          document.getElementById("delete_lan"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column1"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column2"+elementDelete.value).style.display = 'none';                                          
                                          document.getElementById("lan_column3"+elementDelete.value).style.display = 'none';
                                          document.getElementById("lan_column4"+elementDelete.value).style.display = 'none';
                                          return false;
                                         },true);
     }



 table1 = document.getElementById("languageTable");
 table1.style.border = '0px';
 newRow = table1.insertRow(table1.rows.length);
 newRow.style.border = '0px';
 newCell = newRow.insertCell(0);
 newCell.style.border = '0px';
 newCell.appendChild(elementLanguage);
 newRow.id = "lan_column1"+cntt[row];

 
table2 = document.getElementById("oralTable");
table2.style.border = '0px';
newRow = table2.insertRow(table2.rows.length);
newRow.style.border = '0px';
newCell = newRow.insertCell(0);
newCell.style.border = '0px';
newCell.appendChild(elementOral);
newRow.id = "lan_column2"+cntt[row];
  
table3 = document.getElementById("writingTable");
table3.style.border = '0px';
newRow = table3.insertRow(table3.rows.length);
newRow.style.border = '0px';
newCell = newRow.insertCell(0);
newCell.style.border = '0px';
newCell.appendChild(elementWriting);
newRow.id = "lan_column3"+cntt[row];

table4 = document.getElementById("deleteLanguageTable");
table4.style.border = '0px';
newRow = table4.insertRow(table4.rows.length);
newRow.style.border = '0px';
newCell = newRow.insertCell(0);
newCell.style.border = '0px';

 
newCell.appendChild(elementDelete);
newRow.id = "lan_column4"+cntt[row];
 
 
 cntt[row]++;
// document.getElementById("languageNumber").value=cnt[row];
 return cntt[row];
 
}



function defaultLanguageLoad()
{
    row=0;
 
	var elementLanguage = document.createElement("select");
	elementLanguage.id = "language"+cntt[row];
	elementLanguage.name = cntt[row];
	
	elementLanguage.options[0] = new Option("Select","select");
	elementLanguage.options[1] = new Option("Abenaki","Abenaki");
	elementLanguage.options[2] = new Option("Arabic","Arabic");
	elementLanguage.options[3] = new Option("Aramaic","Aramaic");
	elementLanguage.options[4] = new Option("Ayapathu","Ayapathu");
	elementLanguage.options[5] = new Option("Balinese","Balinese");
	elementLanguage.options[6] = new Option("Bangla","Bangla");
	elementLanguage.options[7] = new Option("Bobangi","Bobangi");
	elementLanguage.options[8] = new Option("Bulgarian","Bulgarian");
	elementLanguage.options[9] = new Option("Burmese","Burmese");
	elementLanguage.options[10] = new Option("Catalan","Catalan");
	elementLanguage.options[11] = new Option("Chinese","Chinese");
	elementLanguage.options[12] = new Option("Chinook","Chinook");
	elementLanguage.options[13] = new Option("Cree","Cree");
	elementLanguage.options[14] = new Option("Creole","Creole");
	elementLanguage.options[15] = new Option("Czech","Czech");
	elementLanguage.options[16] = new Option("Danish","Danish");
	elementLanguage.options[17] = new Option("Dutch","Dutch");
	elementLanguage.options[18] = new Option("Eggon","Eggon");
	elementLanguage.options[19] = new Option("English","English");
	elementLanguage.options[20] = new Option("Farsi","Farsi");
	elementLanguage.options[21] = new Option("French","French");
	elementLanguage.options[22] = new Option("Gaelic","Gaelic");
	elementLanguage.options[23] = new Option("German","German");
	elementLanguage.options[24] = new Option("Gothic","Gothic");
	elementLanguage.options[25] = new Option("Greek","Greek");
	elementLanguage.options[26] = new Option("Haida","Haida");
	elementLanguage.options[27] = new Option("Hindi","Hindi");
	elementLanguage.options[28] = new Option("Hungarian","Hungarian");
	elementLanguage.options[29] = new Option("Indonesian","Indonesian");
	elementLanguage.options[30] = new Option("Italian","Italian");
	
	elementLanguage.options[31] = new Option("Jangshung","Jangshung");
	elementLanguage.options[32] = new Option("Japanese","Japanese");
	elementLanguage.options[33] = new Option("Konkani","Konkani");
	elementLanguage.options[34] = new Option("Korean","Korean");
	elementLanguage.options[35] = new Option("Koyo","Koyo");
	elementLanguage.options[36] = new Option("Latin","Latin");
	elementLanguage.options[37] = new Option("Malagasy","Malagasy");
	elementLanguage.options[38] = new Option("Malay","Malay");
	elementLanguage.options[39] = new Option("Malayalam","Malayalam");
	
	
	elementLanguage.options[40] = new Option("Mayan","Mayan");
	elementLanguage.options[41] = new Option("Nahuatl","Nahuatl");
	elementLanguage.options[42] = new Option("Nande","Nande");
	elementLanguage.options[43] = new Option("Pidgin","Pidgin");
	elementLanguage.options[44] = new Option("Pirah","Pirah");
	elementLanguage.options[45] = new Option("Polish","Polish");
	elementLanguage.options[46] = new Option("Prussian","Prussian");
	elementLanguage.options[47] = new Option("Quechua","Quechua");
	elementLanguage.options[48] = new Option("Romanian","Romanian");
	elementLanguage.options[49] = new Option("Russian","Russian");
	elementLanguage.options[50] = new Option("Saanich","Saanich");
	elementLanguage.options[51] = new Option("Sign","Sign");
	elementLanguage.options[52] = new Option("Spanish","Spanish");
	
	
	elementLanguage.options[53] = new Option("Swedish","Swedish");
	elementLanguage.options[54] = new Option("Tagalog","Tagalog");
	elementLanguage.options[55] = new Option("Tamil","Tamil");
	elementLanguage.options[56] = new Option("Thai","Thai");
	elementLanguage.options[57] = new Option("Urdu","Urdu");
	elementLanguage.options[58] = new Option("Venda","Venda");
	elementLanguage.options[59] = new Option("Vietnamese","Vietnamese");
	elementLanguage.options[60] = new Option("Wagiman","Wagiman");
    elementLanguage.options[61] = new Option("Others","Others");
    
	elementLanguage.style.width = '200px';
	elementLanguage.style.textAlign = 'center';
	elementLanguage.style.border="1px solid grey";
	elementLanguage.tabIndex=lanTab+cntt[row]+1;
	
	var elementOral = document.createElement("select");
	elementOral.id = "oral"+cntt[row];
	elementOral.name = cntt[row];
	elementOral.options[0] = new Option("Select","select");
	elementOral.options[1] = new Option("Excellent","Excellent");
	elementOral.options[2] = new Option("Good","Good");
	elementOral.options[3] = new Option("Workable","Workable");
	elementOral.style.width = '180px';
	elementOral.style.border="1px solid grey";
	elementOral.style.textAlign = 'center';
	elementOral.tabIndex=lanTab+cntt[row]+2;


	var elementWriting = document.createElement("select");
	elementWriting.id = "writing"+cntt[row];
	elementWriting.name = cntt[row];
	elementWriting.options[0] = new Option("Select","select");
	elementWriting.options[1] = new Option("Excellent","Excellent");
	elementWriting.options[2] = new Option("Good","Good");
	elementWriting.options[3] = new Option("Workable","Workable");
	elementWriting.style.width = '180px';
	elementWriting.style.border="1px solid grey";
	elementWriting.style.textAlign = 'center';
	elementWriting.tabIndex=lanTab+cntt[row]+3;
	
		
	var elementDelete = document.createElement("a");
	elementDelete.id = "delete_lan"+cntt[row];
	elementDelete.href = "javascript:void(0)";
	elementDelete.innerHTML = "<font size=2>Delete</font>";
	elementDelete.value = cntt[row];
	elementDelete.tabIndex=lanTab+cntt[row]+4;
	
	if(window.addEventListener)
	{              //DOM compliant
	
	 elementDelete.addEventListener("click",function()
	                                        {
	                                          document.getElementById("language"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("delete_lan"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column4"+elementDelete.value).style.display = 'none';
	                                          return false;
	                                        },true);
	 }
	  else
	     {           //IE6 standards compliant mode
	     elementDelete.attachEvent("onclick",function()
	                                         {
	                                          document.getElementById("language"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("delete_lan"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column2"+elementDelete.value).style.display = 'none';                                          
	                                          document.getElementById("lan_column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("lan_column4"+elementDelete.value).style.display = 'none';
	                                          return false;
	                                         },true);
	     }
	
		
	

	table1 = document.getElementById("languageTable");
	table1.style.border = '0px';
	newRow = table1.insertRow(table1.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementLanguage);
	newRow.id = "lan_column1"+cntt[row];

	 
	table2 = document.getElementById("oralTable");
	table2.style.border = '0px';
	newRow = table2.insertRow(table2.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementOral);
	newRow.id = "lan_column2"+cntt[row];
	  
	table3 = document.getElementById("writingTable");
	table3.style.border = '0px';
	newRow = table3.insertRow(table3.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementWriting);
	newRow.id = "lan_column3"+cntt[row];
	
	table4 = document.getElementById("deleteLanguageTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	
	 
	newCell.appendChild(elementDelete);
	newRow.id = "lan_column4"+cntt[row];
	 
	 
	 cntt[row]++;
	// document.getElementById("languageNumber").value=cnt[row];
	 return cntt[row];
 
}



function deleteExperience(expNum)
{
 //alert(expNum);
 
    totalExpNum=totalExpNum-1;
//    alert(totalExpNum);
    document.getElementById("EXP").removeChild(document.getElementById(expNum));
    
 //alert("deleted:"+totalExpNum);
}


function addMoreExperience()
{
  //alert("added:"+totalExpNum);
  var  str =generateExpTable(totalExpNum);
  
  //alert(document.getElementById("EXP").innerHTML);
  //document.getElementById("EXP").innerHTML=document.getElementById("EXP").innerHTML+str;
  $("#EXP").append(str);
  totalExpNum=totalExpNum+1;
  
}
function generateExpTable(totalExpNum)
{

 var comNameInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(0,10)),10);
 var postHeldInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(1,10)),10);
 var serFromInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(2,10)),10);
 var serToInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(3,10)),10);
 var addressInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(4,10)),10);
 var phoneInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(5,10)),10);
 var personInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(6,10)),10);
 var emailInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(7,10)),10);
 var resInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(8,10)),10);
 var achivInd=parseInt(expTab)+parseInt((totalExpNum+""+parseInt(9,10)),10);
 
 var str="<div id='exp"+totalExpNum+"'><table width='100%' border='0' >"+ 
         " <tr bgcolor='#F2F7E3'> "+
         " <td colspan='4' height='35px' width='90%' align='left'>"+
         " &nbsp;&nbsp;<b>Work Experience</b>"+
         " </td>"+
         " <td align='right'  width='10%'>"+
         " <a href=#' tabindex='"+comNameInd+"' style='cursor: pointer;' border='0' onclick=\"deleteExperience('exp"+totalExpNum+"')\">&nbsp;&nbsp;Delete&nbsp;&nbsp;<a/> "+
         " </td>"+
         " </tr>"+
         " <tr>"+
         " <td width='20%' align='left' style='padding-left:10px;'>"+
         " Company Name<font color='red'>*</font>"+
         " </td>"+
         " <td width='30%' align='left'>"+
         " <input type='text' ID='COMPANY_NAME"+totalExpNum+"' style='width: 250px;border:1px solid grey;' maxlength='100' tabindex='"+comNameInd+"'  />"+
         " </td>"+
         " <td width='20%' align='left' style='padding-left:20px;'>"+
         " Post Held<font color='red'>*</font>"+
         " </td>"+
         " <td width='30%' align='left' >"+
         " <input type='text' ID='POSITION_HELD"+totalExpNum+"' style='width: 250px;border:1px solid grey;' maxlength='25' tabindex='"+postHeldInd+"'  />"+
         " </td>"+
         " </tr>"+
         " <tr>"+
         " <td align='left' style='padding-left:10px;'>"+
         " Serve From<font color='red'>*</font>"+
         " </td>"+
         " <td align='left'>"+
         " <input type='text' ID='SERVE_FROM"+totalExpNum+"'  style='width: 190px;border:1px solid grey;' tabindex='"+serFromInd+"' />&nbsp;&nbsp;<font color='maroon' size='1'>dd-mm-yyyy</font>"+
         " </td>"+
         " <td align='left' style='padding-left:20px;'>"+
         " Serve Till<font color='red'>*</font>"+
         " </td>"+
         " <td align='left'>"+
         " <input type='text' ID='SERVE_TILL"+totalExpNum+"' style='width: 150px;border:1px solid grey;' tabindex='"+serToInd+"' />"+
         " </td>"+
         " </tr>"+
         " <tr>"+
         " <td align='left' valign='top' style='padding-left:10px;'>"+
         " Address<font color='red'>*</font>"+
         " </td>"+
         " <td align='left'>"+
         " <textarea name='EXPERI_ADDRESS' id='EXPERI_ADDRESS"+totalExpNum+"' cols='30' rows='4' onkeypress='textCounter(this,150);' tabindex='"+addressInd+"' style='border:1px solid grey;'></textarea>"+
         " </td>"+
         " <td align='left'>"+
         " </td>"+
         " <td align='left'>"+
         " </td>"+
         " </tr>"+
          " <tr >"+
         " <td align='left' colspan='6' style='padding-left: 5px;' height='35px' valign='middle'>"+
         " <font color='red'>*</font>Indicates Mandatory Field."+
         " </td>"+
         " </tr>"+
         
         " </table>";

         return str;

}





function defaultTrainingLoad()
{
    row=0;
 
 
	var elementTrainingName = document.createElement("input");
	elementTrainingName.id = "trainingName"+cnt1[row];
	elementTrainingName.style.width = '180px';
	elementTrainingName.setAttribute('maxlength',40);
	elementTrainingName.style.border="1px solid grey";
	elementTrainingName.name = cnt1[row];
	elementTrainingName.tabIndex=trainTab+cnt1[row]+1;
	
	var elementTrainingFrom = document.createElement("input");
	elementTrainingFrom.id = "trainingFrom"+cnt1[row];
	elementTrainingFrom.style.width = '100px';
	elementTrainingFrom.setAttribute('maxlength',80);
	elementTrainingFrom.style.border="1px solid grey";
	elementTrainingFrom.name = cnt1[row];
	elementTrainingFrom.tabIndex=trainTab+cnt1[row]+2;
	
	var elementTrainingDuration = document.createElement("input");
	elementTrainingDuration.id = "trainingDuration"+cnt1[row];
	elementTrainingDuration.style.width = '100px';
	elementTrainingDuration.setAttribute('maxlength',10);
	elementTrainingDuration.style.border="1px solid grey";
	elementTrainingDuration.name = cnt1[row];
	elementTrainingDuration.tabIndex=trainTab+cnt1[row]+3;
	
	var elementTrainingDesc = document.createElement("input");
	elementTrainingDesc.id = "trainingDesc"+cnt1[row];
	elementTrainingDesc.style.width = '400px';
	elementTrainingDesc.style.border="1px solid grey";
	elementTrainingDesc.setAttribute('maxlength',200);
	elementTrainingDesc.name = cnt1[row];
	elementTrainingDesc.tabIndex=trainTab+cnt1[row]+4;
	
	var elementDelete = document.createElement("a");
	elementDelete.id = "train_delete"+cnt1[row];
	elementDelete.href = "javascript:void(0)";
	elementDelete.innerHTML = "<font size=2>Delete</font>";
	elementDelete.value = cnt1[row];
	elementDelete.tabIndex=trainTab+cnt1[row]+5;

	
	if(window.addEventListener)
	{              //DOM compliant
	
	 elementDelete.addEventListener("click",function()
	                                        {
	                                          document.getElementById("trainingName"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column4"+elementDelete.value).style.display = 'none';
	                                          return false;
	                                        },true);
	 }
	  else
	     {           //IE6 standards compliant mode
	     elementDelete.attachEvent("onclick",function()
	                                         {
	                                          document.getElementById("trainingName"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column2"+elementDelete.value).style.display = 'none';                                          
	                                          document.getElementById("train_column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column4"+elementDelete.value).style.display = 'none';
	                                          return false;
	                                         },true);
	     }
	
		
	

	table1 = document.getElementById("trainingNameTable");
	table1.style.border = '0px';
	newRow = table1.insertRow(table1.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingName);
	newRow.id = "train_column1"+cnt1[row];

//  alert(document.getElementById("trainingName0"));
	 
	table2 = document.getElementById("trainingFromTable");
	table2.style.border = '0px';
	newRow = table2.insertRow(table2.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingFrom);
	newRow.id = "train_column2"+cnt1[row];
	  
	table3 = document.getElementById("trainingDurationTable");
	table3.style.border = '0px';
	newRow = table3.insertRow(table3.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingDuration);
	newRow.id = "train_column3"+cnt1[row];
	
	table4 = document.getElementById("trainingDescTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingDesc);
	newRow.id = "train_column4"+cnt1[row];
	

	table5 = document.getElementById("deleteTrainingTable");
	table5.style.border = '0px';
	newRow = table5.insertRow(table5.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.style.textAlign = 'center';
	
	 
	newCell.appendChild(elementDelete);
	newRow.id = "train_column5"+cnt1[row];
	 
	 
	 cnt1[row]++;
	// document.getElementById("languageNumber").value=cnt[row];
	 return cnt1[row];
 
}

function addMoreTraining()
{
    row=0;
 
 
	var elementTrainingName = document.createElement("input");
	elementTrainingName.id = "trainingName"+cnt1[row];
	elementTrainingName.style.width = '180px';
	elementTrainingName.setAttribute('maxlength',100);
	elementTrainingName.style.border="1px solid grey";
	elementTrainingName.name = cnt1[row];
	elementTrainingName.tabIndex=trainTab+cnt1[row]+1;
	
	var elementTrainingFrom = document.createElement("input");
	elementTrainingFrom.id = "trainingFrom"+cnt1[row];
	elementTrainingFrom.style.width = '100px';
	elementTrainingFrom.setAttribute('maxlength',100);
	elementTrainingFrom.style.border="1px solid grey";
	elementTrainingFrom.name = cnt1[row];
	elementTrainingFrom.tabIndex=trainTab+cnt1[row]+2;
	
	var elementTrainingDuration = document.createElement("input");
	elementTrainingDuration.id = "trainingDuration"+cnt1[row];
	elementTrainingDuration.style.width = '100px';
	elementTrainingDuration.setAttribute('maxlength',10);
	elementTrainingDuration.style.border="1px solid grey";
	elementTrainingDuration.name = cnt1[row];
	elementTrainingDuration.tabIndex=trainTab+cnt1[row]+3;
	
	var elementTrainingDesc = document.createElement("input");
	elementTrainingDesc.id = "trainingDesc"+cnt1[row];
	elementTrainingDesc.style.width = '400px';
	elementTrainingDesc.setAttribute('maxlength',150);
	elementTrainingDesc.style.border="1px solid grey";
	elementTrainingDesc.name = cnt1[row];
	elementTrainingDesc.tabIndex=trainTab+cnt1[row]+4;
	

	
	var elementDelete = document.createElement("a");
	elementDelete.id = "train_delete"+cnt1[row];
	elementDelete.href = "javascript:void(0)";
	elementDelete.innerHTML = "<font size=2>Delete</font>";
	elementDelete.value = cnt1[row];
	elementDelete.tabIndex=trainTab+cnt1[row]+5;


	if(window.addEventListener)
	{              //DOM compliant
	
	 elementDelete.addEventListener("click",function()
	                                        {
	                                          document.getElementById("trainingName"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column2"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column4"+elementDelete.value).style.display = 'none';
	                                          return false;
	                                        },true);
	 }
	  else
	     {           //IE6 standards compliant mode
	     elementDelete.attachEvent("onclick",function()
	                                         {
	                                          document.getElementById("trainingName"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_delete"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column1"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column2"+elementDelete.value).style.display = 'none';                                          
	                                          document.getElementById("train_column3"+elementDelete.value).style.display = 'none';
	                                          document.getElementById("train_column4"+elementDelete.value).style.display = 'none';
	                                          return false;
	                                         },true);
	     }
	
		
	

	table1 = document.getElementById("trainingNameTable");
	table1.style.border = '0px';
	newRow = table1.insertRow(table1.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingName);
	newRow.id = "train_column1"+cnt1[row];

//  alert(document.getElementById("trainingName0"));
	 
	table2 = document.getElementById("trainingFromTable");
	table2.style.border = '0px';
	newRow = table2.insertRow(table2.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingFrom);
	newRow.id = "train_column2"+cnt1[row];
	  
	table3 = document.getElementById("trainingDurationTable");
	table3.style.border = '0px';
	newRow = table3.insertRow(table3.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingDuration);
	newRow.id = "train_column3"+cnt1[row];
	
	table4 = document.getElementById("trainingDescTable");
	table4.style.border = '0px';
	newRow = table4.insertRow(table4.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.appendChild(elementTrainingDesc);
	newRow.id = "train_column4"+cnt1[row];
	

	table5 = document.getElementById("deleteTrainingTable");
	table5.style.border = '0px';
	newRow = table5.insertRow(table5.rows.length);
	newRow.style.border = '0px';
	newCell = newRow.insertCell(0);
	newCell.style.border = '0px';
	newCell.style.textAlign = 'center';
	newCell.appendChild(elementDelete);
	newRow.id = "train_column5"+cnt1[row];

	 
	 
	 cnt1[row]++;
	// document.getElementById("languageNumber").value=cnt[row];
	 return cnt1[row];
 
}



