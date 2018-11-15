package com.scs.service;

import java.util.List;

import com.scs.entity.User;

import net.sf.json.JSONArray;

public interface UserService {
	//新增员工
	int addUser(User user);
	//所有员工
	JSONArray listAllUser();
	//修改员工信息
	int modifyUserInfo(User user);
	//删除员工
	int deleteUserById(Integer id);
}
