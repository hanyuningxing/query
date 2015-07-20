package com.miracle.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ForumHandlerExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(final HttpServletRequest httpServletRequest,
			final HttpServletResponse httpServletResponse, final Object o, final Exception e) {
		httpServletRequest.setAttribute("ex", e);
		e.printStackTrace();
		return super.doResolveException(httpServletRequest, httpServletResponse, o, e);
	}

}
