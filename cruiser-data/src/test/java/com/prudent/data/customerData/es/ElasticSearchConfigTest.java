package com.prudent.data.customerData.es;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prudent.data.customerData.es.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ElasticSearchConfig.class})
public class ElasticSearchConfigTest {

	@Autowired
	CustomerRepository customerRepository;
	
}
