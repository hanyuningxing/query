package com.miracle.lotteryutils;
public enum ProcessIdType {

	ERROR0("成功"),
	ERROR1("身份验证错误"),
	ERROR2("帐号被冻结"),
	ERROR3("彩种错误"),
	ERROR4("不支持的wAction"),
	ERROR5("wParam参数错误"),
	ERROR6("系统错误");
	private String typeName;

	private ProcessIdType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName(){
		return this.typeName;
	}
	public Integer getValue(){
		return this.ordinal();
	}
}
