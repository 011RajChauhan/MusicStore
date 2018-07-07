package com.emusicstore.dao;

import com.emusicstore.models.Cart;

public interface CartDao {
	
	public Cart getCartById(int cartId);
	
	public void updateCart(Cart cart);
}
