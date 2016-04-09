package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Consume;
import com.shop.data.mapper.daishu.ConsumeMapper;
import com.shop.service.AbstractService;

@Service
public class ConsumeService extends AbstractService<Consume> {

	@Autowired
	private ConsumeMapper consumeMapper;
	
	public ConsumeService() {
		super(Consume.class);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.consumeMapper;
	}

}
