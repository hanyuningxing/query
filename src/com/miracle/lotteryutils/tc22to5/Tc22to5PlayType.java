package com.miracle.lotteryutils.tc22to5;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum Tc22to5PlayType implements PlayTypeItem{
	/*常规*/
	General("常规玩法",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,"彩球（大于5）范围：1-22例如：01,02,03,04,05,06,07",  "彩球（5）范围：1-22 例如：01,02,03,04,05"  ,  "彩球胆码（大于1）+ 彩球拖码    (加起来大于5)例如：01,02,03;04,05,06 注：红色为彩球胆码，橙色为彩球拖码 分隔符是; "); 


	
	private Tc22to5PlayType( String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue){
		this.typeName = typeName;
		this.singleSupport = singleSupport;
		this.compoundSupport = compoundSupport;
		this.danSupport = danSupport;
		
		this.singleValue = singleValue;
		this.compoundValue = compoundValue;
		this.danValue = danValue;
	}
	
	private final String typeName;
	private final Boolean compoundSupport;
	private final Boolean singleSupport;
	private final Boolean danSupport;
	private final String compoundValue;
	private final String singleValue;
	private final String danValue;	

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.getTypeName();
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

	public Boolean getCompoundSupport() {
		return compoundSupport;
	}

	public Boolean getSingleSupport() {
		return singleSupport;
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
	
	
}
