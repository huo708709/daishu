package com.shop.manager.web.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.manager.util.CommonUtil;
import com.shop.manager.util.ConfigUtil;

@Controller
public class HomeController {

	@RequestMapping(value = "")
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping(value = "login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}


	@RequestMapping(value = "auth")
	public ModelAndView auth(String code, String state) {
		String requestUrl = ConfigUtil.OAUTH2_URL.replace("APPID", ConfigUtil.APPID).replace("SECRET", ConfigUtil.APP_SECRECT).replace("CODE", code);
		String result = CommonUtil.httpsRequest(requestUrl, "GET", null);
		JSONObject jsonObject = JSON.parseObject(result);
		String accessToken = jsonObject.getString("access_token");
		String openid = jsonObject.getString("openid");
		
		requestUrl = ConfigUtil.USERINFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
		result = CommonUtil.httpsRequest(requestUrl, "GET", null);
		System.out.println(result);
		
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
	
	@RequestMapping(value = "init")
	public void initDB() {
		
	}
}
