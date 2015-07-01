package com.prudent.data.customerData.es;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prudent.data.customerDB.es.entity.Contact;
import com.prudent.data.customerDB.es.entity.Customer;
import com.prudent.data.customerData.es.repository.CustomerRepository;
import com.prudent.data.customerData.es.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ElasticSearchConfig.class })
public class ElasticSearchConfigTest {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Before
	public void before() {
//		elasticsearchTemplate.deleteIndex(Customer.class);
//		elasticsearchTemplate.createIndex(Customer.class);
//		elasticsearchTemplate.putMapping(Customer.class);
//		elasticsearchTemplate.refresh(Customer.class, true);
	}

	@Test
	public void notNull() {
		assertThat(customerRepository, notNullValue());
	}
	
	@Test
	public void createAndRetrieveCustomer(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, 1978);
		
		for(long i=1; i < 10000; i++){
			cal.set(Calendar.MONTH, (int)(i%12));
			cal.set(Calendar.DAY_OF_MONTH, (int)i%29);
			Customer customer = new Customer();
			customer.setId(i);
			customer.setBirthDay(cal.getTime());
			customer.setFirstName("Awesome");
			customer.setLastName("Tester");
			customer.setCity("New York");
			customer.setGender(i%2==0?"MALE":"FEMALE");
			customer.setSsn(123123123);
			customer.setState("New York");
			customer.setStreetAddress("123 main street");
			customer.setZipCode(11232);
			List<Contact> contacts = new ArrayList<Contact>();
			Contact primaryEmail = new Contact();
			primaryEmail.setInformation("myemail@email.com");
			primaryEmail.setMethod("EMAIL");
			contacts.add(primaryEmail);
			customer.setContacts(contacts);
			customerRepository.save(customer);
	
//		assertThat(customerRepository.count(), Is.is(1L));
//		Customer savedCustomer = customerRepository.findOne(id);
//		assertThat(savedCustomer, notNullValue());
//		
//		assertThat(customer, Is.is(savedCustomer));
		}
	}
}
