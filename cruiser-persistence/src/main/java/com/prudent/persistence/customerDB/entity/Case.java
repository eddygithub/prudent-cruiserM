package com.prudent.persistence.customerDB.entity;

import java.sql.Clob;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Case{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Customer customer;
	@OneToOne
	private CaseWorker caseWorker;
	@OneToMany
	private List<Dependent> dependents;
	private int year;
	private String bankName;
	private int routingNum;
	private AccountType accountType;
	private int accountNum;
	private int adjustedGrossIncome;
	@Temporal(TemporalType.TIMESTAMP)
	private Date interviewDate;
	private Date completeDate;
	private float fee;
	private Clob comments;
	private String externalResourceLink;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getRoutingNum() {
		return routingNum;
	}

	public void setRoutingNum(int routingNum) {
		this.routingNum = routingNum;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public int getAdjustedGrossIncome() {
		return adjustedGrossIncome;
	}

	public void setAdjustedGrossIncome(int adjustedGrossIncome) {
		this.adjustedGrossIncome = adjustedGrossIncome;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public Clob getComments() {
		return comments;
	}

	public void setComments(Clob comments) {
		this.comments = comments;
	}

	public String getExternalResourceLink() {
		return externalResourceLink;
	}

	public void setExternalResourceLink(String externalResourceLink) {
		this.externalResourceLink = externalResourceLink;
	}
}
