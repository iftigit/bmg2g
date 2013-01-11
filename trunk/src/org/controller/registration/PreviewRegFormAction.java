package org.controller.registration;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.model.AddressDAO;
import org.model.CaptchaManager;
import org.singleton.RegistrationSingleton;
import org.table.AddressDTO;
import org.table.EducationDTO;
import org.table.ExperienceDTO;
import org.table.LanguageDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;
import org.table.TrainingDTO;
import org.util.PassPhrase;
import org.util.Utility;

import com.opensymphony.xwork2.ActionSupport;

public class PreviewRegFormAction extends ActionSupport{
	
	private static final long serialVersionUID = -4949680482269443391L;
	PersonalInfoDTO personalDTO;
	AddressDTO      addressDTO;
	NomineeDTO      nomineeDTO;
	AddressDAO addDAO = new AddressDAO();
	private String sub_NomineeAddress;
	private String rc;

	boolean error=false;
	
	public String execute() throws Exception 
	{

		System.out.println("In Preview Action ...");
	    return SUCCESS;	
	}
	
	public void validate() 
	{
		ServletActionContext.getRequest().getSession().setAttribute("sessionObj_PersonalInfo", personalDTO);

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
		
		
		String pUnionName=(String) getServletContext().getAttribute("UNION_NAME_FROM_ID"+addressDTO.getPUnion());
		if(pUnionName==null)
		{			
			pUnionName = addDAO.getUnionNameFromId(addressDTO.getPUnion());			
			getServletContext().setAttribute("UNION_NAME_FROM_ID"+addressDTO.getpThana(),pUnionName);
		}
		addressDTO.setPUnionName(pUnionName);
		
		String mUnionName=(String) getServletContext().getAttribute("UNION_NAME_FROM_ID"+addressDTO.getMUnion());
		if(mUnionName==null)
		{			
			mUnionName = addDAO.getUnionNameFromId(addressDTO.getMUnion());			
			getServletContext().setAttribute("UNION_NAME_FROM_ID"+addressDTO.getpThana(),mUnionName);
		}
		addressDTO.setMUnionName(mUnionName);

    	//nomineeDTO.setNomineeAddress(nomineeDTO.getNomineeAddress().replaceAll("\n", "<br>"));
    	sub_NomineeAddress=nomineeDTO.getNomineeAddress().replaceAll("\n", "<br>");		
		
		
		/*=================End of Address ====================*/
		String submittedCode = personalDTO.getCaptchaText();
		String generatedCode = (String) ServletActionContext.getRequest().getSession().getAttribute("captchaText");
		  
		if(!submittedCode.equalsIgnoreCase(generatedCode))
		{addFieldError( "Err_captchaError", " Please Write Correctly" );error=true;}
		else
		{
			ServletActionContext.getRequest().getSession().setAttribute("captchaText",PassPhrase.getNext());
			
		}
		
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

	
	public PersonalInfoDTO getPersonalDTO() {
		return personalDTO;
	}

	public void setPersonalDTO(PersonalInfoDTO personalDTO) {
		this.personalDTO = personalDTO;
	}
	

	public String getSub_NomineeAddress() {
		return sub_NomineeAddress;
	}

	public void setSub_NomineeAddress(String subNomineeAddress) {
		sub_NomineeAddress = subNomineeAddress;
	}

	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}


	
}
