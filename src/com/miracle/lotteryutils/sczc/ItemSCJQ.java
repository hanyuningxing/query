package com.miracle.lotteryutils.sczc;

import org.apache.commons.lang.StringUtils;

import com.miracle.lotteryutils.Item;

 
public enum ItemSCJQ implements Item {
	/** 进0球 */
	J1Q("0", "进0球"),

	/** 进1球 */
	J2Q("1", "进1球"),

	/** 进2球 */
	J3Q("2", "进2球"),
	
	/** 进3球*/
	JNQ("3","进3球或以上")
	;

	private final String value;
	private final String text;

	private ItemSCJQ(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}

	/**
	 * 根据值获取对应的类型,找不到对应的类型返回null.
	 */
	public static ItemSCJQ valueOfValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (ItemSCJQ type : ItemSCJQ.values()) {
				if (type.getValue().equals(value))
					return type;
			}
		}
		return null;
	}
}
