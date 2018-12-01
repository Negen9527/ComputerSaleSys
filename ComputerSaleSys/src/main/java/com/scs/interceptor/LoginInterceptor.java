package com.scs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String user = (String)ActionContext.getContext().getSession().get("user");
		System.out.println(user);
		if(user == null) {
			System.out.println("======>用户未登录");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.sendRedirect("html/login.html");
		}
		return null;
	}

}
