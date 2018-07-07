package com.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emusicstore.models.Customer;
import com.emusicstore.services.CustomerService;
@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public String getCart(@AuthenticationPrincipal User activeUser) {
		
		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());//i think at this point customer will have only cartId in it's cart variable 
		//because data base only stored cartId in customer table 
		//and that is what we are getting from database
		//and ultimately it sets's only the cart id property of cart variable in customer and leave others
		//thats why we will make another call to get cart details using this cart id
		//i am assuming here Cart will only have the cardId field populated
		int cartId = customer.getCart().getCartId();
		return "redirect:/customer/cart/"+cartId;
	}

	@RequestMapping("/{cartId}")
	public String cartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
		
		model.addAttribute("cartId",cartId);
		return "cart";
	}
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
