package com.scs.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scs.dao.LoginDao;
import com.scs.entity.Admin;
import com.scs.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name = "loginDao")
	private LoginDao loginDao;
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	@Override
	public Integer logon(Admin admin) {
		return loginDao.logon(admin);
	}

}
