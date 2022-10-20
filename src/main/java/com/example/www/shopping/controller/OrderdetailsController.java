package com.example.www.shopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.www.shopping.domain.OrderDetailsBean;
import com.example.www.shopping.service.OrderDetailsService;

@Controller
public class OrderdetailsController {
//	@Autowired
//	private OrderDetailsService orderDetailsService;
//	@PostMapping("/orderdetails")
//	public String newDetails(@RequestParam Map<String,String> map) {
//		OrderDetailsBean insert = new OrderDetailsBean();
//		insert.setLname(map.get("lname"));
//		insert.setQuantity(map.get("quantity"));
//		insert.setTotal(map.get("total"));
//		if(insert!=null && insert.getLname()!=null && insert.getQuantity()!=null && insert.getTotal()!=null) {
//			orderDetailsService.insert(insert);
//			return "redirect:/cartlab.html";
//		}
//		return 	"redirect:/cartlab.html";
//	}
}
