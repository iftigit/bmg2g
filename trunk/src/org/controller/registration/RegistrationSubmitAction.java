package org.controller.registration;


import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.model.RegistrationDAO;
import org.singleton.RegistrationSingleton;
import org.table.AddressDTO;
import org.table.LogDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;
import org.table.TtcDTO;
import org.table.UserDTO;
import org.util.PassPhrase;

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

	
@SuppressWarnings("unchecked")
public String execute() throws Exception 
	{		               
		
//		PersonalInfoDTO duplicateSumissionCheck=(PersonalInfoDTO) ServletActionContext.getRequest().getSession().getAttribute("sessionObj_PersonalInfo");
//
//		if(duplicateSumissionCheck==null)
//		{
//			return "blankForm";
//		}

		
		
//		if(RegistrationSingleton.avaiabilityCount(addressDTO.getpThana())<=0)
//		{
//			return "cotaEnd";
//		}
		
		
	    logInfoDTO.setxForward(ServletActionContext.getRequest().getHeader("X-Forwarded-For"));
		logInfoDTO.setVia(ServletActionContext.getRequest().getHeader("Via"));
		logInfoDTO.setRemoteAddress(ServletActionContext.getRequest().getRemoteAddr());
		
		UserDTO operator=(UserDTO)ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		personalDTO.setCotaUnionId(operator.getUnionId());
		
        String registrationId="";
        registrationId=RegistrationSingleton.generateRegistrationId(addressDTO.getpDistrict(),personalDTO.getSex());
        String response=regDAO.insertEmpRegistrationInfo(registrationId,personalDTO,addressDTO,nomineeDTO,logInfoDTO);

        if(response.equalsIgnoreCase("success"))
        {
        	//String decResponse=RegistrationSingleton.decreaseRegistrationCount(registrationId, addressDTO.getpDistrict(),addressDTO.getpThana());
        	ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",registrationId);
        	//TtcDTO ttcDto=RegistrationSingleton.getInterviewInformation(addressDTO.getpDistrict());
        	//int interviewUpdate=regDAO.updateInterviewInforamtion(registrationId, ttcDto.getTtcId(), ttcDto.getInterviewDate());
        	//if(interviewUpdate==1)
        	//{
        	//	int interviewDecrease=RegistrationSingleton.decreaseInterviewCount(ttcDto.getTtcId(), ttcDto.getInterviewDate());
        	//}
        	
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
	//CaptchaManager  cm=new CaptchaManager();
	//boolean response=cm.validateCaptcha(rc, submittedCode, 2); //1 is for Registration Form
	String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
	
//	if(!submittedCode.equalsIgnoreCase(generatedCode))
//	{addFieldError( "Err_captchaError", " Please Write Correctly" );error=true;}
//	else
//	{
//		ServletActionContext.getRequest().getSession().setAttribute("captchaText",PassPhrase.getNext());
//		
//	}
	
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



}
