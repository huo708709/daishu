package com.shop.data.mapper.daishu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.model.TableParameter;

public interface OrderMapper extends AbstractMapper {

	public void changeProperty(@Param("orderId") int orderId,@Param("name") String name, @Param("value") double value);

	public List<Order> listOrdersByCustomerId(@Param("customerId") int customerId);

	public List<Map<String,Object>> listPagedOrderData(@Param("tableParam") TableParameter parameter,@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("ayiId") int ayiId);
	
	public int countOrderData(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("ayiId") int ayiId);
	
	public Order selectByIdAndNo(@Param("id") int id, @Param("orderNo") String orderNo);

	void updatePayStatusByIds(@Param("ids")int[] ids, @Param("payStatus") int payStatus);
	
	public Order selectOrderDetail(@Param("id") int id);
}
