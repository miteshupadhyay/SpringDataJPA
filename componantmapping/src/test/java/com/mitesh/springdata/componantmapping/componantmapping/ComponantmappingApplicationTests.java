package com.mitesh.springdata.componantmapping.componantmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitesh.springdata.componantmapping.componantmapping.entity.Address;
import com.mitesh.springdata.componantmapping.componantmapping.entity.Employee;
import com.mitesh.springdata.componantmapping.componantmapping.repos.EmployeeRepository;

@SpringBootTest
class ComponantmappingApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testCreate() 
	{
		Employee employee=new Employee();
		employee.setId(101);
		employee.setName("Mitesh");
		
		Address address=new Address();
		address.setCity("Pune");
		address.setCountry("India");
		address.setState("MH");
		address.setStreetaddress("Keshav");
		address.setZipcode("411036");
		
		employee.setAddress(address);
		employeeRepository.save(employee);
	}
	
	
}
