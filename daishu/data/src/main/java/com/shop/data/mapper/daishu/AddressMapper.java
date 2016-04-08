package com.shop.data.mapper.daishu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface AddressMapper extends AbstractMapper {
	
	public List<Address> getAddressListByCustomerId(@Param("customerId") int customerId);
}
