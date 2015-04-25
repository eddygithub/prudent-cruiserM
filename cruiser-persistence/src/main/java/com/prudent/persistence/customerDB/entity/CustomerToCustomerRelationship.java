package com.prudent.persistence.customerDB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerToCustomerRelationship extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private RelationshipType relationshipType;
	@OneToOne
	private Customer customer;
	@OneToOne
	private Customer relatedTo;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getRelatedTo() {
		return relatedTo;
	}
	public void setRelatedTo(Customer relatedTo) {
		this.relatedTo = relatedTo;
	}
	public RelationshipType getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(RelationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}
}
