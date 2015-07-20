package com.miracle.lotteryutils.jczq;

import org.apache.commons.lang.StringUtils;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.MatchItem;

/**
 * 竞彩足球-胜平负玩法选项
 * 
 */
public enum ItemChampionRunnerUp implements Item {
	/** 胜 */
	WIN("CS", "冠军",ChampionRunnerUpMatchItem.values()),

	 
;
	private final String value;
	private final String text;
	
	private final MatchItem[] matchItem;

	private ItemChampionRunnerUp(String value, String text,MatchItem[] matchItem) {
		this.value = value;
		this.text = text;
		this.matchItem = matchItem;
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
	public static ItemChampionRunnerUp valueOfValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (ItemChampionRunnerUp type : ItemChampionRunnerUp.values()) {
				if (type.getValue().equals(value))
					return type;
			}
		}
		return null;
	}

	public MatchItem[] getMatchItem() {
		return matchItem;
	}
	
}
