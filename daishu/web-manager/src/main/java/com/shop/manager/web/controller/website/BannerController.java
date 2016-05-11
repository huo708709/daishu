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

import com.shop.data.mapper.website.Banner;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.system.FileService;
import com.shop.service.website.BannerService;

@Controller
@RequestMapping("website/banner")
public class BannerController extends AbstractController<Banner> {

	@Autowired
	private BannerService bannerService;
	@Autowired
	private FileService fileService;

	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("website/banner/banner");
		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("website/banner/add");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile[] files,
			String title, String url, String description, int type) {

		Banner banner = new Banner();
		if (files.length > 0 && !files[0].isEmpty()) {
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/static/upload");
			banner.setFileId(fileService.insert(files[0], dir));
		}
		banner.setDescription(description);
		banner.setTitle(title);
		banner.setUserId(this.getShiroUser().getId());
		banner.setUrl(url);
		banner.setCreateTime(new Date());
		banner.setType(type);
		this.getAbstractService().insert(banner);
		return this.response("添加Banner成功", ResponseData.ACTION_TOAST);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Banner banner = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("website/banner/update");
		mav.addObject("banner", banner);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Banner banner) {
		this.getAbstractService().update(banner);
		return this.response("修改Banner成功", ResponseData.ACTION_TOAST);
	}

	@Override
	public AbstractService<Banner> getAbstractService() {
		return this.bannerService;
	}

}
