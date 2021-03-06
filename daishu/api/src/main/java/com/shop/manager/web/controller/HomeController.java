package com.shop.manager.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.shop.data.mapper.daishu.MemberCard;
import com.shop.data.mapper.daishu.Order;
import com.shop.data.mapper.daishu.Unit;
import com.shop.data.mapper.website.Banner;
import com.shop.data.mapper.website.SystemConfig;
import com.shop.manager.util.CommonUtil;
import com.shop.manager.util.ConfigUtil;
import com.shop.manager.util.PayCommonUtil;
import com.shop.manager.util.weixin.SignatureUtil;
import com.shop.manager.web.filter.AclFilter;
import com.shop.service.AbstractService;
import com.shop.service.daishu.ConsumeService;
import com.shop.service.daishu.CustomerService;
import com.shop.service.daishu.MemberCardService;
import com.shop.service.daishu.OrderService;
import com.shop.service.daishu.UnitService;
import com.shop.service.website.BannerService;
import com.shop.service.website.BusinessService;
import com.shop.service.website.SystemConfigService;

@Controller
public class HomeController extends AbstractController<Object> {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UnitService unitService;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private ConsumeService consumeService;

	@RequestMapping(value = "index")
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		Map<Object, Map<String, Object>> businessMap = this.businessService.getBusinessMap();
		mav.addObject("businessMap", businessMap);
		List<Banner> banners = bannerService.selectActiveBanner(Banner.TYPE_H5);
		mav.addObject("banners", banners);
		return mav;
	}
	
	@RequestMapping(value = "xieyi")
	public ModelAndView xieyi(HttpSession session) {
		ModelAndView mav = new ModelAndView("xieyi");
		SystemConfig systemConfig = this.systemConfigService.selectById(1);
		mav.addObject("systemConfig", systemConfig);
		return mav;
	}
	
	@RequestMapping(value = "guize")
	public ModelAndView guize(HttpSession session) {
		ModelAndView mav = new ModelAndView("guize");
		SystemConfig systemConfig = this.systemConfigService.selectById(1);
		mav.addObject("systemConfig", systemConfig);
		return mav;
	}

	@RequestMapping(value = "auth")
	public ModelAndView auth(HttpServletRequest request, String code, String state) {
		Customer loginCustomer = this.getLoginCustomer(request);
		if (null == loginCustomer) {
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
				session.setAttribute(AclFilter.loginCustomer, customer);
				session.setAttribute(AclFilter.CODE, code);
				session.setAttribute(AclFilter.OPENID, openid);
				ModelAndView mav = new ModelAndView("redirect:/index");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/index");
				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("redirect:/index");
			return mav;
		}
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

	String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
	@RequestMapping(value = "baojie")
	public ModelAndView baojie(int type, String title) throws Exception {
		ModelAndView mav = null;
		if (2 == type || 3 == type || 7 == type || 8 == type || 9 == type) {
			mav = new ModelAndView("baojie1");
		} else {
			mav = new ModelAndView("baojie");
		}
		List<Map<String, String>> dates = new ArrayList<Map<String, String>>();
		long time = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("M-d");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("YYYY-MM-dd");
		int days = 7;
		if (2 == type || 3 == type || 7 == type || 8 == type || 9 == type) {
			days = 3;
		}
		for (int i = 0; i < days; i++) {
			Date date = new Date(time + i * 1000 * 60 * 60 * 24);
			Map<String, String> map = new HashMap<String, String>();
			map.put("date", dateFormat.format(date));
			map.put("dateFormat", dateFormat1.format(date));
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			if (0 == i) {
				map.put("week", "今天");
			} else if (1 == i) {
				map.put("week", "明天");
			} else if (2 == i) {
				map.put("week", "后天");
			} else {
				map.put("week", weekDays[cal.get(Calendar.DAY_OF_WEEK) - 1]);
			}
			dates.add(map);
		}
		mav.addObject("dates", dates);
		mav.addObject("baojieType", type);
		Unit unit = unitService.selectByBaojieType(type);
		mav.addObject("unit", unit);
		mav.addObject("title", title);
		return mav;
	}

	@RequestMapping(value = "vip")
	public ModelAndView vip(HttpSession session) {
		Customer customer = this.getLoginCustomer(session);
		double balance = this.customerService.getBalance(customer.getId());
		ModelAndView mav = new ModelAndView("vip");
		String code = (String) session.getAttribute(AclFilter.CODE);
		String nonceStr = PayCommonUtil.CreateNoncestr();
		Map<String, String> sign = SignatureUtil.getSignMap(nonceStr, "http://daishuguanjia.cn/api/vip");
		mav.addObject("appId", ConfigUtil.APPID);
		mav.addObject("sign", sign);
		mav.addObject("code", code);
		
		Map<String, MemberCard> cards = memberCardService.selectGroupByType();
		mav.addObject("cards", cards);
		mav.addObject("balance", balance);
		return mav;
	}
	
	@RequestMapping(value = "consumeDetail")
	public ModelAndView consumeDetail(HttpSession session) {
		Customer customer = this.getLoginCustomer(session);
		ModelAndView mav = new ModelAndView("consumeDetail");
		List<Order> orders = consumeService.selectByCustomerId(customer.getId());
		mav.addObject("orders", orders);
		return mav;
	}
	
	@RequestMapping(value = "userCenter")
	public ModelAndView userCenter(HttpSession session) {
		Customer customer = this.getLoginCustomer(session);
		ModelAndView mav = new ModelAndView("userCenter");
		List<Order> orders = orderService.listOrdersByCustomerId(customer.getId());
		mav.addObject("orders", orders);
		
		String code = (String) session.getAttribute(AclFilter.CODE);
		String nonceStr = PayCommonUtil.CreateNoncestr();
		Map<String, String> sign = SignatureUtil.getSignMap(nonceStr, "http://daishuguanjia.cn/api/userCenter");
		mav.addObject("appId", ConfigUtil.APPID);
		mav.addObject("sign", sign);
		mav.addObject("code", code);
		
		String tel = systemConfigService.selectTel();
		mav.addObject("tel", tel);
		
		return mav;
	}

	@Override
	public AbstractService<Object> getAbstractService() {
		return null;
	}
}
