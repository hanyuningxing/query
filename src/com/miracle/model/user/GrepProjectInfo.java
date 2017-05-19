package com.miracle.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.miracle.common.Constant;
import com.miracle.model.IdEntity;

/**
 * 采集用户信息
 * 
 */
@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "Grep_Project_INFO")
public class GrepProjectInfo extends IdEntity  {
	private static final long serialVersionUID = -6038223448159787776L;
	
	/** 用户名 */
	private String uid;
	/** 昵称 */
	private String nickName;
	/** 彩种 */
	private String gid;
	/** 期次 */
	private String pid;
	/** 方案号 */
	private String projectId;
	/** 内容 */
	private String code;
	/** 方案金额 */
	private double moeny;
	/** 倍数 */
	private Integer multiple;
	/** 发送标示 */
	private boolean send;
	/** 版本号,用于实现乐观锁 */
	private Integer version;
	/** 创建时间 */
	private Date createTime;
	/** 结束时间 */
	private Date endTime;
	/** 反馈消息 */
	private String messages;
	/** 是否中奖 */
	private Integer wonFlag;
	/** 连中数 */
	private Integer wonNum;
	/** 热门人 */
	private boolean hotPerson;
	/** 查询方案选择是否同步 */
	private boolean flag;


	@Column(nullable = false, length = 40)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	@Column(nullable = false, length = 40)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(nullable = false, length = 20)
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}
	@Column(nullable = false, length = 20)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	@Column(nullable = false, length = 20)
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	@Column(nullable = false, length = 1000)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Column(precision = 18, scale = 1, columnDefinition = "decimal(18,1) default '0'")
	public double getMoeny() {
		return moeny;
	}

	public void setMoeny(double moeny) {
		this.moeny = moeny;
	}
	@Column
	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}
	
	@Column(columnDefinition = "bit(1) default 0")
	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

	@Column(length = 220)
	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
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
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(final Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return {@link #version}
	 */
	@Version
	@Column
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(final Integer version) {
		this.version = version;
	}
	
	@Column
	public Integer getWonFlag() {
		return wonFlag;
	}

	public void setWonFlag(Integer wonFlag) {
		this.wonFlag = wonFlag;
	}
	@Transient
	public Integer getWonNum() {
		return wonNum;
	}

	public void setWonNum(Integer wonNum) {
		this.wonNum = wonNum;
	}

	@Transient
	public boolean isHotPerson() {
		return hotPerson;
	}

	public void setHotPerson(boolean hotPerson) {
		this.hotPerson = hotPerson;
	}
	@Column(columnDefinition = "bit(1) default 0")
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
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
		GrepProjectInfo other = (GrepProjectInfo) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
