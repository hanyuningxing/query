package com.miracle.lotteryutils.dlt;

import com.miracle.lotteryutils.Item;

public enum ItemDltGeneral implements Item{
	/*复式*/
	Compound("复式","前区（大于5）+后区（大于2） 例如：01,02,03,04,05,06,07|01,02"),
	/*单式*/
	Single("单式","前区（5）+后区（2） 例如：01,02,03,04,05|06,01"),
	
	/**胆拖*/
	Dantuo("胆拖","前区胆码（大于1）+ 前区拖码+ 后区胆码（大于1）+ 后区拖码例如：01,02,03;04,05,06,07|01;02,03 注：红色为前区胆码，橙色为前区拖码 分隔符是;蓝色为后区胆码，绿色为后区拖码 分隔符是    ");

	
	private ItemDltGeneral(String text ,String value){
		this.text  = text;
		this.value = value;
	}
	
	private String text;
	private String value;


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

}
