package com.example;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.HobbyDao;
import com.data.Hobby;
import com.data.Roles;
import com.data.wrapper.Hobby_Wrapper;
import com.data.wrapper.Security_User_Wrapper;
import com.service.BasicRestService;

@Controller
@RequestMapping("/v1/hobbies")
public class HobbyService extends BasicRestService<Hobby_Wrapper, Hobby>{

	public static String baseUrl = "/v1/hobbies";
	
	@Autowired
	public HobbyService(HobbyDao d) {
		super(d);
	}

	@Override
	public Hobby_Wrapper getWrapper(Hobby o) {
		if(o == null){
			return null;
		}
		return new Hobby_Wrapper(o);
	}

	@Override
	public Hobby getObject(Hobby_Wrapper w) {
		if(w == null){
			return null;
		}
		return w.getHobby(new Hobby());
	}

	@Override
	public String getUrl(Hobby o) {
		o.setUuid(UUID.randomUUID().toString());
		return baseUrl+"/"+o.getUuid();
	}

	@Override
	public Hobby join(Hobby_Wrapper w, Hobby o) {
		return w.getHobby(o);
	}

	@Override
	public boolean isExisting(Hobby o) {
		Hobby s = dao.getByUuid(o.getUuid());
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
	public boolean hasUser(Hobby_Wrapper w) {
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		if(id != null && w.getUser().equals(id)){
			return true;
		} else {
			return false;
		}
	}

	
}
