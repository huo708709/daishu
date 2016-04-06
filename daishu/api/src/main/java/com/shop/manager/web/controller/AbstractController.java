package com.shop.manager.web.controller;

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
}
