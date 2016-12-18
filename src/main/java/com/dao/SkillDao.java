package com.dao;

import com.data.Skill;

public class SkillDao extends Dao<Skill>{

	@Override
	Class<Skill> getDaoClass() {
		return Skill.class;
	}

	@Override
	Skill setPrimaryKey(Skill o) {
		return o;
	}

}
