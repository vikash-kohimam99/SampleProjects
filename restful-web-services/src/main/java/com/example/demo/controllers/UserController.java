package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.User;
import com.example.demo.entity.UserDaoService;
import com.example.demo.exceptions.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping(value="/users")
	public List<User> allUsers() {
		return userDaoService.findAll();
	}
	
	@PostMapping(value="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser= userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value="/users/{id}")
	public User findOneUser(@PathVariable int id) {
		User user= userDaoService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id - " +id +" Does not exist");
		}
		return user;
	}
	
	@DeleteMapping(value="/users/{id}/delete")
	public User deleteUser(@PathVariable int id) {
		return userDaoService.deleteById(id);
	}
}
