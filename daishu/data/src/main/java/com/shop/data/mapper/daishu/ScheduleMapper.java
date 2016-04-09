package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface ScheduleMapper extends AbstractMapper {
	public void update(@Param("name") String name, @Param("value") String value);
}
