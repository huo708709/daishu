package com.shop.manager.web.controller.daishu;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.shop.data.mapper.daishu.Customer;
import com.shop.data.mapper.daishu.MemberCard;
import com.shop.data.mapper.daishu.Recharge;
import com.shop.manager.util.CommonUtil;
import com.shop.manager.util.ConfigUtil;
import com.shop.manager.util.IpAddressUtil;
import com.shop.manager.util.PayCommonUtil;
import com.shop.manager.util.XMLUtil;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.filter.AclFilter;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.MemberCardService;
import com.shop.service.daishu.RechargeService;

/**
 * 充值
 * 
 * @author huoyao
 *
 */
@Controller
@RequestMapping("recharge")
@SuppressWarnings("unchecked")
public class RechargeController extends AbstractController<Recharge> {

	@Autowired
	private RechargeService rechargeService;
	@Autowired
	private MemberCardService memberCardService;

	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("recharge");
		mav.addObject("show", 0);
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "pay_success")
	public String pay_success(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		System.out.println(JSON.toJSONString(resultMap));
		if (resultMap.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
			Recharge recharge = new Recharge();
			int type = Integer.valueOf(String.valueOf(resultMap.get("attach")));
			recharge.setType(type);
			recharge.setMoney(Double.valueOf(String.valueOf(resultMap
					.get("total_fee"))));
			recharge.setTransactionId(String.valueOf(resultMap
					.get("transaction_id")));
			recharge.setOutTradeNo(String.valueOf(resultMap.get("out_trade_no")));
			recharge.setSign(String.valueOf(resultMap.get("sign")));
			recharge.setOpenId(String.valueOf(resultMap.get("openid")));
			recharge.setDetail(JSON.toJSONString(resultMap));
			this.rechargeService.paySuccess(recharge);

			response.setContentType("text/xml");
			response.getWriter().write(PayCommonUtil.setXML("SUCCESS", "OK"));
			response.getWriter().flush();
			response.getWriter().close();
			return PayCommonUtil.setXML("SUCCESS", "OK");
		}
		return "";
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(HttpServletRequest request, int type) {
		String openid = (String) request.getSession().getAttribute(
				AclFilter.OPENID);
		Customer customer = this.getLoginCustomer(request);
		String outTradeNo = System.currentTimeMillis() + "" + customer.getId();

		String nonceStr = PayCommonUtil.CreateNoncestr();
		try {
			MemberCard memberCard = memberCardService.selectByType(type);
			SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
			parameters.put("appid", ConfigUtil.APPID);
			parameters.put("mch_id", ConfigUtil.MCH_ID);
			parameters.put("attach", String.valueOf(type));
			parameters.put("nonce_str", nonceStr);
			parameters.put("body", "会员卡");
			parameters.put("out_trade_no", outTradeNo);
			parameters.put("total_fee", String.valueOf((long) (memberCard.getRechargeAmount() * 100)));
			parameters.put("spbill_create_ip", IpAddressUtil.getIpAddr(request));
			parameters.put("notify_url", ConfigUtil.NOTIFY_URL);
			parameters.put("trade_type", "JSAPI");
			parameters.put("openid", openid);
			String paySign = PayCommonUtil.createSign("UTF-8", parameters);
			parameters.put("sign", paySign);
			String requestXML = PayCommonUtil.getRequestXml(parameters);

			String resultXml = CommonUtil.httpsRequest(
					ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);
			Map<String, String> resultMap = XMLUtil.doXMLParse(resultXml);

			if (StringUtils.equals(resultMap.get("return_code"), "SUCCESS")) {
				Date currentDate = new Date();
				Recharge recharge = new Recharge();
				recharge.setCustomerId(customer.getId());
				recharge.setType(type);
				recharge.setMoney(memberCard.getRechargeAmount());
				recharge.setTime(currentDate);
				recharge.setStatus(Recharge.STATUS_NOT_PAY);
				recharge.setOpenId(openid);
				recharge.setOutTradeNo(outTradeNo);
				recharge.setSign(paySign);
				this.rechargeService.insert(recharge);

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

	@Override
	public AbstractService<Recharge> getAbstractService() {
		return this.rechargeService;
	}

}
