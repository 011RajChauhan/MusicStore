package com.emusicstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.OrderDao;
import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;
import com.emusicstore.models.CustomerOrder;
import com.emusicstore.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	@Override
	public void addOrder(CustomerOrder order) {
		
		orderDao.addOrder(order);
	}

	@Override
	public double grandTotal(Cart cart) {
		
		double grandTotal =0;
		
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem cartItem: cartItems) {
			grandTotal+=cartItem.getTotalPrice();
		}
		
		return grandTotal;
	}

	
}
