package com.miracle.query;

import com.miracle.common.TicketSchemeState;
import com.miracle.lotteryutils.Lottery;

public class TicketQuery {

	private String startTime;//起始时间

	private String endTime;//结束时间

	private Lottery lotteryType;//彩种

	private TicketSchemeState schemeState;//状态

	private String outOrderNumber;//方案编号

	private String orderId;//订单号

	private String orderFiled;//排序字段

	private Integer orderDesc = 0; //0:升序1:降序 

	private String periodNmStart;//期号起

	private String periodNmEnd;//期号止

	private String betType;//玩法类型
	
	private String export;
	
	private String periodNum;
	
	private String ticketStartTime;//起始时间

	private String ticketEndTime;//结束时间

	public Integer getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(final Integer orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(final String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(final String endTime) {
		this.endTime = endTime;
	}

	public Lottery getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(final Lottery lotteryType) {
		this.lotteryType = lotteryType;
	}

	public TicketSchemeState getSchemeState() {
		return schemeState;
	}

	public void setSchemeState(final TicketSchemeState schemeState) {
		this.schemeState = schemeState;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

	public String getOrderFiled() {
		return orderFiled;
	}

	public void setOrderFiled(final String orderFiled) {
		this.orderFiled = orderFiled;
	}

	public String getPeriodNmStart() {
		return periodNmStart;
	}

	public void setPeriodNmStart(final String periodNmStart) {
		this.periodNmStart = periodNmStart;
	}

	public String getPeriodNmEnd() {
		return periodNmEnd;
	}

	public void setPeriodNmEnd(final String periodNmEnd) {
		this.periodNmEnd = periodNmEnd;
	}

	public String getBetType() {
		return betType;
	}

	public void setBetType(final String betType) {
		this.betType = betType;
	}

	public String getOutOrderNumber() {
		return outOrderNumber;
	}

	public void setOutOrderNumber(final String outOrderNumber) {
		this.outOrderNumber = outOrderNumber;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	public String getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(String periodNum) {
		this.periodNum = periodNum;
	}

	public String getTicketStartTime() {
		return ticketStartTime;
	}

	public void setTicketStartTime(String ticketStartTime) {
		this.ticketStartTime = ticketStartTime;
	}

	public String getTicketEndTime() {
		return ticketEndTime;
	}

	public void setTicketEndTime(String ticketEndTime) {
		this.ticketEndTime = ticketEndTime;
	}

}
