package com.shop.service.daishu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Consume;
import com.shop.data.mapper.daishu.ConsumeMapper;
import com.shop.data.mapper.daishu.Order;
import com.shop.service.AbstractService;

@Service
public class ConsumeService extends AbstractService<Consume> {

	@Autowired
	private ConsumeMapper consumeMapper;
	
	public ConsumeService() {
		super(Consume.class);
	}
	
	public List<Order> selectByCustomerId(int customerId) {
		return this.consumeMapper.selectByCustomerId(customerId);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.consumeMapper;
	}

}
