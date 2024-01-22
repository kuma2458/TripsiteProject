package com.Tripsite.dto;

import org.apache.ibatis.type.Alias;

@Alias("file")
public class FileDTO {
	private int qno;
	private int fno;
	private String path;
	public FileDTO() {
		
	}
	
	
	public FileDTO(int bno, int fno, String path) {
		
		this.qno = bno;
		this.fno = fno;
		this.path = path;
	}


	public int getBno() {
		return qno;
	}
	public void setBno(int bno) {
		this.qno = bno;
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
		return "FileDTO [bno=" + qno + ", fno=" + fno + ", path=" + path + "]";
	}
	
	
	
	
}
