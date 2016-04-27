package com.shop.service.daishu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Order;
import com.shop.data.mapper.daishu.OrderMapper;
import com.shop.data.model.TableData;
import com.shop.data.model.TableParameter;
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
	public List<Order> listOrdersByCustomerId(int customerId){
		return this.orderMapper.listOrdersByCustomerId(customerId);
	}

	public TableData listPagedOrderData(TableParameter parameter, String startTime,String endTime) {
		TableData tableData = new TableData();
		tableData.data = orderMapper.listPagedOrderData(parameter, startTime,endTime);
		tableData.recordsFiltered = orderMapper.countOrderData(startTime,endTime);
		tableData.recordsTotal = tableData.recordsFiltered;
		return tableData;
	}

	public void updatePayStatusByIds(int[] ids) {
		this.orderMapper.updatePayStatusByIds(ids);
	}
}
