package com.shop.manager.mapper.website;

import java.util.List;

import com.shop.manager.mapper.AbstractMapper;

public interface NewsMapper extends AbstractMapper {
	
	public List<News> selectTop5();
	
}
