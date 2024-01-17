package com.Tripsite.dto;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class MemberDTO {
	private String mId;
	private String mPass;
	private String mNick;
	private String mTel;
	private String mEmail;
	private int mBirth;
	private String mGender;
	private String mName;
	
	
	public MemberDTO() {
	}


	public MemberDTO(String mId, String mPass, String mNick, String mTel, String mEmail, int mBirth, String mGender,
			String mName) {
		super();
		this.mId = mId;
		this.mPass = mPass;
		this.mNick = mNick;
		this.mTel = mTel;
		this.mEmail = mEmail;
		this.mBirth = mBirth;
		this.mGender = mGender;
		this.mName = mName;
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}


	public String getmPass() {
		return mPass;
	}


	public void setmPass(String mPass) {
		this.mPass = mPass;
	}


	public String getmNick() {
		return mNick;
	}


	public void setmNick(String mNick) {
		this.mNick = mNick;
	}


	public String getmTel() {
		return mTel;
	}


	public void setmTel(String mTel) {
		this.mTel = mTel;
	}


	public String getmEmail() {
		return mEmail;
	}


	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}


	public int getmBirth() {
		return mBirth;
	}


	public void setmBirth(int mBirth) {
		this.mBirth = mBirth;
	}


	public String getmGender() {
		return mGender;
	}


	public void setmGender(String mGender) {
		this.mGender = mGender;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	@Override
	public String toString() {
		return "MemberDTO [mId=" + mId + ", mPass=" + mPass + ", mNick=" + mNick + ", mTel=" + mTel + ", mEmail="
				+ mEmail + ", mBirth=" + mBirth + ", mGender=" + mGender + ", mName=" + mName + "]";
	}

	
}