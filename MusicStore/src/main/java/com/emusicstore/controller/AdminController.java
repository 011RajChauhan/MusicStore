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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.models.Product;
import com.emusicstore.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	private Path path;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/product/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("productList", products);
		return "productInventory";
	}
	
	@RequestMapping("/product/addProduct")
	public String getAddProductForm(Model model) {
		model.addAttribute("product", getProductDefaultValues());
		return "addProduct";
	}
	
	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute Product product, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		
		productService.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed "+e);
			}
		}
		
		return "redirect:/admin/product/productInventory";
	}
	
	
	@RequestMapping(value = "/product/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") String productId, HttpServletRequest request) {
		
		Product product = productService.getProductById(Integer.valueOf(productId));
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			}catch(IOException ioe) {
				System.out.println("error deleting image for the product, product cannot be deleted.");
				ioe.printStackTrace();
			}
		}
		productService.deleteProduct(product);
		return "redirect:/admin/product/productInventory";
	}
	
	@RequestMapping(value = "/product/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "editProduct";
	}
	
	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute Product product, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "editProduct";
		}
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		if(!productImage.isEmpty() && productImage != null) {
			try {
				productImage.transferTo(new File(path.toString()));
				
			}catch(Exception e) {
				System.out.println("image update failed");
				e.printStackTrace();
			}
		}
		productService.editProduct(product);
		return "redirect:/admin/product/productInventory";
	}
	@RequestMapping("/customer")
	public String customerManagement() {
		//to add some customer servies later.
		return "customerManagement";
	}
	
	private Product getProductDefaultValues() {
		
		Product product = new Product();
		product.setProductCondition("New");
		product.setProductPrice(0);
		product.setProductStatus("In Stock");
		product.setProductUnitInStock(1);
		
		return product;
	}
	/*@SuppressWarnings("unused")
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
                productImage.transferTo(new File(rootDirectory+product.getProductId()+".png"));
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
	}*/
}
