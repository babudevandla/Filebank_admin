package com.sm.admin.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.admin.common.CommonController;
import com.sm.admin.dao.UserDao;
import com.sm.admin.dto.UsersDto;
import com.sm.admin.model.Captcha;
import com.sm.admin.model.Users;

@Service
@Transactional
public class UserServiceImpl extends CommonController implements UserService {

	@Autowired
	private  UserDao userDao;
	
	
	@Override
	public Users findUserByUserName(String email) {
		return userDao.findUserByUserName(email);
	}

	@Override
	public Users getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public Captcha getCaptcha() {
		return userDao.getCaptcha();
	}

	@Override
	public Integer saveUser(UsersDto users) {
		
		Users info=new Users();
		info.setFirstName(users.getFirstname());
		info.setLastname(users.getLastname());
		info.setMobile_no(users.getMobile_no());
		info.setDateofbirth(stringtoDate(users.getBirthday_year()+"-"+users.getBirthday_month()+"-"+users.getBirthday_date()));
		info.setEmail(users.getEmail());
		info.setPassword(users.getPassword());
		info.setUserName(users.getMobile_no());
		info.setCountry(users.getCountry());
		info.setState(users.getState());
		info.setCity(users.getCity());
		info.setPhoneNumber(users.getPhoneNumber());
		info.setZipCode(users.getZipCode());
		return userDao.saveUser(info);
	}

	@Override
	public void updateDynamicCode(String dynamicCode,UsersDto users) {
		userDao.updateDynamicCode(dynamicCode,users);		
	}

	
	@Override
	public Users checkDynamicAccessCode(UsersDto userDto) {
		return userDao.checkDynamicAccessCode(userDto);
	}

	@Override
	public void updateUserInfo(UsersDto userDto) {
		userDao.updateUserInfo(userDto);
	}

	@Override
	public Users getUserByUsernamePassword(UsersDto usersDto) {
		return userDao.getUserByUsernamePassword(usersDto);
	}

	@Override
	public List<UsersDto> getCustomersList(Principal principal) {
		return userDao.getCustomersList(principal);
	}

}
