package com.example.demo.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.limitsservice.Configuration;
import com.example.demo.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitFromConfiguration() {	
		
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
	}
	
	
	@GetMapping("/welcome")
	public String welcome() {
		return "String";
	}
	
}
