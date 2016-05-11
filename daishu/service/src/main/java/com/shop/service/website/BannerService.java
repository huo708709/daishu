package com.shop.service.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.website.Banner;
import com.shop.data.mapper.website.BannerMapper;
import com.shop.service.AbstractService;

@Service
public class BannerService extends AbstractService<Banner> {

	@Autowired
	private BannerMapper bannerMapper;
	
	public BannerService() {
		super(Banner.class);
	}
	
	public List<Banner> selectActiveBanner(int type) {
		return this.bannerMapper.selectActiveBanner(type);
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.bannerMapper;
	}

}
