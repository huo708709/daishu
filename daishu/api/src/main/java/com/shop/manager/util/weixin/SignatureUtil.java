package com.shop.manager.util.weixin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.manager.util.ConfigUtil;

public class SignatureUtil {

	private static Map<String, String> map = new HashMap<String, String>();

	private static String getAccessToken(String appid, String secret) {
		if (StringUtils.isBlank(appid)) {
			appid = ConfigUtil.APPID;
		}
		if (StringUtils.isBlank(secret)) {
			secret = ConfigUtil.APP_SECRECT;
		}
		String accessToken = "";
		String result = HttpUtil
				.httpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ appid + "&secret=" + secret);
		JSONObject jsonObject = JSON.parseObject(result);
		accessToken = jsonObject.getString("access_token");
		return accessToken;
	}

	private static String getTicket(String accessToken) {
		String result = HttpUtil
				.httpGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
						+ accessToken + "&type=jsapi");
		JSONObject jsonObject = JSON.parseObject(result);
		if (0 == jsonObject.getInteger("errcode")) {
			return jsonObject.getString("ticket");
		}
		return "";
	}

	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	public static Map<String, String> sign(String jsapi_ticket, String url, String nonce_str) {
		Map<String, String> ret = new HashMap<String, String>();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str
				+ "&timestamp=" + timestamp + "&url=" + url;

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	public synchronized static Map<String, String> getSignMap(String nonce_str) {
		if (map == null || map.isEmpty()) {
			String ticket = getTicket(getAccessToken("", ""));
			map = sign(ticket,
					"http://daishuguanjia.cn/api/vip", nonce_str);
		}
		long time = Long.valueOf(map.get("timestamp")) * 1000;
		if ((System.currentTimeMillis() - time) > (1000 * 60 * 60 * 1.5)) {
			String ticket = getTicket(getAccessToken("", ""));
			map = sign(ticket,
					"http://daishuguanjia.cn/api/vip", nonce_str);
		}
		return map;
	}

	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String paySign(String openid, String nonce_str) {
		StringBuilder builder = new StringBuilder();
		builder.append("appid=wxb85fe410c80bd960&mch_id=1316745301&nonce_str=")
				.append(nonce_str).append("&openid=").append(openid)
				.append("body=test&out_trade_no=123456789&total_fee=0.1&spbill_create_ip=192.168.0.102")
				.append("&notify_url=http://daishuguanjia.cn/api/vip&openid=02132ea346ef1a701601f834b9f05d8Y&trade_type=JSAPI");
		String sign = MD5(builder.toString());
		
		return sign.toUpperCase();
	}
	
	public static String unifiedorder(String paySign, String openid, String nonce_str) throws Exception {
		String param = "<xml>"
				+ "<appid>wxb85fe410c80bd960</appid>"
				+ "<body><![CDATA[test]]</body>"
				+ "<mch_id>1316745301</mch_id>"
				+ "<nonce_str>" + nonce_str + "</nonce_str>"
				+ "<notify_url>http://www.qjboss.com/order/business_activity/order/add</notify_url>"
				+ "<openid>" + openid + "</openid>"
				+ "<out_trade_no>123456789</out_trade_no>"
				+ "<spbill_create_ip>192.168.0.102</spbill_create_ip>"
				+ "<total_fee>0.1</total_fee>"
				+ "<trade_type>JSAPI</trade_type>"
				+ "<sign><![CDATA[" + paySign + "]]</sign>"
				+ "</xml>";
		return HttpUtil.httpPost("https://api.mch.weixin.qq.com/pay/unifiedorder", param);
	}
	
	public static void main(String[] args) throws Exception {
		// https://api.mch.weixin.qq.com/pay/unifiedorder
		StringBuilder builder = new StringBuilder();
		String nonce_str = create_nonce_str();
		builder.append("appid=wxb85fe410c80bd960&mch_id=1316745301&nonce_str=")
				.append(nonce_str)
				.append("body=test&out_trade_no=123456789&total_fee=0.1&spbill_create_ip=192.168.0.102")
				.append("&notify_url=http://www.qjboss.com/order/business_activity/order/add&openid=02132ea346ef1a701601f834b9f05d8Y&trade_type=JSAPI");
		String param = "<xml>"
				+ "<appid>wxb85fe410c80bd960</appid>"
				+ "<body>test</body>"
				+ "<mch_id>1316745301</mch_id>"
				+ "<nonce_str>" + nonce_str + "</nonce_str>"
				+ "<notify_url>http://www.qjboss.com/order/business_activity/order/add</notify_url>"
				+ "<out_trade_no>123456789</out_trade_no>"
				+ "<total_fee>0.1</total_fee>"
				+ "<spbill_create_ip>192.168.0.102</spbill_create_ip>"
				+ "<trade_type>JSAPI</trade_type>"
				+ "<openid>02132ea346ef1a701601f834b9f05d8Y</openid>"
				+ "</xml>";
		String sign = MD5(builder.toString());
		System.out.println(sign);
		builder.append("&sign=").append(sign.toUpperCase());
		System.out.println(new String(HttpUtil.httpGet("https://api.mch.weixin.qq.com/pay/unifiedorder?" + builder.toString())
				.getBytes(), "iso8859-1"));
		System.out.println(URLEncoder.encode("http://www.qjboss.com/shop-manager/business_activity/order/add/"));
		//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb85fe410c80bd960&redirect_uri=http%3A%2F%2Fwww.qjboss.com%2Fshop-manager%2Fbusiness_activity%2Forder%2Fadd%2F&response_type=code&scope=snsapi_base#wechat_redirect
	}
}
