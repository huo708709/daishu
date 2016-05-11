package com.shop.manager.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shop.data.mapper.daishu.Customer;
import com.shop.manager.web.filter.AclFilter;
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
	
	protected Customer getLoginCustomer(HttpSession session) {
		return (Customer) session.getAttribute(AclFilter.loginCustomer);
	}
	
	protected void setLoginCustomer(HttpSession session, Customer customer) {
		session.setAttribute(AclFilter.loginCustomer, customer);
	}
	
	protected Customer getLoginCustomer(HttpServletRequest request) {
		return (Customer) request.getSession().getAttribute(AclFilter.loginCustomer);
	}
	
	protected void setLoginCustomer(HttpServletRequest request, Customer customer) {
		request.getSession().setAttribute(AclFilter.loginCustomer, customer);
	}
}
