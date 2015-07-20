package com.miracle.query;

import com.miracle.common.FundDetailType;
import com.miracle.common.FundMode;

public class UserQuery {
	
	private String startTime;
	private String endTime;
	private FundDetailType fundType;
	private FundMode fundMode;
	private String remark;
	private String export;
	
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
	public FundDetailType getFundType() {
		return fundType;
	}
	public void setFundType(FundDetailType fundType) {
		this.fundType = fundType;
	}
	public FundMode getFundMode() {
		return fundMode;
	}
	public void setFundMode(FundMode fundMode) {
		this.fundMode = fundMode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getExport() {
		return export;
	}
	public void setExport(String export) {
		this.export = export;
	}
	
	
}
