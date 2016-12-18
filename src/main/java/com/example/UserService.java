package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserDao;
import com.data.*;
import com.service.RestService;

@Controller
@RequestMapping("/users")
public class UserService extends RestService<User>{
	public UserService() {
		super(new UserDao());
	}
}
