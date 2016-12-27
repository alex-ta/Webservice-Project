package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.HobbyDao;
import com.data.*;
import com.service.RestChildService;

@Controller
// /users/{id}/hobbies  -> return list<id>
// /hobbies/{id} -> get by id 
// 
@RequestMapping("/users/{uid}/hobbies")
public class HobbyService extends RestChildService<Hobby>{
	public HobbyService() {
		super(new HobbyDao());
	}
}
