package com.miracle.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miracle.utils.DateUtil;

@Service
@Transactional
public class ContinueJobService {

	public static void getPhoneInfo(){
		String url = "http://www.139cai.com/cpdata/paihang/";
		String[] gids = {"00","01","03","04","07","20","50","51","52","53","54","55","56","80","81","82","83"}; 
		System.out.println(DateUtil.dateToStr(new Date())+"------定时任务开始-------");
		for (String gid : gids) {
			PhoneInfo(url+gid+"_today.json",gid);
			PhoneInfo(url+gid+"_yestoday.json",gid);
			PhoneInfo(url+gid+"_week.json",gid);
			PhoneInfo(url+gid+"_month.json",gid);
		}
		System.out.println(DateUtil.dateToStr(new Date())+"------定时任务结束-------");
	}
	
	public static void getGhPhoneInfo(){
		System.out.println(DateUtil.dateToStr(new Date())+"------gh定时任务开始-------");
		String[] games = {"dlt","ssq","pl","seven","sevenstar","welfare3d"};
		String url2 = "http://www.ghcai.com/js/analyse/";
		for (String game : games) {
			PhoneInfo2(url2+game+"/topwon.js?"+new Date().getTime(),game);
		}
		FetchParserGHBuy.getInstance().fetch();
		System.out.println(DateUtil.dateToStr(new Date())+"------gh定时任务结束-------");
	}
	
	public static void getGhPhoneBuyerInfo(){
		System.out.println(DateUtil.dateToStr(new Date())+"------gh_buy定时任务开始-------");
		FetchParserGHBuy.getInstance().fetch();
		System.out.println(DateUtil.dateToStr(new Date())+"------gh_buy定时任务结束-------");
	}
	public static void getPhoneInfo128(){
		System.out.println(DateUtil.dateToStr(new Date())+"------128定时任务开始-------");
		String url = "http://www.128cai.com/client/urlRequestServlet?action=topBonusLog&pageSize=20&d=";
		PhoneInfo3(url+new Date().getTime());
		System.out.println(DateUtil.dateToStr(new Date())+"------128定时任务结束-------");
	}
	
	private final static void PhoneInfo(String url,String gid) {
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
			File dir = new File(File.separator +"Infos");
//			File dir = new File("D://Infos");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, "phone.txt");
			File qqfile = new File(dir, "qq.txt");
			
//			System.out.println("--------------"+file.getAbsolutePath());
//			System.out.println("----json---------"+buffer.toString());
			if(JSONObject.fromObject(buffer.toString()).has("rows")){
				if ((JSONObject.fromObject(buffer.toString()).get("rows") instanceof JSONObject)) {
					
					if((JSONObject.fromObject(buffer.toString()).getJSONObject("rows").get("row") instanceof JSONArray)){
						JSONArray jsonArray = JSONObject.fromObject(buffer.toString()).getJSONObject("rows").getJSONArray("row");
//						System.out.println("----json---------"+jsonArray.toString());
						for (Object object : jsonArray) {
							String uid = JSONObject.fromObject(object).getString("cnickid");
							String money = JSONObject.fromObject(object).getString("imoney");
							if(isMobilephone(uid)&&!hasSameValue(uid,file)){
								String info = uid+"#"+gid+"#"+money+"#"+DateUtil.dateToStr(new Date())+"\r\n";
								FileWriter fileWriter=new FileWriter(file,true);
								BufferedWriter writer = new BufferedWriter(fileWriter);
								writer.write(info);
								writer.close();
							}
							
							if(isQQ(uid)&&!hasSameValue(uid,qqfile)){
								String info = uid+"#"+gid+"#"+money+"#"+DateUtil.dateToStr(new Date())+"\r\n";
								FileWriter fileWriter=new FileWriter(qqfile,true);
								BufferedWriter writer = new BufferedWriter(fileWriter);
								writer.write(info);
								writer.close();
							}
						}
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
	
	private final static void PhoneInfo2(String url,String gid) {
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
			File dir = new File(File.separator +"Infos");
//			File dir = new File("D://Infos");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String phonetxt = "gh_phone.txt";
			String qqtxt = "gh_qq.txt";
			File file = new File(dir, phonetxt);
			File qqfile = new File(dir, qqtxt);
			
//			System.out.println("--------------"+file.getAbsolutePath());
//			System.out.println("----json---------"+buffer.toString());
			
			String[] types = {"topwonmonth","listDateDesc","topwon","topwonweek"};
			for (String type : types) {
				if((JSONObject.fromObject(buffer.toString()).has(type))){
					JSONArray jsonArray = JSONObject.fromObject(buffer.toString()).getJSONArray(type);
//					System.out.println("----json---------"+jsonArray.toString());
					for (Object object : jsonArray) {
						String uid = JSONObject.fromObject(object).getString("userName");
						String money = JSONObject.fromObject(object).getString("bonus");
						if(isMobilephone(uid)&&!hasSameValue(uid,file)){
							String info = uid+"#"+gid+"#"+money+"#"+DateUtil.dateToStr(new Date())+"\r\n";
							FileWriter fileWriter=new FileWriter(file,true);
							BufferedWriter writer = new BufferedWriter(fileWriter);
							writer.write(info);
							writer.close();
						}
						
						if(isQQ(uid)&&!hasSameValue(uid,qqfile)){
							String info = uid+"#"+gid+"#"+money+"#"+DateUtil.dateToStr(new Date())+"\r\n";
							FileWriter fileWriter=new FileWriter(qqfile,true);
							BufferedWriter writer = new BufferedWriter(fileWriter);
							writer.write(info);
							writer.close();
						}
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
	
	private final static void PhoneInfo3(String url) {
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
			File dir = new File(File.separator +"Infos");
//			File dir = new File("D://Infos");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String phonetxt = "128_phone.txt";
			String qqtxt = "128_qq.txt";
			File file = new File(dir, phonetxt);
			File qqfile = new File(dir, qqtxt);
			JSONArray jsonArray = JSONArray.fromObject(buffer.toString());
			for (Object object : jsonArray) {
				String uid = JSONObject.fromObject(object).getString("mobile");
				String money = JSONObject.fromObject(object).getString("bonusAmount");
				String gid = JSONObject.fromObject(object).getString("lotteryName");
				if(isMobilephone(uid)&&!hasSameValue(uid,file)){
					String info = uid+"#"+gid+"#"+money+"#"+DateUtil.dateToStr(new Date())+"\r\n";
					FileWriter fileWriter=new FileWriter(file,true);
					BufferedWriter writer = new BufferedWriter(fileWriter);
					writer.write(info);
					writer.close();
				}
				
				if(isQQ(uid)&&!hasSameValue(uid,qqfile)){
					String info = uid+"#"+gid+"#"+money+"#"+DateUtil.dateToStr(new Date())+"\r\n";
					FileWriter fileWriter=new FileWriter(qqfile,true);
					BufferedWriter writer = new BufferedWriter(fileWriter);
					writer.write(info);
					writer.close();
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
	
	private final static boolean hasSameValue(String phone,File file) throws Exception {
		boolean flag = false;
		if (file.exists() && file.isFile()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				temp = temp.trim();
				if (temp.length() > 0) {
					if(temp.split("\\#")[0].equals(phone)){
						flag = true;
					}
				}
			}
			br.close();
			br = null ;
			return flag;
		}else{
			return false;
		} 
	}
	
	public final static boolean isMobilephone(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	public final static boolean isQQ(String qq) {
		Pattern p = Pattern.compile("^[qQ_-]*[1-9](\\d){4,9}$");
		Matcher m = p.matcher(qq);
		return m.matches();
	}
	
	public static void main(String[] args) {
//		System.out.println(isQQ("28785685"));
//		PhoneInfo3("http://www.128cai.com/client/urlRequestServlet?action=topBonusLog&pageSize=20&d=1471528039875");
		getGhPhoneInfo();
	}
}
