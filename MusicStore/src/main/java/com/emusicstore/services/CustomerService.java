package com.emusicstore.services;

import java.util.List;

import com.emusicstore.models.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	
	public Customer getCustomerById(int customerId);
	
	
	public Customer getCustomerByUserName(String userName);

	public List<Customer> getCustomersList();
}
