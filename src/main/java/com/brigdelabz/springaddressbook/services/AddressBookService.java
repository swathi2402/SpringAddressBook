package com.brigdelabz.springaddressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brigdelabz.springaddressbook.dto.ContactDTO;
import com.brigdelabz.springaddressbook.exception.AddressBookException;
import com.brigdelabz.springaddressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

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
		addressBookData = new AddressBookData(addressBookList.size() + 1, contactDTO);
		addressBookList.add(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int contactId, ContactDTO contactDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(contactId);
		addressBookData.setName(contactDTO.name);
		addressBookData.setPhoneNumber(contactDTO.phoneNumber);
		addressBookList.set(contactId - 1, addressBookData);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int contactId) {
		addressBookList.remove(getAddressBookDataById(contactId));
	}

}
