package com.shoppingcart.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.order.dao.OrderRepository;
import com.shoppingcart.order.model.OrderMaster;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	/*
	 * add a order
	 */
	public OrderMaster addOrder(OrderMaster orderMaster){
		return orderRepository.save(orderMaster);
	}
	
	
	
	

}
