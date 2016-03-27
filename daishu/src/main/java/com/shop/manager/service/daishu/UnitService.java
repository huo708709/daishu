package com.shop.manager.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.daishu.Unit;
import com.shop.manager.mapper.daishu.UnitMapper;
import com.shop.manager.service.AbstractService;

@Service
public class UnitService extends AbstractService<Unit> {

	@Autowired
	private UnitMapper unitMapper;
	
	public UnitService() {
		super(Unit.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.unitMapper;
	}

}
