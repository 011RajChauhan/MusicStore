package com.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.models.BillingAddress;
import com.emusicstore.models.Cart;
import com.emusicstore.models.Customer;
import com.emusicstore.models.CustomerOrder;
import com.emusicstore.models.ShippingAddress;
import com.emusicstore.services.CartService;
import com.emusicstore.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/addOrder/{cartId}")
	public String addOrder(@PathVariable int cartId) {
		
		Cart cart = cartService.getCartById(cartId);
		
		Customer customer = cart.getCustomer();
		BillingAddress billingAddress = customer.getBillingAddress();
		ShippingAddress shippingAddress = customer.getShippingAddress(); 
		CustomerOrder order = new CustomerOrder();
		
		order.setCart(cart);
		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);
		order.setCustomer(customer);
		orderService.addOrder(order);
		return "redirect:/checout?cartId="+cartId;
	}
}
