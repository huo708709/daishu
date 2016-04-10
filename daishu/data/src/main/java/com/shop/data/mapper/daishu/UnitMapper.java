package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface UnitMapper extends AbstractMapper {
	
	public Unit selectByBaojieType(@Param("baojieType") int baojieType);
}
