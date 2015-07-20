package com.miracle.lotteryutils.welfare3d;

import java.util.List;

import com.miracle.common.Constant;
import com.miracle.common.Welfare3dConstant;
import com.miracle.lotteryutils.Item;
import com.miracle.lotteryutils.PlayTypeItem;

/**
 * 投注方式.<br/>
 * 注：添加类型只能在后面添加，不能插入中间
 * 
 */
public enum Welfare3dPlayType   implements PlayTypeItem{
	/** 直选 */
	Direct("直选",Boolean.TRUE,Boolean.TRUE,null,"定位复式，每个位数用符号-隔开。例如：01,02,03-01,02,03-01","彩球（3）例如：01,02,03",null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			if (area1List.contains(num1) && area2List.contains(num2) && area3List.contains(num3)) {
				welfare3dWinUnit.addWinUnits(multiple);
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> group3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}

	},
	/** 组三 */
	Group3("组三",Boolean.TRUE,Boolean.TRUE,null,"彩球（大于2）例如：01,02,03","彩球（3）例如：01,01,03",null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> group3List, int multiple) {
			// //组选3
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			if (num1.equals(num2) && num2.equals(num3)) {
				// /三个数相同不中奖
				return welfare3dWinUnit;
			} else if (!num1.equals(num2) && !num2.equals(num3) && !num1.equals(num3)) {
				// /三个不相同不中奖
				return welfare3dWinUnit;
			}
			if (group3List.contains(num1) && group3List.contains(num2) && group3List.contains(num3)) {
				welfare3dWinUnit.addG3WinUnits(multiple);
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	},
	/** 组六 */
	Group6("组六",Boolean.TRUE,Boolean.TRUE,null,"彩球（大于3）范围 0-9。例如：01,02,03,04","彩球（3）范围 0-9 例如：01,02,03",null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> group6List, int multiple) {
			// //组选6
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			// //组选6
			if (num1.equals(num2) || num2.equals(num3) || num1.equals(num3)) {
				// /三个有两个是一样的不中奖
				return welfare3dWinUnit;
			}
			if (group6List.contains(num1) && group6List.contains(num2) && group6List.contains(num3)) {
				welfare3dWinUnit.addG6WinUnits(multiple);
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			return null;
		}
	},
	/** 直选和值 */
	DirectSum("直选和值",Boolean.FALSE,Boolean.FALSE,null,"彩球（大于1） 范围：1-27",null,null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> directSumList, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Integer sum = num1 + num2 + num3;
			if (directSumList.contains(sum)) {
				for (int i = 0; i < Welfare3dConstant.UNITS_DIRECT_SUM.length; i++) {
					if (sum == i) {
						welfare3dWinUnit.addWinUnits(multiple);
					}
				}
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	},
	/** 组选和值 */
	GroupSum("组选和值",Boolean.TRUE,Boolean.FALSE,null,"彩球（大于3）。范围：1-26",null,null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> groupSumList, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Integer sum = num1 + num2 + num3;
			if (groupSumList.contains(sum)) {
				for (int i = 0; i < Welfare3dConstant.UNITS_GROUP_SUM.length; i++) {
					if (sum == i) {
						if (!num1.equals(num2) && !num2.equals(num3) && !num1.equals(num3)) {
							// /三个不相同组六
								welfare3dWinUnit.addG6WinUnits( multiple);
						} else {
							// /三个不相同组3
							welfare3dWinUnit.addG3WinUnits( multiple);
						}
					}
				}
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	},
	/** 包串 */
	BaoChuan("包串",Boolean.FALSE,Boolean.FALSE,null,"彩球（大于3）范围 0-9。例如：01,02,03,04",null,null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> baoChuanList, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			if (baoChuanList.contains(num1)&&baoChuanList.contains(num2)&&baoChuanList.contains(num3)) {
			       //中奖，中一注直选
				  welfare3dWinUnit.addWinUnits(multiple);
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, List<Integer> area4List, List<Integer> area5List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	},
	/** 直选跨度  */
	DirectKuadu("直选跨度",Boolean.TRUE,Boolean.FALSE,null,"彩球（大于1）范围 0-9。例如：01",null,null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer>  kuaduList, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Integer bigTemp = Math.max(num1, num2);//算出最大的
			Integer bigNum = Math.max(bigTemp, num3);//算出最大的
			Integer smallTemp = Math.min(num1, num2);//算出最小的
			Integer smallNum = Math.min(smallTemp, num3);//算出最小的
			Integer kuadu = bigNum - smallNum ;
			if (kuaduList.contains(kuadu)) {
			      //中奖，中一注直选
				  welfare3dWinUnit.addWinUnits(multiple);
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, List<Integer> area4List, List<Integer> area5List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	},
	/** 组选3跨度  */
	Group3Kuadu("组选3跨度",Boolean.TRUE,Boolean.FALSE,null,"彩球（大于1）范围 1-9。例如：01",null,null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer>  kuaduList, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Integer bigTemp = Math.max(num1, num2);//算出最大的
			Integer bigNum = Math.max(bigTemp, num3);//算出最大的
			Integer smallTemp = Math.min(num1, num2);//算出最小的
			Integer smallNum = Math.min(smallTemp, num3);//算出最小的
			Integer kuadu = bigNum - smallNum ;
			if (kuaduList.contains(kuadu)) {
			      //中奖，中一注组选3
				   if (!num1.equals(num2) && !num2.equals(num3) && !num1.equals(num3)) {
						// /三个不相同组六
				   } else if(num1.equals(num2) && num2.equals(num3) && num1.equals(num3)){
						// /豹子不中组三组六
				   } else {
						// /三个不相同组3
						welfare3dWinUnit.addG3WinUnits(multiple);
				   }
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, List<Integer> area4List, List<Integer> area5List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	},
	/** 组选6跨度  */
	Group6Kuadu("组选6跨度",Boolean.TRUE,Boolean.FALSE,null,"彩球（大于1）范围 2-9。例如：02",null,null) {
		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer>  kuaduList, int multiple) {
			Welfare3dWinUnit welfare3dWinUnit = new Welfare3dWinUnit();
			Integer num1 = results.get(0);
			Integer num2 = results.get(1);
			Integer num3 = results.get(2);
			Integer bigTemp = Math.max(num1, num2);//算出最大的
			Integer bigNum = Math.max(bigTemp, num3);//算出最大的
			Integer smallTemp = Math.min(num1, num2);//算出最小的
			Integer smallNum = Math.min(smallTemp, num3);//算出最小的
			Integer kuadu = bigNum - smallNum ;
			if (kuaduList.contains(kuadu)) {
			      //中奖，中一注组选6
				   if (!num1.equals(num2) && !num2.equals(num3) && !num1.equals(num3)) {
						// /三个不相同组六
						  welfare3dWinUnit.addG6WinUnits(multiple);
				   } else if(num1.equals(num2) && num2.equals(num3) && num1.equals(num3)){
						// /豹子不中组三组六
				   } else {
						// /三个不相同组3
				   }
			}
			return welfare3dWinUnit;
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, List<Integer> area4List, List<Integer> area5List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}

		public Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> area1List, List<Integer> area2List,
				List<Integer> area3List, int multiple) {
			throw new RuntimeException("此方法对本玩法不适用！");
		}
	};
	/** 类型名称 */
	private final String typeName;
	private final Boolean singleSupport;//支持单式
	private final Boolean compoundSupport;//支持复式
	private final Boolean danSupport;//支持胆拖

	private final String compoundValue;//复式
	
	private final String singleValue;//单式
	
	private final String danValue;
	/**
	 * @param typeName {@link #typeName}
	 */
	private Welfare3dPlayType(String typeName,Boolean compoundSupport, Boolean singleSupport,Boolean danSupport,String compoundValue,String singleValue,String danValue) {
		this.typeName = typeName;
		this.singleSupport = singleSupport;
		this.compoundSupport = compoundSupport;
		this.danSupport = danSupport;
		
		this.singleValue = singleValue;
		this.compoundValue = compoundValue;
		this.danValue = danValue;
	}
	
	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	/**
	 * @return {@link #typeName}
	 */
	public String getTypeName() {
		return typeName;
	}

	@Override
	public String getText() {
		return this.typeName;
	}

	@Override
	public Integer getMaxItemSize() {
		return null;
	}

	@Override
	public Item[] getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getValue() {
		return  this.ordinal();
	}
	public abstract Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> bets, int multiple);

	public abstract Welfare3dWinUnit calcWinUnit(List<Integer> results, List<Integer> bet1, List<Integer> bet2,
			List<Integer> bet3, int multiple);
	
	public Boolean getSingleSupport() {
		return singleSupport;
	}

	public Boolean getCompoundSupport() {
		return compoundSupport;
	}

	public String getCompoundValue() {
		return compoundValue;
	}

	public String getSingleValue() {
		return singleValue;
	}

	public Boolean getDanSupport() {
		return danSupport;
	}

	public String getDanValue() {
		return danValue;
	}
	
	
	
}
	