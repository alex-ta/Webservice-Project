package com.data.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Skill_Wrapper {
	
	private String collectiveterm;
	private String term;
	private int priority;
	private int ability;
	private String uuid;
	
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
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
		
}
