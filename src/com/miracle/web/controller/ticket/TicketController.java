package com.miracle.web.controller.ticket;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miracle.common.TicketSchemeState;
import com.miracle.lotteryutils.Lottery;
import com.miracle.model.ticket.NumberLimit;
import com.miracle.model.ticket.TicketDatail;
import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.model.ticket.TicketThen;
import com.miracle.model.user.FundDetail;
import com.miracle.model.user.User;
import com.miracle.orm.Pagination;
import com.miracle.orm.XDetachedCriteria;
import com.miracle.query.TicketCountBean;
import com.miracle.query.TicketQuery;
import com.miracle.service.ticket.TicketThenService;
import com.miracle.spring.SpringUtils;
import com.miracle.utils.DateUtil;
import com.miracle.utils.ExcelUtil;
import com.miracle.web.controller.common.BaseController;

@Controller
public class TicketController extends BaseController {

	@Autowired
	private TicketThenService ticketThenService;

	@RequestMapping("/ticket/count")
	public String initTicketCount(final ModelMap modelMap) {
		modelMap.addAttribute("ztList", TicketSchemeState.values());
		modelMap.addAttribute("czList", Lottery.values());
		modelMap.addAttribute("stateList", TicketSchemeState.values());
		return "/ticket/ticketCount.ftl";
	}
	
	@RequestMapping("/ticket/limit")
	public String numberLimit(final ModelMap modelMap, Pagination pagination,@RequestParam(required=false)Lottery lotteryType,@RequestParam(required=false)String periodNumber){
		
		if (pagination == null) {
			pagination = new Pagination(10);
		} else {
			pagination.setPageSize(10);
		}
		
		XDetachedCriteria criteria = new XDetachedCriteria(NumberLimit.class);
		if(lotteryType!=null){
			criteria.add(Restrictions.eq("lotteryType", lotteryType));
		}
		if(periodNumber!=null&&!"".equals(periodNumber)){
			criteria.add(Restrictions.eq("periodNumber", periodNumber));
		}
		pagination=ticketThenService.findByCriteriaAndPagination(criteria, pagination);

		modelMap.addAttribute("czList", Lottery.values());
		modelMap.addAttribute("pagination", pagination);
		modelMap.addAttribute("lotteryType", lotteryType);
		modelMap.addAttribute("periodNumber", periodNumber);
		
		return "/ticket/numberLimit.ftl";
	}

	@RequestMapping("/ticket/countquery")
	public String queryTicketCount(final TicketQuery query, final ModelMap modelMap, HttpServletResponse response) {
		final DetachedCriteria criteria = DetachedCriteria.forClass(TicketThen.class, "t");
		buildCriteria(query, criteria, null);
		ProjectionList plist=Projections.projectionList();
		plist.add(Projections.sum("t.schemeCost"));
		plist.add(Projections.count("id"));
		plist.add(Projections.sum("totalPrize"));
		plist.add(Projections.sum("totalPrizeAfterTax"));
		plist.add(Projections.sum("addPrize"));
		plist.add(Projections.groupProperty("t.lotteryType"));
		criteria.setProjection(plist);
		criteria.addOrder(Order.desc("t.lotteryType"));
		TicketPlatformInfo ticketPlatformInfo = this.getTicketPlatformInfo(response);
		criteria.add(Restrictions.eq("t.platformInfoId", ticketPlatformInfo.getId()));
		List<Object[]> list=ticketThenService.findByDetachedCriteria(criteria);
		if(list!=null&&!list.isEmpty()){
			List<TicketCountBean> dataList=new ArrayList<TicketCountBean>();
			for(Object[] objs:list){
				TicketCountBean tb=new 	TicketCountBean();
				if(objs[0]!=null){
					tb.setTotalCost((Long)objs[0]);
				}
				if(objs[1]!=null){
					tb.setTotalCount((Long)objs[1]);
				}
				if(objs[2]!=null){
					tb.setTotalPrize(((Double)objs[2]));
				}
				if(objs[3]!=null){
					tb.setTotalPrizeAfterTax(((BigDecimal)objs[3]).doubleValue());
				}
				if(objs[4]!=null){
					tb.setAddPrize(((BigDecimal)objs[4]).doubleValue());
				}
				if(objs[5]!=null){
					tb.setLotteryType((Lottery)objs[5]);
				}
				dataList.add(tb);
			}
			modelMap.addAttribute("dataList", dataList);
			if(null!=query.getEndTime()){
				User user = this.getLoginUser(response);
				final DetachedCriteria fundCriteria = DetachedCriteria.forClass(FundDetail.class, "f");
				fundCriteria.add(Restrictions.le("f.createTime", DateUtil.strToDate(query.getEndTime())));
				fundCriteria.add(Restrictions.eq("f.userId", user.getId()));
				fundCriteria.addOrder(Order.desc("f.id"));
				List<FundDetail> fundDetailList = ticketThenService.findByDetachedCriteria(fundCriteria,0,1);
				if(null!=fundDetailList&&!fundDetailList.isEmpty()){
					FundDetail fundDetail =  fundDetailList.get(0);
					modelMap.addAttribute("resultMoney", fundDetail.getResultMoney());
				}
			}
			if ("1".equals(query.getExport())) {
				List<String> biaotou = new ArrayList<String>();
				List<String> colName = new ArrayList<String>();
									
				biaotou.add("彩种");
				biaotou.add("购彩总额");
				biaotou.add("总票数");
				biaotou.add("税前奖金");
				biaotou.add("税后奖金");
				biaotou.add("加奖");

				colName.add("lotteryTypeName");
				colName.add("totalCost");
				colName.add("totalCount");
				colName.add("totalPrize");
				colName.add("totalPrizeAfterTax");
				colName.add("addPrize");

				HSSFWorkbook wb = ExcelUtil.excel("数据", biaotou, colName, dataList);
				if (wb != null) {
					try {
						String filename = "ticketcount.xls"; // 设置下载时客户端Excel的名称
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
		return initTicketCount(modelMap);
	}

	@RequestMapping("/ticket")
	public String initTicket(final ModelMap modelMap) {
		modelMap.addAttribute("ztList", TicketSchemeState.values());
		modelMap.addAttribute("czList", Lottery.values());
		return "/ticket/queryTicket.ftl";
	}

	@RequestMapping("ticket/query")
	public String queryPageTickets(final TicketQuery query, Pagination pagination, final ModelMap modelMap,
			HttpServletResponse response) {
		if (pagination == null) {
			pagination = new Pagination(10);
		} else {
			pagination.setPageSize(10);
		}

		final XDetachedCriteria criteria = new XDetachedCriteria(TicketThen.class, "t");
		final DetachedCriteria countCriteria = DetachedCriteria.forClass(TicketThen.class, "t");
		TicketPlatformInfo ticketPlatformInfo = this.getTicketPlatformInfo(response);
		criteria.add(Restrictions.eq("t.platformInfoId", ticketPlatformInfo.getId()));
		countCriteria.add(Restrictions.eq("t.platformInfoId", ticketPlatformInfo.getId()));
		buildCriteria(query, criteria, countCriteria);
		if ("1".equals(query.getExport())) {
			List dataList = ticketThenService.findByDetachedCriteria(countCriteria);
			List<String> biaotou = new ArrayList<String>();
			List<String> colName = new ArrayList<String>();
			biaotou.add("编号");
			biaotou.add("订单号");
			biaotou.add("彩种");
			biaotou.add("期号");
			biaotou.add("彩票编号");
			biaotou.add("注数");
			biaotou.add("倍数");
			biaotou.add("金额");
			biaotou.add("奖金");
			biaotou.add("投注时间");
			biaotou.add("出票时间");
			biaotou.add("结算时间");

			colName.add("id");
			colName.add("orderId");
			colName.add("lotteryTypeName");
			colName.add("periodNumber");
			colName.add("schemeNumber");
			colName.add("units");
			colName.add("multiple");
			colName.add("schemeCost");
			colName.add("totalPrizeAfterTax");
			colName.add("createTime");
			colName.add("ticketTime");
			colName.add("prizeTime");

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
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.sum("t.schemeCost"));
		plist.add(Projections.sum("t.totalPrizeAfterTax"));
		plist.add(Projections.count("t.id"));
		countCriteria.setProjection(plist);

		List rlist = ticketThenService.findByDetachedCriteria(countCriteria);
		pagination = ticketThenService.findByCriteriaAndPagination(criteria, pagination);
		if (rlist != null && !rlist.isEmpty()) {
			Object[] objs = (Object[]) rlist.get(0);
			long totalSale = 0;
			if (objs[0] != null) {
				totalSale = (Long) objs[0];
			}
			double totalPrize = 0;
			if (objs[1] != null) {
				totalPrize = ((BigDecimal) objs[1]).doubleValue();
			}
			long totalCount = 0;
			if (objs[2] != null) {
				totalCount = (Long) objs[2];
			}
			modelMap.addAttribute("totalSale", totalSale);
			modelMap.addAttribute("totalPrize", totalPrize);
			modelMap.addAttribute("totalCount", totalCount);
		}

		modelMap.addAttribute("ztList", TicketSchemeState.values());
		modelMap.addAttribute("czList", Lottery.values());
		modelMap.addAttribute("tick", query);
		modelMap.addAttribute("pagination", pagination);
		if (query.getLotteryType() != null) {
			modelMap.addAttribute("playTypeItems", query.getLotteryType().getPlayTypeItem());
		}
		return "ticket/queryTicket.ftl";
	}

	private void buildCriteria(final TicketQuery query, final DetachedCriteria criteria,
			final DetachedCriteria countCriteria) {
		if (!StringUtils.isEmpty(query.getPeriodNum())) {
			criteria.add(Restrictions.eq("t.periodNumber", query.getPeriodNum()));
			if (countCriteria != null)
				countCriteria.add(Restrictions.eq("t.periodNumber", query.getPeriodNum()));
		}
		if (!StringUtils.isEmpty(query.getPeriodNmStart())) {
			criteria.add(Restrictions.ge("t.periodNumber", query.getPeriodNmStart()));
			if (countCriteria != null)
				countCriteria.add(Restrictions.ge("t.periodNumber", query.getPeriodNmStart()));
		}
		if (!StringUtils.isEmpty(query.getPeriodNmEnd())) {
			criteria.add(Restrictions.le("t.periodNumber", query.getPeriodNmEnd()));
			if (countCriteria != null)
				criteria.add(Restrictions.le("t.periodNumber", query.getPeriodNmEnd()));
		}
		if (!StringUtils.isEmpty(query.getOrderId())) {
			criteria.add(Restrictions.eq("t.orderId", String.valueOf(query.getOrderId())));
			if (countCriteria != null)
				countCriteria.add(Restrictions.eq("t.orderId", String.valueOf(query.getOrderId())));
		}
		if (!StringUtils.isEmpty(query.getLotteryType())) {
			criteria.add(Restrictions.eq("t.lotteryType", query.getLotteryType()));
			if (countCriteria != null)
				countCriteria.add(Restrictions.eq("t.lotteryType", query.getLotteryType()));
		}
		if (!StringUtils.isEmpty(query.getBetType())) {
			criteria.add(Restrictions.eq("t.playType", Byte.valueOf(query.getBetType())));
			if (countCriteria != null)
				countCriteria.add(Restrictions.eq("t.playType", Byte.valueOf(query.getBetType())));
		}
		if (!StringUtils.isEmpty(query.getSchemeState())) {
			criteria.add(Restrictions.eq("t.state", query.getSchemeState()));
			if (countCriteria != null)
				countCriteria.add(Restrictions.eq("t.state", query.getSchemeState()));
		}
		if (!StringUtils.isEmpty(query.getOutOrderNumber())) {
			criteria.add(Restrictions.eq("t.outOrderNumber", query.getOutOrderNumber()));
			if (countCriteria != null)
				countCriteria.add(Restrictions.eq("t.outOrderNumber", query.getOutOrderNumber()));
		}
		if (!StringUtils.isEmpty(query.getStartTime())) {
			criteria.add(Restrictions.ge("t.createTime", DateUtil.strToDate(query.getStartTime())));
			if (countCriteria != null)
				countCriteria.add(Restrictions.ge("t.createTime", DateUtil.strToDate(query.getStartTime())));
		}
		if (!StringUtils.isEmpty(query.getEndTime())) {
			criteria.add(Restrictions.le("t.createTime", DateUtil.strToDate(query.getEndTime())));
			if (countCriteria != null)
				countCriteria.add(Restrictions.le("t.createTime", DateUtil.strToDate(query.getEndTime())));
		}
		if (!StringUtils.isEmpty(query.getTicketStartTime())) {
			criteria.add(Restrictions.ge("t.ticketTime", DateUtil.strToDate(query.getTicketStartTime())));
			if (countCriteria != null)
				countCriteria.add(Restrictions.ge("t.ticketTime", DateUtil.strToDate(query.getTicketStartTime())));
		}
		if (!StringUtils.isEmpty(query.getTicketEndTime())) {
			criteria.add(Restrictions.le("t.ticketTime", DateUtil.strToDate(query.getTicketEndTime())));
			if (countCriteria != null)
				countCriteria.add(Restrictions.le("t.ticketTime", DateUtil.strToDate(query.getTicketEndTime())));
		}
		String orderField = "t.id";
		if(!StringUtils.isEmpty(query.getOrderFiled())){
			orderField = "t."+query.getOrderFiled();
		}
		if (0 == query.getOrderDesc()) {
			criteria.addOrder(Order.desc(orderField));
		} else {
			criteria.addOrder(Order.asc(orderField));
		}
	}
	@RequestMapping("/ticket/detail")
	public String ticketDetail(final ModelMap modelMap) {
		String id = SpringUtils.getParameter("id");
		TicketThen ticketThen = this.ticketThenService.getTicketThen(Long.valueOf(id));
		TicketDatail ticketDatail = this.ticketThenService.getTicketDatailByTicketThen(ticketThen);
		modelMap.addAttribute("ticketDatail", ticketDatail);
		modelMap.addAttribute("ticketThen", ticketThen);
		return "/ticket/detail.ftl";
	}
}
