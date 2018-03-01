package com.bd17kaka.autopaper.controller;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.bd17kaka.autopaper.po.User;

public class UserFilter extends BaseController implements Filter  {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 验证session
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String url = req.getRequestURI().toString();
		
		if (url.equals("/") ) {
			chain.doFilter(request, response);
			return ;
		}
			
		chain.doFilter(request, response);
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
