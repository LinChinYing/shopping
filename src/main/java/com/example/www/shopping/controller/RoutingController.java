package com.example.www.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutingController {
	@RequestMapping(path = {"/"})
	public String method1() {
		return "/index.html";
	}	
}
