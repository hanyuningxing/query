package com.miracle.lotteryutils;

public class CompanyTemp implements java.io.Serializable{
	 
	private static final long serialVersionUID = -5374206780323047857L;
	private Integer key;
	private String name;
	private String realName;
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
