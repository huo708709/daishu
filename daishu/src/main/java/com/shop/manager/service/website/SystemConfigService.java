package com.shop.manager.service.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.website.SystemConfig;
import com.shop.manager.mapper.website.SystemConfigMapper;
import com.shop.manager.service.AbstractService;

@Service
public class SystemConfigService extends AbstractService<SystemConfig> {

	@Autowired
	private SystemConfigMapper systemConfigMapper;
	
	public SystemConfigService() {
		super(SystemConfig.class);
	}
	
	public void update(String name, String value) {
		this.systemConfigMapper.update(name, value);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.systemConfigMapper;
	}

}
