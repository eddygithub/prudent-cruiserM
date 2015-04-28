package com.prudent.data.customerData.es;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prudent.data.customerDB.es.entity.Customer;
import com.prudent.data.customerData.es.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ElasticSearchConfig.class })
public class ElasticSearchConfigTest {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	CustomerRepository customerRepository;

	@Before
	public void before() {
		elasticsearchTemplate.deleteIndex(Customer.class);
		elasticsearchTemplate.createIndex(Customer.class);
		elasticsearchTemplate.putMapping(Customer.class);
		elasticsearchTemplate.refresh(Customer.class, true);
	}

	@Test
	public void notNull() {
		assertThat(customerRepository, notNullValue());
	}
	
	@Test
	public void createAndRetrieveCustomer(){
		long id = 123l;
		Customer customer = new Customer();
		customer.setId(id);
		customer.setBirthDay(new Date());
		customer.setFirstName("Awesome");
		customer.setLastName("Tester");
		
		customerRepository.save(customer);
	
		assertThat(customerRepository.count(), Is.is(1L));
		customerRepository.findAll();
		Customer savedCustomer = customerRepository.findOne(id);
		assertThat(savedCustomer, notNullValue());
		
		assertThat(customer, Is.is(savedCustomer));
	}
}
