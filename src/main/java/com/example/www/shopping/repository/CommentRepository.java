package com.example.www.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.www.shopping.domain.CommentBean;

@Repository
public interface CommentRepository extends JpaRepository<CommentBean, Integer>{
	CommentBean queryByContent(String content);
}
