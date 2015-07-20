package com.miracle.model.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.type.EnumType;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Lottery;
import com.miracle.model.IdEntityWithTimeFlag;

@Table(name = Constant.LOTTERY_TABLE_PREFIX + "NUMBER_LIMIT")
@Entity
public class NumberLimit extends IdEntityWithTimeFlag {

	private static final long serialVersionUID = 2897756835665939308L;

	private String periodNumber;
	
	private Lottery lotteryType;
	
	private String content;
	
	private Integer remainUnits=0;

	@Column(length=50)
	public String getPeriodNumber() {
		return periodNumber;
	}

	public void setPeriodNumber(String periodNumber) {
		this.periodNumber = periodNumber;
	}

	@Type(type = "org.hibernate.type.EnumType", parameters = {
			@Parameter(name = EnumType.ENUM, value = "com.cai310.lottery.common.Lottery"),
			@Parameter(name = EnumType.TYPE, value = Lottery.SQL_TYPE) })
	@Column(nullable = false, updatable = false)
	public Lottery getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(Lottery lotteryType) {
		this.lotteryType = lotteryType;
	}

	@Column(length=500)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(columnDefinition="integer default 0")
	public Integer getRemainUnits() {
		return remainUnits;
	}

	public void setRemainUnits(Integer remainUnits) {
		this.remainUnits = remainUnits;
	}
	
	
	
	
}
