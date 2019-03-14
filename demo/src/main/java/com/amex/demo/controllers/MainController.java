package com.amex.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		
		return "welcome";
	}

	
	@GetMapping("/index")
	public String indexPage(Model model) {
		
		return "index";
	}
}
