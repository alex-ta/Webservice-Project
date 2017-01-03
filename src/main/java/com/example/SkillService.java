package com.example;


import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.SkillDao;
import com.data.Roles;
import com.data.Skill;
import com.data.wrapper.Security_User_Wrapper;
import com.data.wrapper.Skill_Wrapper;
import com.service.BasicRestService;

@Controller
@RequestMapping("/v1/skills")
public class SkillService extends BasicRestService<Skill_Wrapper, Skill>{
	
	public static String baseUrl = "/v1/skills";
	
	@Autowired
	public SkillService(SkillDao d) {
		super(d);
	}

	@Override
	public Skill_Wrapper getWrapper(Skill o) {
		if(o == null){
			return null;
		}
		return new Skill_Wrapper(o);
	}

	@Override
	public Skill getObject(Skill_Wrapper w) {
		if(w == null){
			return null;
		}
		return w.getSkill(new Skill());
	}

	@Override
	public String getUrl(Skill o) {
		o.setUuid(UUID.randomUUID().toString());
		return baseUrl+"/"+o.getUuid();
	}

	@Override
	public Skill join(Skill_Wrapper w, Skill o) {
		return w.getSkill(o);
	}

	@Override
	public boolean isExisting(Skill o) {
		Skill s = dao.getByUuid(o.getUuid());
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
	public boolean hasUser(Skill_Wrapper w) {
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		if(id != null && w.getUser().equals(id)){
			return true;
		} else {
			return false;
		}
	}	
}
