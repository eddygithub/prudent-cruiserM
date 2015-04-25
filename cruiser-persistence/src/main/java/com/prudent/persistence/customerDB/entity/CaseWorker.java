package com.prudent.persistence.customerDB.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CaseWorker extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String fullName;
	
	@OneToMany
	private List<Case> cases;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<Case> getCases() {
		return cases;
	}
	public void setCases(List<Case> cases) {
		this.cases = cases;
	}
}
