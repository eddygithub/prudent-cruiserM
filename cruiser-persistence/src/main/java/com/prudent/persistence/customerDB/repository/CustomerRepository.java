package com.prudent.persistence.customerDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prudent.persistence.customerDB.entity.Customer;

import java.lang.String;
import java.util.List;
import java.util.stream.Stream;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);
	
	List<Customer> findByZipCode(int zipCode);
	
	Customer findByssn(int ssn);
	
	@Query("select c from Customer c")
	Stream<Customer> findAllStream();
}
