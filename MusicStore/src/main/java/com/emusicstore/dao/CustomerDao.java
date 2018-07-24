package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.models.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	
	public Customer getCustomerByUserName(String userName);

	public List<Customer> getCustomersList();
}
