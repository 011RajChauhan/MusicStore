package com.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(value = {"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping(value = "/products")
	public String getProduct(Model model) {
		List<Product> productList = productDao.getAllProduct();
		model.addAttribute(productList);
		return "productList";
	}
	
	@GetMapping(value = "/viewProductDetails")
	public String viewProductDetails() {
		return  "productDetail";
	}
	
	@GetMapping(value = "/products/productDetails/{productId}")
	public String getProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute(product);
		return "productDetail";
	}
	
}
