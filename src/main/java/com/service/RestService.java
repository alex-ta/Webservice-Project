package com.service;

import java.util.List;

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
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public ResponseEntity<List<O>> getAll() {
		  return new ResponseEntity<List<O>>(dao.getAll(), HttpStatus.OK);
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public ResponseEntity<O> get(@PathVariable("id") String id) { 
		  return new ResponseEntity<O>(dao.get(id), HttpStatus.OK);
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		  dao.delete(id);
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }

	  @RequestMapping(value = "/", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	  public ResponseEntity<Void> post(@RequestBody O o) { 
		  dao.save(o);
		  return new ResponseEntity<Void>( HttpStatus.OK);
	  }

	  @RequestMapping(value = "/", method = RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	  public ResponseEntity<Void> postForm(O o) { 
		  dao.save(o);
		  return new ResponseEntity<Void>( HttpStatus.OK);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody O o) { 
		  return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	  }

	  @RequestMapping(value = "/", method = RequestMethod.HEAD)
	  public ResponseEntity<O> head() { 
		  return null;
	  }
}
