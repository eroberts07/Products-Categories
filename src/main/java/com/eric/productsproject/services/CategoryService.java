package com.eric.productsproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.productsproject.models.Category;
import com.eric.productsproject.models.Product;
import com.eric.productsproject.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	public CategoryRepository cRepo;
	
	//Find all categories
	public List<Category> allCategories() {
		return this.cRepo.findAll();
	}
	
	//Find one category
	public Category findCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	//Create
	public Category createCategory(Category newCategory) {
		return this.cRepo.save(newCategory);
		
	}
	
	//Update
	public Category updateCategory(Category updatedCategory) {
		return this.cRepo.save(updatedCategory);
	}
	
	//Delete
	public void deleteCategory(Long id) {
		this.cRepo.deleteById(id);
	}
	
	//Find one product
	public Product findProduct(Product productId) {
		Product thisproduct = findProductById(productId);
		return thisproduct;
	}

	private Product findProductById(Product productId) {
		return null;
	}

	
	

}
