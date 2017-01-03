package com.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dao.Dao;
import com.data.Roles;
import com.service.exceptions.E403;
import com.service.exceptions.E404;
import com.service.exceptions.E409;
import com.service.exceptions.E500;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * W Wrapper class (xmlmapper)
 * O Object class (data)
 * */

@Controller
@RequestMapping("/v1/rest")
public abstract class BasicRestService <W,O> {
	  
	  protected Dao<O> dao;
	  protected Roles allowedRole = Roles.ROLE_ADMIN;
	  
	  public BasicRestService(Dao<O> dao){
		  this.dao = dao;  
	  }
	  
	  public abstract W getWrapper(O o);
	  public abstract O getObject(W w);
	  public abstract O join(W w, O o);
	  public abstract String getUrl(O o);
	  public abstract boolean isExisting(O o);
	  public abstract boolean hasRole(Roles r);
	  public abstract boolean hasUser(W w);
	  
	  private List<W> getWrapperList(List<O> list){
		  List<W> listW = new LinkedList<W>();
		  for(O o : list){
			  listW.add(getWrapper(o));
		  }
		  return listW;
	  }
	  
	  // define the swagger api methods
	  @ApiResponses({
	  @ApiResponse(code = 403, message = "FORBIDDEN"),
	  @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
	  })
	  
	  @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
	  @ResponseBody
	  public ResponseEntity<List<W>> getAll() {
		  try {
			  if(hasRole(allowedRole)){
				  return new ResponseEntity<List<W>>(getWrapperList(dao.getAll()), HttpStatus.OK);
			  } else {
				  throw new E403("Not allow on to see all resources");
			  }
		  } catch (E403 e){
			  throw e;
		  } catch (Exception e){
			  e.printStackTrace();
			  throw new E500("Ups something went wrong");
		  }
	  }

	  // define the swagger api methods
	  @ApiResponses({
	  @ApiResponse(code = 403, message = "FORBIDDEN"),
	  @ApiResponse(code = 404, message = "NOT FOUND"),
	  @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
	  })
	  
	  @RequestMapping(value = "/{uuid}", method = {RequestMethod.GET, RequestMethod.HEAD})
	  @ResponseBody
	  public ResponseEntity<W> get(@ApiParam(name = "uuid", value = "excpected resource uuid", required = true) @PathVariable("uuid") String uuid) { 
		  try {
			  W w = getWrapper(dao.getByUuid(uuid));
			  if(hasRole(allowedRole) || hasUser(w)){
				  if(w != null){
					  return new ResponseEntity<W>(w, HttpStatus.OK);
				  } else {
					  throw new E404("No Object found to Uuid "+uuid);
				  }
			  } else {
				  throw new E403("Not allow on "+uuid);
			  }
		  } catch (E404 e){
			  throw e;
		  } catch (E403 e){
			  throw e;
		  } catch (Exception e){
			  e.printStackTrace();
			  throw new E500("Ups something went wrong");
		  }		  
	  }

	  // define the swagger api methods
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  @ApiResponses({
	  @ApiResponse(code = 403, message = "FORBIDDEN"),
	  @ApiResponse(code = 404, message = "NOT FOUND"),
	  @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
	  })
	  
	  @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
	  @ResponseBody	  
	  public ResponseEntity<Void> delete(@ApiParam(name = "uuid", value = "excpected resource uuid", required = true) @PathVariable("uuid") String uuid) {
		  try {
			  O o = dao.getByUuid(uuid);
			  if(hasRole(allowedRole) || hasUser(getWrapper(o))){
				  if(o != null){
					  dao.delete(o);
					  return new ResponseEntity<Void>(HttpStatus.OK);
				  } else {
					  throw new E404("Object not found");
				  }
			  } else {
				  throw new E403("Not allow on "+uuid);
			  }
		  } catch (E403 e){
			  throw e;
		  } catch (E404 e){
			  throw e;
		  } catch (Exception e){
			  e.printStackTrace();
			  throw new E500("Ups something went wrong");
		  }
	  }
	  
	  // define the swagger api methods
	  @ResponseStatus(HttpStatus.CREATED)
	  @ApiResponses({
	  @ApiResponse(code = 403, message = "FORBIDDEN"),
	  @ApiResponse(code = 409, message = "CONFLICT"),
	  @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
	  })
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	  @ResponseBody
	  public ResponseEntity<String> post(@ApiParam(name = "w", value = "Datamodel containing the data of a new Object", required = true) @RequestBody W w) { 
		  try {
			  if(hasRole(allowedRole) || hasUser(w)) {
				  O o = getObject(w);
				  if(isExisting(o)){
					  throw new E409("The ressource already exists");
				  } else {
					  String url = this.getUrl(o);
					  dao.save(o);
					  return new ResponseEntity<String>(url, HttpStatus.CREATED);
				  }
			  } else {
				  throw new E403("Not allow on to post for user");
			  }
		  } catch (E409 e){
			  throw e;
		  } catch (E403 e){
			  throw e;
		  } catch (Exception e){
			  e.printStackTrace();
			  throw new E500("Ups something went wrong");
		  }
	  }
	  
	  // define the swagger api methods
	  @ApiResponses({
	  @ApiResponse(code = 403, message = "FORBIDDEN"),
	  @ApiResponse(code = 404, message = "NOT FOUND"),
	  @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
	  })
	  
	  @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
	  @ResponseBody
	  public ResponseEntity<W> put(@ApiParam(name = "uuid", value = "excpected resource uuid", required = true)@PathVariable("uuid") String uuid, @ApiParam(name = "w", value = "Datamodel containing the new data", required = true) @RequestBody W w) { 
		  System.out.println(uuid);
		  try {
			  if(hasRole(allowedRole) || hasUser(w)){
				  O o = dao.getByUuid(uuid);
				  System.out.println(o);
				  if(o != null){
  					  O obj = join(w,o);
					  dao.save(obj);
					  return new ResponseEntity<W>(getWrapper(obj), HttpStatus.OK);
				  } else {
					  System.out.println("404");
	  				  throw new E404("No Object found to Uuid "+uuid);			 
				  }
			  } else {
				  throw new E403("Not allow on "+uuid);
			  }
		  } catch (E404 e){
			  throw e;
		  } catch (E403 e){
			  throw e;
		  } catch (Exception e){
			  System.out.println(e.getMessage());
			  e.printStackTrace();
			  throw new E500("Ups something went wrong");
		  }		  
	  }
}
