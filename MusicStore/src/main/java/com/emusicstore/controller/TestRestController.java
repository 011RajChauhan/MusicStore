package com.emusicstore.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class TestRestController {
	@RequestMapping(method = RequestMethod.GET)
	public String testRest() {
		return "test successfull";
	}
	
	@RequestMapping(value = "cart/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable String id) {
		System.out.println("updated..."+id);
	}
}
