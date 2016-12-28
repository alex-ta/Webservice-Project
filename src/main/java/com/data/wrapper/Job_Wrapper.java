package com.data.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

import com.data.Job;

@XmlRootElement
public class Job_Wrapper {
	
	private String start;
	private String end;
	private String company;
	private String name;
	private String uuid;
	
	public Job_Wrapper(){}
	
	public Job_Wrapper(Job j){
		this();
		this.start = j.getStart();
		this.end = j.getEnd();
		this.company = j.getCompany();
		this.name = j.getJob();
		this.uuid = j.getUuid();
	}
	
	public Job getJob(){
		Job job = new Job();
		job.setStart(this.getStart());
		job.setEnd(this.getEnd());
		job.setCompany(this.getCompany());
		job.setJob(this.getName());
		job.setUuid(this.getUuid());
		return job;
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
