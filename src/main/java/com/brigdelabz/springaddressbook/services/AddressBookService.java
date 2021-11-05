package com.brigdelabz.springaddressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brigdelabz.springaddressbook.dto.ContactDTO;
import com.brigdelabz.springaddressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addressBookList = new ArrayList<>();
		addressBookList.add(new AddressBookData(1, new ContactDTO("Swathi", "9999999999")));
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int contactId) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, new ContactDTO("Swathi", "9999999999"));
		return addressBookData;
	}

	@Override
	public AddressBookData createAddressBookData(ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, contactDTO);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int contactId, ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(contactId, contactDTO);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int contactId) {
		// TODO Auto-generated method stub

	}

}
