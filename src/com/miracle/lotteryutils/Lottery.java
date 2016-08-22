package com.miracle.lotteryutils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.testng.collections.Lists;

import com.miracle.common.Constant;
import com.miracle.common.DczcConstant;
import com.miracle.common.DltConstant;
import com.miracle.common.El11to5Constant;
import com.miracle.common.GdEl11to5Constant;
import com.miracle.common.JclqConstant;
import com.miracle.common.JczqConstant;
import com.miracle.common.KlpkConstant;
import com.miracle.common.KlsfConstant;
import com.miracle.common.LczcConstant;
import com.miracle.common.LotteryCategory;
import com.miracle.common.PlConstant;
import com.miracle.common.QyhConstant;
import com.miracle.common.SczcConstant;
import com.miracle.common.SdEl11to5Constant;
import com.miracle.common.SevenConstant;
import com.miracle.common.SevenstarConstant;
import com.miracle.common.SfzcConstant;
import com.miracle.common.SscConstant;
import com.miracle.common.SslConstant;
import com.miracle.common.SsqConstant;
import com.miracle.common.Tc22to5Constant;
import com.miracle.common.Welfare36to7Constant;
import com.miracle.common.Welfare3dConstant;
import com.miracle.lotteryutils.dczc.DczcPassType;
import com.miracle.lotteryutils.dczc.DczcPlayType;
import com.miracle.lotteryutils.dczc.DczcSchemeType;
import com.miracle.lotteryutils.dlt.DltPlayType;
import com.miracle.lotteryutils.el11to5.El11to5PlayType;
import com.miracle.lotteryutils.jczq.JczqPlayType;
import com.miracle.lotteryutils.jczq.JczqPassType;
import com.miracle.lotteryutils.jczq.JczqSchemeType;

import com.miracle.lotteryutils.jclq.JclqPlayType;
import com.miracle.lotteryutils.jclq.JclqPassType;
import com.miracle.lotteryutils.jclq.JclqSchemeType;
import com.miracle.lotteryutils.lczc.LczcPlayType;
import com.miracle.lotteryutils.pl.PlPlayType;
import com.miracle.lotteryutils.sczc.SczcPlayType;
import com.miracle.lotteryutils.sde11to5.Sdel11to5PlayType;
import com.miracle.lotteryutils.seven.SevenPlayType;
import com.miracle.lotteryutils.sevenstar.SevenStarPlayType;
import com.miracle.lotteryutils.sfzc.SfzcPlayType;
import com.miracle.lotteryutils.ssc.SscPlayType;
import com.miracle.lotteryutils.ssq.SsqPlayType;
import com.miracle.lotteryutils.tc22to5.Tc22to5PlayType;
import com.miracle.lotteryutils.welfare3d.Welfare3dPlayType;
import com.miracle.lotteryutils.klpk.KlpkPlayType;
/**
 * 彩票类型.<br/>
 * 注：添加类型只能在后面添加，不能插入中间
 * 
 */
public enum Lottery {
	/*
	 * ----------------------- 彩票类型----------------------- 加彩票类型的时候，一定要往后面加
	 * 。不能中间插队
	 */
	/** 双色球 */
	SSQ(SsqConstant.KEY, "双色球", "SSQ", LotteryCategory.NUMBER,SsqPlayType.values(),null,null,"l_ssq 复式:01,02,03,04,05,06,07|01,02 单式:01,02,03,04,05,06|01"),//0

	/** 快乐十分 */
	KLSF(KlsfConstant.KEY, "快乐十分", "KLS", LotteryCategory.FREQUENT ,null,null,null,"l_klsf"),//1

	/** 11选5 */
	EL11TO5(El11to5Constant.KEY, "江西11选5", "ELT", LotteryCategory.FREQUENT ,El11to5PlayType.values(),null,null,"01,02"),//2

	/** 时时彩 */
	SSC(SscConstant.KEY, "时时彩", "SSC", LotteryCategory.FREQUENT ,SscPlayType.values(),null,null,"01,02,03"),//3

	/** 时时乐 */
	SSL(SslConstant.KEY, "时时乐", "SSL", LotteryCategory.FREQUENT ,null,null,null,"l_ssl"),//4

	/** 3D */
	WELFARE3D(Welfare3dConstant.KEY, "福彩3D", "WSD", LotteryCategory.NUMBER,Welfare3dPlayType.values(),null,null,"01,02,03-01,02,03-01"),//5

	/** PL */
	PL(PlConstant.KEY, "排列3/5", "TPL", LotteryCategory.NUMBER,PlPlayType.values(),null,null,"01,02,03-01,02,03-01-01-01"),//6
	
	

	/** DCZC */
	DCZC(DczcConstant.KEY, "北京单场", "BDC", LotteryCategory.DCZC,DczcPlayType.values(),DczcPassType.values(),DczcSchemeType.getTicketDczcSchemeTypeItem(),"	{\"items\":[{\"lineId\":\"19\",\"value \":3^1^0},{\"lineId\":\"21\",\"value \":1}]}"),//7

	
	SEVEN(SevenConstant.KEY, "七乐彩", "QLC", LotteryCategory.NUMBER, SevenPlayType.values(),null,null,"01,02,03,04,05,06,07,08,09"),//8

	/** 胜负足彩-- 14场、任选九场（playType） */
	SFZC(SfzcConstant.KEY, "胜负彩", "SZC", LotteryCategory.ZC, SfzcPlayType.values(),null,null,"31,*,10,3,1,1,0,*,1,3,31,*,*,*"),//9

	/** 六场半全场 */
	LCZC(LczcConstant.KEY, "六场半全场", "BCB", LotteryCategory.ZC, LczcPlayType.values(),null,null,"31,2,10,3,1,1,0,0,1,1,0,0"),//10

	/** 四场进球 */
	SCZC(SczcConstant.KEY, "进球彩 ", "JQC", LotteryCategory.ZC, SczcPlayType.values(),null,null,"=31,2,10,3,1,1,0,0"),//11

	/** 36选7 */
	WELFARE36To7(Welfare36to7Constant.KEY, "好彩1", "WFC", LotteryCategory.NUMBER, null,null,null,"l_welfareEightySixtoSeven"),//12

	/** 超级大乐透 */
	DLT(DltConstant.KEY, "大乐透", "DLT", LotteryCategory.NUMBER, DltPlayType.values(),null,null,"01,02,03,04,05,06,07|01,02"),//13

	/** 山东11选5 */
	SDEL11TO5(SdEl11to5Constant.KEY, "山东11选5", "SDELT", LotteryCategory.FREQUENT ,Sdel11to5PlayType.values(),null,null,"01,02 "),//14

	/** 山东群英会 */
	QYH(QyhConstant.KEY, "群英会", "QYH", LotteryCategory.FREQUENT ,null,null,null,"l_qyh"),//15
	
	/** 体彩22选5 */
	TC22TO5(Tc22to5Constant.KEY, "22选5", "EEXW", LotteryCategory.NUMBER, Tc22to5PlayType.values(),null,null,"01,02,03,04,05,06,07"),//16
	
	/** 竞彩足球 */
	JCZQ(JczqConstant.KEY, "竞彩足球", "JCZ", LotteryCategory.JC,JczqPlayType.values(),JczqPassType.values(),JczqSchemeType.getTicketJczqSchemeTypeItem(),"{\"items\":[{\"matchKey\":\"20111218-019\",\"playTypeItem\":1,\"value\":3},{\"matchKey\":\"20111218-021\",\"playTypeItem\":1,\"value\":\"1\"}]}。"),//17

	/** 竞彩篮球 */
	JCLQ(JclqConstant.KEY, "竞彩篮球", "JCL", LotteryCategory.JC,JclqPlayType.values(),JclqPassType.values(),JclqSchemeType.getTicketJclqSchemeTypeItem(),"{\"items\":[{\"matchKey\":\"20111218-301\",\"playTypeItem\":1,\"value\":3},{\"matchKey\":\"20111218-302\",\"playTypeItem\":1,\"value\":\"0\"}]}。"),//18
	
	GDEL11TO5(GdEl11to5Constant.KEY, "广东11选5", "GDELT", LotteryCategory.FREQUENT ,null,null,null,"l_gdelElevenToFive"),//19
	
	SEVENSTAR(SevenstarConstant.KEY, "七星彩", "QXC", LotteryCategory.NUMBER, SevenStarPlayType.values(),null,null,"01-02-03-04-05-06-01  "),//20
	
	KLPK(KlpkConstant.KEY, "快乐扑克3", "klpk", LotteryCategory.FREQUENT ,KlpkPlayType.values(),null,null,"01,02 ");//21
	
	/* -----------------------添加一个彩种要在LotteryUtil.getWebLotteryList加上----------------------- */
	
	/* ----------------------- 属性----------------------- */

	private final String key;

	/** 彩种简称 */
	private final String simpleName;
	/** 彩种名称 */
	private final String lotteryName;
	/** 彩种方案号前缀 */
	private final String schemeNumberPrefix;
	/**
	 * 彩种所属类别
	 * 
	 * @see com.cai310.lottery.common.LotteryCategory
	 */
	private final LotteryCategory category;

	private final String schemeNumberRegex;
	
	private final PlayTypeItem[] playTypeItem;
	
	private final PassTypeItem[] passTypeItem;
	
	private final SchemeTypeItem[] schemeTypeItem;
	
	private final String example;

	/* ----------------------- 构造函数 ----------------------- */

	/**
	 * @param key {@link #key}
	 * @param lotteryName {@link #lotteryName}
	 * @param schemeNumberPrefix {@link #schemeNumberPrefix}
	 * @param category {@link #category}
	 */
	private Lottery(String key, String lotteryName, String schemeNumberPrefix, LotteryCategory category,PlayTypeItem[] playTypeItem,PassTypeItem[] passTypeItem,SchemeTypeItem[] schemeTypeItem,String example) {
		this(key, lotteryName, lotteryName, schemeNumberPrefix, category, playTypeItem,passTypeItem,schemeTypeItem, example);
	}

	/**
	 * @param key {@link #key}
	 * @param simpleName {@link #simpleName}
	 * @param lotteryName {@link #lotteryName}
	 * @param schemeNumberPrefix {@link #schemeNumberPrefix}
	 * @param category {@link #category}
	 */
	private Lottery(String key, String simpleName, String lotteryName, String schemeNumberPrefix,
			LotteryCategory category,PlayTypeItem[] playTypeItem,PassTypeItem[] passTypeItem,SchemeTypeItem[] schemeTypeItem,String example) {
		this.key = key;
		this.simpleName = simpleName;
		this.lotteryName = lotteryName;
		this.category = category;
		if (schemeNumberPrefix != null)
			this.schemeNumberPrefix = schemeNumberPrefix;
		else
			this.schemeNumberPrefix = this.name();
		this.schemeNumberRegex = String.format("^%s[0-9]{%s}$", this.schemeNumberPrefix, SCHEME_ID_FORMART.length());
		this.playTypeItem = playTypeItem;
		this.passTypeItem = passTypeItem;
		this.schemeTypeItem = schemeTypeItem;
		this.example=example;
	}

	/* ----------------------- getter method ----------------------- */

	/**
	 * @return {@link #key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 注释见{@link #simpleName}
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * @return {@link #lotteryName}
	 */
	public String getLotteryName() {
		return lotteryName;
	}

	/**
	 * @return {@link #schemeNumberPrefix}
	 */
	public String getSchemeNumberPrefix() {
		return schemeNumberPrefix;
	}
/**
 * 
 * @return {@link #promRebate}
 */
	public String getExample() {
		return example;
	}

	/**
	 * @return {@link #category}
	 */
	public LotteryCategory getCategory() {
		return category;
	}

	/**
	 * 从方案号中获取方案ID
	 * 
	 * @param schemeNumber 方案号
	 * @return 方案ID
	 */
	public Long getSchemeId(String schemeNumber) {
		if (StringUtils.isBlank(schemeNumber))
			return null;
		if (schemeNumber.matches(this.schemeNumberRegex))
			return Long.valueOf(schemeNumber.replaceAll(this.schemeNumberPrefix, ""));
		return null;
	}

	/**
	 * 根据方案ID获取该彩种的方案号
	 * 
	 * @param schemeId 方案ID
	 * @return 方案号
	 */
	public String getSchemeNumber(Long schemeId) {
		return this.schemeNumberPrefix + SCHEME_ID_NF.format(schemeId);
	}

	/* ----------------------- other method ----------------------- */

	/**
	 * 检查彩种是否属于某一类型的彩票
	 * 
	 * @param categoryOrdinal 类型序号
	 * @return 是否属于某一类型的彩票
	 * @see com.cai310.lottery.common.LotteryCategory
	 */
	public boolean checkCategory(int categoryOrdinal) {
		return this.category.equals(LotteryCategory.values()[categoryOrdinal]);
	}

	/**
	 * 根据方案号前缀判断属于哪个彩票类型
	 * 
	 * @param prefix 方案号前缀
	 * @return 彩票类型
	 */
	public static Lottery valueOfPrefix(String prefix) {
		if (StringUtils.isNotBlank(prefix)) {
			prefix = prefix.trim();
			for (Lottery l : Lottery.values()) {
				if (l.getSchemeNumberPrefix().equalsIgnoreCase(prefix))
					return l;
			}
		}
		return null;
	}

	/**
	 * 根据方案号判断属于哪个彩票类型
	 * 
	 * @param schemeNumber 方案号
	 * @return 彩票类型
	 */
	public static Lottery valueOfSchemeNumber(String schemeNumber) {
		if (StringUtils.isNotBlank(schemeNumber)) {
			schemeNumber = schemeNumber.trim();
			for (Lottery l : Lottery.values()) {
				if (schemeNumber.matches(l.schemeNumberRegex))
					return l;
			}
		}
		return null;
	}
	/**
	 * 根据方案号判断属于哪个彩票类型
	 * 
	 * @param schemeNumber 方案号
	 * @return 彩票类型
	 */
	public static List<Lottery> saleLottery() {
		List<Lottery> sale = Lists.newArrayList();
		for (Lottery l : Lottery.values()) {
			switch (l) {
			case EL11TO5:
			case WELFARE36To7:
			case QYH:
			case KLSF:
			case SEVENSTAR:
			case SSL:
			case GDEL11TO5:
			case TC22TO5:
				break;
			default:
				sale.add(l);
				break;
			}
		}
		return sale;
	}
	/**
	 * 根据玩法名字得到玩法选项
	 * 
	 * @param schemeNumber 方案号
	 * @return 彩票类型
	 */
	public Item[] getItemByPlayTypeItem(String playTypeItem) {
		if (StringUtils.isNotBlank(playTypeItem)) {
			playTypeItem = playTypeItem.trim();
			if(null!=this.getPlayTypeItem()){
				for (PlayTypeItem p : this.getPlayTypeItem()) {
					if (p.getTypeName().equals(playTypeItem))
						return p.getAllItems();
				}
			}
			
		}
		return null;
	}

	/**
	 * 是否高频彩种
	 * 
	 * @param lottery
	 * @return
	 */
	public static boolean isKeno(Lottery lottery) {
		switch (lottery) {
		case EL11TO5:
		case SDEL11TO5:
		case QYH:
		case KLSF:
		case SSC:
		case SSL:
		case GDEL11TO5:
			return Boolean.TRUE;
		default:
			return Boolean.FALSE;
		}
	}

	private static final String SCHEME_ID_FORMART = "0000000000";
	private static final NumberFormat SCHEME_ID_NF = new DecimalFormat(SCHEME_ID_FORMART);
	
	public static final String SQL_TYPE = Constant.ENUM_DEFAULT_SQL_TYPE;

	
	public PlayTypeItem[] getPlayTypeItem() {
		return playTypeItem;
	}

	public PassTypeItem[] getPassTypeItem() {
		return passTypeItem;
	}

	public SchemeTypeItem[] getSchemeTypeItem() {
		return schemeTypeItem;
	}
	
	public Integer getLotteryOrdinal() {
		return this.ordinal();
	}

}
