package com.example.www.shopping.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.www.shopping.domain.OrderDetailsBean;
import com.example.www.shopping.service.OrderDetailsService;

@RestController
@RequestMapping(path = {"/api/orderdetails"})
public class OrderdetailsApiController {

	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@GetMapping
	public ResponseEntity<List<OrderDetailsBean>> findAll() {
		List<OrderDetailsBean> result = orderDetailsService.select(null);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody OrderDetailsBean bean) {
		OrderDetailsBean result = orderDetailsService.insert(bean);
		if(result!=null) {
			URI uri = URI.create("/api/orderdetails/"+result.getOrderid());
			return ResponseEntity.created(uri).body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByPrimaryKey(@PathVariable("id") Integer id) {
		OrderDetailsBean bean = new OrderDetailsBean();
		bean.setOrderid(id);
		List<OrderDetailsBean> result = orderDetailsService.select(bean);
		if(result!=null && !result.isEmpty()) {
			return ResponseEntity.ok(result.get(0));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		OrderDetailsBean bean = new OrderDetailsBean();
		bean.setOrderid(id);
		boolean result = orderDetailsService.delete(bean);
		if(result) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody OrderDetailsBean bean) {
		OrderDetailsBean result = orderDetailsService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
