package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	//=======================URI versioning==============================
	@GetMapping("/v1/person")
	public PersonV1 personV1() {		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
    public Personv2 personV2() {
    	return new Personv2(new Name("Bob", "Charlie"));		
	}
	
	// There are different ways to implement versioning in the application : Listed below
	
	//=======================Parameter versioning==============================
	
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 paramV1() {		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/param",params="version=2")
    public Personv2 paramV2() {
    	return new Personv2(new Name("Bob", "Charlie"));		
	}
	
	
	//=======================Header versioning==============================
	

	@GetMapping(value="/person/header",headers="X-API-version=1")
	public PersonV1 headerV1() {		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/header",headers="X-API-version=2")
    public Personv2 headerV2() {
    	return new Personv2(new Name("Bob", "Charlie"));		
	}
	
	//=======================Mime Type/Produces versioning==============================
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
    public Personv2 producesV2() {
    	return new Personv2(new Name("Bob", "Charlie"));		
	}
}
