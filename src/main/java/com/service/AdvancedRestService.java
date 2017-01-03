package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.Dao;
import com.service.exceptions.E;
import com.service.exceptions.E403;
import com.service.exceptions.E404;
import com.service.exceptions.E500;


@Controller
@RequestMapping("/v1/rest/")
public abstract class AdvancedRestService <W, O>  extends BasicRestService<W, O>{
	
	@Autowired
	public AdvancedRestService(Dao<O> dao) {
		super(dao);
	}
	
	public abstract List<String> getList(O o, String attName);
	public abstract boolean hasUser(String w);
	
		  
	public ResponseEntity<List<String>> getLinks (String uuid, String attName) { 
		  try {
			  if(hasRole(allowedRole) || hasUser(uuid)){
				  O o = dao.getByUuid(uuid);
				  if(o != null){
					  return new ResponseEntity<List<String>>(getList(o, attName), HttpStatus.OK);
				  } else {
					  throw new E404("Not entity found to uuid "+uuid);
				  }
			  } else {
				  throw new E403("Not allow on to see all resources");
			  }
		  } catch (E e){
			  throw e;
		  } catch (Exception e){
			  e.printStackTrace();
			  throw new E500("Ups something went wrong");
		  }
	}
}
