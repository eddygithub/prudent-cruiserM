package com.prudent.office.data.store.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.prudent.customerDB.domain.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{
	
	
}
