package org.controller.registration;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.model.CaptchaManager;
import org.model.RegistrationDAO;
import org.singleton.RegistrationSingleton;
import org.table.AddressDTO;
import org.table.EducationDTO;
import org.table.ExperienceDTO;
import org.table.LanguageDTO;
import org.table.LogDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;
import org.table.TrainingDTO;
import org.table.TtcDTO;
import org.util.Utility;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistrationSubmitAction  extends ActionSupport{

	private static final long serialVersionUID = 3937606573865099216L;
	PersonalInfoDTO personalDTO;
	AddressDTO      addressDTO;
	NomineeDTO      nomineeDTO;
	
	AddressDAO addDAO = new AddressDAO();
	RegistrationDAO regDAO=new RegistrationDAO();
	LogDTO  logInfoDTO=new LogDTO();
	boolean error=false;
	private String rc;
	
	
@SuppressWarnings("unchecked")
public String execute() throws Exception 
	{		               
		
		PersonalInfoDTO duplicateSumissionCheck=(PersonalInfoDTO) ServletActionContext.getRequest().getSession().getAttribute("sessionObj_PersonalInfo");

		if(duplicateSumissionCheck==null)
		{
			return "blankForm";
		}

		
		
		if(RegistrationSingleton.avaiabilityCount(addressDTO.getpThana())<=0)
		{
			return "cotaEnd";
		}
		
		
	    logInfoDTO.setxForward(ServletActionContext.getRequest().getHeader("X-Forwarded-For"));
		logInfoDTO.setVia(ServletActionContext.getRequest().getHeader("Via"));
		logInfoDTO.setRemoteAddress(ServletActionContext.getRequest().getRemoteAddr());
		
		
        String registrationId="";
        registrationId=RegistrationSingleton.generateRegistrationId(addressDTO.getpDistrict(),personalDTO.getSex());
        String response=regDAO.insertEmpRegistrationInfo(registrationId,personalDTO,addressDTO,nomineeDTO,logInfoDTO);

        if(response.equalsIgnoreCase("success"))
        {
        	String decResponse=RegistrationSingleton.decreaseRegistrationCount(registrationId, addressDTO.getpDistrict(),addressDTO.getpThana());
        	ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",registrationId);
        	TtcDTO ttcDto=RegistrationSingleton.getInterviewInformation(addressDTO.getpDistrict());
        	int interviewUpdate=regDAO.updateInterviewInforamtion(registrationId, ttcDto.getTtcId(), ttcDto.getInterviewDate());
        	if(interviewUpdate==1)
        	{
        		int interviewDecrease=RegistrationSingleton.decreaseInterviewCount(ttcDto.getTtcId(), ttcDto.getInterviewDate());
        	}
        	
        	return "success";
        }
        else
        {
        	return null;
        }
        
        
	} //End of Method...

public void validate() 
{
	
    
	String submittedCode = personalDTO.getCaptchaText();
	CaptchaManager  cm=new CaptchaManager();
	boolean response=cm.validateCaptcha(rc, submittedCode, 2); //1 is for Registration Form
	//String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
	

	  
	if(response==false)
	{addFieldError( "Err_captchaError", " Please Write Correctly" );error=true;}
	else
		cm.validateCaptcha(rc);

	
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

	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}

	public PersonalInfoDTO getPersonalDTO() {
		return personalDTO;
	}
	
	public void setPersonalDTO(PersonalInfoDTO personalDTO) {
		this.personalDTO = personalDTO;
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

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}


}
