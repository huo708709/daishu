package com.shop.data.mapper.website;

import java.util.List;
import java.util.Map;

import com.shop.data.mapper.AbstractMapper;

public interface BusinessMapper extends AbstractMapper {
	public List<Map<String, Object>> listMap();
}
