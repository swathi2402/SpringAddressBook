package com.brigdelabz.springaddressbook.model;

import com.brigdelabz.springaddressbook.dto.ContactDTO;

public class AddressBookData {

	private int contactId;
	private String name;
	private long phoneNumber;

	public AddressBookData(int contactId, ContactDTO contactDTO) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
