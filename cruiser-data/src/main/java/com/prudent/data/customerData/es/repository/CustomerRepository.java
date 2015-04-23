package com.prudent.data.customerData.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.prudent.data.customerDB.domain.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{
	
	
}
