package com.czmen.core.service;

import com.czmen.model.User;


/**
 * UserService接口，consumer和provider各一份。
 * 暂时不分开，到时方便扩展。
 * 
 * @author YANGYONG
 *
 */
public interface UserService {
	User getUserById(int id);
}
