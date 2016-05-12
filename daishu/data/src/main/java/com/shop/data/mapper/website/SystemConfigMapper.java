package com.shop.data.mapper.website;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface SystemConfigMapper extends AbstractMapper {
	
	public void update(@Param("name") String name, @Param("value") String value);
	
	public String selectTel();
}
