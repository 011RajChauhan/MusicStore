package com.emusicstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.emusicstore.dao.CartDao;
import com.emusicstore.models.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	@Override
	public Cart create(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart read(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String cartId, Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String cartId) {
		// TODO Auto-generated method stub
		
	}
	
	/*private Map<String, Cart> listOfCarts;
	
	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}
	
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("A cart with the same ID is already added", cart.getCartId()));
		};
		listOfCarts.put(cart.getCartId(), cart);
		
		return cart;
	}
	
	public Cart read(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			//throw new IllegalArgumentException(String.format("cart cannot be found", cartId));
			return null;
		}
		return listOfCarts.get(cartId);
	}
	
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("cart cannot be found", cartId));
		}
		
		listOfCarts.put(cartId, cart);
	}
	
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("cart cannot be found", cartId));
		}
		listOfCarts.remove(cartId);
	}*/
}
