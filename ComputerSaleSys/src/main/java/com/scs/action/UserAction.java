package com.scs.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.entity.User;
import com.scs.service.UserService;
@ParentPackage("struts-default")
@Namespace(value = "/")
public class UserAction extends ActionSupport{
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Action(value="/hello")
	public void saveUser() {
		User user = new User();
		user.setAddr("asdfasdf");
		user.setName("zhangsahn");
		System.out.println("hello ssh");
		userService.saveUser(user);
	}
}
