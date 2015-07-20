package com.miracle.model.user;

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
import com.miracle.model.IdEntity;
import com.miracle.model.IdEntityWithTimeFlag;

@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "USER")
public class User extends IdEntity{
	private static final long serialVersionUID = 5919843711612214128L;

	public static final boolean NO_LOCK_STATUS = false;
	/** 版本号,用于实现乐观锁 */
	private Integer version;

	/** 用户名 */
	private String userName;

	/** 账户密码 */
	private String password;

	/** 提款密码 */
	private String tkpassword;

	/** 账户是否被锁定 */
	private boolean locked;

	/** 账户余额 */
	private BigDecimal remainMoney;

	/** 消费总额 */
	private BigDecimal consumptionMoney;
	/**推广佣金*/
	private Double comission;

	/** 创建时间 */
	private Date createTime;

	/** 最后更新时间 */
	private Date lastModifyTime;
	/**
	 * 用户信息
	 * 
	 * @see com.cai310.lottery.entity.user.BankInfo
	 */
	private UserInfo info;
	/** 上级用户ID */
	private Long agentId;

	/** 用户的返点 */
	private Double rebate;
	/** 用户分销图：如1-2-6就是本用户的上级用户按顺序是6，2，1id的用户,为0的是网站第一人 */
	private String relation;
	// 媒体ID。记录用户的来源
	private Long mid;
	/**
	 * 银行卡信息
	 * 
	 * @see com.cai310.lottery.entity.user.BankInfo
	 */
	private BankInfo bank;

	@Column(nullable = false, length = 20, updatable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = true, length = 32)
	public String getTkpassword() {
		return this.tkpassword;
	}

	public void setTkpassword(String tkpassword) {
		this.tkpassword = tkpassword;
	}

	/**
	 * @return the createTime
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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


	public Double getComission() {
		return comission;
	}

	public void setComission(Double comission) {
		this.comission = comission;
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

	/**
	 * @return {@link #bank}
	 */
	@OneToOne(optional = true, mappedBy = "user")
	public BankInfo getBank() {
		return bank;
	}

	/**
	 * @param bank
	 *            the {@link #bank} to set
	 */
	public void setBank(BankInfo bank) {
		this.bank = bank;
	}

	@OneToOne(optional = true, mappedBy = "user")
	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
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
	 * 增加用户消费金额
	 * 
	 * @param money
	 *            增加的消费金额
	 * @throws DataException
	 */
	public boolean checkRelation(User user) throws DataException {
		boolean r = false;
		String relation = this.getRelation();
		if (relation.equals("" + user.getId())) {
			r = true;
		} else if (relation.indexOf(user.getId() + "-") != -1) {
			r = true;
		} else if (relation.indexOf("-" + user.getId()) != -1) {
			r = true;
		} else if (relation.indexOf("-" + user.getId() + "-") != -1) {
			r = true;
		}
		return r;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	@Column
	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	@Column
	public Double getRebate() {
		return rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

	@Column(length = 200)
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Column
	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	

	// 手机为了一致性
	@Transient
	public Long getUserId() {
		return this.getId();
	}

	// 手机为了一致性
	@Transient
	public String getUserPwd() {
		return this.getPassword();
	}

	

	

	// 手机端回显手机号
	@Transient
	public String getRealName() {

		String realName = "";
		if (this.getInfo() != null) {
			realName = this.getInfo().getRealName();
		}
		return realName;
	}

	@Transient
	public String getMobile() {

		String mobile = "";
		if (this.getInfo() != null) {
			mobile = this.getInfo().getMobile();
		}
		return mobile;
	}

}