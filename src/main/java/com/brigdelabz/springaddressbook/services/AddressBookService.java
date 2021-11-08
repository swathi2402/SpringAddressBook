package com.brigdelabz.springaddressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brigdelabz.springaddressbook.dto.ContactDTO;
import com.brigdelabz.springaddressbook.exception.AddressBookException;
import com.brigdelabz.springaddressbook.model.AddressBookData;
import com.brigdelabz.springaddressbook.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;
	
	private List<AddressBookData> addressBookList = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int contactId) {
		return addressBookList.stream().filter(contact -> contact.getContactId() == contactId).findFirst()
				.orElseThrow(() -> new AddressBookException("Contact Not Found"));
	}

	@Override
	public AddressBookData createAddressBookData(ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(contactDTO);
		addressBookList.add(addressBookData);
		log.debug("Contact: " + addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int contactId, ContactDTO contactDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(contactId);
		addressBookData.setFirstName(contactDTO.firstName);
		addressBookData.setPhoneNumber(contactDTO.phoneNumber);
		addressBookList.set(contactId - 1, addressBookData);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int contactId) {
		addressBookList.remove(getAddressBookDataById(contactId));
	}

}
