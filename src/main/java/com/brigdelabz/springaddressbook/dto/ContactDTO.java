package com.brigdelabz.springaddressbook.dto;

import javax.validation.constraints.Pattern;

public class ContactDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA_Z\\s]{2,}$", message = "Contact name Invalid")
	public String name;
	@Pattern(regexp = "'^([+]?[1-9][0-9])?[0-9]{10}$'", message = "Ph Invalid")
	public String phoneNumber;

	public ContactDTO(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "name=" + name + ", phoneNumber=" + phoneNumber;
	}
}
