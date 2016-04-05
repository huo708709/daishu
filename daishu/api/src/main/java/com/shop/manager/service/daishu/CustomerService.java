package com.shop.manager.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.daishu.Customer;
import com.shop.manager.mapper.daishu.CustomerMapper;
import com.shop.manager.service.AbstractService;

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
