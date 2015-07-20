package com.miracle.query;

import com.miracle.lotteryutils.Lottery;

public class TicketCountBean {
	private Lottery lotteryType;
	private Long totalCost;
	private Long totalCount;
	private Double addPrize;
	private Double totalPrize;
	private Double totalPrizeAfterTax;
	
	public String getLotteryTypeName(){
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
	public Long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Double getAddPrize() {
		return addPrize;
	}
	public void setAddPrize(Double addPrize) {
		this.addPrize = addPrize;
	}
	public Double getTotalPrize() {
		return totalPrize;
	}
	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	public Double getTotalPrizeAfterTax() {
		return totalPrizeAfterTax;
	}

	public void setTotalPrizeAfterTax(Double totalPrizeAfterTax) {
		this.totalPrizeAfterTax = totalPrizeAfterTax;
	}
	
	
}
