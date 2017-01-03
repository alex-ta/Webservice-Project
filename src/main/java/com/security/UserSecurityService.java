package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dao.UserDao;
import com.data.User;
import com.data.wrapper.Security_User_Wrapper;

public class UserSecurityService implements UserDetailsService{

	@Autowired
	UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = dao.getById(username);
		if(u == null){
			return null;
		}
		System.out.println(u.getId()+" "+u.getPassword()+" "+u.getRoles()+"");
		return new Security_User_Wrapper(u);
	}

}
