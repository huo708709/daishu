package com.shop.manager.util.weixin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String httpGet(String url) {
		RequestConfig requestConfig = RequestConfig.custom().build();
		HttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse httpResponse = httpClient.execute(httpget);
			HttpEntity entity = httpResponse.getEntity();
			String result = EntityUtils.toString(entity);
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String httpPost(String url, String param) throws Exception {
		RequestConfig requestConfig = RequestConfig.custom().build();
		HttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		HttpPost httppost = new HttpPost(url);
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("SimpleXMLElement", param));
		httppost.setEntity(new UrlEncodedFormEntity(nvps));
		
		try {
			HttpResponse httpResponse = httpClient.execute(httppost);
			HttpEntity entity = httpResponse.getEntity();
			String result = EntityUtils.toString(entity);
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
