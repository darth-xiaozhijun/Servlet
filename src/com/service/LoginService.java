package com.service;

import com.pojo.User;

public interface LoginService {

	/*
	 * 校验登录信息
	 */
	User checkLoginService(String uname,String pwd);

	/**
	 * 校验Cookie信息
	 * @param uid
	 * @return
	 */
	User checkUidService(String uid);
}
