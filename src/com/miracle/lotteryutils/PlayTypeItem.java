package com.miracle.lotteryutils;

/**
 * 选项接口
 * 
 */
public interface PlayTypeItem {

	/**
	 * @return 选项名称
	 */
	String getText();

	Integer getMaxItemSize();

	Item[] getAllItems();
	
	Integer getValue();
	
	String getTypeName();
}
