package com.security;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends Dao<User>{

	public User findByUserName(String username) {
		return this.get(username);
	}

	@Override
	Class<User> getDaoClass() {
		return com.security.User.class;
	}

	@Override
	User setPrimaryKey(User o) {
		return o;
	}

}