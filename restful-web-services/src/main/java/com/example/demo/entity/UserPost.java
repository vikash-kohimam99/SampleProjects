package com.example.demo.entity;

import io.swagger.annotations.ApiModel;

@ApiModel("This Contains all the posts from the users")
public class UserPost  {

	private Integer postId;
	private String post;
	private Integer userId;
	
	
	
	public UserPost(Integer postId, String post, Integer userId) {
		super();
		this.postId = postId;
		this.post = post;
		this.userId = userId;
	}
	
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	


	
}
