package com.prudent.data.customerDB.es.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="prudentcpa", type="dependent")
public class Dependent {
	@Id
	private Long id;
	private int ssn;
	private String firstName;
	private String lastName;
	private Date birthDay;
	private boolean hasMedInsurance;
	private LegalStatus legalStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public boolean isHasMedInsurance() {
		return hasMedInsurance;
	}
	public void setHasMedInsurance(boolean hasMedInsurance) {
		this.hasMedInsurance = hasMedInsurance;
	}
	public LegalStatus getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(LegalStatus legalStatus) {
		this.legalStatus = legalStatus;
	}
}
