package com.supplier.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="commonFilter", urlPatterns={"/*"})
public class CommonFilter  implements Filter {
	
	public void destroy() {}
	  
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException{
		HttpServletResponse response = (HttpServletResponse)arg1;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, authorization");
	    arg2.doFilter(arg0, arg1);
	}
	  
	  public void init(FilterConfig arg0) throws ServletException{}
}

