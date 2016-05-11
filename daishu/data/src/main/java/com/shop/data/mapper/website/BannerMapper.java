package com.shop.data.mapper.website;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface BannerMapper extends AbstractMapper {
	
	public List<Banner> selectActiveBanner(@Param("type") int type);
}
