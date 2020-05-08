package com.mitesh.springdata.productdata.idgenerators.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {

	//@TableGenerator(name = "employee_gen",table = "id_gen",pkColumnName = "gen_name",pkColumnValue = "gen_val",allocationSize = 1000)
	@GenericGenerator(name = "emp_id",strategy = "com.mitesh.springdata.productdata.idgenerators.custom.CustomRandomIDGenerator")
	@GeneratedValue(generator = "emp_id")
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_gen")
	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
}
