package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.Dao;


@Controller
@RequestMapping("/rest")
public abstract class RestService <O> {
		
	  protected Dao<O> dao;

	  public RestService(Dao<O> dao){
		  this.dao = dao;  
	  }
	  
	  public abstract O setId(O o);
	  public abstract boolean isPriviledged(HttpSession session);
	  
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public ResponseEntity<List<O>> getAll(HttpSession session) {
		  if(isPriviledged(session)){
			  return new ResponseEntity<List<O>>(dao.getAll(), HttpStatus.OK);
		  } else {
			  return new ResponseEntity<List<O>>(HttpStatus.FORBIDDEN);
		  }
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public ResponseEntity<O> get(HttpSession session, @PathVariable("id") String id) { 
		  if(isPriviledged(session)){
			  return new ResponseEntity<O>(dao.get(id), HttpStatus.OK);
		  } else {
			  return new ResponseEntity<O>(HttpStatus.FORBIDDEN);
		  }
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public ResponseEntity<Void> delete(HttpSession session, @PathVariable("id") String id) {
		  if(isPriviledged(session)){
			  dao.delete(id);
			  return new ResponseEntity<Void>(HttpStatus.OK);
		  } else {
			  return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		  }
	  }

	  @RequestMapping(value = "/", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	  public ResponseEntity<String> post(HttpSession session, @RequestBody O o) { 
		  if(isPriviledged(session)){
			  dao.save(this.setId(o));
			  // muss neue url zurück geben
			  return new ResponseEntity<String>("URL", HttpStatus.CREATED);
		  } else {
			  return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		  }
	  }

	  @RequestMapping(value = "/", method = RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	  public ResponseEntity<String> postForm(HttpSession session, O o) { 
		  if(isPriviledged(session)){
			  dao.save(this.setId(o));
			  // created 201
			  // nicht überschreiben
			  // neue id setzen
			  return new ResponseEntity<String>("URL", HttpStatus.CREATED);
		  } else {
			  return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		  }
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public ResponseEntity<O> put(HttpSession session, @PathVariable("id") String id, @RequestBody O o) { 
		  if(isPriviledged(session)){
			  // ressource nicht vorhanden id 404
			  // interner server error 500
			  // komplettes datenobject
			  return new ResponseEntity<O>(o, HttpStatus.NOT_IMPLEMENTED);
		  } else {
			  return new ResponseEntity<O>(HttpStatus.FORBIDDEN);
		  }
	  }

	  @RequestMapping(value = "/", method = RequestMethod.HEAD)
	  public ResponseEntity<Void> head() { 
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }
}
