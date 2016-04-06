package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Address;
import com.shop.data.mapper.daishu.AddressMapper;
import com.shop.service.AbstractService;

@Service
public class AddressService extends AbstractService<Address> {

	@Autowired
	private AddressMapper addressMapper;
	
	public AddressService() {
		super(Address.class);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.addressMapper;
	}

}
