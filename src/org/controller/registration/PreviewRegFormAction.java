package org.controller.registration;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.singleton.RegistrationSingleton;
import org.table.AddressDTO;
import org.table.EducationDTO;
import org.table.ExperienceDTO;
import org.table.LanguageDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;
import org.table.TrainingDTO;
import org.util.Utility;

import com.opensymphony.xwork2.ActionSupport;

public class PreviewRegFormAction extends ActionSupport{
	
	private static final long serialVersionUID = -4949680482269443391L;
	PersonalInfoDTO personalDTO;
	AddressDTO      addressDTO;
	NomineeDTO      nomineeDTO;
	AddressDAO addDAO = new AddressDAO();

	private String educationHidden="";
	private String languageHidden="";
	private String experienceHidden="";
	private String trainingHidden="";
	boolean error=false;
	
	public String execute() throws Exception {

		System.out.println("In Preview Action ...");
//		if(RegistrationSingleton.avaiabilityCount(Integer.parseInt(addressDTO.getpDistrict()))<=0)
//		{
//			return "cotaEnd";
//		}

	    return SUCCESS;	
	    }
	
	public void validate() 
	{
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_PersonalInfo", personalDTO);
		/** ==Educational Information ==*/
		/*-----------------------------*/
		String allRows = this.educationHidden;
		System.out.println("Education String:"+allRows);
		ArrayList<EducationDTO> eduList=new ArrayList<EducationDTO>();
		if(!allRows.equals(""))
		{
		String[] allEducations=allRows.split("99ifti99");
		for(int i=0;i<allEducations.length;i++)
		{
			String[] temp=new String[6];
			String hold=allEducations[i];
			EducationDTO eduDTO=new EducationDTO();
			temp=hold.split("88khayer88");
			eduDTO.setDegreeName(temp[0]);
			eduDTO.setPassingYear(temp[1]);
			eduDTO.setSchool(temp[2]);
			eduDTO.setUniversity(temp[3]);
			eduDTO.setSubject(temp[4]);
			eduDTO.setGrade(temp[5]);
			
			if(temp[0].equals("select") || temp[1].equals("select") || temp[2].equals("select") ||
					temp[3].equals("select")|| temp[4].equals("select") || temp[5].equals("select") 
					)
			{
				addFieldError( "Err_Education", " One or More Education Information is blank." );
				error=true;
			}
			eduList.add(eduDTO);

		}
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_EducationInfo", eduList);
		}
		else
		 ServletActionContext.getRequest().getSession().setAttribute("sessionObj_EducationInfo", new ArrayList<EducationDTO>());

		/** ==Language Information ==*/
		/*-----------------------------*/
		allRows = this.languageHidden;
		System.out.println("Language String:"+allRows);
		ArrayList<LanguageDTO> languageList=new ArrayList<LanguageDTO>();
		if(!allRows.equals(""))
		{
		String[] allLanguages=allRows.split("99ifti99");
		for(int i=0;i<allLanguages.length;i++)
		{
			String[] tempLng=new String[3];
			String hold=allLanguages[i];
			LanguageDTO lngDTO=new LanguageDTO();
			tempLng=hold.split("88khayer88");
			lngDTO.setLanguage(tempLng[0]);
			lngDTO.setOralSkill(tempLng[1]);
			lngDTO.setWritingSkill(tempLng[2]);
			
			if(tempLng[0].equals("select") || tempLng[1].equals("select") || tempLng[2].equals("select")
			  )
			{
				addFieldError( "Err_Language", " One or More Language Information is blank." );error=true;
			}
			languageList.add(lngDTO);

		}
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_LanguageInfo", languageList);
		}
		else
	    ServletActionContext.getRequest().getSession().setAttribute("sessionObj_LanguageInfo", new ArrayList<LanguageDTO>());
		
		/** ==Experience Information ==*/
		/*-----------------------------*/
		allRows = this.experienceHidden;
		System.out.println("Experience String:"+allRows);
		ArrayList<ExperienceDTO> experienceList=new ArrayList<ExperienceDTO>();
		if(!allRows.equals(""))
		{
		String[] allExperience=allRows.split("99ifti99");
		for(int i=0;i<allExperience.length;i++)
		{
			String[] tempExp=new String[10];
			String hold=allExperience[i];
			ExperienceDTO expDTO=new ExperienceDTO();
			tempExp=hold.split("88khayer88");
			expDTO.setCompanyName(tempExp[0]);
			expDTO.setPosition(tempExp[1]);
			expDTO.setServeFrom(tempExp[2]);
			expDTO.setServeTill(tempExp[3]);
			expDTO.setAddress(tempExp[4].replaceAll("\n", " ").replaceAll("\r", ""));
			
			if(Utility.isValidDate(tempExp[2],"dd-MM-yyyy","-")==false)
			{
				addFieldError( "Err_Experience", " Correct Serve From Date Format." );error=true;
			}
			
			if(tempExp[0].equals("") || tempExp[1].equals("") || tempExp[2].equals("") ||
			   tempExp[3].equals("") || tempExp[4].equals("")
					
			  )
			{
				addFieldError( "Err_Experience", " One or More Experience is blank." );error=true;
			}
			experienceList.add(expDTO);

		}
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_ExperienceInfo", experienceList);
		}
		else
		    ServletActionContext.getRequest().getSession().setAttribute("sessionObj_ExperienceInfo", new ArrayList<ExperienceDTO>());

		
		/** ==Training  Information ==*/
		/*-----------------------------*/
		
		allRows = this.trainingHidden;
		System.out.println("Training String:"+allRows);
		ArrayList<TrainingDTO> trainingList=new ArrayList<TrainingDTO>();
		if(!allRows.equals(""))
		{
		String[] allTraining=allRows.split("99ifti99");
		for(int i=0;i<allTraining.length;i++)
		{
			String[] tempTrain=new String[3];
			String hold=allTraining[i];
			TrainingDTO trainDTO=new TrainingDTO();
			tempTrain=hold.split("88khayer88");
			trainDTO.setTrainingName(tempTrain[0]);
			trainDTO.setFromWhere(tempTrain[1]);
			trainDTO.setDuration(tempTrain[2]);
			trainDTO.setDescription(tempTrain[3]);
			
			if(tempTrain[0].trim().equals("") || tempTrain[1].trim().equals("") || tempTrain[2].trim().equals("") ||
			   tempTrain[0].trim().equals("")	
			  )
			{
				addFieldError( "Err_Training", " One or More Training Information is blank." );error=true;
			}
			trainingList.add(trainDTO);

		}
		
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_TrainingInfo", trainingList);
		}
		
		else
		    ServletActionContext.getRequest().getSession().setAttribute("sessionObj_TrainingInfo", new ArrayList<TrainingDTO>());

		/*=================Id to Name Conversion for Address ====================*/
		String pDivisionName=(String) getServletContext().getAttribute("DIV_NAME_FROM_ID"+addressDTO.getpDivision());
		if(pDivisionName==null)
		{			
			pDivisionName = addDAO.getDivisionNameFromId(Integer.valueOf(addressDTO.getpDivision()));			
			getServletContext().setAttribute("DIV_NAME_FROM_ID"+addressDTO.getpDivision(),pDivisionName);
		}
		addressDTO.setpDivisionName(pDivisionName);

		String mDivisionName=(String) getServletContext().getAttribute("DIV_NAME_FROM_ID"+addressDTO.getmDivision());
		if(mDivisionName==null)
		{			
			mDivisionName = addDAO.getDivisionNameFromId(Integer.valueOf(addressDTO.getmDivision()));			
			getServletContext().setAttribute("DIV_NAME_FROM_ID"+addressDTO.getmDivision(),mDivisionName);
		}
		addressDTO.setmDivisionName(mDivisionName);
		
		String pDistrictName=(String) getServletContext().getAttribute("DIS_NAME_FROM_ID"+addressDTO.getpDistrict());
		if(pDistrictName==null)
		{			
			pDistrictName = addDAO.getDistrictNameFromId(Integer.valueOf(addressDTO.getpDistrict()));			
			getServletContext().setAttribute("DIV_NAME_FROM_ID"+addressDTO.getpDistrict(),pDistrictName);
		}
		addressDTO.setpDistrictName(pDistrictName);

		String mDistrictName=(String) getServletContext().getAttribute("DIS_NAME_FROM_ID"+addressDTO.getmDistrict());
		if(mDistrictName==null)
		{			
			mDistrictName = addDAO.getDistrictNameFromId(Integer.valueOf(addressDTO.getmDistrict()));			
			getServletContext().setAttribute("DIV_NAME_FROM_ID"+addressDTO.getmDistrict(),mDistrictName);
		}
		addressDTO.setmDistrictName(mDistrictName);
		
		String pThanaName=(String) getServletContext().getAttribute("THANA_NAME_FROM_ID"+addressDTO.getpThana());
		if(pThanaName==null)
		{			
			pThanaName = addDAO.getThanaNameFromId(addressDTO.getpThana());			
			getServletContext().setAttribute("THANA_NAME_FROM_ID"+addressDTO.getpThana(),pThanaName);
		}
		addressDTO.setpThanaName(pThanaName);
		
		String mThanaName=(String) getServletContext().getAttribute("THANA_NAME_FROM_ID"+addressDTO.getmThana());
		if(mThanaName==null)
		{			
			mThanaName = addDAO.getThanaNameFromId(addressDTO.getmThana());			
			getServletContext().setAttribute("THANA_NAME_FROM_ID"+addressDTO.getpThana(),mThanaName);
		}
		addressDTO.setmThanaName(mThanaName);

		
		
		
		/*=================End of Address ====================*/
		
		
		ServletActionContext.getRequest().getSession().setAttribute("sub_NomineeAddress", nomineeDTO.getNomineeAddress().replaceAll("\n", "<br>"));
 	    ServletActionContext.getRequest().getSession().setAttribute("sessionObj_NomineeInfo", nomineeDTO);	    
 	    ServletActionContext.getRequest().getSession().setAttribute("sessionObj_AddressInfo", addressDTO);
	    
//		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
//		String submittedCode = personalDTO.getCaptchaText();

		  
//		if(!generatedCode.equals(submittedCode))
//		{addFieldError( "Err_captchaError", " Please Write Correctly" );error=true;}
//		
		
		checkErrorStatus();
	
	}
	
	public String checkErrorStatus()
	{
	    if(error)
	    {
			
	    	ServletActionContext.getRequest().getSession().setAttribute("form_error", "form_error");
		return "input";
	    }
	    else
	    {
			return "SUCCESS";
	    }
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public NomineeDTO getNomineeDTO() {
		return nomineeDTO;
	}

	public void setNomineeDTO(NomineeDTO nomineeDTO) {
		this.nomineeDTO = nomineeDTO;
	}

	public String getEducationHidden() {
		return educationHidden;
	}

	public void setEducationHidden(String educationHidden) {
		this.educationHidden = educationHidden;
	}

	public String getLanguageHidden() {
		return languageHidden;
	}

	public void setLanguageHidden(String languageHidden) {
		this.languageHidden = languageHidden;
	}

	public String getExperienceHidden() {
		return experienceHidden;
	}

	public void setExperienceHidden(String experienceHidden) {
		this.experienceHidden = experienceHidden;
	}

	public String getTrainingHidden() {
		return trainingHidden;
	}

	public void setTrainingHidden(String trainingHidden) {
		this.trainingHidden = trainingHidden;
	}

	public PersonalInfoDTO getPersonalDTO() {
		return personalDTO;
	}

	public void setPersonalDTO(PersonalInfoDTO personalDTO) {
		this.personalDTO = personalDTO;
	}
	

	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}
	
}
