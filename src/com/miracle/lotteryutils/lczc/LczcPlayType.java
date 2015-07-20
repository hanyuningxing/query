package com.miracle.lotteryutils.lczc;

import org.apache.commons.lang.StringUtils;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;
 


public enum LczcPlayType implements PlayTypeItem{
	
	
	
	/** 	六场半全场*/
	LCBQC("六场半全场", ItemSPF.values()),
 
	
 
	
	;
	/** 玩法名称 */
	private final String text;

 

	private final Item[] allItems;
	
	private final String compoundValue="复式均以“,”相隔，例如:31,2,10,3,1,1,0,0,1,1,0,0";
	private final String singleValue="单式每注用“+”相隔，例如：111111111111+333333333333";
	private final String danValue=null;

	
	
	private LczcPlayType(String text, Item[] allItems) {
		this.text = text; 
		this.allItems = allItems;
	}
	/**
	 * @return {@link #text}
	 */
	public String getText() {
		return text;
	}

 

	/**
	 * @return {@link #allItems}
	 */
	public Item[] getAllItems() {
		return allItems;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	public static LczcPlayType valueOfName(String name) {
		if (StringUtils.isNotBlank(name)) {
			for (LczcPlayType type : LczcPlayType.values()) {
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
	public Integer getValue() {
		return this.ordinal();
	}

	@Override
	public String getTypeName() {
		return this.name();
	}
	@Override
	public Integer getMaxItemSize() {
		// TODO Auto-generated method stub
		return null;
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
