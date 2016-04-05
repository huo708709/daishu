package com.shop.manager.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.manager.service.AbstractService;
import com.shop.manager.web.model.ResponseData;
import com.shop.manager.web.model.TableData;
import com.shop.manager.web.model.TableParameter;


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
	
}
