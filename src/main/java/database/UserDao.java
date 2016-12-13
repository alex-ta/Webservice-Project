package database;

import data.User;

public class UserDao extends Dao<User>{

	@Override
	Class<User> getDaoClass() {
		return User.class;
	}

	@Override
	User setPrimaryKey(User o) {
		return o;
	}
	
}
