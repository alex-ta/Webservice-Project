package com.data.wrapper;

// jndi Datasource
// tomcat realm

import javax.xml.bind.annotation.XmlRootElement;

import com.data.Hobby;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class Hobby_Wrapper {
	
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The name of the Hobby", required = true)
	private String name;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The user that belongs to this hobby", required = true)
	private String user;
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The urlid which identifies an existing user object", required = true)
	private String uuid;

	public Hobby_Wrapper(){}
	
	public Hobby_Wrapper(Hobby h){
		this();
		if(h != null){
		this.name = h.getName();
		this.user = h.getParentId();
		this.uuid = h.getUuid();
		}
	}
	
	public Hobby getHobby(Hobby hobby){
		if(this.getName() != null)
		hobby.setName(this.getName());
		if(this.getUser() != null);
		hobby.setParentId(user);
		return hobby;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
