package com.shop.service.daishu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public MemberCard selectByType(int type) {
		return this.memberCardMapper.selectByType(type);
	}

	public Map<String, MemberCard> selectGroupByType() {
		Map<String, MemberCard> map = new HashMap<String, MemberCard>();
		List<MemberCard> list = this.memberCardMapper.listAll();
		for (MemberCard memberCard : list) {
			if (1 == memberCard.getType()) {
				map.put("mama", memberCard);
			} else if (2 == memberCard.getType()) {
				map.put("baba", memberCard);
			} else if (3 == memberCard.getType()) {
				map.put("baobao", memberCard);
			}
		}
		return map;
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.memberCardMapper;
	}

}
