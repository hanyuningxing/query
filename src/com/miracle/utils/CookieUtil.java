package com.miracle.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miracle.spring.SpringUtils;

/**
 * 
 * 
 * 
 */
public class CookieUtil {
	/**
	 * 添加cookie
	 * 
	 * @param response
	 * @param name cookie的名称
	 * @param value cookie的值
	 * @param maxAge cookie存放的时间(以秒为单位,假如存放三天,即3*24*60*60;
	 *            如果值为0,cookie将随浏览器关闭而清除)
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public static void addReUrlCookie(HttpServletResponse response) {
		CookieUtil.addCookie(response, "redirectUrl", SpringUtils.getRequest().getRequestURI(), 0);
	}

	/**
	 * 获取cookie的值
	 * 
	 * @param request
	 * @param name cookie的名称
	 * @return
	 */
	public static String getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = CookieUtil.readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = cookieMap.get(name);
			return cookie.getValue();
		} else {
			return null;
		}
	}

	protected static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
		return cookieMap;
	}

}