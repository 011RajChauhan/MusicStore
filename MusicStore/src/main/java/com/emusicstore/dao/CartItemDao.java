package com.emusicstore.dao;

import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;

public interface CartItemDao {

	public void addCartItem(CartItem cartItem);
	
	public void removeCartItem(CartItem cartItem);
	
	public void EmptyCart(Cart cart);
	
	public void updateCartItem(CartItem cartItem);
	
	public CartItem getCartItemByProductId(int productId);
}
