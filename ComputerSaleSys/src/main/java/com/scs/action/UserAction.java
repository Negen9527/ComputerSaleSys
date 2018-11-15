package com.scs.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.scs.entity.User;
import com.scs.service.UserService;
import com.scs.utils.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@ParentPackage("json-default")
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
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private JSONArray jsonArrayData = new JSONArray();
	private JSONObject jsonData = new JSONObject();
	
	
	public JSONObject getJsonData() {
		return jsonData;
	}


	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	
	

	public JSONArray getJsonArrayData() {
		return jsonArrayData;
	}


	public void setJsonArrayData(JSONArray jsonArrayData) {
		this.jsonArrayData = jsonArrayData;
	}



	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	/**
	 *	 添加员工
	 * @param request
	 */
	@Action(value="/addUser",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String saveUser() {
		
		User user = getUserData(request);
		userService.addUser(user);
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("added", user);
		this.setJsonData(jsonResult);
		return SUCCESS;
	}
	
	
	/**
	 * 	删除员工
	 * @return
	 */
	@Action(value="/deleteUser",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String deleteUser() {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer intResult = userService.deleteUserById(id);
		JSONObject tempJSON = new JSONObject();
		this.setJsonData(tempJSON);
		tempJSON.put("result", intResult==1?true:false);
		this.setJsonData(tempJSON);
		return SUCCESS;
	}
	
	
	/**
	 * 	获取所有员工
	 * @return
	 */
	@Action(value="/listUser",
			results= {
					@Result(type="json",params= {"root","jsonArrayData"})
			})
	public String listUser() {
		this.setJsonArrayData(userService.listAllUser());	
		return SUCCESS;
	}
	
	
	/**
	 * 	修改信息
	 * @return
	 */
	@Action(value="/modifyUser",
			results= {
					@Result(type="json",params= {"root","jsonData"})
			})
	public String modifyUser() {
		User user = getUserData(request);
		Integer intResult = userService.modifyUserInfo(user);
		JSONObject tempJSON = new JSONObject();
		this.setJsonData(tempJSON);
		tempJSON.put("modifuResult", intResult==1?true:false);
		this.setJsonData(tempJSON);
		return SUCCESS;
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
