package com.dao;
import com.data.Skill;

public class SkillDao extends DaoChild<Skill,String>{

	@Override
	Class<Skill> getDaoClass() {
		return Skill.class;
	}

	@Override
	Skill setPrimaryKey(Skill o) {
		return o;
	}

}
