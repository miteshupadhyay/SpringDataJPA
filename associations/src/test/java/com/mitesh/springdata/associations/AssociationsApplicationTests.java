package com.mitesh.springdata.associations;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitesh.springdata.associations.manytomany.Programmer;
import com.mitesh.springdata.associations.manytomany.Project;
import com.mitesh.springdata.associations.manytomany.repos.ProgrammerRepository;
import com.mitesh.springdata.associations.onetomany.associations.Customer;
import com.mitesh.springdata.associations.onetomany.associations.PhoneNumber;
import com.mitesh.springdata.associations.onetomany.repos.CustomerRepository;
import com.mitesh.springdata.associations.onetoone.entities.License;
import com.mitesh.springdata.associations.onetoone.entities.Person;
import com.mitesh.springdata.associations.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenseRepository;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void createCustomer() 
	{
		Customer customer=new Customer();
		customer.setName("Mitesh");
		
		HashSet<PhoneNumber> numbers=new HashSet<PhoneNumber>();
		
		PhoneNumber phoneNumber1=new PhoneNumber();
			phoneNumber1.setNumber("123456");
			phoneNumber1.setType("cell");
			phoneNumber1.setCustomer(customer);
			
		PhoneNumber phoneNumber2=new PhoneNumber();
			phoneNumber2.setNumber("899813");
			phoneNumber2.setType("home");
			phoneNumber2.setCustomer(customer);
			
			numbers.add(phoneNumber1);
			numbers.add(phoneNumber2);
			
		customer.setNumbers(numbers);
		
		customerRepository.save(customer);
	}
	
	@Test
	public void loadCustomer() 
	{
		Optional<Customer> customer=customerRepository.findById(3L);
		if(customer.isPresent()) {
			System.out.println("My Customer "+customer.get().getName());
			
			Set<PhoneNumber> numbers = customer.get().getNumbers();
			numbers.forEach(number->System.out.println("All the phone numbers for Customer "+customer.get().getName()+" is "+number.getNumber()));
		}		
	}	
	
	
	@Test
	@Transactional
	public void updateCustomer() 
	{
		Optional<Customer> customer=customerRepository.findById(3L);
		if(customer.isPresent()) 
		{
			System.out.println("My Customer "+customer.get().getName());
			customer.get().setName("Devaaa");
			Set<PhoneNumber> numbers = customer.get().getNumbers();
			numbers.forEach(number->number.setType("cellular"));
			customerRepository.save(customer);
		}		
	}	
	
	@Test
	public void testDelete() {
		customerRepository.deleteById(3L);
	}
	

	@Test
	public void testMany2ManyProgrammer() {
		Programmer programmer=new Programmer();
			programmer.setName("Mitesh");
			programmer.setSal(1000);
			
		HashSet<Project> projects=new HashSet<Project>();
		Project project=new Project();
		project.setName("Java");
		projects.add(project);
		
		programmer.setProjects(projects);
		programmerRepository.save(programmer);
		
	}
	
	@Test
	@Transactional
	public void testMany2ManyFindProgrammer() {
		Optional<Programmer> programmer=programmerRepository.findById(1);
		if(programmer.isPresent()) {
		System.out.println(programmer);
		System.out.println(programmer.get().getProjects());
		}
	}
	@Test
	public void testOne2OnecreateLicense() {
		License license=new License();
			license.setType("CAR");
			license.setValidFrom(new Date());
			license.setValidTo(new Date());
			
		Person person=new Person();
			person.setFirstName("Mitesh");
			person.setLastName("Upadhyay");
			person.setAge(50);
			license.setPerson(person);
		licenseRepository.save(license);
	}
}
