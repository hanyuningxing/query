package com.miracle.lotteryutils.jczq;

import com.miracle.lotteryutils.MatchItem;

public enum ChampionMatchItem implements MatchItem{
	
	
	A("001","西班牙"),
	B("002","德国"),
	C("003","荷兰"),
	D("004","英格兰"),
	E("005","葡萄牙"),
	F("006","法国"),
	G("007","意大利"),
	H("008","俄罗斯"),
	I("009","克罗地亚"),
	J("010","乌克兰"),
	K("011","波兰"),
	L("012","瑞典"),
	M("013","捷克"),
	N("014","丹麦"),
	O("015","希腊"),
	P("016","爱尔兰"),
 
	;

	
	private final String match;
	private final String team;
	
	private ChampionMatchItem(String match,String team){
		this.match = match;
		this.team = team;
	}
	
	@Override
	public String getMatch() {
		// TODO Auto-generated method stub
		return match;
	}

	@Override
	public String getTeam() {
		// TODO Auto-generated method stub
		return team;
	}

}
