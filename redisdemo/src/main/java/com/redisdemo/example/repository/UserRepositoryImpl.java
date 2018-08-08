/**
 * 
 */
package com.redisdemo.example.repository;

import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.redisdemo.example.model.User;

/**
 * @author Vikash Kumar
 *
 */
@Service
public class UserRepositoryImpl implements UserRepository {

	private RedisTemplate<String , User> redisTemplete;
	
	private HashOperations hashOperations;
	

	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplete) {
	
		this.redisTemplete = redisTemplete;
		hashOperations = redisTemplete.opsForHash();
	}
	
	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);

	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("USER");
	}

	
	

	@Override
	public void update(User user) {
		save(user);

	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id );

	}

	
	@Override
	public User findBy(String id) {
		return (User)hashOperations.get("User", id);
	}


}
