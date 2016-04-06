package com.shop.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.system.UserMapper;
import com.shop.service.InterfaceService;

@Service
public class SystemService extends InterfaceService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.userMapper;
	}

}
