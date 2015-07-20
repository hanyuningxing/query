package com.miracle.web.controller.user;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.miracle.common.Constant;
import com.miracle.model.user.BankInfo;
import com.miracle.model.user.User;
import com.miracle.model.user.UserInfo;
import com.miracle.spring.SpringUtils;
import com.miracle.utils.MD5;
import com.miracle.web.controller.WebDataException;
import com.miracle.web.controller.common.BaseController;
import com.miracle.web.user.SsoHolder;

@Controller
public class LoginController extends BaseController {

	private transient Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = SsoHolder.loginAction)
	public ModelAndView login(final HttpServletRequest request, final HttpServletResponse response) {
		final ModelAndView mav = new ModelAndView();
		if(this.isGetMethod()){
			///get方法转向
			mav.setViewName("/user/login.ftl");
			return mav;
		}
		mav.setViewName("");
		try {
			//			final User loginUser = getLoginUser(response);
			//			if (loginUser != null) {
			//				mav.setViewName("/main");
			//				return mav;
			//			}
			String userName = request.getParameter("username");
			if (StringUtils.isEmpty(userName)) {
				throw new WebDataException("用户名不能为空");
			}
			userName = URLDecoder.decode(userName.trim(), Constant.ENCODING);
			final String password = request.getParameter("password");
			if (StringUtils.isEmpty(password)) {
				throw new WebDataException("密码不能为空");
			}

			final String captcha = request.getParameter("jcaptchaPassword");
			if (StringUtils.isEmpty(captcha)) {
				throw new WebDataException("为了您的用户安全,请输入验证码");
			} else if (!captcha.equals(SpringUtils.getSession().getAttribute(Constant.LOGIN_CAPTCHA))) {
				throw new WebDataException("验证码错误");
			}

			final String ipAddress = SpringUtils.getRequest().getRemoteAddr();
			logger.info("用户[{}]尝试登录网站,来源IP:{}", userName, ipAddress);
			final User user = userService.getUserBy(userName);
			if (user == null) {
				throw new Exception("用户名或密码错误");
			} else {
				if (user.isLocked()) {
					throw new WebDataException("该账户已被锁定,请联系客服");
				}
			}
			final String pwd = MD5.md5(password.trim()).toUpperCase();
			if (!pwd.equalsIgnoreCase(user.getPassword())) {
				throw new Exception("用户名或密码错误");
			} else {
				//				LoginHolder.login(user.getId(), response);
				if (user.getInfo() == null) {
					user.setInfo(new UserInfo());
					userService.saveUser(user);
				}
				if (user.getBank() == null) {
					user.setBank(new BankInfo());
					userService.saveUser(user);
				}
				//setSessionUser(request, user);
				//				String toUrl = (String) request.getSession().getAttribute(Constant.LOGIN_TO_URL);
				request.getSession().removeAttribute(Constant.LOGIN_TO_URL);
				//				if (StringUtils.isEmpty(toUrl)) {
				//					toUrl = "/main";
				//				}
				SsoHolder.login(user.getId(), response);
				mav.addObject("user", user);
				mav.setView(new RedirectView("/ticket"));
				logger.info("用户[{}]登录成功.", userName);
			}
		} catch (final Exception e) {
			mav.addObject(ERROR_MSG, e.getMessage());
			mav.setViewName("/user/login.ftl");
		}
		return mav;
	}

	@RequestMapping("/user/logout")
	public String logout(final HttpServletResponse response) {
		SsoHolder.logout(response);
		return "/user/login.ftl";
	}
}
