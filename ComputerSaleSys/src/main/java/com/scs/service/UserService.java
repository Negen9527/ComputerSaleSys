package com.scs.service;

import java.util.List;

import com.scs.entity.User;

public interface UserService {
	int saveUser(User user);
	List<User> listAllUsers();
}
