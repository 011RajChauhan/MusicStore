package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.models.BillingAddress;
import com.emusicstore.models.Customer;
import com.emusicstore.models.ShippingAddress;

@Controller
public class CustomerRegisterController {

	@RequestMapping(value = "/register")
	public String getCustomerRegistrationForm(Model model) {
		
		Customer customer = new Customer();
		
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer", customer);
		
		return "customerRegistration";
	}
}
