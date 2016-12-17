package dao;
import data.Hobby;

public class HobbyDao extends Dao<Hobby>{

	@Override
	Class<Hobby> getDaoClass() {
		return Hobby.class;
	}

	@Override
	Hobby setPrimaryKey(Hobby o) {
		return o;
	}

}
