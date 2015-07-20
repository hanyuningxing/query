package com.miracle.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class HttpClientUtil {
	protected static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static DefaultHttpClient httpClient = null;

	public static DefaultHttpClient getHttpClient() {
		if (httpClient == null) {
			HttpParams params = new BasicHttpParams();
			ConnManagerParams.setMaxTotalConnections(params, 50);
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);

			SchemeRegistry schemeRegistry = new SchemeRegistry();
			schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			ClientConnectionManager cm = new ThreadSafeClientConnManager(params, schemeRegistry);
			httpClient = new DefaultHttpClient(cm, params);
		}
		return httpClient;
	}

	public static String getRemoteSource(String url) {
		return getRemoteSource(url, null);
	}

	public static String getRemoteSource(String url, String encode) {
		DefaultHttpClient httpclient = getHttpClient();
		HttpUriRequest httpReq = new HttpGet(url);
		HttpContext context = new BasicHttpContext();
		try {
			boolean useProxy = false;
			if (useProxy) {
				// TODO 使用代理
				String proxyIP = "127.0.0.1";
				int proxyPort = 8080;
				String proxyUserName = "test";
				String proxyPassWord = "123456";
				String proxyScheme = "http";
				httpclient.getCredentialsProvider().setCredentials(new AuthScope(proxyIP, proxyPort),
						new UsernamePasswordCredentials(proxyUserName, proxyPassWord));
				HttpHost proxy = new HttpHost(proxyIP, proxyPort, proxyScheme);
				httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
			}

			ResponseHandler<String> responseHandler = new SimpleResponseHandler(encode);
			String resultContent = httpclient.execute(httpReq, responseHandler, context);
			return resultContent;
		} catch (Exception e) {
			logger.error(String.format("请求远程地址失败，URL：[%s]", url), e);
			httpReq.abort();
			return null;
		}
	}
	public static void main(String[] args) {
		HashMap<String, String> paramMap = Maps.newHashMap();
		paramMap.put("wAction", "102");
	   String  e = HttpClientUtil.Utf8HttpClientUtils("http://61.147.79.116:8070/ticket.jsp",paramMap);
	   System.out.print(e);
	   int o=0;
	}
	public static String Utf8HttpClientUtils(String reUrl, Map<String,String> ParamMap){
		DefaultHttpClient httpclient = getHttpClient();
		httpclient.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, 200000);
		httpclient.getParams().setParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 200000);
		HttpContext context = new BasicHttpContext();
		HttpPost httppost = new HttpPost(reUrl);
		try {
			List<NameValuePair> formparams = Lists.newArrayList();
			for (String key : ParamMap.keySet()) {
				String value = ParamMap.get(key);
				formparams.add(new BasicNameValuePair(key,value));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(entity);
			ResponseHandler<String> responseHandler = new SimpleResponseHandler("UTF-8");
			String resultContent = httpclient.execute(httppost, responseHandler, context);
			return resultContent;
		} catch (Exception e) {
			logger.error(String.format("请求远程地址失败，URL：[%s]", reUrl), e);
			httppost.abort();
			httppost =  null;
			httpclient = null;
			return null;
		}finally{
			if(null!=httppost){
				httppost.abort();
				httppost =  null;
				if(null!=httpclient){
					httpclient = null;
				}
			}
		}
    
	}
}
