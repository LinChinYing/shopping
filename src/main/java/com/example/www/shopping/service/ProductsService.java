package com.example.www.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.www.shopping.domain.ProductsBean;
import com.example.www.shopping.repository.ProductsRepository;

@Service
@Transactional
public class ProductsService {
	@Autowired
	private ProductsRepository productsRepository;
	
	public List<ProductsBean> select(ProductsBean bean) {
		List<ProductsBean> result = null;
		if(bean!=null && bean.getProductid()!=null && !bean.getProductid().equals(0)) {
			Optional<ProductsBean> data = productsRepository.findById(bean.getProductid());
			if(data.isPresent()) {
				result = new ArrayList<ProductsBean>();
				result.add(data.get());
			}
		} else {
			result = productsRepository.findAll();
		}
		return result;
	}

	public ProductsBean insert(ProductsBean bean) {
		ProductsBean result = null;
		if(bean!=null && bean.getProductid()!=null) {
			if(!productsRepository.existsById(bean.getProductid())) {
				result = productsRepository.save(bean);
			}
		}
		return result;
	}

	public ProductsBean update(ProductsBean bean) {
		ProductsBean result = null;
		if(bean!=null && bean.getProductid()!=null) {
			if(productsRepository.existsById(bean.getProductid())) {
				return productsRepository.save(bean);
			}
		}
		return result;
	}

	public boolean delete(ProductsBean bean) {
		boolean result = false;
		if(bean!=null && bean.getProductid()!=null) {
			if(productsRepository.existsById(bean.getProductid())) {
				productsRepository.deleteById(bean.getProductid());
				return true;
			}
		}
		return result;
	}


	
	
}
