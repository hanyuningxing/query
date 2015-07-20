package com.miracle.lotteryutils.dczc;

import org.apache.commons.lang.StringUtils;

import com.miracle.lotteryutils.Item;

/**
 * 竞彩足球-半全场玩法选项
 * 
 */
public enum ItemSXDS implements Item {
	/** 上单*/
	SD("3","上单"),
	
	/** 上双*/
	SS("2","上双"),
	
	/** 下单*/
	XD("1","下单"),
	
	
	/** 下双*/
	XS("0","下双"),
	
	;

	private final String value;
	private final String text;

	private ItemSXDS(String value, String text) {
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
	public static ItemSXDS valueOfValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (ItemSXDS type : ItemSXDS.values()) {
				if (type.getValue().equals(value))
					return type;
			}
		}
		return null;
	}
}
