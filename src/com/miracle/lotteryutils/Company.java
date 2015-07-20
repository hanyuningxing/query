package com.miracle.lotteryutils;

public enum Company {
	
 
	ninety9(0,"99家"),
	weilian(2,"威廉"),
	libo(3,"立博"),
	bet365(4,"Bet365"),
	bwin(6,"Bwin"),
	macao(5,"澳门"),
	jinbaobo(9,"金宝博")
	;
	private final Integer key;
	private final String name;
	
	
	private Company(Integer key,String name){
		this.key = key;
		this.name = name;
	}


	public Integer getKey() {
		return key;
	}


	public String getName() {
		return name;
	}
	
	

	
}
