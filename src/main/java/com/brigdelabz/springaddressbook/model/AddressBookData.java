package com.brigdelabz.springaddressbook.model;

import com.brigdelabz.springaddressbook.dto.ContactDTO;

public class AddressBookData {

	private int contactId;
	public String firstName;
	public String lastName;
	public String address;
	public String state;
	public String city;
	public String zip;
	public String phoneNumber;
	public String email;

	public AddressBookData(int contactId, ContactDTO contactDTO) {
		super();
		this.contactId = contactId;
		this.firstName = contactDTO.firstName;
		this.lastName = contactDTO.lastName;
		this.address = contactDTO.address;
		this.state = contactDTO.state;
		this.city = contactDTO.city;
		this.zip = contactDTO.zip;
		this.phoneNumber = contactDTO.phoneNumber;
		this.email = contactDTO.email;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
