package com.miracle.lotteryutils.dczc;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.SchemeTypeItem;



public enum DczcSchemeType implements SchemeTypeItem{
 

	/** 普通过关 */
	SIMPLE_PASS("普通过关"),

	/** 多选过关 */
	MULTIPLE_PASS("多选过关");
	 

	private final String text;

	private DczcSchemeType(String text) {
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
	public static DczcSchemeType[] getTicketDczcSchemeTypeItem(){
		return new DczcSchemeType[]{DczcSchemeType.SIMPLE_PASS,DczcSchemeType.MULTIPLE_PASS};
	}
}
