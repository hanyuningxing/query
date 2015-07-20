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
public class TicketLogger extends IdEntity implements CreateMarkable {

	private static final long serialVersionUID = -1618582525232766677L;

	/** 创建时间 */
	private Date createTime;

	/** 发起人ID */
	private Long userId;

	/** 彩种 */
	private Lottery lotteryType;

	/** 请求内容 */
	private String reqContent;

	/** 返回内容 */
	private String respContent;

	/** 发送时间 */
	private Date respTime;

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

	@Lob
	@Column(updatable = false)
	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(final String reqContent) {
		this.reqContent = reqContent;
	}

	@Lob
	@Column
	public String getRespContent() {
		return respContent;
	}

	public void setRespContent(final String respContent) {
		this.respContent = respContent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	public Date getRespTime() {
		return respTime;
	}

	public void setRespTime(final Date respTime) {
		this.respTime = respTime;
	}

}
