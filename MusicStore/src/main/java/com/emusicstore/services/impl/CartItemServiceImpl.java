package com.emusicstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.CartItemDao;
import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;
import com.emusicstore.services.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void removeCartItem(CartItem cartItem) {
		
		cartItemDao.removeCartItem(cartItem);
	}


	@Override
	public void updateCartItem(CartItem cartItem) {
		
		cartItemDao.updateCartItem(cartItem);
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		
		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void emptyCart(Cart cart) {
		
		cartItemDao.EmptyCart(cart);
	}


	@Override
	public CartItem getCartItemByProductId(int productId) {
		
		return cartItemDao.getCartItemByProductId(productId);
	}	

}
