package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("All the Details ablout this Class")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message="Name Should have atleast 2 Characters")
	@ApiModelProperty(notes="The Name should have atlease 2 characters")
	private String name;
	@Past
	@ApiModelProperty(notes="Birth Date should always be in past")
	private Date dob;
	
	@OneToMany(mappedBy="user")
	private List<UserPost> post;
	
	
	public User() {
		//default
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


	public List<UserPost> getPost() {
		return post;
	}

	public void setPost(List<UserPost> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
}
