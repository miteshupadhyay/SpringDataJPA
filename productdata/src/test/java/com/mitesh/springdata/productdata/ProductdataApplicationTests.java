package com.mitesh.springdata.productdata;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitesh.springdata.productdata.entity.Product;
import com.mitesh.springdata.productdata.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() 
	{
		Product product=new Product();
		
		product.setDesc("Test");
		product.setName("Test");
		product.setPrice(12.35);
		product.setId(108);
				
		repository.save(product);
	}	
	@Test
	public void testRead() 
	{
		Optional<Product> product=repository.findById(101);
			if(product.isPresent()) {
				assertNotNull(product);
				assertEquals("Rohitbhai",product.get().getName());
			}
	}
	@Test
	public void testUpdate() 
	{
		Product product=repository.findById(102).get();
				product.setName("Rohitbhai");
				product.setDesc("Indore");
				product.setPrice(8.56);
				repository.save(product);
				assertEquals("Rohitbhai",product.getName());
	}
	@Test
	public void testDelete() 
	{
		if(repository.existsById(101))
			repository.deleteById(101);
	}
	@Test
	public void testCount() 
	{
		System.out.println("Total No of Records "+repository.count());
	}
	
	@Test
	public void testFindByName() 
	{
	List<Product> products=repository.findByName("Rohit");
	products.forEach(value->System.out.println("City for Rohit "+value.getDesc()));
	}
	
	@Test
	public void testFindByNameAndDesc() 
	{
	List<Product> products=repository.findByNameAndDesc("Rohit","Indore");
	products.forEach(value->System.out.println("Price for Rohit "+value.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() 
	{
	List<Product> products=repository.findByPriceGreaterThan(10.25d);
	products.forEach(value->System.out.println("All Prices Greater then 10.25d are "+value.getPrice()));
	}
	
	@Test
	public void testFindByDescContains() 
	{
	List<Product> products=repository.findByDescContains("mb");
	products.forEach(value->System.out.println("All Prices Greater then 10.25d are "+value.getDesc()));
	}
	
	@Test
	public void testFindByPriceBetween() 
	{
	List<Product> products=repository.findByPriceBetween(10.25d,30.25d);
	products.forEach(value->System.out.println("All Prices betweens are "+value.getPrice()));
	}
	@Test
	public void testFindByDescLike() 
	{
	List<Product> products=repository.findByDescLike("I%");
	products.forEach(value->System.out.println("All Desc like 'I' are "+value.getDesc()));
	}
	@Test
	public void testFindByIdsIn() 
	{
	Pageable pageable=new PageRequest(0, 2);
	List<Product> products=repository.findByIdIn(Arrays.asList(1001,102),pageable);
	products.forEach(value->System.out.println("All Desc in 101,102 "+value.getDesc()));
	}
	
	@Test
	public void testFindAllPaging() {
		Pageable pageable=new PageRequest(1, 2);
		
		Page<Product> product = repository.findAll(pageable);
		product.forEach(p->System.out.println("Name is "+p.getName()));
	}
	
	@Test
	public void testFindAllSorting() {
		repository.findAll(new Sort(Direction.DESC,"desc")).forEach(p->System.out.println("Description "+p.getDesc()));
	}
	
	@Test
	public void testFindAllSortingMultiple() {
		//Below is the same order for both the properties (desc,price)
		//repository.findAll(new Sort(Direction.DESC,"desc","price")).forEach(p->System.out.println("Description "+p.getDesc()));
		
		//Below is the Descending order for "desc" and Ascending order for price
		repository.findAll(new Sort(new Sort.Order(Direction.DESC,"desc"),new Sort.Order("price")));	
	}
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable=new PageRequest(0, 2,Direction.DESC,"name");
		repository.findAll(pageable).forEach(p->System.out.println("Name==>"+p.getName()));
	}
	
	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<Product> product=repository.findById(1);
		
		repository.findById(1);
		
		session.evict(product);
		
		repository.findById(1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
