package com.miracle.common;

/**
 * 接票状态类型.<br/>
 * 注：添加类型只能在后面添加，不能插入中间
 * 
 */
public enum TicketSchemeState {
	/** 满员 */
	FULL("出票中"),

	/** 成功 */
	SUCCESS("出票成功"),

	/** 撤销 */
	FAILD("出票失败");

	/** 状态名称 */
	private final String stateName;

	/**
	 * @param state {@link #stateName}
	 */
	private TicketSchemeState(String state) {
		this.stateName = state;
	}
	/**
	 * @return {@link #stateName}
	 */
	public String getStateName() {
		return stateName;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;
}
