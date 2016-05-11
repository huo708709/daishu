package com.shop.manager.web.controller.daishu;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.shop.data.mapper.daishu.Comment;
import com.shop.data.mapper.daishu.Customer;
import com.shop.data.mapper.daishu.Order;
import com.shop.data.mapper.daishu.Recharge;
import com.shop.manager.util.CommonUtil;
import com.shop.manager.util.ConfigUtil;
import com.shop.manager.util.IpAddressUtil;
import com.shop.manager.util.PayCommonUtil;
import com.shop.manager.util.XMLUtil;
import com.shop.manager.util.weixin.SignatureUtil;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.filter.AclFilter;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.CommentService;
import com.shop.service.daishu.CustomerService;
import com.shop.service.daishu.OrderService;
import com.shop.service.daishu.ScheduleService;

@Controller
@RequestMapping("order")
public class OrderController extends AbstractController<Order> {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/order/order");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("daishu/order/add");
		return mav;
	}
	
	@RequestMapping(value = "order_pay", method = RequestMethod.GET)
	public ModelAndView orderPay(HttpSession session, String orderId, String orderNo) {
		ModelAndView mav = new ModelAndView("order_pay");
		String code = (String) session.getAttribute(AclFilter.CODE);
		String nonceStr = PayCommonUtil.CreateNoncestr();
		Map<String, String> sign = SignatureUtil.getSignMap(nonceStr, "http://daishuguanjia.cn/api/order/order_pay");
		mav.addObject("appId", ConfigUtil.APPID);
		mav.addObject("sign", sign);
		mav.addObject("code", code);
		mav.addObject("orderId", orderId);
		mav.addObject("orderNo", orderNo);
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "pay_success")
	public String pay_success(HttpServletRequest request) throws Exception {
		InputStream inputStream = request.getInputStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}
		outputStream.close();
		inputStream.close();
		String result = new String(outputStream.toByteArray(), "UTF-8");
		Map<Object, Object> resultMap = XMLUtil.doXMLParse(result);
		if (resultMap.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
			Order order = new Order();
			order.setPrice(Double.valueOf(String.valueOf(resultMap
					.get("total_fee"))));
			order.setTransactionId(String.valueOf(resultMap
					.get("transaction_id")));
			order.setOrderNo(String.valueOf(resultMap.get("out_trade_no")));
			order.setSign(String.valueOf(resultMap.get("sign")));
			order.setOpenId(String.valueOf(resultMap.get("openid")));
			order.setDetail(JSON.toJSONString(resultMap));
			this.orderService.paySuccess(order);

			return PayCommonUtil.setXML("SUCCESS", "");
		}
		return "";
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "pay")
	public ResponseData pay(HttpServletRequest request, int orderId) {
		String openid = (String) request.getSession().getAttribute(
				AclFilter.OPENID);
		Customer customer = this.getLoginCustomer(request);
		String outTradeNo = System.currentTimeMillis() + "" + customer.getId();

		String nonceStr = PayCommonUtil.CreateNoncestr();
		try {
			SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
			parameters.put("appid", ConfigUtil.APPID);
			parameters.put("mch_id", ConfigUtil.MCH_ID);
			parameters.put("nonce_str", nonceStr);
			parameters.put("body", "会员卡");
			parameters.put("out_trade_no", outTradeNo);
			parameters.put("total_fee", "1");
			parameters.put("spbill_create_ip", IpAddressUtil.getIpAddr(request));
			parameters.put("notify_url", ConfigUtil.NOTIFY_URL1);
			parameters.put("trade_type", "JSAPI");
			parameters.put("openid", openid);
			String paySign = PayCommonUtil.createSign("UTF-8", parameters);
			parameters.put("sign", paySign);
			String requestXML = PayCommonUtil.getRequestXml(parameters);

			String resultXml = CommonUtil.httpsRequest(
					ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);
			Map<String, String> resultMap = XMLUtil.doXMLParse(resultXml);

			if (StringUtils.equals(resultMap.get("return_code"), "SUCCESS")) {
				String timeStamp = Long
						.toString(System.currentTimeMillis() / 1000);
				SortedMap<Object, Object> payParameters = new TreeMap<Object, Object>();
				payParameters.put("appId", ConfigUtil.APPID);
				payParameters.put("timeStamp", timeStamp);
				payParameters.put("nonceStr", nonceStr);
				payParameters.put("package",
						"prepay_id=" + resultMap.get("prepay_id"));
				payParameters.put("signType", "MD5");
				paySign = PayCommonUtil.createSign("UTF-8", payParameters);
				payParameters.put("paySign", paySign);
				payParameters.put("orderNum", outTradeNo);
				return this.response("", payParameters);
			} else {
				return this.response(ResponseData.CODE_ERROR, resultMap.get("return_msg"), ResponseData.ACTION_ALERT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return this.response(ResponseData.CODE_ERROR, e.getMessage(), ResponseData.ACTION_ALERT);
		}
	}

	@RequestMapping(value = "order_ok")
	public ModelAndView orderOk() {
		ModelAndView mav = new ModelAndView("order_ok");
		return mav;
	}
	
//	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Order order) {
		int type = order.getBaojieType();
		Customer customer = this.getLoginCustomer(request);
		String orderNo = System.currentTimeMillis() + "" + customer.getId();
		if (3 == type || 7 == type || 8 == type || 9 == type) {
			// TODO 新增订单
			order.setOrderNo(orderNo);
			order.setAuditStatus(Order.AUDIT_STATUS_WAIT);
			order.setPayStatus(Order.PAY_STATUS_WAIT_PAY);
			order.setCreateTime(new Date());
			order.setPayType(Order.PAY_TYPE_CASH);
			order.setCustomerId(customer.getId());
			this.getAbstractService().insert(order);
//			customerService.updatePhoneAndName(customer.getId(), order.getName(), order.getPhone());
//			return "redirect:/order/order_ok?orderNo=" + orderNo + "&orderId=" + order.getId();
		} else {
			// TODO 判断排期是否已满
			int count = scheduleService.availableAyiCount(order.getBaojieType(), order.getServiceDate(), order.getServiceTimeType());
			if (count > 0) {
				// TODO 新增订单
				order.setOrderNo(orderNo);
				order.setAuditStatus(Order.AUDIT_STATUS_WAIT);
				order.setPayStatus(Order.PAY_STATUS_WAIT_PAY);
				order.setCreateTime(new Date());
				order.setPayType(Order.PAY_TYPE_CASH);
				order.setCustomerId(customer.getId());
				this.getAbstractService().insert(order);
			}
		}
		customerService.updatePhoneAndName(customer.getId(), order.getName(), order.getPhone());
		customer.setName(order.getName());
		customer.setPhone(customer.getPhone());
		request.getSession().setAttribute(AclFilter.loginCustomer, customer);
		return "redirect:/order/order_ok?orderNo=" + orderNo + "&orderId=" + order.getId();
//		return this.response("添加订单成功", ResponseData.ACTION_TOAST);
	}
	
	@ResponseBody
	@RequestMapping(value = "list_orders_by_customerId", method = RequestMethod.POST)
	public ResponseData listOrdersByCustomerId(int customerId) {
		List<Order> orders = this.orderService.listOrdersByCustomerId(customerId);
		ResponseData data = new ResponseData("获取订单信息成功！", orders);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "cancel", method = RequestMethod.POST)
	public ResponseData cancel(int id) {
		this.orderService.updatePayStatusByIds(new int[]{id}, Order.PAY_STATUS_CARCEL);
		return this.response("取消成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "pingjia", method = RequestMethod.GET)
	public ModelAndView pingjia(int id) {
		ModelAndView mav = new ModelAndView("order_detail");
		Order order = orderService.selectOrderDetail(id);
		mav.addObject("order", order);
		return mav;
	}
	
	@RequestMapping(value = "pingjia", method = RequestMethod.POST)
	public ModelAndView pingjia(HttpSession session, Comment comment) {
		Customer customer = this.getLoginCustomer(session);
		ModelAndView mav = new ModelAndView("redirect:/userCenter");
		comment.setCustomerId(customer.getId());
		comment.setCreateTime(new Date());
		commentService.insert(comment);
		orderService.updatePayStatusByIds(new int[]{comment.getOrderId()}, Order.PAY_STATUS_COMMENTED);
		return mav;
	}
	
	@Override
	public AbstractService<Order> getAbstractService() {
		return this.orderService;
	}

}
