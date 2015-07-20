package com.miracle.model.ticket;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.miracle.common.Constant;
import com.miracle.exception.DataException;
import com.miracle.model.IdEntityWithTimeFlag;

@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "TICKET_PLATFORM")
public class TicketPlatformInfo extends IdEntityWithTimeFlag {
	private static final long serialVersionUID = 5919843711612214128L;

	public static final boolean NO_LOCK_STATUS = false;
	private Long userId;
	
	private String platformName;
	/** 版本号,用于实现乐观锁 */
	private Integer version;
	/** 账户密码 */
	private String password;

	/** 账户是否被锁定 */
	private boolean locked;

	/** 账户余额 */
	private BigDecimal remainMoney;

	/** 消费总额 */
	private BigDecimal consumptionMoney;
	
	private String limitIp;

	@Column(nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return {@link #version}
	 */
	@Version
	@Column(nullable = false)
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return {@link #remainMoney}
	 */
	@Column(precision = 18, scale = 4, columnDefinition = "decimal(18,4) default '0'")
	public BigDecimal getRemainMoney() {
		return remainMoney;
	}

	/**
	 * @param remainMoney
	 *            the {@link #remainMoney} to set
	 */
	public void setRemainMoney(BigDecimal remainMoney) {
		this.remainMoney = remainMoney;
	}

	/**
	 * @return {@link #consumptionMoney}
	 */
	@Column(precision = 18, scale = 4, columnDefinition = "decimal(18,4) default 0")
	public BigDecimal getConsumptionMoney() {
		return consumptionMoney;
	}

	/**
	 * @param consumptionMoney
	 *            the {@link #consumptionMoney} to set
	 */
	public void setConsumptionMoney(BigDecimal consumptionMoney) {
		this.consumptionMoney = consumptionMoney;
	}
	/**
	 * @return {@link #locked}
	 */
	@Column(nullable = false, columnDefinition = "bit(1) default 0")
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked
	 *            the {@link #locked} to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	/* --------------------- logic method --------------------- */

	/**
	 * 增加账户余额
	 * 
	 * @param money
	 *            增加的金额
	 * @throws DataException
	 */
	public void addMoney(BigDecimal money) throws DataException {
		if (money == null || money.doubleValue() <= 0)
			throw new DataException("增加的金额不能为空或小于等于零.");

		this.remainMoney = (this.remainMoney == null) ? money
				: this.remainMoney.add(money);
	}

	/**
	 * 扣除账户余额
	 * 
	 * @param money
	 *            扣除的金额
	 * @throws DataException
	 */
	public void subtractMoney(BigDecimal money) throws DataException {
		if (money == null || money.doubleValue() <= 0)
			throw new DataException("扣除的金额不能为空或小于等于零.");
		if (this.remainMoney == null || this.remainMoney.doubleValue() == 0)
			throw new DataException("账户余额为零,不能扣除金额.");
		if (this.remainMoney.compareTo(money) < 0)
			throw new DataException("扣除的金额大于账户余额.");

		this.remainMoney = this.remainMoney.subtract(money);
	}

	/**
	 * 减少用户消费金额
	 * 
	 * @param money
	 *            减少的消费金额
	 * @throws DataException
	 */
	public void subtractConsumptionMoney(BigDecimal money) throws DataException {
		if (money == null || money.doubleValue() <= 0)
			throw new DataException("减少的消费金额不能为空或小于等于零.");
		else if (this.consumptionMoney == null
				|| this.consumptionMoney.doubleValue() == 0)
			// 先处理数据。以前没有统计的。现在进来这里报错。先设置为0。
			this.consumptionMoney = BigDecimal.valueOf(0);
		// throw new DataException("消费金额为零,不能减少消费金额.");
		else if (this.consumptionMoney.compareTo(money) < 0)
			// 先处理数据。以前没有统计的。现在进来这里报错。先设置为0。
			this.consumptionMoney = BigDecimal.valueOf(0);
		// throw new DataException("减少消费金额大于用户消费金额.");

		this.consumptionMoney = this.consumptionMoney.subtract(money);
	}

	/**
	 * 判读是不是改用户的上级用户
	 * 
	 * @param money
	 *            增加的消费金额
	 * @throws DataException
	 */
	public void addConsumptionMoney(BigDecimal money) throws DataException {
		if (money == null || money.doubleValue() <= 0)
			throw new DataException("增加的消费金额不能为空或小于等于零.");

		this.consumptionMoney = (this.consumptionMoney == null) ? money
				: this.consumptionMoney.add(money);
	}
	@Column
	public String getLimitIp() {
		return limitIp;
	}

	public void setLimitIp(String limitIp) {
		this.limitIp = limitIp;
	}
	@Column
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column
	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	



}