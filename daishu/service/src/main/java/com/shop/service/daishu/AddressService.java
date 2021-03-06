package com.shop.service.daishu;

import java.util.List;

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
	
	public List<Address> getAddressListByCustomerId(int customerId) {
		return this.addressMapper.getAddressListByCustomerId(customerId);
	}
	
	public int updateStatus(int id, int status) {
		return this.addressMapper.updateStatus(id, status);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.addressMapper;
	}

}
