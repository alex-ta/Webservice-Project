package com.dao;

import java.util.Arrays;
import java.util.LinkedList;

import com.data.Roles;
import com.data.User;

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
			o.setId("Alex");
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
			Roles [] r = new Roles[]{Roles.ROLE_USER, Roles.ROLE_ADMIN};
			o.setRoles(new LinkedList<Roles>(Arrays.asList(r)));
			o.setPassword("123");
			o.setImage("https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h556");
			this.save(o);
		}
	}
	
}
