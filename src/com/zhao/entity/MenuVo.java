package com.zhao.entity;

import java.io.Serializable;


public class MenuVo implements Serializable{
	private int mid;
	private String name;
	private String url;
	private int isshow;
	private int level;
	private String parentiname;
	
	
	public String toString(){
		return "{\"mid\":"+mid+",\"name\":"+name+",\"url\":"+url+",\"isshow\":"+isshow+",\"level\":"+level+",\"parentiname\":"+parentiname+"}";
	}
	
	public MenuVo() {}
	public MenuVo(int mid, String name, String url, int isshow, int level,
			String parentiname) {
		super();
		this.mid = mid;
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentiname = parentiname;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getParentiname() {
		return parentiname;
	}
	public void setParentiname(String parentiname) {
		this.parentiname = parentiname;
	}
	

	
	
}
