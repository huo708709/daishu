package com.shop.manager.web.controller.system;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.system.Role;
import com.shop.manager.service.AbstractService;
import com.shop.manager.service.system.RoleService;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;

@Controller
@RequestMapping("system/role")
public class RoleController extends AbstractController<Role> {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("system/role/role");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("system/role/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Role role) {
		this.getAbstractService().insert(role);
		return this.response("添加角色成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Role role = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("system/role/update");
		mav.addObject("role", role);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Role role) {
		this.getAbstractService().update(role);
		return this.response("修改角色成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "choice")
	public ModelAndView chooseRole(int userId) {
		ModelAndView mav = new ModelAndView("system/role/choose_role");
		List<Map<String, Object>> roles = this.roleService.selectWithUserId(userId);
		mav.addObject("roles", roles);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "authorize")
	public ResponseData authorize(int roleId, String functionIds) {
		int[] ids = null;
		if (StringUtils.isNotBlank(functionIds)) {
			String[] arr = functionIds.split(",");
			if (ArrayUtils.isNotEmpty(arr)) {
				ids = new int[arr.length];
				for (int i = 0; i < arr.length; i++) {
					ids[i] = Integer.valueOf(arr[i]);
				}
			}
		}
		this.roleService.authorize(roleId, ids);
		return this.response("授权成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Role> getAbstractService() {
		return this.roleService;
	}

}
