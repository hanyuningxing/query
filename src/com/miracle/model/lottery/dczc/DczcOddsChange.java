package com.miracle.model.lottery.dczc;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.OddsPankou;
import com.miracle.model.IdEntity;

@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "DCZC_ODDS_CHANGE")
public class DczcOddsChange  extends IdEntity{
 
	private static final NumberFormat TWO_NF = new DecimalFormat("0.00");
	@Column
	private String matchKey;
	@Column
	private String period;
	@Column
	private Integer company;
	@Column
	private String num;
	@Column
	private Integer  homeWin;
	@Column
	private Integer standoff;
	@Column
	private Integer guestWin;
	/**
	 * YA PEI
	 */
	@Column
	private Integer asiaHomeWin;
	@Column
	private Integer asiaStandOff;
	@Column
	private Integer asiaGuestWin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date changeTime;

	public String getMatchKey() {
		return matchKey;
	}
	public void setMatchKey(String matchKey) {
		this.matchKey = matchKey;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Integer getCompany() {
		return company;
	}
	public void setCompany(Integer company) {
		this.company = company;
	}
	 

 
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
 
	public Date getChangeTime() {
		return changeTime;
	}
	
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
 
	@JsonIgnore
	public Integer getHomeWin() {
		return homeWin;
	}
	@Transient
	public String getHomeWinStr() {
		if(homeWin==null)return null;
		return  TWO_NF.format(Float.valueOf(homeWin)/Constant.ODDS_MULTIPLE);
 
	}
	public void setHomeWin(Integer homeWin) {
		this.homeWin = homeWin;
	}
	@JsonIgnore
	public Integer getStandoff() {
		return standoff;
	}
	@Transient
	public String getStandoffStr() {
		if(standoff==null)return null;
		return  TWO_NF.format(Float.valueOf(standoff)/Constant.ODDS_MULTIPLE);
 
	}
	public void setStandoff(Integer standoff) {
		this.standoff = standoff;
	}
	@JsonIgnore
	public Integer getGuestWin() {
		return guestWin;
	}
	@Transient
	public String getGuestWinStr(){
		if(guestWin==null)return null;
		return  TWO_NF.format(Float.valueOf(guestWin)/Constant.ODDS_MULTIPLE);
	 
	}
	public void setGuestWin(Integer guestWin) {
		this.guestWin = guestWin;
	}
	@JsonIgnore
	public Integer getAsiaHomeWin() {
		return asiaHomeWin;
	}
	@Transient
	public String getAsiaHomeWinStr() {
		if(asiaHomeWin==null)return null;
		return  TWO_NF.format(Float.valueOf(asiaHomeWin)/Constant.ODDS_MULTIPLE);
 
	}
	public void setAsiaHomeWin(Integer asiaHomeWin) {
		this.asiaHomeWin = asiaHomeWin;
	}
	@JsonIgnore
	public Integer getAsiaStandOff() {
		return asiaStandOff;
	}
	@Transient
	public String getAsiaStandOffStr() {
		if(asiaStandOff==null)return null;
		double value =  Double.valueOf(TWO_NF.format(Float.valueOf(asiaStandOff)/Constant.ODDS_MULTIPLE));
		return OddsPankou.getOkoooName(value);
	}
	@Transient
	public String getAsiaStandOffValue() {
		if(asiaStandOff==null)return null;
		return TWO_NF.format(Float.valueOf(asiaStandOff)/Constant.ODDS_MULTIPLE);
	}
	public void setAsiaStandOff(Integer asiaStandOff) {
		this.asiaStandOff = asiaStandOff;
	}
	@JsonIgnore
	public Integer getAsiaGuestWin() {
		return asiaGuestWin;
	}
	@Transient
	public String getAsiaGuestWinStr() {
		if(asiaGuestWin==null)return null;
		return  TWO_NF.format(Float.valueOf(asiaGuestWin)/Constant.ODDS_MULTIPLE);
		 
	}
	public void setAsiaGuestWin(Integer asiaGuestWin) {
		this.asiaGuestWin = asiaGuestWin;
	}
	
}
