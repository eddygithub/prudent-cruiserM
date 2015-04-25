package com.prudent.persistence.customerDB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String method;
	private String information;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
}
