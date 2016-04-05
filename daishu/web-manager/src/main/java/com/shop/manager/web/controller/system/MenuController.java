package com.shop.manager.web.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.system.Menu;
import com.shop.manager.service.AbstractService;
import com.shop.manager.service.system.MenuService;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;

@Controller
@RequestMapping("system/menu")
public class MenuController extends AbstractController<Menu> {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("system/menu/menu");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("system/menu/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Menu menu) {
		menu.setStatus(Menu.STATUS_NORMAL);
		this.getAbstractService().insert(menu);
		return this.response("添加菜单成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Menu menu = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("system/menu/update");
		mav.addObject("menu", menu);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Menu menu) {
		this.getAbstractService().update(menu);
		return this.response("修改菜单成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "authorization")
	public ModelAndView authorizeMenu(int roleId) {
		ModelAndView mav = new ModelAndView("system/menu/authorize_menu");
		List<Map<String, Object>> permissions = this.menuService.selectAuthorizeMenu(roleId);
		mav.addObject("permissions", permissions);
		mav.addObject("roleId", roleId);
		return mav;
	}

	@Override
	public AbstractService<Menu> getAbstractService() {
		return this.menuService;
	}

}
