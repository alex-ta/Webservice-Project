package com.data;

// jndi Datasource
// tomcat realm


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "hobby")
@Proxy(lazy = false)
public class Hobby {
	
	Hobby(){
		this.uuid = UUID.randomUUID().toString();
	}
	private String name;
	private int id;
	private String uuid;
	private int parentId;
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Column(name="parent_id")
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parendId) {
		this.parentId = parendId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
