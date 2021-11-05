package com.brigdelabz.springaddressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.brigdelabz.springaddressbook.services.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping("/home")
	public String sayHello() {
		return "Welcome to Address Book!!";
	}

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("contactId") int contactId) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.getAddressBookDataById(contactId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.createAddressBookData(contactDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Contact Data for: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("contactId") int contactId,
			@Valid @RequestBody ContactDTO contactDTO) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookService.updateAddressBookData(contactId, contactDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Contact Data for: ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contactId") int contactId) {
		addressBookService.deleteAddressBookData(contactId);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: " + contactId, HttpStatus.OK);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
