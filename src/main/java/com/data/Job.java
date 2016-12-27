package com.data;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "job")
@Proxy(lazy = false)
public class Job {
	
	Job(){
		this.uuid = UUID.randomUUID().toString();
	}
	private String start;
	private String end;
	private String company;
	private String job;
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
}
