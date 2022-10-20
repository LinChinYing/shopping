package com.example.www.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.www.shopping.service.MailService;
@Controller
public class MailApiController {
	@Autowired
	 private MailService mailService;
	 
	
	@GetMapping("/comment")
	 public String comment(){
	  return "redirect:/contact.html";
	 }
	
}
