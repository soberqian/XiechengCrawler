package com.main;

import java.util.List;

import com.db.MYSQLControl;
import com.model.XieChengModel;
import com.parse.HtmlParse;
import com.util.HttpRequest;

public class CrawlerMain {

	public static void main(String[] args) throws Exception {
		HttpRequest httpRequest = new HttpRequest();
		for(int i = 0; i < 100; i++){
			int page = i;  //爬取的页数
			//拼接url
			String  everypageurl = "http://vacations.ctrip.com/grouptravel/p1740331s0"+"-comment-" + page + ".html" ;
			//调用HttpRequest中的方法获取网页内容
			String html = httpRequest.getHTMLContentByHttpGetMethod(everypageurl,"utf-8");
			//针对每页的HTML,调用HtmlParse类中的方法进行解析
			List<XieChengModel> datalist = HtmlParse.getData(html);
			//针对已获取的数据，调用MYSQLControl中的方法插入数据
			MYSQLControl.executeInsert(datalist);
		}
		//测试程序
		/*String  url = "http://vacations.ctrip.com/grouptravel/p1740331s0-comment-0.html";
		String html = httpRequest.getHTMLContentByHttpGetMethod(url,"utf-8");
		HtmlParse.getData(html);*/
	}

}
