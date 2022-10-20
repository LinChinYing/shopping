package com.example.www.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.www.shopping.domain.CommentBean;
import com.example.www.shopping.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("/allcomment")
	private List<CommentBean> showcomments() {
		List<CommentBean> bean = commentService.select(null);
		return bean;
	}
	@PostMapping("/newcomment")
	private void insertcomment(String content,Integer memberid,String date) {
		CommentBean bean = new CommentBean();
		bean.setContent(content);
		bean.setMemberid(memberid);
		bean.setDate(date);
		commentService.insert(bean);
	}
}
