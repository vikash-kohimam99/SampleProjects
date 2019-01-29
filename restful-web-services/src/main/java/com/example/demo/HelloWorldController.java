package com.example.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET, value="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	
	@GetMapping(value="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(value="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVar(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@RequestMapping(method=RequestMethod.GET, value="/hello-world-internationalization")
	//public String helloWorldInternationalization(@RequestHeader(name="Accept-Language", required=false)Locale locale) {
		public String helloWorldInternationalization() {

		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}

}
