package com.brigdelabz.springaddressbook.dto;

public class ContactDTO {

	public String name;
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
