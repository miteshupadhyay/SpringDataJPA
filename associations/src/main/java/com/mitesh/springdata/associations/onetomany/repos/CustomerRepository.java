package com.mitesh.springdata.associations.onetomany.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.associations.onetomany.associations.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	void save(Optional<Customer> customer);

}
