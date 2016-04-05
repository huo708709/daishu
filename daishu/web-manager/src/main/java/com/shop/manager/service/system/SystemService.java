package com.shop.manager.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.system.UserMapper;
import com.shop.manager.service.InterfaceService;

@Service
public class SystemService extends InterfaceService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.userMapper;
	}

}
