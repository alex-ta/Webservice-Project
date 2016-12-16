package dao;

import java.util.LinkedList;
import java.util.UUID;

import data.User;

public class UserDao extends Dao<User>{

	public static int baseData = 0;
	
	
	@Override
	Class<User> getDaoClass() {		
		return User.class;
	}

	@Override
	User setPrimaryKey(User o) {
		return o;
	}

	
	public void addData(){
		if(baseData < 3){
			User o = new User();
			o.setName("Alex");
			o.setSurname("Newman");
			o.setBirthdate("19.12.1993");
			o.setBirthplace("");
			o.setCity("city");
			o.setCountry("country");
			o.setGender("male");
			o.setHousenumber("12");
			o.setMail("asdasd@asdasd.de");
			o.setTitle("None");
			o.setNationality("Nation");
			o.setPhone("0102300020123");
			o.setStreet("sadasda");
			o.setId(UUID.randomUUID().toString());
			o.setImage("https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h556");
			this.save(o);
		}
	}
	
}
