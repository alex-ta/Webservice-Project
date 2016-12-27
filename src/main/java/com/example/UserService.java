package com.example;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserDao;
import com.data.User;
import com.service.RestService;

@Controller
@RequestMapping("/users")
public class UserService extends RestService<User>{
	public UserService() {
		super(new UserDao());
	}

	@Override
	public User setId(User o) {
		o.setUuid(UUID.randomUUID().toString());
		return o;
	}

	@Override
	public boolean isPriviledged(HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}
}
