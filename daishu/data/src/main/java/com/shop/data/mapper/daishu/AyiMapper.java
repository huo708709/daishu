package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface AyiMapper extends AbstractMapper {
	
	public int updateJobNo(@Param("id") int id, @Param("jobNo") String jobNo);
	
}
