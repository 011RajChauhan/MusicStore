package com.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public String getProduct(Model model) {
		List<Product> productList = productDao.getAllProduct();
		model.addAttribute(productList);
		return "productList";
	}
	
	@RequestMapping(value = "/viewProductDetails", method = RequestMethod.GET)
	public String viewProductDetails() {
		return  "productDetail";
	}
	
	@RequestMapping(value = "/productDetails/{productId}", method = RequestMethod.GET)
	public String getProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "productDetail";
	}
	@RequestMapping(value = "admin/productDetails/{productId}", method = RequestMethod.GET)
	public String getAdminProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "productDetail";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/admin/productInventory", method = RequestMethod.GET)
	public String productInventory(Model model) {
		List<Product> productList = productDao.getAllProduct();
		model.addAttribute(productList);
		return "productInventory";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductPrice(0.00);
		product.setProductCondition("new");
		product.setProductStatus("available");
		product.setProductUnitInStock(0);
		model.addAttribute(product);
		return "addProduct";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductInInventory(@ModelAttribute("product") Product product) {
		productDao.addProduct(product);
		return "redirect:/admin/productInventory";
	}
}
