package com.zhao.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private int sid;
	private String mobile;
	private String passwd;
	private String code;
	public int getSid() {
		return sid;
	}
	
	public User() {}

	public User(int sid, String mobile, String passwd, String code) {
		super();
		this.sid = sid;
		this.mobile = mobile;
		this.passwd = passwd;
		this.code = code;
	}

	
	public void setUid(int uid) {
		this.sid = sid;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
