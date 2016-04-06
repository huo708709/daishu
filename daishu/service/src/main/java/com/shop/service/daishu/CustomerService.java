package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Customer;
import com.shop.data.mapper.daishu.CustomerMapper;
import com.shop.service.AbstractService;

@Service
public class CustomerService extends AbstractService<Customer> {

	@Autowired
	private CustomerMapper customerMapper;
	
	public CustomerService() {
		super(Customer.class);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.customerMapper;
	}

}
