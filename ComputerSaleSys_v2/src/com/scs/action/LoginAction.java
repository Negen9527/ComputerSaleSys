package com.scs.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.dao.LoginDao;
import com.scs.entity.Admin;
import com.scs.service.LoginService;
@ParentPackage("struts-default")
@Namespace(value = "/")
public class LoginAction extends ActionSupport{
	@Resource(name = "loginService")
	private LoginService loginService;
	

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	@Action(value = "login",
			results = {
					@Result(name="success", type="redirect", location="/html/index.html"),
					@Result(name="login", type="redirect", location="/html/login.html")
			})
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<String> sessionIds = (List<String>) session.getAttribute("sessionIds");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		Integer intResult = loginService.logon(admin);
		if(intResult != 0) {
			if(null == sessionIds) {
				List<String> sessionIdList = new ArrayList<String>();
				sessionIdList.add(session.getId());
				session.setAttribute("sessionIds", sessionIdList);
			}else {
				sessionIds.add(session.getId());
				session.setAttribute("sessionIds", sessionIds);
			}
			return SUCCESS;
		}
		
		return "login";
	}
}
