package com.shop.service.daishu;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Unit;
import com.shop.data.mapper.daishu.UnitMapper;
import com.shop.service.AbstractService;

@Service
public class UnitService extends AbstractService<Unit> {

	@Autowired
	private UnitMapper unitMapper;
	
	public UnitService() {
		super(Unit.class);
	}
	
	public Unit selectByBaojieType(@Param("baojieType") int baojieType) {
		return this.unitMapper.selectByBaojieType(baojieType);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.unitMapper;
	}

}
