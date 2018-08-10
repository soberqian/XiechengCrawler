package com.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class HttpRequest {
	private HttpClient httpClient;
	public HttpEntity getEntityByHttpGetMethod(String url){
		httpClient = HttpClients.custom().build(); //初始化httpclient
		HttpGet httpget = new HttpGet(url); //使用的请求方法
		//请求头配置
//		httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//		httpget.setHeader("Accept-Encoding", "gzip, deflate");
//		httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
//		httpget.setHeader("Cache-Control", "max-age=0");
//		httpget.setHeader("Host", "vacations.ctrip.com");
//		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36"); //这项内容很重要
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpget);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		HttpEntity httpEntity = response.getEntity();  //获取网页内容流
		return httpEntity;
	}
	public String getHTMLContentByHttpGetMethod(String url,String code){
		//获取Html内容
		try {
			return EntityUtils.toString(getEntityByHttpGetMethod(url),code);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
