package com.mitesh.springdata.productdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.productdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
