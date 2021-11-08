package com.brigdelabz.springaddressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brigdelabz.springaddressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
