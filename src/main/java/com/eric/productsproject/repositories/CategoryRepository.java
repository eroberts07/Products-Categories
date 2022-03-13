package com.eric.productsproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.productsproject.models.Category;
import com.eric.productsproject.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	List<Category> findAllByProducts(Product product);

}
