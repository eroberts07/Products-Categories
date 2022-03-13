package com.eric.productsproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eric.productsproject.models.Category;
import com.eric.productsproject.models.Product;
import com.eric.productsproject.services.CategoryService;
import com.eric.productsproject.services.ProductService;


@Controller
public class ProductsController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	
	/////////  GET ROUTES //////////
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allProducts", this.pService.allProducts());
		model.addAttribute("allCategories", this.cService.allCategories());
		
		return "index.jsp";
	}
	
	@GetMapping("/newProduct")
	public String addProd(@ModelAttribute("product") Product product,@ModelAttribute("category") Category category, Model model) {
		
		List<Product> products = pService.allProducts();
		
		model.addAttribute("products", products);
		
		List<Category> categories = cService.allCategories();
		
		model.addAttribute("categories", categories);
		
		return "newProduct.jsp";
	}
	
	@GetMapping("/newCategory")
	public String addCat(@ModelAttribute("category") Category category, Model model) {
		
		List<Category> categories = cService.allCategories();
		
		model.addAttribute("categories", categories);
		
		return "newCategory.jsp";
	}
	
	@GetMapping("/{product.id}")
	public String details(@ModelAttribute("product") Product product, 
			@ModelAttribute("category") Category category, 
			@PathVariable("id") Long productid, Model model) {
		
		List<Product> products = pService.allProducts();
		
		model.addAttribute("products", products);
		
		List<Category> categories = cService.allCategories();
		
		model.addAttribute("categories", categories);
		
		return "details.jsp";
	}
	
	
	
	
	
	/////// POST ROUTES ///////
	
	@PostMapping("/newCat")
	public String makeCat(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		cService.createCategory(category);
		return "redirect:/";
	}
	
	@PostMapping("/newProd")
	public String makeProd(@Valid @ModelAttribute("products") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		pService.createProduct(product);
		return "redirect:/";
	}
	
	

}
