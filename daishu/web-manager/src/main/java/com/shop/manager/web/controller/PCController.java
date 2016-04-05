package com.shop.manager.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.website.Banner;
import com.shop.manager.mapper.website.Business;
import com.shop.manager.mapper.website.News;
import com.shop.manager.mapper.website.SystemConfig;
import com.shop.manager.service.website.BannerService;
import com.shop.manager.service.website.BusinessService;
import com.shop.manager.service.website.NewsService;
import com.shop.manager.service.website.SystemConfigService;

@Controller
public class PCController {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private SystemConfigService systemConfigService;

	@RequestMapping(value = "")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("pc/index");
		List<News> news = newsService.selectTop5();
		List<Banner> banners = bannerService.selectActiveBanner();
		SystemConfig systemConfig = systemConfigService.selectById(1);
		mav.addObject("newsList", news);
		mav.addObject("banners", banners);
		mav.addObject("systemConfig", systemConfig);
		return mav;
	}

	@RequestMapping(value = "pc/news")
	public ModelAndView news() {
		ModelAndView mav = new ModelAndView("pc/news");
		List<News> news = newsService.selectTop5();
		mav.addObject("newsList", news);
		List<Banner> banners = bannerService.selectActiveBanner();
		mav.addObject("banners", banners);
		return mav;
	}

	@RequestMapping(value = "pc/news_detail")
	public ModelAndView newsDetail(String id) {
		ModelAndView mav = new ModelAndView("pc/news_detail");
		News news = newsService.selectById(id);
		List<Banner> banners = bannerService.selectActiveBanner();
		mav.addObject("banners", banners);
		mav.addObject("news", news);
		return mav;
	}

	@RequestMapping(value = "pc/business")
	public ModelAndView business() {
		ModelAndView mav = new ModelAndView("pc/business");
		List<Banner> banners = bannerService.selectActiveBanner();
		mav.addObject("banners", banners);
		List<Business> business = businessService.listAll();
		mav.addObject("business", business);
		return mav;
	}
}
