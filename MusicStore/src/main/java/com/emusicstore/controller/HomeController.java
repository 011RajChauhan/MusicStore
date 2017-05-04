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
	public String addProductInInventory(@ModelAttribute Product product, HttpServletRequest request) {
		
		productDao.addProduct(product);
		/*----------------------------------------------------------------------------------------------------------------
		 * upload file to local file system
		 */
		String uploads = "E:/eMusicStore/uploads/images/";
		
		MultipartFile productImage = product.getProductImage();
		
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		System.out.println(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
        
        path = Paths.get(uploads +product.getProductId()+".png");
        
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
       
		
		/*-----------------------------------------------------------------------------------------------------------------
		 * uploding file to webapp could not be achieved as don'nt know how to change output directory
		 * 
		 * MultipartFile productImage = product.getProductImage();
		
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
			System.out.println(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
	        
	        path = Paths.get(uploads +product.getProductId()+".png");
	        
	        if (productImage != null && !productImage.isEmpty()) {
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception e) {
	                e.printStackTrace();
	                throw new RuntimeException("Product image saving failed", e);
	            }
	        }
      		------------------------------------------------------------------------------------------------------------------
        */
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping(value = "/admin/productInventory/productDetails/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") String productId,Model model) {
		productDao.deleteProduct(Integer.parseInt(productId));
		return "redirect:/admin/productInventory";
	}
	
}
