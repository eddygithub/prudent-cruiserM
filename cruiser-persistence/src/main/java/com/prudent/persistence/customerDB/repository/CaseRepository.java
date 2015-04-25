package com.prudent.persistence.customerDB.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prudent.persistence.customerDB.entity.Case;
import com.prudent.persistence.customerDB.entity.Customer;
import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {

	@Override
	public Page<Case> findAll(Pageable pageable);
	
	List<Case> findByCustomerSsn(Customer customer);
}
