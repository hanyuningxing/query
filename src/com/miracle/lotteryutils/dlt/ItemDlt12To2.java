package com.miracle.lotteryutils.dlt;

import com.miracle.lotteryutils.Item;

public enum ItemDlt12To2 implements Item{
	/*复式*/
	Compound("复式","后区（大于2） 例如： 01,02"),
	/*单式*/
	Single("单式","后区（2） 例如： 06,01"),
	 ;
	
	private ItemDlt12To2(String text ,String value){
		this.text  = text;
		this.value = value;
	}
	
	private String text;
	private String value;


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.text;
	}

}
