package com.mitesh.springdata.componantmapping.componantmapping.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	@Embedded
	private Address address;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
