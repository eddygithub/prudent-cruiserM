package com.prudent.persistence.customerDB.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Dependent extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int ssn;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	private boolean hasMedInsurance;
	private LegalStatus legalStatus;
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
