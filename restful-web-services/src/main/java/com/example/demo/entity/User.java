package com.example.demo.entity;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Date dob;
	private UserPost userPost;
	
	//Default Constructor
	public User() {
		//default
	}
	//User with Post Constructor
	public User(Integer id, String name, Date dob, UserPost userPost) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.userPost = userPost;
	}

	//User Constructor
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	

	public UserPost getUserPost() {
		return userPost;
	}

	public void setUserPost(UserPost userPost) {
		this.userPost = userPost;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", userPost=" + userPost + "]";
	}
	
	
	
}
