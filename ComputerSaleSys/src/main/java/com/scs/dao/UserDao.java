package com.scs.dao;

import java.util.List;

import com.scs.entity.User;

public interface UserDao {
	//保存用户
	int saveUser(User user);
	//查询所有用户
	List<User> selectAllUsers();
	//修改用户信息
	int updateUser(User user);
	//删除用户
	int deleteUser(Integer id);
	//通过id查找用户
	User findUserById(Integer id);
	
	
}
