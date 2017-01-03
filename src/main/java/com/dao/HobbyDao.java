package com.dao;
import com.data.Hobby;

public class HobbyDao extends DaoChild<Hobby,String>{

	@Override
	Class<Hobby> getDaoClass() {
		return Hobby.class;
	}

	@Override
	Hobby setPrimaryKey(Hobby o) {
		return o;
	}

}
