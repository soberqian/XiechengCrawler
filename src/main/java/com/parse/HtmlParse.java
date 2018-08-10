package com.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.model.XieChengModel;

public class HtmlParse {
	public static List<XieChengModel> getData (String html) throws Exception{
		//获取的数据，存放在集合中
		List<XieChengModel> datalist = new ArrayList<XieChengModel>();
		//采用Jsoup解析
		Document doc = Jsoup.parse(html);
		//获取html标签中的内容
		Elements elements = doc.select("div#js_commentData").select("ul[class=detail_comment_list]> li");
//		Elements elements = doc.select("div#js_commentData").select("ul[class=detail_comment_list]").select("li");
		for (Element ele:elements) {
			String user_id = ele.select("p[class= user_id]").text();
			String user_type = ele.select("span[class=user_type]").text();  
			String score = ele.select("strong[class=score]").text();
			String comment_info = ele.select("p").get(1).nextElementSibling().text().replace(Jsoup.parse("&nbsp;").text(), "");
			//创建一个对象，封装数据
			XieChengModel xiechengModel = new XieChengModel();
			xiechengModel.setUser_id(user_id);
			xiechengModel.setUser_type(user_type);
			xiechengModel.setScore(score);
			xiechengModel.setComment_info(comment_info);
			//将每一个对象的值，保存到List集合中
			datalist.add(xiechengModel);
			System.out.println( user_id + "\t" + user_type + "\t" + score + "\t" + comment_info );
		}
		//返回数据
		return datalist;
	}
}
