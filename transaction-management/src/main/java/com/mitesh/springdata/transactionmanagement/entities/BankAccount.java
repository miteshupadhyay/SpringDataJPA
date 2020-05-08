package com.mitesh.springdata.transactionmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

	@Id
	private int accno;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	private int bal;
	
	public int getAccno() {
		return accno;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getBal() {
		return bal;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", firstName=" + firstName + ", lastName=" + lastName + ", bal=" + bal
				+ "]";
	}
	
	
}
