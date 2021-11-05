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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping("/home")
	public String sayHello() {
		return "Welcome to Address Book!!";
	}
	
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<String> getAddressBookData(@PathVariable("contactId") int contactId) {
		return new ResponseEntity<String>("Get Call Success for id: " + contactId, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addAddressBookData(@RequestBody ContactDTO contactDTO) {
		return new ResponseEntity<String>("Created Contact Data for: " + contactDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateAddressBookData(@RequestBody ContactDTO contactDTO) {
		return new ResponseEntity<String>("Updated Contact Data for: " + contactDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("contactId") int contactId) {
		return new ResponseEntity<String>("Delete Call Success for id: " + contactId, HttpStatus.OK);
	}
}
