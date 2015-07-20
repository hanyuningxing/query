package com.miracle.lotteryutils.ssc;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum SscPlayType implements PlayTypeItem{
	 
	/**一星直选*/
	OneStarDirect("一星直选",Boolean.TRUE,null,null,"定位复式，例如：01,02,03",null,null),	
	
	/**二星直选*/
	TwoStarDirect("二星直选",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02",null,null),	
	
	/**三星直选*/
	ThreeStarDirect("三星直选",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02-01",null,null   ),	

	/**五星直选*/
	FiveStarDirect("五星直选",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02-01-01,02-01",null,null),	

	/**三星组三*/
	ThreeStarGroup3("三星组三",Boolean.FALSE,null,null,"0-9号码选择2个成为一注。例如01,02",null,null),	

	/**三星组六*/
	ThreeStarGroup6("三星组六",Boolean.FALSE,null,null,"0-9号码选择3个成为一注。例如01,02,03",null,null),	

	/**三星直选和值*/
	ThreeStarDirectSum("三星直选和值",Boolean.FALSE,null,null,"0-27号码选择1个成为一注。例如01 表示投注和值为1",null,null),	

	/**三星组选和值*/
	ThreeStarGroupSum("三星组选和值",Boolean.FALSE,null,null,"0-27号码选择1个成为一注。例如01 表示投注和值为1",null,null),	

	/**二星直选和值*/
	TwoStarDirectSum("二星直选和值",Boolean.FALSE,null,null,"0-18号码选择1个成为一注。例如01 表示投注和值为1",null,null),	

	/**二星组选和值*/
	TwoStarGroupSum("二星组选和值",Boolean.TRUE,null,null,"0-18号码选择1个成为一注。例如01 表示投注和值为1",null,null),	

	/**五星通选*/
	FiveStarGeneral("五星通选",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02-01-01,02-01",null,null),	

	/**二星组选*/
	TwoStarGroup("二星组选",Boolean.TRUE,null,null,"0-9号码选择2个成为一注。例如01,02",null,null),		
	
	/**大小单双*/
	BigSmall("大小单双",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开，大=2小=1双=4单=5  例如：  2-1表示投注是 十位是大，个位是小",null,null),	
	; 

	private final String typeName;
	private final Boolean singleSupport;//支持单式
	private final Boolean compoundSupport;//支持复式
	private final Boolean danSupport;//支持胆拖

	private final String compoundValue;//复式
	
	private final String singleValue;//单式
	
	private final String danValue;
	
	
	private SscPlayType(String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue) {
	
		this.typeName = typeName;
		this.singleSupport = singleSupport;
		this.compoundSupport = compoundSupport;
		this.danSupport = danSupport;		
		this.singleValue = singleValue;
		this.compoundValue = compoundValue;
		this.danValue = danValue;
	}
	
	@Override
	public String getText() {
		return this.typeName;
	}

	@Override
	public Integer getMaxItemSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item[] getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return this.ordinal();
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return typeName;
	}

	public Boolean getSingleSupport() {
		return singleSupport;
	}

	public Boolean getCompoundSupport() {
		return compoundSupport;
	}

	public Boolean getDanSupport() {
		return danSupport;
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

	public String getPlayType() {
		return null;
	}
	
	

}
