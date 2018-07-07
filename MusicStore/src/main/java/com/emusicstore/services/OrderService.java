package com.emusicstore.services;

import com.emusicstore.models.Cart;
import com.emusicstore.models.CustomerOrder;

public interface OrderService {

	public void addOrder(CustomerOrder order);
	
	public double grandTotal(Cart cart);
}
