package com.miracle.lotteryutils.jczq;

import com.miracle.common.Constant;


/**
 * 过关模式
 * 
 */
public enum PassMode {
	/** 单关 */
	SINGLE("单关"),

	/** 过关 */
	PASS("过关"),
	
	/** 混合过关 */
	MIX_PASS("混合过关");

	private final String text;

	private PassMode(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;
}
