package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Product;

@Controller
public class HomeController {
	
	private Path path;
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(value = "/")
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
	@GetMapping(value = "admin/productInventory/productDetails/{productId}")
	public String getAdminProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute(product);
		return "productDetail";
	}
	
	@GetMapping(value = "/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping(value = "/admin/productInventory")
	public String productInventory(Model model) {
		List<Product> productList = productDao.getAllProduct();
		model.addAttribute(productList);
		return "productInventory";
	}
		
	@GetMapping(value = "/admin/productInventory/addProduct")
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
	
	@PostMapping(value = "/admin/productInventory/addProduct")
	public String addProductInInventory(@Valid @ModelAttribute Product product,BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		productDao.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		
        String rootDirectory = request.getSession().getServletContext().getRealPath("/")+"\\WEB-INF\\resources\\images\\";
        
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory+product.getProductId()+".png"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping(value = "/admin/productInventory/productDetails/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") String productId,Model model,HttpServletRequest request) {
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/")+"\\WEB-INF\\resources\\images\\";
		Path path = Paths.get(rootDirectory+productId+".png");
		
		if(Files.exists(path)) {
			try{
				Files.delete(path);
			}catch(IOException ie) {
				ie.printStackTrace();
			}
		}
		productDao.deleteProduct(Integer.parseInt(productId));
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping(value = "/admin/productInventory/productDetails/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") String productId, Model model, HttpServletRequest request) {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute("product",product);
		return "editProduct";
	}
	
	@PostMapping(value = "/admin/productInventory/productDetails/editProduct")
	public String savedEditedProduct(@Valid @ModelAttribute Product product,BindingResult result, HttpServletRequest request) {
MultipartFile productImage = product.getProductImage();
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		productDao.editProduct(product);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/")+"\\WEB-INF\\resources\\images\\";
        
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory+product.getProductId()+".png"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        
		return "redirect:/admin/productInventory";
	}
}
