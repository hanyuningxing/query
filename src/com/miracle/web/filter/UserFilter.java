package com.miracle.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.miracle.common.Constant;
import com.miracle.model.user.User;
import com.miracle.web.user.SsoHolder;

public class UserFilter implements Filter {

	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	/**
	 * 不需要登录即可访问的URL资源
	 */
	private static final String[] INHERENT_ESCAPE_URIS = { "/login", "/jcaptcha", "/images", "/styles", "/scripts" ,"/jquery"};

	//"/favicon.ico" 

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		//保证该过滤器在一次请求中之被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {
			//设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			final HttpServletRequest httpRequest = (HttpServletRequest) request;
			final User userContext = SsoHolder.getLoginUser(((HttpServletResponse)response));
			//用户未登录，且当前URI资源需要登录才能访问
			if (userContext == null && !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}
				//将用户的请求URL保存在session中，用于登录成功后，跳转到目标URL
				httpRequest.getSession().setAttribute(Constant.LOGIN_TO_URL, toUrl);
				//转发到登录
				request.getRequestDispatcher(SsoHolder.loginAction).forward(request, response);
				return;
			}
			chain.doFilter(request, response);
		}
	}

	private boolean isURILogin(final String requestURI, final HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI)) {
			return true;
		}
		for (final String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {

	}
}
