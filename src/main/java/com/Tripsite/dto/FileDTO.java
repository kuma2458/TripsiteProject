package com.Tripsite.dto;

import org.apache.ibatis.type.Alias;

@Alias("file")
public class FileDTO {
	private int qno;
	private int fno;
	private String path;
	public FileDTO() {
		
	}
	public FileDTO(int qno, int fno, String path) {
		super();
		this.qno = qno;
		this.fno = fno;
		this.path = path;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileDTO [qno=" + qno + ", fno=" + fno + ", path=" + path + "]";
	}
	
	
}
