package com.shop.manager.mapper.website;

import java.util.List;

import com.shop.manager.mapper.AbstractMapper;

public interface BannerMapper extends AbstractMapper {
	
	public List<Banner> selectActiveBanner();
}
