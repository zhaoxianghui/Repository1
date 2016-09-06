package com.zhao.entity;

public class Role {
	private int rid;
	private String rname;
	
	
	public Role() {
		super();
	}
	public Role(int rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	

}
