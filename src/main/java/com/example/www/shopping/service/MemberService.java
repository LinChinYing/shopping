package com.example.www.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.www.shopping.domain.MemberBean;
import com.example.www.shopping.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public MemberBean login(String name, String password) {
		MemberBean user = memberRepository.queryByNameAndPassword(name, password);
		if(user != null) {
		return user;
		}
		return null;
	}

	public List<MemberBean> select(MemberBean bean) {
		List<MemberBean> result = null;
		if (bean != null && bean.getName() != "" && bean.getPassword() != "") {
			//Optional<MemberBean> data = memberRepository.findByName(bean.getName());
			Optional<MemberBean> data = memberRepository.findByNameAndPassword(bean.getName(),bean.getPassword());
			if (data.isPresent()) {
				result = new ArrayList<MemberBean>();
				result.add(data.get());
			}
		} else {
			result = memberRepository.findAll();
		}
		return result;
	}

	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		if (bean != null && bean.getName() != null) {
			if (memberRepository.queryByName(bean.getName()) == null) {
				return memberRepository.save(bean);
			}
		}
		return result;
	}

	public MemberBean update(MemberBean bean) {
		System.out.println(bean.getName());
		System.out.println(bean.getMemberid());
		MemberBean result = null;
		if (bean != null && bean.getMemberid() != null) {
			if (memberRepository.existsById(bean.getMemberid())) {
				return memberRepository.save(bean);
			}

		}
		return result;
	}

	public boolean delete(MemberBean bean) {
		boolean result = false;
		if (bean != null && bean.getMemberid() != null) {
			if (memberRepository.existsById(bean.getMemberid())) {
				memberRepository.deleteById(bean.getMemberid());
				return true;
			}

		}
		return result;
	}
	public List<MemberBean> selectacc(MemberBean bean) {
		List<MemberBean> result = null;
		if (bean != null && bean.getMemmail() != "") {
			Optional<MemberBean> data = memberRepository.findByMemmail(bean.getMemmail());
//			Optional<MemberBean> data = memberRepository.findByNameAndPassword(bean.getName(),bean.getPassword());
			if (data.isPresent()) {
				result = new ArrayList<MemberBean>();
				result.add(data.get());
			}
		} else {
			result = memberRepository.findAll();
		}
		return result;
	}
}
