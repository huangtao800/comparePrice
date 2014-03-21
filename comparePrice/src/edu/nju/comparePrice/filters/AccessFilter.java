package edu.nju.comparePrice.filters;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
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
    	String ip = request.getRemoteAddr();
    	
//    	boolean canAccess = attackDetector.analyzeIP(ip);
//    	if (canAccess) {
//    		chain.doFilter(request, response); 
//    	} else {
//    		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//    		httpServletResponse.sendRedirect("http://www.jsga.gov.cn/www/jsga/2010/index.htm");
//    	}
    		chain.doFilter(request, response); 
	}

}
