package com.shop.manager.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.manager.mapper.AbstractMapper;

public interface AyiMapper extends AbstractMapper {
	
	public int updateJobNo(@Param("id") int id, @Param("jobNo") String jobNo);
	
}
