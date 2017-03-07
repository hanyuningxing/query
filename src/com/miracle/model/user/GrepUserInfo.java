package com.miracle.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.miracle.common.Constant;
import com.miracle.model.IdEntity;

/**
 * 采集用户信息
 * 
 */
@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "Grep_USER_INFO")
public class GrepUserInfo extends IdEntity {
	private static final long serialVersionUID = -6038223448159787776L;
	
	/** 用户名 */
	private String uid;
	/** 中奖金额 */
	private double wonMoeny;
	/** 中奖次数 /或者表示连中*/
	private Integer wonNum=0;
	/** 版本号,用于实现乐观锁 */
	private Integer version;
	/** 创建时间 */
	private Date createTime;
	/** 最后更新时间 */
	private Date lastModifyTime;
	
	/** 方案次数、或者表示月 */
	private Integer proNum=0;
	/** 方案中奖次数、或者表示月 */
	private Integer proWonNum=0;
	/** 方案中奖时间 */
	private Date proWonTime;

	
	/** 周方案次数 */
	private Integer weekNum=0;
	/** 周方案中奖次数 */
	private Integer weekWonNum=0;
	/** 周方案时间 */
	private Date weekTime;
	
	/** 热门人 */
	private boolean hotPerson;

	@Column
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	@Column(precision = 18, scale = 1, columnDefinition = "decimal(18,1) default '0'")
	public double getWonMoeny() {
		return wonMoeny;
	}

	public void setWonMoeny(double wonMoeny) {
		this.wonMoeny = wonMoeny;
	}
	@Column
	public Integer getWonNum() {
		return wonNum;
	}

	public void setWonNum(Integer wonNum) {
		this.wonNum = wonNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(final Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

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
	@Column(nullable = false)
	public Integer getProNum() {
		return proNum;
	}

	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}
	@Column(nullable = false)
	public Integer getProWonNum() {
		return proWonNum;
	}

	public void setProWonNum(Integer proWonNum) {
		this.proWonNum = proWonNum;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	public Date getProWonTime() {
		return proWonTime;
	}

	public void setProWonTime(Date proWonTime) {
		this.proWonTime = proWonTime;
	}
	@Column(nullable = false)
	public Integer getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}
	@Column(nullable = false)
	public Integer getWeekWonNum() {
		return weekWonNum;
	}

	public void setWeekWonNum(Integer weekWonNum) {
		this.weekWonNum = weekWonNum;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	public Date getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(Date weekTime) {
		this.weekTime = weekTime;
	}
	@Column(columnDefinition = "bit(1) default 0")
	public boolean isHotPerson() {
		return hotPerson;
	}

	public void setHotPerson(boolean hotPerson) {
		this.hotPerson = hotPerson;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrepUserInfo other = (GrepUserInfo) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
