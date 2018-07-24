package com.emusicstore.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CartDao;
import com.emusicstore.models.Cart;
import com.emusicstore.services.OrderService;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private OrderService orderService;

	@Override
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		//todo flush session later
		return (Cart) session.get(Cart.class, cartId);
	}

	@Override
	public void updateCart(Cart cart) {
		
		double grandTotal = orderService.grandTotal(cart);
		cart.setGrandTotal(grandTotal);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		
	}

	@Override
	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if(cart==null || cart.getCartItems().size()==0) {
			throw new IOException(cartId+"");
		}
		updateCart(cart);
		return cart;
	}

	
}
