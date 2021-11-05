package com.brigdelabz.springaddressbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping(value = { "", "/", "/home" })
	public String sayHello() {
		return "Welcome to Address Book!!";
	}
}
