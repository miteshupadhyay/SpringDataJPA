package com.mitesh.springdata.associations.onetomany.associations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String number;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public long getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
