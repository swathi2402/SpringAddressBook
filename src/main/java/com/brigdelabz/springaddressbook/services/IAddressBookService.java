package com.brigdelabz.springaddressbook.services;

import java.util.List;

import com.brigdelabz.springaddressbook.dto.ContactDTO;
import com.brigdelabz.springaddressbook.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(int contactId);

	AddressBookData createAddressBookData(ContactDTO contactDTO);

	AddressBookData updateAddressBookData(int contactId, ContactDTO contactDTO);

	void deleteAddressBookData(int contactId);
}
