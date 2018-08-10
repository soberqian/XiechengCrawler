package com.model;
//需要采集的数据字段
public class XieChengModel {
	private String user_id; 
	private String user_type;
	private String score;
	private String comment_info;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getComment_info() {
		return comment_info;
	}
	
	public void setComment_info(String comment_info) {
		this.comment_info = comment_info;
	}
	
}
