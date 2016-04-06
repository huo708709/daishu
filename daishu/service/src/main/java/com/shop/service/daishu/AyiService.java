package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Ayi;
import com.shop.data.mapper.daishu.AyiMapper;
import com.shop.service.AbstractService;

@Service
public class AyiService extends AbstractService<Ayi> {

	@Autowired
	private AyiMapper ayiMapper;
	
	public AyiService() {
		super(Ayi.class);
	}
	
	@Override
	public int insert(Ayi entity) {
		int id = super.insert(entity);
		ayiMapper.updateJobNo(entity.getId(), String.valueOf(1000 + entity.getId()));
		return id;
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.ayiMapper;
	}

}
