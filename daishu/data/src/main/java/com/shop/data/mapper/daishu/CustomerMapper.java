package com.shop.data.mapper.daishu;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface CustomerMapper extends AbstractMapper {
	
	/**
	 * 根据openid查询用户信息
	 * @param openid
	 * @return
	 */
	public Customer selectByOpenid(@Param("openid") String openid);
	
	/**
	 * 更新用户的会员余额
	 * @param id
	 * @param balance
	 * @return
	 */
	public int updateBalance(@Param("openid") String openid, @Param("balance") double balance);
}
