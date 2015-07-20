package com.miracle.lotteryutils.jclq;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.SchemeTypeItem;



public enum JclqSchemeType implements SchemeTypeItem{
	/** 单关 */
	SINGLE("单关"),

	/** 普通过关 */
	SIMPLE_PASS("普通过关"),

	/** 多选过关 */
	MULTIPLE_PASS("多选过关");
	 

	private final String text;

	private JclqSchemeType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	@Override
	public Integer getValue() {
		return this.ordinal();
	}

	@Override
	public String getTypeName() {
		return this.name();
	}
	public static JclqSchemeType[] getTicketJclqSchemeTypeItem(){
		return new JclqSchemeType[]{JclqSchemeType.SINGLE,JclqSchemeType.SIMPLE_PASS};
	}
}
