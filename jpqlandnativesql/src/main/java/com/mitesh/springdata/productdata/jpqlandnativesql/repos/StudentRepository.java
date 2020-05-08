package com.mitesh.springdata.productdata.jpqlandnativesql.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mitesh.springdata.productdata.jpqlandnativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);
	
	@Query("select st.firstName,st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();
	
	//Named Query Parameter
	@Query("from Student where firstName=:fstName")
	List<Student> findAllStudentByFirstName(@Param("fstName") String fstName);
	
	@Query("from Student where score>:minValue and score<:maxValue")
	List<Student> findStudentsForGivenScore(@Param("minValue") int minValue,@Param("maxValue") int maxValue);
	
	@Modifying //because this is DML operation
	@Query("delete from Student where firstName=:fstName")
	void deleteStudentsByFirstName(@Param("fstName") String fstName);
	
	//Below are native queries (Native queries are used , when there are complex join needs to be used)
	@Query(value = "select * from student",nativeQuery = true)
	List<Student> findAllStudentNQ();
	
	@Query(value = "select * from student where fname=:firstName",nativeQuery = true)
	List<Student> findAllStudentNQ(@Param("firstName") String firstName);
}
