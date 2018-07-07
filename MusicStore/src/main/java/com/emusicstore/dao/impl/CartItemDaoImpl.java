package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CartItemDao;
import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public void removeCartItem(CartItem cartItem) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	@Override
	public void EmptyCart(Cart cart) {
		
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item: cartItems) {
			removeCartItem(item);
		}
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId=?");
		query.setInteger(0, productId);
		session.flush();
		return (CartItem) query.uniqueResult();
	}

}
