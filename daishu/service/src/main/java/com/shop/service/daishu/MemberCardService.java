package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.MemberCard;
import com.shop.data.mapper.daishu.MemberCardMapper;
import com.shop.service.AbstractService;

@Service
public class MemberCardService extends AbstractService<MemberCard> {

	@Autowired
	private MemberCardMapper memberCardMapper;
	
	public MemberCardService() {
		super(MemberCard.class);
	}
	public void update(String type,String name, String value) {
		this.memberCardMapper.update(type,name, value);
	}
	public MemberCard selectByType(String type){
		return this.memberCardMapper.selectByType(type);
	}
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.memberCardMapper;
	}

}
