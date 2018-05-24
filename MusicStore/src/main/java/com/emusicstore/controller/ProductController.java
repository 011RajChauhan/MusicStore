package com.emusicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.models.Product;
import com.emusicstore.services.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> productList = productService.getProductList();
		model.addAttribute(productList);
		return "productList";
	}
	
	@RequestMapping("/productDetails/{productId}")
	public String getProductDetails(@PathVariable("productId") String productId, Model model) {
		
		model.addAttribute("product", productService.getProductById(Integer.valueOf(productId)));
		return "productDetail";
	}
}
