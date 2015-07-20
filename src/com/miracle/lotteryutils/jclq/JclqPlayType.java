package com.miracle.lotteryutils.jclq;

import org.apache.commons.lang.StringUtils;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

/**
 * 竞彩篮球玩法类型
 * 
 */
public enum JclqPlayType implements PlayTypeItem {
	/** 胜负 */
	SF("胜负", ItemSF.values(), 8),

	/** 让分胜负 */
	RFSF("让分胜负", ItemRFSF.values(), 8),

	/** 胜分差 */
	SFC("胜分差", ItemSFC.values(), 3),

	/** 大小分 */
	DXF("大小分", ItemDXF.values(), 8),
	/** 混合串 */
	MIX("混合串", null ,3);
	/** 玩法名称 */
	private final String text;

	/** 此玩法所能选择的最大场次数目 */
	private final int maxMatchSize;

	private final Item[] allItems;

	private JclqPlayType(String text, Item[] allItems, int maxMatchSize) {
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

	public static JclqPlayType valueOfName(String name) {
		if (StringUtils.isNotBlank(name)) {
			for (JclqPlayType type : JclqPlayType.values()) {
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
