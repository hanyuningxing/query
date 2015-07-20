package com.miracle.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class RichFreeMarkerView extends FreeMarkerView {
	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		super.exposeHelpers(model, request);
		model.put("base", request.getContextPath());
		model.put("request", request);
	}
}
