package com.brigdelabz.springaddressbook.services;

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

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDataById(int contactId) {
		return addressBookRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("Contact with Id " + contactId + " does not exists..!"));
	}

	@Override
	public AddressBookData createAddressBookData(ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(contactDTO);
		log.debug("Contact: " + addressBookData.toString());
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int contactId, ContactDTO contactDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(contactId);
		addressBookData.updateAddressBookData(contactDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int contactId) {
		AddressBookData addressBookData = this.getAddressBookDataById(contactId);
		addressBookRepository.delete(addressBookData);
	}

}
