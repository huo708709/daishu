package com.shop.manager.mapper.website;

import org.apache.ibatis.annotations.Param;

import com.shop.manager.mapper.AbstractMapper;

public interface SystemConfigMapper extends AbstractMapper {
	
	public void update(@Param("name") String name, @Param("value") String value);
}
