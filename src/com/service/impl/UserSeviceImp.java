package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.dao.impl.UserDaoImp;
import com.pojo.User;
import com.service.UserService;

public class UserSeviceImp implements UserService{

	//获取Dao层对象
	UserDao ud=new UserDaoImp();
	
	/**
	 * 获取用户信息
	 */
	@Override
	public User getUserInfoService(String name) {
		
		return ud.getUserInfo(name);
	}
	
}
