package com.dao;

import com.data.Education;

public class EducationDao extends DaoChild<Education,String>{

	@Override
	Class<Education> getDaoClass() {
		return Education.class;
	}

	@Override
	Education setPrimaryKey(Education o) {
		return o;
	}

}
