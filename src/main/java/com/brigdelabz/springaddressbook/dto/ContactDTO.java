package com.brigdelabz.springaddressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class ContactDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA_Z\\s]{2,}$", message = "Contact first name Invalid")
	public String firstName;

	@Pattern(regexp = "^[A-Z]{1}[a-zA_Z\\s]{2,}$", message = "Contact last name Invalid")
	public String lastName;

	@Pattern(regexp = "([a-zA-Z]{3,}\\s?){2,}$", message = "Address is Invalid")
	public String address;

	@NotBlank(message = "State cannot be empty")
	public String state;

	@NotBlank(message = "City cannot be empty")
	public String city;

	@Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Zip Code Invalid")
	public String zip;

	@Pattern(regexp = "^([+]?[1-9][0-9])?[0-9]{10}$", message = "Phone number Invalid")
	public String phoneNumber;

	@Pattern(regexp = "([a-zA-Z][a-zA-Z0-9]*)(([+_.-][a-zA-Z0-9]+)?)(@[a-zA-Z0-9]+)([.])([a-z]{2,})(([.][a-z]{2})?)", message = "Email Invalid")
	public String email;
}
