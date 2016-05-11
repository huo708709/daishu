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
	
	public Customer selectByOpenid(String openid) {
		return this.customerMapper.selectByOpenid(openid);
	}
	
	public int updateBalance(int customerId, double balance) {
		return this.customerMapper.updateBalance(customerId, balance);
	}
	
	public double getBalance(int id) {
		return this.customerMapper.getBalance(id);
	}
	
	public int updatePhoneAndName(int id, String name, String phone) {
		return this.customerMapper.updatePhoneAndName(id, name, phone);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.customerMapper;
	}

}
