package com.sm.admin.dao;

import java.security.Principal;
import java.util.List;

import com.sm.admin.dto.UsersDto;
import com.sm.admin.model.Captcha;
import com.sm.admin.model.Users;

public interface UserDao {

	public Users findUserByUserName(String email);

	public Users getUserById(Integer userId);

	public Captcha getCaptcha();

	public Integer saveUser(Users info);

	public Users checkDynamicAccessCode(UsersDto userDto);

	public void updateUserInfo(UsersDto userDto);

	public Users getUserByUsernamePassword(UsersDto usersDto);

	public void updateDynamicCode(String dynamicCode, UsersDto users);

	public List<UsersDto> getCustomersList(Principal principal);

}