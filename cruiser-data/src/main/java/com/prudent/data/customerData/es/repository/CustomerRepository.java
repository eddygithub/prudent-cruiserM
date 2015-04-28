package com.prudent.data.customerData.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.prudent.data.customerDB.es.entity.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, Long>{
	
	@Override
	public List<Customer> findAll();
}
