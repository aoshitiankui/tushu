package com.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringApplicationContext {
	private static Logger logger = LoggerFactory.getLogger(SpringApplicationContext.class);
	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	
	//用来获取项目路径
	private static ServletContext application = null;
	
	public static ServletContext getApplication() {
		return application;
	}
	public static void setApplication(ServletContext application) {
		SpringApplicationContext.application = application;
	}
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
	public static HttpServletRequest getRequest() {
		return requestLocal.get();
	}

	public static void setRequest(HttpServletRequest request) {
		requestLocal.set(request);
	}

	public static HttpServletResponse getResponse() {
		return responseLocal.get();
	}

	public static void setResponse(HttpServletResponse response) {
		responseLocal.set(response);
	}
	private static ApplicationContext ac = null;
	public static void setApplicationContext(ServletContext sc){
		ac = WebApplicationContextUtils.getWebApplicationContext(sc);
	}
	public static void setClassPathXmlApplicationContext(String xml){
		ac = new ClassPathXmlApplicationContext(xml);
	}
	public static void setFileSystemXmlApplicationContext(String xml){
		ac = new FileSystemXmlApplicationContext(xml);
	}
	public static ApplicationContext getApplicationContext(){
		return ac;
	}
	public static<T> T getApplicationContextBean(Class<T> clzz){
		if(ac!=null){
			logger.debug(clzz.toString());
			return ac.getBean(clzz);
		}
		return null;
	}
	public static Object getApplicationContextBean(String bean){
		if(ac!=null){
			logger.debug(bean);
			return ac.getBean(bean);
		}
		return null;
	}
}
