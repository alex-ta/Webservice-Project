package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserDao;
import com.data.Education;
import com.data.Hobby;
import com.data.Job;
import com.data.Roles;
import com.data.Skill;
import com.data.User;
import com.data.wrapper.Security_User_Wrapper;
import com.data.wrapper.User_Wrapper;
import com.service.AdvancedRestService;

@Controller
@RequestMapping("/v1/users")
public class UserService extends AdvancedRestService<User_Wrapper, User>{
	
	public static String baseUrl = "/v1/users";
	
	@Autowired
	public UserService(UserDao d) {
		super(d);
	}

	@Override
	public List<String> getList(User u, String attName) {
		List<String> list = new LinkedList<String>();
		switch(attName){
			case "hobbies": 
				for(Hobby h : u.getHobbies()){
					list.add(baseUrl+h.getUuid()+"/hobbies/"+h.getUuid());
				}
				break;
			case "educations": 
				for(Education e : u.getEducations()){
					list.add(baseUrl+e.getUuid()+"/educations/"+e.getUuid());
				}
				break;
			case "jobs": 
				for(Job j : u.getJobs()){
					list.add(baseUrl+j.getUuid()+"/jobs/"+j.getUuid());
				}
				break;
			case "skills": 
				for(Skill s : u.getSkills()){
					list.add(baseUrl+s.getUuid()+"/skills/"+s.getUuid());
				}
				break;
		}
		return list;
	}
	
	@RequestMapping(value = "/{uuid}/hobbies", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getHobbies(@PathVariable("uuid") String uuid) { 
		return super.getLinks(uuid, "hobbies");
	}
	
	@RequestMapping(value = "/{uuid}/jobs", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getJobs(@PathVariable("uuid") String uuid) { 
		return super.getLinks(uuid, "jobs");
	}
	
	@RequestMapping(value = "/{uuid}/educations", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getEducations(@PathVariable("uuid") String uuid) { 
		return super.getLinks(uuid, "educations");
	}
	
	@RequestMapping(value = "/{uuid}/skills", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSkills(@PathVariable("uuid") String uuid) { 
		return super.getLinks(uuid, "skills");
	}
	
	@Override
	public String getUrl(User o) {
		o.setUuid(UUID.randomUUID().toString());
		return baseUrl+"/"+o.getUuid();
	}

	@Override
	public User_Wrapper getWrapper(User o) {
		if(o == null){
			return null;
		}
		return new User_Wrapper(o);
	}


	@Override
	public User getObject(User_Wrapper w) {
		return w.join(new User());
	}


	@Override
	public User join(User_Wrapper w, User o) {
		return w.join(o);
	}

	@Override
	public boolean isExisting(User o) {
		User o2 = dao.getById(o.getId());
		if(o2 != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRole(Roles r) {
		Security_User_Wrapper u =((Security_User_Wrapper) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return u.getRoles().contains(r);
	}

	@Override
	public boolean hasUser(User_Wrapper w) {
		if(w.getUuid() == null){
			Security_User_Wrapper u =((Security_User_Wrapper) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			w.setUuid(u.getUuid());
		}
		return hasUser(w.getUuid());
	}

	@Override
	public boolean hasUser(String w) {
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		User o = dao.getById(id);
		if(o != null && w.equals(o.getUuid())){
			return true;
		} else {
			return false;
		}
	}

}
