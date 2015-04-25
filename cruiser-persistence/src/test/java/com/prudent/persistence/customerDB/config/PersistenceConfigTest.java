package com.prudent.persistence.customerDB.config;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prudent.persistence.customerDB.entity.Customer;
import com.prudent.persistence.customerDB.entity.Gender;
import com.prudent.persistence.customerDB.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PersistenceConfig.class)
@ActiveProfiles(profiles="test")
public class PersistenceConfigTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void isNull(){
		assertThat(customerRepository, notNullValue());
	}
	
	@Test
	public void saveCustomer(){
		int ssn = 112113113;
		
		Customer customer = new Customer();
		customer.setBirthDay(new Date());
		customer.setCity("New York");
		customer.setFirstName("First Name");
		customer.setGender(Gender.MALE);
		customer.setLastName("Last Name");
		customer.setSsn(ssn);
		customer.setState("NY");
		customer.setStreetAddress("123 Main Street");
		customer.setZipCode(11354);
		
		customerRepository.save(customer);
		
		Customer savedCustomer = customerRepository.findByssn(ssn);
		assertThat(customer, Is.is(savedCustomer));
	}
}
