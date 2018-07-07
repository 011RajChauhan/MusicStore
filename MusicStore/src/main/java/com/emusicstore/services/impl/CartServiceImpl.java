package com.emusicstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.CartDao;
import com.emusicstore.models.Cart;
import com.emusicstore.services.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	@Override
	public void updateCart(Cart cart) {
		
		cartDao.updateCart(cart);
	}

	@Override
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

}
