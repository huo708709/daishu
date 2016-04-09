package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface MemberCardMapper extends AbstractMapper {
	public void update(@Param("type") String type,@Param("name") String name, @Param("value") String value);

	public MemberCard selectByType(@Param("type") String type);
}
