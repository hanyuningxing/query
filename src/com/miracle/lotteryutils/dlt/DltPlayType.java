package com.miracle.lotteryutils.dlt;


import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum DltPlayType implements PlayTypeItem{
	/** 常规玩法*/
	General("常规玩法", Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,"前区（大于5）+后区（大于2） 例如：01,02,03,04,05,06,07|01,02","前区（5）+后区（2） 例如：01,02,03,04,05|06,01","前区胆码（大于1）+ 前区拖码+ 后区胆码（大于1）+ 后区拖码例如：01,02,03;04,05,06,07|01;02,03 注：红色为前区胆码，橙色为前区拖码 分隔符是; 蓝色为后区胆码，绿色为后区拖码 分隔符是;"),

	/** 12选2生肖乐 */
	D12To2("12选2生肖乐",Boolean.TRUE,Boolean.TRUE,null,"后区（大于2） 例如： 01,02","后区（2） 例如： 06,01",null),

	/** 常规追加（每注3元） */
	GeneralAppend("常规追加（每注3元）",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,"前区（大于5）+后区（大于2） 例如：01,02,03,04,05,06,07|01,02","前区（5）+后区（2） 例如：01,02,03,04,05|06,01","前区胆码（大于1）+ 前区拖码+ 后区胆码（大于1）+ 后区拖码例如：01,02,03;04,05,06,07|01;02,03 注：红色为前区胆码，橙色为前区拖码 分隔符是; 蓝色为后区胆码，绿色为后区拖码 分隔符是;");



	private final String typeName;
	private final Boolean compoundSupport;
	private final Boolean singleSupport;
	private final Boolean danSupport;
	private final String compoundValue;
	private final String singleValue;
	private final String danValue;	

 


	private DltPlayType( String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue){
		this.typeName = typeName;
		this.singleSupport = singleSupport;
		this.compoundSupport = compoundSupport;
		this.danSupport = danSupport;
		
		this.singleValue = singleValue;
		this.compoundValue = compoundValue;
		this.danValue = danValue;
	}
	

	/**
	 * @return {@link #text}
	 */
	public String getText() {
		return this.typeName;
	}

 

 

	@Override
	public Integer getValue() {
		return this.ordinal();
	}

	@Override
	public String getTypeName() {
		return typeName;
	}

	@Override
	public Integer getMaxItemSize() {
		// TODO Auto-generated method stub
		return null;
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


	@Override
	public Item[] getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
