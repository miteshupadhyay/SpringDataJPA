package com.mitesh.springdata.associations.manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	private String name;
	@ManyToMany(mappedBy = "projects")
	private Set<Programmer> programmers;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}
	
}
