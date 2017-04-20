package com.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/getProducts")
	public String getProduct(Model model) {
		List<Product> productList = productDao.getAllProduct();
		model.addAttribute(productList);
		return "productList";
	}
	
	@RequestMapping(value = "viewProductDetails")
	public String viewProductDetails() {
		return  "productDetail";
	}
	
	@RequestMapping(value = "productDetails/{productId}")
	public String getProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "productDetail";
	} 
}
