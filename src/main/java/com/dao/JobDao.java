package com.dao;
import com.data.Job;

public class JobDao extends DaoChild<Job,String>{

	@Override
	Class<Job> getDaoClass() {
		return Job.class;
	}

	@Override
	Job setPrimaryKey(Job o) {
		return o;
	}

}
