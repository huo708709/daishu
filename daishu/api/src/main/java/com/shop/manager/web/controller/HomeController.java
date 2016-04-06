package com.shop.manager.web.controller;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.data.mapper.daishu.Customer;
import com.shop.manager.util.CommonUtil;
import com.shop.manager.util.ConfigUtil;
import com.shop.service.daishu.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "")
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping(value = "auth")
	public ModelAndView auth(HttpServletRequest request, String code, String state) {
		String requestUrl = ConfigUtil.OAUTH2_URL.replace("APPID", ConfigUtil.APPID).replace("SECRET", ConfigUtil.APP_SECRECT).replace("CODE", code);
		String result = CommonUtil.httpsRequest(requestUrl, "GET", null);
		JSONObject jsonObject = JSON.parseObject(result);
		String errcode = jsonObject.getString("errcode");
		
		if (StringUtils.isBlank(errcode)) {
			String accessToken = jsonObject.getString("access_token");
			String openid = jsonObject.getString("openid");
			
			requestUrl = ConfigUtil.USERINFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
			String detailresult = CommonUtil.httpsRequest(requestUrl, "GET", null);
			JSONObject detail = JSON.parseObject(detailresult);
			
			Customer customer = this.customerService.selectByOpenid(openid);
			if (null == customer) {
				// 第一次进入
				customer = new Customer();
				customer.setWeixinName(detail.getString("nickname"));
				customer.setFirstTime(new Date());
				customer.setLastTime(new Date());
				customer.setStatus(Customer.STATUS_NORMAL);
				customer.setName(detail.getString("nickname"));
				customer.setAddress(detail.getString("country") + detail.getString("province") + detail.getString("city"));
				customer.setDetail(detailresult);
				customer.setOpenid(openid);
				this.customerService.insert(customer);
			}
			HttpSession session = request.getSession();
			session.setAttribute("loginCustomer", customer);
		}
		
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping(value = "unauthorized", method = RequestMethod.GET)
	public ModelAndView unauthorized() {
		ModelAndView mav = new ModelAndView("unauthorized");
		return mav;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("loginout")
	public String loginout(HttpServletRequest request) {
		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			String s = em.nextElement().toString();
			request.getSession().removeAttribute(s);
		}
		return "login";
	}

	@RequestMapping(value = "baojie")
	public ModelAndView baojie(int type) {
		ModelAndView mav = new ModelAndView("baojie");
		return mav;
	}
}
