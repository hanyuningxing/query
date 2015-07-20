package com.miracle.model.ticket;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.type.EnumType;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Lottery;
import com.miracle.model.IdEntity;
import com.miracle.orm.hibernate.CreateMarkable;

@Table(name = Constant.LOTTERY_TABLE_PREFIX + "TICKET_PROCESS")
@Entity
public class TicketProcess extends IdEntity implements CreateMarkable {

	private static final long serialVersionUID = 1992846935549712020L;

	/** 创建时间 */
	private Date createTime;

	/** 发起人ID */
	private Long userId;

	/** orderId */
	private Long orderId;

	/** 彩种 */
	private Lottery lotteryType;

	/** 处理 */
	private String process;

	/** 错误内容 */
	private String errorMsg;

	/** 错误内容 */
	private String exceptionMsg;

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(final Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return {@link #lotteryType}
	 */
	@Type(type = "org.hibernate.type.EnumType", parameters = {
			@Parameter(name = EnumType.ENUM, value = "com.cai310.lottery.common.Lottery"),
			@Parameter(name = EnumType.TYPE, value = Lottery.SQL_TYPE) })
	@Column(updatable = false)
	public Lottery getLotteryType() {
		return lotteryType;
	}

	/**
	 * @param lotteryType the {@link #lotteryType} to set
	 */
	public void setLotteryType(final Lottery lotteryType) {
		this.lotteryType = lotteryType;
	}

	@Column(updatable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	@Column
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(final String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Column
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(final Long orderId) {
		this.orderId = orderId;
	}

	@Column
	public String getProcess() {
		return process;
	}

	public void setProcess(final String process) {
		this.process = process;
	}

	@Lob
	@Column
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(final String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
