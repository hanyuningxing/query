package com.miracle.lotteryutils.ssq;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum SsqPlayType implements PlayTypeItem{
	
	/*常规*/
	General("常规玩法",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,"红球（大于6）+蓝球（大于1） 例如：01,02,03,04,05,06,07|01,02","红球（6）+蓝球（1） 例如：01,02,03,04,05,06|01","红球胆码（大于1）+ 红球拖码+蓝球( 大于1例如：01,02,03;04,05,06,07|01 )"); 


	
	private SsqPlayType( String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue){
		this.typeName = typeName;
		
		this.compoundSupport = compoundSupport;
		this.singleSupport = singleSupport;
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
