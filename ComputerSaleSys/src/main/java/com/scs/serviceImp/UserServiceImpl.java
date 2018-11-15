package com.scs.serviceImp;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.dao.UserDao;
import com.scs.entity.User;
import com.scs.service.UserService;
import com.scs.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 添加员工
	 */
	@Override
	public int addUser(User user) {
		if(null != user) 
			return userDao.saveUser(user);
		else 
			return 0;
	}

	
	/**
	 * 列出所有员工
	 */
	@Override
	public JSONArray listAllUser() {
		List<User> users = userDao.selectAllUsers();
		JSONArray userJsonArr = new JSONArray();
		if(null != users) {
			for (User user : users) {
				JSONObject tempJSON = new JSONObject();
				tempJSON.put("id", user.getId());
				tempJSON.put("userName", user.getUsername());
				tempJSON.put("sex", user.getSex());
				tempJSON.put("tel", user.getTel());
				tempJSON.put("birth", user.getBirth());
				tempJSON.put("inTime", user.getInTime());
				tempJSON.put("addr", user.getAddr());
				tempJSON.put("basicSalary", user.getBasicSalary());
				userJsonArr.add(tempJSON);
			}
		}
		return userJsonArr;
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public int modifyUserInfo(User user) {
		if(null != user)
			return userDao.updateUser(user);
		else
			return 0;
	}

	
	/**
	 * 删除员工
	 */
	@Override
	public int deleteUserById(Integer id) {
		if(id >=0)
			return userDao.deleteUser(id);
		else
			return 0;
	}


}
