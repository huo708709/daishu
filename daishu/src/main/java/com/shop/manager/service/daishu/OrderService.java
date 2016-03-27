package com.shop.manager.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.daishu.Order;
import com.shop.manager.mapper.daishu.OrderMapper;
import com.shop.manager.service.AbstractService;

@Service
public class OrderService extends AbstractService<Order> {

	@Autowired
	private OrderMapper orderMapper;
	
	public OrderService() {
		super(Order.class);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.orderMapper;
	}

}
