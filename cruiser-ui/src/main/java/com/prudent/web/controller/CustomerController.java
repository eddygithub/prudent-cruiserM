package com.prudent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prudent.persistence.customerDB.entity.Customer;
import com.prudent.persistence.customerDB.repository.CustomerRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="/create", method=RequestMethod.PUT)
	public void createCustomer(@RequestBody Customer customer){
		customerRepository.save(customer);
	}
	
	@RequestMapping("/{id}")
	public String showCustomerForm(@PathVariable("id") Customer customer, Model model){
		model.addAttribute("customer", customer);
		return "customerForm";
	}
	
	@RequestMapping
	public String showCustomers(Model model, Pageable pageable){
		model.addAttribute("customers", customerRepository.findAll(pageable));
		return "customers";
	}
	
}
