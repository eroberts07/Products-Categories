package com.eric.productsproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, max=200)
	private String name;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "categories_products", 
	joinColumns = @JoinColumn( name ="category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	
	public Category() {
		
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getCreateAt() {
		return updatedAt;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setCreateAt(Date createAt) {
		this.updatedAt = createAt;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category(@Size(min = 1, max = 200) String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	

}
