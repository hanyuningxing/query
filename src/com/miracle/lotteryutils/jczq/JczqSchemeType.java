package com.miracle.lotteryutils.jczq;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.SchemeTypeItem;



public enum JczqSchemeType implements SchemeTypeItem{
	/** 单关 */
	SINGLE("单关"),

	/** 普通过关 */
	SIMPLE_PASS("普通过关"),

	/** 多选过关 */
	MULTIPLE_PASS("多选过关");
	 

	private final String text;

	private JczqSchemeType(String text) {
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
	public static JczqSchemeType[] getTicketJczqSchemeTypeItem(){
		return new JczqSchemeType[]{JczqSchemeType.SINGLE,JczqSchemeType.SIMPLE_PASS};
	}
}
