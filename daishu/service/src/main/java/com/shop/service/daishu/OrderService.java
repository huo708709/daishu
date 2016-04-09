package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Order;
import com.shop.data.mapper.daishu.OrderMapper;
import com.shop.service.AbstractService;

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

	public void changeProperty(int orderId,String name, double value) {
		this.orderMapper.changeProperty(orderId,name, value);
	}

}
