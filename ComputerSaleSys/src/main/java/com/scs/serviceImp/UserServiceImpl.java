package com.scs.serviceImp;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.dao.UserDao;
import com.scs.entity.User;
import com.scs.service.UserService;
import com.scs.utils.StringUtil;

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
	public List<User> listAllUser() {
		List<User> users = userDao.selectAllUsers();
		return users;
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public int modifyUserInfo(User user) {
		return userDao.updateUser(user);
	}

	
	/**
	 * 删除员工
	 */
	@Override
	public int deleteUserById(Integer id) {
		return userDao.deleteUser(id);
	}


}
