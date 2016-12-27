package com.data.wrapper;

// jndi Datasource
// tomcat realm

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hobby_Wrapper {
	
	private String name;
	private String uuid;
	
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
