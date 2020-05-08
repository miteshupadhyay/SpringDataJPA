package com.mitesh.springdata.productdata.jpqlandnativesql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private Long id;
	@Column(name = "fname")
	private String firstName;
	@Column(name = "lname")
	private String lastName;
	private int score;
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getScore() {
		return score;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + "]";
	}
	
}
