package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam("error") String error,
			@RequestParam("logout") String logout, Model model) {
		if(error != null) {
			model.addAttribute("error", "invalid username or password.");
		}
		if(logout != null) {
			model.addAttribute("msg", "you have been logged out successfully.");
		}
		
		return "login";
	}
}
