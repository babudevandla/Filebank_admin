package com.sm.admin.service;

import com.sm.admin.dto.UsersDto;
import com.sm.admin.model.Captcha;
import com.sm.admin.model.Users;

public interface UserService {

	Users findUserByUserName(String email);
	Users getUserById(Integer userId);
	public Captcha getCaptcha();
	Users getUserByUsernamePassword(UsersDto usersDto);
	Integer saveUser(UsersDto users);
	Users checkDynamicAccessCode(UsersDto userDto);
	void updateUserInfo(UsersDto userDto);
	void updateDynamicCode(String dynamicCode, UsersDto users);
}