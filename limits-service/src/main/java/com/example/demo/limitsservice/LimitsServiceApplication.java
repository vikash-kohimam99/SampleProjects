package com.example.demo.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimitsServiceApplication {

	public static void main(String[] args) {
		System.out.println("Inside main methos of limits service");
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

}
