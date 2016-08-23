package com.miracle.task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.miracle.model.user.GrepMatchInfo;
import com.miracle.model.user.GrepProjectInfo;
import com.miracle.model.user.GrepUserInfo;
import com.miracle.service.user.GrepMatchInfoService;
import com.miracle.service.user.GrepProjectInfoService;
import com.miracle.service.user.GrepUserInfoService;
import com.miracle.utils.DateUtil;

@Service
@Transactional
public class GrepUserInfoTask {

	@Autowired
	private GrepUserInfoService grepUserInfoService;
	@Autowired
	private GrepProjectInfoService grepProjectInfoService;
	@Autowired
	private GrepMatchInfoService grepMatchInfoService;
	
	/**
	 * 定时任务 获取用户
	 */
	public void getGrepUserInfos(){
		String url = "http://www.159cai.com/cpdata/paihang/";
		System.out.println(DateUtil.dateToStr(new Date())+"------grepUser定时任务开始-------");
		getUserInfos(url+"00_today.json");
		System.out.println(DateUtil.dateToStr(new Date())+"------grepUser定时任务结束-------");
	}
	
	public void getWeekUserInfos() {
		String url = "http://mapi.159cai.com/phoneRecord.php?version=99&user=159ceshi&password=911d430ee303815d753125cc9a435e70&result=mob_hot&type=70&newValue=10";
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
			System.out.println(buffer.toString());
			JSONArray jsonArray = JSONArray.fromObject(buffer.toString());
			for (Object object : jsonArray) {
				String uid = JSONObject.fromObject(object).getString("cnickid");
				String money = JSONObject.fromObject(object).getString("imoney");
				GrepUserInfo grepUser = grepUserInfoService.getGrepUserInfo("uid", uid);
				if(grepUser!=null){
					if(DateUtil.dateToStr(grepUser.getLastModifyTime(),"yyyy-MM-dd").equals(DateUtil.dateToStr(new Date(),"yyyy-MM-dd"))){
						continue;
					}
					grepUser.setWonMoeny(grepUser.getWonMoeny()+Double.valueOf(money));
					grepUser.setWonNum(grepUser.getWonNum()+1);
				}else{
					grepUser = new GrepUserInfo();
					grepUser.setUid(uid);
					grepUser.setCreateTime(new Date());
					grepUser.setWonMoeny(Double.valueOf(money));
					grepUser.setWonNum(1);
					grepUser.setProNum(0);
					grepUser.setProWonNum(0);
				}
				grepUser.setLastModifyTime(new Date());
				grepUserInfoService.saveGrepUserInfo(grepUser);
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
	 * 定时任务 获取方案
	 */
	public void getGrepProjectInfos(){
		String url = "http://mapi.159cai.com/phoneRecord.php?version=31&user=159ceshi&password=911d430ee303815d753125cc9a435e70&result=mob_canbuy&type=70&newValue=";
		System.out.println(DateUtil.dateToStr(new Date())+"------grepProject定时任务开始-------");
		List<GrepUserInfo> list = grepUserInfoService.findCanBuyUser();
		int num = 0;
		for (GrepUserInfo grepUserInfo : list) {
			System.out.println(DateUtil.dateToStr(new Date())+"------【"+grepUserInfo.getUid()+"】开始请求");
			getProjectInfos(url,grepUserInfo.getUid());
			num ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------grepProject定时任务结束-------共："+num);
	}
	
	public void getHotUserProjectInfos(){
		String url = "http://mapi.159cai.com/phoneRecord.php?version=31&user=159ceshi&password=911d430ee303815d753125cc9a435e70&result=mob_canbuy&type=70&newValue=";
		System.out.println(DateUtil.dateToStr(new Date())+"------getHotUserProjectInfos定时任务开始-------");
		List<GrepUserInfo> list = getHotUserToBuy();
		int num = 0;
		for (GrepUserInfo grepUserInfo : list) {
			System.out.println(DateUtil.dateToStr(new Date())+"------【"+grepUserInfo.getUid()+"】开始请求");
			getProjectInfos(url,grepUserInfo.getUid());
			num ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------getHotUserProjectInfos定时任务结束------共："+num);
	}
	
	/**
	 * 定时任务 获取是否中奖
	 */
	public void getGrepProjectAwardInfos(){
		String url = "http://mapi.159cai.com/phoneRecord.php?version=31&user=159ceshi&password=911d430ee303815d753125cc9a435e70&result=mob_award&type=70&newValue=";
		System.out.println(DateUtil.dateToStr(new Date())+"------getGrepProjectAwardInfos定时任务开始-------");
		DetachedCriteria criteria = DetachedCriteria.forClass(GrepProjectInfo.class);
		criteria.add(Restrictions.isNull("wonFlag"));
		criteria.add(Restrictions.lt("endTime",DateUtil.calDate(new Date(),0,0,-1)));
		List<GrepProjectInfo> list = grepProjectInfoService.findByDetachedCriteria(criteria, 0, 10);
		for (GrepProjectInfo grepProjectInfo : list) {
			System.out.println(DateUtil.dateToStr(new Date())+"------【"+grepProjectInfo.getProjectId()+"】开始请求");
			getProjectAwardInfos(url,grepProjectInfo.getProjectId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------getGrepProjectAwardInfos定时任务结束-------");
	}
	
	
	/**
	 * 获取用户信息
	 * @param url
	 */
	private final void getUserInfos(String url) {
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
				String uid = JSONObject.fromObject(object).getString("cnickid");
				String money = JSONObject.fromObject(object).getString("imoney");
				GrepUserInfo grepUser = grepUserInfoService.getGrepUserInfo("uid", uid);
				if(grepUser!=null){
					if(DateUtil.dateToStr(grepUser.getLastModifyTime(),"yyyy-MM-dd").equals(DateUtil.dateToStr(new Date(),"yyyy-MM-dd"))){
						continue;
					}
					grepUser.setWonMoeny(grepUser.getWonMoeny()+Double.valueOf(money));
					grepUser.setWonNum(grepUser.getWonNum()+1);
				}else{
					grepUser = new GrepUserInfo();
					grepUser.setUid(uid);
					grepUser.setCreateTime(new Date());
					grepUser.setWonMoeny(Double.valueOf(money));
					grepUser.setWonNum(1);
					grepUser.setProNum(0);
					grepUser.setProWonNum(0);
				}
				grepUser.setLastModifyTime(new Date());
				grepUserInfoService.saveGrepUserInfo(grepUser);
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
	 * 获取方案信息
	 * @param url
	 * @param uid
	 */
	private final void getProjectInfos(String url,String uid) {
		HttpURLConnection connection = null;
		try{
			URL getUrl = new URL(url+uid); 
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
			System.out.println(buffer.toString());
			JSONArray jsonArray = JSONArray.fromObject(buffer.toString());
			for (Object object : jsonArray) {
				String planNo = JSONObject.fromObject(object).getString("planNo");
				String gid = JSONObject.fromObject(object).getString("gid"); 
				String codes = JSONObject.fromObject(object).getString("codes"); 
				String pid = JSONObject.fromObject(object).getString("termNo"); 
				String money = JSONObject.fromObject(object).getString("money");
				String mulity = JSONObject.fromObject(object).getString("mulity");
				String endtime = JSONObject.fromObject(object).getString("endtime");
				GrepProjectInfo grepProjectInfo = grepProjectInfoService.getGrepProjectInfo("projectId", planNo);
				if(grepProjectInfo!=null){
					continue;
				}
				grepProjectInfo = new GrepProjectInfo();
				grepProjectInfo.setPid(pid);
				grepProjectInfo.setGid(gid);
				grepProjectInfo.setCreateTime(new Date());
				grepProjectInfo.setCode(codes);
				grepProjectInfo.setEndTime(DateUtil.strToDate(endtime, "yyyy-MM-dd hh:mm:ss"));
				grepProjectInfo.setMoeny(Double.valueOf(money));
				grepProjectInfo.setMultiple(Integer.valueOf(mulity));
				grepProjectInfo.setUid(uid);
				grepProjectInfo.setProjectId(planNo);
				grepProjectInfoService.saveGrepProjectInfo(grepProjectInfo);
				
				transCodes(codes,uid);
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
	
	public void getRealMatchChooses(){
		System.out.println(DateUtil.dateToStr(new Date())+"------getRealMatchChooses定时任务结束-------");
//		String hql1 = " from GrepProjectInfo where  endTime >=? and endTime <? order by uid";
//		Date startDate = DateUtil.strToDate(DateUtil.dateToStr(new Date(),"yyyy-MM-dd")+" 10:00:00");
//		Date endDate = DateUtil.strToDate(DateUtil.dateToStr(DateUtil.calDate(new Date(),0,0,1),"yyyy-MM-dd")+" 10:00:00");
//		List<GrepProjectInfo> projectlist =grepProjectInfoService.find(hql1, new Object[]{startDate,endDate});
		String hql1 = " from GrepProjectInfo where  flag =0 order by uid";
//		Date startDate = DateUtil.strToDate(DateUtil.dateToStr(new Date(),"yyyy-MM-dd")+" 10:00:00");
		List<GrepProjectInfo> projectlist =grepProjectInfoService.find(hql1, new Object[]{});
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		
		List<String> list = new ArrayList<String>();
		for (GrepProjectInfo grepProjectInfo : projectlist) {
			if(map.containsKey(grepProjectInfo.getUid())){
				list = map.get(grepProjectInfo.getUid());
				if(!list.contains(grepProjectInfo.getCode())){
					list.add(grepProjectInfo.getCode());
				}
			}else{
				list = new ArrayList<String>();
				list.add(grepProjectInfo.getCode());
				map.put(grepProjectInfo.getUid(), list);
			}
			grepProjectInfo.setFlag(true);//同步
		}
		 for (Map.Entry<String, List<String>> entry : map.entrySet()) { 
			 transCodes(entry.getValue());
		 }
		 System.out.println(DateUtil.dateToStr(new Date())+"------getRealMatchChooses定时任务结束-------");
	}
	
	private void transCodes(List<String> list) {
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		for (String codes : list) {
			transCodes(codes, map);
		}
		for (Map.Entry<String, List<String>> entry : map.entrySet()) { 
			List<String> pidcodes =  entry.getValue();
			String matchId = entry.getKey();
			GrepMatchInfo grepMatchInfo = grepMatchInfoService.getGrepMatchInfo("matchId", matchId);
			if(grepMatchInfo==null){
				grepMatchInfo = new GrepMatchInfo();
				grepMatchInfo.setCreateTime(new Date());
				grepMatchInfo.setMatchId(matchId);
			}
			for (String vs : pidcodes) {
				if(vs.equals("spf3")){
					grepMatchInfo.setOspf3((grepMatchInfo.getOspf3()==null?0:grepMatchInfo.getOspf3())+1);
				}else if(vs.equals("spf1")){
					grepMatchInfo.setOspf1((grepMatchInfo.getOspf1()==null?0:grepMatchInfo.getOspf1())+1);
				}else if(vs.equals("spf0")){
					grepMatchInfo.setOspf0((grepMatchInfo.getOspf0()==null?0:grepMatchInfo.getOspf0())+1);
				}else if(vs.equals("rspf3")){
					grepMatchInfo.setOrspf3((grepMatchInfo.getOrspf3()==null?0:grepMatchInfo.getOrspf3())+1);
				}else if(vs.equals("rspf1")){
					grepMatchInfo.setOrspf1((grepMatchInfo.getOrspf1()==null?0:grepMatchInfo.getOrspf1())+1);
				}else if(vs.equals("rspf0")){
					grepMatchInfo.setOrspf0((grepMatchInfo.getOrspf0()==null?0:grepMatchInfo.getOrspf0())+1);
				}
			}
			grepMatchInfoService.saveGrepMatchInfo(grepMatchInfo);
		 }
	}
	
	private void transCodes(String codes,Map<String,List<String>> map) {
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
			
			List<String> vcodes = new ArrayList<String>();
			
			String[] chooseItems = null;
			if(item_parts[1].indexOf("+")>-1){
				chooseItems =  item_parts[1].split("\\+");
			}else{
				chooseItems =  new String[]{item_parts[1]};
			}
			for (String choose : chooseItems) {
				String[] chs = choose.split("=");
				if(chs[0].equals("SPF")||chs[0].equals("RSPF")){
					String matchId = item_parts[0];//131105001
					
					if(map.containsKey(matchId)){
						vcodes = map.get(matchId);
					}
					
					if(chs[0].equals("SPF")){
						//RSPF=1/0
						if(chs[1].contains("3")){
							if(!vcodes.contains("spf3")){
								vcodes.add("spf3");
							}
						}else if(chs[1].contains("1")){
							if(!vcodes.contains("spf1")){
								vcodes.add("spf1");
							}
						}else if(chs[1].contains("0")){
							if(!vcodes.contains("spf0")){
								vcodes.add("spf0");
							}
						}
					}else if(chs[0].equals("RSPF")){
						if(chs[1].contains("3")){
							if(!vcodes.contains("rspf3")){
								vcodes.add("rspf3");
							}
						}else if(chs[1].contains("1")){
							if(!vcodes.contains("rspf1")){
								vcodes.add("rspf1");
							}
						}else if(chs[1].contains("0")){
							if(!vcodes.contains("rspf0")){
								vcodes.add("rspf0");
							}
						}
					}
					
					if(!map.containsKey(matchId)){
						if(vcodes!=null&&vcodes.size()>0){
							map.put(matchId, vcodes);
						}
					}
				}
			}
			
		}
	}
	
	/**
	 *定时任务 获取对阵赛果
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
	 * 获取方案中奖信息
	 * @param url
	 * @param planNo
	 */
	private final void getProjectAwardInfos(String url,String planNo) {
		
		HttpURLConnection connection = null;
		try{
			URL getUrl = new URL(url+planNo); 
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
			System.out.println(buffer.toString());
			JSONArray jsonArray = JSONArray.fromObject(buffer.toString());
			for (Object object : jsonArray) {
				String bonus = JSONObject.fromObject(object).getString("bonus");
				GrepProjectInfo grepProjectInfo = grepProjectInfoService.getGrepProjectInfo("projectId", planNo);
				if(grepProjectInfo==null){
					continue;
				}
				int wonFlag = 0;//未中奖，空未处理
				if(Double.valueOf(bonus)>0){
					wonFlag = 1;//中奖
				}
				grepProjectInfo.setWonFlag(wonFlag);
				grepProjectInfoService.saveGrepProjectInfo(grepProjectInfo);
				
				GrepUserInfo grepUser = grepUserInfoService.getGrepUserInfo("uid", grepProjectInfo.getUid());
				if(grepUser!=null){
					grepUser.setProNum(grepUser.getProNum()+1);
					if(wonFlag==1){
						grepUser.setProWonNum(grepUser.getProWonNum()+1);
						grepUser.setProWonTime(new Date());
					}
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
	 * 定时任务 统计一周中奖数据
	 */
	public void getProjectAwardWeekInfos(){
		System.out.println(DateUtil.dateToStr(new Date())+"------getProjectAwardWeekInfos定时任务开始-------");
		DetachedCriteria criteria = DetachedCriteria.forClass(GrepProjectInfo.class);
		criteria.add(Restrictions.isNotNull("wonFlag"));
		criteria.add(Restrictions.gt("endTime",DateUtil.calDate(new Date(),0,0,-7)));
		ProjectionList plist=Projections.projectionList();
		/*plist.add(Projections.property("uid"));*/
		plist.add(Projections.count("id"));
		plist.add(Projections.sum("wonFlag"));
		plist.add(Projections.groupProperty("uid"));//属性
		criteria.setProjection(plist);
		
		List<Object[]> list = grepProjectInfoService.findByDetachedCriteria(criteria);
		for (Object[] objs : list) {
			GrepUserInfo grepUser = grepUserInfoService.getGrepUserInfo("uid", objs[2]);
			if(grepUser!=null){
				grepUser.setWeekNum(Integer.valueOf(String.valueOf(objs[0])));
				grepUser.setWeekWonNum(Integer.valueOf(String.valueOf(objs[1])));
				grepUser.setWeekTime(new Date());
			}
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------getProjectAwardWeekInfos定时任务结束-------");
	}
	
	/**
	 * 定时任务 发单
	 */
	public void chooseProjectsToBuy(){
		System.out.println(DateUtil.dateToStr(new Date())+"------chooseProjectsToBuy定时任务开始-------");
		
		List<GrepMatchInfo> hotMatchList = getHotMatchsToBuy();
		
		List<GrepUserInfo> hotlist = getHotUserToBuy();
		
		List<GrepProjectInfo> hotProjectlist =new ArrayList<GrepProjectInfo>();
		
		for (GrepUserInfo grepUserInfo : hotlist) {
			String hql = " from GrepProjectInfo where uid =? and endTime >? ";
			List<GrepProjectInfo> projectlist =grepProjectInfoService.find(hql, new Object[]{grepUserInfo.getUid(),DateUtil.calDate(new Date(),0,0,0,0,30,0)});
			for (GrepProjectInfo grepProjectInfo : projectlist) {
				//一注方案小于10才发起
//				if(grepProjectInfo.getMoeny()/grepProjectInfo.getMultiple()<10){
					String codes = grepProjectInfo.getCode();
					System.out.println(codes);
					//131105001>RSPF=3+JQS=1+CBF=1:0,131105002>SPF=3/1+RSPF=1/0+JQS=1
					//将上例转化为SPF=3,SPF=1的集合与matchInfo中选择最多的对比，若满足是最多选择则表示可以投注
					String[] contents = codes.split("\\|");
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
											System.out.println("--------"+matchId+"-"+v);
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
//				}
			}
		}
		
		for (GrepProjectInfo projectInfo : hotProjectlist) {
			System.out.println(projectInfo.getProjectId());
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------chooseProjectsToBuy定时任务结束-------");
	}
	
	
	private List<GrepUserInfo> getHotUserToBuy(){
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
//		for (GrepUserInfo grepUserInfo : hotlist) {
//			System.out.println(grepUserInfo.getUid());
//		}
		return hotlist;
	}
	
	private List<GrepMatchInfo> getHotMatchsToBuy(){
		String hql = " from GrepMatchInfo where homeScore is null and (spf3+spf1+spf0+rspf3+rspf1+rspf0)> 1 order by (spf3+spf1+spf0+rspf3+rspf1+rspf0) desc ";
		List<GrepMatchInfo> hotMatchlist =grepMatchInfoService.find(hql, null);
		return hotMatchlist;
	}
	

	public static void main(String[] args) {
		String pid = DateUtil.dateToStr(DateUtil.calDate(new Date(),0,0,0,0,30,0), "yyyyMMdd-hhmmss");
		System.out.println(pid);
		GrepMatchInfo grepMatchInfo = new GrepMatchInfo();
//		grepMatchInfo.setSpf3(0);
//		grepMatchInfo.setSpf1(0);
//		grepMatchInfo.setSpf0(2);
//		grepMatchInfo.setRspf3(1);
//		grepMatchInfo.setRspf1(3);
//		grepMatchInfo.setRspf0(6);
		List<String> list = grepMatchInfo.getOMaxValue();
		for (String v : list) {
			System.out.println(v);
		}
		
		
	}
}
