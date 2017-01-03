package com.data.wrapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.data.Job;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class Job_Wrapper {
	
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The start date of an job", required = true)
	private String start;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The end date of an job", required = true)
	private String end;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The company provided this job", required = true)
	private String company;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The name of the job", required = true)
	private String name;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The user that belongs to this job", required = true)
    @NotNull
    @Size(max=200)
	private String user;
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The urlid which identifies an existing user object", required = true)
	private String uuid;
	
	public Job_Wrapper(){}
	
	public Job_Wrapper(Job j){
		this();
		if(j != null){
		this.start = j.getStart();
		this.end = j.getEnd();
		this.company = j.getCompany();
		this.name = j.getJob();
		this.user = j.getParentId();
		this.uuid = j.getUuid();
		}
	}


	public Job getJob(Job job){
		if(this.getStart() != null)
		job.setStart(this.getStart());
		if(this.getEnd() != null)
		job.setEnd(this.getEnd());
		if(this.getCompany() != null)
		job.setCompany(this.getCompany());
		if(this.getName() != null)
		job.setJob(this.getName());
		if(this.getUser() != null)
		job.setParentId(this.getUser());
		return job;
	}
		
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
