package com.example.www.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.www.shopping.domain.OrdersBean;
import com.example.www.shopping.repository.OrdersRepository;

@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	public List<OrdersBean> select(OrdersBean bean) {
		List<OrdersBean> result = null;
		if(bean!=null && bean.getOrderid()!=null && !bean.getOrderid().equals(0)) {
			Optional<OrdersBean> data = ordersRepository.findById(bean.getOrderid());
			if(data.isPresent()) {
				result = new ArrayList<OrdersBean>();
				result.add(data.get());
			}
		} else {
			result = ordersRepository.findAll();
		}
		return result;
	}

	public OrdersBean insert(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null && bean.getOrderid()!=null) {
			if(!ordersRepository.existsById(bean.getOrderid())) {
				result = ordersRepository.save(bean);
			}
		}
		return result;
	}

	public OrdersBean update(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null && bean.getOrderid()!=null) {
			if(ordersRepository.existsById(bean.getOrderid())) {
				return ordersRepository.save(bean);
			}
		}
		return result;
	}

	public boolean delete(OrdersBean bean) {
		boolean result = false;
		if(bean!=null && bean.getOrderid()!=null) {
			if(ordersRepository.existsById(bean.getOrderid())) {
				ordersRepository.deleteById(bean.getOrderid());
				return true;
			}
		}
		return result;
	}
}