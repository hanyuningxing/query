package com.miracle.lotteryutils;

/**
 * 选项接口
 * 
 */
public interface PassTypeItem {

	/**
	 * @return 选项名称
	 */
	String getText();
	
	Integer getBetValue();
	
	String getTypeName();
}
