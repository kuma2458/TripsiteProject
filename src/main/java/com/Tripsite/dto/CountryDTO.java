package com.Tripsite.dto;

public class CountryDTO {

	private int nCode;
	private String nName;
	private String nCur;
	private int air;
	private String nCity1;
	private String nCity2;
	private String nCity3;
	
	
	public CountryDTO() {	}


	public CountryDTO(int nCode, String nName, String nCur, int air, String nCity1, String nCity2, String nCity3) {
		this.nCode = nCode;
		this.nName = nName;
		this.nCur = nCur;
		this.air = air;
		this.nCity1 = nCity1;
		this.nCity2 = nCity2;
		this.nCity3 = nCity3;
	}


	public int getnCode() {
		return nCode;
	}


	public void setnCode(int nCode) {
		this.nCode = nCode;
	}


	public String getnName() {
		return nName;
	}


	public void setnName(String nName) {
		this.nName = nName;
	}


	public String getnCur() {
		return nCur;
	}


	public void setnCur(String nCur) {
		this.nCur = nCur;
	}


	public int getAir() {
		return air;
	}


	public void setAir(int air) {
		this.air = air;
	}


	public String getnCity1() {
		return nCity1;
	}


	public void setnCity1(String nCity1) {
		this.nCity1 = nCity1;
	}


	public String getnCity2() {
		return nCity2;
	}


	public void setnCity2(String nCity2) {
		this.nCity2 = nCity2;
	}


	public String getnCity3() {
		return nCity3;
	}


	public void setnCity3(String nCity3) {
		this.nCity3 = nCity3;
	}


	@Override
	public String toString() {
		return "CountryDTO [nCode=" + nCode + ", nName=" + nName + ", nCur=" + nCur + ", air=" + air + ", nCity1="
				+ nCity1 + ", nCity2=" + nCity2 + ", nCity3=" + nCity3 + "]";
	}
	
	
	

}


