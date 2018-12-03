package com.scs.interceptor;

import java.util.List;

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
		List<String> sessionIds = (List<String>)ActionContext.getContext().getSession().get("sessionIds");
		System.out.println(sessionIds);
		if(sessionIds == null) {
			System.out.println("======>用户未登录");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.sendRedirect("html/login.html");
		}
		invocation.invoke();
		return null;
	}

}
