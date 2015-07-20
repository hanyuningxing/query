package com.miracle.lotteryutils.pl;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum PlPlayType implements PlayTypeItem{
	/*排列五直选*/
	Pl5Direct("0","排列五直选",Boolean.TRUE,Boolean.TRUE,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02,03-01-01-01","彩球（5）例如：01,02,03,04,05",null),
	/*排列三直选*/
	Pl3Direct("1","排列三直选",Boolean.TRUE,Boolean.TRUE,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02,03-01","彩球（3）例如：01,02,03",null),
	/*排列三组三*/
	Pl3Group3("2","排列三组三",Boolean.TRUE,Boolean.TRUE,null,"彩球（大于2）。例如：01,02,03","彩球（3）例如：01,01,03",null),
	/*排列三组六*/
	Pl3Group6("3","排列三组六",Boolean.TRUE,Boolean.TRUE,null,"彩球（大于3）范围 0-9。例如：01,02,03,04	","彩球（3）范围 0-9 例如：01,02,03",null),
	/*排列三直选和值*/
	Pl3DirectSum("4","排列三直选和值",Boolean.FALSE,null,null,"彩球（大于1） 范围：1-27 ",null,null),
	/*排列三组选和值*/
	Pl3GroupSum("5","排列三组选和值",Boolean.TRUE,null,null,"彩球（大于3）。范围：1-26",null,null),
	/*排列三包串*/
	Pl3Bao("6","排列三包串",Boolean.FALSE,null,null,"彩球（大于3）范围 0-9。例如：01,02,03,04",null,null),
	/*排列三直选跨度*/
	Pl3DirectCross("7","排列三直选跨度",Boolean.TRUE,null,null,"彩球（大于1）范围 0-9。例如：01",null,null),
	/*排列三组选三跨度*/
	Pl3Group3Cross("8","排列三组选三跨度",Boolean.TRUE,null,null,"彩球（大于1）范围 1-9。例如：01",null,null),
	/*排列三组选六跨度*/
	Pl3Group6Cross("9","排列三组选六跨度",Boolean.TRUE,null,null,"彩球（大于1）范围 2-9。例如：02",null,null),

	;
 
	private final String playType;
	private final String typeName;
	private final Boolean singleSupport;//支持单式
	private final Boolean compoundSupport;//支持复式
	private final Boolean danSupport;//支持胆拖

	private final String compoundValue;//复式
	
	private final String singleValue;//单式
	
	private final String danValue;
	
	
	private PlPlayType(String playType,String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue) {
		
		this.playType = playType;
		
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
		return playType;
	}
	
	

}
