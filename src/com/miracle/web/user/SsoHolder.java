package com.miracle.web.user;

import java.net.URLDecoder;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.miracle.common.Config;
import com.miracle.common.Constant;
import com.miracle.model.user.User;
import com.miracle.service.user.UserService;
import com.miracle.spring.SpringContextHolder;
import com.miracle.spring.SpringUtils;
import com.miracle.utils.AspMD5;

public class SsoHolder {
	
	public final static String loginAction = "/user/login";
	
	private static long TIME_2004_1_1 = -1;

	private final static String validationKey = "728h3892";

	private final static String ENCODING = "UTF-8";

	private final static String ssoCookieName = Config.config.getProperty("web.cookieName","MCTDEMO");

	private final static String LOGIN_USER = "ssoUser";

	private final static String SERVERNAME_REGEX = "[^\\.]*\\.(cn|com|org)$";

	private final static int CookieTimeOut = 40;

	private static UserService userService;

	public static UserService getUserService() {
		if (userService == null) {
			userService = (UserService) SpringContextHolder.getBean("userService");
		}
		return userService;
	}

	public static User getLoginUser(final HttpServletResponse response) {
		User loginUser = getUserFromCookie(SpringUtils.getRequest());
		if (loginUser != null) {
			addLoginCookie(response, loginUser);
			loginUser = getUserService().getUser(loginUser.getId());
		}
		return loginUser;
	}

	public static void addLoginCookie(final HttpServletResponse response, final User user) {
		final Cookie cookie = getLoginCookie(user);
		final String serverName = SpringUtils.getRequest().getServerName();
		if (StringUtils.isNotBlank(serverName)) {
			final Pattern p = Pattern.compile(SERVERNAME_REGEX);
			final Matcher m = p.matcher(serverName);
			if (m.find()) {
				cookie.setDomain(m.group());
			}
		}
		response.addCookie(cookie);
	}

	/**
	 * 获取登录用户的Cookie
	 * 
	 * @param userInfo
	 * @return
	 */
	public static Cookie getLoginCookie(final User user) {
		final AspMD5 digest = new AspMD5();
		final String key = digest.calcMD5(user.getPassword());
		final long now = System.currentTimeMillis();
		final int expires = (int) ((now - TIME_2004_1_1) / 1000);
		final String val_prefix = user.getId() + "|" + expires + "|";
		final String val = val_prefix + digest.calcMD5(val_prefix + key + validationKey);
		final Cookie cookie = generateLoginCookie();
		cookie.setValue(val);
		cookie.setMaxAge(expires);
		cookie.setPath("/");
		return cookie;
	}

	/**
	 * 生成供登录用的Cookie
	 * 
	 * @return
	 */
	private static Cookie generateLoginCookie() {
		final Cookie cookie = new Cookie(ssoCookieName, null);
		cookie.setPath("/");
		return cookie;
	}

	/**
	 * 根据Cookie获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	public static User getUserFromCookie(final HttpServletRequest request) {
		User user = null;
		final Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (int i = 0; i < cookies.length; i++) {
			if (ssoCookieName.equals(cookies[i].getName())) {
				try {
					final String cookie_val = URLDecoder.decode(cookies[i].getValue(), ENCODING);
					if (StringUtils.isNotBlank(cookie_val)) {
						final String[] vals = StringUtils.split(cookie_val, '|');
						if (vals.length == 3 && checkCookieTime(vals[1])) {
							final String userId = vals[0];
							user = getUserFromSession(request);
							if (user != null && user.getId() != Integer.parseInt(userId)) {
								user = null;
							}

							if (user == null) {
								user = getUserService().getUser(Long.valueOf((userId)));
							}

							if (checkCookieMd5(user, vals[1], vals[2])) {
								request.getSession(true).setAttribute(LOGIN_USER, user);
								return user;
							} else {
								return null;
							}
						}
					}
				} catch (final Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}

	/**
	 * 验证Cookie是否过期
	 * 
	 * @param timeval
	 * @return
	 */
	private static boolean checkCookieTime(final String timeval) {
		final int secs = Integer.parseInt(timeval) + CookieTimeOut * 60;
		final long now = (System.currentTimeMillis() - TIME_2004_1_1) / 1000;
		if (secs > now) {
			return true;
		}
		return false;
	}

	/**
	 * 从Session里取用户信息
	 * 
	 * @param request
	 * @return
	 */
	private static User getUserFromSession(final HttpServletRequest request) {
		final HttpSession sess = request.getSession(false);
		if (sess == null) {
			return null;
		}
		if (sess.getAttribute(LOGIN_USER) instanceof User) {
			return (User) sess.getAttribute(LOGIN_USER);
		}
		return null;
	}

	/**
	 * 验证Cookie是否合法
	 * 
	 * @param userInfo
	 * @param timeval
	 * @param md5
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean checkCookieMd5(final User user, final String timeval, final String md5)
			throws NoSuchAlgorithmException {
		if (user != null) {
			final AspMD5 digest = new AspMD5();
			final String msg = user.getId() + "|" + timeval + "|" + digest.calcMD5(user.getPassword()) + validationKey;
			if (md5.equals(digest.calcMD5(msg))) {
				return true;
			}
		}
		return false;
	}

	public static User login(final Long id, final HttpServletResponse response) {
		final User user = getUserService().getUser(id);
		addLoginCookie(response, user);
		reFlushLoginUser();
		return user;
	}

	/**
	 * 刷新登录用户的信息
	 * 
	 */
	public static void reFlushLoginUser() {
		final HttpServletRequest request = SpringUtils.getRequest();
		final HttpSession sess = request.getSession(false);
		if (sess.getAttribute(LOGIN_USER) instanceof User) {
			User user = (User) sess.getAttribute(LOGIN_USER);
			if (user != null) {
				user = getUserService().getUser(user.getId());
				request.getSession(true).setAttribute(LOGIN_USER, user);
			}
		}
	}
	/**
	 * 退出登录，清除Cookie
	 * 
	 * @param request
	 * @param response
	 */
	public static void logout(final HttpServletResponse response) {
		HttpServletRequest request = SpringUtils.getRequest();
		final HttpSession session = request.getSession(false);

		session.removeAttribute(Constant.USER_CONTEXT);
		User user_ = getUserFromCookie(request);
		if (user_ != null) {
			Cookie cookie = generateLoginCookie();
			cookie.setMaxAge(0);
			response.addCookie(cookie);

			String serverName = request.getServerName();
			if (StringUtils.isNotBlank(serverName)) {
				Pattern p = Pattern.compile(SERVERNAME_REGEX);
				Matcher m = p.matcher(serverName);
				if (m.find()) {
					Cookie cookie2 = generateLoginCookie();
					cookie2.setMaxAge(0);
					cookie2.setDomain(m.group());
					response.addCookie(cookie2);
				}
			}
		}
	}
}
