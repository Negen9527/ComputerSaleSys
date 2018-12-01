package com.scs.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-default")
@Namespace(value = "/")
public class LoginAction extends ActionSupport{
	
	@Action(value = "login",
			results = {
					@Result(name="success")
			})
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<String> sessionIds = (List<String>) session.getAttribute("sessionIds");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("123") && password.equals("123")) {
			System.out.println("==========>登陆成功");
			if(null == sessionIds) {
				List<String> sessionIdList = new ArrayList<String>();
				sessionIdList.add(session.getId());
				session.setAttribute("user", sessionIdList);
			}else {
				sessionIds.add(session.getId());
				session.setAttribute("user", sessionIds);
			}
			return SUCCESS;
		}
		
		return "login";
	}
}
