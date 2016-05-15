package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface RechargeMapper extends AbstractMapper {
	
	public int paySuccess(Recharge recharge);
	
	public Recharge selectByNo(@Param("outTradeNo") String outTradeNo);
}
