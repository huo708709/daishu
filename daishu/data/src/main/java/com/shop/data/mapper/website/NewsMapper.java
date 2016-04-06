package com.shop.data.mapper.website;

import java.util.List;

import com.shop.data.mapper.AbstractMapper;

public interface NewsMapper extends AbstractMapper {
	
	public List<News> selectTop5();
	
}
