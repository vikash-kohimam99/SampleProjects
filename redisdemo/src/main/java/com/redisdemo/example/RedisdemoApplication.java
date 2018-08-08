package com.redisdemo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.redisdemo.example.model.User;

@SpringBootApplication
public class RedisdemoApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setHostName("localhost");
//		jedisConnectionFactory.setPort(6379);
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplete() {
		RedisTemplate<String, User> redisTemplete = new RedisTemplate<>();
		redisTemplete.setConnectionFactory(jedisConnectionFactory());
		return redisTemplete;
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisdemoApplication.class, args);
	}
}
