package com.shop.service.daishu;

import java.util.List;
import java.util.Map;

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
	/**
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Map<String, Object>> selectWithOrderId(int orderId) {
		return this.ayiMapper.selectWithOrderId(orderId);
	}
	public int assignAyi(int orderId, int ayiId) {
		this.ayiMapper.assignAyi(orderId,ayiId);
		return 0;
	}
}
