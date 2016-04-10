package com.shop.data.mapper.daishu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface OrderMapper extends AbstractMapper {

	void changeProperty(@Param("orderId") int orderId,@Param("name") String name, @Param("value") double value);

	List<Order> listOrdersByCustomerId(@Param("customerId") int customerId);
	
}
