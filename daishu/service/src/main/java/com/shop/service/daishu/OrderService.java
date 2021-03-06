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
	
	public Order selectByIdAndNo(int id, String orderNo) {
		return this.orderMapper.selectByIdAndNo(id, orderNo);
	}
	
	public Order selectByOrderNo(String orderNo) {
		return this.orderMapper.selectByOrderNo(orderNo);
	}

	public TableData listPagedOrderData(TableParameter parameter, String startTime, String endTime, int ayiId) {
		TableData tableData = new TableData();
		tableData.data = orderMapper.listPagedOrderData(parameter, startTime, endTime, ayiId);
		tableData.recordsFiltered = orderMapper.countOrderData(startTime, endTime, ayiId);
		tableData.recordsTotal = tableData.recordsFiltered;
		return tableData;
	}

	public void updatePayStatusByIds(int[] ids, int payStatus) {
		this.orderMapper.updatePayStatusByIds(ids, payStatus);
	}

	public void updateAuditStatusById(int id, int auditStatus) {
		this.orderMapper.updateAuditStatusById(id, auditStatus);
	}

	public void updatePayStatusAndPayTypeByIds(int[] ids, int payStatus, int payType) {
		this.orderMapper.updatePayStatusAndPayTypeByIds(ids, payStatus, payType);
	}
	
	public Order selectOrderDetail(int id) {
		return orderMapper.selectOrderDetail(id);
	}
	
	public int paySuccess(Order order) {
		return this.orderMapper.paySuccess(order);
	}
	
	public double selectPriceById(int id) {
		return this.orderMapper.selectPriceById(id);
	}
}
