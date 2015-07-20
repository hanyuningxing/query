package com.miracle.web.controller.user;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.collect.Maps;
import com.miracle.common.FundDetailType;
import com.miracle.common.FundMode;
import com.miracle.common.TicketSchemeState;
import com.miracle.lotteryutils.Lottery;
import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.model.ticket.TicketThen;
import com.miracle.model.user.FundDetail;
import com.miracle.model.user.User;
import com.miracle.query.FundDetailShow;
import com.miracle.query.FundReport;
import com.miracle.query.TicketQuery;
import com.miracle.query.UserQuery;
import com.miracle.service.QueryService;
import com.miracle.spring.SpringUtils;
import com.miracle.utils.DateUtil;
import com.miracle.utils.ExcelUtil;
import com.miracle.utils.SecurityUtil;
import com.miracle.web.controller.common.BaseController;

@Controller
public class UserController extends BaseController {

	private transient Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private QueryService queryService;

	@RequestMapping("/user/user")
	public String index() {
		return "/user/index.ftl";
	}
	
	@RequestMapping("/user/fdreport/init")
	public String initFundReport(final ModelMap modelMap){
		modelMap.addAttribute("ztList", TicketSchemeState.values());
		modelMap.addAttribute("czList", Lottery.values());
		modelMap.addAttribute("stateList", TicketSchemeState.values());
		return "/user/fundReport.ftl";
	}
	@RequestMapping("/user/fdreport")
	public String fundReportCount(final ModelMap modelMap, final TicketQuery query,HttpServletResponse response) {
		initFundReport(modelMap);
		DetachedCriteria criteria = DetachedCriteria.forClass(TicketThen.class);
		TicketPlatformInfo ticketPlatformInfo = this.getTicketPlatformInfo(response);
		criteria.add(Restrictions.eq("platformInfoId", ticketPlatformInfo.getId()));
		try {
			if (StringUtils.isNotBlank(query.getStartTime())) {
				criteria.add(Restrictions.ge("createTime",DateUtil.strToDate(query.getStartTime())));
//						DateUtils.parseDate(query.getStartTime(), new String[] { "yyyy-MM-dd HH:mm:ss" })));
			}
			if (StringUtils.isNotBlank(query.getEndTime())) {
				criteria.add(Restrictions.le("createTime",DateUtil.strToDate(query.getEndTime())));
//						DateUtils.parseDate(query.getEndTime(), new String[] { "yyyy-MM-dd HH:mm:ss" })));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null!=query.getLotteryType()) {
			criteria.add(Restrictions.eq("lotteryType", query.getLotteryType()));
		}
		if (!StringUtils.isEmpty(query.getBetType())) {
			criteria.add(Restrictions.eq("playType", Byte.valueOf(query.getBetType())));
		}
		
		ProjectionList plist=Projections.projectionList();
		plist.add(Projections.groupProperty("lotteryType"));
		plist.add(Projections.sum("units"));
		plist.add(Projections.sum("multiple"));
		plist.add(Projections.sum("schemeCost"));
		plist.add(Projections.sum("totalPrizeAfterTax"));
		plist.add(Projections.count("id"));
		criteria.setProjection(plist);
		List<Object[]> list=queryService.findByDetachedCriteria(criteria);
		List<FundReport> freportList=new ArrayList<FundReport>(); 
		if(list!=null&&!list.isEmpty()){
			for(Object[] objs:list){
				FundReport fr=new FundReport();
				if(objs[0]!=null){
					fr.setLotteryType((Lottery)objs[0]);
				}
				if(objs[1]!=null){
					fr.setTotalUnits(((Long)objs[1]).intValue());
				}
				if(objs[2]!=null){
					fr.setTotalMultiple(((Long)objs[2]).intValue());
				}
				if(objs[3]!=null){
					fr.setTotalCost(((Long)objs[3]).doubleValue());
				}
				if(objs[4]!=null){
					fr.setTotalPrize(((BigDecimal)objs[4]).doubleValue());
				}
				if(objs[5]!=null){
					fr.setTotalCount(((Long)objs[5]).intValue());
				}
				fr.setStartTime(query.getStartTime());
				fr.setEndTime(query.getEndTime());
				freportList.add(fr);
			}
			modelMap.addAttribute("dataList", freportList);
			
			if ("1".equals(query.getExport())) {
				List<String> biaotou = new ArrayList<String>();
				List<String> colName = new ArrayList<String>();

				biaotou.add("彩种");
				biaotou.add("注数");
				biaotou.add("倍数");
				biaotou.add("金额");
				biaotou.add("彩票");
				biaotou.add("奖金");
				biaotou.add("开始时间");
				biaotou.add("结束时间");

				colName.add("lotteryName");
				colName.add("totalUnits");
				colName.add("totalMultiple");
				colName.add("totalCost");
				colName.add("totalCount");
				colName.add("totalPrize");
				colName.add("startTime");
				colName.add("endTime");

				HSSFWorkbook wb = ExcelUtil.excel("数据", biaotou, colName, freportList);
				if (wb != null) {
					try {
						String filename = "export.xls"; // 设置下载时客户端Excel的名称
						// 请见：http://zmx.javaeye.com/blog/622529
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-disposition", "attachment;filename=" + filename);
						OutputStream ouputStream = response.getOutputStream();
						wb.write(ouputStream);
						ouputStream.flush();
						ouputStream.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			}
		}
		modelMap.addAttribute("tick", query);
		if (query.getLotteryType() != null) {
			modelMap.addAttribute("playTypeItems", query.getLotteryType().getPlayTypeItem());
		}
		return "/user/fundReport.ftl";
	}
	
	
	@RequestMapping("/user/fund")
	public String initFundDetail(final ModelMap modelMap){
		modelMap.addAttribute("fundModeList", FundMode.values());
		modelMap.addAttribute("fundTypeList", FundDetailType.values());
		return "/user/fundDetailCount.ftl";
	}
	
	@RequestMapping("/user/fundcount")
	public String fundDetailCount(final ModelMap modelMap, final UserQuery query,HttpServletResponse response) {
		initFundDetail(modelMap);
		DetachedCriteria criteria = DetachedCriteria.forClass(FundDetail.class);
		User user = this.getLoginUser(response);
		criteria.add(Restrictions.eq("userId", user.getId()));
		buidCriteria(query, criteria);

		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.count("id"));
		plist.add(Projections.groupProperty("mode"));
		plist.add(Projections.groupProperty("type"));
		plist.add(Projections.sum("money"));
		criteria.setProjection(plist);
		List<Object[]> list = queryService.findByDetachedCriteria(criteria);
		Map<String, FundDetailShow> map = new HashMap<String, FundDetailShow>();
		if (list != null && !list.isEmpty()) {
			for (Object[] objs : list) {
				Long count = (Long) objs[0];
				FundMode mode = (FundMode) objs[1];
				FundDetailType type = (FundDetailType) objs[2];
				BigDecimal money = (BigDecimal) objs[3];
				FundDetailShow fdshow = map.get(type.name());
				if (fdshow == null) {
					fdshow = new FundDetailShow();
					fdshow.setType(type);
				}
				fdshow.setFundCount(fdshow.getFundCount()+count);
				if (money != null) {
					if (FundMode.IN == mode) {
						fdshow.setMoneyIn(money.doubleValue());
					}else if(FundMode.OUT==mode){
						fdshow.setMoneyOut(money.doubleValue());
					}
				}
				map.put(type.name(), fdshow);
			}
		}
		if(!map.isEmpty()){
			Set<String> keys=new TreeSet<String>(map.keySet());
			List<FundDetailShow> dataList=new ArrayList<FundDetailShow>();
			for(String key:keys){
				dataList.add(map.get(key));
			}
			modelMap.addAttribute("dataList", dataList);
			
			if ("1".equals(query.getExport())) {
				List<String> biaotou = new ArrayList<String>();
				List<String> colName = new ArrayList<String>();
				biaotou.add("交易类型");
				biaotou.add("收入金额");
				biaotou.add("支出金额");
				biaotou.add("交易数目");

				colName.add("fundTypeName");
				colName.add("moneyIn");
				colName.add("moneyOut");
				colName.add("fundCount");

				HSSFWorkbook wb = ExcelUtil.excel("数据", biaotou, colName, dataList);
				if (wb != null) {
					try {
						String filename = "export.xls"; // 设置下载时客户端Excel的名称
						// 请见：http://zmx.javaeye.com/blog/622529
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-disposition", "attachment;filename=" + filename);
						OutputStream ouputStream = response.getOutputStream();
						wb.write(ouputStream);
						ouputStream.flush();
						ouputStream.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			}
		}
		
		modelMap.addAttribute("query", query);
		return "/user/fundDetailCount.ftl";
	}

	private void buidCriteria(final UserQuery query, final DetachedCriteria criteria) {
		try {
			if (StringUtils.isNotBlank(query.getStartTime())) {
				criteria.add(Restrictions.ge("createTime",
						DateUtils.parseDate(query.getStartTime(), new String[] { "yyyy-MM-dd HH:mm:ss" })));
			}
			if (StringUtils.isNotBlank(query.getEndTime())) {
				criteria.add(Restrictions.le("createTime",
						DateUtils.parseDate(query.getEndTime(), new String[] { "yyyy-MM-dd HH:mm:ss" })));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (null != query.getFundMode()) {
			criteria.add(Restrictions.eq("mode", query.getFundMode()));
		}
		if (null != query.getFundType()) {
			criteria.add(Restrictions.eq("type", query.getFundType()));
		}
		if (StringUtils.isNotBlank(query.getRemark())) {
			criteria.add(Restrictions.like("remark", "%" + query.getRemark() + "%"));
		}
	}
	/** 
     * 返回JSON数据 
     * @return 
     */  
	/** 金额 格式化对象 */
	public static final NumberFormat MONEY_FORMAT = new DecimalFormat("###,###.##");
    @RequestMapping(value="/user/remainMoney")  
    @ResponseBody  
    public Object remainMoney(HttpServletResponse response){  
    	HashMap<String, String> map = Maps.newHashMap();
    	TicketPlatformInfo ticketPlatformInfo = super.getTicketPlatformInfo(response);
    	if(null!=ticketPlatformInfo){
        	map.put("remainMoney", ""+MONEY_FORMAT.format(ticketPlatformInfo.getRemainMoney()));
    	}else{
        	map.put("remainMoney", "");
    	}
    	return map;
    } 
    
}
