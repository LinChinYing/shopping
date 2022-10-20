package com.example.www.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.www.shopping.domain.OrderDetailsBean;

import com.example.www.shopping.repository.OrderDetailsRepository;

@Service
@Transactional
public class OrderDetailsService {
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	public List<OrderDetailsBean> select(OrderDetailsBean bean) {
		List<OrderDetailsBean> result = null;
		if(bean!=null && bean.getOrderdetailsid()!=null && !bean.getOrderdetailsid().equals(0)) {
			Optional<OrderDetailsBean> data = orderDetailsRepository.findById(bean.getOrderdetailsid());
			if(data.isPresent()) {
				result = new ArrayList<OrderDetailsBean>();
				result.add(data.get());
			}
		} else {
			result = orderDetailsRepository.findAll();
		}
		return result;
	}

	public OrderDetailsBean insert(OrderDetailsBean bean) {
		
		OrderDetailsBean result = null;
		result = orderDetailsRepository.save(bean);
//		if(bean!=null && bean.getOrderdetailsid()!=null) {
//			if(!orderDetailsRepository.existsById(bean.getOrderdetailsid())) {
//				result = orderDetailsRepository.save(bean);
//			}
//		}
		return result;
	}

	public OrderDetailsBean update(OrderDetailsBean bean) {
		OrderDetailsBean result = null;
		result = orderDetailsRepository.save(bean);
//		if(bean!=null && bean.getOrderdetailsid()!=null) {
//			if(orderDetailsRepository.existsById(bean.getOrderdetailsid())) {
//				return orderDetailsRepository.save(bean);
//			}
//		}
		return result;
	}

	public boolean delete(OrderDetailsBean bean) {
		boolean result = false;
		if(bean!=null && bean.getOrderdetailsid()!=null) {
			if(orderDetailsRepository.existsById(bean.getOrderdetailsid())) {
				orderDetailsRepository.deleteById(bean.getOrderdetailsid());
				return true;
			}
		}
		return result;
	}









}
