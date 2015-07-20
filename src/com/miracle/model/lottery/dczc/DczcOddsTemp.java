package com.miracle.model.lottery.dczc;





public class DczcOddsTemp {
	
		private String matchKey;
		
		private String period;
	
		private Integer company;
	
		private String num;

	
		private String  homeWin;
	
		private String standoff;
	
		private String guestWin;
		/**
		 * YA PEI
		 */

		private String asiaHomeWin;
	
		private String asiaStandOff;

		private String asiaGuestWin;

 
	 
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((asiaGuestWin == null) ? 0 : asiaGuestWin.hashCode());
			result = prime * result
					+ ((asiaHomeWin == null) ? 0 : asiaHomeWin.hashCode());
			result = prime * result
					+ ((asiaStandOff == null) ? 0 : asiaStandOff.hashCode());
			result = prime * result + ((company == null) ? 0 : company.hashCode());
			result = prime * result
					+ ((guestWin == null) ? 0 : guestWin.hashCode());
			result = prime * result + ((homeWin == null) ? 0 : homeWin.hashCode());
			result = prime * result
					+ ((matchKey == null) ? 0 : matchKey.hashCode());
			result = prime * result + ((period == null) ? 0 : period.hashCode());
			result = prime * result
					+ ((standoff == null) ? 0 : standoff.hashCode());
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
			DczcOddsTemp other = (DczcOddsTemp) obj;
			if (asiaGuestWin == null) {
				if (other.asiaGuestWin != null)
					return false;
			} else if (!asiaGuestWin.equals(other.asiaGuestWin))
				return false;
			if (asiaHomeWin == null) {
				if (other.asiaHomeWin != null)
					return false;
			} else if (!asiaHomeWin.equals(other.asiaHomeWin))
				return false;
			if (asiaStandOff == null) {
				if (other.asiaStandOff != null)
					return false;
			} else if (!asiaStandOff.equals(other.asiaStandOff))
				return false;
		 
			if (guestWin == null) {
				if (other.guestWin != null)
					return false;
			} else if (!guestWin.equals(other.guestWin))
				return false;
			if (homeWin == null) {
				if (other.homeWin != null)
					return false;
			} else if (!homeWin.equals(other.homeWin))
				return false;
			 
			if (matchKey == null) {
				if (other.matchKey != null)
					return false;
			} else if (!matchKey.equals(other.matchKey))
				return false;
			if (period == null) {
				if (other.period != null)
					return false;
			} else if (!period.equals(other.period))
				return false;
			if (standoff == null) {
				if (other.standoff != null)
					return false;
			} else if (!standoff.equals(other.standoff))
				return false;
			return true;
		}
		public String getHomeWin() {
			return homeWin;
		}
		public void setHomeWin(String homeWin) {
			this.homeWin = homeWin;
		}
		public String getStandoff() {
			return standoff;
		}
		public void setStandoff(String standoff) {
			this.standoff = standoff;
		}
		public String getGuestWin() {
			return guestWin;
		}
		public void setGuestWin(String guestWin) {
			this.guestWin = guestWin;
		}
		public String getAsiaHomeWin() {
			return asiaHomeWin;
		}
		public void setAsiaHomeWin(String asiaHomeWin) {
			this.asiaHomeWin = asiaHomeWin;
		}
		public String getAsiaStandOff() {
			return asiaStandOff;
		}
		public void setAsiaStandOff(String asiaStandOff) {
			this.asiaStandOff = asiaStandOff;
		}
		public String getAsiaGuestWin() {
			return asiaGuestWin;
		}
		public void setAsiaGuestWin(String asiaGuestWin) {
			this.asiaGuestWin = asiaGuestWin;
		}
		
		
		
}
