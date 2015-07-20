package com.miracle.query;

import com.miracle.common.FundDetailType;

public class FundDetailShow {
	
	private FundDetailType type;
	
	private double moneyIn;
	
	private double moneyOut;
	
	private long fundCount;
	
	public String getFundTypeName(){
		if(type!=null){
			return type.getTypeName();
		}
		return null;
	}

	public FundDetailType getType() {
		return type;
	}

	public void setType(FundDetailType type) {
		this.type = type;
	}

	public double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(double moneyIn) {
		this.moneyIn = moneyIn;
	}

	public double getMoneyOut() {
		return moneyOut;
	}

	public void setMoneyOut(double moneyOut) {
		this.moneyOut = moneyOut;
	}

	public long getFundCount() {
		return fundCount;
	}

	public void setFundCount(long fundCount) {
		this.fundCount = fundCount;
	}
	
	
}
