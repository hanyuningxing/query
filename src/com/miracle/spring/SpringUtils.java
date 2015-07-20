package com.miracle.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringUtils {

	public static HttpServletRequest getRequest() {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	public static String getParameter(final String name) {
		return getRequest().getParameter(name);
	}
	public static Boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}
	public static Boolean isNotBlank(String str) {
		return StringUtils.isNotBlank(str);
	}
	public static HttpSession getSession() {
		if (null != getRequest()) {
			return getRequest().getSession();
		}
		return null;
	}

	/**
	 * 判断是否AJAX请求
	 * 
	 * @return 是否AJAX请求
	 */
	public static boolean isAjaxRequest() {
		final String x_requested_with = getRequest().getHeader("x-requested-with");
		return x_requested_with != null && x_requested_with.equalsIgnoreCase("XMLHttpRequest");
	}
}
