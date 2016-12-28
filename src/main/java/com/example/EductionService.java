package com.example;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.EducationDao;
import com.data.*;
import com.service.RestService;

@Controller
@RequestMapping("/users/{uid}/educations")
public class EductionService extends RestService<Education>{
	// benutzer check 
	// user check in den filtern
	@Autowired
	public EductionService(EducationDao d) {
		super(d);
	}

	@Override
	public Education setId(Education o) {
		return null;
	}

	@Override
	public boolean isPriviledged(HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}
}
