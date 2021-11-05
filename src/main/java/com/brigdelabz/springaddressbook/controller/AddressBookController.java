package com.brigdelabz.springaddressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brigdelabz.springaddressbook.dto.ContactDTO;
import com.brigdelabz.springaddressbook.dto.ResponseDTO;
import com.brigdelabz.springaddressbook.model.AddressBookData;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping("/home")
	public String sayHello() {
		return "Welcome to Address Book!!";
	}

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, new ContactDTO("Swathi", "9999999999"));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("contactId") int contactId) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, new ContactDTO("Swathi", "9999999999"));
		ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, contactDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Contact Data for: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("contactId") int contactId,
			@RequestBody ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(contactId, contactDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Contact Data for: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contactId") int contactId) {
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: " + contactId, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
