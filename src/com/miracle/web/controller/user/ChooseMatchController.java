package com.miracle.web.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miracle.model.user.GrepMatchInfo;
import com.miracle.model.user.GrepProjectInfo;
import com.miracle.model.user.GrepUserInfo;
import com.miracle.service.user.GrepMatchInfoService;
import com.miracle.service.user.GrepProjectInfoService;
import com.miracle.service.user.GrepUserInfoService;
import com.miracle.utils.DateUtil;
import com.miracle.web.controller.common.BaseController;

@Controller
public class ChooseMatchController extends BaseController {

	private transient Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private GrepMatchInfoService grepMatchInfoService;
	@Autowired
	private GrepProjectInfoService grepProjectInfoService;
	@Autowired
	private GrepUserInfoService grepUserInfoService;
	
	
	
	@RequestMapping("/chooseMatchs")
	public String showMatchs(final ModelMap modelMap){
		String hql = " from GrepMatchInfo where homeScore is null and lastModifyTime >=? order by matchId desc ";
		List<GrepMatchInfo> chooseMatchList =grepMatchInfoService.find(hql, DateUtil.getTodayDate(new Date()));
		modelMap.addAttribute("chooseMatchList", chooseMatchList);
		return "/test/chooseMatchList.ftl";
	}
	
	@RequestMapping("/chooseMatchs2")
	public String showMatchs2(final ModelMap modelMap){
		String hql = " from GrepMatchInfo where homeScore is null and  lastModifyTime >=? order by matchId desc ";
		List<GrepMatchInfo> chooseMatchList =grepMatchInfoService.find(hql, DateUtil.getTodayDate(new Date()));
		modelMap.addAttribute("chooseMatchList", chooseMatchList);
		return "/test/chooseMatchList2.ftl";
	}
	
	@RequestMapping("/chooseMatchsHis")
	public String showMatchHis(final ModelMap modelMap){
		String hql = " from GrepMatchInfo where homeScore is not null  and createTime <? and createTime>=? order by matchId desc ";
		List<GrepMatchInfo> chooseMatchList =grepMatchInfoService.find(hql, new Object[]{DateUtil.getTodayDate(new Date()),DateUtil.calDate(new Date(),0,0,-2)});
		int won=0;
		int owon=0;
		for (GrepMatchInfo grepMatchInfo : chooseMatchList) {
			if(grepMatchInfo.isFlag()){
				won++;
			}
			if(grepMatchInfo.isOflag()){
				owon++;
			}
		}
		String rate = "";
		String orate = "";
		if(chooseMatchList!=null&&chooseMatchList.size()>0){
			rate = won*100/chooseMatchList.size()+"%";
			orate = owon*100/chooseMatchList.size()+"%";
		}
		modelMap.addAttribute("chooseMatchList", chooseMatchList);
		modelMap.addAttribute("rate", rate);
		modelMap.addAttribute("orate", orate);
		return "/test/chooseMatchList.ftl";
	}
	
	@RequestMapping("/chooseMatchsHis2")
	public String showMatchHis2(final ModelMap modelMap){
		String hql = " from GrepMatchInfo where homeScore is not null  and createTime <? and createTime>=? order by matchId desc ";
		List<GrepMatchInfo> chooseMatchList =grepMatchInfoService.find(hql, new Object[]{DateUtil.getTodayDate(new Date()),DateUtil.calDate(new Date(),0,0,-1)});
		int won=0;
		int owon=0;
		for (GrepMatchInfo grepMatchInfo : chooseMatchList) {
			if(grepMatchInfo.isFlag()){
				won++;
			}
			if(grepMatchInfo.isOflag()){
				owon++;
			}
		}
		String rate = "";
		String orate = "";
		if(chooseMatchList!=null&&chooseMatchList.size()>0){
			rate = won*100/chooseMatchList.size()+"%";
			orate = owon*100/chooseMatchList.size()+"%";
		}
		modelMap.addAttribute("chooseMatchList", chooseMatchList);
		modelMap.addAttribute("rate", rate);
		modelMap.addAttribute("orate", orate);
		return "/test/chooseMatchList2.ftl";
	}
	
	
	
	
	@RequestMapping("/chooseProjects")
	public String showProjects(final ModelMap modelMap){
		String hql = " from GrepProjectInfo where (send =1 or uid in (select uid from GrepUserInfo where hotPerson = 1)) and endTime >? order by endTime,uid  ";
		List<GrepProjectInfo> projectlist =grepProjectInfoService.find(hql, new Object[]{DateUtil.calDate(new Date(),0,0,0,0,30,0)});
		
		String hql2 = " from GrepUserInfo where hotPerson = 1";
		List<GrepUserInfo> userlist =grepUserInfoService.find(hql2, new Object[]{});
		for (GrepProjectInfo grepProjectInfo : projectlist) {
			for (GrepUserInfo grepUserInfo : userlist) {
				if(grepUserInfo.getUid().equals(grepProjectInfo.getUid())){
					grepProjectInfo.setHotPerson(true);
				}
			}
		}
		modelMap.addAttribute("projectlist", projectlist);
		return "/test/chooseProjectList.ftl";
	}
	
	@RequestMapping("/chooseHotProjects")
	public String showHotProjects(final ModelMap modelMap){
		
		String hql1 = " from GrepUserInfo where proWonTime >? order by weekWonNum/weekNum desc,weekNum desc ";
		String hql2 = " from GrepUserInfo where proWonTime >? order by proWonNum/proNum desc,proNum desc ";
		String hql3 = " from GrepUserInfo where proWonTime >? and hotPerson = 1 order by weekWonNum/weekNum desc,weekNum desc ";
		List<GrepUserInfo> weeklist =grepUserInfoService.find(hql1, new Object[]{DateUtil.calDate(new Date(),0,0,-7)});
		List<GrepUserInfo> porlist =grepUserInfoService.find(hql2, new Object[]{DateUtil.calDate(new Date(),0,0,-7)});
		List<GrepUserInfo> hotlist =grepUserInfoService.find(hql3, new Object[]{DateUtil.calDate(new Date(),0,0,-7)});
		if(hotlist ==null){
			hotlist = new ArrayList<GrepUserInfo>();
		}
		int fw = 10;
		if(weeklist!=null&&porlist!=null){
			if(weeklist.size()<10||porlist.size()<10){
				fw = weeklist.size()> porlist.size()?porlist.size():weeklist.size();
			}
			for (int i = 0; i < fw; i++) {
				for (int j = 0; j < fw; j++) {
					if(weeklist.get(i).getUid().equals(porlist.get(j).getUid())){
						if(!hotlist.contains(weeklist.get(i))){
							hotlist.add(weeklist.get(i));
						}
					}
				}
			}
			if(!hotlist.contains(weeklist.get(0))){
				hotlist.add(weeklist.get(0));
			}
			if(!hotlist.contains(porlist.get(0))){
				hotlist.add(porlist.get(0));
			}
		}
		List<String> list = new ArrayList<String>();
		for (GrepUserInfo grepUserInfo : hotlist) {
			list.add("'"+grepUserInfo.getUid()+"'");
		}
		String uids = StringUtils.join( list.toArray(),",");
		String hql = " from GrepProjectInfo where uid in ("+uids+") and endTime >? order by endTime,uid ";
		List<GrepProjectInfo> projectlist =grepProjectInfoService.find(hql, new Object[]{DateUtil.calDate(new Date(),0,0,0,0,30,0)});
		
		for (GrepProjectInfo grepProjectInfo : projectlist) {
			for (GrepUserInfo grepUserInfo : hotlist) {
				if(grepUserInfo.getUid().equals(grepProjectInfo.getUid())){
					grepProjectInfo.setHotPerson(grepUserInfo.isHotPerson());
				}
			}
		}
		modelMap.addAttribute("projectlist", projectlist);
		return "/test/chooseProjectList.ftl";
	}
	
	public static void main(String[] args) {
		String startDate = DateUtil.dateToStr(new Date(),"yyyy-MM-dd")+" 10:00";
		String endDate = DateUtil.dateToStr(DateUtil.calDate(new Date(),0,0,1),"yyyy-MM-dd")+" 10:00";
		System.out.println(startDate);
		System.out.println(endDate);
	}
    
}
