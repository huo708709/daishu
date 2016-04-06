package com.shop.data.mapper.website;

import java.util.List;

import com.shop.data.mapper.AbstractMapper;

public interface BannerMapper extends AbstractMapper {
	
	public List<Banner> selectActiveBanner();
}
