package com.sm.admin.dao;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.admin.dto.UsersDto;
import com.sm.admin.model.Captcha;
import com.sm.admin.model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users findUserByUserName(String email) {
		Users user=(Users) sessionFactory.getCurrentSession().createQuery("from Users where userName=:userName").setParameter("userName", email).uniqueResult();	    
		return user;
	}

	@Override
	public Captcha getCaptcha() {
		return (Captcha)sessionFactory.getCurrentSession().createQuery("from Captcha order by rand()").setMaxResults(1).uniqueResult();
	}
	
	@Override
	public Integer saveUser(Users info) {
		return (Integer) sessionFactory.getCurrentSession().save(info);
	}
	
	@Override
	public void updateDynamicCode(String dynamicCode,UsersDto users) {
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === updateDynamicCode == end");
		
		sessionFactory.getCurrentSession().createQuery("update Users set dynamic_access_code=:dynamic_access_code where mobile_no=:mobile_no")
		.setParameter("dynamic_access_code", dynamicCode)
		.setParameter("mobile_no", users.getMobile_no()).executeUpdate();
		
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === updateDynamicCode == end");
	}

	@Override
	public Users getUserById(Integer userId) {
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === getUserById == end");
		
		Users user=(Users) sessionFactory.getCurrentSession().createQuery("from Users where userId=:userId").setParameter("userId", userId).uniqueResult();
		
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === getUserById == end");
		
		return user;
	}

	@Override
	public Users checkDynamicAccessCode(UsersDto userDto) {
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === checkDynamicAccessCode == start ");
		
		Users user=(Users) sessionFactory.getCurrentSession().createQuery("from Users where userId=:userId and dynamic_access_code=:dynamic_access_code and dynamic_status=:dynamic_status")
				.setParameter("userId", userDto.getUserId())
				.setParameter("dynamic_access_code", userDto.getDynamic_access_code())
				.setParameter("dynamic_status", false).uniqueResult();	
		
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === checkDynamicAccessCode == end");
		
		return user;
	}

	@Override
	public void updateUserInfo(UsersDto userDto) {
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === updateUsers == start ");
		
		sessionFactory.getCurrentSession().createQuery("update Users set dynamic_status=:dynamic_status , enabled=:enabled where userId=:userId")
		.setParameter("dynamic_status", true)
		.setParameter("enabled", true)
		.setParameter("userId", userDto.getUserId()).executeUpdate();
		
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === updateUsers == end ");
	}

	@Override
	public Users getUserByUsernamePassword(UsersDto usersDto) {
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === findUserByUserName == end");
		
		Users user=(Users) sessionFactory.getCurrentSession().createQuery("from Users where mobile_no=:mobile_no and password=:password ")
				.setParameter("mobile_no", usersDto.getMobile_no())
				.setParameter("password", usersDto.getPassword()).uniqueResult();
		
		if(logger.isTraceEnabled())
			logger.info("UserDaoImpl === findUserByUserName == end");
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersDto> getCustomersList(Principal principal) {
		List<Users> users=(List<Users>) sessionFactory.getCurrentSession().createQuery("from Users where userName!=:userName")
				.setParameter("userName", principal.getName()).list();	 
		List<UsersDto> userslist=new ArrayList<>();
		for(Users user:users){
			UsersDto info=new UsersDto();
			info.setFirstname(user.getFirstName());
			info.setLastname(user.getLastname());
			info.setMobile_no(user.getMobile_no());
			info.setEmail(user.getEmail());
			info.setPassword(user.getPassword());
			info.setUsername(user.getUserName());
			info.setCountry(user.getCountry());
			info.setState(user.getState());
			info.setCity(user.getCity());
			info.setPhoneNumber(user.getPhoneNumber());
			info.setZipCode(user.getZipCode());
			userslist.add(info);
		}
		return userslist;
	}

	


}
