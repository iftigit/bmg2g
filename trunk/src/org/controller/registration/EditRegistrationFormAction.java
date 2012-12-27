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
		form_error="edit_form";
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


}
