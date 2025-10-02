package com.pjt4.ssafit.dto.User;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable{
	private int id;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt;
	
	
	public Review() {
	}
	
	public Review(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = 0;
		this.regDate = new Date().toString();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", viewCnt=" + viewCnt + "]";
	}

}
