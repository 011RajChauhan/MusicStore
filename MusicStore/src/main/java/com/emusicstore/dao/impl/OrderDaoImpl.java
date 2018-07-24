package com.emusicstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.OrderDao;
import com.emusicstore.models.CustomerOrder;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addOrder(CustomerOrder order) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
		session.flush();
	}

}
