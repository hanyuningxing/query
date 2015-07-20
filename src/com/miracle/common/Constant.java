package com.miracle.common;

import java.sql.Types;

public final class Constant {
	/** 系统路径,监听器设值 **/
	public static String ROOTPATH = "";
	/** 服务器路径,监听器设值 **/
	public static String BASEPATH = "";
	public static final String ENCODING = "UTF-8";

	/**hibernate cache Key*/
	public static String DEMO_CACHE = "DEMO_CACHE";

	public static final String LOGIN_CAPTCHA = "LOGIN_CAPTCHA";

	/** 彩票系统数据表名称前缀 */
	public static final String LOTTERY_TABLE_PREFIX = "LOTTERY_";
	

	/** 用于生成主键的数据表的名称 */
	public static final String GENERATOR_TABLE = LOTTERY_TABLE_PREFIX+"ID_GENERATOR";

	public static final String USER_CONTEXT = "userContext";

	/** 默认的枚举类型的SQL Type */
	public static final String ENUM_DEFAULT_SQL_TYPE = "" + Types.TINYINT;

	public static final String LOGIN_TO_URL = "loginToUrl";
	
	public static final String DEFAULT_ENCODE = "UTF-8";

	public static int QUERY_MAXRESULTS = 50;//查询返回的最大记录数
	
	public static int ODDS_MULTIPLE = 1000;
	
}
