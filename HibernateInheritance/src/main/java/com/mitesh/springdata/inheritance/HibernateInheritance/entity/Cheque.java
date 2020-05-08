package com.mitesh.springdata.inheritance.HibernateInheritance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bankcheck")
public class Cheque extends Payment{

	@Column(name = "checknumber")
	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
}
