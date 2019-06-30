package com.service.impl;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.pojo.User;
import com.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	//创建Dao层过度向
	LoginDao loginDao = new LoginDaoImpl();

	@Override
	public User checkLoginService(String uname, String pwd) {
		
		return loginDao.checkLoginDao(uname, pwd);
	}

	//校验Cookie信息
	@Override
	public User checkUidService(String uid) {
		// TODO Auto-generated method stub
		return loginDao.checkIdDao(uid);
	}

}
