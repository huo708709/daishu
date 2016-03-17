package com.shop.manager.web.controller.website;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.website.News;
import com.shop.manager.service.AbstractService;
import com.shop.manager.service.system.FileService;
import com.shop.manager.service.website.NewsService;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;

@Controller
@RequestMapping("website/news")
public class NewsController extends AbstractController<News> {

	@Autowired
	private NewsService newsService;
	@Autowired
	private FileService fileService;

	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("website/news/news");
		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("website/news/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile[] files,
			String title, String digest, String content) {
		
		News news = new News();
		if (files.length > 0 && !files[0].isEmpty()) {
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/static/upload");
			news.setFileId(fileService.insert(files[0], dir));
		}
		news.setContent(content);
		news.setTitle(title);
		news.setDigest(digest);
		news.setUserId(this.getShiroUser().getId());
		news.setCreateTime(new Date());
		this.getAbstractService().insert(news);
		return this.response("添加新闻成功", ResponseData.ACTION_TOAST);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		News news = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("website/news/update");
		mav.addObject("news", news);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(News news) {
		this.getAbstractService().update(news);
		return this.response("修改新闻成功", ResponseData.ACTION_TOAST);
	}

	@Override
	public AbstractService<News> getAbstractService() {
		return this.newsService;
	}

}
