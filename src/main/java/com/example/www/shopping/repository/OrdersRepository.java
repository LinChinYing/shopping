package com.example.www.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.www.shopping.domain.OrdersBean;
@Repository
public interface OrdersRepository extends JpaRepository<OrdersBean, Integer>{

}
