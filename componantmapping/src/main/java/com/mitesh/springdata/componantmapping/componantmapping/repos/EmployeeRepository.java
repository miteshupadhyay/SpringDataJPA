package com.mitesh.springdata.componantmapping.componantmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.componantmapping.componantmapping.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
