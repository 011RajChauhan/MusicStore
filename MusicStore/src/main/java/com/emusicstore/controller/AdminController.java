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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Product;

@Controller
public class AdminController {
	
	@SuppressWarnings("unused")
	private Path path;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "admin/productInventory/productDetails/{productId}", method = RequestMethod.GET)
	public String getAdminProductDetails(@PathVariable("productId") String productId, Model model) throws IOException {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute(product);
		return "productDetail";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("username",getUserName());
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
	public String addProductInInventory(@Valid @ModelAttribute Product product,BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		productDao.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		
        String rootDirectory = request.getSession().getServletContext().getRealPath("/")+"\\WEB-INF\\resources\\images\\";
        System.out.println(request.getSession().getServletContext().getRealPath("/"));
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory+product.getProductName()+"_"+product.getProductId()+".png"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value = "/admin/productInventory/productDetails/deleteProduct/{productId}", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/admin/productInventory/productDetails/editProduct/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("productId") String productId, Model model, HttpServletRequest request) {
		Product product = productDao.getProductById(Integer.parseInt(productId));
		model.addAttribute("product",product);
		return "editProduct";
	}
	
	@RequestMapping(value = "/admin/productInventory/productDetails/editProduct", method = RequestMethod.POST)
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
	
	private String getUserName() {
		String userName = null;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
