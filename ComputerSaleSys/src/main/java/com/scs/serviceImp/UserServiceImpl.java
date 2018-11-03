package com.scs.serviceImp;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.dao.UserDao;
import com.scs.entity.User;
import com.scs.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public List<User> listAllUsers() {
		userDao.selectAllUsers();
		return null;
	}

}
