package edu.nju.comparePrice.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.comparePrice.attackDetector.AttackDetector;

public class AccessFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 7035105663148079361L;
	
	private AttackDetector attackDetector;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		attackDetector = new AttackDetector();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String ip = getIp(httpServletRequest);
		String url = httpServletRequest.getServletPath();
		System.out.println(url);
		
		String contextPath = httpServletRequest.getContextPath();
		
    	boolean canAccess = attackDetector.analyzeIP(ip);
    	if (canAccess) {
    		chain.doFilter(request, response); 
    	} else {
    		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
    		httpServletResponse.sendRedirect(contextPath+"/user/attackWarn.jsp");
    	}
	}
	
	private String getIp (HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");  
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	         ip = request.getHeader("Proxy-Client-IP");  
	     }  
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	         ip = request.getHeader("WL-Proxy-Client-IP");  
	      }  
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	          ip = request.getRemoteAddr();  
	     }
	     return ip;
	}
}
