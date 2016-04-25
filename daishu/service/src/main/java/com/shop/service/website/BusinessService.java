package com.shop.service.website;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<Object, Map<String, Object>> getBusinessMap() {
		Map<Object, Map<String, Object>> map = new HashMap<Object, Map<String, Object>>();
		List<Map<String, Object>> businessList = this.businessMapper.listMap();
		for (Map<String, Object> business : businessList) {
			map.put(business.get("code"), business);
		}
		return map;
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.businessMapper;
	}

}
