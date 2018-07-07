package com.emusicstore.services;

import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;

public interface CartItemService {

	public void updateCartItem(CartItem cartItem);
	
	public void addCartItem(CartItem cartItem);
	
	public void removeCartItem(CartItem cartItem);
	
	public void emptyCart(Cart cart);

	public CartItem getCartItemByProductId(int productId);

}
     