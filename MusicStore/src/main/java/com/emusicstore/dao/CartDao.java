package com.emusicstore.dao;

import java.io.IOException;

import com.emusicstore.models.Cart;

public interface CartDao {
	
	public Cart getCartById(int cartId);
	
	public void updateCart(Cart cart);
	
	public Cart validate(int cartId) throws IOException;
}
