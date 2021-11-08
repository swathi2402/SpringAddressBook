package com.brigdelabz.springaddressbook.dto;

import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class ContactDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA_Z\\s]{2,}$", message = "Contact name Invalid")
	public String firstName;
	public String lastName;
	public String address;
	public String state;
	public String city;
	public String zip;

	@Pattern(regexp = "^([+]?[1-9][0-9])?[0-9]{10}$", message = "Phone number Invalid")
	public String phoneNumber;
}
