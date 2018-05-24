package com.emusicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;
import com.emusicstore.models.Product;

@RestController
@RequestMapping("/rest/cart")
public class CartController {

	/*@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	//using only @ResponseBody annotation, other one is @ResponseEntity that gives more flexibility as can you response header etc.
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable("cartId") String cartId) {
		return cartDao.read(cartId);
	}
	
	rest test calls
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<String>testRestService() {
		List<String>list = new ArrayList<String>();
		list.add("rajan");
		return list;
	}
	
	@RequestMapping(value = "cart/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable String id) {
		System.out.println("updated..."+id);
	}
	
	rest test calls ends
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
		cartDao.update(cartId, cart);
	}
	
	@RequestMapping(value = "/cartId", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartDao.delete(cartId);
	}
	
	@RequestMapping(value = "add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable int productId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if(cart == null) {
		cart = cartDao.create(new Cart(sessionId));
		}		
		
		Product product = productDao.getProductById(productId);
		
		if(product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.addCartItem(new CartItem(product));
		
		cartDao.update(sessionId, cart);
	}
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if(cart != null) {}
		cart = cartDao.create(new Cart(sessionId));
		
		Product product = productDao.getProductById(productId);
		
		if(product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.removeCartItem(new CartItem(product));
		
		cartDao.update(sessionId, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "illegal request, please verify you payload.")
	public void handleClientError(Exception e) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "internal server error.")
	public void handleServerError(Exception e) {}*/
}
