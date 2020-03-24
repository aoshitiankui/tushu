package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SysInteceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		SpringApplicationContext.setRequest(request);
		SpringApplicationContext.setResponse(response);
		return super.preHandle(request, response, handler);
	}

}

