package com.Tripsite.dto;

import org.apache.ibatis.type.Alias;

@Alias("comment")
public class CommentDTO {
	private int cNo;
	private String cId;
	private String cTime;
	private String cContent;
	private int rNo;
	private String cNick;
	private int cHate;
	private int cLike;
	
	public CommentDTO() {}
	

	public CommentDTO(int cNo, String cId, String cTime, String cContent, int rNo, String cNick, int cHate, int cLike) {
		super();
		this.cNo = cNo;
		this.cId = cId;
		this.cTime = cTime;
		this.cContent = cContent;
		this.rNo = rNo;
		this.cNick = cNick;
		this.cHate = cHate;
		this.cLike = cLike;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcTime() {
		return cTime;
	}
	public void setcTime(String cTime) {
		this.cTime = cTime;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getcNick() {
		return cNick;
	}
	public void setcNick(String cNick) {
		this.cNick = cNick;
	}
	public int getcHate() {
		return cHate;
	}
	public void setcHate(int cHate) {
		this.cHate = cHate;
	}
	public int getcLike() {
		return cLike;
	}
	public void setcLike(int cLike) {
		this.cLike = cLike;
	}
	@Override
	public String toString() {
		return "CommentDTO [cNo=" + cNo + ", cId=" + cId + ", cTime=" + cTime + ", cContent=" + cContent + ", rNo="
				+ rNo + ", cNick=" + cNick + ", cHate=" + cHate + ", cLike=" + cLike + "]";
	}


	
}
