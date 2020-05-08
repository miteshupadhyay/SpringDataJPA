package com.mitesh.springdata.productdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitesh.springdata.productdata.idgenerators.entities.Employee;
import com.mitesh.springdata.productdata.idgenerators.repos.EmployeeRepository;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository repository;
	
	@Test
	void testCreateEmployee() 
	{
		Employee employee=new Employee();
			employee.setName("Mitesh");
			
			repository.save(employee);
	}

}
