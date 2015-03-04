package com.czmen.core.service.impl;

import com.czmen.core.service.UserService;
import com.czmen.mapper.UserMapper;
import com.czmen.model.User;

/**
 * 用戶信息实现类。
 * 
 * @author YANGYONG
 *
 */
public class UserServiceImpl extends BaseService implements UserService {
	private UserMapper userMapper;

	/**
	 * Get the User object by user id.
	 */
	public User getUserById(int id) {
		userMapper = readonlySQLSession.getMapper(UserMapper.class);
		return userMapper.getUser(id);
	}
}
