package com.prudent.data.customerDB.es.entity;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="prudentcpa", type="contact")
public class Contact {
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
