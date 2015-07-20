package com.miracle.common;


/**
 * 资金明细类型.<br/>
 * 注：添加类型只能在后面添加，不能插入中间
 * 
 */
public enum FundDetailType {
	/** 认购 */
	SUBSCRIPTION("认购","1"),  //0

	/** 撤销认购 */
	CANCEL_SUBSCRIPTION("撤销认购","1"), //1

	/** 保底 */
	BAODI("保底","1"), //2

	/** 撤销保底 */
	CANCEL_BAODI("撤销保底","1"), //3

	/** 方案撤单 */
	CANCEL_SCHEME("方案撤单","1"),  //4

	/** 方案退款 */
	REFUNDMENT_SCHEME("方案退款","1"),//5

	/** 方案佣金 */
	SCHEME_COMMISSION("方案佣金","1"),//6

	/** 奖金分红 */
	SCHEME_BONUS("奖金分红","3"),//7

	/** 管理员手动调整额度 */
	ADMIN_OPR("手动调整额度","8"),

	/** 追号 */
	CHASE("追号","1"),

	/** 用户提款 */
	DRAWING("用户提款","2"),

	/** 停止追号 */
	STOP_CHASE("停止追号","1"),

	/** 提款失败返还资金 */
	DRAWINGFAIL("提款失败返还资金","2"),

	/** 在线充值 */
	PAY("在线充值","4"),
	
	/** 后台通过充值 */
	ADMINPAY("后台通过充值","8"),
	
	/** 赠送彩金 */
	RECHARGEACTIVITY("活动赠送彩金","8"),
	
	/** 代理商操作 */
	AGENTOPR("代理商操作","8"),
	
	/** 佣金 */
	REBATE("佣金","8"),
	
	/** 加奖送彩金 */
	SENDWINNERS("加奖送彩金","8"),
	/**推广返点**/
	AGENT("推广返点","8");
	
	/** 类型名称 */
	private final String typeName;
	
	/** 类目类型名称 */
	private final String superTypeName;

	/**
	 * @param typeName {@link #typeName}
	 */
	
	private FundDetailType(String typeName,String superTypeName) {
		this.typeName = typeName;
		this.superTypeName = superTypeName;
	}
	/**
	 * @return {@link #typeName}
	 */
	public String getTypeName() {
		return typeName;
	}

	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	public String getSuperTypeName() {
		return superTypeName;
	}
}
