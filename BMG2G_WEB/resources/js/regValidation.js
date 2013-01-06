/**************!!!  Educational Information Validation !!!**********************/
function checkEducationalInformation()
{
  			var  degreeName;
            var  yearofPassing;
            var  schoolName;
            var  universityName;
            var  subject;
            var  grade;
            
            var  degreeName_Element;
            var  yearofPassing_Element;
            var  school_Element;
            var  universityName_Element;
            var  subject_Element;
            var  grade_Element;
            
            var educationHidden;
            var count =-1;

            educationHidden = document.getElementById("educationHidden");
            educationHidden.value = "";
            
            for(var j=0; j < cnt[0]; j++)
              {

                degreeName_Element = document.getElementById("degree"+j);
                yearofPassing_Element = document.getElementById("year"+j);
                school_Element = document.getElementById("school"+j);
                universityName_Element = document.getElementById("board"+j);
                subject_Element = document.getElementById("subject"+j);
                grade_Element = document.getElementById("grade"+j);

                
                if(degreeName_Element.style.display != 'none')
                {

                  degreeName = degreeName_Element.value;
                  yearofPassing = yearofPassing_Element.value;
                  schoolName = school_Element.value;
                  universityName= universityName_Element.value;
                  subject = subject_Element.value;
                  grade = grade_Element.value;
				  
				  
                  if(degreeName == 'select' || degreeName == 'select' ||  (schoolName=='' &&
                     universityName=='select') || subject=='select' || grade=='select')
                  {
                    //alert("One or more Educational Information is blank.");
                    return false;
                  }
                  if(schoolName=='')
                     schoolName='---';
                  educationHidden.value += degreeName+"88khayer88"+yearofPassing+"88khayer88"+schoolName+"88khayer88"+universityName+"88khayer88"+subject+"88khayer88"+grade+"99ifti99";
                }
              }
              
              //alert(educationHidden.value);
              
              return true;
            
}
         
/*``````````````````````````````````````````````````````````````````````````*/
/**************!!!  Experience Information Validation !!!**********************/
function checkExperienceInformation()
{
  			var  companyName;
            var  postHeld;
            var  serveFrom;
            var  serveTill;
            var  address;
            //var  phone;
            //var  contactPerson;
            //var  email;
            //var  responsibility;
            //var  achievement;
            
            
            var  companyName_Element;
            var  postHeld_Element;
            var  serveFrom_Element;
            var  serveTill_Element;
            var  address_Element;
            //var  phone_Element;
            //var  contactPerson_Element;
            //var  email_Element;
            //var  responsibility_Element;
            //var  achievement_Element;
            
            var experienceHidden;
            experienceHidden = document.getElementById("experienceHidden");
            experienceHidden.value = "";
            
            //alert(totalExpNum);
            
            for(var j=0; j < totalExpNum; j++)
              {
                companyName_Element = document.getElementById("COMPANY_NAME"+j);
                postHeld_Element = document.getElementById("POSITION_HELD"+j);
                serveFrom_Element = document.getElementById("SERVE_FROM"+j);
                serveTill_Element = document.getElementById("SERVE_TILL"+j);
                address_Element = document.getElementById("EXPERI_ADDRESS"+j);
                //phone_Element = document.getElementById("EXPERI_PHONE"+j);
                //contactPerson_Element = document.getElementById("EXPERI_CONT_PERSON_NAME"+j);
                //email_Element = document.getElementById("EXPERI_CONT_PERSON_EMAIL"+j);
                //responsibility_Element = document.getElementById("EXPERI_RESPON"+j);
                //achievement_Element = document.getElementById("EXPERI_ACHIEVEMENT"+j);

                if(companyName_Element)
                {
                
		            companyName=companyName_Element.value;
		            postHeld=postHeld_Element.value;
		            serveFrom=serveFrom_Element.value;
		            serveTill=serveTill_Element.value;
		            address=address_Element.value;
		            //phone=phone_Element.value;
		            //contactPerson=contactPerson_Element.value;
		            //email=email_Element.value;
		            //responsibility =responsibility_Element.value;
		            //achievement =achievement_Element.value;
				  
                  if(trim(companyName) == '' || trim(postHeld) == '' || trim(serveFrom)=='' || 
                     trim(serveTill)==''     || trim(address)==''     || trim(address)=='' 
                    )
                  {
                    //alert("One or more Experience Information is blank.");
                    return false;
                  }
                     
                     
experienceHidden.value += companyName+"88khayer88"+postHeld+"88khayer88"+serveFrom+"88khayer88"+serveTill+
                          "88khayer88"+address+"99ifti99";
                }
              }
              
              //alert(experienceHidden.value);
              
              return true;
            
}


/*````````````````````````````````````````````````````````````````*/
/**************!!!  Language Information !!!**********************/

function checkLanguageInformation()
{
            var  language;
            var  oral;
            var  writing;
            
            var  language_Element;
            var  oral_Element;
            var  writing_Element;

            var languageHidden;
            languageHidden = document.getElementById("languageHidden");
            languageHidden.value = "";
            
            for(var j=0; j < cntt[0]; j++)
              {
                language_Element = document.getElementById("language"+j);
                oral_Element = document.getElementById("oral"+j);
                writing_Element = document.getElementById("writing"+j);
                if(language_Element.style.display != 'none')
                {
                
		            language=language_Element.value;
		            oral=oral_Element.value;
		            writing=writing_Element.value;

                  if(trim(language) == 'select' || trim(oral) == 'select' || trim(writing)=='select')
                  {
                    //alert("One or more Language Information is blank.");
                    return false;
                  }
/*                  if(schoolName=='')
                     schoolName='---';
*/                     
					languageHidden.value += language+"88khayer88"+oral+"88khayer88"+writing+"99ifti99";
                }
              }
              
              
              return true;
}
/*```````````````````````````````````````````````````````````````*/


/*````````````````````````````````````````````````````````````````*/
/**************!!!  Training Information !!!**********************/

function checkTrainingInformation()
{
            var  trainingName;
            var  trainingFrom;
            var  trainingDuration;
            var  trainingDesc;
            
            
            var  trainingName_Element;
            var  trainingFrom_Element;
            var  trainingDuration_Element;
            var  trainingDesc_Element;
            

            var trainingHidden;
            trainingHidden = document.getElementById("trainingHidden");
            trainingHidden.value = "";
            
            
            for(var j=0; j < cnt1[0]; j++)
              {
                trainingName_Element = document.getElementById("trainingName"+j);
                trainingFrom_Element = document.getElementById("trainingFrom"+j);
                trainingDuration_Element = document.getElementById("trainingDuration"+j);
                trainingDesc_Element = document.getElementById("trainingDesc"+j);
                 
                if(trainingName_Element.style.display != 'none')
                {
                
		            trainingName=trainingName_Element.value;
		            trainingFrom=trainingFrom_Element.value;
		            trainingDuration=trainingDuration_Element.value;
		            trainingDesc=trainingDesc_Element.value;

                  if(trim(trainingName) == '' || trim(trainingFrom) == '' || trim(trainingDuration)==''||
					 trim(trainingDesc) == ''	                     
                    )
                  {
                    //alert("One or more Training Information is blank.");
                    return false;
                  }
/*                  if(schoolName=='')
                     schoolName='---';
*/                     
					trainingHidden.value += trainingName+"88khayer88"+trainingFrom+"88khayer88"+trainingDuration+"88khayer88"+trainingDesc+"99ifti99";
                }
              }
              
              //alert(trainingHidden.value);
              
              return true;
}

function checkSubCategory(value)
{
//alert(value);
	document.getElementById("DESIREDJOBSUBCAT1").options.length = 0;
	addOption("DESIREDJOBSUBCAT1","--Select Sub Category--","select");
	if(value=="Agriculture")
	{
		addOption("DESIREDJOBSUBCAT1","Agriculture labor","Agriculture labor");
		addOption("DESIREDJOBSUBCAT1","Fisher man","Fisher man");
		addOption("DESIREDJOBSUBCAT1","Flower Nursery","Flower Nursery");
		addOption("DESIREDJOBSUBCAT1","Vegetable gardening","Vegetable gardening");
		addOption("DESIREDJOBSUBCAT1","Others","Others");						
	}
	if(value=="Manufacturing")
	{
		addOption("DESIREDJOBSUBCAT1","Factory worker","Factory worker");
		addOption("DESIREDJOBSUBCAT1","Machine Tools Operator","Machine Tools Operator");
		addOption("DESIREDJOBSUBCAT1","Garments worker","Garments worker");
		addOption("DESIREDJOBSUBCAT1","Mechanics","Mechanics");						
		addOption("DESIREDJOBSUBCAT1","Others","Others");		
	}
	if(value=="Construction")
	{
		addOption("DESIREDJOBSUBCAT1","Masson","Masson");
		addOption("DESIREDJOBSUBCAT1","Rod binder","Rod binder");
		addOption("DESIREDJOBSUBCAT1","Pipe fitter","Pipe fitter");
		addOption("DESIREDJOBSUBCAT1","Electrician","Electrician");						
		addOption("DESIREDJOBSUBCAT1","Carpenter","Carpenter");
		addOption("DESIREDJOBSUBCAT1","Painter","Painter");
		addOption("DESIREDJOBSUBCAT1","Still fixture","Still fixture");
		addOption("DESIREDJOBSUBCAT1","Tiles fixture","Tiles fixture");
		addOption("DESIREDJOBSUBCAT1","Welder","Welder");
		addOption("DESIREDJOBSUBCAT1","Others","Others");									
	}
	if(value=="Service")
	{
		addOption("DESIREDJOBSUBCAT1","Driver","Driver");
		addOption("DESIREDJOBSUBCAT1","Hotel boy","Hotel boy");
		addOption("DESIREDJOBSUBCAT1","Cleaner","Cleaner");
		addOption("DESIREDJOBSUBCAT1","Cook","Cook");						
		addOption("DESIREDJOBSUBCAT1","Computer operator","Computer operator");
		addOption("DESIREDJOBSUBCAT1","Sales man","Sales man");
		addOption("DESIREDJOBSUBCAT1","Security Guard","Security Guard");
		addOption("DESIREDJOBSUBCAT1","Others","Others");								
	}
}

function addOption(selectID, display, value)
{
  var obj = document.getElementById(selectID);
  obj.options[obj.options.length] = new Option(display, value);
}