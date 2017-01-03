package com.example;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.JobDao;
import com.data.Job;
import com.data.Roles;
import com.data.wrapper.Job_Wrapper;
import com.data.wrapper.Security_User_Wrapper;
import com.service.BasicRestService;

@Controller
@RequestMapping("/v1/jobs")
public class JobService extends BasicRestService<Job_Wrapper, Job>{

	public static String baseUrl = "/v1/jobs";

	@Autowired
	public JobService(JobDao d) {
		super(d);
	}

	@Override
	public Job_Wrapper getWrapper(Job o) {
		if(o == null){
			return null;
		}
		return new Job_Wrapper(o);
	}

	@Override
	public Job getObject(Job_Wrapper w) {
		if(w == null){
			return null;
		}
		return w.getJob(new Job());
	}

	@Override
	public String getUrl(Job o) {
		o.setUuid(UUID.randomUUID().toString());
		return baseUrl+"/"+o.getUuid();
	}

	@Override
	public Job join(Job_Wrapper w, Job o) {
		return w.getJob(o);
	}

	@Override
	public boolean isExisting(Job o) {
		Job s = dao.getByUuid(o.getUuid());
		if(s != null){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasRole(Roles r) {
		Security_User_Wrapper u =((Security_User_Wrapper) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return u.getRoles().contains(r);
	}

	@Override
	public boolean hasUser(Job_Wrapper w) {
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		if(id != null && w.getUser().equals(id)){
			return true;
		} else {
			return false;
		}
	}
}
