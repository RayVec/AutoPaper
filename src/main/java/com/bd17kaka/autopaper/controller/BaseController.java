/**
 * 
 */
package com.bd17kaka.autopaper.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd17kaka.autopaper.constant.SessionKey;
import com.bd17kaka.autopaper.po.User;
import com.bd17kaka.autopaper.vo.Page;

/**
 * @author bd17kaka
 *
 */
public class BaseController {
	
	private void write(String contentType, HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
		resp.setContentType(contentType);
		OutputStreamWriter out = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
		out.write(msg);
		resp.setContentLength(msg.getBytes("UTF-8").length);
		out.flush();
		out.close();
		out = null;
	}
	
	protected void writeJson(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
		write("application/json; charset=\"UTF-8\"", req, resp, msg);
	}
	
	protected void setUserSession(HttpServletRequest request, Object user) {
 		request.getSession(true).setAttribute(SessionKey.USER_SESSION.name(), user);
		request.getSession(true).setAttribute(SessionKey.USER_LOGIN_STATUS.name(), null != user);
	}

	protected User getUserSession(HttpServletRequest request) {
		return (User) request.getSession(true).getAttribute(SessionKey.USER_SESSION.name());
	} 

	 protected Page parsePage(HttpServletRequest request) {
        Page page = null;
        try {
        	page = new Page(Integer.parseInt(request.getParameter("pageNo")));
        } catch (NumberFormatException e) {
        	page = new Page(1);
        }
        return page;
    }
}
