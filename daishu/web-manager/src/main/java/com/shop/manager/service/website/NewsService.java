package com.shop.manager.service.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.website.News;
import com.shop.manager.mapper.website.NewsMapper;
import com.shop.manager.service.AbstractService;

@Service
public class NewsService extends AbstractService<News> {

	@Autowired
	private NewsMapper newsMapper;
	
	public NewsService() {
		super(News.class);
	}
	
	public List<News> selectTop5() {
		return this.newsMapper.selectTop5();
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.newsMapper;
	}

}
