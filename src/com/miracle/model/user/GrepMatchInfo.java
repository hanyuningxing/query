package com.miracle.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.miracle.common.Constant;
import com.miracle.model.IdEntity;

/**
 * 比赛投注信息
 * 
 */
@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "Grep_MATCH_INFO")
public class GrepMatchInfo extends IdEntity {
	private static final long serialVersionUID = -6038223448159787776L;
	
	/** 比赛场次id */
	private String matchId;
	/** 创建时间 */
	private Date createTime;
	/** 最后更新时间 */
	private Date lastModifyTime;
	/** 胜次数 */
	private Integer spf3=0;
	/** 平次数 */
	private Integer spf1=0;
	/** 负次数 */
	private Integer spf0=0;
	/** 让胜次数 */
	private Integer rspf3=0;
	/** 让平次数 */
	private Integer rspf1=0;
	/** 让负次数 */
	private Integer rspf0=0;
	
	/** 非同一人选胜次数 */
	private Integer ospf3=0;
	/** 平次数 */
	private Integer ospf1=0;
	/** 负次数 */
	private Integer ospf0=0;
	/** 让胜次数 */
	private Integer orspf3=0;
	/** 让平次数 */
	private Integer orspf1=0;
	/** 让负次数 */
	private Integer orspf0=0;
	
	/** 让球 */
	private Integer lose=0;
	/** 主队比分 */
	private Integer homeScore;
	/** 客队比分 */
	private Integer guestScore;
	
	/** 最大值是否中标 */
	private boolean flag;
	
	/** 非同一人是否中标 */
	private boolean oflag;
	
	

	@Column
	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	@Column
	public Integer getSpf3() {
		return spf3;
	}

	public void setSpf3(Integer spf3) {
		this.spf3 = spf3;
	}
	@Column
	public Integer getSpf1() {
		return spf1;
	}

	public void setSpf1(Integer spf1) {
		this.spf1 = spf1;
	}
	@Column
	public Integer getSpf0() {
		return spf0;
	}

	public void setSpf0(Integer spf0) {
		this.spf0 = spf0;
	}
	@Column
	public Integer getRspf3() {
		return rspf3;
	}

	public void setRspf3(Integer rspf3) {
		this.rspf3 = rspf3;
	}
	@Column
	public Integer getRspf1() {
		return rspf1;
	}

	public void setRspf1(Integer rspf1) {
		this.rspf1 = rspf1;
	}
	@Column
	public Integer getRspf0() {
		return rspf0;
	}

	public void setRspf0(Integer rspf0) {
		this.rspf0 = rspf0;
	}
	@Column
	public Integer getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}
	@Column
	public Integer getGuestScore() {
		return guestScore;
	}

	public void setGuestScore(Integer guestScore) {
		this.guestScore = guestScore;
	}
	@Column
	public Integer getLose() {
		return lose;
	}

	public void setLose(Integer lose) {
		this.lose = lose;
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
	@Column
	public Integer getOspf3() {
		return ospf3;
	}

	public void setOspf3(Integer ospf3) {
		this.ospf3 = ospf3;
	}
	@Column
	public Integer getOspf1() {
		return ospf1;
	}

	public void setOspf1(Integer ospf1) {
		this.ospf1 = ospf1;
	}
	@Column
	public Integer getOspf0() {
		return ospf0;
	}

	public void setOspf0(Integer ospf0) {
		this.ospf0 = ospf0;
	}
	@Column
	public Integer getOrspf3() {
		return orspf3;
	}

	public void setOrspf3(Integer orspf3) {
		this.orspf3 = orspf3;
	}
	@Column
	public Integer getOrspf1() {
		return orspf1;
	}

	public void setOrspf1(Integer orspf1) {
		this.orspf1 = orspf1;
	}
	@Column
	public Integer getOrspf0() {
		return orspf0;
	}

	public void setOrspf0(Integer orspf0) {
		this.orspf0 = orspf0;
	}
	@Column(columnDefinition = "bit(1) default 0")
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Column(columnDefinition = "bit(1) default 0")
	public boolean isOflag() {
		return oflag;
	}

	public void setOflag(boolean oflag) {
		this.oflag = oflag;
	}

	@Transient
	public List<String> getMaxValue(){
		List<String> maxList = new ArrayList<String>();
		maxList.addAll(getSPFMaxValue());
		maxList.addAll(getRSPFMaxValue());
		return maxList;
	}
	@Transient
	public List<String> getSPFMaxValue(){
		int[] data = {spf3,spf1,spf0};
		String[] value = {"SPF=3","SPF=1","SPF=0"};
		int maxVal=0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= data.length - 1; i++) {
			if (data[i] > maxVal) {
				list.clear();
				maxVal = data[i];
				list.add(i);
			}else if(data[i] == maxVal&&maxVal!=0){
				list.add(i);
			}
		}
		List<String> maxList = new ArrayList<String>();
		for (Integer num : list) {
			maxList.add(value[num]);
		}
		return maxList;
	}
	@Transient
	public List<String> getRSPFMaxValue(){
		int[] data = {rspf3,rspf1,rspf0};
		String[] value = {"RSPF=3","RSPF=1","RSPF=0"};
		int maxVal=0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= data.length - 1; i++) {
			if (data[i] > maxVal) {
				list.clear();
				maxVal = data[i];
				list.add(i);
			}else if(data[i] == maxVal&&maxVal!=0){
				list.add(i);
			}
		}
		List<String> maxList = new ArrayList<String>();
		for (Integer num : list) {
			maxList.add(value[num]);
		}
		return maxList;
	}
	@Transient
	public List<String> getOMaxValue(){
		List<String> maxList = new ArrayList<String>();
		maxList.addAll(getOSPFMaxValue());
		maxList.addAll(getORSPFMaxValue());
		return maxList;
	}
	@Transient
	public List<String> getOSPFMaxValue(){
		int[] data = {ospf3,ospf1,ospf0};
		String[] value = {"SPF=3","SPF=1","SPF=0"};
		int maxVal=0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= data.length - 1; i++) {
			if (data[i] > maxVal) {
				list.clear();
				maxVal = data[i];
				list.add(i);
			}else if(data[i] == maxVal&&maxVal!=0){
				list.add(i);
			}
		}
		List<String> maxList = new ArrayList<String>();
		for (Integer num : list) {
			maxList.add(value[num]);
		}
		return maxList;
	}
	
	@Transient
	public List<String> getORSPFMaxValue(){
		int[] data = {orspf3,orspf1,orspf0};
		String[] value = {"RSPF=3","RSPF=1","RSPF=0"};
		int maxVal=0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= data.length - 1; i++) {
			if (data[i] > maxVal) {
				list.clear();
				maxVal = data[i];
				list.add(i);
			}else if(data[i] == maxVal&&maxVal!=0){
				list.add(i);
			}
		}
		List<String> maxList = new ArrayList<String>();
		for (Integer num : list) {
			maxList.add(value[num]);
		}
		return maxList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
