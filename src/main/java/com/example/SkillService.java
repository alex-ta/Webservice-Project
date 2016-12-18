package com.example;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.SkillDao;
import com.data.*;
import com.service.RestChildService;

@Controller
@RequestMapping("/users/{uid}/skills")
public class SkillService extends RestChildService<Skill>{
	public SkillService() {
		super(new SkillDao());
	}
}
