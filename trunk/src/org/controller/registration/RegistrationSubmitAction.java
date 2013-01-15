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
	
		PersonalInfoDTO duplicateSumissionCheck=(PersonalInfoDTO) ServletActionContext.getRequest().getSession().getAttribute("sessionObj_PersonalInfo");
		String localIp=ServletActionContext.getRequest().getHeader("X-Forwarded-For")==null?"":ServletActionContext.getRequest().getHeader("X-Forwarded-For");
		String via=ServletActionContext.getRequest().getHeader("Via")==null?"":ServletActionContext.getRequest().getHeader("Via");
		String realIp=ServletActionContext.getRequest().getRemoteAddr()==null?"":ServletActionContext.getRequest().getRemoteAddr();
		String submittedAuthKey=localIp+via+realIp;
		
		UserDTO loggedInUser=(UserDTO) ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		if(duplicateSumissionCheck==null)
		{
			return "blankForm";
		}
		else if(!loggedInUser.getAuthenticationKey().equalsIgnoreCase(submittedAuthKey) && !loggedInUser.getUserType().equalsIgnoreCase("UISC_REG_OPERATOR"))
		{
			return "logout";
		}
		else if(loggedInUser.getAccessRight()==0)
		{
			return "timeOver";	
		}
		
		String submittedCode = personalDTO.getCaptchaText();
		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
		
		if(!submittedCode.equalsIgnoreCase(generatedCode))
		{addFieldError( "Err_captchaError", " Please Write Correctly" );error=true;}
		else
			ServletActionContext.getRequest().getSession().setAttribute("captchaText",PassPhrase.getNext());
		if(error)
	    {		
	    	ServletActionContext.getRequest().getSession().setAttribute("form_error", "form_error");
	    	return "input";
	    }
		
		String messages="";
		
		
		if(personalDTO.getEmpFname()==null || personalDTO.getEmpFname().equalsIgnoreCase("") )
		{
			messages+="* Jobseeker's First Name cannot be blank.";			
		}
		if(personalDTO.getFatherName()==null||personalDTO.getFatherName().equalsIgnoreCase(""))
		{
			messages+="* Father Name cannot be blank.";			
		}
		if(personalDTO.getMotherName()==null || personalDTO.getMotherName().equalsIgnoreCase("") )
		{
			messages+="* Mother Name cannot be blank.";			
		}
		if(personalDTO.getBirthDate()==null || personalDTO.getBirthDate().equalsIgnoreCase(""))
		{
			messages+="* Birth Date cannot be blank.";			
		}
		if(personalDTO.getWeight()==null || personalDTO.getWeight().equalsIgnoreCase(""))
		{
			messages+="* Weight cannot be blank.";			
		}
		if(personalDTO.getHeightFeet()==null || personalDTO.getHeightFeet().equalsIgnoreCase(""))
		{
			messages+="* Height Feet cannot be blank.";			
		}
		if(personalDTO.getReligion()==null || personalDTO.getReligion().equalsIgnoreCase("select"))
		{
			messages+="* Please select your religion.";			
		}
		if(addressDTO.getpThana()==null || addressDTO.getpThana().equalsIgnoreCase("select"))
		{
			messages+="* Please select Permanent Address Upazilla Correctly.";			
		}
		if(addressDTO.getmThana()==null || addressDTO.getmThana().equalsIgnoreCase("select"))
		{
			messages+="* Please select Mailing Address Upazilla Correctly.";			
		}
		if(addressDTO.getPUnion()==null || addressDTO.getPUnion().equalsIgnoreCase("select"))
		{
			messages+="* Please select Permanent Address Union Correctly.";			
		}
		if(addressDTO.getMUnion()==null || addressDTO.getMUnion().equalsIgnoreCase("select"))
		{
			messages+="* Please select Mailing Address Union Correctly.";			
		}
		
		if( nomineeDTO.getNomineeName()==null || nomineeDTO.getNomineeName().equalsIgnoreCase(""))
		{
			messages+="* Nominee Name cannot be blank.";			
		}
		if(nomineeDTO.getNomineeRelation()==null || nomineeDTO.getNomineeRelation().equalsIgnoreCase("none"))
		{
			messages+="* Please select Nominee Religion.";			
		}
		if(nomineeDTO.getNomineeAddress()==null || nomineeDTO.getNomineeAddress().equalsIgnoreCase(""))
		{
			messages+="* Please provide nominee's address.";			
		}
		if(nomineeDTO.getNomineePhone()==null || nomineeDTO.getNomineePhone().equalsIgnoreCase(""))
		{
			messages+="* Please provide nominee's phone number.";			
		}
		if(nomineeDTO.getContactName()==null || nomineeDTO.getContactName().equalsIgnoreCase(""))
		{
			messages+="* Please provide contact person name.";			
		}
		if(nomineeDTO.getContactMobile()==null || nomineeDTO.getContactMobile().equalsIgnoreCase(""))
		{
			messages+="* Please provide contact person mobile number.";			
		}
		
		if(!messages.equalsIgnoreCase(""))
		{addFieldError( "Common_Messages", " Please Correct the following errors. \n"+messages );error=true;}
		
		if(error)
	    {		
	    	ServletActionContext.getRequest().getSession().setAttribute("form_error", "form_error");
	    	return "registrationHome";
	    }
		
	    logInfoDTO.setxForward(ServletActionContext.getRequest().getHeader("X-Forwarded-For"));
		logInfoDTO.setVia(ServletActionContext.getRequest().getHeader("Via"));
		logInfoDTO.setRemoteAddress(ServletActionContext.getRequest().getRemoteAddr());
		
		UserDTO operator=(UserDTO)ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		personalDTO.setCotaUnionId(operator.getUnionId());
		
        String registrationId="";
        registrationId=RegistrationSingleton.generateRegistrationId(addressDTO.getpDistrict(),personalDTO.getSex());
        String response=regDAO.insertEmpRegistrationInfo(registrationId,personalDTO,addressDTO,nomineeDTO,logInfoDTO,loggedInUser.getUserId());

        if(response.equalsIgnoreCase("success"))
        {
        	ServletActionContext.getRequest().getSession().setAttribute("sessionObj_regId",registrationId);
        	personalDTO=null;
        	addressDTO=null;
        	nomineeDTO=null;
        	ServletActionContext.getRequest().getSession().setAttribute("sessionObj_PersonalInfo",null);
        	return "success";
        }
        else
        {
        	addFieldError( "Err_RegSubmit", response);        	
        	return "input";
        }
        
        
	} //End of Method...




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
