package com.miracle.lotteryutils.el11to5;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum El11to5PlayType implements PlayTypeItem{
	 
	/**任选1*/
	R1("任选一",Boolean.TRUE,null,null,"1-11号码选择至少（任选玩法个数-例如任选三就是最少3个号码）个成为一注。例如01,02",null,null),	
	
	/**任选二*/
	R2("任选二",Boolean.TRUE,null,null,"同任选1",null,null),	
	
	/**前二组选*/
	Q2Group("前二组选",Boolean.TRUE,null,null,"1-11号码选择至少2个号码组成一注 例如01,02",null,null   ),	

	/**前二直选*/
	Q2Direct("前二直选",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02",null,null),	

	/**任选三*/
	R3("任选三",Boolean.TRUE,null,null,"同任选1",null,null),	

	/**前三组选*/
	Q3Group("前三组选",Boolean.TRUE,null,null,"1-11号码选择至少3个号码组成一注 例如01,02,03",null,null),	

	/**前三直选*/
	Q3Direct("前三直选",Boolean.TRUE,null,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02-01",null,null),	

	/**任选四*/
	R4("任选四",Boolean.TRUE,null,null,"同任选1",null,null),	

	/**任选五*/
	R5("任选五",Boolean.TRUE,null,null,"同任选1",null,null),	

	/**任选六*/
	R6("任选六",Boolean.TRUE,null,null,"同任选1",null,null),	

	/**任选七*/
	R7("任选七",Boolean.TRUE,null,null,"同任选1",null,null),	

	/**任选八*/
	R8("任选八",Boolean.TRUE,null,null,"同任选1",null,null),		
	; 

	private final String typeName;
	private final Boolean singleSupport;//支持单式
	private final Boolean compoundSupport;//支持复式
	private final Boolean danSupport;//支持胆拖

	private final String compoundValue;//复式
	
	private final String singleValue;//单式
	
	private final String danValue;
	
	
	private El11to5PlayType(String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue) {
	
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
