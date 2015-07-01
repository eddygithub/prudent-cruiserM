package com.prudent.data.customerData.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.prudent.data.customerDB.es.entity.Employee;

public interface EmployeeRepository extends ElasticsearchCrudRepository<Employee, Long> {

}
