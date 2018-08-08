package com.redisdemo.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redisdemo.example.model.User;
import com.redisdemo.example.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserResourceController {

	private UserRepository userRepository;

	public UserResourceController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/add/{id}/{name}")
	public User add(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.save(new User(id, name, 20000L));		
		return userRepository.findBy(id);
	}

	@GetMapping("/update/{id}/{name}")
	public Map<String, User> update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.update(new User(id, name, 20000L));
		return all(); 
 
	}

	@GetMapping("/all")
	public Map<String, User> all() {
		return userRepository.findAll();

	}
	@GetMapping("/delete/{id}")
	public Map<String, User> delete(@PathVariable("id") final String id) {
		userRepository.delete(id);
		return all();

	}
}
