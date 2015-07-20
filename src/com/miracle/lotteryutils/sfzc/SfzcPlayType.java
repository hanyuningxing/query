package com.miracle.lotteryutils.sfzc;

import org.apache.commons.lang.StringUtils;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;
 
 

public enum SfzcPlayType implements PlayTypeItem{
	/** 	14场胜负彩 */
	SPF("14场胜负彩",null, ItemSPF.values()),

	/** 	任选9场 */
	R9C("任选9场", null, null),
	;
	/** 玩法名称 */
	private final String text;

	/** 此玩法所能选择的最大场次数目 */
	private final Integer maxMatchSize;

	private final Item[] allItems;
	
	private final String compoundValue = "复式均以“,”相隔，例如：31,*,10,3,1,1,0,*,1,3,31,*,*,*";
	private final String singleValue = "单式每注用“+”相隔，例如：31*103**13*01*+31*103**13*01*+31*103**13*01*";
	private final String danValue="任选9胆拖 最小命中数和投注内容用;隔开,胆拖的场次用4表示 例如：1;431,1,0,3,1,1,0,*,1,3,31,*,*,*  表示最小命中个数是1，第一场选择胜和平选项并设胆";

	private SfzcPlayType(String text, Integer maxMatchSize, Item[] allItems) {
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
	public Integer getMaxMatchSize() {
		return maxMatchSize;
	}

	/**
	 * @return {@link #allItems}
	 */
	public Item[] getAllItems() {
		return allItems;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	public static SfzcPlayType valueOfName(String name) {
		if (StringUtils.isNotBlank(name)) {
			for (SfzcPlayType type : SfzcPlayType.values()) {
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

	public String getCompoundValue() {
		return compoundValue;
	}

	public String getSingleValue() {
		return singleValue;
	}

	public String getDanValue() {
		return danValue;
	}
	
	
	
}



