package com.scs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-default")
@Namespace(value = "/")
public class LogoutAction extends ActionSupport{
	
	/**
	 * 	退出登陆
	 * @return
	 */
	@Action(value = "logout",
			results = {
					@Result(name = "success", type="redirect", location="html/login.html")
			})
	public String logout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<String> sessionIds = (List<String>) session.getAttribute("sessionIds");
		if(null != sessionIds) {
			String cSessionId = session.getId();
			sessionIds.remove(cSessionId);
			session.setAttribute("sessionIds", sessionIds);
		}
		return SUCCESS;
	}
}
