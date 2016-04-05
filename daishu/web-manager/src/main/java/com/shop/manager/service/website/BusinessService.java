package com.shop.manager.service.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.website.Business;
import com.shop.manager.mapper.website.BusinessMapper;
import com.shop.manager.service.AbstractService;

@Service
public class BusinessService extends AbstractService<Business> {

	@Autowired
	private BusinessMapper businessMapper;
	
	public BusinessService() {
		super(Business.class);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.businessMapper;
	}

}
