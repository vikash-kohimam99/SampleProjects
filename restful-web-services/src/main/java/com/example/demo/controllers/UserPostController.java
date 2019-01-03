package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserPostDaoService;
import com.example.demo.entity.UserPost;

@RestController
public class UserPostController {

	@Autowired
	private UserPostDaoService userPostDaoService;
	//Retrive all the user post based on the id
	
	@GetMapping(value="/users/{id}/posts")
	public List<UserPost> retrivePosts( @PathVariable int id) {
		return userPostDaoService.seeAllPosts(id);
		
	}
	
	@PostMapping(value="/user/create-post")
	public UserPost createUserPost(@RequestBody UserPost userPost) {
		userPostDaoService.createPost(userPost);
		return userPost;
	}
	
}
