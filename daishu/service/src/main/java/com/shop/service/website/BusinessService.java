package com.shop.service.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.website.Business;
import com.shop.data.mapper.website.BusinessMapper;
import com.shop.service.AbstractService;

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
