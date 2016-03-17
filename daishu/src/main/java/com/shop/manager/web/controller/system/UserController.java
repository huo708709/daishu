package com.shop.manager.web.controller.system;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.system.User;
import com.shop.manager.service.AbstractService;
import com.shop.manager.service.system.UserService;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;

@Controller
@RequestMapping(value = "system/user")
public class UserController extends AbstractController<User> {

	@Autowired
	private UserService userService;

	@RequestMapping
	@RequiresPermissions("user:access")
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("system/user/user");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	@RequiresPermissions("user:add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("system/user/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@RequiresPermissions("user:add")
	public ResponseData add(User user) {
		user.setCreateTime(new Date());
		user.setStatus(User.STATUS_NORMAL);
		this.getAbstractService().insert(user);
		return this.response("添加用户成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	@RequiresPermissions("user:update")
	public ModelAndView update(int id) {
		User user = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("system/user/update");
		mav.addObject("user", user);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@RequiresPermissions("user:update")
	public ResponseData update(User user) {
		this.getAbstractService().update(user);
		return this.response("修改用户成功", ResponseData.ACTION_TOAST);
	}
	
	@ResponseBody
	@RequestMapping(value = "update/status/{status}", method = RequestMethod.POST)
	@RequiresPermissions("user:update_status")
	public ResponseData updateStatus(@PathVariable("status") int status, int id) {
		this.userService.updateStatus(id, status);
		return this.response("更新用户状态成功", ResponseData.ACTION_TOAST);
	}
	
	@ResponseBody
	@RequestMapping(value = "assign_roles")
	@RequiresPermissions("user:assign_role")
	public ResponseData assignRoles(int userId, @RequestParam(required = false, value = "roleIds[]") int[] roleIds) {
		this.userService.assignRoles(userId, roleIds);
		return this.response("分配角色成功", ResponseData.ACTION_TOAST);
	}

	@Override
	public AbstractService<User> getAbstractService() {
		return this.userService;
	}
}
