package com.mitesh.springdata.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.associations.manytomany.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> 
{
	
}
