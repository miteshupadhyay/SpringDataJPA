package com.mitesh.springdata.associations.onetoone.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class License {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	private Date validTo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	public Long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
