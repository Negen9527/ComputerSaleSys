package com.scs.service;

import java.util.List;

import com.scs.entity.User;

public interface UserService {
	//新增员工
	int addUser(User user);
	//所有员工
	List<User> listAllUser();
	//修改员工信息
	int modifyUserInfo(User user);
	//删除员工
	int deleteUserById(Integer id);
}
