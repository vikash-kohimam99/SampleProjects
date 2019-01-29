package com.example.demo.entity;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("All the Details ablout this Class")
public class User {

	private Integer id;
	@Size(min=2, message="Name Should have atleast 2 Characters")
	@ApiModelProperty(notes="The Name should have atlease 2 characters")
	private String name;
	@Past
	@ApiModelProperty(notes="Birth Date should always be in past")
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
