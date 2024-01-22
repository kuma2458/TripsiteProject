package com.Tripsite.dto;

import org.apache.ibatis.type.Alias;

@Alias("qna")
public class QnaDTO {
	private int qNo;
	private String qTitle;
	private String qContent;
	private String qItem;
	private String qId;
	private String qNick;
	private String qTime;
	
	public QnaDTO() {
		
	}

	public QnaDTO(int qNo, String qTitle, String qContent, String qItem, String qId, String qNick, String qTime) {
		super();
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qItem = qItem;
		this.qId = qId;
		this.qNick = qNick;
		this.qTime = qTime;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getqItem() {
		return qItem;
	}

	public void setqItem(String qItem) {
		this.qItem = qItem;
	}

	public String getqId() {
		return qId;
	}

	public void setqId(String qId) {
		this.qId = qId;
	}

	public String getqNick() {
		return qNick;
	}

	public void setqNick(String qNick) {
		this.qNick = qNick;
	}

	public String getqTime() {
		return qTime;
	}

	public void setqTime(String qTime) {
		this.qTime = qTime;
	}

	@Override
	public String toString() {
		return "QnaDTO [qNo=" + qNo + ", qTitle=" + qTitle + ", qContent=" + qContent + ", qItem=" + qItem + ", qId="
				+ qId + ", qNick=" + qNick + ", qTime=" + qTime + "]";
	}
	
	

	
	
}
