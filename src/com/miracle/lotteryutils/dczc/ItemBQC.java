package com.miracle.lotteryutils.dczc;

import org.apache.commons.lang.StringUtils;

import com.miracle.lotteryutils.Item;

/**
 * 竞彩足球-半全场玩法选项
 * 
 */
public enum ItemBQC implements Item {
	/** 胜胜 */
	WIN_WIN("33", "胜-胜"),

	/** 胜平 */
	WIN_DRAW("31", "胜-平"),

	/** 胜负 */
	WIN_LOSE("30", "胜-负"),

	/** 平胜 */
	DRAW_WIN("13", "平-胜"),

	/** 平平 */
	DRAW_DRAW("11", "平-平"),

	/** 平负 */
	DRAW_LOSE("10", "平-负"),

	/** 负胜 */
	LOSE_WIN("03", "负-胜"),

	/** 负平 */
	LOSE_DRAW("01", "负-平"),

	/** 负负 */
	LOSE_LOSE("00", "负-负");

	private final String value;
	private final String text;

	private ItemBQC(String value, String text) {
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
	public static ItemBQC valueOfValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (ItemBQC type : ItemBQC.values()) {
				if (type.getValue().equals(value))
					return type;
			}
		}
		return null;
	}
}
