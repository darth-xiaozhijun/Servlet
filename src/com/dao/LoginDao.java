package com.dao;

import com.pojo.User;

public interface LoginDao {

	/**
	 * 根据用户名和密码获取用户信息
	 * @param uname
	 * @param pwd
	 * @return
	 */
	User checkLoginDao(String uname,String pwd);

	/**
	 * 根据uid获取用户信息
	 * @param uid
	 * @return
	 */
	User checkIdDao(String uid);
}
