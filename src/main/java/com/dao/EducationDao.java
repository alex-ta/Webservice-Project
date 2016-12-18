package com.dao;

import com.data.Education;

public class EducationDao extends Dao<Education>{

	@Override
	Class<Education> getDaoClass() {
		return Education.class;
	}

	@Override
	Education setPrimaryKey(Education o) {
		return o;
	}

}
