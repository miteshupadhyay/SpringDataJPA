package com.mitesh.springdata.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
