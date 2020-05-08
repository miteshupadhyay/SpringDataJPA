package com.mitesh.springdata.productdata.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mitesh.springdata.productdata.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	void save(Optional<Product> product);
	
	List<Product> findByName(String name);
	List<Product> findByNameAndDesc(String name,String desc);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByDescContains(String desc);
	List<Product> findByPriceBetween(Double price1,Double price2);
	List<Product> findByDescLike(String desc);
	
	//List<Product> findByIdIn(List<Integer> ids);
	List<Product> findByIdIn(List<Integer> ids,Pageable pageable); //The same as above but with Pagination Support
}
