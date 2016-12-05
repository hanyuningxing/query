package com.miracle.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;

import com.miracle.utils.DateUtil;

public class FetchParserGHBuy extends AbstractFetchParser {
	private static final String URL="http://www.tao3c.com/info/task!showuser.action";
	
	private static final String CHARSET = "GBK";
	
	private static FetchParserGHBuy fetchParserGHBuy=null;
	
	public FetchParserGHBuy (){
		
	}
	public static FetchParserGHBuy getInstance(){
		if(fetchParserGHBuy==null){
			fetchParserGHBuy = new FetchParserGHBuy();
		}
		return fetchParserGHBuy;
	}
	
	public void fetch(){
		String html="";
		try {
			html = HttpClientUtil.Utf8HttpClientUtils(URL, null);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!StringUtils.isEmpty(html)){
			parser(html);
		}else{
			System.out.println("html is null");
		}
		
	}
	public void parser(String html) {
		File dir = new File(File.separator +"Infos");
//		File dir = new File("D://Infos");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String phonetxt = "gh_fetch_phone.txt";
		String qqtxt = "gh_fetch_qq.txt";
		File file = new File(dir, phonetxt);
		File qqfile = new File(dir, qqtxt);
		
		TableTag tag=getTable(html, CHARSET,"id","userDetail");
		TableRow[] rows = tag.getRows();
		int i = 0;
		for (TableRow row : rows) {
			i++;
			if(i<2){
				continue;
			}
			try {
				TableColumn[] columns = row.getColumns();
				String uid =columns[0].getChild(0).getText();
				String gid="-";
				String money=columns[1].getChild(0).getText();
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
				
			} catch (Exception e) {
				e.printStackTrace();
				continue;
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
		FetchParserGHBuy fetch=new FetchParserGHBuy();
		fetch.fetch();
	}
}
