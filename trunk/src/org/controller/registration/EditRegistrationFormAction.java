package org.controller.registration;
import org.apache.struts2.ServletActionContext;
import org.table.AddressDTO;
import org.table.NomineeDTO;
import org.table.PersonalInfoDTO;


public class EditRegistrationFormAction {
	
	PersonalInfoDTO personalDTO;
	AddressDTO      addressDTO;
	NomineeDTO      nomineeDTO;
	private String form_error;

	
public String execute() {

	    PersonalInfoDTO duplicateSumissionCheck=(PersonalInfoDTO) ServletActionContext.getRequest().getSession().getAttribute("sessionObj_PersonalInfo");
	
		if(duplicateSumissionCheck==null)
		{
			return "blankForm";
		}

		
		ServletActionContext.getRequest().getSession().setAttribute("form_error", "edit_form");
		return "success";
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


	public String getForm_error() {
		return form_error;
	}


	public void setForm_error(String formError) {
		form_error = formError;
	}


}
