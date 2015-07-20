package com.miracle.model.lottery.jczq;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.type.EnumType;

import com.miracle.common.Constant;
import com.miracle.lotteryutils.Lottery;
import com.miracle.lotteryutils.OddsPankou;
import com.miracle.model.IdEntity;
import com.miracle.model.lottery.dczc.DczcOdds;


@Entity
@Table(name = Constant.LOTTERY_TABLE_PREFIX + "JCZQ_ODDS")
public class JczqOdds extends IdEntity{
 
 
	private static final NumberFormat TWO_NF = new DecimalFormat("0.00");
	private Lottery lotteryType;
		@Column
		private String matchKey;
		@Column
		private String period;
		@Column
		private Integer company;
		@Column
		private String num;
		
		@Temporal(TemporalType.TIMESTAMP)
		@Column(nullable = false, updatable = false)
		private Date changeTime;
		
		
		/**
		 * 欧赔
		 */
		
		@Column
		private Integer  firstHomeWin;
		@Column
		private Integer firstStandoff;
		@Column
		private Integer firstGuestWin;
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
	 
		@Column
		private Integer firstAsiaHomeWin;
		@Column
		private Integer firstAsiaStandOff;
		@Column
		private Integer firstAsiaGuestWin;
		
		
		
		@Type(type="org.hibernate.type.EnumType",parameters={@Parameter(name=EnumType.ENUM,value="com.miracle.lotteryutils.Lottery"),@Parameter(name=EnumType.TYPE,value=Lottery.SQL_TYPE)})
		@Column(nullable = false, updatable = true)
		@JsonIgnore
		public Lottery getLotteryType() {
			return lotteryType;
		}
		public void setLotteryType(Lottery lotteryType) {
			this.lotteryType = lotteryType;
		}
		@JsonIgnore
		public String getMatchKey() {
			return matchKey;
		}
		@Transient
		public Integer getK(){
			return Integer.valueOf(matchKey);
		}
		
		public void setMatchKey(String matchKey) {
			this.matchKey = matchKey;
		}
		@JsonIgnore
		public String getPeriod() {
			return period;
		}
		@Transient
		public String getP(){
			return period;
		}
		
		public void setPeriod(String period) {
			this.period = period;
		}
		@JsonIgnore
		public Integer getCompany() {
			return company;
		}
		@Transient
		public Integer getC(){
			return company;
		}
		public void setCompany(Integer company) {
			this.company = company;
		}
		@JsonIgnore
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
	
		@JsonIgnore
		public Integer getFirstHomeWin() {
			return firstHomeWin;
		}
 
		@Transient
		public String getU(){
			if(firstHomeWin==null){
				return null;
			}else{return  TWO_NF.format(Float.valueOf(firstHomeWin)/Constant.ODDS_MULTIPLE);}		
		}
		@Transient
		public String getV(){
			if(firstStandoff==null){
				return null;
			}else{return   TWO_NF.format(Float.valueOf(firstStandoff)/Constant.ODDS_MULTIPLE);}		
		}
		@Transient
		public String getW(){
			if(firstGuestWin==null){
				return null;
			}else{return   TWO_NF.format(Float.valueOf(firstGuestWin)/Constant.ODDS_MULTIPLE);}		
		}
 
		@Transient
		public String getX(){
			if(firstAsiaHomeWin==null){
				return null;
			}else{return  TWO_NF.format(Float.valueOf(firstAsiaHomeWin)/Constant.ODDS_MULTIPLE);}		
		}
		@Transient
		public String getY(){
			if(firstAsiaStandOff==null){
				return null;
			}else{
				double value =  Double.valueOf(TWO_NF.format(Float.valueOf(firstAsiaStandOff)/Constant.ODDS_MULTIPLE));
				return OddsPankou.getOkoooName(value);
			}		
		}
		@Transient
		public String getZ(){
			if(firstAsiaGuestWin==null){
				return null;
			}else{return  TWO_NF.format(Float.valueOf(firstAsiaGuestWin)/Constant.ODDS_MULTIPLE);}		
		}
		@Transient
		public String getH(){
			if(homeWin==null){
				return null;
			}else{
				return  TWO_NF.format(Float.valueOf(homeWin)/Constant.ODDS_MULTIPLE);
			}		
		}
		@Transient
		public String getS(){
			if(standoff==null){
				return null;
			}else{
				return  TWO_NF.format(Float.valueOf(standoff)/Constant.ODDS_MULTIPLE);
			}		
		}
		@Transient
		public String getG(){
			if(guestWin==null){
				return null;
			}else{return   TWO_NF.format(Float.valueOf(guestWin)/Constant.ODDS_MULTIPLE);}		
		}
		@Transient
		public String getL(){
			if(asiaHomeWin==null){
				return null;
			}else{return  TWO_NF.format(Float.valueOf(asiaHomeWin)/Constant.ODDS_MULTIPLE);}		
		}
		@Transient
		public String getM(){
			if(asiaStandOff==null){
				return null;
			}else{
				double value =  Double.valueOf(TWO_NF.format(Float.valueOf(asiaStandOff)/Constant.ODDS_MULTIPLE));
				return OddsPankou.getOkoooName(value);
			}		
		}
		@Transient
		public String getN(){
			if(asiaGuestWin==null){
				return null;
			}else{return   TWO_NF.format(Float.valueOf(asiaGuestWin)/Constant.ODDS_MULTIPLE);}		
		}		
		public void setFirstHomeWin(Integer firstHomeWin) {
			this.firstHomeWin = firstHomeWin;
		}
		@JsonIgnore
		public Integer getFirstStandoff() {
			return firstStandoff;
		}
		public void setFirstStandoff(Integer firstStandoff) {
			this.firstStandoff = firstStandoff;
		}
		@JsonIgnore
		public Integer getFirstGuestWin() {
			return firstGuestWin;
		}
		public void setFirstGuestWin(Integer firstGuestWin) {
			this.firstGuestWin = firstGuestWin;
		}
		@JsonIgnore
		public Integer getFirstAsiaHomeWin() {
			return firstAsiaHomeWin;
		}
		public void setFirstAsiaHomeWin(Integer firstAsiaHomeWin) {
			this.firstAsiaHomeWin = firstAsiaHomeWin;
		}
		@JsonIgnore
		public Integer getFirstAsiaStandOff() {
			return firstAsiaStandOff;
		}
		public void setFirstAsiaStandOff(Integer firstAsiaStandOff) {
			this.firstAsiaStandOff = firstAsiaStandOff;
		}
		@JsonIgnore
		public Integer getFirstAsiaGuestWin() {
			return firstAsiaGuestWin;
		}
		public void setFirstAsiaGuestWin(Integer firstAsiaGuestWin) {
			this.firstAsiaGuestWin = firstAsiaGuestWin;
		}
		@JsonIgnore
		public Integer getHomeWin() {
			return homeWin;
		}
		public void setHomeWin(Integer homeWin) {
			this.homeWin = homeWin;
		}
		@JsonIgnore
		public Integer getStandoff() {
			return standoff;
		}
		public void setStandoff(Integer standoff) {
			this.standoff = standoff;
		}
		@JsonIgnore
		public Integer getGuestWin() {
			return guestWin;
		}
		public void setGuestWin(Integer guestWin) {
			this.guestWin = guestWin;
		}
		@JsonIgnore
		public Integer getAsiaHomeWin() {
			return asiaHomeWin;
		}
		public void setAsiaHomeWin(Integer asiaHomeWin) {
			this.asiaHomeWin = asiaHomeWin;
		}
		@JsonIgnore
		public Integer getAsiaStandOff() {
			return asiaStandOff;
		}
		public void setAsiaStandOff(Integer asiaStandOff) {
			this.asiaStandOff = asiaStandOff;
		}
		@JsonIgnore
		public Integer getAsiaGuestWin() {
			return asiaGuestWin;
		}
		public void setAsiaGuestWin(Integer asiaGuestWin) {
			this.asiaGuestWin = asiaGuestWin;
		}
		@JsonIgnore
		public Date getChangeTime() {
			return changeTime;
		}
		@Transient
		public Date getT() {
			return changeTime;
		}
		public void setChangeTime(Date changeTime) {
			this.changeTime = changeTime;
		}
		
		public static String toOddsArray(List<JczqOdds> oddsList){
			StringBuilder sb=new StringBuilder();
			sb.append("[");
			String str="";
			for(JczqOdds o:oddsList){		 
				sb.append("["+o.getPeriod()+","+o.getK()+","+o.getCompany()+","+o.getT().getTime()+",");

				if(o.getU()==null){
					sb.append(",");
				}else{
					sb.append(o.getU()+",");
				}
				if(o.getV()==null){
					sb.append(",");
				}else{
					sb.append(o.getV()+",");
				}
				if(o.getW()==null){
					sb.append(",");
				}else{
					sb.append(o.getW()+",");
				}
				if(o.getX()==null){
					sb.append(",");
				}else{
					sb.append(o.getX()+",");
				}	
				if(o.getFirstAsiaStandOff()==null){
					sb.append(",");
				}else{
					sb.append(o.getFirstAsiaStandOff()+",");
				}	
				if(o.getZ()==null){
					sb.append(",");
				}else{
					sb.append(o.getZ()+",");
				}
				if(o.getH()==null){
					sb.append(",");
				}else{
					sb.append(o.getH()+",");
				}	
				if(o.getS()==null){
					sb.append(",");
				}else{
					sb.append(o.getS()+",");
				}	
				if(o.getG()==null){
					sb.append(",");
				}else{
					sb.append(o.getG()+",");
				}
				if(o.getL()==null){
					sb.append(",");
				}else{
					sb.append(o.getL()+",");
				}	
				if(o.getAsiaStandOff()==null){
					sb.append(",");
				}else{
					sb.append(o.getAsiaStandOff()+",");
				}	
				if(o.getN()!=null){
					sb.append(o.getN());
				}	
				sb.append("],");
				//str+="["+o.getPeriod()+","+o.getMatchKey()+","+o.getCompany()+","+o.getT().getTime()+","+o.getU()+","+o.getV()+","+o.getW()+","+o.getX()+","+o.getFirstAsiaStandOff()+","+o.getZ()+","+o.getH()+","+o.getS()+","+o.getG()+","+o.getL()+","+o.getAsiaStandOff()+","+o.getN()+"],";
			}
			 str= sb.toString();
			 sb=null;
			if(str.endsWith(",")){str = str.substring(0, str.length()-1);}
			str=str+"]";
			return str;
	}

	
	
}
