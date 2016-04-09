package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Recharge;
import com.shop.data.mapper.daishu.RechargeMapper;
import com.shop.service.AbstractService;

@Service
public class RechargeService extends AbstractService<Recharge> {

	@Autowired
	private RechargeMapper rechargeMapper;
	
	public RechargeService() {
		super(Recharge.class);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.rechargeMapper;
	}

}
