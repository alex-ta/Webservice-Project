package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.EducationDao;
import com.data.*;
import com.service.RestChildService;

@Controller
@RequestMapping("/users/{uid}/educations")
public class EductionService extends RestChildService<Education>{
	public EductionService() {
		super(new EducationDao());
	}
}
