package com.miracle.lotteryutils.sevenstar;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum SevenStarPlayType implements PlayTypeItem{
	/*常规*/
	General("常规玩法",Boolean.TRUE,Boolean.TRUE,null,"彩球（大于7）范围：0-9 每个区间用-隔开 例如：01-02-03-04-05-06-01"  ,  "彩球（7）范围：0-9 例如：01,02,03,04,05,06,07",null); 


	
	private SevenStarPlayType( String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue){
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
