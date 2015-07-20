package com.miracle.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.miracle.common.Constant;
import com.miracle.orm.hibernate.CreateMarkable;
import com.miracle.orm.hibernate.UpdateMarkable;

/**
 * 银行卡信息
 * 
 */
@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "USER_BANK_INFO")
public class BankInfo implements CreateMarkable, UpdateMarkable, Serializable {
	private static final long serialVersionUID = -6038223448159787776L;
	private Long id;
	private String partBankProvince;

	private String partBankCity;

	private String partBankName;

	/** 银行卡开户银行名称 */
	private String bankName;

	/** 银行卡号码 */
	private String bankCard;

	/** 购彩账户 */
	private User user;

	/** 版本号,用于实现乐观锁 */
	private Integer version;

	/** 创建时间 */
	private Date createTime;

	/** 最后更新时间 */
	private Date lastModifyTime;

	@Id
	@Column(name = "id")
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = { @Parameter(name = "property", value = "user") })
	@GeneratedValue(generator = "generator")
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return {@link #user}
	 */
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return user;
	}

	/**
	 * @param user the {@link #user} to set
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * @return {@link #bankName}
	 */
	@Column(length = 200)
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the {@link #bankName} to set
	 */
	public void setBankName(final String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return {@link #bankCard}
	 */
	@Column(length = 30)
	public String getBankCard() {
		return bankCard;
	}

	/**
	 * @param bankCard the {@link #bankCard} to set
	 */
	public void setBankCard(final String bankCard) {
		this.bankCard = bankCard;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(final Date createTime) {
		this.createTime = createTime;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	@Override
	public void setLastModifyTime(final Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
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
	 * @param version the version to set
	 */
	public void setVersion(final Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Column(length = 30)
	public String getPartBankProvince() {
		return partBankProvince;
	}

	public void setPartBankProvince(final String partBankProvince) {
		this.partBankProvince = partBankProvince;
	}

	@Column(length = 30)
	public String getPartBankCity() {
		return partBankCity;
	}

	public void setPartBankCity(final String partBankCity) {
		this.partBankCity = partBankCity;
	}

	@Column(length = 200)
	public String getPartBankName() {
		return partBankName;
	}

	public void setPartBankName(final String partBankName) {
		this.partBankName = partBankName;
	}
}
