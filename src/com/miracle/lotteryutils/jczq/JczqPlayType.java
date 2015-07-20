package com.miracle.lotteryutils.jczq;

import org.apache.commons.lang.StringUtils;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

/**
 * 竞彩足球玩法类型
 * 
 */
public enum  JczqPlayType  implements PlayTypeItem {
	/** 胜平负 */
	SPF("胜平负", 8, ItemSPF.values()),

	/** 进球数 */
	JQS("进球数", 6, ItemJQS.values()),

	/** 比分 */
	BF("比分", 4, ItemBF.values()),

	/** 半全场 */
	BQQ("半全场", 4, ItemBQQ.values()),
	
	/** 混合串 */
	MIX("混合串", 4, null),
	
	RQSPF("让分胜平负", 8, ItemSPF.values()),
	
	EuropeChampion("欧洲冠军",0,ItemChampion.values()),
	
	EuropeChampionRunnerUp("欧洲冠亚军",0,ItemChampionRunnerUp.values()),
;
	/** 玩法名称 */
	private final String text;

	/** 此玩法所能选择的最大场次数目 */
	private final int maxMatchSize;

	private final Item[] allItems;

	private JczqPlayType(String text, int maxMatchSize, Item[] allItems) {
		this.text = text;
		this.maxMatchSize = maxMatchSize;
		this.allItems = allItems;
	}

	/**
	 * @return {@link #text}
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return {@link #maxMatchSize}
	 */
	public int getMaxMatchSize() {
		return maxMatchSize;
	}

	/**
	 * @return {@link #allItems}
	 */
	public Item[] getAllItems() {
		return allItems;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	public static JczqPlayType valueOfName(String name) {
		if (StringUtils.isNotBlank(name)) {
			for (JczqPlayType type : JczqPlayType.values()) {
				if (type.name().equals(name))
					return type;
			}
		}
		return null;
	}
	public Item getItemByItemValue(String value) {
		if (StringUtils.isNotBlank(value)) {
			for (Item item : this.allItems) {
				if(item.getValue().trim().equalsIgnoreCase(value.trim())){
					return item;
				}
			}
		}
		return null;
	}

	@Override
	public Integer getMaxItemSize() {
		return this.maxMatchSize;
	}

	@Override
	public Integer getValue() {
		return this.ordinal();
	}

	@Override
	public String getTypeName() {
		return this.name();
	}
}
