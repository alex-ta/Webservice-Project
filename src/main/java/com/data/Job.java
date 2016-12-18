package com.data;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

@XmlRootElement
@Entity
@Table(name = "job")
@Proxy(lazy = false)
public class Job {
	
	public static String URL = "/jobs";
	
	public Job(String uid){
		this();
		this.parentId = uid;
	}
	
	Job(){
		this.id = UUID.randomUUID().toString();
	}
	
	private String start;
	private String end;
	private String company;
	private String job;
	private String id;
	private String parentId;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parendId) {
		this.parentId = parendId;
	}
	
}
