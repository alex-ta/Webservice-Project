package com.data.wrapper;

// jndi Datasource
// tomcat realm

import javax.xml.bind.annotation.XmlRootElement;

import com.data.Hobby;

@XmlRootElement
public class Hobby_Wrapper {
	
	private String name;
	private String uuid;
	
	public Hobby_Wrapper(){}
	
	public Hobby_Wrapper(Hobby h){
		this();
		this.name = h.getName();
		this.uuid = h.getUuid();
	}
	
	public Hobby getHobby(){
		Hobby hobby = new Hobby();
		hobby.setName(this.getName());
		hobby.setUuid(this.getUuid());
		return hobby;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
