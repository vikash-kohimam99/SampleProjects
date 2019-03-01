/*package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UserPost;

@Component
public class UserPostDaoService {
	
	private static final org.slf4j.Logger log =LoggerFactory.getLogger(UserPostDaoService.class);
	private static List<UserPost> userPosts= new ArrayList();
		int count = 0;
	static {
		userPosts.add(new UserPost(32, "This is post One",1));
		userPosts.add(new UserPost(33, "This is post two",1));
		userPosts.add(new UserPost(34, "This is post three",3));
		userPosts.add(new UserPost(35, "This is post four",3));
	}

	
	//a user can create a post
	//a user can See all their post
	// a user can delete the post
	

	//See all the posts of a User
	public List<UserPost> seeAllPosts(int id) {		
			List<UserPost> oneUserPost = new ArrayList<>();
			for(UserPost posts: userPosts) {
				if(id==posts.getUserId()) {
					log.info("The Posts related to UserId :{} is :{} ", id,posts.toString());
				 oneUserPost.add(posts);
			}								
		}			
		return oneUserPost;	
		
	}
	
	//Requirement 2: A user can create a post
	public void createPost(UserPost userPost) {
		// A user can create a post, means This post has to be appended to the list userPosts
		// and each UserPost shold have a valid UserId.
		if(userPost.getPostId()==null) {
			userPost.setPostId(++count);
		}
		userPosts.add(userPost);
	}
	
	
}
*/