package com.brigdelabz.springaddressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.brigdelabz.springaddressbook.dto.ContactDTO;

import lombok.Data;

@Entity
@Table(name = "addressbook")
public @Data class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private int contactId;
	
	@Column(name = "first_name")
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String city;
	private String zip;
	private String phoneNumber;
	private String email;

	public AddressBookData() {
	}

	public AddressBookData(ContactDTO contactDTO) {
		this.updateAddressBookData(contactDTO);
	}

	public void updateAddressBookData(ContactDTO contactDTO) {
		this.firstName = contactDTO.firstName;
		this.lastName = contactDTO.lastName;
		this.address = contactDTO.address;
		this.state = contactDTO.state;
		this.city = contactDTO.city;
		this.zip = contactDTO.zip;
		this.phoneNumber = contactDTO.phoneNumber;
		this.email = contactDTO.email;
	}
}
