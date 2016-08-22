package com.miracle.web.controller.doc;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.miracle.common.Config;
import com.miracle.common.LotteryCategory;
import com.miracle.lotteryutils.Lottery;
import com.miracle.lotteryutils.ProcessIdType;
import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.model.user.BankInfo;
import com.miracle.model.user.User;
import com.miracle.model.user.UserInfo;
import com.miracle.spring.SpringUtils;
import com.miracle.utils.DateUtil;
import com.miracle.utils.HttpClientUtil;
import com.miracle.utils.JsonUtil;
import com.miracle.utils.MD5;
import com.miracle.utils.SecurityUtil;
import com.miracle.web.controller.common.BaseController;

@Controller
public class DocController extends BaseController {

	@RequestMapping("/doc")
	public ModelAndView initTicket() {
		final ModelAndView mav = new ModelAndView("/doc/index.ftl");
		return mav;
	}
	@RequestMapping("/doc/build")
	public ModelAndView build() {
		for (int i = 0; i < 10; i++) {
		User user = new User();
		user.setId(null);
		user.setMid(0L);
		user.setComission(0.0);
		user.setUserName("testhb"+i);
		user.setLocked(User.NO_LOCK_STATUS);
		user.setRemainMoney(BigDecimal.ZERO);
		user.setPassword(MD5.md5("123456")
				.toUpperCase());
		user.setAgentId(1L);
		user.setRelation("1");
		user.setRebate(0D);
		UserInfo info = new UserInfo();
		BankInfo bank = new BankInfo();
		user.setBank(bank);
		user.setInfo(info);
		user.setComission(0.0);
		// User reg=userManager.getUser(user.getId());
		user.setCreateTime(new Date());
		user = userService.saveUser(user);
		
		TicketPlatformInfo ticketPlatformInfo = new TicketPlatformInfo();
		ticketPlatformInfo.setPlatformName("testhb"+i);
		ticketPlatformInfo.setConsumptionMoney(BigDecimal.ZERO);
		ticketPlatformInfo.setUserId(user.getId());
		ticketPlatformInfo.setLocked(User.NO_LOCK_STATUS);
		ticketPlatformInfo.setRemainMoney(BigDecimal.valueOf(1000000D));
		ticketPlatformInfo.setPassword(MD5.md5("123456")
				.toUpperCase());
		ticketPlatformInfo.setCreateTime(new Date());
		ticketThenService.saveTicketPlatformInfo(ticketPlatformInfo);

		
		}
		final ModelAndView mav = new ModelAndView("/doc/index.ftl");
		return mav;
	}
	@RequestMapping("/doc/error")
	public ModelAndView error(final ModelMap modelMap) {
		modelMap.addAttribute("processIdType", ProcessIdType.values());
		final ModelAndView mav = new ModelAndView("/doc/error.ftl");
		return mav;
	}
	@RequestMapping("/doc/send")
	public ModelAndView send() {
		final ModelAndView mav = new ModelAndView("/doc/send.ftl");
		return mav;
	}
	@RequestMapping("/doc/confirm")
	public ModelAndView confirm() {
		final ModelAndView mav = new ModelAndView("/doc/confirm.ftl");
		return mav;
	}
	@RequestMapping("/doc/prize")
	public ModelAndView prize() {
		final ModelAndView mav = new ModelAndView("/doc/prize.ftl");
		return mav;
	}
	@RequestMapping("/doc/test")
	public ModelAndView test(final ModelMap modelMap,final HttpServletResponse response) {
		User user = this.getLoginUser(response);
	    if(null!=user){
	    	TicketPlatformInfo tp = ticketThenService.getTicketPlatformInfoBy(user);
	    	if(null!=tp){
	    		modelMap.addAttribute("wAgent", tp.getId());
	    		modelMap.addAttribute("wKey", tp.getPassword());
	    	}
	    }
		final ModelAndView mav = new ModelAndView("/doc/test.ftl");
		return mav;
	}
	
	@RequestMapping("/doc/saleLottery")
	public ModelAndView saleLottery(final ModelMap modelMap) {
		List<Lottery> saleLottery = Lottery.saleLottery();
		modelMap.addAttribute("saleLottery", saleLottery);
		ModelAndView mav = new ModelAndView("/doc/saleLottery.ftl");
		return mav;
	}
	
	@RequestMapping("/doc/lotteryinfo")
	public ModelAndView salLotteryInfo(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/lotteryInfo.ftl");
		return mav;
	}
	@RequestMapping("/doc/lotterymatch")
	public ModelAndView salLotteryMatch(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/lotteryMatch.ftl");
		return mav;
	}
	@RequestMapping("/doc/lotterymatch1")
	public ModelAndView salLotteryMatch1(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/lotteryMatch1.ftl");
		return mav;
	}
	@RequestMapping("/doc/lotterytype")
	public ModelAndView salLotteryType(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/lotteryType.ftl");
		return mav;
	}
	@RequestMapping("/doc/time")
	public ModelAndView time(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/time.ftl");
		return mav;
	}
	@RequestMapping("/doc/remainMoney")
	public ModelAndView remainMoney(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/remainMoney.ftl");
		return mav;
	}
	@RequestMapping("/doc/prizeTicket")
	public ModelAndView prizeTicket(final ModelMap modelMap) {
		final ModelAndView mav = new ModelAndView("/doc/prizeTicket.ftl");
		return mav;
	}
	@RequestMapping("/doc/resultList")
	public ModelAndView resultList(final ModelMap modelMap){
		final ModelAndView mav=new ModelAndView("/doc/resultList.ftl");
		return mav;
	}
	@RequestMapping("/dco/resultFormat")
	public ModelAndView resultFormat(final ModelMap modelMap){
		final ModelAndView mav=new ModelAndView("/doc/resultFormat.ftl");
		return mav;
	}
	@RequestMapping("/doc/lottery")
	public ModelAndView lottery(final ModelMap modelMap) {
		String lotteryStr = SpringUtils.getParameter("lottery");
		Lottery lottery = Lottery.valueOf(lotteryStr);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/doc/lottery.ftl");
		if(lottery.getCategory().equals(LotteryCategory.ZC)){
			mav.setViewName("/doc/lotteryZc.ftl");
		}
		modelMap.addAttribute("lottery", lottery);
		return mav;
	}
	@RequestMapping("/doc/numlottery")
	public ModelAndView numlottery(final ModelMap modelMap) {
		String lotteryStr = SpringUtils.getParameter("lottery");
		Lottery lottery = Lottery.valueOf(lotteryStr);
		final ModelAndView mav = new ModelAndView("/doc/lottery_num.ftl");
		modelMap.addAttribute("lottery", lottery);
		return mav;
	}
	
	@RequestMapping("/doc/playTypeItem")
	public ModelAndView playTypeItem(final ModelMap modelMap) {
		String lotteryStr = SpringUtils.getParameter("lottery");
		Lottery lottery = Lottery.valueOf(lotteryStr);
		String playTypeItemStr = SpringUtils.getParameter("playTypeItem");
		modelMap.addAttribute("item", lottery.getItemByPlayTypeItem(playTypeItemStr));
		ModelAndView mav = new ModelAndView("/doc/playTypeItem.ftl");
		if(playTypeItemStr !=null && playTypeItemStr.startsWith("Europe")){
			mav.setViewName("/doc/playTypeItemEurope.ftl");
		}
	 
		modelMap.addAttribute("lottery", lottery);
		return mav;
	}
 
	
	/** 
     * 返回JSON数据 
     * @return 
     */  
    @RequestMapping(value="/test/md5")  
    @ResponseBody  
    public Object md5(){  
    	HashMap<String, String> map = Maps.newHashMap();
    	String md5 = SpringUtils.getParameter("md5");
    	if(SpringUtils.isBlank(md5)){
    		map.put("md5", "输入MD5");
        	return map;
    	}
		String pwd=null;
		try {
			pwd = SecurityUtil.md5(md5.getBytes("UTF-8")).toUpperCase().trim();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	map.put("md5",pwd);
    	return map;
    }  
    /** 
     * 返回JSON数据 
     * @return 
     * @throws UnsupportedEncodingException 
     */  

    @RequestMapping(value="/test/action")  
    @ResponseBody  
    public Object action() throws UnsupportedEncodingException{
    	String reUrl = Config.config.getProperty("ticket.interface", "http://localhost/ticket");//"http://221.228.231.83:18122/ticket";
    	HashMap<String, String> map = Maps.newHashMap();
    	String wAction = SpringUtils.getParameter("wAction");
    	if(SpringUtils.isBlank(wAction)){
    		map.put("msg", "请输入wAction");
        	return map;
    	}
    	String wParam = SpringUtils.getParameter("wParam");
    	if(SpringUtils.isBlank(wParam)){
    		if(!"106".equals(wAction)){
    			map.put("msg", "请输入wParam");
            	return map;
    		}
    	}
    	String wAgent = SpringUtils.getParameter("wAgent");
    	if(SpringUtils.isBlank(wAgent)){
    		map.put("msg", "请输入wAgent");
        	return map;
    	}
    	String wSign = SpringUtils.getParameter("wSign");
    	if(SpringUtils.isBlank(wAgent)){
    		map.put("msg", "请输入wSign");
        	return map;
    	}
//    	Long time =System.currentTimeMillis();
//    	List<String> ticket = Lists.newArrayList();
//    	String date = DateUtil.dateToStrYyyyMMdd(new Date());
//		for (long i = time; i < time+1; i++) {
//    		Map<String,String> ParamMap=new LinkedHashMap<String,String>();
//    		//ParamMap.put("mode", "0");
//    		ParamMap.put("periodNumber", "");
//    		ParamMap.put("cost", "2");
//    		ParamMap.put("multiple", "1");
//    		ParamMap.put("units", "1");
//    		ParamMap.put("playType", "0");
//    		ParamMap.put("type", "1");
//    		ParamMap.put("passType", "1");
////    		String value = "{\"danMinHit\":1,\"items\":[{\"dan\":false,\"matchKey\":\"0\",\"value\":3}," +
////    													"{\"dan\":false,\"matchKey\":\"2\",\"value\":3}," +
////    													"{\"dan\":false,\"matchKey\":\"3\",\"value\":3}," +
////								        				"{\"dan\":false,\"matchKey\":\"4\",\"value\":0}," +
////								        				"{\"dan\":false,\"matchKey\":\"5\",\"value\":3}," +
////								        				"{\"dan\":false,\"matchKey\":\"6\",\"value\":3}," +
////								        				"{\"dan\":true,\"matchKey\":\"7\",\"value\":1}," +
////								        				"{\"dan\":false,\"matchKey\":\"8\",\"value\":0}," +
////								        				"{\"dan\":false,\"matchKey\":\"10\",\"value\":3}]}";
//    		String value = "{\"items\":[" +
//								"{\"matchKey\":\""+date+"-001\",\"value\":3}," +
//								"{\"matchKey\":\""+date+"-002\",\"value\":3}]}";
////    		ParamMap.put("value", "3,3,3,3,3,3,3,3,3,3,3,3,3,3");
//    		ParamMap.put("value", value);
////    		ParamMap.put("userId", Uid);
////    		ParamMap.put("userPwd", password);
//    		
////    		ParamMap.put("userId", "134");
////    		ParamMap.put("userPwd", "2a90ac99f393436c3a581f83fe90e57b");
//    		
////    		ParamMap.put("isChase", "false");
////    		ParamMap.put("periodSizeOfChase", "2");
////    		ParamMap.put("totalCostOfChase", "8");
////    		ParamMap.put("wonStopOfChase", "false");
//    		
//    		ParamMap.put("orderId", i+"");
//    		
//    		
//    		
////    		
////    		ParamMap.put("shareType", "0");
////    		ParamMap.put("baodiCost", "1");
////    		ParamMap.put("subscriptionCost", "1");
////    		ParamMap.put("commissionRate", "1");
////    		ParamMap.put("minSubscriptionCost", "1");
////    		ParamMap.put("secretType", "");
//    		ticket.add(JsonUtil.getJsonString4JavaPOJO(ParamMap));
//		}
//		Map<String,Object> ParamMap=new LinkedHashMap<String,Object>();
////		ParamMap.put("userId", "134");
////		ParamMap.put("userPwd", "E10ADC3949BA59ABBE56E057F20F883E");
//		ParamMap.put("wLotteryId", Lottery.JCZQ.ordinal());
////		ParamMap.put("id", "4");
//		ParamMap.put("ticket", ticket);
//		String betValue = JsonUtil.getJsonString4JavaPOJO(ParamMap);
    	HashMap<String, String> paramMap1 = Maps.newHashMap();
    	paramMap1.put("wAction", wAction.trim());
    	paramMap1.put("wParam", URLEncoder.encode(wParam.trim(),"UTF-8"));
//    	paramMap1.put("wParam", betValue);
    	paramMap1.put("wAgent", wAgent.trim());
//		String param = wAction+betValue+wAgent+"E10ADC3949BA59ABBE56E057F20F883E";
//		String pwd  = SecurityUtil.md5(param.getBytes("UTF-8")).toUpperCase().trim();
    	paramMap1.put("wSign", wSign.trim());
//		paramMap1.put("wSign", pwd.trim());
		String returnString = HttpClientUtil.Utf8HttpClientUtils(reUrl,paramMap1);		map.put("msg", returnString);
    	return map;
    }  
}
