package com.scs.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.entity.User;
import com.scs.service.UserService;
import com.scs.utils.DateUtil;
@ParentPackage("struts-default")
@Namespace(value = "/")
public class UserAction extends ActionSupport{
	private String username;                //用户名
	private Integer sex;                     //性别
	private String birthStr;                   //生日
	private String addr;                    //住址
	private String inTimeStr;                  //入职时间
	private Double basicSalary;             //底薪
	private Integer isDelete;                //是否删除
	private String tel;                     //电话
	
	
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Action(value="/addUser")
	public void saveUser(HttpServletRequest request) {
		User user = getUserData(request);
		System.out.println("hello ssh");
	}
	
	
	
	
	
	
	
	/**
	 * 获取前台传来的参数
	 * @param request
	 * @return
	 */
	private User getUserData(HttpServletRequest request) {
		User user = null;
		try {
			username = request.getParameter("username");
			sex = Integer.parseInt(request.getParameter("username"));
			birthStr = request.getParameter("birth");
			Date birth = DateUtil.str2date(birthStr);
			addr = request.getParameter("addr");
			inTimeStr = request.getParameter("inTime");
			Date inTime = DateUtil.str2date(inTimeStr);
			basicSalary = Double.parseDouble(request.getParameter("basicSalary"));
			isDelete = Integer.parseInt(request.getParameter("isDelete"));
			tel = request.getParameter("tel");
			user = new User();
			user.setUsername(username);
			user.setSex(sex);
			user.setBirth(birth);
			user.setAddr(addr);
			user.setInTime(inTime);
			user.setBasicSalary(basicSalary);
			user.setDelete(isDelete);
			user.setTel(tel);
		} catch (Exception e) {
			
		}
		return user;
	
	}
	
	
	
	
}
