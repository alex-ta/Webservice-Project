package com.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.Roles;

@Service("userDetailsService")
public class UserDetail implements UserDetailsService {
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username)
		throws UsernameNotFoundException {
		System.out.println("Username: "+username);
		com.security.User user = new UserDao().findByUserName(username);
		if(user == null){
			return null;
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
		return new User(user.getId(), user.getPassword(),user.isEnabled(), true, true, true, authorities);
	}


	public List<GrantedAuthority> buildUserAuthority(Integer userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for(Roles r :Roles.values()){
			System.out.println(r.name()+" "+r.ordinal());
			//setAuths.add(new SimpleGrantedAuthority(r.name()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
}