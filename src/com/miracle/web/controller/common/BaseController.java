package com.miracle.web.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.miracle.common.Constant;
import com.miracle.model.ticket.TicketPlatformInfo;
import com.miracle.model.user.User;
import com.miracle.service.ticket.TicketThenService;
import com.miracle.service.user.UserService;
import com.miracle.spring.SpringUtils;
import com.miracle.web.user.SsoHolder;

public class BaseController {

	protected static final String ERROR_MSG = "errorMsg";
	@Autowired
	protected TicketThenService ticketThenService;
	@Autowired
	protected UserService userService;

	protected User getLoginUser(final HttpServletResponse response) {
		return SsoHolder.getLoginUser(response);
	}
	@ModelAttribute
	protected TicketPlatformInfo getTicketPlatformInfo(final HttpServletResponse response) {
		User user = this.getLoginUser(response);
	    if(null!=user){
	    	TicketPlatformInfo tp = ticketThenService.getTicketPlatformInfoBy(user);
	    	if(null!=tp){
	    		return tp;
	    	}
	    }
	    return null;
	}
	protected boolean isAjaxRequest() {
		final String ajax = SpringUtils.getParameter("ajax");
		return !"false".equals(ajax) && (SpringUtils.isAjaxRequest() || "true".equals(ajax));
	}
	protected Boolean isGetMethod(){
		if ("GET".equals(SpringUtils.getRequest().getMethod())) {// 转向登录页面
			return true;
		}
		return false;
	}

	/**
	 * 获取保存在session中的用户对象
	 * @param request
	 * @return
	 */
	protected User getSessionUser(final HttpServletRequest request) {
		return (User) request.getSession().getAttribute(Constant.USER_CONTEXT);
	}

	/**
	 * 将用户对象保存到session
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(final HttpServletRequest request, final User user) {
		request.getSession().setAttribute(Constant.USER_CONTEXT, user);
	}

	/**
	 * 获取基于应用程序的URL绝对路径
	 * @param request
	 * @param url
	 * @return
	 */
	public String getAppbaseUrl(final HttpServletRequest request, final String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "url必须以/打头");
		return request.getContextPath() + url;
	}
	
	@ModelAttribute
	public User getUser(HttpServletResponse response){
		return SsoHolder.getLoginUser(response);
	}
}
