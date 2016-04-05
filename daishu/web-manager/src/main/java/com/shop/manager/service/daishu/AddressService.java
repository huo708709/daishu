package com.shop.manager.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.daishu.Address;
import com.shop.manager.mapper.daishu.AddressMapper;
import com.shop.manager.service.AbstractService;

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
