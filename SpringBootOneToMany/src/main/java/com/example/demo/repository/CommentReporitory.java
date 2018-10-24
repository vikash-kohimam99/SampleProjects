package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;

public interface CommentReporitory extends JpaRepository<Comment, Long>{
	
	Page<Comment> findByPostId(Long postId, org.springframework.data.domain.Pageable pageable);

}
