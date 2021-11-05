package com.brigdelabz.springaddressbook.dto;

public class ContactDTO {

	public String name;
	public long phoneNumber;

	public ContactDTO(String name, long phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "name=" + name + ", phoneNumber=" + phoneNumber;
	}
}
