package com.miracle.query;

import com.miracle.lotteryutils.Lottery;

public class FundReport {
	
	private Lottery lotteryType;
	
	private Double totalCost;
	
	private Integer totalUnits;
	
	private Integer totalMultiple;
	
	private Integer totalCount;
	
	private Double totalPrize;
	
	private String startTime;
	
	private String endTime;
	
	public String getLotteryName(){
		if(lotteryType!=null){
			return lotteryType.getLotteryName();
		}
		return null;
	}

	public Lottery getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(Lottery lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(Integer totalUnits) {
		this.totalUnits = totalUnits;
	}

	public Integer getTotalMultiple() {
		return totalMultiple;
	}

	public void setTotalMultiple(Integer totalMultiple) {
		this.totalMultiple = totalMultiple;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Double getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
}
