package com.example.demo.controllers;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.example.demo.entity.UserPost;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@RestController
public class UserJPAResourceController {

	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping(value="/jpa/users")
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(value="/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser= userRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value="/jpa/users/{id}")
	public Optional<User> findOneUser(@PathVariable int id) {
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id - " +id +" Does not exist");
		}
		return user;
	}
	
	@DeleteMapping(value="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id, User user) {
		if(user.getId()!=null) {
		userRepository.deleteById(id);	
		}
		
	}
	
	@GetMapping(value="/jpa/users/{id}/posts")
	public List<UserPost> allUserPost(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id - " +id +" Does not exist");
		}
		return userOptional.get().getPost();
	}
	
	/**
	 * Create a new UserPost
	 */
	@PostMapping(value="/jpa/users/{id}/post")
	public ResponseEntity<Object> saveUserPost(@PathVariable int id, @Valid @RequestBody UserPost userPost) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id - " +id +" Does not exist");
		}
		
		User user = userOptional.get();
		userPost.setUser(user);
		postRepository.save(userPost);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userPost.getPostId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
