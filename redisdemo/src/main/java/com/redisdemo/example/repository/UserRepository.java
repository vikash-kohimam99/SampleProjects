package com.redisdemo.example.repository;

import java.util.Map;

import com.redisdemo.example.model.User;

public interface UserRepository {
	
	void save(User user);
	Map<String, User> findAll();
	void update(User user);
	void delete(String id);
	User findBy(String id);

}
