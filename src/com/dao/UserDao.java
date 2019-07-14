package com.dao;

import com.pojo.User;

public interface UserDao {

	/**
	 * 获取用户信息
	 * @param name
	 * @return
	 */
	User getUserInfo(String name);

}
