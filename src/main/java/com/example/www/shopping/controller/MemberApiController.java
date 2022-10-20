package com.example.www.shopping.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.www.shopping.domain.MemberBean;
import com.example.www.shopping.service.MemberService;


@RestController
@RequestMapping(path={"/api/members"})
public class MemberApiController {
	@Autowired private MemberService memberService;
	
	@GetMapping("/")
	public ResponseEntity<List<MemberBean>> findAll() {
		List<MemberBean> select = memberService.select(null);
		return ResponseEntity.ok(select);
	}
	@GetMapping("/account/{memmail}")
	public ResponseEntity<?> findacc(@PathVariable String memmail) {
		MemberBean bean = new MemberBean();
		bean.setMemmail(memmail);
		List<MemberBean> select = memberService.selectacc(bean);
		if(select != null && !select.isEmpty()) {
			return ResponseEntity.ok(select.get(0));
			//回傳第一筆資料
		}else {
//			ResponseEntity.HeadersBuilder<?> builder = ResponseEntity.notFound();
//			ResponseEntity<?> xxx = builder.build();
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{name}/{password}")
	public ResponseEntity<?> findByName(@PathVariable String name, @PathVariable String password) {
		MemberBean bean = new MemberBean();
		bean.setName(name);
		bean.setPassword(password);
		List<MemberBean> select = memberService.select(bean);
		if(select != null && !select.isEmpty()) {
			return ResponseEntity.ok(select.get(0));
			//回傳第一筆資料
		}else {
//			ResponseEntity.HeadersBuilder<?> builder = ResponseEntity.notFound();
//			ResponseEntity<?> xxx = builder.build();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> newOne(@RequestBody MemberBean bean) {
		MemberBean result = memberService.insert(bean);
		if(result!=null) {
			URI uri = URI.create("/api/members/"+result.getName());
			return ResponseEntity.created(uri).body(result);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/renew/{memberid}")
	public ResponseEntity<?> fix(@PathVariable(name="memberid") Integer memberid, MemberBean bean) {
		MemberBean result = memberService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();			
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> trash(@PathVariable(name="id") Integer id) {
		MemberBean bean = new MemberBean();
		bean.setMemberid(id);
		boolean result = memberService.delete(bean);
		if(result) {
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.notFound().build();			
		}
	}
	
	
}
