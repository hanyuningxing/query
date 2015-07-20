package com.miracle.lotteryutils.sfzc;

import org.apache.commons.lang.StringUtils;

import com.miracle.lotteryutils.Item;

 
public enum ItemR9C implements Item {
	/** 任选9胆拖 */
	R9Dan("任选9胆拖 最小命中数和投注内容用;隔开,胆拖的场次用4表示 例如：1;431,1,0,3,1,1,0,*,1,3,31,*,*,*  表示最小命中个数是1，第一场选择胜和平选项并设胆", "任选9胆拖"),

	Compound("复式均以“,”相隔，例如：31,*,10,3,1,1,0,*,1,3,31,*,*,*","复式"),
	
	Single("单式每注用“+”相隔，例如：31*103**13*01*+31*103**13*01*+31*103**13*01*","	单式")
	
	;

	private final String value;
	private final String text;

	private ItemR9C(String value, String text) {
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
	public static ItemR9C valueOfValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (ItemR9C type : ItemR9C.values()) {
				if (type.getValue().equals(value))
					return type;
			}
		}
		return null;
	}
}
