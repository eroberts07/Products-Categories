package com.eric.productsproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.productsproject.models.Product;
import com.eric.productsproject.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	//Find all products
	public List<Product> allProducts() {
		return this.pRepo.findAll();
	}
	
	//Find one product
	public Product findProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Create
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	//Update
	public Product updateProduct(Product updatedProduct) {
		return this.pRepo.save(updatedProduct);
	}
	
	//Delete
	public void deleteProduct(Long id) {
		this.pRepo.deleteById(id);
	}

}
