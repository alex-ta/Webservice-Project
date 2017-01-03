package com.example;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.EducationDao;
import com.data.Education;
import com.data.Roles;
import com.data.wrapper.Education_Wrapper;
import com.data.wrapper.Security_User_Wrapper;
import com.service.BasicRestService;

@Controller
@RequestMapping("/v1/educations")
public class EductionService extends BasicRestService<Education_Wrapper, Education>{
	
	public static String baseUrl = "/v1/educations";
	
	@Autowired
	public EductionService(EducationDao d) {
		super(d);
	}

	@Override
	public Education_Wrapper getWrapper(Education o) {
		if(o == null){
			return null;
		}
		return new Education_Wrapper(o);
	}

	@Override
	public Education getObject(Education_Wrapper w) {
		if(w == null){
			return null;
		}
		return w.getEducation(new Education());
	}

	@Override
	public String getUrl(Education o) {
		o.setUuid(UUID.randomUUID().toString());
		return baseUrl+"/"+o.getUuid();
	}

	@Override
	public Education join(Education_Wrapper w, Education o) {
		return w.getEducation(o);
	}

	@Override
	public boolean isExisting(Education o) {
		Education s = dao.getByUuid(o.getUuid());
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
	public boolean hasUser(Education_Wrapper w) {
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		if(id != null && w.getUser().equals(id)){
			return true;
		} else {
			return false;
		}
	}
}
