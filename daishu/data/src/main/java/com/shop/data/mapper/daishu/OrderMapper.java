package com.shop.data.mapper.daishu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.model.TableParameter;

public interface OrderMapper extends AbstractMapper {

	void changeProperty(@Param("orderId") int orderId,@Param("name") String name, @Param("value") double value);

	List<Order> listOrdersByCustomerId(@Param("customerId") int customerId);

	List<Map<String,Object>> listPagedOrderData(@Param("tableParam") TableParameter parameter,@Param("startTime") String startTime,@Param("endTime") String endTime);
	public int countOrderData(@Param("startTime") String startTime,@Param("endTime") String endTime);

	void updatePayStatusByIds(@Param("ids")int[] ids);
}
