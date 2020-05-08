package com.mitesh.springdata.productdata.jpqlandnativesql;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitesh.springdata.productdata.jpqlandnativesql.entities.Student;
import com.mitesh.springdata.productdata.jpqlandnativesql.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testStudentCreate() {
		Student student1 = new Student();
		student1.setFirstName("Mitesh");
		student1.setLastName("Upadhyay");
		student1.setScore(52);
		student1.setId(103L);
		repository.save(student1);

		Student student2 = new Student();
		student2.setFirstName("Devanshi");
		student2.setLastName("Bhatt");
		student2.setScore(82);
		student2.setId(104L);
		repository.save(student2);

	}

	@Test
	public void testFindAllStudents() {
		System.out.println(repository.findAllStudents(new PageRequest(0, 2)));
	}
	
	@Test
	public void testFindAllStudentsPartialData() {
		 List<Object[]> findAllStudentsPartialData = repository.findAllStudentsPartialData();
		 for(Object[] objects:findAllStudentsPartialData) {
			 System.out.println(objects[0]);
			 System.out.println(objects[1]);
		 }
	}
	
	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(repository.findAllStudentByFirstName("Mitesh"));
	}	
	
	@Test
	public void testFindAllStudentsByScore() {
		System.out.println(repository.findStudentsForGivenScore(72, 92));
	}
	
	@Test
	@Transactional 
	@Rollback(false) //If we don't use this then Transaction will be rolled Back and no record will get deleted
	public void testDeleteStudentsByFirstName() {
		repository.deleteStudentsByFirstName("Mitesh");
	}
	
	@Test
	public void testFindAllStudentsNQ() {
		System.out.println("=======>"+repository.findAllStudentNQ());		
	}
	
	@Test
	public void testFindAllStudentsByFirstNameNQ() {
		System.out.println("=======>"+repository.findAllStudentNQ("Mitesh"));		
	}	
}
