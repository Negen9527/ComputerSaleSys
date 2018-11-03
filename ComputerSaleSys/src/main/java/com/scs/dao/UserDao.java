package com.scs.dao;

import java.util.List;

import com.scs.entity.User;

public interface UserDao {
	public int saveUser(User user);
	List<User> selectAllUsers();
}
