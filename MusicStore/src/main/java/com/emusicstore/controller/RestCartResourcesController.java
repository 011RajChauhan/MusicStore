package com.emusicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;
import com.emusicstore.models.Customer;
import com.emusicstore.models.Product;
import com.emusicstore.services.CartItemService;
import com.emusicstore.services.CartService;
import com.emusicstore.services.CustomerService;
import com.emusicstore.services.ProductService;

@Controller
@RequestMapping(value = "/rest/cart")
public class RestCartResourcesController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping(value="/{cartId}")
	public @ResponseBody Cart getCart(@PathVariable(value="cartId") int cartId) {
		return cartService.getCartById(cartId);
	}
	
	@RequestMapping(value = "/addCartItem/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItemToCart(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {
		
		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
		
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartItems();
		Product product = productService.getProductById(productId);
		
		for(int i=0; i<cartItems.size(); i++) {
			if(product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(cartItem.getQuantity()*product.getProductPrice());
				cartItemService.updateCartItem(cartItem);
				return;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}
	
	@RequestMapping(value = "/removeCartItem/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable int productId) {
		
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping(value = "/emptyCart/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void emptyCart(@PathVariable int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.emptyCart(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "please check your payload.")
	public void handleClientError(Exception e) {};
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "internal server error occured.")
	public void handleInternalServerError(Exception e) {};
}
