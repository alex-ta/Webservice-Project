package com.data.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

import com.data.Skill;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class Skill_Wrapper {
	
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The collectiv term of skills like this", required = true)
	private String collectiveterm;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The name of the skill", required = true)
	private String term;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The priority of an skill to make them sortable 0 = high", required = true)
	private int priority;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The urlid which identifies an existing skill object", required = true)
	private String uuid;
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The user that belongs to this skill", required = true)
	private String user;
	
	public Skill_Wrapper(){}
	
	public Skill_Wrapper(Skill s){
		this();
		if(s != null){
		this.collectiveterm = s.getCollectiveterm();
		this.term = s.getTerm();
		this.priority = s.getPriority();
		this.uuid = s.getUuid();
		this.user = s.getParentId();
		}
	}
	
	public Skill getSkill(Skill skill){
		if(this.getCollectiveterm() != null)
		skill.setCollectiveterm(this.getCollectiveterm());
		if(this.getTerm() != null)
		skill.setTerm(this.getTerm());
		skill.setPriority(this.getPriority());
		if(this.getUser() != null)
		skill.setParentId(this.getUser());
		return skill;
	}
	
	public String getCollectiveterm() {
		return collectiveterm;
	}
	public void setCollectiveterm(String collectiveterm) {
		this.collectiveterm = collectiveterm;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
		
}
