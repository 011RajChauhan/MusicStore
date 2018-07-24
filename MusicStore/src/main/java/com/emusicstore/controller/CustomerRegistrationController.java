package com.emusicstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emusicstore.models.BillingAddress;
import com.emusicstore.models.Customer;
import com.emusicstore.models.ShippingAddress;
import com.emusicstore.services.CustomerService;

@Controller
public class CustomerRegistrationController {
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getCustomerRegistrationForm(Model model) {
		
		Customer customer = new Customer();
		
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer", customer);
		
		return "customerRegistration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute Customer customer,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "customerRegistration";
		}
		customerService.addCustomer(customer);
		model.addAttribute("customerName",customer.getCustomerName());
		return "customerRegistrationSuccess";
	}
}
