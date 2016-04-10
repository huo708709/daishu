package com.shop.data.mapper.daishu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface AddressMapper extends AbstractMapper {
	
	public List<Address> getAddressListByCustomerId(@Param("customerId") int customerId);
	
	/**
	 * 更新地址状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("id") int id, @Param("status") int status);
}
