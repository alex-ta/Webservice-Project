package dao;

import data.Skill;

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
