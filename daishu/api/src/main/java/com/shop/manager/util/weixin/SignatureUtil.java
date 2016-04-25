package com.shop.manager.util.weixin;

import java.io.UnsupportedEncodingException;
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

	public synchronized static Map<String, String> getSignMap(String nonce_str, String url) {
		if (map == null || map.isEmpty()) {
			String ticket = getTicket(getAccessToken("", ""));
			map = sign(ticket, url, nonce_str);
		}
		long time = Long.valueOf(map.get("timestamp")) * 1000;
		if ((System.currentTimeMillis() - time) > (1000 * 60 * 60 * 1.5)) {
			String ticket = getTicket(getAccessToken("", ""));
			map = sign(ticket, url, nonce_str);
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
}
