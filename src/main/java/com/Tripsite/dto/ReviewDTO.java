package com.Tripsite.dto;

import org.apache.ibatis.type.Alias;

@Alias("review")
public class ReviewDTO {
	private int rno;
	private String rTitle;
	private String rContent;
	private String rTime;
	private String rId;
	private String rNick;
	private String rcount;
	public ReviewDTO(int rno, String rTitle, String rContent, String rTime, String rId, String rNick, String rcount) {
		super();
		this.rno = rno;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rTime = rTime;
		this.rId = rId;
		this.rNick = rNick;
		this.rcount = rcount;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getrNick() {
		return rNick;
	}
	public void setrNick(String rNick) {
		this.rNick = rNick;
	}
	public String getRcount() {
		return rcount;
	}
	public void setRcount(String rcount) {
		this.rcount = rcount;
	}
	@Override
	public String toString() {
		return "ReviewDTO [rno=" + rno + ", rTitle=" + rTitle + ", rContent=" + rContent + ", rTime=" + rTime + ", rId="
				+ rId + ", rNick=" + rNick + ", rcount=" + rcount + "]";
	}
	
	
}
