package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface ScheduleMapper extends AbstractMapper {
	public void update(@Param("baojieType") int baojieType,@Param("name") String name, @Param("value") String value);

	public int countOrderByServiceDateAndTimeTypeAndBaoJieType(@Param("baoJieType") int baoJieType,@Param("serviceDate") String serviceDate,@Param("serviceTimeType") int serviceTimeType);

	public int countAyiByxingqiNumAndBaoJieType(@Param("xingqiNum") String xingqiNum,@Param("baoJieType") int baoJieType);
}
