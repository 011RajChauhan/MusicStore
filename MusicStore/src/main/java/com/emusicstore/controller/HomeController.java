package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Product;

@Controller
public class HomeController {
	
	private Path path;
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProduct(Model model) {
		List<Product> productList = productDao.getAllProduct();
		model.addAttribute(productList);
		return "productList";
	}
	
	@RequestMapping(value = "/viewProductDetails", method = RequestMethod.GET)
	public String viewProductDetails() {
		return  "productDetail";
	}
	
	@RequestMapping(value = "/products/productDetails/{productId}", method = RequestMethod.GET)
	public String getProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute(product);
		return "productDetail";
	}
	@RequestMapping(value = "admin/productInventory/productDetails/{productId}", method = RequestMethod.GET)
	public String getAdminProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(Integer.parseInt(productId));
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
	public String addProductInInventory(@ModelAttribute("product") Product product, HttpServletRequest request) {
		productDao.addProduct(product);
		String saveDirectory = "E:/Test/Upload/";
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getContextPath();
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		System.out.println(">>>>"+path.toString());
		if(productImage != null && !productImage.isEmpty()) {
			try{
			productImage.transferTo(new File(saveDirectory+product.getProductId()));
			System.out.println("saved successfully");
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed.");
			}
		}
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value = "/admin/productInventory/productDetails/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") String productId,Model model) {
		productDao.deleteProduct(Integer.parseInt(productId));
		return "redirect:/admin/productInventory";
	}
	
}
