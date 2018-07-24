package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.models.Authorities;
import com.emusicstore.models.Cart;
import com.emusicstore.models.Customer;
import com.emusicstore.models.Users;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		customer.setEnabled(true);
		customer.getBillingAddress().setCustomer(customer);  
		customer.getShippingAddress().setCustomer(customer);
		session.saveOrUpdate(customer);
	
		session.saveOrUpdate(customer.getBillingAddress()); 
		session.saveOrUpdate(customer.getShippingAddress()); 
		
		Users user = new Users();
		user.setCustomerId(customer.getCustomerId());
		user.setEnabled(customer.isEnabled());
		user.setPassword(customer.getPassword());
		user.setUsername(customer.getUsername());
		
		Authorities authority = new Authorities();
		authority.setAuthority("ROLE_USER");
		authority.setUsername(customer.getUsername());
		
		session.saveOrUpdate(user);
		session.saveOrUpdate(authority);
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
	
		session.saveOrUpdate(customer);
		session.saveOrUpdate(cart);
		
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Customer)session.get(Customer.class, customerId);
	}

	
	@Override
	public Customer getCustomerByUserName(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer where username = ? ");
		query.setString(0, userName);
		return (Customer)query.uniqueResult();
	}

	@Override
	public List<Customer> getCustomersList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		return customerList;
	}

}
