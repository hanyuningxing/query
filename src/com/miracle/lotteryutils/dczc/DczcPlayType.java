package com.miracle.lotteryutils.dczc;

import org.apache.commons.lang.StringUtils;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;
 
 

public enum DczcPlayType implements PlayTypeItem{
	
	
	/** 胜平负 */
	SPF("胜平负", 15, ItemSPF.values()),

	/** 进球数 */
	JQS("进球数", 6, ItemJQS.values()),

	/**	上下单双过关*/
	SXDS("上下单双过关",6,ItemSXDS.values()),
	
	/** 比分 */
	BF("比分", 3, ItemBF.values()),

	/** 半全场 */
	BQQ("半全场", 6, ItemBQC.values()) 
	
 
	
	;
	/** 玩法名称 */
	private final String text;

	/** 此玩法所能选择的最大场次数目 */
	private final int maxMatchSize;

	private final Item[] allItems;

	private DczcPlayType(String text, int maxMatchSize, Item[] allItems) {
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

	public static DczcPlayType valueOfName(String name) {
		if (StringUtils.isNotBlank(name)) {
			for (DczcPlayType type : DczcPlayType.values()) {
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
