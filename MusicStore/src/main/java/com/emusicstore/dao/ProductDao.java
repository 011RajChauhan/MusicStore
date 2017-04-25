package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.models.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	
	Product getProductById(int id);
	
	List<Product> getAllProduct();
	
	void deleteProduct(int id);
}
