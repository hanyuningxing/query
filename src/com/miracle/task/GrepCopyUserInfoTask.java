package com.miracle.task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.miracle.model.user.GrepMatchInfo;
import com.miracle.model.user.GrepProjectInfo;
import com.miracle.model.user.GrepUserInfo;
import com.miracle.service.user.GrepMatchInfoService;
import com.miracle.service.user.GrepProjectInfoService;
import com.miracle.service.user.GrepUserInfoService;
import com.miracle.utils.DateUtil;

@Service
@Transactional
public class GrepCopyUserInfoTask {
	private List<GrepUserInfo> userList = new ArrayList<GrepUserInfo>();
	@Autowired
	private GrepUserInfoService grepUserInfoService;
	@Autowired
	private GrepProjectInfoService grepProjectInfoService;
	@Autowired
	private GrepMatchInfoService grepMatchInfoService;
	
	/**
	 * 1 定时任务 获取用户
	 */
	public void getGrepUserInfos(){
		String url = "http://www.159cai.com/cpdata/";
		System.out.println(DateUtil.dateToStr(new Date())+"------grepUser定时任务开始-------");
		getUserInfos(url+"phot/31/hitWeekUsers.json","week");
		getUserInfos(url+"phot/31/hitMonthUsers.json","month");
		getUserInfos(url+"copy/redUserList.json","redUser");
		System.out.println(DateUtil.dateToStr(new Date())+"------grepUser定时任务结束-------");
	}
	private final void getUserInfos(String url,String type) {
		userList.clear();
		try{
			String result = getInfosByUrl(url);
			JSONArray jsonArray = JSONArray.fromObject(result);
			for (Object object : jsonArray) {
				String uid = JSONObject.fromObject(object).getString("uid");
				int allnum = JSONObject.fromObject(object).getInt("allnum");
				int hitnum = JSONObject.fromObject(object).getInt("hitnum");
				boolean ishot =false;
				if(JSONObject.fromObject(object).has("ishot")){
					ishot =JSONObject.fromObject(object).getInt("ishot")==1?true:false;
				}
				GrepUserInfo grepUser = grepUserInfoService.getGrepUserInfo("uid", uid);
				if(grepUser!=null){
					if(DateUtil.dateToStr(grepUser.getLastModifyTime(),"yyyy-MM-dd").equals(DateUtil.dateToStr(new Date(),"yyyy-MM-dd"))){
						continue;
					}
					if(type.equals("week")){
						grepUser.setWeekNum(allnum);
						grepUser.setWeekWonNum(hitnum);
					}else if(type.equals("month")){
						grepUser.setProNum(allnum);
						grepUser.setProWonNum(hitnum);
					}else{
						grepUser.setWeekNum(allnum);
						grepUser.setWeekWonNum(hitnum);
						ishot =true;
						grepUser.setWonNum(JSONObject.fromObject(object).getInt("lznum"));
					}
					grepUser.setHotPerson(ishot);
				}else{
					grepUser = new GrepUserInfo();
					grepUser.setUid(uid);
					grepUser.setCreateTime(new Date());
					if(type.equals("week")){
						grepUser.setWeekNum(allnum);
						grepUser.setWeekWonNum(hitnum);
					}else if(type.equals("month")){
						grepUser.setProNum(allnum);
						grepUser.setProWonNum(hitnum);
					}else{
						grepUser.setWeekNum(allnum);
						grepUser.setWeekWonNum(hitnum);
						ishot =true;
						grepUser.setWonNum(JSONObject.fromObject(object).getInt("lznum"));
					}
					grepUser.setHotPerson(ishot);
				}
				grepUser.setLastModifyTime(new Date());
//				userList.add(grepUser);
				grepUserInfoService.saveGrepUserInfo(grepUser);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * 2 定时任务 获取方案
	 */
	public void getGrepProjectInfos(){
		String url = "http://www.159cai.com/cpdata/copy/jczq_hot_List.json";
		System.out.println(DateUtil.dateToStr(new Date())+"------grepProject定时任务开始-------");
		try{
			String result = getInfosByUrl(url);
			JSONArray jsonArray = JSONArray.fromObject(result);
			int count =0;
			for (Object filterObj : jsonArray) {
				int lznum = JSONObject.fromObject(filterObj).getInt("lznum");
				int allnum = JSONObject.fromObject(filterObj).getInt("allnum");
				int hitnum = JSONObject.fromObject(filterObj).getInt("hitnum");
				boolean ishot =false;
				if(JSONObject.fromObject(filterObj).has("ishot")){
					ishot =JSONObject.fromObject(filterObj).getInt("ishot")==1?true:false;
				}
				int hitRate =0;
				if(allnum>0){
					BigDecimal b1 = new BigDecimal(allnum);
					BigDecimal b2 = new BigDecimal(hitnum);
					hitRate = b2.divide(b1,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).intValue();
				}
				if((hitRate>80&&hitnum>4)||lznum>2||ishot){
					saveProjectInfos(filterObj);
					count++;
				}
			}
			System.out.println("共有方案"+count);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------grepProject定时任务结束-------");
	}
	
	private void saveProjectInfos(Object object){
		String[] gid_planNo = JSONObject.fromObject(object).getString("projid").split("_");
		String gid =gid_planNo[0];
		String planNo = gid_planNo[1];
		String uid = JSONObject.fromObject(object).getString("uid");
		String lznum = JSONObject.fromObject(object).getString("lznum");
		int allnum = JSONObject.fromObject(object).getInt("allnum");
		int hitnum = JSONObject.fromObject(object).getInt("hitnum");
		boolean ishot =false;
		if(JSONObject.fromObject(object).has("ishot")){
			ishot =JSONObject.fromObject(object).getInt("ishot")==1?true:false;
		}
		GrepUserInfo grepUser = grepUserInfoService.getGrepUserInfo("uid", uid);
		if(grepUser!=null){
			grepUser.setWonNum(Integer.valueOf(lznum));
			grepUser.setWeekNum(allnum);
			grepUser.setWeekWonNum(hitnum);
			grepUser.setHotPerson(ishot);
		}else{
			grepUser = new GrepUserInfo();
			grepUser.setUid(uid);
			grepUser.setCreateTime(new Date());
			grepUser.setWonNum(Integer.valueOf(lznum));
			grepUser.setWeekNum(allnum);
			grepUser.setWeekWonNum(hitnum);
			grepUser.setHotPerson(ishot);
		}
		grepUser.setLastModifyTime(new Date());
		grepUserInfoService.saveGrepUserInfo(grepUser);
		String codes = ""; 
		String endtime = JSONObject.fromObject(object).getString("cendtime");
		String pid = DateUtil.dateToStr(DateUtil.strToDate(endtime, "yyyy-MM-dd"), "yyyyMMdd"); 
		String money = JSONObject.fromObject(object).getString("itmoney");
		String perMoney = JSONObject.fromObject(object).getString("perMoney");
		int mulity = Integer.valueOf(money)/Integer.valueOf(perMoney);
		GrepProjectInfo grepProjectInfo = grepProjectInfoService.getGrepProjectInfo("projectId", planNo);
		if(grepProjectInfo!=null){
			return;
		}
		String url = "http://www.159cai.com/cpdata/guoguan/"+gid+"/"+pid+"/pass/"+planNo+".json";
		String result = getInfosByUrl(url);
		JSONObject rows = JSONObject.fromObject(result).getJSONObject("rows");
		JSONArray proArray = new JSONArray();
		if(rows.get("row") instanceof JSONArray){
			proArray = rows.getJSONArray("row");
		}else{
			proArray.add(rows.getJSONObject("row"));
		}
		if(proArray.size()>3){
			return;
		}
		for (Object proj : proArray) {
			String code = JSONObject.fromObject(proj).getString("code");
			transCodes(code,uid);
			codes += code+";";
		}
		if(codes.contains(";")){
			codes = codes.substring(0, codes.length()-1);
		}
		if(StringUtils.isEmpty(codes)){
			return;
		}
		grepProjectInfo = new GrepProjectInfo();
		grepProjectInfo.setPid(pid);
		grepProjectInfo.setGid(gid);
		grepProjectInfo.setCreateTime(new Date());
		grepProjectInfo.setCode(codes);
		grepProjectInfo.setEndTime(DateUtil.strToDate(endtime, "yyyy-MM-dd hh:mm:ss"));
		grepProjectInfo.setMoeny(Double.valueOf(money));
		grepProjectInfo.setMultiple(mulity);
		grepProjectInfo.setUid(uid);
		grepProjectInfo.setProjectId(planNo);
		grepProjectInfoService.saveGrepProjectInfo(grepProjectInfo);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 3 定时任务 获取是否中奖
	 */
	public void getGrepProjectAwardInfos(){
		String url = "";
		System.out.println(DateUtil.dateToStr(new Date())+"------getGrepProjectAwardInfos定时任务开始-------");
		DetachedCriteria criteria = DetachedCriteria.forClass(GrepProjectInfo.class);
		criteria.add(Restrictions.isNull("wonFlag"));
		criteria.add(Restrictions.lt("endTime",DateUtil.calDate(new Date(),0,0,-1)));
		List<GrepProjectInfo> list = grepProjectInfoService.findByDetachedCriteria(criteria, 0, 10);
		String gid ="";
		String pid ="";
		String planNo ="";
		for (GrepProjectInfo grepProjectInfo : list) {
			gid =grepProjectInfo.getGid();
			pid =grepProjectInfo.getPid();
			planNo =grepProjectInfo.getProjectId();
			System.out.println(DateUtil.dateToStr(new Date())+"------【"+grepProjectInfo.getProjectId()+"】开始请求");
			url = "http://www.159cai.com/cpdata/guoguan/"+gid+"/"+pid+"/pass/"+planNo+".json";
			String result = getInfosByUrl(url);
			JSONArray proArray = JSONObject.fromObject(result).getJSONObject("rows").getJSONArray("row");
			int wonFlag = 0;//未中奖，空未处理
			for (Object object : proArray) {
				String tax = JSONObject.fromObject(object).getString("tax");
				if(Double.valueOf(tax)>0){
					wonFlag = 1;//中奖
				}
			}
			grepProjectInfo.setWonFlag(wonFlag);
			grepProjectInfoService.saveGrepProjectInfo(grepProjectInfo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------getGrepProjectAwardInfos定时任务结束-------");
	}


	/**
	 * 设置投注支持比率
	 * @param codes
	 */
	private final void transCodes(String codes,String uid) {
		//131105001>RSPF=3+JQS=1+CBF=1:0,131105002>SPF=3/1+RSPF=1/0+JQS=1
		String[] contents = codes.split("\\|");
		String[] items = null;
		if(contents[1].indexOf(",")>-1){
			items = contents[1].split(",");
		}else{
			items = new String[]{contents[1]};
		}
		for (String item : items) {
			String [] item_parts = item.split(">");
			String[] chooseItems = null;
			if(item_parts[1].indexOf("+")>-1){
				chooseItems =  item_parts[1].split("\\+");
			}else{
				chooseItems =  new String[]{item_parts[1]};
			}
			for (String choose : chooseItems) {
				String[] chs = choose.split("=");
				if(chs[0].equals("SPF")||chs[0].equals("RSPF")){
					String matchId = item_parts[0];
					GrepMatchInfo grepMatchInfo = grepMatchInfoService.getGrepMatchInfo("matchId", matchId);
					if(grepMatchInfo==null){
						grepMatchInfo = new GrepMatchInfo();
						grepMatchInfo.setCreateTime(new Date());
						grepMatchInfo.setMatchId(matchId);
					}
					grepMatchInfo.setLastModifyTime(new Date());
					if(chs[0].equals("SPF")){
						//RSPF=1/0
						if(chs[1].contains("3")){
							grepMatchInfo.setSpf3((grepMatchInfo.getSpf3()==null?0:grepMatchInfo.getSpf3())+1);
						}else if(chs[1].contains("1")){
							grepMatchInfo.setSpf1((grepMatchInfo.getSpf1()==null?0:grepMatchInfo.getSpf1())+1);
						}else if(chs[1].contains("0")){
							grepMatchInfo.setSpf0((grepMatchInfo.getSpf0()==null?0:grepMatchInfo.getSpf0())+1);
						}
					}else if(chs[0].equals("RSPF")){
						if(chs[1].contains("3")){
							grepMatchInfo.setRspf3((grepMatchInfo.getRspf3()==null?0:grepMatchInfo.getRspf3())+1);
						}else if(chs[1].contains("1")){
							grepMatchInfo.setRspf1((grepMatchInfo.getRspf1()==null?0:grepMatchInfo.getRspf1())+1);
						}else if(chs[1].contains("0")){
							grepMatchInfo.setRspf0((grepMatchInfo.getRspf0()==null?0:grepMatchInfo.getRspf0())+1);
						}
					}
					grepMatchInfoService.saveGrepMatchInfo(grepMatchInfo);
				}
			}
			
		}
	}
	
	/**
	 *4 定时任务 获取对阵赛果
	 */
	public void getMatchScore() {
		String pid = DateUtil.dateToStr(DateUtil.calDate(new Date(),0,0,-1), "yyMMdd");
//		String pid ="160817";
		String url = "http://www.159cai.com/cpdata/match/jczq/award/"+pid+"/"+pid+".json";
		HttpURLConnection connection = null;
		try{
			URL getUrl = new URL(url); 
			connection = (HttpURLConnection) getUrl.openConnection();
			connection.connect(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
			StringBuffer buffer = new StringBuffer();
			String lines;
			while ((lines = reader.readLine()) != null) { 
				buffer.append(lines);
			}
			reader.close(); 
			connection.disconnect();
		
			JSONArray jsonArray = JSONObject.fromObject(buffer.toString()).getJSONObject("rows").getJSONArray("row");
			for (Object object : jsonArray) {
				String tid = JSONObject.fromObject(object).getString("tid");
				String ms = JSONObject.fromObject(object).getString("ms");
				String ss = JSONObject.fromObject(object).getString("ss");
				String lose = JSONObject.fromObject(object).getString("lose");
				GrepMatchInfo grepMatch = grepMatchInfoService.getGrepMatchInfo("matchId", tid);
				if(grepMatch!=null){
					grepMatch.setHomeScore(Integer.valueOf(ms));
					grepMatch.setGuestScore(Integer.valueOf(ss));
					grepMatch.setLose(Integer.valueOf(lose));
					int value = Integer.valueOf(ms)-Integer.valueOf(ss);
					int rvalue = Integer.valueOf(ms)+Integer.valueOf(lose)-Integer.valueOf(ss);
					boolean flag = false;
					boolean oflag = false;
					List<String> list = grepMatch.getMaxValue();
					for (String cv : list) {
						if(cv.equals("SPF=3")&&value>0){
							flag = true;
						}else if(cv.equals("SPF=1")&&value==0){
							flag = true;
						}else if(cv.equals("SPF=0")&&value<0){
							flag = true;
						}
						if(cv.equals("RSPF=3")&&rvalue>0){
							flag = true;
						}else if(cv.equals("RSPF=1")&&rvalue==0){
							flag = true;
						}else if(cv.equals("RSPF=0")&&rvalue<0){
							flag = true;
						}
					}
					grepMatch.setFlag(flag);
					List<String> olist = grepMatch.getOMaxValue();
					for (String cv : olist) {
						if(cv.equals("SPF=3")&&value>0){
							oflag = true;
						}else if(cv.equals("SPF=1")&&value==0){
							oflag = true;
						}else if(cv.equals("SPF=0")&&value<0){
							oflag = true;
						}
						if(cv.equals("RSPF=3")&&rvalue>0){
							oflag = true;
						}else if(cv.equals("RSPF=1")&&rvalue==0){
							oflag = true;
						}else if(cv.equals("RSPF=0")&&rvalue<0){
							oflag = true;
						}
					}
					grepMatch.setOflag(oflag);
					grepMatchInfoService.saveGrepMatchInfo(grepMatch);
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	/**
	 * 5 定时任务 发单
	 */
	public void chooseProjectsToBuy(){
		System.out.println(DateUtil.dateToStr(new Date())+"------chooseProjectsToBuy定时任务开始-------");
		
		List<GrepMatchInfo> hotMatchList = getHotMatchsToBuy();
		List<GrepProjectInfo> hotProjectlist =new ArrayList<GrepProjectInfo>();
		String hql = " from GrepProjectInfo where endTime >? ";
		List<GrepProjectInfo> projectlist =grepProjectInfoService.find(hql, new Object[]{DateUtil.calDate(new Date(),0,0,0,0,30,0)});
		for (GrepProjectInfo grepProjectInfo : projectlist) {
			//一注方案小于10才发起
//			if(grepProjectInfo.getMoeny()/grepProjectInfo.getMultiple()<10){
				String codes = grepProjectInfo.getCode();
//				System.out.println(codes);
				//131105001>RSPF=3+JQS=1+CBF=1:0,131105002>SPF=3/1+RSPF=1/0+JQS=1
				//将上例转化为SPF=3,SPF=1的集合与matchInfo中选择最多的对比，若满足是最多选择则表示可以投注
				codes = codes.replaceAll("\\(.*?\\)", "");
				String[] cds = codes.split(";");
				for (String code : cds) {
					String[] contents = code.split("\\|");
					String[] items = null;
					if(contents[1].indexOf(",")>-1){
						items = contents[1].split(",");
					}else{
						items = new String[]{contents[1]};
					}
					for (String item : items) {
						String [] item_parts = item.split(">");
						String matchId = item_parts[0];
						for (GrepMatchInfo grepMatchInfo : hotMatchList) {
							List<String> list = grepMatchInfo.getMaxValue();
							if(grepMatchInfo.getMatchId().equals(matchId)){
								String[] chooseItems = null;
								if(item_parts[1].indexOf("+")>-1){
									chooseItems =  item_parts[1].split("\\+");
								}else{
									chooseItems =  new String[]{item_parts[1]};
								}
								String[] choose = null;
								for (String chooses : chooseItems) {
									String[] chs = chooses.split("=");
									if(chs[1].indexOf("/")>-1){
										String[] cs = chs[1].split("/");
										//转化为SPF=3,SPF=1
										choose = new String[cs.length];
										for (int i = 0; i < cs.length; i++) {
											choose[i] = chs[0]+"="+cs[i];
										} 
									}else{
										choose = new String[]{chooses};
									}
									for (String cv : choose) {
										for (String v : list) {
//											System.out.println("--------"+matchId+"-"+v);
											if(cv.equals(v)){
												if(!hotProjectlist.contains(grepProjectInfo)){
													hotProjectlist.add(grepProjectInfo);
													grepProjectInfo.setSend(true);
												}
												
											}
										}
									}
								}
							}
						}
					}
				}
//			}
		}
		
		for (GrepProjectInfo projectInfo : hotProjectlist) {
			System.out.println(projectInfo.getProjectId());
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------chooseProjectsToBuy定时任务结束-------");
	}
	
	
	private List<GrepMatchInfo> getHotMatchsToBuy(){
		String hql = " from GrepMatchInfo where homeScore is null and (spf3+spf1+spf0+rspf3+rspf1+rspf0)> 1 order by (spf3+spf1+spf0+rspf3+rspf1+rspf0) desc ";
		List<GrepMatchInfo> hotMatchlist =grepMatchInfoService.find(hql, null);
		return hotMatchlist;
	}
	

	private String getInfosByUrl(String url){
		HttpURLConnection connection = null;
		String result = "";
		try{
			URL getUrl = new URL(url); 
			connection = (HttpURLConnection) getUrl.openConnection();
			connection.connect(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
			StringBuffer buffer = new StringBuffer();
			String lines;
			while ((lines = reader.readLine()) != null) { 
				buffer.append(lines);
			}
			reader.close(); 
			connection.disconnect();
//			System.out.println(buffer.toString());
			result =buffer.toString();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
//		String pid = DateUtil.dateToStr(DateUtil.calDate(new Date(),0,0,0,0,30,0), "yyyyMMdd-hhmmss");
//		System.out.println(pid);
//		GrepMatchInfo grepMatchInfo = new GrepMatchInfo();
//		grepMatchInfo.setSpf3(0);
//		grepMatchInfo.setSpf1(0);
//		grepMatchInfo.setSpf0(2);
//		grepMatchInfo.setRspf3(1);
//		grepMatchInfo.setRspf1(3);
//		grepMatchInfo.setRspf0(6);
//		List<String> list = grepMatchInfo.getOMaxValue();
//		for (String v : list) {
//			System.out.println(v);
//		}
		String ss = "HH|170305006>SPF=1(2.95),170305007>RSPF=0(1.41)|2*1";
		ss= ss.replaceAll("\\(.*?\\)", "");
		String[] cds = ss.split(";");
		System.out.println(DateUtil.dateToStr(DateUtil.strToDate("2017-03-07 23:50:00", "yyyy-MM-dd"), "yyyyMMdd"));
	}
}
