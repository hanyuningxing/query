package com.miracle.lotteryutils.jczq;

import com.miracle.lotteryutils.MatchItem;

/**
 * 冠亚军玩法
 * @author Administrator
 *
 */

public enum ChampionRunnerUpMatchItem implements MatchItem{
	
	
	A("001","德国—荷兰"),
	B("002","西班牙—德国"),
	C("003","西班牙—荷兰"),
	D("004","西班牙—英格兰"),
	E("005","西班牙—意大利"),
	F("006","西班牙—葡萄牙"),
	G("007","德国—葡萄牙"),
	H("008","西班牙—法国"),
	I("009","德国—英格兰"),
	J("010","荷兰—葡萄牙"),
	K("011","西班牙—克罗地亚"),
	L("012","荷兰—英格兰"),
	M("013","西班牙—俄罗斯"),
	N("014","德国—法国"),
	O("015","德国—意大利"),
	P("016","西班牙—乌克兰"),
	Q("017","荷兰—法国"),
	R("018","德国—俄罗斯"),
	S("019","荷兰—意大利"),
	T("020","西班牙—波兰"),
	U("021","英格兰—法国"),
	V("022","英格兰—葡萄牙"),
	
	W("023","德国—克罗地亚"),
	X("024","德国—乌克兰"),
	Y("025","西班牙—捷克"),
	Z("026","西班牙—瑞典"),
	AA("027","德国—捷克"),
	AB("028","德国—波兰"),
	AC("029","德国—瑞典"),
	AD("030","荷兰—波兰"),
	
	AE("031","荷兰—俄罗斯"),
	AF("032","荷兰—乌克兰"),
	AG("033","葡萄牙—法国"),
	AH("034","葡萄牙—意大利"),
	AI("035","荷兰—克罗地亚"),
	AJ("036","英格兰—意大利"),
	AK("037","荷兰—瑞典"),
	AL("038","英格兰—俄罗斯"),
	AM("039","英格兰—乌克兰"),
	AN("040","意大利—法国"),

	BA("041","葡萄牙—俄罗斯"),
	BB("042","英格兰—克罗地亚"),
	BC("043","英格兰—波兰"),
	BD("044","法国—俄罗斯"),
	BE("045","法国—乌克兰"),
	BF("046","葡萄牙—克罗地亚"),
	BG("047","葡萄牙—波兰"),
	BH("048","葡萄牙—乌克兰"),
	BI("049","意大利—乌克兰"),
	BJ("050","—其它—"),

	;

	
	private final String match;
	private final String team;
	
	private ChampionRunnerUpMatchItem(String match,String team){
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
