package dao;

import data.Job;

public class JobDao extends Dao<Job>{

	@Override
	Class<Job> getDaoClass() {
		return Job.class;
	}

	@Override
	Job setPrimaryKey(Job o) {
		return o;
	}

}
