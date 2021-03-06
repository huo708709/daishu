package com.shop.manager.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.data.model.TableData;
import com.shop.data.model.TableParameter;
import com.shop.manager.shiro.ShiroDbRealm;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;


public abstract class AbstractController<T> {
	
	public abstract AbstractService<T> getAbstractService();

	protected ResponseData response(String message, Object data) {
		return new ResponseData(message, data);
	}

	protected ResponseData response(String message, String action, Object data) {
		return new ResponseData(message, action, data);
	}

	protected ResponseData response(String message, String action) {
		return new ResponseData(message, action);
	}

	protected ResponseData response(int code, String message, String action, Object data) {
		return new ResponseData(code, message, action, data);
	}

	protected ResponseData response(int code, String message, String action) {
		return new ResponseData(code, message, action);
	}
	
	protected ShiroDbRealm.ShiroUser getShiroUser() {
		Subject subject = SecurityUtils.getSubject();
		ShiroDbRealm.ShiroUser shiroUser = (ShiroDbRealm.ShiroUser)subject.getPrincipal();
		return shiroUser;
	}
	
	@ResponseBody
	@RequestMapping(value = "list_paged")
	public TableData listPaged(TableParameter parameter, T entity) {
		return this.getAbstractService().listPaged(parameter, entity);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ResponseData delete(@RequestParam("ids[]") int[] ids) {
		this.getAbstractService().deleteByIds(ids);
		return this.response("删除成功", ResponseData.ACTION_TOAST);
	}
	
//	@InitBinder
//	protected void initBinder(HttpServletRequest request,
//            ServletRequestDataBinder binder) throws Exception {
////		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	    CustomDateEditor dateEditor = new CustomDateEditor(format, true);
//	    binder.registerCustomEditor(Date.class, dateEditor);
//	}
}
