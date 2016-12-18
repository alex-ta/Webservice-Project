package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.JobDao;
import com.data.*;
import com.service.RestChildService;

@Controller
@RequestMapping("/users/{uid}/jobs")
public class JobService extends RestChildService<Job>{
	public JobService() {
		super(new JobDao());
	}
}
