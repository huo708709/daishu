package com.shop.manager.web.controller.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.website.SystemConfig;
import com.shop.manager.service.AbstractService;
import com.shop.manager.service.website.SystemConfigService;
import com.shop.manager.web.controller.AbstractController;

@Controller
@RequestMapping("website/system_config")
public class SystemConfigController extends AbstractController<SystemConfig> {
	
	@Autowired
	private SystemConfigService systemConfigService;

	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("website/system_config/system_config");
		SystemConfig systemConfig = this.systemConfigService.selectById(1);
		mav.addObject("systemConfig", systemConfig);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(String name, String value) {
		try {
			this.systemConfigService.update(name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public AbstractService<SystemConfig> getAbstractService() {
		return this.systemConfigService;
	}

}
