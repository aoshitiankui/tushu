package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonFilter implements Filter{
    public void destroy() {  
    	  
    }  
  
    public void doFilter(ServletRequest req, ServletResponse resp,  
            FilterChain chain) throws IOException, ServletException {  
          
        HttpServletRequest request = (HttpServletRequest) req; 
        String xReq = request.getHeader("x-requested-with");
        if (xReq!=null && "XMLHttpRequest".equalsIgnoreCase(xReq)) {
        	request.setCharacterEncoding("UTF-8");
            
        }else{
        	request.setCharacterEncoding("UTF-8");
        }
        Object obj = request.getSession().getAttribute("user");
        String contextPath = request.getContextPath();// 
        String servletPath = request.getServletPath();//
        if(obj==null&&!"/login.jsp".equals(servletPath)&&!"/login.do".equals(servletPath)
        		&&!"/getImg.do".equals(servletPath)
        		&&!"/checkCode.do".equals(servletPath)
        		&&!"/updpwd.do".equals(servletPath)
        		&&!"/checkusername.do".equals(servletPath)
        		&&!"/loginOut.do".equals(servletPath)
        		&&!"/regest.jsp".equals(servletPath)
        		&&!"/regest.do".equals(servletPath)
        		&&!(servletPath.indexOf("/customer")>-1)
        		&&!(servletPath.indexOf("/books/findBooksByCondition")>-1)
        		&&!(servletPath.indexOf("/adjust/findAdjustByCondition.do")>-1)
        		&&!(servletPath.indexOf("/books/findBooksById")>-1)
        		&&!(servletPath.indexOf("/message/addMessage.do")>-1)
        		
        		
        		
        		){
        	HttpServletResponse response = (HttpServletResponse) resp ;
        	response.sendRedirect(contextPath+"/customer/login.jsp");
        }else{
        	 chain.doFilter(req, resp); 
        }
  
    }  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
  
       
    }  
}
