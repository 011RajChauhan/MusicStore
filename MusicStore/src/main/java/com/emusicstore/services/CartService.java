package com.emusicstore.services;

import com.emusicstore.models.Cart;

public interface CartService {

	public Cart getCartById(int cartId);
	
	public void updateCart(Cart cart);
	
}
