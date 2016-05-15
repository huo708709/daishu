package com.shop.data.mapper.daishu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface ConsumeMapper extends AbstractMapper {
	
	public List<Order> selectByCustomerId(@Param("customerId") int customerId);
}
