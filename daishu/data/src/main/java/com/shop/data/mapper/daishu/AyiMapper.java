package com.shop.data.mapper.daishu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface AyiMapper extends AbstractMapper {
	
	public int updateJobNo(@Param("id") int id, @Param("jobNo") String jobNo);
	public List<Map<String, Object>> selectWithOrderId(@Param("orderId") int orderId);
	public int assignAyi(@Param("orderId") int orderId, @Param("ayiId") int ayiId);
}
