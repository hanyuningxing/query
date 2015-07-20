package com.miracle.lotteryutils.klpk;

import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

public enum KlpkPlayType implements PlayTypeItem{
	
	/**同花包选*/
	SAMEBAO("同花包选",Boolean.TRUE,null,null,"内容统一为1",null,null),	
	
	/**同花单选*/
	SAME("同花单选",Boolean.TRUE,null,null,"1-4号码选择至少1个成为一注。1=黑桃 2=红桃 3=梅花 4=方块",null,null),	
	/**顺子包选*/
	SHUNBAO("顺子包选",Boolean.TRUE,null,null,"内容统一为1",null,null),	

	/**顺子单选*/
	SHUN("顺子单选",Boolean.TRUE,null,null,"01-12号码选择至少1个成为一注。01=A23 02=234 03=345 04=456 05=567 06=678 07=789 08=8910 09=910J 10=10JQ 11=JQK 12=QKA",null,null),	

	/**对子包选*/
	DUIBAO("对子包选",Boolean.TRUE,null,null,"内容统一为1",null,null),	

	/**对子单选*/
	DUI("对子单选",Boolean.TRUE,null,null,"01-13号码选择至少1个成为一注。例如01或者01,02,03,04,05,06,07(复试多注)",null,null),		
	
	 
	/**任选1*/
	R1("任选一",Boolean.TRUE,null,null,"01-13号码选择至少1个成为一注。例如01或者01,02,03,04,05,06,07(复试多注)",null,null),	
	
	/**任选二*/
	R2("任选二",Boolean.TRUE,null,null,"01-13号码选择至少2个成为一注。例如01,02或者01,02,03,04,05,06,07(复试多注)",null,null),	
	/**任选三*/
	R3("任选三",Boolean.TRUE,null,null,"01-13号码选择至少2个成为一注。例如01,02,03或者01,02,03,04,05,06,07(复试多注)",null,null),	

	/**任选四*/
	R4("任选四",Boolean.TRUE,null,null,"01-13号码选择至少2个成为一注。例如01,02,03,04或者01,02,03,04,05,06,07(复试多注)",null,null),	

	/**任选五*/
	R5("任选五",Boolean.TRUE,null,null,"01-13号码选择至少2个成为一注。例如01,02,03,04,05或者01,02,03,04,05,06,07(复试多注)",null,null),	

	/**任选六*/
	R6("任选六",Boolean.TRUE,null,null,"01-13号码选择至少6个成为一注。例如01,02,03,04,05,06或者01,02,03,04,05,06,07(复试多注)",null,null),		
	; 

	private final String typeName;
	private final Boolean singleSupport;//支持单式
	private final Boolean compoundSupport;//支持复式
	private final Boolean danSupport;//支持胆拖

	private final String compoundValue;//复式
	
	private final String singleValue;//单式
	
	private final String danValue;
	
	
	private KlpkPlayType(String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue) {
	
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
