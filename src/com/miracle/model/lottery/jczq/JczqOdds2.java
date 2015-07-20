package com.miracle.model.lottery.jczq;

 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
  


@Entity
@Table(name = "jczqOdds2")
public class JczqOdds2  {
		@Id
		private Integer id;
 
		@Column
		private String matchKey;
		@Column
		private String period;
		@Column
		private Integer company;
		@Column
		private String num;
		
		@Column
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

		public Integer getFirstHomeWin() {
			return firstHomeWin;
		}

		public void setFirstHomeWin(Integer firstHomeWin) {
			this.firstHomeWin = firstHomeWin;
		}

		public Integer getFirstStandoff() {
			return firstStandoff;
		}

		public void setFirstStandoff(Integer firstStandoff) {
			this.firstStandoff = firstStandoff;
		}

		public Integer getFirstGuestWin() {
			return firstGuestWin;
		}

		public void setFirstGuestWin(Integer firstGuestWin) {
			this.firstGuestWin = firstGuestWin;
		}

		public Integer getHomeWin() {
			return homeWin;
		}

		public void setHomeWin(Integer homeWin) {
			this.homeWin = homeWin;
		}

		public Integer getStandoff() {
			return standoff;
		}

		public void setStandoff(Integer standoff) {
			this.standoff = standoff;
		}

		public Integer getGuestWin() {
			return guestWin;
		}

		public void setGuestWin(Integer guestWin) {
			this.guestWin = guestWin;
		}

		public Integer getAsiaHomeWin() {
			return asiaHomeWin;
		}

		public void setAsiaHomeWin(Integer asiaHomeWin) {
			this.asiaHomeWin = asiaHomeWin;
		}

		public Integer getAsiaStandOff() {
			return asiaStandOff;
		}

		public void setAsiaStandOff(Integer asiaStandOff) {
			this.asiaStandOff = asiaStandOff;
		}

		public Integer getAsiaGuestWin() {
			return asiaGuestWin;
		}

		public void setAsiaGuestWin(Integer asiaGuestWin) {
			this.asiaGuestWin = asiaGuestWin;
		}

		public Integer getFirstAsiaHomeWin() {
			return firstAsiaHomeWin;
		}

		public void setFirstAsiaHomeWin(Integer firstAsiaHomeWin) {
			this.firstAsiaHomeWin = firstAsiaHomeWin;
		}

		public Integer getFirstAsiaStandOff() {
			return firstAsiaStandOff;
		}

		public void setFirstAsiaStandOff(Integer firstAsiaStandOff) {
			this.firstAsiaStandOff = firstAsiaStandOff;
		}

		public Integer getFirstAsiaGuestWin() {
			return firstAsiaGuestWin;
		}

		public void setFirstAsiaGuestWin(Integer firstAsiaGuestWin) {
			this.firstAsiaGuestWin = firstAsiaGuestWin;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

 
	
	
}
