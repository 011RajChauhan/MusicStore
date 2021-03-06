package com.emusicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emusicstore.models.Product;
import com.emusicstore.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProduct(Model model) {
		List<Product> productList = productService.getProductList();
		model.addAttribute(productList);
		return "productList";
	}
	
	/*@RequestMapping(value = "/viewProductDetails", method = RequestMethod.GET)
	public String viewProductDetails() {
		return  "productDetail";
	}
	
	@RequestMapping(value = "/products/productDetails/{productId}", method = RequestMethod.GET)
	public String getProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute(product);
		return "productDetail";
	}*/
	
}
