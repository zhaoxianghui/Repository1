package com.zhao.entity;

public class Student {
    private int sid;
    private String mobile;
    private String times;
    private int cid;
    
	public Student() {	}
	public Student(int sid, String mobile, String times, int code) {
		super();
		this.sid = sid;
		this.mobile = mobile;
		this.times = times;
		this.cid = code;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
    
}
