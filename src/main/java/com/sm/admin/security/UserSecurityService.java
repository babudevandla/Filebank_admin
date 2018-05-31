package com.sm.admin.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.sm.admin.exception.EasyLivingException;
import com.sm.admin.model.Role;
import com.sm.admin.model.Users;
import com.sm.admin.service.UserService;


 public class UserSecurityService implements org.springframework.security.core.userdetails.UserDetailsService{

	 @Autowired
	    private UserService userService;

	  @Override
	    @Transactional
	    public UserDetails loadUserByUsername(final String login) {
	       
	    	 String lowercaseLogin = login.toLowerCase();
	         System.out.println(lowercaseLogin);
	         Users userFromDatabase = userService.findUserByUserName(lowercaseLogin.trim());
	         System.out.println(userFromDatabase);
	         if (userFromDatabase == null){
	             throw new EasyLivingException("No User Exist With this Username");
	         }
	         else if (!userFromDatabase.getEnabled()){
	             throw new EasyLivingException("Account is disabled");
	         }

	         Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	         for (Role role : userFromDatabase.getRoles()) {
	             GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
	             grantedAuthorities.add(grantedAuthority);
	         }
	         
	             return new org.springframework.security.core.userdetails.User(lowercaseLogin, userFromDatabase.getPassword(),
	                 grantedAuthorities);
	     }
}
